# Schritt 1: Ausgangssituation

In diesem Projekt wird LabVisionDistributed erweitert.

Ziel ist es, aus der bisherigen modularen Anwendung eine verteilte Anwendung zu machen.

Dafür sollen mehrere Services entstehen, die jeweils als eigener Prozess laufen und über HTTP miteinander kommunizieren.

Geplante Services:

- App-Service auf Port 8081
- Auth-Service auf Port 8082
- Upload-Service auf Port 8083
- Analysis-Service auf Port 8084
- Report-Service auf Port 8085

Der wichtigste verteilte Ablauf ist:

App → Upload-Service → Analysis-Service → Report-Service

Dadurch sendet ein Teil Daten an einen zweiten Teil, der diese Daten weiterverarbeitet.