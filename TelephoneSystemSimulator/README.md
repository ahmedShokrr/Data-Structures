
# TelephoneSystemSimulator

## Overview

This project is part of the CSE111 Data Structures course at Al Alamein International University. It simulates the operation of a telephone system for a small business. The system processes incoming calls, simulates call handling using a single-service queue, and gathers statistics about call processing.

## Features

- **Simulation of Call Handling**:
  - **Timing Loop**: Simulates each minute of real-time operation.
  - **Call Simulator**: Determines if a call is received using a random number generator.
  - **Process Active Call**: Checks if the active call is completed and gathers statistics.
  - **Start New Call**: Starts a new call if there are calls waiting in the queue.

- **Statistics**:
  - Total calls received.
  - Total idle time.
  - Total wait time.
  - Total service time.
  - Maximum queue size.
  - Average wait time.
  - Average service time.




## Usage

1. **Open the project in your IDE**:
    - Open Eclipse or your preferred IDE.
    - Import the project.

2. **Run the program**:
    - Locate the `Main.java` file in your IDE.
    - Run the `Main.java` file to execute the program.

3. **Simulation**:
    - The program will prompt for the length of service time in hours and the maximum service time for an operator.
    - Enter the required inputs to start the simulation.

## Code Structure

- `Main.java`: Contains the main method to initiate the simulation.
- `Simulator.java`: Contains the main simulation logic.
  - **Methods**:
    - `run_simulator(int serviceHours, int maxServiceTime)`: Main timing loop for the simulation.
    - `call_simulator()`: Determines if a call is received.
    - `process_active_call()`: Processes the active call and gathers statistics.
    - `start_new_call()`: Starts a new call if there are calls waiting in the queue.
    - `finalise_report_simulator()`: Generates a final report with statistics.

- `Queue.java`: Implements the Queue Abstract Data Type (ADT).
  - **Methods**:
    - `enqueue(Call call)`: Adds a call to the queue.
    - `dequeue()`: Removes a call from the queue.
    - `isEmpty()`: Checks if the queue is empty.
    - `size()`: Returns the size of the queue.



## License

This project is licensed under the MIT License.
