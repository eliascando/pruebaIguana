package com.example.dto;

import java.io.Serializable;
import javax.persistence.*;
import com.example.dto.GenericDTO;
import com.example.dto.EmpresaDTO;
import com.example.dto.UsuarioDTO;

@Entity
@Table(name = "EFACTTIPO_PRUEBA" schema = "FACTURACION")
public class TipoPruebaDTO extends GenericFacturacionDTO<TipoPruebaDTO> {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODIGO", nullable = false)
    private String codigo;

    @Column(name = "CANTIDAD", nullable = false)
    private Integer cantidad;

    @Column(name = "DURACION", nullable = false)
    private Integer duracion;

    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "ESTADO", nullable = false)
    @Type(type = GenericDTO.Estado.TYPE)
    private GenericDTO.Estado estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMPRESA_ID")
    private EmpresaDTO empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID")
    private UsuarioDTO usuario;

    public TipoPruebaDTO() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getValue() {
        return this.id;
    }

    @Override
    public String getDescription() {
        return this.descripcion;
    }

    @Override
    public String getLabel() {
        return this.descripcion;
    }

    public EmpresaDTO getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public UsuarioDTO getUsuario() {
        return this.usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public GenericDTO.Estado getEstado() {
        return this.estado;
    }

    public void setEstado(GenericDTO.Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "TipoPruebaDTO [id=" + this.id + ", codigo=" + this.codigo + ", cantidad=" + this.cantidad + ", duracion=" + this.duracion
                + ", descripcion=" + this.descripcion + ", estado=" + this.estado + ", empresa=" + this.empresa + ", usuario=" + this.usuario
                + "]";
    }


}
