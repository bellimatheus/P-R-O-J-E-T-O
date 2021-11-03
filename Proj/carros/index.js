var carritos = document.querySelector(".carritos");
const url = "http://localhost:8080/api/locadora/veiculo"


fetch(url)
    .then(response => {
        response.json()
    })
    .then(data => {
        data.forEach(carros => {
            let carro = documente.querySelector(".pic-ctn").cloneNode(true);

            carro.classList.remove("model");
            carro.querySelector("h3").innerHTML = carros.tipo;
            carro.querySelector("p").innerHTML = carros.modelo;
            carritos.appendChild(carro);
        })
    })
    .catch(err => {
        console.log(err)
    })