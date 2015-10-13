//Fortune Generator

var fortunes = ["Good things come to those who wait.",
				"The future is unclear, please try again.",
				"The stars align for your enemies.",
				"You will narrowly avoid misfortune.",
				"Be patient, grasshopper.",
				"New things can bring you great joy.",
				"A sparrow when fully grown, may fly the nest.",
				"A brisk walk can bring new ideas.",
				"They live. We sleep.",
				"A brisk walk can bring new ideas.",
				"The dew of the mountain can provide vigorous refreshment.",
				"He who laughs last, laughs longest.",
				"Of course, the earth is round after all."
				
				];

//Just picks out an element of the array and writes to the html file.
var select = Math.floor(Math.random()*fortunes.length);
var message = fortunes[select]; 


document.write(message);
