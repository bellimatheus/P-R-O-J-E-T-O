function init() {
    document.getElementById("btn_submit").addEventListener("click", () => {
        Login();
        document.getElementById("reg").addEventListener("click", () => {
            registrar();
        })
    });
}

async function Login() {
    let dados = {
        "email": document.getElementById("email").value,
        "senha": document.getElementById("senha").value
    }

    try {
        const url = "http://aaa0-2804-18-8c5-aa1d-e52a-67e8-1030-219d.ngrok.io/locadora/login";
        const settings = {
            method: 'POST',
            headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(dados)
        }

        const response = await fetch(url, settings);
        const data = await response.json();

        localStorage.clear();

        if (response.status == 404) {
            console.log("Erro")
        } else {
            window.location.href = "../home/index.html";
            localStorage.setItem("user", JSON.stringify(data));
        }
    } catch (erro) {
        console.log(erro)
    }
}

function registrar() {
    window.location.href = "../LCadastro/index.html"
}

(init)();