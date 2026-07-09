# Projektdokumentation – LabVisionDistributed

## 1. Einleitung

LabVisionDistributed ist eine verteilte Anwendung, die im Rahmen des Moduls Softwaretechnik entwickelt wurde. Ziel der Dokumentation ist es zu zeigen, wie die einzelnen Services gestartet werden, wie sie unabhängig voneinander laufen und welche Daten über die verschiedenen Ports ausgetauscht werden.

Die Anwendung besteht aus mehreren eigenständigen Spring-Boot-Services. Jeder Service übernimmt eine bestimmte Aufgabe und läuft als eigener Prozess. Die Kommunikation zwischen den Services erfolgt über HTTP-Anfragen.

Dadurch wird das Prinzip einer verteilten Anwendung praktisch dargestellt.
---

## 2. Projektarchitektur

Die Anwendung wurde als Multi-Modul-Maven-Projekt entwickelt und besteht aus mehreren eigenständigen Spring-Boot-Services. Jeder Service übernimmt eine klar definierte Aufgabe und läuft als eigener Prozess auf einem eigenen Port. Dadurch können die Services unabhängig voneinander gestartet, ausgeführt und getestet werden.

Im Gegensatz zu einer klassischen modularen Anwendung kommunizieren die einzelnen Services nicht direkt über Java-Methoden. Stattdessen erfolgt der Datenaustausch über HTTP-Anfragen. Dadurch wird das Prinzip einer verteilten Anwendung umgesetzt.

Die folgende Abbildung zeigt den grundsätzlichen Aufbau der Anwendung.

**Abbildung 1: Architektur der Anwendung**

*(Hier wird später das Architekturdiagramm eingefügt.)*

Anschließend werden die einzelnen Services sowie ihre Aufgaben und die Kommunikation zwischen ihnen genauer beschrieben.
### 2.1 Projektstruktur

Die Anwendung wurde als Multi-Modul-Maven-Projekt umgesetzt. Jedes Modul übernimmt eine eigene Aufgabe innerhalb der Anwendung. Durch diese Aufteilung bleibt der Quellcode übersichtlich und die einzelnen Services können unabhängig voneinander entwickelt und ausgeführt werden.

Die folgende Abbildung zeigt die Projektstruktur in Cursor.

**Abbildung 2: Projektstruktur des Projekts**

![Projektstruktur](screenshots/01-projektstruktur.png)

Die wichtigsten Module sind:

| Modul | Aufgabe |
|--------|---------|
| **app** | Stellt die Weboberfläche bereit und koordiniert den Ablauf der Anwendung. |
| **auth** | Überprüft die Anmeldedaten des Benutzers. |
| **upload** | Nimmt den Bildnamen entgegen und startet den Upload-Prozess. |
| **analysis** | Analysiert das Bild und erstellt das Analyseergebnis. |
| **report** | Erstellt aus dem Analyseergebnis den Bericht. |
| **common** | Enthält gemeinsam genutzte Klassen und Funktionen. |
| **docs** | Enthält die Projektdokumentation, das Architekturdiagramm und die Screenshots. |

Durch die Aufteilung in mehrere Module ist der Aufbau der Anwendung klar strukturiert und leicht nachvollziehbar.
---

# 3. Beschreibung der Services

Die Anwendung besteht aus fünf unabhängigen Spring-Boot-Services. Jeder Service übernimmt eine klar definierte Aufgabe innerhalb des Workflows. Alle Services laufen als eigene Prozesse und kommunizieren ausschließlich über HTTP-Anfragen miteinander.

## 3.1 Auth-Service

Der Auth-Service ist für die Anmeldung des Benutzers zuständig. Er empfängt den Benutzernamen und das Passwort von der Webanwendung und überprüft die Anmeldedaten. Nach erfolgreicher Anmeldung sendet er eine Bestätigung an den App-Service zurück.

- **Port:** 8081
- **Empfangene Daten:** Benutzername und Passwort
- **Antwort:** Status der Anmeldung

**Abbildung 3: Gestarteter Auth-Service**

![Auth-Service](screenshots/02-auth-service.png)
