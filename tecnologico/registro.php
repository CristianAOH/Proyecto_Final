<?php include ('functions.php');
$nombre=$_GET['nombre'];
$s_nombre=$_GET['s_nombre'];
$apellido_p=$_GET['apellido_p'];
$apellido_m=$_GET['apellido_m'];
$semestre=$_GET['semestre'];
$id_carrera=$_GET['id_carrera'];
$pin=$_GET['pin'];


ejecutarSQLCommand("INSERT INTO  `alumno` (nombre,s_nombre,apellido_p,apellido_m,semestre,id_carrera)
VALUES ('$nombre','$s_nombre','$apellido_p','$apellido_m','$semestre','$id_carrera');

 ON DUPLICATE KEY UPDATE `nombre`= '$nombre',
`s_nombre`='$s_nombre'
`apellido_p`='$apellido_p'
`apellido_m`='$apellido_m'
`semestre`='$semestre'
`id_carrera`='$id_carrera'
`pin`='$pin';");
 ?>