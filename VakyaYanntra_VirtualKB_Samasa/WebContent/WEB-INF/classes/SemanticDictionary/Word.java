/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SemanticDictionary;

/**
 *
 * @author user
 */
public class Word {

    String word;
    String meaning;
    String pos;
    String translation;

    public Word(String word, String meaning, String pos, String translation) {
        this.word = word;
        this.meaning = meaning;
        this.pos = pos;
        this.translation = translation;
    }
    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

}
