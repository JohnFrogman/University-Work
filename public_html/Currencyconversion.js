//Currency Converters
//Multiplies the value of whatever the input is and changes the values in the other boxes, each conversion factor is 
//multiplied by 100 so that the rounding to two decimal places is smoother.

function poundChange(gbp)
{
	document.getElementById("USD").value=Math.round(gbp*160)/100;
	document.getElementById("EUR").value=Math.round(gbp*127)/100;
}

function euroChange(euro)
{
	document.getElementById("GBP").value=Math.round(euro*79)/100;
	document.getElementById("USD").value=Math.round(euro*126)/100;
}

function dollarChange(usd)
{
	document.getElementById("EUR").value=Math.round(usd*80)/100;
	document.getElementById("GBP").value=Math.round(usd*63)/100;
}

