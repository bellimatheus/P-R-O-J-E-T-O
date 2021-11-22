function Allma(){
    let url = "http://localhost:8080/locadora/locacao"

    fetch(url, {
        method: "GET",
    })
    .then(response => {
        return response.json();
    })
    .then(data => {
        data.forEach(he => {
            console.log(he);
            let card = document.querySelector(".pad").cloneNode(true);
            card.style.display = "block"; 
            card.style.visibility = "visible"; 
            
            let imagem = card.querySelector("img");
            imagem.src = he.img
            card.querySelectorAll("p")[0].innerHTML = he.localRetirada;
            card.querySelectorAll("p")[1].innerHTML = he.DataRetirada;
            card.querySelectorAll("p")[2].innerHTML = he.localDevolucao;
            card.querySelectorAll("p")[3].innerHTML = he.dataDevolucao;
            document.querySelector(".carritos").appendChild(card)
        })
    })
    .catch(err => {
        console.log(err);
    })
}