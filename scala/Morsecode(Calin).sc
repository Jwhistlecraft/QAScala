val morseMessage:String=".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--"
val humanMesage:String="HELLO DAILY PROGRAMMER GOOD LUCK ON THE CHALLENGES TODAY"
def returnDecryptedWord(word:String)=word match{
  case ".-"=>"A"
  case "-..."=>"B"
  case "-.-."=>"C"
  case "-.."=>"D"
  case "."=>"E"
  case "..-."=>"F"
  case "--."=>"G"
  case "...."=>"H"
  case ".."=>"I"
  case ".---"=>"J"
  case "-.-"=>"K"
  case ".-.."=>"L"
  case "--"=>"M"
  case "-."=>"N"
  case "---"=>"O"
  case ".--."=>"P"
  case "--.-"=>"Q"
  case ".-."=>"R"
  case "..."=>"S"
  case "-"=>"T"
  case "..-"=>"U"
  case "...-"=>"V"
  case ".--"=>"W"
  case "-..-"=>"X"
  case "-.--"=>"Y"
  case "--.."=>"Z"
  case "-----"=>"0"
  case ".----"=>"1"
  case "..---"=>"2"
  case "...--"=>"3"
  case "....-"=>"4"
  case "....."=>"5"
  case "-...."=>"6"
  case "--..."=>"7"
  case "---.."=>"8"
  case "----."=>"9"
  case _=>" "

}

def returnEncryptedWord(word:Char)=word match{
  case 'A'=>".-"
  case 'B'=>"-..."
  case 'C'=>"-.-."
  case 'D'=>"-.."
  case 'E'=>"."
  case 'F'=>"..-."
  case 'G'=>"--."
  case 'H'=>"...."
  case 'I'=>".."
  case 'J'=>".---"
  case 'K'=>"-.-"
  case 'L'=>".-.."
  case 'M'=>"--"
  case 'N'=>"-."
  case 'O'=>"---"
  case 'P'=>".--."
  case 'Q'=>"--.-"
  case 'R'=>".-."
  case 'S'=>"..."
  case 'T'=>"-"
  case 'U'=>"..-"
  case 'V'=>"...-"
  case 'W'=>".--"
  case 'X'=>"-..-"
  case 'Y'=>"-.--"
  case 'Z'=>"--.."
  case '0'=>"-----"
  case '1'=>".----"
  case '2'=>"..---"
  case '3'=>"...--"
  case '4'=>"....-"
  case '5'=>"....."
  case '6'=>"-...."
  case '7'=>"--..."
  case '8'=>"---.."
  case '9'=>"----."
  case _=>"/"

}

def morseCodeTranslator(message:String)={
  message.split('/').flatMap(item=>item.split(' ')).map(item=>returnDecryptedWord(item)).mkString
}

def humanToMorseCode(message:String)={
  message.toCharArray.map(item=>returnEncryptedWord(item)).mkString
}

print(morseCodeTranslator(morseMessage))
print(humanToMorseCode(humanMesage))