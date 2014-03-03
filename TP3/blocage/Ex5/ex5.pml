mtype {libre, occupe, inactif, enAttente, actif}
mtype verrou = libre;
mtype etatHaut = inactif;
mtype etatBas = inactif;
mtype etatMoyen = inactif;

proctype haut(){
	do ::
		etatHaut = enAttente;
		atomic { verrou == libre; verrou = occupe;}
		etatHaut = actif;
		etatHaut = inactif;
		verrou = libre;		
	od;
}

proctype moyen(){
	do ::
		etatHaut == inactif -> etatMoyen = enAttente;
		etatHaut == inactif -> etatMoyen = actif;
		etatHaut == inactif -> etatMoyen = inactif;
	od;
}

proctype bas(){
	do ::
		etatMoyen == inactif -> etatBas = enAttente;
		etatMoyen == inactif ->
		atomic { verrou == libre; verrou = occupe;}
		etatMoyen == inactif -> etatBas = actif;
		etatMoyen == inactif -> etatBas = inactif;
		verrou = libre;		
	od;
}

init {
	run haut(); run moyen(); run bas();
}
