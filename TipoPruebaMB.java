package com.example.mb;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import com.example.dto.TipoPruebaDTO;
import com.example.service.FacturacionS;

@ManagedBean
@ViewScoped
public class TipoPruebaMB implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private FacturacionS facturacionS;

    private List<TipoPruebaDTO> listaTipoPrueba;
    private TipoPruebaDTO tipoPruebaSeleccionado;

    @PostConstruct
    public void init() {
        listaTipoPrueba = facturacionS.obtenerTodosLosTiposDePrueba();
        tipoPruebaSeleccionado = new TipoPruebaDTO();
    }

    public void guardarTipoPrueba() {
        if (tipoPruebaSeleccionado.getId() == null) {
            facturacionS.crearTipoPrueba(tipoPruebaSeleccionado);
        } else {
            facturacionS.actualizarTipoPrueba(tipoPruebaSeleccionado);
        }
        listaTipoPrueba = facturacionS.obtenerTodosLosTiposDePrueba();
        tipoPruebaSeleccionado = new TipoPruebaDTO();
    }

    public void eliminarTipoPrueba(Long id) {
        facturacionS.eliminarTipoPrueba(id);
        listaTipoPrueba = facturacionS.obtenerTodosLosTiposDePrueba();
    }

    // Getters and Setters
    public List<TipoPruebaDTO> getListaTipoPrueba() {
        return listaTipoPrueba;
    }

    public void setListaTipoPrueba(List<TipoPruebaDTO> listaTipoPrueba) {
        this.listaTipoPrueba = listaTipoPrueba;
    }

    public TipoPruebaDTO getTipoPruebaSeleccionado() {
        return tipoPruebaSeleccionado;
    }

    public void setTipoPruebaSeleccionado(TipoPruebaDTO tipoPruebaSeleccionado) {
        this.tipoPruebaSeleccionado = tipoPruebaSeleccionado;
    }
}
