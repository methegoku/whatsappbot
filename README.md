#  WhatsApp Chatbot Backend

A Spring Boot backend service designed for a WhatsApp chatbot that responds to user messages, stores chat logs in Firebase Firestore, and is deployed on Render.

P.S. I have created only the backend of the project. We can Intergrate this project with Whatsapp Buisness as it will be added in the future (as I am learning it.)

---

##  Features

-  Java Spring Boot backend for chatbot logic
-  Firebase Firestore integration for message logging
-  RESTful webhook endpoint (`/webhook`)
-  Deployed using Docker on Render
-  Lightweight, fast, and beginner-friendly architecture

---

##  Tech Stack

| Layer          | Tech Used                |
|----------------|--------------------------|
| Language       | Java (JDK 17)            |
| Framework      | Spring Boot              |
| Database       | Firebase Firestore       |
| Deployment     | Render + Docker          |
| Dependency Mgmt| Maven                    |
| JSON Parsing   | Jackson / Gson           |

---

##  API Usage

### POST `/webhook`
- Used to receive and respond to incoming messages.
- In Postman. select POST request as copy and paste the JSON format in the body
  
####  Request JSON:
```
{
  "from": "user_phone_number",
  "message": "hi"
}
```
###  Response:

Welcome to Jarurat Care! Type 1 for Services, 2 for Contact Info

---

## How to Run this Project?
- First download the project as Zip.
- Then open in any code editor you like.
- Make sure that you add your JSON private key `Firebaseconfig.java`. For detailed explanation check the file
- Inorder to store the data into the database, create a `Firestone` collection in Firebase.
- Then run the code. Boom! you have your backend of Whatsapp bot.

---
##  Predefined Commands

| User Input  | Bot Response                                                           |
|-------------|------------------------------------------------------------------------|
| hi          | Welcome to Jarurat Care! Type 1 for Services, 2 for Contact Info       |
| 1           | We offer health checkups, medicine delivery, and home care services.   |
| 2           | You can reach us at +91-1234567890 or care@jarurat.com                 |
| other input | Sorry, I didn't understand that. Please type 1 or 2.                   |

---

##  Firebase Setup (Environment Variable)
###  Add to Render:
- Go to your Render service dashboard
- Set environment variable:

| ENV NAME            | Private Key (JSON Content)                                   |
|---------------------|--------------------------------------------------------------|
| FIREBASE_CONFIG     | {your minified firebase-service-account JSON content} |


- Make sure that you Minify the JSON file using https://jsonformatter.org/json-minify 
- Redeploy with Clear Cache

---

##  Example Firebase Entry
```
{
  "from": "user_number",
  "message": "1",
  "reply": "We offer health checkups...",
  "timestamp": "2025-06-21"
}
```
--- 

## If you heav any doubts or suggestions, you can contact me..!
- 📧 gokulelumalai46@gmail.com
- 🌐 https://www.linkedin.com/in/gokul-elumalai-12a203267/

--

## License
This project is for educational and internal assessment use only. Not for commercial distribution.

