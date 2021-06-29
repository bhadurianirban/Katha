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
import org.ksaman.core.DTO.MaintextDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "shlokLineFirstChar")
@ViewScoped
public class ShlokLineFirstChar implements Serializable {

    /*
     * Creates a new instance of ShlokapaadSuchiList
     */
    private List<MaintextDTO> shlokLineFirstCharList;
    private MaintextDTO selectedFirstChar;
    private String firstChar;

    public void loadAllShlokLineFirstChar() {
        KSCoreService ksCoreService = new KSCoreService();
        shlokLineFirstCharList = ksCoreService.getShlokaUniqueFirstCharList();

//        for (int i = 0; i < shlokLineFirstCharList.size(); i++) {
//            firstChar = shlokLineFirstCharList.get(i).getFirstChar();
//        }
    }
    
    public String shlokaListView() {
        firstChar = selectedFirstChar.getFirstChar();
        return "ShlokLineListByFirstChar";
    }

    public List<MaintextDTO> getShlokLineFirstCharList() {
        return shlokLineFirstCharList;
    }

    public void setShlokLineFirstCharList(List<MaintextDTO> shlokLineFirstCharList) {
        this.shlokLineFirstCharList = shlokLineFirstCharList;
    }

    public MaintextDTO getSelectedFirstChar() {
        return selectedFirstChar;
    }

    public void setSelectedFirstChar(MaintextDTO selectedFirstChar) {
        this.selectedFirstChar = selectedFirstChar;
    }

    public String getFirstChar() {
        return firstChar;
    }

    public void setFirstChar(String firstChar) {
        this.firstChar = firstChar;
    }
}
