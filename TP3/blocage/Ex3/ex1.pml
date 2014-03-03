mtype {libre, occupe, inactif, enAttente, actif}
mtype verrou = libre;
mtype etatA = inactif;
mtype etatB = inactif;

ltl b { [](!(verrou == occupe && etatA == actif && etatB == actif)) }
ltl c { !(<>[](etatA == actif)) }
ltl d { [](etatA == actif ->(verrou == occupe)) }
ltl e { []((etatA == enAttente) -> <>(etatA == actif))}
// ltl f { []((etatA == inactif || etatB == inactif) -> X(etatA == enAttente || etatB == enAttente))}

 ltl f { [](((etatA == inactif) -> (etatA == inactif) U (etatA == enAttente)) && 
		((etatB == inactif) -> ((etatB == inactif) U (etatB == enAttente)))) }
 
ltl g { [](((etatA == actif) -> (etatA == actif) U (etatA == inactif)) && 
		((etatB == actif) -> ((etatB == actif) U (etatB == inactif)))) }
proctype A(){
	do ::
		etatA = enAttente;
		atomic { verrou == libre; verrou = occupe;}
		etatA = actif;
		etatA = inactif;
		verrou = libre;		
	od;
}

proctype B(){
	do ::
		etatB = enAttente;
		atomic { verrou == libre; verrou = occupe;}
		etatB = actif;
		etatB = inactif;
		verrou = libre;
	od;
}

init {
	run A(); run B();

}
