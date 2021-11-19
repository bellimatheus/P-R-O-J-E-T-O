const dados = JSON.parse(localStorage.getItem('busca'));
console.log(dados);


function get(url) {
    let request = new XMLHttpRequest();
    request.open('GET', url, false);
    request.send()
    return request.responseText
}

// function criandoCarros(carritos) {
//     let iinf = document.querySelector('.pad');
    
//     let imagem = document.createElement("img");
//     model = document.querySelector("#title");
//     marc = document.querySelector("#des");
//     imagem.src = carritos.img;
//     model.innerHTML = carritos.marca;
//     marc.innerHTML = carritos.modelo;

//     iinf.appendChild(imagem);
//     iinf.appendChild(model);
//     iinf.appendChild(marc);

//     return iinf;
    

// }
var url = 'http://localhost:8080/locadora/veiculo'

function aaa(){
    
    
    fetch(url, {
        method: 'GET',
    })
    .then(resp => {
        return resp.json();
    })
    .then(data => {
        data.forEach(e => {
            let model = document.querySelector(".carlos").cloneNode(true);
            model.classList.remove("model");
            let imagem = model.querySelector("img")
            imagem.src = e.img;
            model.querySelectorAll("p")[0].innerHTML = e.marca;
            model.querySelectorAll("p")[1].innerHTML = e.modelo;
            let economico = document.querySelector(".economico");
            let popular = document.querySelector(".popular");
            let wagon = document.querySelector(".wagon");
            let suv = document.querySelector(".suv");
            let esportivo = document.querySelector(".esportivo");
            
            if("Economico" == e.tipo){
                economico.appendChild(model);
            }

            if("Popular" == e.tipo){
                popular.appendChild(model);                
            }

            if("Wagon" == e.tipo){
                wagon.appendChild(model);                
            }

            if("SUV" == e.tipo){
                suv.appendChild(model);                
            }

            if("Esportivo" == e.tipo){
                esportivo.appendChild(model);                
            }
        })
        
    
    })
    .catch(err => {
        console.log(err);
    })
}

function abrir(){

    fetch(url, {
        method: 'GET',
    })
    .then(resp => { return resp.json()})
    .then(data => {
        data.forEach(e => {
            let card = document.querySelector("#popUp").cloneNode(true);
            // let image = document.querySelector(".cap");
            // image.addEventListener("click", () => {
            //     image.src = e.img;
            // })

            card.querySelectorAll("p")[0].innerHTML = e.marca;
            card.querySelectorAll("p")[1].innerHTML = e.modelo;
            card.querySelectorAll("p")[2].innerHTML = e.placa;
            card.querySelectorAll("p")[3].innerHTML = e.espf;

            card.style.display = "block";
            card.style.visibility = "visible";
            body.style.overflow = "hidden"
            
        })

    })

}



// var veiculos = document.querySelector('.veiculos');

// const url = "http://localhost:8080/locadora/veiculo";
// var src = ""

// fetch(url)
// .then(resp => {
//     return resp.json();
// })
// .then(data => {
//     data.forEach(carros => {
//         //atribuindoHtml(carros.img); , carros.tipo, carros.marca
//         var entreVeiculos = document.querySelector('.pad').cloneNode(true);
//         let nome = document.querySelector('p').innerHTML = carros.modelo;
//         let marc = document.querySelector('p').innerHTML = carros.marca;

//         imaag();
//         entreVeiculos.appendChild(nome);
//         entreVeiculos.appendChild(marc);

//     })
// })
// .catch(err => {
//     console.log(err);
// })

// function imaag () {
//     let urlFoto = ""; 

//     entreVeiculos.innerHTML = "";
//     dados.forEach(foto => {
//         imagem.style.width = '100%';
//         let imagem = document.querySelector('#captura');
//         imagem.src = foto.img;
//         entreVeiculos.appendChild(imagem);
//     })
// }

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


// function closeModal() {
//     document.querySelector("body").style.overflow = "visible";
//     document.querySelector(".popUp").classList.add("modal");
// }