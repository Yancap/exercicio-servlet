
const error = {
}

async function handleSubmit(event) {
  event.preventDefault()
  const tagError = document.querySelector("[data-error]")
  tagError.classList.remove("message-error")
  tagError.setAttribute("style", "display: none;")
  this.querySelector("#email").style.outline = ""
  this.querySelector("#password").style.outline = ""


  const body = {
    email: this.querySelector("#email").value,
    password: this.querySelector("#password").value
  }

  
  const response = await fetch("http://localhost:8080/webapp/profile", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(body)
  })
  const json = await response.json();

  if(json.error) {
    if(json.error === "WrongLoginParams") {
      this.querySelector("#email").style.outline = "1px solid #F5746C"
      this.querySelector("#password").style.outline = "1px solid #F5746C"
    }
    tagError.classList.add("message-error")
    tagError.setAttribute("style", "display: inline;")
    tagError.innerHTML = json.message
    return;
  }

  document.cookie
  .split(";")
  .forEach(
    c => { 
      document.cookie = c.replace(/^ +/, "")
      .replace(/=.*/, "=;expires=" 
      + new Date().toUTCString() + ";path=/"); 
  })

  
  const name = json.body.name.replaceAll(" ", "_")
  
  document.cookie = "name=" + name;
  document.cookie = "email=" + json.body.email;
  window.location.assign(response.url)
}
document.getElementById("login").addEventListener("submit", handleSubmit)