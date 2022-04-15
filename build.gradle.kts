plugins {
    id("com.github.ben-manes.versions") version "0.42.0"
    id("java-library")
}

allprojects {
    group = "com.liquidforte.phantasia"
}

subprojects {
    apply(plugin = "java-library")

    java {
        sourceCompatibility = JavaVersion.VERSION_18
        targetCompatibility = JavaVersion.VERSION_18
    }

    tasks.withType<JavaCompile> {
        options.compilerArgs.add("--enable-preview")
    }

    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        implementation("org.slf4j:slf4j-api:1.7.32")
        implementation(platform("org.apache.logging.log4j:log4j-bom:2.17.2"))
        implementation("org.apache.logging.log4j:log4j-api")

        runtimeOnly("org.apache.logging.log4j:log4j-slf4j-impl")
        runtimeOnly("org.apache.logging.log4j:log4j-core")

        testImplementation(platform("org.junit:junit-bom:5.8.2"))
        testImplementation("org.junit.jupiter:junit-jupiter")

        testImplementation("org.mockito:mockito-core:4.4.0")
        testImplementation("org.mockito:mockito-junit-jupiter:4.4.0")

        testImplementation("org.assertj:assertj-core:3.22.0")
    }

    tasks.withType<Test> {
        useJUnitPlatform();
        systemProperties["junit.jupiter.execution.parallel.enabled"] = true
        systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
        maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
    }

    tasks.withType<JavaExec> {
        standardInput = System.`in`
    }
}