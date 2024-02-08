
# Card Game Service

Author: Roshan Adhikari

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Building the Application](#building-the-application)
  - [Running the Application](#running-the-application)
- [Usage](#usage)
  - [Endpoints](#endpoints)
  - [Sample Requests](#sample-requests)
- [Assumptions](#assumptions)


## Introduction

The Card Game Service is a RESTful API for managing card decks within game sessions. It provides endpoints for dealing, shuffling, and returning cards from the deck. This README provides instructions on how to build and run the application.

## Getting Started

### Prerequisites

Before running the application, make sure you have the following prerequisites installed:

- Java 17 or higher
- Maven (for building the application)

### Building the Application

1. Clone the repository to your local machine:

   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory:

   ```bash
   cd card-game-service
   ```

3. Build the application using Maven:

   ```bash
   mvn clean install
   ```

### Running the Application

Once the application is built, you can run it using the following command:

```bash
java -jar target/card-game-service-<version>.jar
```

Replace `<version>` with the actual version of the JAR file generated during the build process.

## Usage

### Endpoints

The Card Game Service exposes the following endpoints:

- `GET /api/v1/games/create`: Creates a new deck.
- `GET /api/v1/games/{sessionId}/deck/deal`: Deals a card from the deck.
- `POST /api/v1/games/{sessionId}/deck/shuffle`: Shuffles the deck.
- `POST /api/v1/games/{sessionId}/deck/return`: Returns a card to the deck.

### Sample Requests

#### Create a new deck

To create a new deck, send a POST request to the following endpoint:

```
GET /api/v1/games/create
```

#### Deal a Card

To deal a card from the deck, send a GET request to the following endpoint:

```
GET /api/v1/games/{sessionId}/deck/deal
```

Replace `{sessionId}` with the actual session ID.

#### Shuffle the Deck

To shuffle the deck, send a POST request to the following endpoint:

```
POST /api/v1/games/{sessionId}/deck/shuffle
```

Replace `{sessionId}` with the actual session ID.

#### Return a Card

To return a card to the deck, send a POST request to the following endpoint:

```
POST /api/v1/games/{sessionId}/deck/return
```

Replace `{sessionId}` with the actual session ID and provide the card details in the request body.

## Assumptions

- A new game is created every time the application is restarted/re-run.
- Create initializes a new deck
- If there are no decks the deal, shuffle and return will not work
- Deal returns a card from the top of the deck
- Shuffle re-arranges the deck 
- Return pushes non-duplicate cards to the deck
- The application assumes that valid session IDs are provided for all operations.
- The deck is automatically initialized and shuffled upon creation.
- The Card Game Service uses RESTful conventions for API endpoints and error responses.
- Errors are handled using `ResponseStatusException` to ensure consistent HTTP status codes and messages.

