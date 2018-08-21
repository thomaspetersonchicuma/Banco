/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Tpc
 */
public abstract class ContaBancaria implements Serializable{

    private String nrDeConta;
    private int saldo;
    private String historico;

    public ContaBancaria(String nrDeConta, int saldo, String historico) {
        this.nrDeConta = nrDeConta;
        this.saldo = saldo;
        this.historico = historico;
    }

    public ContaBancaria() {
    }
    

    public String getNrDeConta() {
        return nrDeConta;
    }

    public void setNrDeConta(String nrDeConta) {
        this.nrDeConta = nrDeConta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" + "nrDeConta=" + nrDeConta + ", saldo=" + saldo + ", historico=" + historico + '}';
    }
    
    
    
    /*
    metodo para levantar 
    @param saque
    */
    abstract void sacar(double saque);
    
    
    /*
    metodo para depositar 
    @param deposito
    */
    abstract void depositar(double deposito);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public void transferir(ContaBancaria conta, double valor){
        this.sacar(valor);
        conta.depositar(valor);
    }
    
}
