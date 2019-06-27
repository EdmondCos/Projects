class Board {
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
    private char[] letters = new char[30];
    private int m = 0;

    boolean isMatch(char letter) {
        while (true) {
            for (char i : letters) {
                if (i == letter) ;
                break;
            }
            letters[m++] = letter;
            break;
        }
        boolean bol = false;
        for (Word l : word) {
            if (l.letter == letter) {
                l.hide = false;
                counterW++;
                bol = true;
            }
        }
        if(bol){
            return true;
        }
        counterL++;
        return false;
    }

    boolean isLetterRepeated(char letter) {
        for (char c : letters) {
            if (c == letter) {
                return true;
            }
        }
        return false;
    }

    boolean isGameOver() {
        if (counterL == 20) {
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
