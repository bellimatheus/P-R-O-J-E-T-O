const dados = JSON.parse(localStorage.getItem('busca'));
console.log(dados);


var veiculos = document.querySelector('.veiculos');

const url = "http://fe7f-2804-214-8592-c1a2-c9f3-64f9-9f61-80c2.ngrok.io/locadora/veiculo";

fetch(url)
.then(resp => {
    return resp.json();
})
.then(data => {
    data.forEach(carro => {
        generateHtml(carro.img, carro.tipo, carro.marca);
    })
})
.catch(err => {
    console.error(err);
})

function generateHtml(img, tipo, marca){
    let pad = document.querySelector(".pad").cloneNode(true);
    pad.classList.remove("modal");
    pad.querySelector("#captura").innerHTML = img;    
    pad.querySelector("#title").innerHTML = tipo;    
    pad.querySelector("#preco").innerHTML = marca;    
    pad.addEventListener("click", () => {
        document.querySelector("body").style.overflow = "hidden";
        document.querySelector(".popUp").classList.remove("modal");
        //getVeiculo(id);
    });
    veiculos.appendChild(pad);
}

// function getVeiculo(id) {
//     let urlFoto = "https://jsonplaceholder.typicode.com/photos?albumId=" + id;

//     fetch(urlFoto)
//     .then(resp => { return resp.json() })
//     .then(data => {
//         let infos = document.querySelector(".infos");
//         infos.innerHTML = "";
//         data.forEach(foto => {
//             let img = document.createElement("img");
//             img.style.width = "20%";
//             img.src = foto.url;
//             infos.appendChild(img);
//         })
//         //console.log(data);
//     })
//     .catch(err => { console.log(err) })
// }


function closeModal() {
    document.querySelector("body").style.overflow = "visible";
    document.querySelector(".popUp").classList.add("modal");
}