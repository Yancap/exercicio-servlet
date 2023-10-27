
const error = {
}

async function handleSubmit(event) {
  event.preventDefault();

  const tagError = document.querySelector("[data-error]")
  const body = {
    email: this.querySelector("#email").value,
    password: this.querySelector("#password").value
  }

  
  const response = await (await fetch("http://localhost:8080/webapp/profile", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(body)
  })).json()
    
  if(response.error) {
    console.log("Deu ruim");
    tagError.classList.add("message-error")
    tagError.setAttribute("style", "display: inline;")
    tagError.innerHTML = response.message
  }

  
}

document.getElementById("login").addEventListener("submit", handleSubmit)