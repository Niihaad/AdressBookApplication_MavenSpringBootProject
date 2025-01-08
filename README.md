# AdressBookApplication_MavenSpringBootProject
AdressBookApplication_MavenSpringBootProject
# Demo Spring Boot Project

## Description
Ce projet est une application Spring Boot démonstrative utilisée pour explorer des fonctionnalités telles que la persistance des données avec Hibernate, l'utilisation d'une base de données H2, et la création de contrôleurs pour exposer des données via des URL.

---

## Dépendances ajoutées

### 1. **Spring Boot Starter Web**
- **Description** : Fournit les outils nécessaires pour construire des applications web, y compris les contrôleurs REST et la gestion des serveurs intégrés (comme Tomcat).
- **Utilisation dans le projet** : Permet de créer des endpoints REST et de servir des fichiers HTML avec Thymeleaf.

### 2. **Spring Boot Starter Thymeleaf**
- **Description** : Intègre le moteur de templates Thymeleaf dans les projets Spring Boot pour générer des pages HTML dynamiques.
- **Utilisation dans le projet** : Utilisé pour créer des vues dynamiques comme `addresses.html` qui affichent des données de la base.

### 3. **Spring Boot Starter Data JPA**
- **Description** : Fournit des fonctionnalités pour interagir avec des bases de données relationnelles via l'API JPA (Java Persistence API).
- **Utilisation dans le projet** : Utilisé pour définir l'entité `Address` et accéder aux données à travers `AddressRepository`.

### 4. **H2 Database**
- **Description** : Une base de données relationnelle embarquée écrite en Java. Idéale pour des tests et des projets de démonstration.
- **Utilisation dans le projet** : Sert de base de données pour stocker les adresses dans ce projet.

### 5. **Spring Boot DevTools**
- **Description** : Fournit des outils pour accélérer le développement, notamment un rechargement automatique des modifications et une expérience simplifiée pour les développeurs.
- **Utilisation dans le projet** : Facilite les tests rapides en rechargeant l'application à chaque modification du code.

---

## Réponses aux quetsions du TP 

1. **URL d'appel `/greeting` :**
   L'URL d'appel est paramétrée avec l'annotation `@GetMapping("/greeting")` sur la méthode `greeting()` du contrôleur `HelloWorldController.java`.

2. **Fichier HTML à afficher :**
   Le fichier HTML à afficher est choisi par la ligne `return "greeting";`, qui indique à Spring Boot de rendre le fichier `greeting.html` situé dans le répertoire `src/main/resources/templates`.

3. **Envoi du nom :**
   Le nom est envoyé en tant que paramètre de requête, comme dans l'URL `http://localhost:8080/greeting?name=ENSIM`. Dans le contrôleur, il est récupéré grâce à l'annotation `@RequestParam(name="nameGET", required=false, defaultValue="World")`, et ajouté au modèle via `model.addAttribute("nomTemplate", nameGET);` pour être affiché dans la vue.
