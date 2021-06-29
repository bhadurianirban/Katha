/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bhaduri.ksaman.edit.tika;

import java.io.Serializable;
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
@Named(value = "addTika")
@ViewScoped
public class AddTika implements Serializable {

    /**
     * Creates a new instance of AddNewReference
     */
    private TikaDTO tikaDTO;
    private int parvaId;
    private int adhyayId;
    private int shlokaNum;
    private int shlokaLine;
    private int refTextId;
    private String refText;
    private int refTextPosition;
    
    public void loadAddTika() {
        
    }
    public String add() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;

        tikaDTO = new TikaDTO();

        tikaDTO.setParvaId(parvaId);
        tikaDTO.setAdhyayId(adhyayId);
        tikaDTO.setShlokaLine(1);
        tikaDTO.setShlokaNum(shlokaNum);
        tikaDTO.setRefTextId(refTextId);
        tikaDTO.setRefText(refText);
        tikaDTO.setRefTextPosition(0);
        

        KSCoreService kSCoreService = new KSCoreService();
        responseCode = kSCoreService.addTika(tikaDTO);

        if (responseCode == HedwigResponseCode.SUCCESS) {
            fm = new FacesMessage("Alert", "Tika added Successfully.");
            context.addMessage(null, fm);
            return "TikaList";
        } else if (responseCode == HedwigResponseCode.DB_DUPLICATE) {
            fm = new FacesMessage("Alert", "Tika already exsists.");
            context.addMessage(null, fm);
            return "AddTika";
        } else {
            fm = new FacesMessage("Alert", "Contact DB Admin");
            context.addMessage(null, fm);
            return "TikaList";
        }
    }

    public TikaDTO getTikaDTO() {
        return tikaDTO;
    }

    public void setTikaDTO(TikaDTO tikaDTO) {
        this.tikaDTO = tikaDTO;
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

    public int getRefTextId() {
        return refTextId;
    }

    public void setRefTextId(int refTextId) {
        this.refTextId = refTextId;
    }

    public String getRefText() {
        return refText;
    }

    public void setRefText(String refText) {
        this.refText = refText;
    }

    public int getRefTextPosition() {
        return refTextPosition;
    }

    public void setRefTextPosition(int refTextPosition) {
        this.refTextPosition = refTextPosition;
    }



    
    
    
}
