<?php
include('functions.php');
$id_alumno=$_GET["id_alumno"];


if($resultset=getSQLResultSet("SELECT * FROM `alumno` WHERE id_alumno='$id_alumno'")){
	while ($row = $resultset->fetch_array(MYSQLI_NUM)){
		echo json_encode($row);
	}
}

?>


