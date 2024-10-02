# Worttrainer
Pavel Bakshi

## Projektbeschreibung
Der Worttrainer ist eine App, die speziell entwickelt wurde, um Volksschulkinder beim Üben ihrer Rechtschreibung zu unterstützen. Dabei werden Bilder, die über URLs geladen werden, angezeigt und die Kinder müssen das entsprechende Wort dazu eingeben. Das Programm überprüft die Eingabe und meldet, ob die Schreibweise korrekt oder falsch ist. Zudem wird eine Statistik geführt, die das Verhältnis von richtigen und falschen Antworten erfasst.
Die Anwendung wurde unter Anwendung moderner Softwareentwicklungsmethoden entwickelt. Dabei kamen Gradle als Build-System sowie Git für die Versionsverwaltung zum Einsatz. Die Implementierung erfolgte in Java, während die Benutzeroberfläche mit Swing realisiert wurde.

## Installation und Einführung

### Vorraussetzungen
- Java
- Gradle 
- Ein Git-Client


### Gradle

```java
$ gradle init

Select type of build to generate:
  1: Application
  2: Library
  3: Gradle plugin
  4: Basic (build structure only)

$ 3
```
Depandancy:

```java
dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.3'
    implementation 'com.google.code.gson:gson:2.8.9'
    implementation 'org.json:json:20210307'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```
## Speichern und Laden
Der FileWriter wurde verwendet, um Daten in eine Datei zu speichern und aus ihr zu laden, weil er eine einfache Möglichkeit bietet, Textdateien in Java zu bearbeiten. Mit dem FileWriter können Daten zeilenweise in eine Datei geschrieben und später wieder ausgelesen werden. Er ist besonders nützlich, wenn es darum geht, kleine bis mittelgroße Textdaten schnell und unkompliziert zu speichern und zu laden.

Der FileWriter wurde verwendet, um Daten in JSON- und XML-Dateien zu speichern und zu laden, weil er eine einfache Methode bietet, Textdateien zu bearbeiten. 

## GUI
Java Swing wurde für die grafische Oberfläche verwendet, weil es eine zuverlässige und flexible Möglichkeit bietet, Programme mit Fenstern, Buttons und Bildern zu erstellen. Es stellt viele Bausteine zur Verfügung, um eine Benutzeroberfläche einfach anzupassen und zu gestalten. Daher eignet es sich gut für Anwendungen, die eine klare und funktionale Benutzeroberfläche benötigen.

wichtige imports:

```java
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import org.json.JSONObject;
```

## UML Diagramm
<img src="Worttrainer.png" alt="Worttrainer" title="" />

