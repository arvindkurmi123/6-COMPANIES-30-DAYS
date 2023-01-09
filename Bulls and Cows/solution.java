class solution {
  public String getHint(String secret, String guess) {
    HashMap<Integer, Boolean> mp = new HashMap<Integer, Boolean>();
    HashMap<Integer, Boolean> mp2 = new HashMap<Integer, Boolean>();

    for (int i = 0; i < secret.length(); i++) {
      mp.put(i, false);
      mp2.put(i, false);
    }
    int b = 0;

    for (int i = 0; i < guess.length(); i++) {
      if (guess.charAt(i) == secret.charAt(i)) {
        b++;
        mp.put(i, true);
        mp2.put(i, true);
      }
    }

    int c = 0;
    for (int i = 0; i < guess.length(); i++) {
      int j = 0;
      while (j < secret.length()) {
        if (i != j) {
          if (guess.charAt(i) == secret.charAt(j) && !mp.get(j) && !mp2.get(i)) {
            c++;
            mp.put(j, true);
            mp2.put(i, true);
          }
        }

        j++;
      }

    }
    String answer = Integer.toString(b) + "A" + Integer.toString(c) + "B";
    return answer;

  }
}