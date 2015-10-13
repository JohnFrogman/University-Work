// 								Quiz By Alex Hayes								//
//	This has all the functions required to generate a short quiz, it's a little //
//	Messy but it ultimately works.												//
// 				Permutation code borrowed from Dr Russell martin 				//
// 						Full code can be found here:							//
// 	view-source:cgi.csc.liv.ac.uk/~martin/teaching/comp519/JS/permutation.html	//

//
var questionOrder = new Array();
var score = 0;
var questions = new Array(); 
var id;
var percentageScore;
	
questions[0] = "Who wrote Dead Souls?";
questions[1] = "When was the Magna Carta sealed?";
questions[2] = "Who was the first Holy Roman Emperor?";
questions[3] = "Which of these is not a moon of Jupiter?";
questions[4] = "Who invented the first practical electric car?";
questions[5] = "Shake is a unit of what?";
questions[6] = "When did Constantinople fall?";
questions[7] = "Where is Yakutsk?";
questions[8] = "A pion is a...";
questions[9] = "Who united Japan after the Sengoku era?";
//questions[10] = "";

var answers = new Array();

answers[0] = ["Alexander Pushkin", "Nikolai Gogol", "Leo Tolstoy", 1];
answers[1] = ["1215", "1066", "1488", 0];
answers[2] = ["Julius Caesar", "Alfred the Great", "Charlemagne", 2]
answers[3] = ["Europa","Eurydome","Narvi",2]	
answers[4] = ["Thomas Parker", 	"Nikola Tesla",	"James Joule",0]
answers[5] = ["Volume","Time", "Power",1]
answers[6] = ["1494","1346","1453",2] 	
answers[7] = ["Siberia","The Caucasus","Alaska",0]
answers[8] = ["Baryon","Meson","Quark",1];
answers[9] = ["Oda Nobunaga", "Tokugawa Ieyasu", "Toyotomi Hideyoshi", 2];

function generateQuiz(quizLength)
{
	//clears the boxes of the quiz on generation to stop things being endlessly appended.
	for (var q = 0 ; q < quizLength; q++)
	{
		document.getElementById('questionBox' + q).innerHTML = "";
		document.getElementById('answerButton' + q).innerHTML = "";
		document.getElementById('scoreBox').innerHTML = "";
	}

	
	var n = document.getElementById('quizLength').value;

	//Permutation, randomises the order of the questions without giving duplicates
	//Made by Russell Martin, original code found here cgi.csc.liv.ac.uk/~martin/teaching/comp519/JS/permutation.html
	var p = new Array(n);  
	var i, k, temp;
	var finish = Math.pow(n,3) * Math.log(n) * 12, message = "";
		
	for (i = 0; i < n; i++)
        p[i] = i+1;
		for (i = 1; i <= finish; i++)
            if (Math.random () < 0.5)  //    flip a coin, and if "heads" swap two
                                       // randomly selected adjacent elements
               {  
                  k = Math.floor(Math.random() * (p.length - 1));
                  temp = p[k];
                  p[k] = p[k+1];
                  p[k+1] = temp;
               } 
	
	questionOrder = p.slice(0,quizLength);
  
//Iterates through the questions based on the permutation, printing the questions and the answers associated with them 
//by some radio buttons.
	for (var r = 0; r<quizLength; r++)
	{	
		document.getElementById('questionBox' + r).innerHTML = questions[p[r]];
		
		for (var j = 0; j<3; j++)
		{
		document.getElementById('answerButton' + r).innerHTML += 
			'<input type="radio" id='+j+''+r+' value="'+answers[p[r]][3]+'" name = "'+r+'"/>'
			+
			answers[p[r]][j]
			+
			'<br>'
			;
		}
	}
}

// This gets the score by matching the id with the value, the value of the box is the same as the first character of the correct answer's id
function getScore()
{
	document.getElementById('scoreBox').innerHTML = "";
	score = 0;
	
	for (var z = 0; z<document.getElementById('quizLength').value; z++)
	{
		for (var t = 0; t < 3; t++)
		{	
			var identity = "" + t + z;
			var rightAnswer = document.getElementById(identity).id.charAt(0);
			
			if ((document.getElementById(identity).checked) && (document.getElementById(identity).value == rightAnswer))
			{
				score+=1;
			}
		}
	}
	percentageScore = score/document.getElementById('quizLength').value*100;
	document.getElementById('scoreBox').innerHTML = "You scored: " + score + " out of " + document.getElementById('quizLength').value + ", that's " + Math.round(percentageScore*100)/100 +"%!";

		for (var r = 0; r<questionOrder.length; r++)
	{	
		var position = questionOrder[r];
		correctAnswer = answers[position][3];
		document.getElementById('answerButton' + r).innerHTML = "The correct answer is: " + answers[position][correctAnswer];
		
	}
}
