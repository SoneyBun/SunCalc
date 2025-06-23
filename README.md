# 🚨 SUNCALC V2 IS OUTDATED AND WILL BE REPLACED BY V3 IN UPCOMING MONTHS



# SunCalc 2

SunCalc is a Reverse Polish Notation (RPN) calculator developed in Java. Unlike standard calculators, it requires operators to be placed after their operands, offering a unique approach to mathematical computations.

## Features

- **Reverse Polish Notation (RPN):** Input expressions where operators follow their operands. For example:
  ```
  2 2 +
  ```
  This yields:
  ```
  2.0 + 2.0 = 4.0
  ```

- **Comprehensive Function Support:** Includes trigonometric functions, factorials, and a library of irrational numbers.
- **Health Utilities:** Features like BMI Calculator and Height Estimation are accessible by typing `health`.
- **Session Management:** Utilizes `ans` and `ans2` to store previous results for use in subsequent calculations.
- **Exit Functionality:** Type `esc` or `escape` to terminate the program gracefully.
- **Help Feature:** Type `help` in order to get a prompt to join the discord server.

## Getting Started

### Prerequisites

- Ensure you have the Java Development Kit (JDK) installed on your system.

### Installation

1. **Clone the Repository:**
   ```
   git clone https://github.com/SoneyBun/SunCalc.git
   ```
2. **Navigate to the Directory:**
   ```
   cd SunCalc
   ```
3. **Compile the Program:**
   ```
   javac Main.java
   ```
4. **Run the Program:**
   ```
   java Main
   ```

## Usage

Upon running, SunCalc enters an interactive mode. Input your RPN expressions directly. For example:
```
> 5 3 -
```
This yields:
```
5.0 - 3.0 = 2.0
```

To access health-related features, type:
```
> health
```

To exit the program, type:
```
> esc
```

For help on the calculator, type:
```
> help
```

## Developers

- **SoneyBun:** Lead developer responsible for core functionalities.
- **Skeledan:** Contributor focusing on feature enhancements.

Join our community on Discord for discussions and updates.
