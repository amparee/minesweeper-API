# Minesweeper-API

**Introduction**:
Develop the classic game of Minesweeper

**What we build:**

 - Design and implementation the game and the board with cells and states like isFlagged and revealed. 
  - Developed in Java 8 with Springboot and Angular 8. 
  - Ability to flag cells. 
  - Mines and flags counter. 
  - Detect when the game is over. 
  - Clock in real time.
  - Persistence the data in a mongo collection. 
  - Ability to start a new game. 
  - Ability to send parameters: number of rows, columns and mines.
  - Save game in a mongodb collection.

**Decisions:**

We start the development from the backend, generating the necessary entities with their respective attributes.
In the technical point of view we start with the architecture of the application so that the rest of the team is only responsible for adding the necessary features of features such as detecting when a game is finished and won.
We decided to perform the backend and frontend separately to decouple responsibilities and make it scalable for tomorrow.
It is also a good idea that the first customer approach is a pleasant experience.
We would have liked more time to add security, online gameplay, and most importantly, finish an amazing project.

**Tools**:

 - Java 8
 - Springboot 
 - Angular 8
 - Docker
 - Mongodb
 - Git
 - Maven


**Download the project:**

git clone git@github.com:amparee/minesweeper-API.git

# Backend

Go to backend main folder and download dependencies with maven:
mvn clean install -DskipTests

##Configure the environment variables:

|Name            |Value 
|----------------|-------------------------------
|database|mydb
|mongodburi|mongodb://localhost:27017/mydb
|host|localhost
|port|27017

Run docker with mongodb container:

    docker pull mongodb
    docker run --name some-mongo -p 27017:27017 -d mongo

Run the application:

First you have to go to folder 'backend/target/' and run the command:

    java -jar minesweeper-0.0.1-SNAPSHOT.jar

# Frontend

Go to frontend main folder and do an `npm-install`
then you can run the frontend with the command: `ng serve`

We installed a test environment in digital ocean.

You can access in the following links:

URL (dev):

dev.front.url = http://142.93.15.46/
dev.swagger.url = http://142.93.15.46:8080/swagger.html


Pablo Servile.-






# minesweeper-API
API test

We ask that you complete the following challenge to evaluate your development skills. Please use the programming language and framework discussed during your interview to accomplish the following task.

## The Game
Develop the classic game of [Minesweeper](https://en.wikipedia.org/wiki/Minesweeper_(video_game))

## Show your work

1.  Create a Public repository ( please dont make a pull request, clone the private repository and create a new plublic one on your profile)
2.  Commit each step of your process so we can follow your thought process.

## What to build
The following is a list of items (prioritized from most important to least important) we wish to see:
* Design and implement  a documented RESTful API for the game (think of a mobile app for your API)
* Implement an API client library for the API designed above. Ideally, in a different language, of your preference, to the one used for the API
* When a cell with no adjacent mines is revealed, all adjacent squares will be revealed (and repeat)
* Ability to 'flag' a cell with a question mark or red flag
* Detect when game is over
* Persistence
* Time tracking
* Ability to start a new game and preserve/resume the old ones
* Ability to select the game parameters: number of rows, columns, and mines
* Ability to support multiple users/accounts
 
## Deliverables we expect:
* URL where the game can be accessed and played (use any platform of your preference: heroku.com, aws.amazon.com, etc)
* Code in a public Github repo
* README file with the decisions taken and important notes

## Time Spent
You do not need to fully complete the challenge. We suggest not to spend more than 5 hours total, which can be done over the course of 2 days.  Please make commits as often as possible so we can see the time you spent and please do not make one commit.  We will evaluate the code and time spent.
 
What we want to see is how well you handle yourself given the time you spend on the problem, how you think, and how you prioritize when time is insufficient to solve everything.

Please email your solution as soon as you have completed the challenge or the time is up.
