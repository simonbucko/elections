import { SERVER_URL } from "../../constants/index.js"
const tableBody = document.querySelector("#tableBody")


window.addEventListener("load", () => {
    fetchAndRenderVotes()
})



const fetchAndRenderVotes = async () => {
    try {
        const response = await fetch(`${SERVER_URL}/api/votes`);
        const data = await response.json();
        console.log(data)
        let parties = [
            {
                name: "Socialdemokratiet",
                count: 0
            },
            {
                name: "Konservative Folkeparti",
                count: 0
            },
            {
                name: "Socialistisk Folkeparti",
                count: 0
            },
            {
                name: "Danske Folkeparti",
                count: 0
            },
        ]
        data.forEach(vote => {
            switch (vote.candidate.party.name) {
                case "Socialdemokratiet": {
                    parties[0].count++;
                    break;
                }
                case "Konservative Folkeparti": {
                    parties[1].count++;
                    break;
                }
                case "Socialistisk Folkeparti": {
                    parties[2].count++;
                    break;
                }
                case "Danske Folkeparti": {
                    parties[3].count++;
                    break;
                }
                default: break
            }
        })
        generateTableBody(tableBody, parties);
    } catch (error) {
        console.log(error)
        return []
    }

}

const generateTableBody = (parentElement, parties) => {
    let HTML = ``;
    parties.forEach((party, i) => {
        HTML += `
        <tr >
            <th scope="row">${i + 1}</th>
            <th>${party.name}</th>
            <th>${party.count}</th>
        </tr>
        `
    });
    parentElement.innerHTML = HTML;
}
