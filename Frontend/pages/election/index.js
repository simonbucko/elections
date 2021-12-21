import { SERVER_URL } from "../../constants/index.js"
const tableBody = document.querySelector("#tableBody")
const confirmButton = document.querySelector("#confirmButton")
let candidates = [];
let selectedCandidate = {};

window.addEventListener("load", () => {
    fetchAndRenderCandidates()
})


confirmButton.addEventListener("click", (e) => {
    const cpr = JSON.parse(sessionStorage.getItem("cpr"));
    const requestData = {
        cpr,
        candidateId: selectedCandidate.id
    }
    console.log(requestData);
    fetch(`${SERVER_URL}/api/votes`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(requestData),
    })
        .then(response => response.json()
        )
        .then(data => {
            console.log(data)
            sessionStorage.removeItem("cpr")
            window.location.href = "/pages/confirmation"
        })
        .catch(error => {
            window.location.href = "/pages/confirmation"
        });
})

const fetchAndRenderCandidates = async () => {
    try {
        const response = await fetch(`${SERVER_URL}/api/candidates`);
        const data = await response.json();
        candidates = data
        generateTableBody(tableBody, candidates);
        addListenerForRows();
    } catch (error) {
        console.log(error)
        return []
    }

}

const generateTableBody = (parentElement, candidates) => {
    let HTML = ``;
    candidates.forEach((candidate, i) => {
        HTML += `
        <tr data-candidateindex=${i}>
            <th data-candidateindex=${i} scope="row">${i + 1}</th>
            <th data-candidateindex=${i}>${candidate.name}</th>
            <th data-candidateindex=${i}>${candidate.party.name}</th>
        </tr>
        `
    });
    parentElement.innerHTML = HTML;
}

const addListenerForRows = () => {
    const rows = Array.from(document.querySelectorAll("#tableBody tr"));
    rows.forEach(row => {
        row.addEventListener("click", (e) => {
            const candidateIndex = e.target.getAttribute('data-candidateindex');
            selectedCandidate = candidates[candidateIndex];
            showConfirmBanner()
        })
    })
}

const showConfirmBanner = () => {
    const confirmBanner = document.querySelector("#confirmBanner")
    confirmBanner.style.display = "flex"
    document.querySelector("#candidateName").innerText = `Are you sure you want to vote for ${selectedCandidate.name}?`;
}