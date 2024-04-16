# Cron expression parser
Cron expression parser is a Java program able to parse and explain the cron expressions.

## Compiling
To compile the program you need a JDK in version 21 or newer installed on your computer.

To compile the program you need to call:

    ./gradlew build

The compiled jar will be available in `build/libs/` folder as `cron-expression-parser-1.0.jar`

## Running
### Running with Java
To run the program with Java you need a JRE in version 21 or newer installed on your computer.

To run the program you need to call:

    java -jar cron-expression-parser-1.0.jar "*/15 0 1,15 * 1-5 /usr/bin/find"

The program must be called with only one argument representing cron expression with a command string.

### Running as a Docker container
This app can also be executed as a Docker container.

To create a Docker image you can execute:

    docker build . -t domodro/cron-expression-parser

The docker image is based on alpine and uses jigsawed JRE as an execution environment.

The container can be started with:

    docker run --rm domodro/cron-expression-parser "*/15 0 1,15 * 1-5 /usr/bin/find"

The container must be started with only one argument representing cron expression with a command string.

## Output
Output is presented in the following manner:

    minute        0 15 30 45
    hour          0
    day of month  1 15
    month         1 2 3 4 5 6 7 8 9 10 11 12
    day of week   1 2 3 4 5
    command       /usr/bin/find

Each line of the output represents resolved expressions of minutes, hours, days of month, months, days of week and command.
The cron should run the command when any combination of all fields matches the time.

The expression errors are presented by the program by displaying `ERROR` message in the following format:

    ERROR: Value above range

## Using as a library

This program can also be used as the cron parsing library.

To use it as a library, add the jar to the classpath and in your program call:

    var cronLine = "*/15 0 1,15 * 1-5 /usr/bin/find";
    var cronParser = new CronParser();
    Collection<CronResult<?>> result = cronParser.parse(cronLine);

The result of calling the `CronParser#parse` is a collection of `CronResult` interface,
which consists of the `type` enum and either `String` value for command, or `List<Integer>` for other types.
