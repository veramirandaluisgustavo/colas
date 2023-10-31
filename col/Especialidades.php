<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">



</head>

<body>
    <?php
    include "conexion.php";
    $especialidad = $_GET["especialidad"];
    $sql = "SELECT * FROM medico WHERE especialidad='$especialidad'";
    $result = $con->query($sql);
    if (!$result) {
        die("Error en la consulta: " . $con->error);
    }
    ?>
    <div>
        <h1>Listado de Medicos</h1>
        <div class="img-container">
            <img src="./images/edificio.jpg">
        </div>
    </div>
    <div class="container">
        <div class="doctor-details" id="resultado">
            <!--aqui saldran los medicos con esa especialidad-->
            <div class="container">
                <div class="row">

                    <?php
                    while ($row = $result->fetch_assoc()) {
                        // Accede a los datos de cada fila
                        $nombre = $row['nombre'];
                        $imagen = $row['imagen'];

                        // Realiza acciones con los datos, por ejemplo, imprímelos
                        echo '<div class="col-md-6" style="border: 1px solid black;">
                        <div class="especialidad btn-container">
                        <a style="border: 1px solid black;margin:10px" id="' . $nombre . '" class="btn-neon" href="crear.php?especialidad=' . $especialidad .'&medico='.strtolower($nombre).'">
                            <span id="span1"></span>
                            <span id="span2"></span>
                            <span id="span3"></span>
                            <span id="span4"></span>
                            ' . strtoupper($nombre) . '
                           </a>
                           <div style="margin: 10px;" class="img-container"><img src="./images/' . $imagen . '" height="200" width="200"></div>
                           
                    </div>
                    </div>';
                    }
                    ?>

                </div>
                <div class="btn-container">
                    <a style="border: 1px solid black;" href="Index.html" class="btn-neon">
                        <span id="span1"></span>
                        <span id="span2"></span>
                        <span id="span3"></span>
                        <span id="span4"></span>
                        Volver Inicio
                    </a>
                </div>
            </div>
        </div>
        <div class="btn-container">
            <a href="Index.html" class="btn-neon">
                <span id="span1"></span>
                <span id="span2"></span>
                <span id="span3"></span>
                <span id="span4"></span>
                Volver Inicio
            </a>
        </div>
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Registrar Datos</h5>

                    </div>
                    <div class="modal-body">
                        <div class="mb3">
                            <label for="paciente-nomre" class="form-label">Nombre De Paciente</label>
                            <input type="text" class="form-control" id="paciente-nombre" placeholder="Introduce tu nombre">
                        </div>
                        <div class="mb-3">
                            <label for="ci" class="form=label">CI</label>
                            <input type="text" class="form-control" id="ci" placeholder="Introduce tu CI">
                        </div>

                    </div>
                    <div class="modal-footer">
                        <button onclick="sendMessage()" class="btn btn-primary mt-3">Enviar</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
    </div>
    <script>
        setTimeout(function () {
        console.log("Han pasado 30 segundos");
        window.location.href = 'index.html';
    }, 10000);
        var urlParams = new URLSearchParams(window.location.search);
        var valorRecibido = urlParams.get("valor");

        var especialidad = urlParams.get("especialidad");

        //con este valor recibido podemos bucar a los medicos con esa especialidad no? aqui mostre el valor que recibe 
        if (valorRecibido) {
            document.getElementById("resultado").textContent = "Valor Recibido: " + valorRecibido;
        }

        function sendMessage() {

            let pacienteNombre = document.getElementById("paciente-nombre").value;
            let ci = document.getElementById("ci").value;
            let medico;
            let fullMessage = "paciente-nombre:" + pacienteNombre + "-ci:" + ci + "-medico:" + medico;

            socket.send(fullMessage);
            document.getElementById("paciente-nombre").value = "";
            document.getElementById("ci").value = "";
        }
        console.log("Especialidad: " + valorRecibido);
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>

</html>