<html>
<!-- Code borrowed, butchered and built on from the slides --> 
<!-- Stack overflow and google were very helpful for troubleshooting -->

<head>
	<link rel="stylesheet" type="text/css" href="StyleSheet.css">
	<meta charset= "UTF-8">
	<meta name="Author" content="Alexander Hayes">
	<meta name="keywords" content="University of Liverpool, comp519, web development">
	<meta name="description" content="First webpage made by Alex, made for both fun and profit.">
	<title>Module Registration</title>
	
	<script type="text/javascript">
	
	var usedID = 0;

	var idArr = new Array;
	idArr = <?php

	$db = mysql_connect('mysql', 'm4ah', 'qwertyqaz1');
	mysql_select_db("m4ah");

	$idQuery = "SELECT student_id FROM Students";
	$q = mysql_query($idQuery);
			
	$idArr = Array();
	while ($row = mysql_fetch_array($q, MYSQL_ASSOC)) 
	{
		$idArr[] =  $row['student_id'];  
	}
	echo json_encode($idArr); 
	mysql_close();

	?>;

	function checkID()
	{
		for (var i = 0; i < idArr.length; i++)
		{
			if (idArr[i] == document.getElementById("student_id").value)
			{	
				usedID = 1;		
			}
		}
	}	
	
	function continueBox()
	{		
		if (usedID == 1)
{
		var r = confirm("Are you sure you want to change your information?");
		if (r == true)
		{
			return true;
		}
			else 
		{	
			return false;
		}
}	
	}
	</script>	

</head>

<body>
<?php
			
	$db = mysql_connect('mysql', 'm4ah', 'qwertyqaz1');
	mysql_select_db("m4ah");
	
	/*insert students into DB*/
	
	if	(isset($_POST["submit"])) 
	{		
		// echo @mysql_ping() ? 'true' : 'false';
		

		$idQuery = "SELECT student_id FROM Students";
		$q = mysql_query($idQuery);
			
		$idArr = Array();
		while ($row = mysql_fetch_array($q, MYSQL_ASSOC)) 
		{
			$idArr[] =  $row['student_id'];  
		}

		// Checks if someone is already registered, then deletes their previous entry if they are.
		foreach ($idArr as $id)
		{
			if ($id == $_POST["student_id"])
		 	{
				$sql = "DELETE FROM Students WHERE student_id=".$_POST["student_id"].""; 
				mysql_query($sql);
				echo "Deleted your old data.";				
		 	}
		}

		$date=date("Y-m-d");  /*  Get the current date in the right SQL format  */
		
		$query = "SELECT COUNT(*) FROM Students WHERE gr=" . $_POST["gr"];
		$groupCount = mysql_query($query);
		$groupSize = mysql_fetch_row($groupCount);
		
		// Prevents registering more than 8 people to a group. 
		if ($groupSize[0] >= 8)
		{
			echo "That group is full";
			echo "<br/>";
			
			// Shows remaining places in group.
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
			mysql_close();
		}

		else 
		{

			//echo $id;
			//echo $_POST["student_id"];
			
			$sql="INSERT INTO Students VALUES('','" . $_POST["f_name"] . "','" . $_POST["l_name"] . "'," . $_POST["student_id"] . ",'" . $_POST["email"] . "','" . $date . "'," . $_POST["gr"] . ")"; 
			mysql_query($sql);   /*  execute the query  */  
			echo"<h3>Thank you. The data has been entered.</h3> \n";
			
			// Shows remaining places in group.
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
			mysql_close();
		}
	}

	else
	{
?>   

	
	<h1>Register for a practical slot</h1>
	<p>Check all your info before submitting, make sure that your ID number is correct</p>
	<p>You can change your slot by registering again with the same ID</p>
	<p>If you have any problems email A.hayes2@liverpool.ac.uk</p>

	<h3>Enter your items into the database</h3>
	<form action="data_in.php" method="post">
	First Name: <input required type="text" name="f_name" /> <br/>
	Last Name: <input required type="text" name="l_name" /> <br/>
	ID: <input required type="number" id = "student_id" name="student_id" onchange="checkID()" min="1"/> <br/>
	email: <input required type="email" name="email" /> <br/>
	Time Slot: <select name="gr">
		<option value ="1">1</option>
		<option value ="2">2</option>
		<option value ="3">3</option>
		<option value ="4">4</option>
	</select><br/><br/>
	<input type="submit" name="submit" onclick="continueBox()"/> <input type="reset" />
	</form>
<?php
	// Remaining places in a group
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
	mysql_close();	
}     /*  end of "else" block  */
?>

<a href="data_in.php">Return to registration</a>

</body>
</html>
