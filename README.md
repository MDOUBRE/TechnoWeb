# TechnoWeb

DOUBRE Maxime
DELMAS Nicolas

Pour éxécuter notre application, nous avons fait un ant et vous devez donc rentrer les commandes suivantes :

ant compile pour compiler les .class
ant exe pour lancer le serveur


Si toute fois, vous avez une erreur lors de ces commandes avec ant, vous devez faire dans le terminal les commandes suivantes :

javac -d build -cp "lib/*" src/*.java   pour compiler tous les fichiers
java -cp "lib/*;build" Main             pour lancer le serveur et éxécuter l'application


Ensuite pour accéder à l'application web :
http://localhost:4567/