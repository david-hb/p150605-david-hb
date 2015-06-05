/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20150605;

import java.io.File;
import java.util.Date;

/**
 *
 * @author David
 */
public class AudioPista {
    protected static final int Valor_Maximo_Duración_Permitido = 120;
    protected File archivo; // manejador para el archivo que contiene el audio (.mp3)
    protected int duracion; // duración del audio, en segundos
    public String lasterrormsg; //donde almacenamos la descripcion de error.
    /*Los error que se pueden producir
    Si no se produjo ningun problema. Retorna 0
    Si no se establece duracion. Retorna -1
    Si no se ha indicado el nombre del producto anunciado. Retorna -2
    Si no se ha establecido el archivo de audio. Retorna -3
    Si no se ha establecido el archivo de audio. Retorna -4
    Si se produjo una excepcion. Retorna -5
     */

    public AudioPista() {
    }

    /**
     * El metodo establece la duracion del spot.
     *
     * @param duracion Indica la duracion que tinen el spot.
     * @throws IllegalArgumentException Excepcion que se producira al sobre pasar el limite.
     */
    public void setDuracion(int duracion) throws IllegalArgumentException {
        if (duracion < 0) {
            duracion = 0;
        } else if (duracion > Valor_Maximo_Duración_Permitido) {
            throw new IllegalArgumentException("Duración demasiado larga");
        }
        this.duracion = duracion;
    }

    /**
     * El metodo comprueba que el archivo que contiene el audio existe.
     *
     * @param nombre_archivo Nombre del archivo que contiene el audio.
     * @return Retorna un booleano que indica si el archivo existe.
     */
    public Boolean setArchivo(String nombre_archivo) {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }

    /**
     * El metodo se encarga de manejar la cola de reproducción.
     *
     * @param cola_reproduccion Es la lista de anuncios a reproducir.
     * @return Retorna el valor resultado de la comprobacion.
     */
    public int ProgramaEnCola(Object cola_reproduccion, Date fecha) {
        // comprobamos previamente que no falte nada
        int resultado = Comprobador();
        // si todo va bien, programamos
        if (resultado == 0) {
            try {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
            } catch (Exception ex) {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        } else {
            return resultado;
        }
    }
    
}
