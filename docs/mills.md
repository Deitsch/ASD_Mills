# Mill-Refactoring
1. Main-Class:
   1. Imagebackground, backgroundsize, backgroundimage, background saving relocate to new class
   2. Root, Scene relocate to new class

2. Controller-Class: 
   1. Remove showRulesFromInfo() 
   2. feedback() rename to showMessageBox()
   3. 

3. Node-Class:
   1. Member have German/English name &rarr; change to english 
   2. Some setters are pointless (there is additionally a private setter) &rarr; remove them
   3. Some Member of Class need final-keyword (such as ID)

4. In general naming convention of variables/functions