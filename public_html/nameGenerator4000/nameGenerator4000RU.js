// NAME GENERATOR 4000 RU EDITION
 
var nameLength = 5;
var i = 0;
var name = "";
 
var alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
 
while (i < nameLength)
{
var select = Math.floor(Math.random()*26 + 1);
name += alphabet.charAt(select);
i++;
}
var completeName = name.charAt(0).toUpperCase() + name.slice(1);;
 
document.write("<h1>" + completeName + "</h1>");