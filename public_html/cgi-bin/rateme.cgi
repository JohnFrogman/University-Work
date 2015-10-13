#!/usr/bin/perl -w
print "Content-type:text/html\r\n\r\n";
use CGI qw(param); 
$remote_address = $ENV{'REMOTE_ADDR'};  # User's ip
$s = param("rate");				# The input rating
my $sum = 0;
my $voted = 0;

print<<head; 
<head>
<link rel="stylesheet" type="text/css" href="http://cgi.csc.liv.ac.uk/~m4ah/StyleSheet.css">
<meta charset= "UTF-8">
<meta name="Author" content="Alexander Hayes">
<meta name="keywords" content="University of Liverpool, comp519, web development">
<title>Perl stuff</title>
</head>
<br>
head


# Stops inputs above five.
if ($s > 5)
{
	$s = 5;
}
# Stops inputs less than 1.
if ($s < 1)
{
	$s = 1;
}

# Reading inputs
$ipFile="ip.dat";
open(IP,$ipFile);
@ips=<IP>;
open(IP,">>$ipFile");

# Checking if ip has been used before.
# This only works under certain conditions but I cant figure out why.
foreach $ips (@ips)
{
	if ($ips eq $remote_address)
	{
		$voted = 1;	
	}
}


$rateFile="rate.dat";
open(RATE,$rateFile);
@ratings=<RATE>;
open(RATE,">>$rateFile");

if ($voted == 0)
{
	print IP "$remote_address\n";
	print RATE "$s\n";

	print "You rated my website $s out of 5.";
	print "<br>";
}
else 
{
print "You have already voted.";
}

# Getting the average rating.
foreach $rating (@ratings)
{
	$sum += $rating;
}
$average = $sum/@ratings;
close (RATE);
close (IP);
$roundedAverage  = substr($average, 0, 4);
print "The average rating for my websites is $roundedAverage out of 5";