/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author johanjairgilcesreyes
 */
public class Hours {
    int start, end;
    
    public Hours(int s, int e){
        start=s;
        end=e;
    }

    @Override
    public String toString() {
        return "start:" + start + ", end=" + end ;
    }
    
}
