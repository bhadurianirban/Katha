/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.browse;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.ksaman.core.DTO.WordsDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "wordFirstChar")
@ViewScoped
public class WordFirstChar implements Serializable {

    /**
     * Creates a new instance of WordspaadSuchiList
     */
    private List<WordsDTO> wordFirstCharList;
    private WordsDTO selectedWordFirstChar;
    private String firstChar;

    public void loadWordFirstCharList() {
        KSCoreService ksCoreService = new KSCoreService();
        wordFirstCharList = ksCoreService.getShlokaWordUniqueFirstCharList();

    }
    
    public String goToWordListByFirstChar() {
        firstChar = selectedWordFirstChar.getWordFirstChar();
        return "WordListByFirstChar";
    }

    public List<WordsDTO> getWordFirstCharList() {
        return wordFirstCharList;
    }

    public void setWordFirstCharList(List<WordsDTO> wordFirstCharList) {
        this.wordFirstCharList = wordFirstCharList;
    }

    public WordsDTO getSelectedWordFirstChar() {
        return selectedWordFirstChar;
    }

    public void setSelectedWordFirstChar(WordsDTO selectedWordFirstChar) {
        this.selectedWordFirstChar = selectedWordFirstChar;
    }
    
    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
    
}
