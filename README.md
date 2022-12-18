# Build an Android app using the Fake API (easy)
##### Build an Android app using the [Fake API](https://jsonplaceholder.typicode.com/comments)

Create main screen with list of comments from this request [https://api.github.com/users](https://jsonplaceholder.typicode.com/comments)

The list item has to display such data:

- name
- email
- body

Tech stack:

- Jetpack Compose
- Kotlin
- MVVM Architecture
- Kotlin coroutines
- Retrofit
- Dagger 2 or Dagger Hilt
- Single Activity Design Pattern
- Clean Architecture
## Project Structure


Dillinger uses a number of open source projects to work properly:

- ```di``` Contain all module for Dependency Injection
- ```model```  Contain pojo
- ```navigation```  Contain NavGraph and Screen .
- ```network```  Retrofit config
- ```repository``` Contain repository
- ```ui.theme``` theme of app
- ```views``` the views
- ```vm``` the viewmodel

## Release
You can find the apk  [here](https://github.com/zack2/android-app-fake-api/tree/main/app/release)