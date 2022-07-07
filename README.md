## Knight Moves
My solution uses a Breadth-first Search approach for finding the shortest path to the destination. I've already compiled the jar file and included it so that it can be run from the root directory via the following command:

`java -jar ./build/libs/knight_moves-1.0-SNAPSHOT.jar`.

You will be prompted to enter the board size, source coordinates, and destination coordinates. They should be comma separated but without spaces since I did not include any input sanitization or validation. Sample input/output is shown below.

If you wish to compile yourself before running the jar, you can do so via gradle using the following command:

`./gradlew clean build`

The compiled jar file will be found in the `build/libs/` directory.

### Sample Input/Output
```shell
davidkelly@WF18135 knight_moves % java -jar ./build/libs/knight_moves-1.0-SNAPSHOT.jar
Enter Board Size (x,y): 10,10
Enter Source Coordinates (x,y): 4,5
Enter Destination Coordinates (x,y): 3,2
(4, 5) -> (5, 3) -> (3, 2)
Step count: 2
davidkelly@WF18135 knight_moves % 
```

