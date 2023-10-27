<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <link rel="stylesheet" href="../styles.css" />
</head>
<body>
    <main>
        <section class="container">
            <form action="auth" method="POST" class="container-form register">
                <h1>Register</h1>
                <div class="form-row">
                  <div class="container-input">
                    <label for="">Nome</label>
                    <input type="nome">
                  </div>
                  <div class="container-input">
                    <label for="">Email</label>
                    <input type="email">
                  </div>
                </div>
                <div class="form-row">
                  <div class="container-input">
                      <label for="">Senha</label>
                      <input type="password">
                  </div>
                  <div class="container-input">
                      <label for="">Confirmar Senha</label>
                      <input type="password">
                  </div>
                </div>
                <div>
                    <a href="/webapp">Já possui conta?</a>
                </div>
                <button class="btn">
                    Enviar
                </button>
            </form>
        </section>
    </main>
</body>
</html>