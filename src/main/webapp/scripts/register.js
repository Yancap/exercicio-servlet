const error = {
}

async function handleSubmit(event) {
  event.preventDefault()

  const tagError = document.querySelector("[data-error]")
  tagError.classList.remove("message-error")
  tagError.setAttribute("style", "display: none;")

  const inputPassword = this.querySelector("#password")
  const inputConfirmPassword = this.querySelector("#confirm-password")

  const password = inputPassword.value
  const confirmPassword = inputConfirmPassword.value
  if(password !== confirmPassword) {
    inputPassword.style.outline = "1px solid #F5746C"
    inputConfirmPassword.style.outline = "1px solid #F5746C"
    tagError.classList.add("message-error")
    tagError.setAttribute("style", "display: inline;")
    tagError.innerHTML = "Senhas diferentes"
  } else {
    inputPassword.style.outline = ""
    inputConfirmPassword.style.outline = ""
  }

  const body = {
    name: this.querySelector("#name").value,
    email: this.querySelector("#email").value,
    password: password
  }

  const response = await fetch("http://localhost:8080/webapp/register", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(body)
  })
  const json = await response.json();

  if(json.error) {
    if(json.error === "EmailAlreadyExists") {
      this.querySelector("#email").style.outline = "1px solid #F5746C"
    }
    tagError.classList.add("message-error")
    tagError.setAttribute("style", "display: inline;")
    tagError.innerHTML = json.message
    return;
  }

  alert("Registro realizado com sucesso")
  setTimeout(() => {
    window.location.assign("/webapp")
  }, 500)
}
document.getElementById("register").addEventListener("submit", handleSubmit)