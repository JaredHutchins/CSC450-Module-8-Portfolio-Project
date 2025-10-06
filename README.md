# CSC450 Week 8 – Final Portfolio Project: Fallout RAD Countdown

## What This Is

This repo contains my Week 8 CSC450 Final Portfolio Project. It's a Java console program that demonstrates basic concurrency using two threads in a Fallout-themed simulation.

## What's Inside

- FalloutCountdown.java – The Java program  
- README.md
- .gitignore

## Key Features

- Simulates radiation exposure followed by an antidote cooldown using two threads  
- Thread 1 (Radiation Phase) counts up from 1 to 10  
- Thread 2 (Recovery Phase) begins only after exposure ends, counting down from 10 to 0  
- Uses Java's Thread class and join() for sequencing  
- Console output is styled around Fallout theming for clarity and immersion

## How to Run

Compile:
```
javac FalloutCountdown.java
```

Run:
```
java FalloutCountdown
```

## Created By

Jared Hutchins