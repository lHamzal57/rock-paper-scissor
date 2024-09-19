# Coding Interview: Rock Paper Scissors

## The Task

Write a program that plays multiple rounds of Rock, Paper, Scissors (https://en.wikipedia.org/wiki/Rock-paper-scissors) and shows the final results of the game.The code should at least provide the minimal functional requirements listed below, have high test coverage and adhere to common clean code rules. 

Minimal functional requirements:
* One player should always play randomly, the other should always choose rock. No user interaction should be required (i.e. no reading from stdin and waiting for a user interaction)
* The application should play 100 rounds of the game
* The application should evaluate the game logic, i.e. the result (e.g. WIN, DRAW, LOSE) of two actions (e.g. ROCK, PAPER, SCISSOR) competing against each other
* The application should calculate at least the number of wins for each player and the number of draws.
 
The output of the program should be like the following:

```
"Player A wins 31 of 100 games"
"Player B wins 37 of 100 games"
"Draws: 32 of 100 games"
```

---------------------

## Building the Docker Image

To build the Docker image for this application, navigate to the project directory where the `Dockerfile` is located and run the following command:

```bash
docker build -t rock-paper-scissor .
```
Once the Docker image is built, you can run the application inside a Docker container using the following command:

```bash
docker run --rm rock-paper-scissor
```
> --rm: This flag automatically removes the container after it exits, keeping your environment clean.