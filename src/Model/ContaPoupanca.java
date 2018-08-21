/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *classe que herda dados da classe
 * @see ContaBancaria
 * e implementa o metodo mostrar dados da interface
 * @see Imprimivel
 * @author Tpc
 */
public class ContaPoupanca extends ContaBancaria implements Imprimivel,Serializable{
    
    private double limite;

    public ContaPoupanca(double limite, String nrDeConta, int saldo, String historico) {
        super(nrDeConta, saldo, historico);
        this.limite = limite;
    }

 public ContaPoupanca() {
       
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" + "limite=" + limite + '}';
    }

    @Override
 public   void sacar(double saque) {
        double limite = getSaldo() - saque;
        
        if (limite >= getLimite()){
            
            super.setSaldo((int) (getSaldo() - saque)); 
        }
    }

    @Override
   public void depositar(double deposito) {
        
        super.setSaldo((int) (getSaldo() + deposito));
    }
    
    public void mostrarDados() {
        System.out.println("O numero da conta e "+ getNrDeConta()+" e os seu salo e "+ getSaldo());
    }
    
    public static void main(String[] args) {
        
        ContaPoupanca c = new ContaPoupanca();
        
        c.depositar(0);
        
        c.mostrarDados();
    }
    
    public void transferir(ContaBancaria conta, double valor){
        this.sacar(valor);
        conta.depositar(valor);
    }
}
