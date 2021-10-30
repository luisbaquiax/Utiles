/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablaversion3;

/**
 *
 * @author luis
 */
public class TipoColumna {

    private String tipo;
    private String valor;

    public TipoColumna(String tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @return the valor
     */
    public String getValor() {
        return valor;
    }
}
