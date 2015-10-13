#!/usr/bin/perl -w
print "Content-type:text/html\r\n\r\n";
use CGI qw(param); 
#$remote_address = $ENV{'REMOTE_ADDR'};
$s = param("rate");
print "You rated my website $s out of 5.";
my $sum = 0;

$rateFile="rate.dat";
open(RATE,$rateFile);
@ratings=<RATE>;
open(RATE,">>$rateFile");
print RATE "$s\n";

# Getting the average rating.
foreach $rating (@ratings)
{
	$sum += $rating;
}
$average = $sum/@ratings;
close (RATE);

print "The average rating for my websites is $average out of 5";


