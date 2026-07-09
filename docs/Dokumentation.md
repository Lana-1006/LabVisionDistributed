# Projektdokumentation – LabVisionDistributed

## 1. Einleitung

LabVisionDistributed ist eine verteilte Anwendung, die im Rahmen des Moduls Softwaretechnik entwickelt wurde. Ziel der Dokumentation ist es zu zeigen, wie die einzelnen Services gestartet werden, wie sie unabhängig voneinander laufen und welche Daten über die verschiedenen Ports ausgetauscht werden.

Die Anwendung besteht aus mehreren eigenständigen Spring-Boot-Services. Jeder Service übernimmt eine bestimmte Aufgabe und läuft als eigener Prozess. Die Kommunikation zwischen den Services erfolgt über HTTP-Anfragen.

Dadurch wird das Prinzip einer verteilten Anwendung praktisch dargestellt.
