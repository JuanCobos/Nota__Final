/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dto.Estudiante;
import dto.Materia;
import dto.Nota;
import java.util.HashMap;
import java.util.Map;
import memoria.Memoria;

/**
 *
 * @author jdcob
 */
public class Generador  {
public String ultimaOperacion;
    public double ultimoResultado;
    private Map<String, Nota> listaNotas;
    public Generador(){
        if (listaNotas == null){
           listaNotas = (Map<String, Nota> )Memoria.recuperar();
            if (listaNotas == null){
                listaNotas = new HashMap<>();
            }
        }
    }
   
    
    public Nota generarNota (double num1,double num2,double num3,double num4,String nombre, String codigo,String materia){
       
          Materia laMateria = this.crearMateria(materia);
           Estudiante elEstudiante = this.crearEstudiante(nombre,codigo);
           Nota c = new Nota(laMateria,elEstudiante,num1,num2,num3,num4);
           listaNotas.put(c.getCodigo(),c);
           Memoria.guardar(listaNotas);
           return c;
       
}
    private Estudiante crearEstudiante(String nombre, String codigo){
        Estudiante p = new Estudiante();
        p.modificaCodigo(codigo);
        p.modificaNombre(nombre);
        return p;
    }
    private Materia crearMateria(String materia){
        Materia m = new Materia();
        m.modificaNombre(materia);
        return m;
    }
    public Map<String, Nota> obtenerLista(){
        return this.listaNotas;
    }

    

   
}