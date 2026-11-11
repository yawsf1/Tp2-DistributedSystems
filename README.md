# TP2 — Architecture distribuée

Bonjour ! Ce projet contient deux services Spring Boot : un service pour les étudiants et un autre pour les cours. Voici comment les lancer et essayer les tests Postman.

## Prérequis

- Java 17
- Maven
- Docker et Docker Compose, pour le lancement avec Docker
- Postman, pour exécuter les tests

## Compiler le projet

Le fichier `pom.xml` à la racine permet de compiler les deux services ensemble. Depuis le dossier principal du projet, lancez simplement :

```bash
mvn clean package
```

Par exemple, si le projet se trouve dans `~/SpringProjects/tp2Architecture` :

```bash
cd ~/SpringProjects/tp2Architecture
mvn clean package
```

Cette commande crée les fichiers JAR des deux services dans leurs dossiers `target/` respectifs.

## Lancer les services sans Docker

Après la compilation, ouvrez deux terminaux à la racine du projet.

Dans le premier terminal :

```bash
java -jar etudiants/target/etudiants-0.0.1-SNAPSHOT.jar
```

Dans le deuxième terminal :

```bash
java -jar cours/target/cours-0.0.1-SNAPSHOT.jar
```

Les services sont disponibles ici :

- Étudiants : <http://localhost:8081>
- Cours : <http://localhost:8082>

Laissez les deux terminaux ouverts pendant les tests.

## Lancer avec Docker

Depuis le dossier principal du projet, compilez d'abord les deux services avec `mvn clean package` (voir ci-dessus), puis lancez :

```bash
docker compose up --build
```

Pour arrêter les conteneurs, faites `Ctrl+C`, puis, si nécessaire :

```bash
docker compose down
```

**Petite remarque :** le client du service `cours` appelle actuellement `localhost:8081`. Dans Docker, cela peut empêcher `cours` de joindre le conteneur `etudiants`. De plus, certains tests Postman vérifient des réponses qui ne correspondent pas exactement au code actuel. Quelques tests peuvent donc échouer.

## Importer et utiliser les tests Postman

Le fichier de collection s'appelle **`Postman-Tests.json`** et se trouve à la racine du projet.

1. Ouvrez Postman.
2. Cliquez sur **Import**, puis choisissez **Files**.
3. Sélectionnez `Postman-Tests.json`.
4. Ouvrez la collection **ArchTp2 - Microservices Tests**. Les adresses par défaut sont `http://localhost:8081` pour les étudiants et `http://localhost:8082` pour les cours.
5. Vérifiez que les deux services sont lancés, puis envoyez les requêtes dans l'ordre. Les requêtes de création enregistrent les identifiants utilisés par les requêtes suivantes.
6. Regardez la réponse et l'onglet **Test Results** après chaque requête.

Les scénarios 1 à 4 testent les étudiants, les cours, les cours enrichis et la suppression d'un étudiant. Pour le scénario 5, envoyez d'abord **5.1**, arrêtez le service `etudiants`, puis envoyez **5.2** et **5.3**. Redémarrez ensuite `etudiants` avant d'envoyer **5.4**.

Merci d'essayer le projet !
