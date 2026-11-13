# Spring Boot GPT Chatbot (PoC)

A proof-of-concept REST API built with **Spring Boot** that connects to a GPT model (OpenAI API) to power a simple conversational chatbot.

## Overview

This project shows how to integrate a Large Language Model into a Spring Boot backend. A client sends a message to the API, the service forwards it to the GPT model, and the generated reply is returned as the response.

> **Status:** Proof of Concept. It is intended for learning and experimentation, not production use.

## Features

- REST endpoint to send prompts and receive GPT-generated responses
- Integration with the OpenAI Chat Completions API
- Externalized configuration for the API key and model settings
- Lightweight, easy-to-extend Spring Boot structure

## Tech Stack

- Java 17+
- Spring Boot
- Maven
- OpenAI GPT API

## Project Structure

```
com.josamtechie.api
└── SpringbootGptChatbotApplication   # Application entry point
```

## Getting Started

### Prerequisites

- JDK 17 or later
- Maven 3.8+
- An OpenAI API key

### Configuration

Add your settings to `src/main/resources/application.properties`:

```properties
openai.api.key=YOUR_API_KEY
openai.model=gpt-4o-mini
```

Prefer an environment variable so the key is never committed:

```bash
export OPENAI_API_KEY=your_api_key_here
```

### Run the Application

```bash
mvn spring-boot:run
```

The server starts on `http://localhost:8080` by default.

### Example Request

```bash
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{"message": "Hello, who are you?"}'
```

## Roadmap

- Conversation history and context handling
- Streaming responses
- Error handling and rate-limit management
- Simple web UI for chatting
- Authentication and request validation

## Disclaimer

This is a PoC and has not been hardened for security or scale. Never commit API keys to version control.

## Author

**josamtechie**
