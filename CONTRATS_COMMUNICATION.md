# Contrats de Communication - Middle-Service REST

## Vue d'ensemble

Le middle-service REST expose une API REST qui consomme le service SOAP existant et transforme les appels SOAP en endpoints REST pour faciliter l'accès aux clients.

## Base URL

**Middle-Service REST:** `http://localhost:8083`

**Service Consommateur:** `http://localhost:8081`

## Endpoints REST exposés par le Middle-Service

### 1. Créer un serveur

**URI:** `POST /api/servers`

**Méthode HTTP:** `POST`

**Paramètres d'entrée:**

```json
{
  "name": "string",
  "ipAddress": "string"
}
```

**Format de requête:** JSON

**Format de réponse:** JSON

```json
{
  "id": 1,
  "name": "string",
  "ipAddress": "string",
  "status": false
}
```

**Code de statut HTTP:** `201 CREATED`

---

### 2. Lister tous les serveurs

**URI:** `GET /api/servers`

**Méthode HTTP:** `GET`

**Paramètres d'entrée:** Aucun

**Format de requête:** N/A

**Format de réponse:** JSON (Array)

```json
[
  {
    "id": 1,
    "name": "string",
    "ipAddress": "string",
    "status": true
  }
]
```

**Code de statut HTTP:** `200 OK`

---

### 3. Obtenir le statut d'un serveur

**URI:** `GET /api/servers/{id}/status`

**Méthode HTTP:** `GET`

**Paramètres d'entrée:**

- `id` (Path Variable): Long - Identifiant du serveur

**Format de requête:** N/A

**Format de réponse:** JSON

```json
true
```

**Code de statut HTTP:** `200 OK`

---

### 4. Démarrer un serveur

**URI:** `POST /api/servers/{id}/start`

**Méthode HTTP:** `POST`

**Paramètres d'entrée:**

- `id` (Path Variable): Long - Identifiant du serveur

**Format de requête:** N/A (Body vide)

**Format de réponse:** JSON

```json
{
  "id": 1,
  "name": "string",
  "ipAddress": "string",
  "status": true
}
```

**Code de statut HTTP:** `200 OK`

---

### 5. Arrêter un serveur

**URI:** `POST /api/servers/{id}/stop`

**Méthode HTTP:** `POST`

**Paramètres d'entrée:**

- `id` (Path Variable): Long - Identifiant du serveur

**Format de requête:** N/A (Body vide)

**Format de réponse:** JSON

```json
{
  "id": 1,
  "name": "string",
  "ipAddress": "string",
  "status": false
}
```

**Code de statut HTTP:** `200 OK`

---

### 6. Renommer un serveur

**URI:** `PUT /api/servers/{id}/rename`

**Méthode HTTP:** `PUT`

**Paramètres d'entrée:**

- `id` (Path Variable): Long - Identifiant du serveur
- Body (JSON):

```json
{
  "newName": "string"
}
```

**Format de requête:** JSON

**Format de réponse:** JSON

```json
{
  "id": 1,
  "name": "nouveau-nom",
  "ipAddress": "string",
  "status": true
}
```

**Code de statut HTTP:** `200 OK`

---

### 7. Supprimer un serveur

**URI:** `DELETE /api/servers/{id}`

**Méthode HTTP:** `DELETE`

**Paramètres d'entrée:**

- `id` (Path Variable): Long - Identifiant du serveur

**Format de requête:** N/A

**Format de réponse:** Aucun (Body vide)

**Code de statut HTTP:** `204 NO CONTENT`

**Note:** Le serveur doit être arrêté (status = false) avant d'être supprimé, sinon une erreur sera retournée.

---

## Endpoints REST exposés par le Service Consommateur

Le service consommateur expose les mêmes endpoints que le middle-service pour permettre aux clients d'accéder aux fonctionnalités via une couche supplémentaire.

**Base URL:** `http://localhost:8081`

Tous les endpoints sont identiques à ceux du middle-service:

- `POST /api/servers` - Créer un serveur
- `GET /api/servers` - Lister tous les serveurs
- `GET /api/servers/{id}/status` - Obtenir le statut
- `POST /api/servers/{id}/start` - Démarrer un serveur
- `POST /api/servers/{id}/stop` - Arrêter un serveur
- `PUT /api/servers/{id}/rename` - Renommer un serveur
- `DELETE /api/servers/{id}` - Supprimer un serveur

---

## Architecture de Communication

```
Client → Service Consommateur (Port 8081) → Middle-Service REST (Port 8083) → Service SOAP (Port 8080)
```

1. **Service SOAP** (SUPNUM_TD1_23044): Port 8080

   - Expose les services SOAP via `/ws/*`
   - Namespace: `http://supnum.com/server`

2. **Middle-Service REST**: Port 8083

   - Consomme le service SOAP
   - Expose des endpoints REST via `/api/servers/*`
   - Format: JSON

3. **Service Consommateur**: Port 8081
   - Consomme le Middle-Service REST
   - Expose les mêmes endpoints REST pour les clients finaux
   - Format: JSON

---

## Formats de données

Tous les endpoints utilisent le format **JSON** pour les requêtes et réponses.

### Structure ServerDTO

```json
{
  "id": 1,
  "name": "string",
  "ipAddress": "string",
  "status": boolean
}
```

### Structure CreateServerRequestDTO

```json
{
  "name": "string",
  "ipAddress": "string"
}
```

### Structure RenameServerRequestDTO

```json
{
  "newName": "string"
}
```

---

## Codes d'erreur HTTP

- `200 OK`: Succès
- `201 CREATED`: Ressource créée avec succès
- `204 NO CONTENT`: Succès sans contenu (pour DELETE)
- `400 BAD REQUEST`: Requête invalide
- `404 NOT FOUND`: Ressource non trouvée
- `500 INTERNAL SERVER ERROR`: Erreur serveur
