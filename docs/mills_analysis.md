# Mill-Refactoring

## Todos ordered by classes
1. Main-Class:
   1. Imagebackground, backgroundsize, backgroundimage, background saving relocate to new class
   2. Root, Scene relocate to new class

2. Controller-Class: 
   1. Remove showRulesFromInfo() 
   2. feedback() rename to showMessageBox()
   3. for loops with magic numbers

3. Node-Class:
   1. Member have German/English name &rarr; change to english 
   2. Some setters are pointless (there is additionally a private setter) &rarr; remove them
   3. Some Member of Class need final-keyword (such as ID)

4. GameField-Class:
   1. Image Object with selected and not selected state
   2. Include ImageObject in Player
   3. setToken_phase1 reduce duplicate code
   4. rename function "feedback"
   5. functions: "feedback" does the same as "messageBox"

5. Player-Class:
   1. color to enum -> can only be black or white

## General stuff 
* In general naming convention of variables/functions
* usage of enums instead of strings in comparissons
* getter and setter for public objects