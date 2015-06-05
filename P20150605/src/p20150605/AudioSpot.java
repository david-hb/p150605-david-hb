package p20150605;

import java.io.File;
/**
 * Clase destinada a la gestion de cuñas de anuncios publicitarios en radio
 * 
 * @author David
 * @version 1.0.1
 */

public class AudioSpot
{
    private File archivo;       // manejador para el archivo que contiene el audio (.mp3)
    private int duracion;       // duración del audio, en segundos
    private String producto;    // nombre del producto anunciado
    private String anunciante;  // nombre de la empresa anunciante
    
    public String lasterrormsg; //donde almacenamos la descripcion de error.
    /*Los error que se pueden producir
    Si no se produjo ningun problema. Retorna 0
    Si no se establece duracion. Retorna -1
    Si no se ha indicado el nombre del producto anunciado. Retorna -2
    Si no se ha establecido el archivo de audio. Retorna -3
    Si no se ha establecido el archivo de audio. Retorna -4
    Si se produjo una excepcion. Retorna -5
    */
    
    
    /**
     * Constructor de AudioSpot.
     */
    public AudioSpot ()
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
     * El metodo establece la duracion del spot.
     * 
     * @param duracion Indica la duracion que tinen el spot.
     * @throws IllegalArgumentException Excepcion que se producira al sobre pasar el limite.
     */
    public void setDuracion(int duracion) throws IllegalArgumentException
    {
        if (duracion<0)
            duracion=0;
        else if (duracion>120)
            throw new IllegalArgumentException ("Duración demasiado larga");
        this.duracion = duracion;
    }
    
    /**
     * El metodo comprueba que el archivo que contiene el audio existe.
     * 
     * @param nombre_archivo Nombre del archivo que contiene el audio.
     * @return Retorna un booleano que indica si el archivo existe.
     */
    public Boolean setArchivo(String nombre_archivo)
    {
        this.archivo = new File(nombre_archivo);
        return this.archivo.exists();
    }
    
    /**
     * El metodo se encarga de comprobar que no falta nada, si se produgera un error
     * genera un codigo de error.
     * 
     * @param cola_reproduccion Es la lista de anuncios a reproducir.
     * @return Retorna el valor resultado de la comprobacion.
     */
    public int ProgramaEnCola(Object cola_reproduccion)
    {
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
        
        // si todo va bien, programamos
        if (resultado==0)
        {
            try
            {
                // falta por implementar la programación en la cola_reproducción
                lasterrormsg = "";
                return this.duracion;
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
    
    /**
     * El metodo se encarga de comprobar que no falta nada, si se produgera un error
     * genera un codigo de error si no exporta a formato daw.
     * 
     * @param objeto_daw Objeto a exportar a formato daw.
     * @return Retorna el valor resultado de la comprobacion.
     */
    
    public int ExportaAFormatoDAW(Object objeto_daw)
    {
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
    
}
