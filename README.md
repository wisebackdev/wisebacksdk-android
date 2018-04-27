# Wiseback SDK for Android
**Wiseback Android SDK** allows you to easily implement Wiseback forms to your Android apps.

## Requirements
The SDK requires your app to target minimum **API Level 19** (Android 4.4).

## Installation
To use Wiseback SDK library in your app, proceed as follows:
1. In Android Studio add the library (wisebacksdk-release.aar) file to your project:

> a. Click **File > New > New Module**.
  
> b. Click **Import .JAR/.AAR Package** then click **Next**.
  
> c. Enter the location of the library (AAR) file then click **Finish**.

2. Make sure the library is listed at the top of your `settings.gradle` file:
```
include ':app', ':wisebacksdk-release'
```

3. Open the app module's `build.gradle` file and add a new line to the dependencies block as shown in the following snippet:
```
dependencies {
    implementation project(':wisebacksdk-release')
}
```

4. Click **Sync Project with Gradle Files**.


## Usage

### Quick start

First you need to import the library.
```java
import com.wiseback.wisebacksdk.WiseActivity;
```

Here is a sample code to show a Wiseback form:
```java
Intent intent = new Intent(MainActivity.this, WiseActivity.class);
intent.putExtra("formID", "VgcfNL"); //change "VgcfNL" with your formID
startActivity(intent);
```

### Customize `form`
You can hide close button, show a progress bar and add animation.
```java
Intent intent = new Intent(MainActivity.this, WiseActivity.class);
intent.putExtra("formID", "VgcfNL");
intent.putExtra("hasCloseButton", false); //optional, default: true
intent.putExtra("showProgress", true); //optional, default: false
intent.putExtra("animation", WiseActivity.Anim.UP); //optional, default: Anim.DEFAULT
startActivity(intent);
```

### Add `Event Listener`
The library implements the following event listeners:
* `onStartLoading`: When form starts loading
* `onFormLoaded`: When form has loaded
* `onErrorLoading`: When an error occures
* `onFormClosed`: When the form has closed

Example usage:
```java
WiseActivity.setWiseEventListener(new WiseActivity.WiseEventListener() {
    @Override
    public void onStartLoading() {
        Log.d("WISE_SDK", "onStartLoading: OK");
    }

    @Override
    public void onFormLoaded() {
        Log.d("WISE_SDK", "onFormLoaded: OK");
    }

    @Override
    public void onErrorLoading(String description) {
        Log.d("WISE_SDK", "onErrorLoading: " + description);
    }

    @Override
    public void onFormClosed() {
        Log.d("WISE_SDK", "onFormClosed: OK");
    }
});
```
