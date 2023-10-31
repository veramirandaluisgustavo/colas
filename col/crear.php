<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
    <title>Title</title>
</head>


<body>

<?php
    $medico=$_GET["medico"];
    $especialidad=$_GET["especialidad"];
    echo '<script>
    let medico="'.$medico.'";
    let especialidad="'.$especialidad.'";
    </script>'
    
?>


<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <div id="messageArea"></div>
                <div class="mb3">
                    <label for="paciente-nomre" class="form-label">Nombre De Paciente</label>
                    <input type="text" class="form-control" id="paciente-nombre" placeholder="Introduce tu nombre">
                </div>
                <div class="mb-3">
                    <label for="ci" class="form=label">CI</label>
                    <input type="text" class="form-control" id="ci" placeholder="Introduce tu mensaje">
                </div>
                <button onclick="sendMessage()" class="btn btn-primary mt-3">Enviar</button>
        </div>
    </div>
</div>


<div class="modal-container" id="modal-container">
    <div class="modal2" >
    <h1>SU TIKECT ES EL NUMERO:</h1>
    <h1 id="ncliente">2</h1>
    </div>
</div>

<script th:inline="javascript">
    const modal_cont=document.getElementById("modal-container");
    
    setTimeout(function () {
        console.log("Han pasado 30 segundos");
        window.location.href = 'index.html';
    }, 120000);
    let socket = new WebSocket("ws://localhost:8080/chat")
    function sendMessage(){
    let paciente =document.getElementById("paciente-nombre").value;
    let ci = document.getElementById("ci");
    
    let fullMessage ="paciente-nombre:" +paciente+"-ci:"+ ci.value+"-medico:"+medico+"-especialidad:"+especialidad;
    console.log(fullMessage);
    socket.send(fullMessage);
    //window.location.href = 'index.html';
    
    }
    socket.onmessage =function(event){
        cliente=document.getElementById("ncliente");
        cliente.innerHTML=event.data;
        modal_cont.classList.add('show');
        setTimeout(function () {
        console.log("Han pasado 10 segundos");
        //window.location.href = 'index.html';
    }, 10000);

    };
</script>

</body>
</html>