package br.com.frota.servico;

import br.com.frota.DAO.ContaLuzDAO;
import br.com.frota.model.ContaLuz;

public class ServicoContaLuz extends ContaLuzDAO {

    public static void main(String[] args) {
        BuscarContaLuz(1);
    }
    public static void BuscarContaLuz(int id){
        ContaLuzDAO contaLuzDAO = new ContaLuzDAO();
        ContaLuz conta = contaLuzDAO.selectContaLuz(id);
        System.out.println(conta);
    }
}
