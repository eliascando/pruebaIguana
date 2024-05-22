package com.example.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.dto.TipoPruebaDTO;

@Stateless
public class FacturacionS {

    @PersistenceContext
    private EntityManager em;

    public List<TipoPruebaDTO> obtenerTodosLosTiposDePrueba() {
        return em.createQuery("SELECT t FROM TipoPruebaDTO t", TipoPruebaDTO.class).getResultList();
    }

    public void crearTipoPrueba(TipoPruebaDTO tipoPrueba) {
        em.persist(tipoPrueba);
    }

    public void actualizarTipoPrueba(TipoPruebaDTO tipoPrueba) {
        em.merge(tipoPrueba);
    }

    public void eliminarTipoPrueba(Long id) {
        TipoPruebaDTO tipoPrueba = em.find(TipoPruebaDTO.class, id);
        if (tipoPrueba != null) {
            em.remove(tipoPrueba);
        }
    }
}
