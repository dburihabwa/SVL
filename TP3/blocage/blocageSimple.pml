/* un interblocage */
chan canal = [0] of {bit};

proctype B() {
  canal?_;
}

proctype C() {
  canal?_;
}

init {
  run B(); run C();
}