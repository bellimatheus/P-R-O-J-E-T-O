const host = JSON.parse(localStorage.getItem("user"));
console.log(host)

const loca = JSON.parse(localStorage.getItem("locacao"));



var lst = document.querySelector(".lst");
var taag = document.getElementById("lis");

if (host != null) { 
    var nome = document.getElementById("name");
    var demente = document.getElementById("name")
    demente.href = "#";
    nome.innerHTML = "Olá " + host.nome;
    nome.style = "color:#fff; border:none";
    taag.className = "taag";
    taag.style = "color:#fff;"
    // taag.style = "padding-top: 5.5%; font-size:27px;"
    taag.innerHTML = "Sair?"
    taag.addEventListener("click", () => {
        localStorage.removeItem("user");
        //localStorage.removeItem

        document.location.href = "/home/index.html";
    })
    lst.appendChild(taag);

}

function Allma(){
    let url = "http://localhost:8080/locadora/locacao"


    if (host){
        fetch(url, {
            method: "GET",
        })
        .then(response => {
            return response.json();
        })
        .then(data => {
            console.log(data)
            data.forEach(he => {
                let card = document.querySelector(".pad").cloneNode(true);
                card.style.display = "block"; 
                card.style.visibility = "visible"; 
                let imagem = card.querySelector("img");
                imagem.src = he.idVeiculo.img
                card.querySelectorAll("p")[0].innerHTML = "Data retirada: "+he.localRetirada;
                card.querySelectorAll("p")[1].innerHTML = "Data devolução: "+he.dataRetirada;
                card.querySelectorAll("p")[2].innerHTML = "Local retirada: "+he.dataDevolucao;
                card.querySelectorAll("p")[3].innerHTML = "Local devolução: "+he.localDevolucao;
                document.querySelector(".carritos").appendChild(card)
                
                //console.log(he)
            })
        })
        .catch(err => {
            console.log(err);
        })
    }else{
        console.log("Error")
    }

}