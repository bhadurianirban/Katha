/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bhaduri.ksaman.edit.tika;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.hedwig.cloud.response.HedwigResponseCode;
import org.ksaman.core.DTO.TikaDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "tikaList")
@ViewScoped
public class TikaList implements Serializable{

    /**
     * Creates a new instance of ReferencedTextTabView
     */
    private List<TikaDTO> tikaDTOList;
//    private TikaDTO referencetextDTO;
//    private List<TikaDTO> selectedReferencetextDTOs;
    private TikaDTO selectedTika;
    private int parvaId;
    private int adhyayId;
    private int shlokaNum;
    private int shlokaLine;
    private int tikaId;

    
    
    public void loadTikaList() {
        KSCoreService ksCoreService = new KSCoreService();
        shlokaLine = 1;
        tikaDTOList = ksCoreService.getReftextList(parvaId, adhyayId, shlokaNum, shlokaLine);
        
    }
    public String editTika() {
        tikaId= selectedTika.getRefTextId();
        return "EditTika";
    }
    public String deleteTika() {
        shlokaLine = 1;
        tikaId= selectedTika.getRefTextId();
        TikaDTO tikaDTO = new TikaDTO();
        tikaDTO.setParvaId(parvaId);
        tikaDTO.setAdhyayId(adhyayId);
        tikaDTO.setShlokaNum(shlokaNum);
        tikaDTO.setShlokaLine(shlokaLine);
        tikaDTO.setRefTextId(tikaId);
        
        KSCoreService kscs = new KSCoreService();
        int responseCode = kscs.deleteTika(tikaDTO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        if (responseCode == HedwigResponseCode.SUCCESS) {
            fm = new FacesMessage("Alert", "Tika added Successfully.");
            context.addMessage(null, fm);
            return "TikaList";
        } else {
            fm = new FacesMessage("Alert", "Contact DB Admin");
            context.addMessage(null, fm);
            return "TikaList";
        }
        
    }

    public List<TikaDTO> getTikaDTOList() {
        return tikaDTOList;
    }

    public void setTikaDTOList(List<TikaDTO> tikaDTOList) {
        this.tikaDTOList = tikaDTOList;
    }

    public TikaDTO getSelectedTika() {
        return selectedTika;
    }

    public void setSelectedTika(TikaDTO selectedTika) {
        this.selectedTika = selectedTika;
    }

    public int getParvaId() {
        return parvaId;
    }

    public void setParvaId(int parvaId) {
        this.parvaId = parvaId;
    }

    public int getAdhyayId() {
        return adhyayId;
    }

    public void setAdhyayId(int adhyayId) {
        this.adhyayId = adhyayId;
    }

    public int getShlokaNum() {
        return shlokaNum;
    }

    public void setShlokaNum(int shlokaNum) {
        this.shlokaNum = shlokaNum;
    }

    public int getShlokaLine() {
        return shlokaLine;
    }

    public void setShlokaLine(int shlokaLine) {
        this.shlokaLine = shlokaLine;
    }

    public int getTikaId() {
        return tikaId;
    }

    public void setTikaId(int tikaId) {
        this.tikaId = tikaId;
    }

  
    


    
 
          
}
