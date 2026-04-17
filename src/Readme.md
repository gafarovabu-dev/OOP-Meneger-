# Proposal Management System

## 👤 Student

Name: *[Gafarov Abdumalik]*
Course: Object-Oriented Programming (OOP)

---

## 📌 Description

This project is a **console-based Proposal Management System** developed in Java.
It allows users to create, view, update, delete, and manage project proposals.

The system also supports:

* Data persistence using files
* Import and export using CSV
* Input validation and error handling

---

## 🎯 Objectives

The main objectives of this project are:

* Apply Object-Oriented Programming principles
* Implement CRUD operations
* Work with file handling in Java
* Build a user-friendly command-line interface
* Demonstrate encapsulation, inheritance, and polymorphism

---

## ✅ Project Requirements

The system implements the following requirements:

1. CRUD operations (Create, Read, Update, Delete)
2. Command Line Interface (CLI)
3. Input Validation (email, empty fields, ID checks)
4. Data Persistence (saving to file)
5. Modular Design (separate classes and methods)
6. Documentation (this README file)
7. Error Handling (try-catch for safe execution)
8. Encapsulation (private fields + getters/setters)
9. Inheritance (Person → Proposal)
10. Polymorphism (method overriding display())

---

## 🧱 Project Structure

* `Main.java` → Main program logic and menu
* `Proposal.java` → Proposal class (data and methods)
* `Person.java` → Parent class (inheritance)
* `proposals.txt` → Data storage file
* `export.csv` → Exported data file

---

## ⚙️ Features

* Add new proposal
* View all proposals
* Update proposal by ID
* Delete proposal by ID
* Save data automatically to file
* Load data on program start
* Export data to CSV file
* Import data from CSV file

---

## 🧠 OOP Concepts Used

### 🔒 Encapsulation

Fields are private and accessed using getters and setters.

### 🧬 Inheritance

`Proposal` class extends `Person`.

### 🔄 Polymorphism

The `display()` method is used to show proposal details.

---

## 💾 Data Persistence

* Data is stored in `proposals.txt`
* Automatically saved when the program exits
* Automatically loaded when the program starts

---

## 🔁 Import / Export

* Export: saves data to `export.csv`
* Import: loads data from `export.csv`

---

## 🧪 Test Cases

### Test 1: Add Proposal

Input:
ID: 1
Title: Test
Email: [test@gmail.com](mailto:test@gmail.com)

Output:
Proposal added successfully

---

### Test 2: Invalid Email

Input:
Email: abc

Output:
Invalid email

---

### Test 3: Duplicate ID

Input:
ID: 1 (already exists)

Output:
ID already exists

---

### Test 4: Update Proposal

Input:
ID: 1

Output:
Updated successfully

---

### Test 5: Delete Proposal

Input:
ID: 1

Output:
Deleted successfully

---

## ⚠️ Challenges Faced

* Handling file input/output
* Preventing program crashes from invalid input
* Implementing validation correctly
* Managing data import/export

---

## 🚀 How to Run

1. Open the project in IntelliJ IDEA
2. Run `Main.java`
3. Use the menu to interact with the system

---

## 📸 Screenshots

![import.png](../../Log/import.png)
![export.png](../../Log/export.png)
![delet.png](../../Log/delet.png)
![update.png](../../Log/update.png)
![view.png](../../Log/view.png)
![меню.png](../../Log/%D0%BC%D0%B5%D0%BD%D1%8E.png)
## 🔗 Presentation

https://drive.google.com/drive/folders/1feJgi2bJk72GyBcdXwOw1YxlGeZFhbRR?usp=drive_link

---
