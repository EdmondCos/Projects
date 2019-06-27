public class Board {
//    String[] library = {"masa", "casa", "para", "merisoare", "cangur",
//            "dulceata", "telefon", "cablu", "patine", "noapte"};

    private Word[] word;

    Board(String cuvant) {
        word = new Word[cuvant.length()];
        char[] x = cuvant.toCharArray();
        for (int i = 0; i < cuvant.length(); i++) {
            word[i] = new Word(x[i]);
        }
    }

    private int counterL = 0;
    private int counterW = 0;

    int leterReveal(char letter) {
        for (Word l : word) {
            if (l.letter == letter) {
                l.hide = false;
                counterW++;
                return counterL;
            }
        }
        return ++counterL;
    }

    boolean isGameOver() {
        if (counterL == 5) {
            return true;
        } else {
            return counterW == word.length;
        }
    }


    String print() {
        StringBuilder x = new StringBuilder();
        for (Word l : word) {
            if (l.hide) {
                x.append('_');
            } else {
                x.append(l.letter);
            }
        }
        return x.toString();
    }

}
