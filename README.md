# TP2 — Architecture distribuée

Bonjour ! Ce projet contient deux petits services Spring Boot : un service pour les étudiants et un autre pour les cours. Voici quelques étapes simples pour le lancer et essayer les requêtes Postman.

## Prérequis

- Java 17
- Docker et Docker Compose, pour le lancement avec Docker
- Postman, pour exécuter les tests

## Lancer les services sans Docker

Ouvrez deux terminaux à la racine du projet.

Dans le premier terminal :

```bash
cd etudiants
./mvnw spring-boot:run
```

Dans le deuxième terminal :

```bash
cd cours
./mvnw spring-boot:run
```

Sous Windows, vous pouvez remplacer `./mvnw` par `mvnw.cmd`.

Les services sont normalement disponibles ici :

- Étudiants : <http://localhost:8081>
- Cours : <http://localhost:8082>

Laissez les deux terminaux ouverts pendant les tests.

## Lancer avec Docker

Les Dockerfiles copient un fichier JAR déjà compilé. Il faut donc d'abord créer les JAR :

```bash
cd etudiants
./mvnw package
cd ../cours
./mvnw package
cd ..
```

Puis, depuis la racine du projet :

```bash
docker compose up --build
```

Pour arrêter les conteneurs, faites `Ctrl+C`, puis, si nécessaire :

```bash
docker compose down
```

**Petite remarque :** le client du service `cours` appelle actuellement `localhost:8081`. Dans Docker, cela peut empêcher `cours` de joindre le conteneur `etudiants`. De plus, la configuration Postman vérifie certaines réponses qui ne correspondent pas exactement au code actuel. Il est donc possible que quelques tests échouent ; cela ne signifie pas forcément que Postman est mal configuré.

## Importer et utiliser les tests Postman

Le fichier de collection s'appelle **`Postman-Tests.json`** (avec un `s` et un `T` majuscule) et se trouve à la racine du projet.

1. Ouvrez Postman.
2. Cliquez sur **Import** puis choisissez **Files**.
3. Sélectionnez `Postman-Tests.json`.
4. Ouvrez la collection **ArchTp2 - Microservices Tests**. Les adresses par défaut sont `http://localhost:8081` pour les étudiants et `http://localhost:8082` pour les cours.
5. Vérifiez que les deux services sont lancés, puis envoyez les requêtes dans l'ordre. Les requêtes de création enregistrent automatiquement les identifiants utilisés par les requêtes suivantes.
6. Après chaque requête, regardez la réponse et l'onglet **Test Results** pour voir les vérifications.

Les scénarios 1 à 4 testent les étudiants, les cours, les cours enrichis et la suppression d'un étudiant. Pour le scénario 5, il faut simuler l'arrêt du service étudiants : envoyez d'abord **5.1**, arrêtez le service `etudiants`, puis envoyez **5.2** et **5.3**. Redémarrez ensuite `etudiants` avant d'envoyer **5.4**. Ne lancez pas ce scénario comme une exécution automatique complète sans effectuer ces étapes.

Bon courage et merci d'essayer le projet !
