import { SERVER_URL } from "../../constants/index.js"
const confirmBanner = document.querySelector("#confirmBanner")
const tableBody = document.querySelector("#tableBody")
let candidates = [];
let selectedCandidate = {};

window.addEventListener("load", () => {
    fetchAndRenderCandidates()
})



// requestForm.addEventListener("submit", (e) => {
//     e.preventDefault()
//     const { email } = JSON.parse(sessionStorage.getItem("user"));
//     const requestData = {
//         method: ADD,
//         sender: email,
//         srcHost: SRC_HOST,
//         recipient: requestForm.femail.value,
//         rcpHost: requestForm.fhost.value,
//         version: 1
//     }
//     fetch(`${SERVER_URL}/api/response`, {
//         method: 'POST',
//         headers: {
//             'Content-Type': 'application/json',
//         },
//         body: JSON.stringify(requestData),
//     })
//         .then(response => response.json()
//         )
//         .then(data => {
//             console.log(data)
//         })
//         .catch(error => {
//             console.log(error)
//         });
// })

const fetchAndRenderCandidates = async () => {
    try {
        const response = await fetch(`${SERVER_URL}/api/candidates`);
        const data = await response.json();
        candidates = data
        console.log(data)
        generateTableBody(tableBody, candidates);
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