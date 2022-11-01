package br.com.crud.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Cliente;
import java.sql.SQLException;


public class ClienteDAO {

	public void save(Cliente cliente) {
		String sql = "INSERT INTO CLIENTES"+
	                 "(NOME,IDADE,EMAIL, DESTINO)"+
	                 "VALUES(?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getIdade());
                        pstm.setString(3, cliente.getEmail());
                        pstm.setString(2, cliente.getDestino());
			pstm.execute();
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public void update(Cliente cliente) {
		String sql = "UPDATE CLIENTES SET "+
	                 "NOME = ?, IDADE = ?, EMAIL = ?, DESTINO = ? "+
	                 "WHERE ID = ? ";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setInt(2, cliente.getIdade());
			pstm.setString(3, cliente.getEmail());
                        pstm.setString(4, cliente.getDestino());
                        
			pstm.execute();
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	
	public void removeById(int id) {
		String sql = "DELETE FROM CLIENTES WHERE ID = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
		}catch(Exception ex){
			ex.printStackTrace();
		} finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public List<Cliente> getCliente(){
		String sql = "SELECT * FROM CLIENTE";
		List<Cliente> cliente = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			while(rset.next()) {
				Cliente c = new Cliente();
				c.setNome(rset.getString("NOME"));
				c.setEmail(rset.getString("EMAIL"));
                                c.setDestino(rset.getString("DESTINO"));
				c.setIdade(rset.getInt("IDADE"));
				cliente.add(c);				
			}
		}catch(Exception ex){
		} finally {
			try {
				if(rset!=null)
					rset.close();
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			}catch(SQLException ex) {
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
            //Contato x = new Contato();
            //x.setNome("XPTO");
            //x.setIdade(1200);
            //x.setEmail();
             //x.setDestino();
            //dao.save(x);
            for (Cliente c : dao.getCliente()) {
                System.out.println(c.getNome()+"::"+c.getIdade()+"::"+c.getEmail()+"::"+c.getDestino());
            }
	}


    }

