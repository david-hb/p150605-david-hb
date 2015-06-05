package p20150605;

import java.io.File;
import java.util.Date;
/**
 * Clase destinada a la gestion de cuñas de anuncios publicitarios en radio
 * 
 * @author David
 * @version 1.0.1
 */

public class AudioAnuncio extends AudioPista
{
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    
    /**
     * Constructor de AudioSpot.
     */
    public AudioAnuncio ()
    {
        this.archivo = null;
        this.duracion = 0;
        this.producto = "";
        this.anunciante = "";
        this.lasterrormsg = "";
    }
    
    /**
     * El metodo establece los metadatos del spot.
     * 
     * @param producto  Indicamos el nombre del producto.
     * @param anunciante Indica el nombre del anumciante.
     */
    public void setMetaDatos (String producto, String anunciante)
    {
        this.producto = producto;
        this.anunciante = anunciante;
    }
    
    
    /**
     * El metodo se encarga exporta a formato daw.
     * 
     * @param objeto_daw Objeto a exportar a formato daw.
     * @return Retorna el valor resultado de la comprobacion.
     */
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
        int resultado = Comprobador();
        
        // si todo va bien, exportamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la exportación del audio
                lasterrormsg = "";
                return 0;
            }
            catch (Exception ex)
            {
                lasterrormsg = ex.getMessage();
                return -5;
            }
        }
        else
            return resultado;
    }

    protected int Comprobador() {
        // comprobamos previamente que no falte nada
        int resultado = 0;
        if (this.duracion==0)
        {
            lasterrormsg = "No se ha establecido duración alguna.";
            resultado = -1;
        }
        else if (this.producto.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre del producto anunciado.";
            resultado = -2;
        }
        else if (this.anunciante.equals(""))
        {
            lasterrormsg = "No se ha indicado el nombre de la empresa anunciante.";
            resultado = -3;
        }
        else if (this.archivo==null)
        {
            lasterrormsg = "No se ha establecido el archivo de audio.";
            resultado = -4;
        }
        return resultado;
    }
    
}
