# Rendu 3: Projet Compétition

## **Auteurs**

 - FATHALLAH Mohamed Amine (mohammedamine.fathallah.etu@univ-lille.fr)
 - AMEUR Hedi (hedi.ameur.etu@univ-lille.fr)

 - Groupe : 7


 ## **Introduction.**

 Le projet porte sur la création d'une application permettant d'organiser une compétition sportive et de la faire jouer.

 Les compétitions sportives sont caractérisées par un ensemble de matchs qui se jouent entre différents compétiteurs.

 Une compétition permet de jouer ses matchs jusqu'à ce qu'il ne reste qu'un seul gagnant désigné comme un vainqueur.

 Nous considérons qu'il existe 2 types de compétitions sportives:

   * Les championnats (League): se jouent en matchs aller/retour

   * Les tournois (Tournament): se jouent en plusieurs tours, -à chaque tour- seuls les vainquants ayant gagné leurs matchs participent au tour suivant, jusqu'à ce qu'il ne reste qu'un gagnant.

   * Les masters(Master): se jouent en 2 phases, la 1ère phase contient des poules, chaque poule joue une League. Les gagnants de cette phase sont séléctionnés pour jouer la seconde qui est un Tournoi.

 dans la compétition, il y a forcément un gagnant à chaque match.


 ## **L'arborescence du projet**

 ```bash
 .projet-competitions
     |
     └── Competittions
          ├── readme.md
          ├── uml
          │   └── UML-3.PNG
          ├── .gitignore
          ├── src
          │   ├── competition
          │   │   ├── Competition.java
          │   │   ├── League.java
          │   │   ├── Master.java
          │   │   └── Tournament.java
          │   ├── competitor
          │   │   └── Competitor.java
          │   ├── match
          │   │   ├── Match.java
          |   |   └── MatchRandom.java
          |   ├── exception
          │   │   ├── ErrorNumberParticipants.java
          |   |   └── NumberInsufisant.java
          │   ├── selection
          │   │   ├── Selection.java
          │   │   ├── TopOfGroup.java
          │   │   └── Util.java
          │   ├── util
          │   │   └── MapUtil.java
          │   ├── main
          │   │   ├── Main.java
          │   │   ├── LeagueMain.java
          │   │   ├── MainObserver.java
          │   │   └── TournamentMain.java
          │   ├── observer
          │   │   ├── BookMaker.java
          │   │   ├── Journalist.java
          │   │   ├── CompetitonEvent.java
          │   │   └── CompetitionListener.java
          ├── jar
          │   └── MANIFEST.MF
          └── test
              ├── competition
              │   ├── TestCompetition.java
              │   ├── TestLeague.java
              │   ├── TestMaster.java
              │   └── TestTournament.java
              ├── competitor
              │   └── TestCompetitor.java
              ├── match
              │   ├── TestMatch.java
              │   └── TestMatchRandom.java
              ├── selection
              │   ├── TestTopOfGroup.java
              │   └── TestUtil.java
              ├── observer
              │   └── TestBookMaker.java
              └── util
                  └── TestMapUtil.java
 ```

 ##  **HOW TO**

 ### **Récupération des données**

 Pour récupérer les données du projet, suivez les étapes suivantes :

 * Si vous avez déjà une version locale du dépôt Git :
     * il vous suffit d'exécuter la commande shell suivante :
         ``` bash
         $ git pull
         ```
     Vous aurez ensuite accès à tous les fichiers du projet, et vous pourrez l'ouvrir dans
     un éditeur de texte.


 * Si vous n'avez pas encore de version locale du dépôt :
     * Exécutez la commande suivante pour créer une version locale du dépôt dans
     le dossier *dossier-projet-coo* :
         ```bash
         $ git clone https://gitlab-etu.fil.univ-lille1.fr/fathallah/projet-competitions.git
         ```
         (**Attention**, le dossier doit être vide originellement)

     * Si vous préférez utiliser votre clé SSH (si elle est configurée sur votre machine) :
         ```bash
         $ git clone git@gitlab-etu.fil.univ-lille1.fr:fathallah/projet-competitions.git
         ```
     Vous aurez de cette manière accès aux différents fichiers du projet. Pour mettre
      à jour ces fichiers, utilisez la commande précisée ci-dessus.


### **Génération de la documentation**
* Pour générer la documentation, Placez-vous dans le dossier src et passez la commande suivante :
  ```bash
  $ javadoc -d ../docs -subpackages competition
  ```
 Pour la consulter, ouvrez le fichier index.html qui se trouve dans le dossier docs.

 Les documentations sont rangées dans le dossier /docs situé à la racine.

### **Compilation des sources du projet (à faire en premier)**

* Pour compiler les sources du projet, placez-vous à la racine du projet (competitions) et lancez les commandes suivantes :

  ```bash
  $ mkdir classes
  ```
  Ensuite, mettez-vous dans le dossier src et lancez la commande suivante:
  ```bash
  $ javac competition/*.java -d ../classes
  ```

### **Compilation et execution des tests**

* Pour compiler toutes les classes de tests, on a utilisé comme outil l'éditeur de text Java Eclipse.

## **Execution du programme avec le .jar executable**

  placez-vous dans le dossier competition/classes et ensuite, passez la commande suivante:

  ```bash
  $ jar cvfm ../jar/main.jar ../jar/MANIFEST.MF *
  ```

	Ensuite placez vous au dossier(encore à la racine) competition et passez la commande suivante :
  ```bash
	$ java -jar jar/main.jar
  ```

## **DIagramme UML(A jour avec la VERSION 2)**
le diagramme uml est fournit sous forme d'image dans le dossier /uml


## **Points forts du projet**


La flexibilité du code, la création d'un projet extensible qui s'adapte aux nouvelles fonctionnalités était parmis nos objectifs primordiaux.

On revient toujours sur le point de représenter le code le plus simple possible et le plus maintenable. En pratique, nous avons appliqué l'abstraction dans les classes de test ce qui est le cas pour la classe TestCompetition. Cela nous a permis d'éviter les répétitions du code dans les sous-classes Test ainsi de le rendre plus maintenable. Par exemple, si jamais nous pensons à ajouter d'autres types de compétition, nous aurons qu'à ajouter les méthodes de test propres à cette classe dans sa classe test.

D'un autre point, nous avons essayé de tester toutes les classes, même celles qui sont abstraites. En effet, cela sous entend l'utilisation des Mocks. Durant tout le projet, (dont on les a appelé [inheritedClass]), nous avons pu constater l'utilité réelle des mocks et comment les utiliser. Par conséquent, vous allez trouver que les mocks sont utilisés partout dans les tests, par exemple pour tester la méthode play() de Competition, elle fait bien un appel à la méthode abstraite play(list).


### **Concernant la conception des Matchs**

Un match se joue entre 2 joueurs et se conclut nécessairement par un vainqueur.


### **Concernant la conception des Compétitions**

Une compétition est définie par un ensemble de match qui se jouent entre les compétiteurs.

**Remarque** ***Pour le cas du tournoi, l'ensemble des matches n'est construit sauf si le nombre des compétiteurs est de puissance de 2, sinon une exception est levée et on affiche à l'utilisateur que le tournoi ne peut pas être commencé sauf si le nombre est bien de puissance de 2.***

## **Les designs patterns dans la deuxiéme version**

* **Strategy**
Nous avons considéré les méthodes de séléction comme  stratégies.
- - un attribut représentant la séléction qui est d'un type abstrait dans la classe Master.
- - On peux ajouter d'autres types de selection, en faisant varier le type concret de la stratégie(Selection) on change le comportement apparent de la classe Master.

## **Améliorations éventuelles**

Lors d'un Tournoi si on rentre une liste de compétiteurs qui n'est pas de puissance de 2, au lieu d'arreter le programme(et d'afficher à l'utilisateur que le nombre doit etre puissance de 2), nous pouvons arrondir le nombre(ajouter des compétiteur automatiquement pour compléter la liste) et se débrouiller à ce que l'ensemble des matchs soit bien remplit dans tous les cas.  

Nous avons supposé que le nombre de compétiteurs à la création de la compétition Master doit être un nombre pair, pour une répartition équilibrée au sein de chaque poule.

Par exemple, si on a 5 compétiteurs(nombre impair) dans la liste, alors leurs répartition au sein de chacune des poules ne sera pas équilibrée dans ce cas, puisque nous aurons par exemple une poule de trois compétiteurs et une autre de deux compétiteurs.

## **Concernant la conception des Sélections**
Une selection est une interface dans laquelle on définit trois méthodes.
Si on est en besoin d'ajouter d'autre types de selection, il faut juste ajouter autre classe qui implementes de la classes interface Selection,et modifier les trois méthodes selon le cahier des charges.



## **La conception pour le troisième rendu**
Notre conception repose sur le design pattern Observer, dans ce qui suit on détaillera les étapes suivi:

### **Définition d'un événement CompetitionEvent**
Premièrement nous avons définit une classe d'événement nommé CompetitionEvent, va nous permettre de notifier les observateurs à chaque match.
Les bookmakers sont des observateurs d'une compétition, ils assistent à tous les matchs d'une compétition. En terme de conception, se sont un des observateurs(ou Listener) dans le modèle Observer.

### **Définition d'une interface CompetitionListener**
C'est une interface qui contient pour chaque événement une méthode qui sera déclenchée lors de la notification des bookmaker et journalises. En l'occurence, on appelle cette méthode competitionPlayed(CompetitionEvent) qui prend en paramètre l'événement déclenché, et la méthode permet de notifier les bookmaker et les journalistes que la compétitions est entrain de se jouer.

### **Définition des classes observateurs: BookMaker & Journaliste**
Les bookmaker et journaliste sont des classes concrètes du Listener associée, donc ils doivent implémenter l'interface CompétitionListener.

#### **Pour Journaliste**  
Les journalistes diffusent le résultat de chaque match, donc l'implémentation de la méthode *competitionPlayed(CompetitionEvent)* se fait par une boucle sur l'ensemble de match joué par la compétition et à chaque itération on affiche le résultat de ce match.

#### **Pour BookMaker**
Les bookmakers font évoluer les cotes en fonction des résultats de chaque match.
La classe Bookmaker possède un attribut de type Map, afin d'attribuer à chaque compétiteur sa cote. Dans notre conception nous avons déterminé que la cote de chacun des compétiteurs est initialisée à 1.
La méthode *competitionPlayed(CompetitonEvent)* est implémenté pour faire un affichage des cotes de chaque compétiteur de chque match, ainsi les cotes sont misent à jour au cour des différents matchs. Enfin, à l'issu de la compétition on arrive à afficher le total des cotes cumulées de chaque joueur.
Une méthode spéciale nommée *fillsTheOddsMap()*, permet de calculer les cotes associées en fonction du résultat du match. En particulier, si un compétiteur perd on incrémente sa cote de 1 et on la baisse à son adversaire.
