package br.com.frota.util;

import br.com.frota.model.ContaLuz;
import br.com.frota.DAO.ContaLuzDAO;
//import br.com.frota.DAO.PessoalDAO;
//import br.com.frota.model.Pessoal;

import java.sql.SQLException;
//import java.util.List;

import com.google.gson.Gson;

public class Teste {
    //static PessoalDAO pessoalDAO = new PessoalDAO();
    static ContaLuzDAO contaLuzDAO = new ContaLuzDAO();

    public static void main(String[] args) throws SQLException {


    	ContaLuz conta = contaLuzDAO.selectContaLuz(1);
        System.out.println(conta);


        System.out.println(new Gson().toJson(conta));


        /*Insert
         Pessoal pessoal = new Pessoal(6, "Eduarda", "111.111.111-00","", 1);
        pessoalDAO.insertPessoal(pessoal);

        GetbyId
        pessoal = pessoalDAO.selectPessoal(1);
        System.out.println(pessoal);

        Update
        pessoal.setNome("Joana");
        pessoalDAO.updatePessoal(pessoal);
        pessoal = pessoalDAO.selectPessoal(2);
        System.out.println(pessoal);

        Select all
        List<Pessoal> pessoals = pessoalDAO.selectAllPessoal();
        pessoals.forEach(System.out::println);*/

    }
}
