# Backend-Server für das Spiel ZellAttacke
[ZellAttacke](https://github.com/fb-bht/ZellAttacke)

## Beschreibung
Der Backend-Server wird benutzt um registrierte Spieler und deren Spielstände in einer MySQL Datenbank zu speichern. Die Informationen werden per REST-Schnittstelle mit dem Client ausgetauscht. Die Autentifizierung und Autorisierung erfolgt mittels JWT-Token.

Einige REST-Endpunkte sind ohne Token zugänglich wie z.B. /highscore

## Technologien
* Spring-Boot-Framework
* Hibernate ORM-Framework
* JSON Web Tokens