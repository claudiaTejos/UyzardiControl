//Variaveis
var emailTyped = document.getElementById("inputEmail");
var passwordTyped = document.getElementById("inputPassword");
var btnSubmit = document.getElementById("btnSubmit");

//Funções
function validateInfo() {
    if (emailTyped.value == "teste@teste" && passwordTyped.value == "123") {
        document.location.href = "telaPrincipal.html";
    }
}

btnSubmit.addEventListener("click", validateInfo);
