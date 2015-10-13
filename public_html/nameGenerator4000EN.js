// NAME GENERATOR 4000
// Next time I update this I might overhaul it entirely, after I wrote the vowel checking part I thought of a much more elegant way of doing it. That being said it already works so I'm in no rush.
 
var nameLength = 5;
var vowelCount = 3;
var name = "";
var x = 0;
var alphabet = "abcdefghijklmnopqrstuvwxyz";
var vowels = "aeiouy"; 
var running = true;
 
var j = 0;
 
while (running)
{
        //This works perfectly, it generates the initial name.
        for (var i = 0; i < nameLength; i++)
        {
                var select = Math.floor(Math.random()*alphabet.length);
                name += alphabet.charAt(select);
        }
 
        //Checking vowel number
        for (var j = 0; j < nameLength; j++)
                {
                    for (var k = 0; k < vowels.length; k++)
                        {
						if (name.charAt(j) == vowels.charAt(k))
                            {
                                x += 1;
                            }
                        else
							{
							}
                                }
                }
       
        //Restarts if there are not enough vowels.
        if (x<vowelCount)
                {
                x = 0;
                j = 0;
                name = "";
                running = true;
                }
 
        else if (x>vowelCount)
                {
                running = false;
                }
        else
                {
                running = false;
                }
 
}
 
 
var completeName = name.charAt(0).toUpperCase() + name.slice(1);
 
document.write("<h1>" + completeName + "</h1>");// NAME GENERATOR 4000