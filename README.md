# 🏥 E-HealthCare Management System (Java, Swing, MySQL)

## 📌 Objective
The **E-HealthCare Management System** is a Java-based desktop application designed to simplify hospital operations for **Admins**, **Doctors**, and **Patients**.  
It integrates **database management**, **appointment booking**, and **email verification** into a user-friendly GUI, ensuring smooth healthcare workflow.

---

## ✨ Features

### 👨‍💼 Admin
- Manage doctors, patients, and appointments
- Edit or remove any user
- Add new appointments
- Update hospital records

### 🩺 Doctor
- Register and manage their profile
- View and edit assigned appointments
- Access personal dashboard

### 👨‍⚕️ Patient
- Register and log in
- Book appointments
- Pay for appointments
- Edit profile and change password
- Two-step email verification for secure signup

---

## 🔄 Workflow
1. **Signup Selection Page** – User chooses to register as Doctor, Patient, or Admin.
2. **Registration & Verification** – Email verification using **javax.mail** and 2-step authentication.
3. **Login Page** – Secure authentication with database validation.
4. **Role-Specific Dashboard** – Access features based on user role.
5. **Database Connection** – All user data, appointments, and transactions are stored in **MySQL** via `mysql-connector-java`.
6. **GUI** – Designed using **Java Swing (javax)** with manual layout (x, y coordinates).
7. **Supporting Tools** – GUI planning via **draw.io**, local DB management via **XAMPP**.

---

## 🛠 Technologies Used
- **Java SE** (Core Java)
- **Java Swing (javax)** for GUI
- **MySQL** with **XAMPP**
- **JavaMail API** for SMTP email verification
- **jcalendar-1.4.jar** for date picking
- **mysql-connector-java-8.0.29.jar** for DB connectivity

---

## 🚀 How to Run

### **1. Installing Java**
1. Download **Java JDK** (version 8 or later) from:  
   🔗 [https://www.oracle.com/java/technologies/javase-downloads.html](https://www.oracle.com/java/technologies/javase-downloads.html)
2. Install the JDK by following the on-screen instructions.

---

### **2. Setting Environment Variables (Windows)**
1. Press **Windows + S** → Search for **"Environment Variables"** → Open **"Edit the system environment variables"**.
2. Click **Environment Variables…**.
3. Under **System variables**, select **Path** → **Edit** → **New**.
4. Add the JDK `bin` path (example):  C:\Program Files\Java\jdk-17\bin
   
### **3. Prerequisites for the Project**
- Install **XAMPP** (MySQL + Apache)
- Required `.jar` files (place them in the project folder):
  - `jcalendar-1.4.jar`
  - `javax.mail.jar`
  - `mysql-connector-java-8.0.29.jar`

---

### **4. Database Setup**
1. Start **XAMPP** and enable **Apache** and **MySQL**.
2. **Restoring `ibdata1` (Important for Database to Work)**  
   ⚠ **Warning:** Without this, MySQL will not recognize the tables.  
   - Stop **MySQL** service from XAMPP.  
   - Navigate to your MySQL data folder (e.g. `C:\xampp\mysql\data`).  
   - **Backup your existing `ibdata1`** (rename or move it).  
   - Place the provided `ibdata1` file into the `data` folder.  
   - Ensure the corresponding database folder (with `.frm` and `.ibd` files) is also in `data`.  
   - Restart MySQL in XAMPP.
3. Open **phpMyAdmin** to verify that the database tables are loaded.
4. Update your Java code's DB connection details if needed.

---

### **5. Running the Application Using CMD**
1. Open **Command Prompt**.
2. Navigate to the project folder:
   ```bash
   cd path\to\project
   
## 📩 Contact
**Authors:**
- Md Tamjid Hossain  
- Wasif Asad Alvi  
📧 **Email:** tamjid621@gmail.com

