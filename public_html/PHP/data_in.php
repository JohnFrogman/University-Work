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
</head>

<body>
<?php
			
	$db = mysql_connect('mysql', 'm4ah', 'qwertyqaz1');
	mysql_select_db("m4ah");
	
	/*insert students into DB*/
	
	if	(isset($_POST["submit"])) 
	{		
		// echo @mysql_ping() ? 'true' : 'false';
		
		$date=date("Y-m-d");  /*  Get the current date in the right SQL format  */
		
		$query = "SELECT COUNT(*) FROM Students WHERE gr=" . $_POST["gr"];
		$groupCount = mysql_query($query);
		$groupSize = mysql_fetch_row($groupCount);
		
		// Prevents registering more than 8 people to a group. 
		if ($groupSize[0] >= 8)
		{
			echo "that group is full";
			
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
			$idQuery = "Select student_id from Students";
			$idArr = mysql_fetch_row(mysql_query($idQuery));
			// Checks if someone is already registered, then deletes their previous entry if they are.
			foreach ($idArr as &$id)
			{
				if ($id == $_POST["student_id"])
			 	{
					echo $id;
					echo $_POST["student_id"];
					{
						$sql = "DELETE FROM Students WHERE student_id=".$_POST["student_id"].""; 
						mysql_query($sql);
						echo "Deleted your old data.";			
					}	
			 	}
			}
			
			$sql="INSERT INTO Students VALUES('','" . $_POST["f_name"] . "','" . $_POST["l_name"] . "'," . $_POST["student_id"] . ",'" . $_POST["email"] . "','" . $date . "'," . $_POST["gr"] . ")"; 
			mysql_query($sql);   /*  execute the query  */  
			echo"<h3>Thank you. The data has been entered.</h3> \n";
			echo'<p><a href="data_in.php">Back to registration</a></p>' . "\n";
			echo'<p><a href="data_out.php">View the student lists</a></p>' ."\n";
			
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

	<h3>Enter your items into the database</h3>
	<form action="data_in.php" method="post">
	First Name: <input required type="text" name="f_name" /> <br/>
	Last Name: <input required type="text" name="l_name" /> <br/>
	ID: <input required type="number" name="student_id" min="1"/> <br/>
	email: <input required type="email" name="email" /> <br/>
	Time Slot: <select name="gr">
		<option value ="1">1</option>
		<option value ="2">2</option>
		<option value ="3">3</option>
		<option value ="4">4</option>
	</select><br/><br/>
	<input type="submit" name="submit" /> <input type="reset" />
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
<br/>
<a href="data_out.php">Check enrolled students</a>

</body>
</html>
