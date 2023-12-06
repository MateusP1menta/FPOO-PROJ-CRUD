package br.org.chillitickets.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.mysql.jdbc.PreparedStatement;
import br.org.chillitickets.controller.Conexao;
import br.org.chillitickets.model.Ingressos;

public class CrudDAO {
	//CRUD C-Create R - Read U- Update D - Delete
	
	//CREATE (inserir DADOS)
	public void create(Ingressos ingressos) {
		String sql = "INSERT INTO ingressos(categoria, preco, fp) VALUES(?, ?, ?)";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, ingressos.getCategoria());
			p.setFloat(2, ingressos.getPreco());
			p.setString(3, ingressos.getFp());
			p.execute();
		}catch(Exception e) {
			JOptionPane.showConfirmDialog(null, "Erro ao inserir dados! \nERRO: "+e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//fim create
	//********************************************************************************
	
	//metodo update
	public void update(Ingressos ingressos) {
		String sql = "UPDATE ingressos SET categoria = ?, preco = ?, fp = ? , WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null;//link com banco 
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			p.setString(1, ingressos.getCategoria());
			p.setFloat(2, ingressos.getPreco());
			p.setString(3, ingressos.getFp());
			p.setInt(4, ingressos.getId());
			p.execute();//"executa inst para gravar" dados no banco
			JOptionPane.showConfirmDialog(null, "dados atualizados com sucesso!");
			System.out.println("dados att com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao att dados \nERRO: "+e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}//fim update
	//*********************************************************************************************
	
	// R - READ
	public List<Ingressos> read(){
		String sql = "SELECT * FROM ingressos";
		List<Ingressos> ingressos = new ArrayList<Ingressos>();
		Connection conn = null;
		PreparedStatement p = null;
		ResultSet resultado = null;
		
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);//cast
			resultado = p.executeQuery();//mostra os dados da consulta
			while(resultado.next()) {
				Ingressos ver_ingresso = new Ingressos();
				ver_ingresso.setCategoria(resultado.getString("categoria"));
				ver_ingresso.setId(resultado.getInt("id"));
				ver_ingresso.setPreco(resultado.getFloat("preco"));
				ver_ingresso.setFp(resultado.getString("fp"));
				ingressos.add(ver_ingresso);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return ingressos;
	}//fim READ
	//*********************************************************************************************************
	//D - Delete
	public boolean delete(int id) {
		String sql = "DELETE FROM ingressos WHERE id = ?";
		Connection conn = null;
		PreparedStatement p = null;
		try {
			conn = Conexao.criandoConexao();
			p = (PreparedStatement) conn.prepareStatement(sql);
			p.setInt(1, id);
			p.execute();
			JOptionPane.showConfirmDialog(null, "dados excluidos com sucesso!");
			System.out.println("dados excluidos com sucesso!");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir dados \nERRO: "+e);
		}finally {
			try {
				if(p != null);
				p.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}//fim crud
