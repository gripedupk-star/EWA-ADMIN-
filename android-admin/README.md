# EWA Admin Android v0.7.1

Repository-ready Android admin app for EWA Core v4.4.0.

## Live updates
- Firebase Cloud Messaging push notifications when the app is backgrounded/closed.
- 60-second activity sync while the app is open.
- Notifications deep-link to Students, Memberships, Orders, Video Sessions, or WhatsApp.
- Event-ID duplicate protection.

## GitHub APK build
1. Create a Firebase Android app with package `com.ewa.admin`.
2. Download `google-services.json`.
3. GitHub repository > Settings > Secrets and variables > Actions > New repository secret.
4. Name: `FIREBASE_GOOGLE_SERVICES_JSON`.
5. Paste the complete contents of `google-services.json` as the secret value.
6. Actions > Build EWA Admin APK > Run workflow.
7. Download artifact `EWA-Admin-v0.7.1-APK`.

Do not commit `google-services.json`; `.gitignore` excludes it.

## Server
Install EWA Core v4.4.0 and configure its EWA Platform > Mobile Push screen with the Firebase service-account JSON.
