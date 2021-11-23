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
    taag.style = "color:#fff;"
    // taag.style = "padding-top: 5.5%; font-size:27px;"
    taag.innerHTML = "Sair?"
    taag.addEventListener("click", () => {
        localStorage.removeItem("user");
        document.location.href = "/home/index.html";
    })
    lst.appendChild(taag);

}

function mudarImg() {
    let white = document.querySelector('.white')
    let black = document.querySelector('.black')



    if (white.style.display == 'none') {

        white.style.display = 'flex'
        black.style.display = 'none'
    }else {
        
        white.style.display = 'none'
        black.style.display = 'flex'
    }

}