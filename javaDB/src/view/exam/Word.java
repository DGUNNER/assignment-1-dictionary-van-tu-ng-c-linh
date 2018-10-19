package view.exam;

public class Word {
    private String wordEng;
    private String wordVi;

    public Word(String wordEng, String wordVi) {
        this.wordEng = wordEng;
        this.wordVi = wordVi;
    }

    public String getWordEng() {
        return wordEng;
    }

    public void setWordEng(String wordEng) {
        this.wordEng = wordEng;
    }

    public String getWordVi() {
        return wordVi;
    }

    public void setWordVi(String wordVi) {
        this.wordVi = wordVi;
    }
}
