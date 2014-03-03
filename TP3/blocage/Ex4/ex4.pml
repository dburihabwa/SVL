mtype {libre, occupe, inactif, enAttente, actif}
mtype verrou = libre;
mtype etatHaut = inactif;
mtype etatBas = inactif;

ltl b { [](!(verrou == occupe && etatHaut == actif && etatBas == actif)) }
ltl c { !(<>[](etatHaut == actif)) }
ltl d { [](etatHaut == actif ->(verrou == occupe)) }
ltl e { []((etatHaut == enAttente) -> <>(etatHaut == actif))}
// ltl f { []((etatHaut == inactif || etatBas == inactif) -> X(etatA == enAttente || etatBas == enAttente))}

 ltl f { [](((etatHaut == inactif) -> (etatHaut == inactif) U (etatHaut == enAttente)) && 
		((etatBas == inactif) -> ((etatBas == inactif) U (etatBas == enAttente)))) }
 
ltl g { [](((etatHaut == actif) -> (etatHaut == actif) U (etatHaut == inactif)) && 
		((etatBas == actif) -> ((etatBas == actif) U (etatBas == inactif)))) }
proctype haut(){
	do ::
		etatHaut = enAttente;
		atomic { verrou == libre; verrou = occupe;}
		etatHaut = actif;
		etatHaut = inactif;
		verrou = libre;		
	od;
}

proctype bas(){
	do ::
		etatHaut == inactif -> etatBas = enAttente;
		etatHaut == inactif ->
		atomic { verrou == libre; verrou = occupe;}
		etatHaut == inactif -> etatBas = actif;
		etatHaut == inactif -> etatBas = inactif;
		etatHaut == inactif -> verrou = libre;
		
	od;
}

init {
	run haut(); run bas();

}
