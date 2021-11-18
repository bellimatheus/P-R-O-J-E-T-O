
async function cadastrarCliente() {
    let infos = {
        "email": document.getElementById("email").value,
        "nome": document.getElementById("nome").value,
        "idade": document.getElementById("idade").value,
        "cpf": document.getElementById("cpf").value,
        "cnh": document.getElementById("cnh").value,
        "telefone": document.getElementById("telefone").value,
        "senha": document.getElementById("senha").value
    };

    try {
        const url = "http://localhost:8080/locadora/cliente";
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
    
    window.location.href = '/home/index.html';
}
