const url = "http://localhost:8090/";

let roleId = sessionStorage.getItem("roleId");
let userId = sessionStorage.getItem("userId");

console.log(roleId);
console.log(userId);

document.getElementById("reimbursementTable").addEventListener("load", getReimbursement);
document.getElementById("addReimbursement").addEventListener("click", addReimburseFunc);

async function getReimbursement() {

    let response = await fetch(url + "reimbursements/userId", 
    {
        method: "POST",
        body: JSON.stringify(userId),
        credentials: "include"
    });

    console.log(response);

    if(response.status === 200){

        let data = await response.json();

        for(let reimbursement of data){

            let row = document.createElement("tr");
            
            //amount
            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.reimb_amount;
            row.appendChild(cell);

            //submitted
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimb_submitted;
            row.appendChild(cell2);

            //resolved
            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimb_resolved;
            row.appendChild(cell3);

            //description
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell4);

            //status
            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.reimb_status_id;
            row.appendChild(cell5);

            //type
            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.reimb_type_id;
            row.appendChild(cell6);
        }

    }

 }

 async function addReimburseFunc() {

 }