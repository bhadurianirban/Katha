/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.browse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.ksaman.core.DTO.MaintextDTO;
import org.ksaman.core.DTO.TikaDTO;
import org.ksaman.core.bl.service.KSCoreService;

/**
 *
 * @author bhaduri
 */
@Named(value = "fullShlokView")
@ViewScoped
public class FullShlokView implements Serializable {

    private List<MaintextDTO> shlokDTOList;
    private int parvaId;
    private int adhyayId;
    private int ubachaId;
    private int shlokaLine;
    private int shlokaNum;
    private String ubachaName;
    private String parvaName;
    private String ubachaBachan;
    private String shlokaText;
    private String shlokaAnubad;
    private MaintextDTO maintextDTO;
    private Boolean anubadNotIncluded;
    private List<TikaDTO> tikaDTOList;

    /**
     * Creates a new instance of FullShlokView
     */
    public FullShlokView() {
    }

    public void loadShlokDetails() {
        KSCoreService ksCoreService = new KSCoreService();
        shlokDTOList = ksCoreService.getMaintextTranslation(parvaId, adhyayId, shlokaNum);

        if (!shlokDTOList.isEmpty()) {
            ubachaName = shlokDTOList.get(0).getUbachaName();
            ubachaBachan = shlokDTOList.get(0).getUbachaBachan();
            parvaName = shlokDTOList.get(0).getParvaName();
            ubachaId = shlokDTOList.get(0).getUbachaId();
            parvaId = shlokDTOList.get(0).getParvaId();
            shlokaNum = shlokDTOList.get(0).getShlokaNum();
            adhyayId = shlokDTOList.get(0).getAdhyayId();
            shlokaAnubad = shlokDTOList.get(0).getAnubadText();
            if (shlokaAnubad != null) {
                shlokaAnubad = addTikaIndexes(shlokaAnubad, tikaDTOList);
            } else {
                shlokaAnubad = "অনুবাদ করা হয়নি |";
            }
            tikaDTOList = shlokDTOList.get(0).getTikaDTOList();
        }

    }

    private String addTikaIndexes(String pureAnubadText, List<TikaDTO> tikaList) {
        List<String> matchList = new ArrayList<String>();
        String citeRegex = "[{][{](\\d+)[}][}]";
        //Pattern regex = Pattern.compile(citeRegex);
        String consecutiveCitationRegex = "</sup><sup>";
        String replaceCitation = "<sup>$1</sup>";
        String replaceConsecutiveCitation = ",</sup><sup>";

        Pattern pattern = Pattern.compile(citeRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(pureAnubadText);
        String consecutiveCitationTempText = matcher.replaceAll(replaceCitation);
        System.out.println(consecutiveCitationTempText);

        Pattern consecutiveCitationPattern = Pattern.compile(consecutiveCitationRegex, Pattern.CASE_INSENSITIVE);
        Matcher consecutiveCitationMatcher = consecutiveCitationPattern.matcher(consecutiveCitationTempText);
        String finalText = consecutiveCitationMatcher.replaceAll(replaceConsecutiveCitation);

        System.out.println(finalText);
        return (finalText);

//        while (regexMatcher.find()) {//Finds Matching Pattern in String
//            matchList.add(regexMatcher.group(1));//Fetching Group from String
//        }
//
//        for (String str : matchList) {
//            System.out.println(str);
//        }
    }

    public List<MaintextDTO> getShlokDTOList() {
        return shlokDTOList;
    }

    public void setShlokDTOList(List<MaintextDTO> shlokDTOList) {
        this.shlokDTOList = shlokDTOList;
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

    public String getParvaName() {
        return parvaName;
    }

    public void setParvaName(String parvaName) {
        this.parvaName = parvaName;
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

    public String getShlokaAnubad() {
        return shlokaAnubad;
    }

    public void setShlokaAnubad(String shlokaAnubad) {
        this.shlokaAnubad = shlokaAnubad;
    }

    public MaintextDTO getMaintextDTO() {
        return maintextDTO;
    }

    public void setMaintextDTO(MaintextDTO maintextDTO) {
        this.maintextDTO = maintextDTO;
    }

    public Boolean getAnubadNotIncluded() {
        return anubadNotIncluded;
    }

    public void setAnubadNotIncluded(Boolean anubadNotIncluded) {
        this.anubadNotIncluded = anubadNotIncluded;
    }

    public List<TikaDTO> getTikaDTOList() {
        return tikaDTOList;
    }

    public void setTikaDTOList(List<TikaDTO> tikaDTOList) {
        this.tikaDTOList = tikaDTOList;
    }

}
