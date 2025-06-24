📚 VG-MS Educational Levels

An academic project developed by students at CETPRO Valle Grande as part of their Social Responsibility course. Its objective is to digitize educational levels and facilitate access to structured data using modern technologies.

🔧 Stack Tecnológico

Backend: OpenJDK 17/Springboot/WebFlux
Frontend: React
Database: MongoDB/posgtres
DevOps: GitLab CI/CD for continuous integration and automatic deployment

✅ Project Purpose

This project seeks to promote digital transformation in educational institutions by developing a platform that manages and visualizes the different levels of education available, contributing modern tools to improve internal processes.

🚀 Getting Started

Clone the repository
git clone https://gitlab.com/vallegrande/as231s5_prs2/vg-ms-educational_levels.git

Upload your local project (if you already have one)
cd existing_repo
git remote add origin https://gitlab.com/vallegrande/as231s5_prs2/vg-ms-educational_levels.git
git branch -M main
git push -uf origin main

🧩 Using the Application
Make sure you have the backend and frontend running.
Go to http://localhost:4200.
Register as a user to start managing educational levels.
Send your suggestions in the "Contact Us" section.

🛠️ Project Configuration
Backend
cd backend
./mvnw spring-boot:run

Frontend
cd frontend
npm install
ng serve

🔐 Environment Variables (Deployment)
Configure the .env file with the following variables:
MONGODB_URI=your_mongodb_uri
JWT_SECRET=your_jwt_secret_key

🛡️ Note: Make sure to enable CORS on the backend to allow frontend access.
To deploy:
npm run build
Then, upload the contents of the dist/ folder to the production server.

📁 Repository Structure
/vg-ms-educational_levels
├── backend/ # REST API with Spring Boot
├── frontend/ # Angular application
├── README.md # This document
├── CONTRIBUTING.md # Contributing guidelines
├── .env.example # Environment variables
└── docs/ # Technical documentation and diagrams

💡 Best Practices
Write unit tests (JUnit for the backend, Jasmine/Karma for the frontend)
Document each REST endpoint
Use mvn clean and npm run lint before each commit

🔭 Roadmap
Add authentication with roles (admin/user)
Integration with Firebase Hosting
Dashboard with usage graphs by educational level
Internationalization (i18n)

🤝 Contributions
We're open to improvements!
Fork the repository
Create a new branch:
git checkout -b feature/your-feature-name

Make your changes and test
Open a Merge Request with a clear description
Use Fixes #<issue-number> if you're resolving an existing issue

🧑‍💻 Authors and Acknowledgments
Thanks to the students and teachers at Valle Grande CETPRO who make this project possible.

📜 License
This project is for educational use and is distributed under the MIT license.

📞 Support
If you need help:

Open an issue on GitLab
Join the support channel on WhatsApp
Contact the responsible teachers

🔔 Project Status
🟢 In active development
📅 Last updated: June 2025
🚀 Current version: v1.0-alpha
