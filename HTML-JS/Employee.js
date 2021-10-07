const url = "http://localhost:8090/";

let roleId = sessionStorage.getItem("roleId");
let userId = sessionStorage.getItem("userId");

console.log(roleId);
console.log(userId);

document.getElementById("employeeBody").addEventListener("load", getReimbursement());
document.getElementById("addReimbursementButton").addEventListener("click", addReimburseFunc);


async function getReimbursement() {

    let user = {
        reimb_id:0,
        status_id:0,
        user_id:userId
    }

    let response = await fetch(url + "reimbursements/userId", 
    {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(response);

    if(response.status === 200){

        let data = await response.json();

        console.log(data);

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
            if(reimbursement.reimb_resolved){
                cell3.innerHTML = reimbursement.reimb_resolved;
            } else {
                cell3.innerHTML = "Not Resolved";
            }
            row.appendChild(cell3);

            //description
            let cell4 = document.createElement("td");
            cell4.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell4);

            //status
            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.reimb_status_id.status;
            row.appendChild(cell5);

            //type
            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.reimb_type_id.type;
            row.appendChild(cell6);

            document.getElementById("reimbursementBody").appendChild(row);
        }

    }

 }

  async function addReimburseFunc() {

     let amount = document.getElementById("amount").value;
     let description = document.getElementById("description").value;
     let type = document.getElementById("type").value;

     let typeId;

     if(type === "LODGING"){
         typeId = 1;
     } else if (type === "TRAVEL"){
         typeId = 2;
     } else if (type === "FOOD"){
         typeId = 3;
     } else {
         typeId = 4;
     }

     let reimburse = {
         reimb_amount:amount,
         reimb_description:description,
         reimb_author:{
             users_id:userId
         },
         reimb_status_id:{
             status_id:1,
             status: "PENDING"
         },
         reimb_type_id:{
             type_id:typeId,
             status:type
         }
     }

     console.log(reimburse);

     let response = await fetch(url + "reimbursements/add", {
         method:"POST",
         body: JSON.stringify(reimburse),
         credentials: "include"
     });

     console.log(response.status);

     if(response.status === 200){
         console.log(response);
         location.reload();
     } else {
         console.log("Add failed");
     }

  }

  