<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <link rel="stylesheet" href="./css/main.css">
    <title>Control</title>
</head>
<body>
  <?php
  $especialidad=$_GET["especialidad"];
  if($especialidad=="general"){
    $especialidad="nulo";
  }
  echo '<script>
  let especialidad="'.$especialidad.'"
  </script>'

  ?>
   <div class="container text-center center-container">

      <br>
      <h2>¿Usted Cuenta con Médico de Cabecera?</h2>
      <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="especialidad">
                <a id="siButton" class="btn-neon" href="Especialidades.php?especialidad=<?php echo $especialidad ;?>">Sí</a>
                <a id="noButton" class="btn-neon" href="crear.php?especialidad=<?php echo $especialidad ;?>&medico=nulo">No, Crear Ficha</a><br>
                <div class="img-container"><img src="./images/dermatologia_2.jpg" height="200" alt="Dermatología Image"></div>
                <p>¿Qué es un Médico de Cabecera?</p>
                <p>Un médico de cabecera es responsable de la atención general del paciente en un hospital o en el ámbito clínico.</p>
            </div>
        </div>
      </div>
   </div>
   <script>
    setTimeout(function () {
        console.log("Han pasado 30 segundos");
        window.location.href = 'index.html';
    }, 10000);
   </script>
   

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
      crossorigin="anonymous"></script>
</body>
</html>
