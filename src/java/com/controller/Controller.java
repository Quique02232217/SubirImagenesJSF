/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.controller;

import com.modelo.Producto;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Controller implements Serializable{

    private Producto p = new Producto();
    private UploadedFile filep;
    private List<Producto> listaproductos = new ArrayList<>();
    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    public void registrarProducto(){
        listaproductos.add(p);
        p = new Producto();
    }
    
    public void crearNuevoProducto(){
        p = new Producto();
    }
    public void consultarProducto(Producto producto){
        producto = p;
    
    }
    public void upload(){
        if(filep != null){
            try{
                ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String path = sc.getRealPath("/img.png");
                path = path.replace("img.png", "Imagenes\\Productos");
                System.out.println(path);
                ImageUtils.copyFile(p.getId()+".png", filep.getInputStream(), path);
            }catch(IOException ex){
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex); 
            
            }
        }else{
            System.out.println("Error=");
        }
    
    }
    
    
    public List<Producto> getListaproductos() {
        return listaproductos;
    }

    public void setListaproductos(List<Producto> listaproductos) {
        this.listaproductos = listaproductos;
    }
    

    public UploadedFile getFilep() {
        return filep;
    }

    public void setFilep(UploadedFile filep) {
        this.filep = filep;
    }

    public Producto getP() {
        return p;
    }

    public void setP(Producto p) {
        this.p = p;
    }
    
    
    
    
    
}
