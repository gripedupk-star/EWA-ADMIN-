# EWA Live Push Setup

1. Create/open a Firebase project and add Android app package `com.ewa.admin`.
2. Download `google-services.json` and place it at `android-admin/app/google-services.json`.
3. Firebase Console > Project settings > Service accounts > Generate new private key.
4. In WordPress go to **EWA Platform > Mobile Push** and paste that service-account JSON.
5. Build/install EWA Admin v0.7.0 and sign in once. The app registers its FCM device token automatically.
6. Android 13+ asks for notification permission; allow it.

Architecture:
- EWA Core writes every admin event to `wp_ewa_admin_events`.
- EWA Core immediately sends high-priority FCM data push to registered admin devices.
- App displays a high-priority Android notification and deep-links to the relevant section.
- While the app is open, it also calls `/admin/app/activity` every 60 seconds as a fallback and refreshes the current section.
- Duplicate suppression uses event IDs.

Events wired in this release:
student registration, WhatsApp queue message, book order, membership payment submission, video-session payment/request.
