<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administrador - Motor Riding Club</title>
    <link rel="stylesheet" href="css/administrador.css">
    <link 
        href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" 
        rel="stylesheet">
</head>
<body>
    <div class="admin-container">
        <!-- Barra de navegación con enlace para regresar -->
        <nav class="navbar navbar-light">
            <p><a href="administrador.jsp">← Volver</a></p>
        </nav>
        
        <h1>Panel de Administrador</h1>
        
        <!-- Contenedor Flex para Clubes y Usuarios -->
        <div class="flex-container">
            <!-- Sección Clubes -->
            <div class="section">
                <div class="section-header">
                    <h2>Clubes</h2>
                    <button class="add-btn" id="addClubBtn">+</button>
                    <input type="text" id="searchClub" placeholder="Buscar Club" class="search-input">
                </div>
                <!-- Los clubes se cargarán aquí con AJAX -->
                <div id="clubList" class="list-container">
                    <!-- Los clubes se cargarán aquí con AJAX -->
                </div>
            </div>

            <!-- Sección Usuarios -->
            <div class="section">
                <div class="section-header">
                    <h2>Usuarios</h2>
                    <button class="add-btn" id="addUserBtn">+</button>
                    <input type="text" id="searchUser" placeholder="Buscar Usuario" class="search-input">
                </div>
                <!-- Los usuarios se cargarán aquí con AJAX -->
                <div id="userList" class="list-container">
                    <!-- Los usuarios se cargarán aquí con AJAX -->
                </div>
            </div>
        </div>
    </div>

    <!-- Modal para agregar/modificar Club o Usuario -->
    <div id="modal" class="modal">
        <div class="modal-content">
            <span id="closeModal" class="close-btn">&times;</span>
            <h3 id="modalTitle">Agregar Club</h3>
            <form id="modalForm">
                <label for="name">Nombre:</label>
                <input type="text" id="modalName" required>
                <label for="description">Descripción:</label>
                <input type="text" id="modalDescription" required>
                <button type="submit" id="modalSubmitBtn">Guardar</button>
            </form>
        </div>
    </div>

    <!-- Vinculación con el archivo de JS -->
    <script src="javaScript/main.js"></script>
</body>
</html>
