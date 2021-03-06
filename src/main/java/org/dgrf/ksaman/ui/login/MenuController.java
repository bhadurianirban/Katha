/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dgrf.ksaman.ui.login;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;



import org.primefaces.model.menu.DefaultMenuItem;

import org.primefaces.model.menu.DefaultMenuModel;

import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author bhaduri
 */
@Named(value = "menuController")
@RequestScoped
public class MenuController {

    private MenuModel menuModel;

    /**
     * Creates a new instance of MenuController
     */
    @Inject
    LoginController loginController;

    public MenuController() {
    }

    @PostConstruct
    void init() {
        if (loginController.getUserAuthDTO().getUserId() == null) {
           
        } else {

            
            menuModel = new DefaultMenuModel();
            
            String maintextBrowseUrl = "/edit/maintext/navigate/ParvaList?faces-redirect=true";
            String parvaBrowseUrl = "/edit/parva/ParvaList?faces-redirect=true";
            String ubachaBrowseUrl = "/edit/ubacha/UbachaList?faces-redirect=true";
            
            DefaultMenuItem maintextList = DefaultMenuItem.builder().value("Shloka Gucchho").outcome(maintextBrowseUrl).build();
            DefaultMenuItem parvaList = DefaultMenuItem.builder().value("Parva").outcome(parvaBrowseUrl).build();
            DefaultMenuItem ubachaList = DefaultMenuItem.builder().value("Ubacha").outcome(ubachaBrowseUrl).build();
            
            menuModel.getElements().add(parvaList);
            menuModel.getElements().add(ubachaList);
            menuModel.getElements().add(maintextList);
          

        }
    }

    
    public MenuModel getMenuModel() {
        return menuModel;
    }

    public void setMenuModel(MenuModel menuModel) {
        this.menuModel = menuModel;
    }

}
