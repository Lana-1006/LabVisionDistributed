# Projektdokumentation – LabVisionDistributed

## 1. Einleitung

LabVisionDistributed ist eine verteilte Anwendung, die im Rahmen des Moduls Softwaretechnik entwickelt wurde. Ziel der Dokumentation ist es zu zeigen, wie die einzelnen Services gestartet werden, wie sie unabhängig voneinander laufen und welche Daten über die verschiedenen Ports ausgetauscht werden.

Die Anwendung besteht aus mehreren eigenständigen Spring-Boot-Services. Jeder Service übernimmt eine bestimmte Aufgabe und läuft als eigener Prozess. Die Kommunikation zwischen den Services erfolgt über HTTP-Anfragen.

Dadurch wird das Prinzip einer verteilten Anwendung praktisch dargestellt.
---

# 2. Projektarchitektur

Die Anwendung wurde als **Multi-Modul-Maven-Projekt** entwickelt. Das bedeutet, dass das Projekt aus mehreren Modulen besteht, die jeweils eine eigene Aufgabe übernehmen. Durch diese Aufteilung bleibt der Quellcode übersichtlich und die einzelnen Teile der Anwendung können unabhängig voneinander entwickelt werden.

Für die verteilte Anwendung wurden fünf eigenständige Spring-Boot-Services erstellt. Jeder Service wird als eigener Prozess gestartet und läuft auf einem eigenen Port. Dadurch können die Services unabhängig voneinander ausgeführt werden. Die Kommunikation zwischen den Services erfolgt ausschließlich über HTTP-Anfragen.

Die folgende Abbildung zeigt die Struktur des Projekts.

**Abbildung 1: Projektstruktur von LabVisionDistributed**

![Projektstruktur](screenshots/01-projektstruktur.png)

Die wichtigsten Module des Projekts sind in der folgenden Tabelle dargestellt.

| Modul | Aufgabe |
|--------|----------|
| **app** | Stellt die Webanwendung bereit und steuert den gesamten Ablauf der Anwendung. |
| **auth** | Überprüft die Anmeldedaten des Benutzers. |
| **upload** | Nimmt den Bildnamen entgegen und leitet ihn an den Analysis-Service weiter. |
| **analysis** | Analysiert das Bild und erstellt das Analyseergebnis. |
| **report** | Erstellt aus dem Analyseergebnis den Bericht. |
| **common** | Enthält gemeinsam genutzte Klassen, die von mehreren Modulen verwendet werden. |
| **docs** | Enthält die Projektdokumentation und die Screenshots. |

Die Kommunikation zwischen den Services erfolgt über das HTTP-Protokoll. Jeder Service besitzt einen eigenen Port und kann unabhängig von den anderen Services gestartet oder beendet werden. Dadurch wird das Prinzip einer verteilten Anwendung umgesetzt.
---

# 3. Beschreibung der Services

Die Anwendung besteht aus mehreren eigenständigen Spring-Boot-Services. Jeder Service übernimmt eine eigene Aufgabe innerhalb des gesamten Workflows. Dadurch ist die Anwendung übersichtlicher aufgebaut und jeder Teil kann unabhängig gestartet, getestet und bei Bedarf erweitert werden.

## 3.1 Auth-Service

Der Auth-Service ist für die Anmeldung des Benutzers zuständig. Er überprüft, ob Benutzername und Passwort vorhanden sind. In diesem Projekt wird die Anmeldung vereinfacht dargestellt. Es geht nicht um eine echte Benutzerverwaltung mit Datenbank, sondern darum zu zeigen, dass die Anmeldung als eigener Prozess ausgelagert wurde.

Der Service läuft unabhängig von der Webanwendung und wird über HTTP aufgerufen. Dadurch ist er nicht direkt mit dem App-Service verbunden, sondern bekommt die benötigten Daten über eine Anfrage.

- **Port:** 8081
- **Aufgabe:** Anmeldung prüfen
- **Eingabe:** Benutzername und Passwort
- **Ausgabe:** Ergebnis der Anmeldung

**Abbildung 2: Gestarteter Auth-Service**

![Auth-Service](screenshots/02-auth-service.png)

Der Screenshot zeigt, dass der Auth-Service als eigener Spring-Boot-Prozess gestartet wurde und auf Port 8081 läuft.

---

## 3.2 Upload-Service

Der Upload-Service verarbeitet den Upload-Schritt. In diesem Projekt wird kein echtes Bild hochgeladen, sondern der Bildname beispielhaft übergeben. Dadurch bleibt der Ablauf einfach, aber der verteilte Aufbau ist trotzdem erkennbar.

Der Upload-Service erhält den Bildnamen und übernimmt die Aufgabe, diesen Schritt im Workflow zu starten. Er ist ein eigener Prozess und kann unabhängig von den anderen Services gestartet werden.

- **Port:** 8083
- **Aufgabe:** Bildname entgegennehmen
- **Eingabe:** Bildname, zum Beispiel `sample.png`
- **Ausgabe:** Upload-Ergebnis

**Abbildung 3: Gestarteter Upload-Service**

![Upload-Service](screenshots/03-upload-service.png)

Der Screenshot zeigt, dass der Upload-Service als eigener Spring-Boot-Prozess gestartet wurde und auf Port 8083 läuft.

---

## 3.3 Analysis-Service

Der Analysis-Service übernimmt die Analyse des Bildes. Er bekommt den Bildnamen übergeben und erstellt daraus ein Analyseergebnis. Auch diese Analyse ist in diesem Projekt vereinfacht dargestellt, damit der Fokus auf der verteilten Architektur liegt.

Der Service zeigt, wie ein eigener Prozess Daten erhält, verarbeitet und ein Ergebnis erzeugt. Dadurch wird deutlich, dass die Verarbeitung nicht in der Webanwendung selbst stattfindet, sondern an einen eigenen Service ausgelagert wurde.

- **Port:** 8084
- **Aufgabe:** Bild analysieren
- **Eingabe:** Bildname
- **Ausgabe:** Analyseergebnis

**Abbildung 4: Gestarteter Analysis-Service**

![Analysis-Service](screenshots/04-analysis-service.png)

Der Screenshot zeigt, dass der Analysis-Service als eigener Spring-Boot-Prozess gestartet wurde und auf Port 8084 läuft.

---

## 3.4 Report-Service

Der Report-Service erstellt aus dem Analyseergebnis einen Bericht. Er ist der letzte fachliche Service im Workflow. Er bekommt das Ergebnis der Analyse und erzeugt daraus eine einfache Textantwort.

Auch hier wurde die Funktion bewusst einfach gehalten. Wichtig ist, dass der Report-Service als eigener Prozess läuft und eine eigene Aufgabe übernimmt. Dadurch ist die Berichterstellung vom Rest der Anwendung getrennt.

- **Port:** 8085
- **Aufgabe:** Bericht erstellen
- **Eingabe:** Analyseergebnis
- **Ausgabe:** Bericht

**Abbildung 5: Gestarteter Report-Service**

![Report-Service](screenshots/05-report-service.png)

Der Screenshot zeigt, dass der Report-Service als eigener Spring-Boot-Prozess gestartet wurde und auf Port 8085 läuft.

---

## 3.5 App-Service

Der App-Service ist der Einstiegspunkt der Anwendung. Er stellt die Weboberfläche bereit, die im Browser geöffnet wird. Über diese Weboberfläche wird der gesamte Ablauf sichtbar.

Der App-Service enthält nicht die gesamte Fachlogik selbst. Stattdessen ruft er die anderen Services über HTTP auf. Dadurch steuert er den Ablauf, während die eigentlichen Aufgaben von den getrennten Services übernommen werden.

- **Port:** 8082
- **Aufgabe:** Weboberfläche bereitstellen und Workflow starten
- **Eingabe:** Aufruf im Browser
- **Ausgabe:** Darstellung der Ergebnisse im Browser

**Abbildung 6: Gestarteter App-Service**

![App-Service](screenshots/06-app-service.png)

Der Screenshot zeigt, dass der App-Service als eigener Spring-Boot-Prozess gestartet wurde und auf Port 8082 läuft.
---

# 4. Kommunikation zwischen den Services

Der wichtigste Unterschied zwischen einer modularen und einer verteilten Anwendung besteht in der Kommunikation der einzelnen Komponenten. Während bei einer modularen Anwendung Methoden direkt innerhalb desselben Programms aufgerufen werden, kommunizieren die Services in einer verteilten Anwendung über HTTP-Anfragen.

Jeder Service besitzt einen eigenen Port und kann unabhängig von den anderen Services gestartet oder beendet werden. Die Kommunikation erfolgt über die Webanwendung, welche die einzelnen Services nacheinander aufruft und die Antworten verarbeitet.

Der Ablauf der Anwendung ist in Abbildung 7 dargestellt.

**Abbildung 7: Ablauf der Kommunikation zwischen den Services**

*(Hier wird später das Architekturdiagramm eingefügt.)*

## 4.1 Anmeldung

Nachdem der Benutzer die Webanwendung geöffnet hat, startet der App-Service den Workflow. Zunächst werden der Benutzername und das Passwort an den Auth-Service gesendet.

**Aufruf**

```
http://localhost:8081/login?username=lana&password=password
```

**Gesendete Daten**

- Benutzername
- Passwort

**Antwort**

```
Login successful for user lana
```

Nach erfolgreicher Anmeldung erhält der App-Service die Antwort des Auth-Service und fährt mit dem nächsten Schritt fort.

---

## 4.2 Upload

Im nächsten Schritt wird der Upload-Service aufgerufen. In diesem Projekt wird beispielhaft der Bildname **sample.png** verwendet.

**Aufruf**

```
http://localhost:8083/upload?imageName=sample.png
```

**Gesendete Daten**

- Bildname

**Antwort**

```
Image uploaded: sample.png
```

Nach dem erfolgreichen Upload wird der Bildname an den Analysis-Service weitergegeben.

---

## 4.3 Analyse

Der Analysis-Service empfängt den Bildnamen und führt die Analyse durch. Anschließend wird das Analyseergebnis erstellt.

**Aufruf**

```
http://localhost:8084/analysis?imageName=sample.png
```

**Gesendete Daten**

- Bildname

**Antwort**

```
Analysis completed for sample.png
```

Das Analyseergebnis wird anschließend an den Report-Service übergeben.

---

## 4.4 Berichterstellung

Der Report-Service empfängt das Analyseergebnis und erstellt daraus einen Bericht.

**Aufruf**

```
http://localhost:8085/report?analysisResult=Analysis completed for sample.png
```

**Gesendete Daten**

- Analyseergebnis

**Antwort**

```
Report created: Analysis completed for sample.png
```

Der Bericht wird anschließend an den App-Service zurückgegeben und in der Webanwendung angezeigt.

---

## Zusammenfassung der Kommunikation

Die folgende Tabelle fasst die Kommunikation zwischen den einzelnen Services zusammen.

| Schritt | Sender | Empfänger | Übertragene Daten |
|----------|---------|-----------|-------------------|
| 1 | App-Service | Auth-Service | Benutzername und Passwort |
| 2 | App-Service | Upload-Service | Bildname |
| 3 | Upload-Service | Analysis-Service | Bildname |
| 4 | Analysis-Service | Report-Service | Analyseergebnis |
| 5 | Report-Service | App-Service | Fertiger Bericht |

An diesem Ablauf wird deutlich, dass jeder Service ausschließlich seine eigene Aufgabe übernimmt. Die Services kommunizieren nicht direkt über Java-Methoden, sondern ausschließlich über HTTP-Anfragen. Dadurch entsteht eine verteilte Anwendung, bei der jeder Service unabhängig ausgeführt werden kann.
