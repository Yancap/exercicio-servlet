<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pagina inicial</title>
    <link rel="stylesheet" href="styles.css" />
</head>
<body>
    <main>
        <section class="container">
            <form id="login" method="post" class="container-form" autocomplete="off">
                <h1>Login</h1>
                <div class="container-input">
                    <label for="email">Email</label>
                    <input id="email" type="email" name="email">
                </div>
                <div class="container-input">
                    <label for="password">Senha</label>
                    <input id="password" type="password" name="password">
                </div>
                <div>
                    <a href="register">Nao possui conta?</a>
                </div>
                <span style="display: none;" data-error></span>
                <button class="btn">
                    Enviar
                </button>
            </form>
        </section>
    </main>
    <script src="scripts/login.js"></script>
</body>
</html>