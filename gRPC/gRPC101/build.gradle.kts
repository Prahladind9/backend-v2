plugins {
    id("java")
}

group = "edu.prahlad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/net.devh/grpc-server-spring-boot-starter
    implementation("net.devh:grpc-server-spring-boot-starter:2.15.0.RELEASE")
    // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
    implementation("javax.annotation:javax.annotation-api:1.3.2")


}

tasks.test {
    useJUnitPlatform()
}