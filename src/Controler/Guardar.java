/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.ContaBancaria;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Honwana
 */
public class Guardar {
     public static boolean Gravar(ArrayList<ContaBancaria> c){
        try {
            FileOutputStream gravar=new FileOutputStream("contas.dat");
            ObjectOutputStream os=new ObjectOutputStream(gravar);
            os.writeObject(c);
            gravar.flush();
            gravar.close();
            os.flush();
            os.close();
            return true;
        } catch (FileNotFoundException ex) {
            System.err.println("Erro "+ ex);
            return false;
        } catch (IOException ex) {
            System.err.println("Erro " + ex);
            return false;
        }
        
    }
    public static void update(ContaBancaria conta){
        ArrayList<ContaBancaria> contas= new ArrayList<>();
        contas=Guardar.Buscar();
        for(ContaBancaria c:contas){
            if(conta.getNrDeConta()==c.getNrDeConta()){
                c.setSaldo(conta.getSaldo());
            }
        }
        Guardar.Gravar(contas);
    }
    public static ArrayList<ContaBancaria> Buscar(){
        try {
            FileInputStream buscar=new FileInputStream("contas.dat");
            ObjectInputStream in=new ObjectInputStream(buscar);
            return (ArrayList<ContaBancaria>)in.readObject();
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) {
            return null;
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
