const url = "http://localhost:8090/";

let userId;
let roleId;

document.getElementById("loginButton").addEventListener("click", loginFunc);

async function loginFunc() {
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    let user = {
        username:usern,
        password:userp
    }

    console.log(user);

    let loginResponse = await fetch(url + 'login', {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    console.log(loginResponse.status);

    if(loginResponse.status === 200){

        let roleIdResponse = await fetch(url + "login/roleId", 
        {
            method: "POST",
            body: JSON.stringify(user),
            credentials: "include"
        });

        let userIdResponse = await fetch(url + "login/userId",
        {
            method: "POST",
            body: JSON.stringify(user),
            credentials: "include"
        });

        console.log(roleIdResponse.status);
        console.log(userIdResponse.value);

        if(roleIdResponse.status === 200){
            roleId = await roleIdResponse.json();
            sessionStorage.setItem("roleId", roleId);
        }

        if(userIdResponse.status ===200){
            userId = await userIdResponse.json();
            sessionStorage.setItem("userId", userId);
        }

        if(roleId === 1){
            window.location.replace("employee.html");
        } else if (roleId === 2) {
            window.location.replace("manager.html");
        }

    } else {
        document.getElementById("login-row").appendChild("span");
    }

}

