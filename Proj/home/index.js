
var varr = new Date();
document.querySelector("#data").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());
document.querySelector("#devData").setAttribute("min", varr.getFullYear()+"-"+varr.getMonth()+"-"+varr.getDate());

var nome = document.querySelector("#name");
username.innerHTML = localStorage.getItem("nome");

var lugar = document.querySelector(".buraco");




// function limpar(){
//     document.local.reset();
//     document.data.reset();
//     document.hora.reset();
// }

// function validarData(){
    
//     if(!data.value){
//         botao.addEventListener("click", () => {
//             locacao();
//         })

//     }else{
//         alert("Vazio")
//     }
// }


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

    //
    // if(local == "" || data == "" || hora == ""){
    //     alert('Por favor, preencha os campos');
    //     return false;
    // }

