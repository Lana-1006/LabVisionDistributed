# 🔬 LabVisionDistributed

> **A distributed Spring Boot application demonstrating communication between independent services via HTTP.**

---

## 📖 Projektübersicht

**LabVisionDistributed** ist eine verteilte Anwendung, die im Rahmen des Moduls **Softwaretechnik** entwickelt wurde.

Ziel des Projekts war es, eine bestehende modulare Anwendung in eine **verteilte Architektur** umzuwandeln. Anstatt alle Funktionen innerhalb einer einzigen Anwendung auszuführen, wurde der Workflow auf mehrere eigenständige Spring-Boot-Services verteilt.

Jeder Service übernimmt eine klar definierte Aufgabe und läuft als eigener Prozess auf einem eigenen Port. Die Kommunikation erfolgt ausschließlich über HTTP-Anfragen. Dadurch wird gezeigt, wie mehrere unabhängige Anwendungen zusammenarbeiten und gemeinsam einen vollständigen Workflow ausführen.

Die Anwendung simuliert die Verarbeitung eines Laborbildes – von der Anmeldung über den Upload und die Analyse bis hin zur Erstellung eines Berichts.

---

## 🎯 Projektziel

Das Projekt verfolgt folgende Ziele:

- Umsetzung einer verteilten Anwendung mit Spring Boot
- Trennung der einzelnen Funktionen in unabhängige Services
- Kommunikation der Services über HTTP
- Verständnis verteilter Systeme anhand eines praktischen Beispiels
- Nachvollziehbare Dokumentation des gesamten Workflows

---

## 🛠️ Verwendete Technologien

- Java 17
- Spring Boot
- Maven
- REST / HTTP
- Git
- GitHub
- Cursor

---

## 📂 Projektstruktur

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

## 🏗️ Systemarchitektur

```text
                    Browser
                       │
                       ▼
              App-Service (8082)
                       │
        ┌──────────────┴──────────────┐
        ▼                             ▼
 Auth-Service                   Upload-Service
   (8081)                          (8083)
                                        │
                                        ▼
                              Analysis-Service
                                    (8084)
                                        │
                                        ▼
                               Report-Service
                                    (8085)
                                        │
                                        ▼
                              Antwort an Browser
```

---

## 🔄 Workflow

Der Ablauf der Anwendung erfolgt in mehreren Schritten:

1. Der Benutzer öffnet die Webanwendung.
2. Der App-Service startet den Workflow.
3. Die Anmeldung wird durch den Auth-Service geprüft.
4. Der Bildname wird an den Upload-Service übergeben.
5. Der Analysis-Service analysiert das Bild.
6. Der Report-Service erstellt einen Bericht.
7. Das Ergebnis wird im Browser angezeigt.

---

## 📑 Dokumentation

Eine ausführliche Projektdokumentation befindet sich im Ordner **docs**.

Die Dokumentation enthält unter anderem:

- Projektarchitektur
- Beschreibung aller Services
- Kommunikation zwischen den Services
- Erklärung der HTTP-Aufrufe
- Screenshots der gestarteten Prozesse
- Browser-Ausgabe
- Fazit

---

## 👨‍💻 Autor

**Lana Abou-Shokair**

Bachelorstudiengang **Wirtschaftsinformatik**

Projekt im Modul **Softwaretechnik**
