    
// NAME GENERATOR 4000 HIRAGANA EDITION
 
var nameLength = 5;
var i = 0;
var name = "";
 
var alphabet = "あいうえおかきくけこさしすせそたちつてとなにぬねのはひふへほまみむめもやゆよらりるれろわをんがぎぐげござじずぜぞだぢづでどばびぶべぼぱぴぷぺぽ"; //Hiragana
while (i < nameLength)
{
var select = Math.floor(Math.random()*26 + 1);
name += alphabet.charAt(select);
i++;
}
 
document.write("<h1>" + name + "</h1>");