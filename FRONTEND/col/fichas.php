<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
    <title>Control</title>

</head>
<?php
include "conexion.php";
$sql = "SELECT * FROM especialidad";
$result = $con->query($sql);
if (!$result) {
    die("Error en la consulta: " . $con->error);
}
?>

<body>

    <div style="margin: 20px;">
    <br>
    <br>
    <br>
    <h1 style="margin: 0px">Escojer Una Especialidad Médica</h1><br>
        
        <div class="container">
            <div class="row" >
                
                    <?php
                    while ($row = $result->fetch_assoc()) {
                        // Accede a los datos de cada fila
                        $nombre = $row['nombre'];
                        $imagen = $row['imagen'];

                        // Realiza acciones con los datos, por ejemplo, imprímelos
                        echo '<div class="col-md-6" style="border: 1px solid black;">
                        <div class="especialidad btn-container">
                        <a style="border: 1px solid black;margin:10px" id="' . $nombre . '" class="btn-neon" href="Pregunta.php?especialidad='.$nombre.'">
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

    <script>
        setTimeout(function () {
        console.log("Han pasado 30 segundos");
        window.location.href = 'index.html';
    }, 10000);
        // document.getElementById("cardiologia").addEventListener("click", function() {
        //     var boton = this;
        //     var valorBoton = boton.textContent.trim();
        //     console.log("Valor del botón 'Cardiología': " + valorBoton);
        //     window.location.href = "Especialidades.html?valor=" + valorBoton;
        // });


        // document.getElementById("dermatologia").addEventListener("click", function() {
        //     var boton = this;
        //     var valorBoton = boton.textContent.trim();
        //     console.log("Valor del botón 'Dermatología': " + valorBoton);
        //     window.location.href = "Especialidades.html?valor=" + valorBoton;
        // });
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>

</html>