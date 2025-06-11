# POO-Project

# Academic Event Manager

This project is a Java object-oriented application designed to manage academic events at a university. It allows the registration of events, association of participants, certificate generation, and report issuing.

## 📁 Project Structure

```
src/
├── main/java/com/mycompany/app/
│   ├── events/         → Event types (Course, Fair, Workshop, Lecture)
│   ├── participants/   → Participant types (Student, Teacher, Outsider)
│   ├── utils/          → Helpers (CertificateUtil, ReportUtil)
│   └── main/           → Entry point (Main.java)
└── test/java/com/mycompany/app/
    └── AppTest.java    → Tests (optional)
```

## 🚀 Compilation and Execution Instructions

> ✅ This project uses **Maven** for build and execution.

### 📦 Compile the project

Run the following command in your terminal from the root of the project (where `pom.xml` is located):

```bash
mvn clean compile
```

### ▶️ Execute the project

To run the application (assuming the main class is `com.mycompany.app.main.Main`):

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.app.main.Main"
```

### 📦 Package into a JAR

To generate a JAR file:

```bash
mvn package
```

You can run the JAR like this:

```bash
java -cp target/my-app-1.0-SNAPSHOT.jar com.mycompany.app.main.Main
```

### 📄 Sample Output

The system displays a menu like this:

```
1. Create Event
2. Register Participant in Event
3. Generate Certificates
4. Report by Type
5. Report by Date
0. Exit
```

## ✅ Features

- Register various event types (Course, Workshop, Fair, Lecture)
- Register participants (Student, Teacher, Outsider)
- Restrict registration based on event rules
- Generate `.txt` certificates for each participant
- Print reports by event type and date

## 🛠️ Fulfilled Technical Requirements

- Inheritance, polymorphism, abstract classes and interfaces
- Correct use of collections and type casting
- Static methods and method overloading
- Logical package organization and modular structure
- Command-line interface (no GUI required)

## 👨‍💻 Author

Student - Guilherme Cauê Andrade Vasques
INF008 - Object-Oriented Programming  
Federal Institute of Bahia – IFBA
