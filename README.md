
# Analytics SDK  

A lightweight, modular, and scalable Analytics SDK for Android applications. This SDK allows developers to manage multiple analytics sessions, track events with properties, and persist session data. It is built with testability and scalability in mind, ensuring smooth integration into any project.

---

## Features  

- **Session Management**  
  - Start, stop, and manage analytics sessions.  

- **Event Tracking**  
  - Log custom events with key-value properties during active sessions.  

- **Persistent Storage**  
  - Session data is stored persistently for later retrieval or analysis.  

- **Testability**  
  - Instrumented test cases cover all SDK functionalities.  

---

## Installation  

1. Clone this repository or download the SDK as a library.  
2. Add the SDK module to your project.  


## Please find aar in the link below
https://drive.google.com/file/d/1czcZDcCpGuPSoHEdwDseuqhj345p_b5v/view?usp=sharing

## Code Snippet  

### Initialize the SDK  
Initialize the SDK in your `Application` class:  
```kotlin  

class App : Application() {  
    override fun onCreate() {  
        super.onCreate()  
        AnalyticsSDK.initialize(this)  
    }  
}

// Start a Session
val sessionId = AnalyticsSDK.getInstance().startSession()  
println("Session started with ID: $sessionId")  

// Log Events
AnalyticsSDK.getInstance().trackEvent("Test Event", mapOf("key" to "value"))  


// Stop a Session
val sessionId = AnalyticsSDK.getInstance().stopSession("sessionId")  
if (sessionId != null) println("Session $sessionId stopped.")  
else println("No active session found.")  



