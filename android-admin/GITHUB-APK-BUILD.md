# EWA Android Admin — v0.5.7

## GitHub Actions

1. Upload/replace the `android-admin` folder in the repository.
2. Keep `.github/workflows/android.yml` at repository root.
3. Open **Actions → Build Android APK → Run workflow**.
4. Wait for the workflow to finish.
5. Open the successful run → **Artifacts** → `ewa-android-admin-v0.5.7-debug`.

The workflow also runs on pushes to `main` or `master`.

## v0.5.7 compile fix

The previous build used `JSONObject.opt(key, default)`, which is not a valid Android `org.json.JSONObject` overload. Analytics now uses the correct typed accessors (`optInt` / `optDouble`).
