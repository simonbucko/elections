import { SERVER_URL } from "../../constants/index.js"
const tableBody = document.querySelector('#tableBody');
const createForm = document.querySelector('#add_child_form');
const updateForm = document.querySelector('#update_child_form');
const buttonClose = document.querySelectorAll('.btn-close');
let candidates = [];

//handling submiting post the form
createForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const data = {
        name: createForm.name.value,
        party: createForm.party.value,
    }
    fetch(`${SERVER_URL}/api/candidates`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            getAllCandidates()
            createForm.reset();
            buttonClose[0].click();
        })
        .catch(error => console.log(error));
})

updateForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const data = {
        id: updateForm.id.value,
        name: updateForm.name.value,
        age: updateForm.age.value,
        address: updateForm.address.value,
        phoneNumber: updateForm.phoneNumber.value,
        email: updateForm.email.value
    }
    fetch(SERVER_URL, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            generateHtml(data);
            candidates = data;
            updateForm.reset();
            buttonClose[1].click();
        })
        .catch(error => console.log(error));
})

//deleting row from table
tableBody.addEventListener('click', (e) => {
    //deleting
    if (e.target.classList.contains('fa-trash')) {
        const id = e.target.getAttribute('data-id');
        document.querySelector(`tr[data-id="${id}"]`).remove();
        fetch(`${SERVER_URL}/${id}`, {
            method: 'DELETE'
        })
            .then(response => response.json())
            .then(data => {
                generateHtml(data);
            })
            .catch(error => console.log(error));
    }
    //editing
    if (e.target.classList.contains('fa-user-edit')) {
        const candidate_id = e.target.getAttribute('data-id');
        const candidate = candidates[candidate_id]
        updateForm.name.value = candidate.name;
        updateForm.party.value = candidate.party.id;
        updateForm.id.value = candidate.id;
    }
})

const getAllCandidates = () => {
    fetch(`${SERVER_URL}/api/candidates`)
        .then(response => response.json())
        .then(data => {
            generateHtml(data);
            console.log(data)
            candidates = data;
        })
        .catch(error => console.log(error));
}

getAllCandidates();

const generateHtml = (data) => {
    let HTML = ``;
    data.forEach((candidate, i) => {
        HTML += `
        <tr data-id="${candidate.id}">
            <th scope="row">${i + 1}</th>
            <td>${candidate.name}</td>
            <td>${candidate.party.name}</td>
            <td><i class="fas fa-user-edit" data-id="${i}" data-bs-toggle="modal" data-bs-target="#editModal"></i><i class="fas fa-trash" data-id="${candidate.id}"></i></td>
        </tr>
        `
    });
    HTML += `
        <tr class="add_child">
            <td colspan="7"><i class="fas fa-plus-circle" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-toggle="tooltip" data-bs-placement="top" title="Add new record"></i></td>
        </tr>
    `
    tableBody.innerHTML = HTML;
}