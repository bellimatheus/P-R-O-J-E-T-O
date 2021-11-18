
async function sapoha() {
    let infos = {
        "tipo": document.getElementById("tipo").value,
        "modelo": document.getElementById("modelo").value,
        "marca": document.getElementById("marca").value,
        "placa": document.getElementById("placa").value,
        "espf": document.getElementById("espf").value,
        "img": document.getElementById("img").value,
    };
    try {
        const url = "http://localhost:8080/locadora/veiculo";
        const settings = {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(infos)
        };

        await fetch(url, settings);
    } catch (erro) {
        console.log(erro)
    };
    verifica();
    
}

function verifica(){
    localStorage.clear();
//     let inpuut = document.querySelector("tipo");
//     if (inpuut != ""){
//         alert("carro cadastrado")
//     }else{
//         alert.alert("Faltando info")
//     }
}

function local () {
    window.location.href = '/home/index.html';
}