# EWA Admin v0.7.1

- Repository layout normalized for a fresh GitHub repository.
- GitHub Actions workflow updated for current setup-java v6 and setup-gradle v6.
- Removed setup-java Gradle cache dependency that caused repository detection failures.
- Firebase google-services.json is injected securely from a GitHub Actions secret.
- Keeps v0.7.0 FCM live notifications, 60-second foreground sync, notification deep links, and duplicate suppression.
