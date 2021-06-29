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
 * @author bhaduri
 */
@Named(value = "editTika")
@ViewScoped
public class EditTika implements Serializable {

    /**
     * Creates a new instance of EditTika
     */
    private int parvaId;
    private int adhyayId;
    private int shlokaNum;
    private int shlokaLine;
    private int tikaId;
    private String tikaText;

    public EditTika() {
    }

    public void loadEditTika() {
        shlokaLine = 1;
        TikaDTO tikaDTO = new TikaDTO();
        tikaDTO.setParvaId(parvaId);
        tikaDTO.setAdhyayId(adhyayId);
        tikaDTO.setShlokaNum(shlokaNum);
        tikaDTO.setShlokaLine(shlokaLine);
        tikaDTO.setRefTextId(tikaId);
        KSCoreService kscs = new KSCoreService();
        tikaDTO = kscs.getTikaDetails(tikaDTO);
        tikaText = tikaDTO.getRefText();

    }

    public String save() {
        shlokaLine = 1;
        TikaDTO tikaDTO = new TikaDTO();
        tikaDTO.setParvaId(parvaId);
        tikaDTO.setAdhyayId(adhyayId);
        tikaDTO.setShlokaNum(shlokaNum);
        tikaDTO.setShlokaLine(shlokaLine);
        tikaDTO.setRefTextId(tikaId);
        tikaDTO.setRefText(tikaText);
        KSCoreService kscs = new KSCoreService();
        int responseCode = kscs.updateTika(tikaDTO);
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
            return "EditTika";
        }
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

    public String getTikaText() {
        return tikaText;
    }

    public void setTikaText(String tikaText) {
        this.tikaText = tikaText;
    }

}
