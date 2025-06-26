# 📚 VG-MS Educational Levels

VG-MS Educational Levels is an academic software project developed by students at CETPRO Valle Grande as part of their Social Responsibility course. It aims to digitize educational levels and provide a structured, scalable, and user-friendly platform for managing educational data, supporting digital transformation in educational institutions.

## 🔧 Tech Stack
| Layer     | Technology                          |
|-----------|-------------------------------------|
| Backend   | Java 17 (OpenJDK), Spring Boot + WebFlux |
| Frontend  | React (Vite/CRA recommended)        |
| Database  | MongoDB (NoSQL), PostgreSQL (Relational) |
| DevOps    | GitLab CI/CD, Docker (optional), Firebase (planned) |

## ✅ Project Objectives
- Modernize the management of educational levels across institutions.
- Offer a web platform with real-time access to data.
- Empower students to work with real-world tech stacks.
- Foster collaborative development and technical documentation skills.

## 🚀 Getting Started

### 🔁 Clone the Repository
```bash
git clone https://gitlab.com/vallegrande/as231s5_prs2/vg-ms-educational_levels.git
cd vg-ms-educational_levels

###⬆️ Push Your Local Repo (If You Already Have One)
```bash
cd existing_repo
git remote add origin https://gitlab.com/vallegrande/as231s5_prs2/vg-ms-educational_levels.git
git branch -M main
git push -uf origin main


###🛠️ Project Setup
```bash
Backend (Spring Boot + WebFlux)
cd backend
./mvnw clean install
./mvnw spring-boot:run

```bash
Requirements
Java 17+
Maven 3.8+
MongoDB/PostgreSQL instance running

Frontend (React)
cd frontend
npm install
npm start

🔐 Environment Configuration
Create a .env file in the backend root directory with:
MONGODB_URI=mongodb+srv://<user>:<password>@cluster.mongodb.net/dbname
POSTGRES_URL=jdbc:postgresql://localhost:5432/dbname
JWT_SECRET=your_secret_key
✅ CORS must be enabled in the backend to allow React frontend to connect.

📁 Repository Structure
vg-ms-educational_levels/
├── backend/          # Java Spring Boot REST API
│   └── src/
├── frontend/         # React app
│   └── src/
├── docs/             # Technical diagrams, database schema, etc.
├── .env.example      # Sample environment config
├── .gitlab-ci.yml    # GitLab CI/CD pipeline
├── CONTRIBUTING.md   # How to contribute
└── README.md         # This file

🧩 Application Usage
Run backend and frontend.
Navigate to http://localhost:3000.
Register as a new user.
View, add, edit, or delete educational levels.
Use the “Contact Us” form to send suggestions or report bugs.

🧪 Testing & Code Quality
Backend: JUnit 5, Mockito
Frontend: React Testing Library, Jest
Run linters and tests before pushing code:

### Backend
./mvnw test
./mvnw checkstyle:check

### Frontend
npm run lint
npm test

🌐 CI/CD Pipeline (GitLab)
Auto-run tests on every push
Linting and test coverage reports
Deploy to staging (Firebase planned)
Manual approval required for production

🔭 Roadmap
Feature	Status
Authentication with roles (admin/user)	 ✅ In progress
Firebase Hosting integration	           🔜 Planned
Dashboard with education stats	         🔜 Planned
REST API documentation (Swagger)	       ✅ Completed
Responsive mobile layout	               ✅ Completed
Multilingual support (i18n)	             🔜 Planned
PostgreSQL integration	                 ✅ Completed
Docker support	                         🔜 Planned

🤝 Contributing
We welcome collaboration! Follow these steps:
Fork the repository.

Create a new feature branch:
git checkout -b feature/my-new-feature

Make your changes, write tests, and commit:
git commit -m "Add feature: description"

Push and open a Merge Request:
git push origin feature/my-new-feature

Add Fixes #<issue-number> in your MR description when solving issues.

🧑‍💻 Authors & Credits
Developed by students of CETPRO Valle Grande
Mentored by the Social Responsibility Program
Special thanks to instructors and code reviewers

📜 License
This project is licensed under the MIT License — see the LICENSE file for details.

📞 Support & Contact
📩 Open an issue on GitLab
💬 Join our WhatsApp Support Group
📧 Contact instructors via institutional email

📊 Project Status
🟢 Active Development
🔄 Last updated: June 2025
🚀 Current version: v1.0-alpha
🧠 Next release: v1.1 (Beta) — Q3 2025
