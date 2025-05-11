# 📘 School Vaccination Portal

## 👨‍🏫 Project Overview

This web-based application is designed for school coordinators to manage vaccination efforts. It provides functionalities to add and manage students, schedule and update vaccination drives, monitor vaccination statuses, and generate reports.

**Tech Stack:**

* **Backend:** Spring Boot (Java), PostgreSQL
* **Frontend:** React.js
* **Data Exchange:** REST API (JSON)

---

## 🧱 Architecture Overview

```
Frontend (React)
    ↕ REST API calls (Axios)
Backend (Spring Boot)
    ↕ JPA Repositories
Database (PostgreSQL)
```

---

## 🔐 Simulated Authentication

* Authentication is mocked. On app load, users are assumed to be logged in as the school coordinator.

---

## 📊 Features Implemented (User Stories)

### 1. Dashboard

* Metrics: total students, vaccinated students, vaccination rate
* Upcoming drives (within 30 days)
* Graceful message if no drives are available

### 2. Student Management

* Add individual students
* Bulk upload via CSV (`name,studentClass` headers)
* Search by name/class
* Mark students as vaccinated

### 3. Vaccination Drives

* Create new drive with validation (at least 15 days in future)
* Prevent overlapping drives (on same date)
* Edit future drives only
* Display upcoming drives

### 4. Reports

* List of all vaccination records
* Filtered by vaccine type (optional)
* Download report as CSV
* Table with pagination (frontend-controlled)

---

## 🧪 API Endpoints

### Students

* `GET /api/students` – List all students
* `POST /api/students` – Add one student
* `POST /api/students/bulk` – Bulk upload
* `PUT /api/students/{id}/vaccinate` – Mark vaccinated

### Drives

* `GET /api/drives/upcoming` – Drives within 30 days
* `POST /api/drives` – Create new drive
* `PUT /api/drives/{id}` – Edit drive

### Records

* `GET /api/records` – List all vaccination records
* `POST /api/records` – Create vaccination record

### Dashboard

* `GET /api/dashboard/summary` – Summary metrics & upcoming drives

---

## 🧾 Database Schema

### Student

* `id`: Long
* `name`: String
* `studentClass`: String
* `vaccinated`: boolean

### VaccineDrive

* `id`: Long
* `vaccineName`: String
* `date`: LocalDate
* `dosesAvailable`: int
* `applicableClasses`: String

### VaccinationRecord

* `id`: Long
* `student`: FK to Student
* `drive`: FK to VaccineDrive
* `dateOfVaccination`: LocalDate

---

## 🛠 Setup Instructions

### Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

Ensure PostgreSQL is running and configured in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vaccination_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
```

Create database:

```sql
CREATE DATABASE vaccination_db;
```

### Frontend (React)

```bash
cd frontend
npm install
npm start
```

Ensure `proxy` is added in `frontend/package.json`:

```json
"proxy": "http://localhost:8080"
```

---

## 🖼️ Output Screenshots (To Include)

* Dashboard metrics and drive list
* Student list with vaccination status
* CSV upload interface
* Vaccination report table with download button

---

## 📹 Demonstration Video

Include a screencast showing:

* Adding students (manual + CSV)
* Creating and editing a drive
* Vaccinating students
* Dashboard summary
* Report export

---

## 🔗 GitHub Repository Structure

```
backend/         # Spring Boot app
frontend/        # React app
README.md        # This file
```

---

## ✅ Assumptions

* Only one vaccination record per student per vaccine drive is allowed
* CSV upload expects exact headers: `name`, `studentClass`
* Authentication is simulated (not secure, for demo purposes)

---

## 📌 References

* React Docs: [https://react.dev](https://react.dev)
* Spring Boot Docs: [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
* PostgreSQL Docs: [https://www.postgresql.org/docs/](https://www.postgresql.org/docs/)
* PapaParse CSV Parser: [https://www.papaparse.com/](https://www.papaparse.com/)

---

## 📥 Submission Checklist

* [x] All user stories implemented
* [x] Full-stack integration tested
* [x] GitHub repo updated
* [x] Demo video recorded
* [x] Documentation and screenshots ready for LMS upload

---

✅ All requirements from the assignment document have been covered.

Contact: [akshaya.ganesan@pilani.bits-pilani.ac.in](mailto:akshaya.ganesan@pilani.bits-pilani.ac.in)

---

**End of Documentation**
