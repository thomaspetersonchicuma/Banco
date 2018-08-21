/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Tpc
 */
public class Executavel {
    
    public static void main(String[] args) {
        
        ContaCorrente cc = new ContaCorrente();
        ContaPoupanca cp = new ContaPoupanca();
        
        cc.setNrDeConta("1111");
        cc.setSaldo(20000);
        cc.setHistorico("Medico");
        
        cp.setNrDeConta("2222");
        cp.setSaldo(200);
        cp.setHistorico("Professor");
        
        
        
        cc.sacar(19000);
        cp.sacar(200);
        
        
        Relatorio r = new Relatorio();
        r.gerarRelatorio(cp);
        r.gerarRelatorio(cc);
        
    }
    
}
