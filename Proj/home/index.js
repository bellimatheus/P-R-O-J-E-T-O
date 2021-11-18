
var varr = new Date();
document.querySelector("#data").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());
document.querySelector("#devData").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());

const host = JSON.parse(localStorage.getItem("user"));
console.log(host)

var lst = document.querySelector(".lst");

if (host != null) { 
    var nome = document.getElementById("name");
    nome.innerHTML = "Olá " + host.nome;
    nome.style = "color:#000; padding-top: 15px; border:none";
    // nome.style.hover = "color:gold";
    // var taag = document.getElementById("lis");
    // taag.className = "taag";
    // taag.innerHTML = "Sair?"
    // lst.appendChild(taag);
    // taag.addEventListener("click", () => {
    //     CLEAR();
    //     refresh();
    // })
}



var lugar = document.querySelector(".buraco");

function locacao(){

    let google = document.querySelectorAll(".aluga")[1];
    google.classList.remove("modal");
    
    if (!google.classList.contains("modal")) {
        botao.addEventListener("click", () => {
            let database = {
                "retirada": document.querySelector("#local").value,
                "dataRet": document.querySelector("#data").value,
                "horaRet": document.querySelector("#hora").value,
                "devolucao": document.querySelector("#dev").value,
                "dataDev": document.querySelector("#devData").value,
                "horaDev": document.querySelector("#devHora").value
            }
            localStorage.setItem("busca", JSON.stringify(database));
            window.location.href = "/carros/index.html"
            botao.type = "submit";
            console.log(botao);
        })
    }
}


function CLEAR(){
    localStorage.clear(localStorage.getItem("user"));
}


