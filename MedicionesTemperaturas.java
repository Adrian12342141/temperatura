/**
 * MedicionesTemperaturas representa una lista de mediciones de temperaturas
 * de una estación meteorológica. Las temperaturas están en grados centígrados
 * 
 * @author N. Aguirre 
 * @version 0.1
 */

import java.util.ArrayList;

public class MedicionesTemperaturas
{
    
    // lista de mediciones tomadas en la estacion meteorologica.
    private ArrayList<Float> mediciones;
    
    /**
     * Constructor de MedicionesTemperaturas. Crea la lista de mediciones vacía.
     */
    public MedicionesTemperaturas()
    {
        mediciones = new ArrayList<Float>();
    }
    
    /**
     * Agrega una nueva medicion de temperatura
     */
    public void agregarMedicion(float nuevaTemperatura) {
        assert (nuevaTemperatura >=-273.15):"La temperatura no puede ser menor al cero absoluto (-273,15°)";
        mediciones.add(nuevaTemperatura);
    }
    
    /**
     * Imprime la lista de temperaturas/mediciones
     */
    public void imprimirTemperaturas()
    {
        System.out.println("Temperaturas Registradas:");
        for (Float temp: mediciones) {
            System.out.println(temp + "C");
        }
    }
    
    /**
     * Calcula el promedio de temperaturas. 
     * Precondicion: debe haber al menos una temperatura cargada para que el promedio tenga sentido.
     */
    public float promedioTemperaturas()
    {
        assert mediciones.size() > 0: "debe haber al menos una temperatura cargada para calcular el promedio";
        float suma = 0;
        for (Float temp: mediciones) {
            suma = suma + temp;
        }
        return suma / mediciones.size();
    }
    
    /**
     * Calcula cantidad de registros de temperaturas negativas (sub cero)
     */
    public int cantidadRegistrosSubCero() {
        int negativas = 0;
        for (Float temp: mediciones) {
            if (temp < 0) {
                negativas = negativas + 1;
            }
        }
        return negativas;
    }
    
     /**
     * Permite computar la cantidad de temperaturas extremas, una temperatura
     * se considera extrema si es superior a 35 grados, o inferior a -15 grados.
     */
    public int cantTemperaturasExtremas(){
        int count=0;
        for (Float temp: mediciones){
            if (temp > 35.0 || temp < -15){
                count++;
            }
        }
        return count;
    }
    
     /**
     * Permite calcular la cantidad de mediciones consecutivas con la misma temperatura
     */
    public int cantMedicionesConsecutivas(){
        int count=0;
        if (mediciones.size() > 1){
            for (int i=0; i < (mediciones.size()-1); i++){
                if (mediciones.get(i).equals(mediciones.get(i + 1))){
                    count++;
                }
            }
        }
        return count;
    }
    
}




