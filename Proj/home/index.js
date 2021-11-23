
var varr = new Date();
document.querySelector("#data").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());
document.querySelector("#devData").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());

const host = JSON.parse(localStorage.getItem("user"));
console.log(host)

var lst = document.querySelector(".lst");
var taag = document.getElementById("lis");

if (host != null) { 
    var nome = document.getElementById("name");
    var demente = document.getElementById("name")
    demente.href = "#";
    nome.innerHTML = "Olá " + host.nome;
    nome.style = "color:#fff; border:none";
    taag.className = "taag";
    //taag.style = "#fff"
    // taag.style = "padding-top: 5.5%; font-size:27px;"
    taag.innerHTML = "Sair?"
    taag.addEventListener("click", () => {
        localStorage.removeItem("user");
        document.location.href = "/home/index.html";
    })
    lst.appendChild(taag);

}


var lugar = document.querySelector(".buraco");

function locacao(){

    let google = document.querySelectorAll(".aluga")[1];
    google.classList.remove("modal");

    let botao = document.querySelector("#btn");
    
    if (!google.classList.contains("modal")) {
        console.log(google)
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
            console.log(database);
            document.location.href = "/carros/index.html"
            
        })
        
    }
}




