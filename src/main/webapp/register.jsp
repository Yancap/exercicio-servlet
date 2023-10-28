<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="./styles.css" />
</head>
<body>
    <main>
        <section class="container">
            <form id="register" class="container-form register" autocomplete="off">
                <h1>Register</h1>
                <div class="form-row">
                  <div class="container-input">
                    <label for="name">Nome</label>
                    <input id="name" type="text" >
                  </div>
                  <div class="container-input">
                    <label for="email">Email</label>
                    <input id="email" type="email" >
                  </div>
                </div>
                <div class="form-row">
                  <div class="container-input">
                      <label for="password">Senha</label>
                      <input id="password" type="password">
                  </div>
                  <div class="container-input">
                      <label for="confirm-password">Confirmar Senha</label>
                      <input id="confirm-password" type="password">
                  </div>
                </div>
                <div>
                    <a href="/webapp">Ja possui conta?</a>
                </div>
                <span style="display: none;" data-error>
                    Credenciais invalidas
                </span>
                <button class="btn">
                    Enviar
                </button>
            </form>
        </section>
    </main>
    <script src="scripts/register.js"></script>
</body>
</html>