package com.example.service;

import java.util.List;
import com.example.dto.TipoPruebaDTO;
import com.example.util.PaginationParams;
import com.example.util.GenericCriteria;

public class FacturacionS {

    public static List<TipoPruebaDTO> obtenerTiposPruebaList(TipoPruebaDTO filterDTO, PaginationParams pagination) {
        GenericCriteria<TipoPruebaDTO> criteria = GenericCriteria.forClass(TipoPruebaDTO.class);
        criteria.addLike("codigo", filterDTO.getCodigo());
        criteria.addLike("descripcion", filterDTO.getDescripcion());
        criteria.addEqualsIfNotNull("estado", filterDTO.getEstado());
        criteria.addEqualsIfNotNull("id", filterDTO.getId());
        return findByCriteria(criteria, pagination);
    }

    public static TipoPruebaDTO guardarTipoPrueba(TipoPruebaDTO tipoPrueba) {
        tipoPrueba = saveOrUpdate(tipoPrueba);
        wrapSuccessMessage("TipoPrueba.success.TipoPruebaGuardado");
        return tipoPrueba;
    }

    public static void eliminarTipoPrueba(Long id) {
        TipoPruebaDTO tipoPrueba = findById(id);
        if (tipoPrueba != null) {
            delete(tipoPrueba);
            wrapSuccessMessage("TipoPrueba.success.TipoPruebaEliminado");
        }
    }
}
