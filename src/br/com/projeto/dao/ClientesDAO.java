/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import javax.swing.JOptionPane;
import com.mysql.jdbc.ResultSetImpl;
import br.com.pacote.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


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
    
    
    //metodo listar todos os clientes 
    public ArrayList<Object>listaCliente(){
        
        try {
            //1 criar a lista.
            ArrayList<Object> lista = new ArrayList<Object>();
            
            //2 passo - criar comando sql 
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Clientes obj = new Clientes();
                
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("Nome"));
                obj.setRg(rs.getString("Rg"));
                obj.setCpf(rs.getString("Cpf"));
                obj.setEmail(rs.getString("Email"));
                obj.setTelefone(rs.getString("Telefone"));
                obj.setCelular(rs.getString("Celular"));
                obj.setCep(rs.getString("Cep"));
                obj.setEndereco(rs.getString("Endereco"));
                obj.setNumero(rs.getInt("Numero"));
                obj.setComplemento(rs.getString("Complemento"));
                obj.setBairro(rs.getString("Bairro"));
                obj.setCidade(rs.getString("Cidade"));
                obj.setUf(rs.getString("Uf"));
                
                lista.add(obj);
                
                
            }
            
            return lista;
            
            
            
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
            
        }
    }
}
        
