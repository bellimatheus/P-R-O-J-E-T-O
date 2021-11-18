const dados = JSON.parse(localStorage.getItem('busca'));
console.log(dados);


var veiculos = document.querySelector('.veiculos');

const url = "http://localhost:8080/locadora/veiculo";
var src = ""

fetch(url)
.then(resp => {
    return resp.json();
})
.then(data => {
    data.forEach(carros => {
        //atribuindoHtml(carros.img); , carros.tipo, carros.marca
        var entreVeiculos = document.querySelector('.pad').cloneNode(true);
        let nome = document.querySelector('p').innerHTML = carros.modelo;
        let marc = document.querySelector('p').innerHTML = carros.marca;

        imaag();
        entreVeiculos.appendChild(nome);
        entreVeiculos.appendChild(marc);

    })
})
.catch(err => {
    console.log(err);
})

function imaag () {
    let urlFoto = ""; 

    entreVeiculos.innerHTML = "";
    dados.forEach(foto => {
        imagem.style.width = '100%';
        let imagem = document.querySelector('#captura');
        imagem.src = foto.img;
        entreVeiculos.appendChild(imagem);
    })
}

// function atribuindoHtml(img){ //, tipo, marca
//     let pad = document.querySelector(".pad").cloneNode(true);
//     let captura = document.querySelector("#captura");
//     pad.classList.remove("modal");
//     captura.innerHTML = "";
//     pad.captura.innerHTML = img;    
//     // pad.querySelector("#title").innerHTML = tipo;    
//     // pad.querySelector("#preco").innerHTML = marca;    
//     pad.addEventListener("click", () => {
//         document.querySelector("body").style.overflow = "hidden";
//         document.querySelector(".popUp").classList.remove("modal");
       
//     });
//     veiculos.appendChild(pad);
// }

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