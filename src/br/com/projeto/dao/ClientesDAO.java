/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.pacote.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;


/**
 *
 * @author 876
 */
public class ClientesDAO {
    
    private Connection con;
    
    public ClientesDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    
    
    
    //Metedo CadastrarCliente
    public void cadastrarCliente(Clientes obj){
        
        try {
            // primeiro passo: criar o comando mysql
            String sql = "insert into tb_clientes (nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) "
                    + "value(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            // 2 passo : conectar o banco e organizar 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            
            
            //3 passo - executar o comando sql. 
            stmt.execute();
            stmt.close();
            // acerto 
            JOptionPane.showMessageDialog(null,"Cadastrar com Sucesso!");
            //erro 
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro!:" +erro);
       
        }
        
    }
 
    //Metodo AlterarCliente
    public void alterarCliente(){
    }
    
    //metode ExcluirCliente
    public void excluirCliente(){
    }
    
    
    
    
    
    
    
}
