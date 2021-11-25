# Object Bootcamp

## How to import this project on IntelliJ

Go to `File` > `Open...` > (navigate to `build.gradle`) > `Open` > `Open as Project` > check `Use auto-import` > `Ok` > voilà!

## How to run tests

There are multiple ways you can do it. If you wanna run all tests at once from the command line, open up a terminal, navigate to this project's root folder and issue `./gradlew clean test`.

You can do the same on IntelliJ. Open up the `Project` tab (Command+1) > right click the `src/test/java` folder > `Run 'All Tests'`.

Or you can just right click an individual test class and then `Run` it.

# TODO List

1) I can close the parking lot when it has less than 20% usage

2) One lot reopen when all other lots they own and are open have usage more than 75%

3) If I own only one lot, don't close

4) assistant can only park on open lots

5) assistant park large cars in the parking lot with the least % of usage