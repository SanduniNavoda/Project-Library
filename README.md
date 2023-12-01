# Students' Marks Management System

## Overview
<a name="overview"></a>

This Java application is designed to manage student marks for an institute. The system allows users to add new students, assign marks, update student details, and perform various other functions through a Command-Line Interface (CLI).

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [Home Page](#home-page)
  - [Add New Student](#add-new-student)
  - [Add New Student with Marks](#add-new-student-with-marks)
  - [Add Marks](#add-marks)
  - [Update Student Details](#update-student-details)
  - [Update Student Marks](#update-student-marks)
  - [Delete Student](#delete-student)
  - [Print Student Details](#print-student-details)
  - [Print Student Ranks](#print-student-ranks)
  - [Best in Programming Fundamentals](#best-in-programming-fundamentals)
  - [Best in Database Management System](#best-in-database-management-system)
- [Guidelines Followed](#guidelines-followed)

## Features

- **Add New Student.**
- **Add New Student with Marks.**
- **Add Marks.** 
- **Update Student Details.**
- **Update Students' Marks.**
- **Delete Student.**
- **View detailed student information and rankings.**
- **Identify the best-performing students in Programming Fundamentals and Database Management System.**

## Getting Started

Follow these steps to get started with the project:

### Prerequisites

Make sure you have the following prerequisites installed on your machine:

- [Java SE](https://www.oracle.com/java/technologies/javase-downloads.html) installed on your machine.
- A code editor such as [Visual Studio Code](https://code.visualstudio.com/), [IntelliJ IDEA](https://www.jetbrains.com/idea/), or [Eclipse](https://www.eclipse.org/) installed.

### Installation



1. Clone the repository to your local machine:

    ```bash
    git clone git@github.com:SanduniNavoda/Project-Library.git
    ```

2. Compile the Java application:

    ```bash
    javac MarksManagement.java
    ```

3. Run the Java application:

    ```bash
    java MarksManagement
    ```


## Usage

### Home Page

Upon running the application, a CLI home page will be displayed, allowing users to choose various options.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/21179fcf-8e3a-4d77-9629-1cd8950c1d95)



### Add New Student

To add a new student, enter the Student ID and Student Name. The system prevents adding duplicate Student IDs.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/dab268a4-e73b-4128-abed-3f1c3b5c7169)


### Add New Student with Marks

This option allows users to add both a new student and assign marks. Marks are validated to ensure they fall within the range of 0-100.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/38b1c13e-dfd7-43eb-af6a-5dd9b3e68655)


### Add Marks

If a student is added without marks, this option allows users to add marks for existing students. Validation ensures marks are within the valid range.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/283c7135-d4ab-455f-807e-324ae24632ee)


### Update Student Details

Update existing student details by entering a valid Student ID. Users can modify student names.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/39842627-731c-4427-b0bc-beec5d1b5278)


### Update Student Marks

Update previously assigned marks by providing the Student ID. Validation ensures only valid updates are accepted.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/6c39253c-73bf-4dfc-90f7-055d7480ae12)


### Delete Student

Delete a student from the system by entering the valid Student ID.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/0be36759-9343-4f1e-9a90-6170caba7551)


### Print Student Details

View detailed student information, including total marks, average marks, and rank. Users can continue seeking student details or return to the main menu.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/ecb5bfe6-af49-4282-953b-b1bd50d925b3)


### Print Student Ranks

Display a list of all students with their ranks, student IDs, names, total marks, and average marks.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/146564e7-225e-4885-bec6-d2f2862f894d)


### Best in Programming Fundamentals

Identify the top-performing student in the Programming Fundamentals module.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/d046b78c-a3b4-492d-ac5a-910e9ee627a5)


### Best in Database Management System

Identify the top-performing student in the Database Management System module.

![image](https://github.com/SanduniNavoda/Project-Library/assets/152306126/f5087d77-adb3-49ab-bf74-53816c5facd0)

## Guidelines Followed

- **Use Java arrays for data storage.**
- **Avoid external libraries or frameworks.**
- **Validate inputs and implement all specified functionalities.**
- **Clear the command line screen for better user experience.**
 






