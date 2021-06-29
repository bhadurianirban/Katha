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
import org.ksaman.core.DTO.ParvaDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author dgrfiv
 */
@Named(value = "parvaListNavigate")
@ViewScoped
public class ParvaListNavigate implements Serializable {

    /**
     * Creates a new instance of ParvaListTabView
     */
    
    private List<ParvaDTO> parvaDTOList;
    private ParvaDTO selectedParva;
    private int parvaId;
    
    public void loadAllParvaList() {
        KSCoreService ksCoreService = new KSCoreService();
        parvaDTOList = ksCoreService.getParvaDTOList();
    }
    
    public String adhyayView() {
        parvaId = selectedParva.getParvaId();
        return "AdhyayList";
    }

    public List<ParvaDTO> getParvaDTOList() {
        return parvaDTOList;
    }

    public void setParvaDTOList(List<ParvaDTO> parvaDTOList) {
        this.parvaDTOList = parvaDTOList;
    }

    public ParvaDTO getSelectedParva() {
        return selectedParva;
    }

    public void setSelectedParva(ParvaDTO selectedParva) {
        this.selectedParva = selectedParva;
    }

    public int getParvaId() {
        return parvaId;
    }

    public void setParvaId(int parvaId) {
        this.parvaId = parvaId;
    }

    
    
}
