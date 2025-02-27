<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Iniciar Sesión Club</title>
    <!-- Enlace a estilos CSS -->
    <link rel="stylesheet" href="static/css/styles.css">
    <link rel="stylesheet" 
          href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" 
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" 
          crossorigin="anonymous">
    <!-- Scripts de Bootstrap y jQuery -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
    <script 
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" 
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" 
        crossorigin="anonymous"></script>
</head>
<body>
    <div class="container" style="width: 400px; margin-top: 50px;">
        <h3 class="text-center mb-4"><b>Iniciar Sesión Club</b></h3>

        <!-- Formulario de inicio de sesiÃ³n -->
        <form id="loginClubForm" action="/login/club" method="post">
            <!-- Correo -->
            <div class="mb-3">
                <input type="text" id="email" class="form-control" placeholder="Introduzca su email" required>
            </div>

            <!-- Contraseña -->
            <div class="mb-3">
                <input type="password" id="password" class="form-control" placeholder="Introduzca su contraseña" required>
            </div>

            <!-- BotÃ³n de iniciar sesiÃ³n -->
            <button type="submit" class="btn btn-dark w-100">Iniciar Sesión</button>
        </form>

        <!-- Enlaces adicionales -->
        <div class="text-center mt-3">
            <p>¿Tienes un club no registrado? <a href="registrarseClub.jsp">Registrarse</a></p>
            <p><a href="index.jsp">Volver al menú</a></p>
        </div>

        <!-- Contenedor para mostrar mensajes de resultado -->
        <div id="result" class="text-center mt-3 text-danger"></div>
    </div>

    <!-- Incluyendo el archivo de JavaScript -->
    <script src="javaScript/main.js" type="module"></script>
</body>
</html>
