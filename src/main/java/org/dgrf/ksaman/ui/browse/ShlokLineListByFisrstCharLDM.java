/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.browse;

import java.util.List;
import java.util.Map;
import org.ksaman.core.DTO.MaintextDTO;
import org.ksaman.core.bl.service.KSCoreService;
import org.primefaces.model.FilterMeta;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;


/**
 *
 * @author dgrfiv
 */
public class ShlokLineListByFisrstCharLDM extends LazyDataModel<MaintextDTO> {

    /**
     *
     */
    public String firstChar;
    
    public ShlokLineListByFisrstCharLDM(String firstChar) {
        
        this.firstChar = firstChar;
        KSCoreService kSCoreService = new KSCoreService();
        
        this.setRowCount(kSCoreService.getShlokaCountByFirstChar(firstChar));
    }


    @Override
    public List<MaintextDTO> load(int first, int pageSize, Map<String, SortMeta> map, Map<String, FilterMeta> filters) {
        KSCoreService kSCoreService = new KSCoreService();
        List<MaintextDTO> listShlokaByPaad = kSCoreService.getShlokaListByFirstChar(firstChar, first, pageSize);
        return listShlokaByPaad;
    }
}
