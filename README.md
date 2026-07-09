# LabVisionDistributed

## Projektbeschreibung und Ziel

LabVisionDistributed ist eine verteilte Anwendung, die im Rahmen des Moduls **Softwaretechnik** entwickelt wurde.

Ziel des Projekts war es, aus einer bestehenden modularen Anwendung eine verteilte Anwendung zu entwickeln. Dazu wurde die Anwendung in mehrere eigenständige Spring-Boot-Services aufgeteilt. Jeder Service übernimmt eine bestimmte Aufgabe und läuft als eigener Prozess auf einem eigenen Port.

Im Gegensatz zu einer modularen Anwendung kommunizieren die einzelnen Services nicht mehr direkt über Java-Methoden, sondern ausschließlich über HTTP-Anfragen. Dadurch wird gezeigt, wie mehrere unabhängige Prozesse zusammenarbeiten und gemeinsam einen vollständigen Arbeitsablauf ausführen.

Die Anwendung bildet einen einfachen Workflow zur Verarbeitung eines Laborbildes ab. Der Benutzer startet den Prozess über die Webanwendung. Zunächst werden die Anmeldedaten an den Auth-Service übermittelt. Nach erfolgreicher Anmeldung wird der Upload-Service aufgerufen, der den Bildnamen entgegennimmt und an den Analysis-Service weiterleitet. Der Analysis-Service analysiert das Bild und sendet das Analyseergebnis an den Report-Service. Dieser erstellt daraus einen Bericht und gibt das Ergebnis an die Webanwendung zurück.

Mit diesem Projekt wird das Prinzip einer verteilten Architektur praktisch umgesetzt und gezeigt, wie mehrere Services über definierte HTTP-Schnittstellen miteinander kommunizieren.

---

# Verwendete Technologien

Für die Entwicklung des Projekts wurden folgende Technologien verwendet:

- Java 17
- Spring Boot
- Maven
- REST / HTTP
- Git
- GitHub
- Cursor (Visual Studio Code Clone)

---

# Projektstruktur

```text
LabVisionDistributed
│
├── app
├── auth
├── upload
├── analysis
├── report
├── common
└── docs
```

| Modul | Beschreibung |
|--------|--------------|
| **app** | Stellt die Weboberfläche bereit und startet den gesamten Workflow. |
| **auth** | Überprüft die Anmeldedaten des Benutzers. |
| **upload** | Nimmt den Bildnamen entgegen und leitet ihn an den Analysis-Service weiter. |
| **analysis** | Analysiert das Bild und erstellt das Analyseergebnis. |
| **report** | Erstellt aus dem Analyseergebnis einen Bericht. |
| **common** | Enthält gemeinsam genutzte Klassen und Funktionen. |
| **docs** | Enthält die Projektdokumentation, Screenshots und das Architekturdiagramm. |

---

# Verteilte Architektur

Die Anwendung besteht aus fünf unabhängigen Spring-Boot-Services.

| Service | Port | Aufgabe |
|----------|------|----------|
| App-Service | **8082** | Einstiegspunkt der Anwendung und Bereitstellung der Weboberfläche |
| Auth-Service | **8081** | Überprüfung der Anmeldedaten |
| Upload-Service | **8083** | Verarbeitung des Bilduploads |
| Analysis-Service | **8084** | Analyse des Bildes |
| Report-Service | **8085** | Erstellung des Analyseberichts |

---

# Kommunikationsablauf

Der Ablauf der Anwendung erfolgt in folgender Reihenfolge:

```text
Browser
   │
   ▼
App-Service (8082)
   │
   ▼
Auth-Service (8081)
   │
   ▼
Upload-Service (8083)
   │
   ▼
Analysis-Service (8084)
   │
   ▼
Report-Service (8085)
   │
   ▼
Antwort an den Browser
```

Während des Ablaufs werden verschiedene Informationen zwischen den Services übertragen:

- Der **App-Service** sendet Benutzername und Passwort an den **Auth-Service**.
- Der **Auth-Service** überprüft die Anmeldedaten und sendet das Ergebnis an den App-Service zurück.
- Anschließend wird der Bildname an den **Upload-Service** übergeben.
- Der **Upload-Service** leitet den Bildnamen an den **Analysis-Service** weiter.
- Der **Analysis-Service** erstellt das Analyseergebnis und sendet es an den **Report-Service**.
- Der **Report-Service** erstellt den Bericht und liefert das Ergebnis an die Webanwendung zurück.

---

# Dokumentation

Eine ausführliche Projektdokumentation befindet sich im Ordner **docs**.

Die Dokumentation enthält:

- Beschreibung der Projektarchitektur
- Erklärung der einzelnen Services
- Beschreibung der Kommunikation zwischen den Services
- Architekturdiagramm
- Screenshots der gestarteten Prozesse
- Screenshots der laufenden Anwendung
- Erläuterung des Datenaustauschs über die einzelnen Ports
