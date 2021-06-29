/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bhaduri.ksaman.edit.navigate;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.ksaman.core.DTO.MaintextDTO;
import org.ksaman.core.DTO.ParvaDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "adhyayList")
@ViewScoped
public class AdhyayList implements Serializable {

    /**
     * Creates a new instance of AdhyayListTabView
     */
    private List<MaintextDTO> adhyayDTOList;
    private MaintextDTO selectedAdhyay;
    private String parvaName;
    private int parvaId;
    private int adhyayId;

    public void loadAllAdhyayList() {
        KSCoreService ksCoreService = new KSCoreService();
        adhyayDTOList = ksCoreService.getAdhyayIdList(parvaId);
        ParvaDTO parvaDTO = new ParvaDTO();
        parvaDTO.setParvaId(parvaId);
        parvaDTO = ksCoreService.getParvaDTO(parvaDTO);
        parvaName = parvaDTO.getParvaName();   
    }

    public String shlokaView() {
        adhyayId = selectedAdhyay.getAdhyayId();
        return "ShlokaList";
    }

    public List<MaintextDTO> getAdhyayDTOList() {
        return adhyayDTOList;
    }

    public void setAdhyayDTOList(List<MaintextDTO> adhyayDTOList) {
        this.adhyayDTOList = adhyayDTOList;
    }

    public MaintextDTO getSelectedAdhyay() {
        return selectedAdhyay;
    }

    public void setSelectedAdhyay(MaintextDTO selectedAdhyay) {
        this.selectedAdhyay = selectedAdhyay;
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

    public String getParvaName() {
        return parvaName;
    }

    public void setParvaName(String parvaName) {
        this.parvaName = parvaName;
    }

}
