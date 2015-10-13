<html>
<!-- Code borrowed, butchered and built on from the slides. -->
<head>
	<link rel="stylesheet" type="text/css" href="StyleSheet.css">
	<meta charset= "UTF-8">
	<meta name="Author" content="Alexander Hayes">
	<meta name="keywords" content="University of Liverpool, comp519, web development">
	<meta name="description" content="First webpage made by Alex, made for both fun and profit.">
	<title>Enrollment</title>
</head>

<body>
<h1> Student Database </h1>
<p> Order the full list of students by 
<a href="data_out.php?order=date">date</a>,
<a href="data_out.php?order=student_id">id</a>, or
by <a href="data_out.php?order=l_name">surname</a>.
<br/>
<a href="data_in.php">Return to registration page</a>
</p>

<form action="data_out.php" method="post">
Or only see the list of students in group 
<select name="gr">
  <option value ="1">1</option>
  <option value ="2">2</option>
  <option value ="3">3</option>
</select>
<br/>
<input type="submit" name="submit" />
</form>

<?php 
	/*get students from the DB */
	$db = mysql_connect("mysql", "m4ah", "qwertyqaz1");
	mysql_select_db("m4ah", $db);
	
	for ($i = 1; $i <= 4; $i++)
	{
		$q = "SELECT COUNT(*) FROM Students WHERE gr='".$i."'";
		$gCount = mysql_query($q);
		$gSize = mysql_fetch_row($gCount);
		$placesLeft = 8 - $gSize[0];
		echo $placesLeft;
		echo " places left in timeslot ";
		echo $i;
		echo "<br/>";
	}

	switch($_GET["order"])
	{
		case  'date':   $sql = "SELECT * FROM Students ORDER BY date"; break;
		case  'student_id':     $sql = "SELECT * FROM Students ORDER BY student_id"; break;
		case  'l_name': $sql = "SELECT * FROM Students ORDER BY l_name"; break;

		default: $sql = "SELECT * FROM Students";  break;
	}
	
	if(isset($_POST["submit"]))
	{
		$sql = "SELECT * FROM Students WHERE gr=" . $_POST["gr"];
	}

	$result=mysql_query($sql);      /*  execute the query  */
	while($row=mysql_fetch_array($result))
	{
		echo "<h4> Name: " . $row["l_name"] . ', ' . $row["f_name"] . "</h4> \n";
		echo "<h5> ID: " . $row["student_id"] . "<br/> Email: " . $row["email"] . "<br/> Time slot: " . $row["gr"] . "<br/> Posted: " . $row["date"] . "</h5> \n";
	}
	mysql_close();
?>
</body>
</html>
