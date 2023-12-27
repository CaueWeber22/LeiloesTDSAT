/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        
      String sql = "INSERT into produtos (nome, valor, status) VALUES (?, ?, ?)";
    
        try{
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setInt(2, produto.getValor());
        ps.setString(3, produto.getStatus());
        ps.execute();
        
        JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso.", "Sucesso", 1);
        
 
        } catch (Exception ex) {
          System.out.println("ERRO: " + ex.getMessage());
           JOptionPane.showMessageDialog(null, "Falha ao realizar o cadastro: " + ex.getMessage(), "Erro", 1);
          
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

