package com.example.mb;

import java.util.List;
import com.example.dto.TipoPruebaDTO;
import com.example.service.FacturacionS;

public class TipoPruebaMB extends AbstractFacturacionMB<TipoPruebaDTO, TipoPruebaDTO> {
    
    private DataListAudit<TipoPruebaDTO> tipoPruebaDataList;

    @Override
    public void getInit() {
        // para búsquedas
        filterDTO = new TipoPruebaDTO();
        filterDTO.setEstado(Estado.ACTIVO);
        tipoPruebaDataList.unload();
        currentDTO = new TipoPruebaDTO();
    }

    @Override
    protected List<TipoPruebaDTO> loadDataTableCollection(TipoPruebaDTO tipoPrueba, PaginationParams pagination) {
        tipoPruebaDataList.unload();
        return new ArrayList<TipoPruebaDTO>();
    }

    ///////////// DATA LIST ///////////////
    DataListAudit<TipoPruebaDTO> tipoPruebaDataList = new DataListAudit<TipoPruebaDTO>(this) {
        public void initAudit() {
            initAudit(corporativoS, sesionUsuario.getOpcionActual(), null, sesionUsuario);
        }

        @Override
        protected List<TipoPruebaDTO> loadCollection(PaginationParams pagination) {
            List<TipoPruebaDTO> list = FacturacionS.obtenerTiposPruebaList(filterDTO, pagination);
            return list;
        }

        protected TipoPruebaDTO actionNew() {
            currentDTO = new TipoPruebaDTO();
            return currentDTO;
        }

        @Override
        protected TipoPruebaDTO actionSave(TipoPruebaDTO tipoPrueba) {
            tipoPrueba = FacturacionS.guardarTipoPrueba(tipoPrueba);
            actionEdit(tipoPrueba);
            return tipoPrueba;
        }

        @Override
        protected void actionMultiSave(Set<TipoPruebaDTO> items) {
            for (TipoPruebaDTO item : items) {
                item = FacturacionS.guardarTipoPrueba(item);
            }
        }

        protected TipoPruebaDTO actionEdit(TipoPruebaDTO tipoPrueba) {
            currentDTO = tipoPruebaDataList.getActiveItem();
            return tipoPrueba;
        }
    };

    public DataList<TipoPruebaDTO> getTipoPruebaDataList() {
        return tipoPruebaDataList;
    }
}
