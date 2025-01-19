# flashcardgames_java_cli
A command-line flashcard application built in Java to strengthen my Java learning. The goal is to replicate well-known flashcard games, starting with a simplified version to ensure basic functionality works first. The project is based on my HyperSkill Flashcards projects.

## Features
- Create and store flashcards with questions and answers
- Review flashcards in sequential order
- Save flashcards to files for later use
- Load existing flashcard sets

## What I Learned

This project helped me learn:
- Java basics and OOP concepts
- Command line interface application
- File class in Java
- User input processing with Scanner
- Data persistence
- Singleton and Factory design pattern in Java

## Installation & Running 
### Option 1: Run from JAR
1. Make sure you have Java JRE 8 or higher installed on your system
2. Download the Flashcards.jar file
3. Open terminal/command prompt and run the program using java command 
   ```bash
   java -jar Flashcards.jar 
   ```


### Option 2: Build from Source
1. Make sure you have Java JDK installed
2. Clone this repository
3. Compile and run:
   ```bash
   javac -cp . ./flashcards/Main.java -d ./compiled
   ```
   ```bash
   java -cp ./compiled flashcards.Main
   ```
or Create your executable JAR file

4. create .jar
   ```bash
   jar cfm Flashcards.jar manifest.mf -C compiled flashcards
   ```
5. run the program using java command 
   ```bash
   java -jar Flashcards.jar 
   ```


- To delete all .class files 
   ```bash
   find . -name "*.class" -type f -delete
   ```

## Commands

- `add` - Create a new flashcard
- `remove` - remove a flashcard
- `import` - Save flashcards to file
- `export` - Load flashcards from file
- `ask` - Start quiz mode
- `hardest card` - Show the hardest card
- `log` - Logs all console texts to a file
- `reset stats` reset mistakes stats
- `exit` - Quit the application

## Future Improvements
- Show all flashcard questions
- Add categories for flashcards
- Add statistics tracking on mistakes
- Implement spaced repetition