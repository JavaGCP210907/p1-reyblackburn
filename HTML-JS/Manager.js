const url = "http://localhost:8090/";

let roleId = sessionStorage.getItem("roleId");
let userId = sessionStorage.getItem("userId");

document.getElementById("managerBody").addEventListener("load",getReimburseFunc());
document.getElementById("statusFilter").addEventListener("change",filterReimburseFunc());
document.getElementById("updateReimbursementButton").addEventListener("click", updateReimburseFunc);

async function getReimburseFunc(){

    let response = await fetch(url + "reimbursements",{credentials:"include"})

    console.log(response);

    if(response.status === 200){
        let data = await response.json();

        for(let reimbursement of data){

            let row = document.createElement("tr");

            //reimburse id
            let cell = document.createElement("td");
            cell.innerHTML = reimbursement.reimb_id;
            row.appendChild(cell);

            //reimburse amount
            let cell2 = document.createElement("td");
            cell2.innerHTML = reimbursement.reimb_amount;
            row.appendChild(cell2);

            //reimburse submitted
            let cell3 = document.createElement("td");
            cell3.innerHTML = reimbursement.reimb_submitted;
            row.appendChild(cell3);

            //reimburse resolved
            let cell4 = document.createElement("td");
            if(reimbursement.reimb_resolved){
                cell4.innerHTML = reimbursement.reimb_resolved;
            } else {
                cell4.innerHTML = "UNRESOLVED";
            }
            row.appendChild(cell4);

            //reimb description
            let cell5 = document.createElement("td");
            cell5.innerHTML = reimbursement.reimb_description;
            row.appendChild(cell5);

            //reimb author
            let cell6 = document.createElement("td");
            cell6.innerHTML = reimbursement.reimb_author;
            row.appendChild(cell6);

            //reimburse status
            let cell7 = document.createElement("td");
            cell7.innerHTML = reimbursement.reimb_status_id;
            row.appendChild(cell7);

            //reimburse type
            let cell8 = document.createElement("td");
            cell8.innerHTML = reimbursement.reimb_type_id;
            row.appendChild(cell8);

            document.getElementById("reimbursementBody").appendChild(row);
        }
    }

}

async function filterReimburseFunc(){
    let status = document.getElementById("statusFilter").value;

    switch(status){
        case "BLANK":
            removeAllChildNodes(document.getElementById("reimbursementBody"));

            let response = await fetch(url + "reimbursements",{credentials:"include"})

            console.log(response);

            if(response.status === 200){
            
                let data = await response.json();

                for(let reimbursement of data){

                    let row = document.createElement("tr");

                    //reimburse id
                    let cell = document.createElement("td");
                    cell.innerHTML = reimbursement.reimb_id;
                    row.appendChild(cell);

                    //reimburse amount
                    let cell2 = document.createElement("td");
                    cell2.innerHTML = reimbursement.reimb_amount;
                    row.appendChild(cell2);

                    //reimburse submitted
                    let cell3 = document.createElement("td");
                    cell3.innerHTML = reimbursement.reimb_submitted;
                    row.appendChild(cell3);

                    //reimburse resolved
                    let cell4 = document.createElement("td");
                    if(reimbursement.reimb_resolved){
                        cell4.innerHTML = reimbursement.reimb_resolved;
                    } else {
                        cell4.innerHTML = "UNRESOLVED";
                    }
                    row.appendChild(cell4);

                    //reimb description
                    let cell5 = document.createElement("td");
                    cell5.innerHTML = reimbursement.reimb_description;
                    row.appendChild(cell5);

                    //reimb author
                    let cell6 = document.createElement("td");
                    cell6.innerHTML = reimbursement.reimb_author;
                    row.appendChild(cell6);

                    //reimburse status
                    let cell7 = document.createElement("td");
                    cell7.innerHTML = reimbursement.reimb_status_id;
                    row.appendChild(cell7);

                    //reimburse type
                    let cell8 = document.createElement("td");
                    cell8.innerHTML = reimbursement.reimb_type_id;
                    row.appendChild(cell8);

                    document.getElementById("reimbursementBody").appendChild(row);
                }
            }
        break;

        case "PENDING":

            removeAllChildNodes(document.getElementById("reimbursementBody"));

            let status = {
                reimb_id:0,
                status_id:1,
                user_id:0
            }

            let response = await fetch(url + "reimbursements/status",
            {
                method:"POST",
                body: JSON.stringify(status),
                credentials:"include"
            });

            console.log(response);

            if(response.status === 200){
            
                let data = await response.json();

                for(let reimbursement of data){

                    let row = document.createElement("tr");

                    //reimburse id
                    let cell = document.createElement("td");
                    cell.innerHTML = reimbursement.reimb_id;
                    row.appendChild(cell);

                    //reimburse amount
                    let cell2 = document.createElement("td");
                    cell2.innerHTML = reimbursement.reimb_amount;
                    row.appendChild(cell2);

                    //reimburse submitted
                    let cell3 = document.createElement("td");
                    cell3.innerHTML = reimbursement.reimb_submitted;
                    row.appendChild(cell3);

                    //reimburse resolved
                    let cell4 = document.createElement("td");
                    if(reimbursement.reimb_resolved){
                        cell4.innerHTML = reimbursement.reimb_resolved;
                    } else {
                        cell4.innerHTML = "UNRESOLVED";
                    }
                    row.appendChild(cell4);

                    //reimb description
                    let cell5 = document.createElement("td");
                    cell5.innerHTML = reimbursement.reimb_description;
                    row.appendChild(cell5);

                    //reimb author
                    let cell6 = document.createElement("td");
                    cell6.innerHTML = reimbursement.reimb_author;
                    row.appendChild(cell6);

                    //reimburse status
                    let cell7 = document.createElement("td");
                    cell7.innerHTML = reimbursement.reimb_status_id;
                    row.appendChild(cell7);

                    //reimburse type
                    let cell8 = document.createElement("td");
                    cell8.innerHTML = reimbursement.reimb_type_id;
                    row.appendChild(cell8);

                    document.getElementById("reimbursementBody").appendChild(row);
                }
            }

        break;

        case "GRANTED":

            removeAllChildNodes(document.getElementById("reimbursementBody"));

            let status = {
                reimb_id:0,
                status_id:2,
                user_id:0
            }

            let response = await fetch(url + "reimbursements/status",
            {
                method:"POST",
                body: JSON.stringify(status),
                credentials:"include"
            });

            console.log(response);

            if(response.status === 200){
            
                let data = await response.json();

                for(let reimbursement of data){

                    let row = document.createElement("tr");

                    //reimburse id
                    let cell = document.createElement("td");
                    cell.innerHTML = reimbursement.reimb_id;
                    row.appendChild(cell);

                    //reimburse amount
                    let cell2 = document.createElement("td");
                    cell2.innerHTML = reimbursement.reimb_amount;
                    row.appendChild(cell2);

                    //reimburse submitted
                    let cell3 = document.createElement("td");
                    cell3.innerHTML = reimbursement.reimb_submitted;
                    row.appendChild(cell3);

                    //reimburse resolved
                    let cell4 = document.createElement("td");
                    if(reimbursement.reimb_resolved){
                        cell4.innerHTML = reimbursement.reimb_resolved;
                    } else {
                        cell4.innerHTML = "UNRESOLVED";
                    }
                    row.appendChild(cell4);

                    //reimb description
                    let cell5 = document.createElement("td");
                    cell5.innerHTML = reimbursement.reimb_description;
                    row.appendChild(cell5);

                    //reimb author
                    let cell6 = document.createElement("td");
                    cell6.innerHTML = reimbursement.reimb_author;
                    row.appendChild(cell6);

                    //reimburse status
                    let cell7 = document.createElement("td");
                    cell7.innerHTML = reimbursement.reimb_status_id;
                    row.appendChild(cell7);

                    //reimburse type
                    let cell8 = document.createElement("td");
                    cell8.innerHTML = reimbursement.reimb_type_id;
                    row.appendChild(cell8);

                    document.getElementById("reimbursementBody").appendChild(row);
                }
            }

        break;

        case "DENIED":

            removeAllChildNodes(document.getElementById("reimbursementBody"));

            let status = {
                reimb_id:0,
                status_id:3,
                user_id:0
            }

            let response = await fetch(url + "reimbursements/status",
            {
                method:"POST",
                body: JSON.stringify(status),
                credentials:"include"
            });

            console.log(response);

            if(response.status === 200){
            
                let data = await response.json();

                for(let reimbursement of data){

                    let row = document.createElement("tr");

                    //reimburse id
                    let cell = document.createElement("td");
                    cell.innerHTML = reimbursement.reimb_id;
                    row.appendChild(cell);

                    //reimburse amount
                    let cell2 = document.createElement("td");
                    cell2.innerHTML = reimbursement.reimb_amount;
                    row.appendChild(cell2);

                    //reimburse submitted
                    let cell3 = document.createElement("td");
                    cell3.innerHTML = reimbursement.reimb_submitted;
                    row.appendChild(cell3);

                    //reimburse resolved
                    let cell4 = document.createElement("td");
                    if(reimbursement.reimb_resolved){
                        cell4.innerHTML = reimbursement.reimb_resolved;
                    } else {
                        cell4.innerHTML = "UNRESOLVED";
                    }
                    row.appendChild(cell4);

                    //reimb description
                    let cell5 = document.createElement("td");
                    cell5.innerHTML = reimbursement.reimb_description;
                    row.appendChild(cell5);

                    //reimb author
                    let cell6 = document.createElement("td");
                    cell6.innerHTML = reimbursement.reimb_author;
                    row.appendChild(cell6);

                    //reimburse status
                    let cell7 = document.createElement("td");
                    cell7.innerHTML = reimbursement.reimb_status_id;
                    row.appendChild(cell7);

                    //reimburse type
                    let cell8 = document.createElement("td");
                    cell8.innerHTML = reimbursement.reimb_type_id;
                    row.appendChild(cell8);

                    document.getElementById("reimbursementBody").appendChild(row);
                }
            }

        break;
    }
}

async function updateReimburseFunc() {

    let reimbId = document.getElementById("reimbId").value;
    let status = document.getElementById("status").value;
    let statusId;

    if(status === "GRANTED"){
        statusId = 2;
    } else if(status === "DENIED"){
        statusId = 3;
    }

    let statusData = {
        reimb_id:reimbId,
        status_id:statusId,
        user_id:userId
    }

    let response = await fetch(url + "reimbursements/update", {
        method:"PUT",
        body:JSON.stringify(statusData),
        credentials:"include"
    });

    console.log(response.status);

    if(response.status === 200){
        console.log(response);
        location.reload;
    } else {
        console.log("update failed");
    }

}

function removeAllChildNodes(parent) {
    while (parent.firstChild) {
        parent.removeChild(parent.firstChild);
    }
}