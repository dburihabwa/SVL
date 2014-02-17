chan canal1 = [0] of {bit};
chan canal2 = [0] of {bit};

proctype A() {
  if
    :: canal1 ! 0;
    :: canal2 ! 0;
  fi	 
}

proctype B() {
  canal1?_;
}

proctype C() {
  canal2?_;
}

init {
  run A(); run B(); run C();
}