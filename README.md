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
   Le nom est envoyé en tant que paramètre de requête, comme dans l'URL `http://localhost:9090/greeting?name=ENSIM`. Dans le contrôleur, il est récupéré grâce à l'annotation `@RequestParam(name="nameGET", required=false, defaultValue="World")`, et ajouté au modèle via `model.addAttribute("nomTemplate", nameGET);` pour être affiché dans la vue.


4. **Avez-vous remarqué une différence dans la console H2 ?**

Une nouvelle table address a été créée dans la base de données H2 en mémoire. Cette table correspond à la classe Address que nous avons ajoutée et contient les colonnes id, creation, et content.

5. **Faites une requête de type SELECT sur la table Adress**
 Oui, lorsque l'on exécute la requête SELECT * FROM Adress;, on voit bien toutes les données insérées depuis le fichier data.sql.

6. **à quoi sert l'annotation @Autowired ?**

L'annotation @Autowired dans Spring permet d'injecter automatiquement les dépendances dans une classe. Dans ce cas, elle injecte une instance de AddressRepository dans le contrôleur AddressController pour que le contrôleur puisse utiliser les méthodes de ce repository pour accéder aux données des adresses dans la base de données, sans avoir besoin de créer manuellement cette instance. Spring gère cette injection de manière transparente au moment de l'exécution.

7. ## Ajouter Bootstrap au projet

### Méthode utilisée

Pour inclure Bootstrap dans ce projet, nous avons utilisé la méthode du CDN, qui permet de charger Bootstrap directement depuis un serveur externe sans avoir à télécharger les fichiers manuellement.

#### Étapes suivies :
Dans le fichier principal nous avons ajouté les liens suivants dans la section `<head>` :```html
   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
Nous avons ensuite utilisé les classes CSS de Bootstrap pour styliser les éléments. par exemple :

<button class="btn btn-primary">btn utilisé</button>
Pourquoi utiliser un CDN ?
 Facilité d'intégration : aucun fichier à télécharger.
 Chargement rapide : les fichiers Bootstrap sont souvent mis en cache par le navigateur.

 8.Réponses aux questions sur l'API MeteoConcept

__ Faut-il une clé API pour appeler MeteoConcept ?
   Une clé API est nécessaire pour chaque appel à l'API. Elle doit être incluse dans l'URL en tant que paramètre token.

__ Quelle URL appeler ?
      Pour récupérer les éphémérides (lever et coucher du soleil, phase lunaire) :

https://api.meteo-concept.com/api/ephemeride/0?token=CLE_API

Pour les prévisions météo journalières :

   https://api.meteo-concept.com/api/forecast/daily?token=CLE_API

__ Quelle méthode HTTP utiliser ?
La méthode HTTP utilisée est GET.

__ Comment passer les paramètres d'appels ?
Les paramètres doivent être ajoutés à l'URL sous forme de chaîne de requête :

   token : Clé API pour l'authentification.
   day : (optionnel) Permet de spécifier le jour visé (exemple : 0 pour aujourd'hui, 1 pour demain).
   lat et lon : (optionnel) Coordonnées GPS du lieu visé. Si elles ne sont pas spécifiées, la localisation par défaut du compte est utilisée.

__ Exemple d'URL avec des paramètres :

https://api.meteo-concept.com/api/forecast/daily?token=CLE_API&lat=48.112&lon=-1.6819

__Où est l'information dont on a besoin dans la réponse ?

 Pour afficher la température du lieu visé par les coordonnées GPS :
 Les informations de température minimale et maximale se trouvent dans les nœuds tmin et tmax de la réponse obtenue depuis l'endpoint /forecast/daily.
 Exemple de structure XML :

<response>
    <forecast>
        <day>0</day>
        <datetime>2025-01-09</datetime>
        <tmin>-1</tmin>
        <tmax>7</tmax>
    </forecast>
</response>

__ Pour afficher la prévision de météo du lieu visé par les coordonnées GPS :
La prévision météorologique est contenue dans les nœuds weather et probarain :

 weather : Code représentant l'état du ciel.
 probarain : Probabilité de pluie en pourcentage.
 Exemple de structure XML :

<response>
    <forecast>
        <day>0</day>
        <datetime>2025-01-09</datetime>
        <weather>12</weather>
        <probarain>45</probarain>
    </forecast>
</response>

![image](https://github.com/user-attachments/assets/fae6ee5c-97f7-44c6-ba03-3d180ec163ae)

![image](https://github.com/user-attachments/assets/5dba4860-e4a9-4434-ac20-99a65da7c9ff)
![image](https://github.com/user-attachments/assets/44f44604-1ff0-4f1f-bc62-ca663f528adb)
![image](https://github.com/user-attachments/assets/64484d51-9ab7-499e-ac91-a502af2d63a5)


