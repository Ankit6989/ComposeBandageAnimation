[![Android API](https://img.shields.io/badge/api-21%2B-brightgreen.svg?style=for-the-badge)](https://android-arsenal.com/api?level=21)
[![kotlin](https://img.shields.io/github/languages/top/raamcosta/compose-destinations.svg?style=for-the-badge&color=blueviolet)](https://kotlinlang.org/)

<p align="center"> 
   <img height="250" src="https://user-images.githubusercontent.com/80427734/147891822-5cd34c80-8dca-4d34-8278-2aa3bf36913f.png"/> 
</p>

<h1 align="center"> 
   <a href="https://composedestinations.rafaelcosta.xyz">Compose Destinations</a>
</h1>

- A KSP library that processes annotations and generations code that uses official jetpack compose for Navigation unfder the hood.
- It hides the complex, non-type-safe and boilerplate code you would have to write otherwise.
- Kotlin Symbol Processing or KSP is an API that you can use to develop lightweight compiler plugins. 
- KSP provides a simplified compiler plugin API that leverages the power of Kotlin while keeping the learning curve at a minimum.

## Setup
1) Add the KSP Plugin
   
 ```gradle
plugins {
    //...
    id 'com.google.devtools.ksp' version '1.8.0-1.0.9' // Depends on your kotlin version
}
```

2) Add the Dependencies

```gradle
implementation("io.github.raamcosta.compose-destinations:core:<version>")
ksp("io.github.raamcosta.compose-destinations:ksp:<version>")
```

3) Include a kotlin block that defines the sourceSets for the generated code inside your build.gradle

```
kotlin {
    sourceSets {
        debug {
            kotlin.srcDir("build/generated/ksp/debug/kotlin")
        }
        release {
            kotlin.srcDir("build/generated/ksp/release/kotlin")
        }
    }
}
```
## Implement Navigation

1) We use the Destination annotation which comes from the [Compose Destinations](https://github.com/raamcosta/compose-destinations).

```
@Destination
@Composable
fun LoginScreen(
navigator: DestinationsNavigator
) {}
```

2) Run the command below which generates all the Destinations ```./gradlew clean build```

## Using NavHost
```
class MainActivity : ComponentActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
  super.onCreate(savedInstanceState)
  setContent {
      AppTheme {
          DestinationsNavHost(navGraph = NavGraphs.root)
      }
  }
 }
}
```

- Our DestinationsNavHost includes the destinations of navGraph. It includes all the composables annotated with Destination inside NavGraphs generated file.
- NavGraphs is a generated file that describes your navigation graphs and their destinations. By default, all destinations belong to the NavGraphs.root

## Passing custom arguments
### Let’s see a case, for example, we have an Loginscreen and we need to pass the user object to our Home screen.

1) Plugin Required

```gradle
plugins {
    //...
   id 'kotlin-parcelize'
}
```

2) Let’s create a Parcelable class User This class basically contains the name,id and local date time.
```
@Parcelize
data class User(
    val name: String,
    val id: String,
    val created: LocalDateTime
): Parcelable
```

3) We modify our Home composable as below
```
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    user: User
) {}

```   
