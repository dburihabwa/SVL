############################################
3. Modélisation de l'utilisation du verrou
############################################
Q2
a. La vérification d'ispin comme décrite à la section 2 ne révèle pas d'interblocage.
b. La proposition LTL b vérifie cette propriété. L'accès au verrou est fait de manière atomique empéchant les deux processus de l'occuper au même moment. 
c. La proposition LTL c vérifie cette propriété.
d. La proposition LTL d vérifie cette propriété.

Q3
La proposition LTL e n'est pas vérifiée par notre programme.
En effet, si A s'exécute en premier et met son état en attente puis passe la main à B, B peut s'exécuter tout seul à l'infini.

Q4
a. La proposition LTL f n'est pas vérifiée car dans le cas où le processus B  prend le verrou et cycle, l'état de A reste inactif sans jamais passer enAttente.
b. La proposition LTL g est vérifiée car le passage à l'état actif puis l'état inactif se fait dans la zone de code protégée par le verrou.


############################################
4.  Travail préliminaire sur l'association verrou et préemption
############################################

