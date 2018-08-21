/*
 * To change this license header, choose License HeaderSs in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *Classe que herda dados da classe
 * @see ContaBancaria
 * e implementa o metodo mostrar dados da interface
 * @see Imprimivel
 * @author Tpc
 */
public class ContaCorrente extends ContaBancaria implements Imprimivel,Serializable{
    
    private double taxaDeOperacoes;

    
    /*
    constructor que inicializa atributos desta class e da classe mae
    @param taxaDeOperacoes desta clasee
    @param nrDeConta
    @param saldo
    @param historico
    */
    
    

    public ContaCorrente(double taxaDeOperacoes, String nrDeConta, int saldo, String historico) {
        super(nrDeConta, saldo, historico);
        this.taxaDeOperacoes = taxaDeOperacoes;
    }

  public  ContaCorrente() {
        super();
    }

   
    public double getTaxaDeOperacoes() {
        return taxaDeOperacoes;
    }

    public void setTaxaDeOperacoes(double taxaDeOperacoes) {
        this.taxaDeOperacoes = taxaDeOperacoes;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" + "taxaDeOperacoes=" + taxaDeOperacoes + '}';
    }

    
    /*
    metodo para levantar
    @param saque
    */
    @Override
  public  void sacar(double saque) {
        
        double limite = getSaldo() - (saque + getTaxaDeOperacoes());
        
        if (limite >= 0){
            
            super.setSaldo((int) limite); 
        }
    }

    
    /*
    metodo para depositar
    @param deposito
    */
    @Override
    public void depositar(double deposito) {
        
        super.setSaldo((int) (getSaldo() + deposito - getTaxaDeOperacoes()));
        
    }

    @Override
    public void mostrarDados() {
        System.out.println("O numero da conta e "+ getNrDeConta()+" e os seu salo e "+ getSaldo());
    }

    @Override
    public void transferir(ContaBancaria conta, double valor) {
        super.transferir(conta, valor); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
