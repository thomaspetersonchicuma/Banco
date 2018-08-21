/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import Controler.Guardar;
/**
 *
 * @author Tpc
 */
public class Banco implements Imprimivel{
    ArrayList<ContaBancaria> contas=new ArrayList<>();

    public ArrayList<ContaBancaria> getContas() {
        return contas;
    }

    public void setContas(ArrayList<ContaBancaria> contas) {
        this.contas = contas;
    }
    
/**
 * Metodo para inserir uma conta no arrayList
 * @param conta 
 */
    public void inserir(ContaBancaria conta){
        contas.add(conta);
    }
/**
 * Metodo para remover a conta do arrayList
 * @param conta 
 */    
    public void remover(String conta){
        ArrayList<ContaBancaria> contass=new ArrayList<>();
        contass=Guardar.Buscar();
        int k=0;
        for(ContaBancaria c:contass){
            if(c.getNrDeConta().equalsIgnoreCase(conta) ){
                contas.remove(c);
                Guardar.Gravar(contas);
                k++;
                JOptionPane.showMessageDialog(null,"Conta removida com sucesso!");
            }
        }
        if(k==0){
                JOptionPane.showMessageDialog(null,"A conta nao foi achada! Verifique e tente novamente!");
        }
    }
    
    /**
     * Pesquisa de contas
     * @param numero
     * @return 
     */
    public ContaBancaria procurarConta(String numero){
        for(ContaBancaria c:contas){
            if(c.getNrDeConta().equalsIgnoreCase(numero))
                return c;
        }
        return null;
    }

    @Override
    public void mostrarDados() {
        for(ContaBancaria c:contas){
           if(c instanceof ContaCorrente){
               ((ContaCorrente) c).mostrarDados();
           } else{
               if(c instanceof ContaPoupanca){
                   ((ContaPoupanca) c).mostrarDados();
               }}
        }
    }
}
