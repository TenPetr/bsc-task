# BSC Homework for the backend by Petr Jelínek

### Running a program
- If you have an IDE (IDEA, Eclipse), you can run it directly from there. Basically, you can
just clone this project from GitHub and open it in for example IDEA, and all Gradle dependencies
should automatically download and configure.
Then, you simply hit the "play" button and program is up and running. 

- If you want to try passing file as a command line argument,
then go to the `Run settings > Edit configuration > Program arguments` and pass name _(initial-resources.txt)_ of the file
(I provided test file located in the root-level resources' folder)

### How it works?
Let me just briefly describe my code here. 

**Main**
 - This is main entry point of the application. First, I check, if user passed any files as an initial
packages, if so, I process them in the PackageUtils class.
- If not, I ran background printing method and then start loop, which takes user's input.

**PackageUtils**
- In this class, I put all methods and utils associated with the package processing itself. 
- Method `saveUsersInput()` collects user's inputs, validate them and format them.
- When user enter "quit" keyword, whole program will exit. 
- After successful validation, I convert it into a PackageInfo DTO and update or create
entry inside of the package map, which is key-value structure.
- If package with the postalCode already exists, it adds new weight to the existing, if not,
it will create new entry in the map.
- After each new entry, sort method is called to sort map descending by weight. 
- If the method `loadInitialPackages()` is called, it will basically load the file and check for every
line, if the format is correct. If so, it will convert it into DTO and then save to the map and sort it.

**PackageValidator**
- In this method, I am validation inputs by entered directly by users or from a file. I tried to 
implement as many validation rules as possible to avoid users from entering malicious inputs.

**PackagePrinter**
- This class contains method, which returns TimerTask, which runs in the background. I set it up as you wished,
every 60 seconds, it prints every package formatted by postal code and sorted by weight.

**PackageConvertor**
- In this class I simply convert raw input into PackageInfo DTO.

**PackageInfo**
- This is a model class. (I could also use some library for generating getters, setters etc.)

**Unit Tests**
- I also tested most of my classes with unit tests. I am aware of not testing `PackageUtils` class.
This class is not very well testable, and if I would have more time, I would refactored it.

## Conclusion
I know, that there are few not very well solved problems, but since I did not have much time,
I used solutions that could be replaced by better ones. Anyway, task was really cool, and I enjoyed
every minute of it, and I am looking forward for your feedback.