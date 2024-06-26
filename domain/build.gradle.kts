plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")

}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies{
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
    implementation("javax.inject:javax.inject:1")
}