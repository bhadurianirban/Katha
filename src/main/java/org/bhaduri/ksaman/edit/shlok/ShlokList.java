/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bhaduri.ksaman.edit.shlok;

import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.hedwig.cloud.response.HedwigResponseCode;
import org.ksaman.core.DTO.MaintextDTO;
import org.ksaman.core.DTO.ParvaDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "shlokList")
@ViewScoped
public class ShlokList implements Serializable {

    /**
     * Creates a new instance of ShlokaListTabView
     */
    private List<MaintextDTO> shlokaDTOList;
    private MaintextDTO selectedShloka;
    private int parvaId;
    private String parvaName;
    private int adhyayId;
    private int ubachaId;
    private int shlokaLine;
    private int shlokaNum;
    private String ubachaName;
    private String ubachaBachan;
    private String shlokaText;

    public void loadAllShlokaList() {
        KSCoreService ksCoreService = new KSCoreService();
        shlokaDTOList = ksCoreService.getShlokaList(parvaId, adhyayId);
        ParvaDTO parvaDTO = new ParvaDTO();
        parvaDTO.setParvaId(parvaId);
        parvaDTO = ksCoreService.getParvaDTO(parvaDTO);
        parvaName = parvaDTO.getParvaName();
        for (int i = 0; i < shlokaDTOList.size(); i++) {

            ubachaId = shlokaDTOList.get(i).getUbachaId();
            ubachaName = shlokaDTOList.get(i).getUbachaName();
            ubachaBachan = shlokaDTOList.get(i).getUbachaBachan();

            shlokaText = shlokaDTOList.get(i).getShlokaText();
            shlokaLine = shlokaDTOList.get(i).getShlokaLine();
            shlokaNum = shlokaDTOList.get(i).getShlokaNum();
        }
    }
    
    public String addShlokaBtn() {
        return "AddShlok";
    }

    public String editShlok() {
        shlokaNum= selectedShloka.getShlokaNum();
        shlokaLine = selectedShloka.getShlokaLine();
        return "EditShlok";
    }
    
    public String viewFullShlok() {
        shlokaNum= selectedShloka.getShlokaNum();
        shlokaLine = selectedShloka.getShlokaLine();
        return "FullShlokView";
    }
    
    public String deleteShloka() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.getExternalContext().getFlash().setKeepMessages(true);
        FacesMessage fm;
        int responseCode;
        
        MaintextDTO maintextDTO = new MaintextDTO();
        
        maintextDTO.setParvaId(parvaId);
        maintextDTO.setAdhyayId(adhyayId);
        maintextDTO.setShlokaNum(selectedShloka.getShlokaNum());
        maintextDTO.setShlokaLine(selectedShloka.getShlokaLine());
        
        KSCoreService ksCoreService = new KSCoreService();
        responseCode = ksCoreService.removeShloka(maintextDTO);
        
        if (responseCode == HedwigResponseCode.SUCCESS) {
            fm = new FacesMessage("Shloka delete alert:", "Shloka data deleted Successfully.");
            context.addMessage(null, fm);
            return "ShlokList";
        } else if (responseCode == HedwigResponseCode.DB_NON_EXISTING) {
            fm = new FacesMessage("Shloka delete alert:", "Selected Shloka not found.");
            context.addMessage(null, fm);
            return "ShlokList";
        } else {
            fm = new FacesMessage("Shloka delete alert:", "Something went wrong, please contact admin.");
            context.addMessage(null, fm);
            return "ShlokList";
        }
    }
    
    public String anubad() {
        shlokaNum= selectedShloka.getShlokaNum();
        return "AddEditAnubad";
    }

    public List<MaintextDTO> getShlokaDTOList() {
        return shlokaDTOList;
    }

    public void setShlokaDTOList(List<MaintextDTO> shlokaDTOList) {
        this.shlokaDTOList = shlokaDTOList;
    }

    public MaintextDTO getSelectedShloka() {
        return selectedShloka;
    }

    public void setSelectedShloka(MaintextDTO selectedShloka) {
        this.selectedShloka = selectedShloka;
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

    public int getUbachaId() {
        return ubachaId;
    }

    public void setUbachaId(int ubachaId) {
        this.ubachaId = ubachaId;
    }

    public int getShlokaLine() {
        return shlokaLine;
    }

    public void setShlokaLine(int shlokaLine) {
        this.shlokaLine = shlokaLine;
    }

    public int getShlokaNum() {
        return shlokaNum;
    }

    public void setShlokaNum(int shlokaNum) {
        this.shlokaNum = shlokaNum;
    }

    public String getUbachaName() {
        return ubachaName;
    }

    public void setUbachaName(String ubachaName) {
        this.ubachaName = ubachaName;
    }

    public String getUbachaBachan() {
        return ubachaBachan;
    }

    public void setUbachaBachan(String ubachaBachan) {
        this.ubachaBachan = ubachaBachan;
    }

    public String getShlokaText() {
        return shlokaText;
    }

    public void setShlokaText(String shlokaText) {
        this.shlokaText = shlokaText;
    }

    public String getParvaName() {
        return parvaName;
    }

    public void setParvaName(String parvaName) {
        this.parvaName = parvaName;
    }
    
}
