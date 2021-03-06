package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidad.Cliente;
import entidad.TipoCliente;
import util.MySqlDBConexion;

public class ClienteModel {

	
	public List<Cliente> consultaCliente(String dni) {
		
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre "+ 
						"from cliente c join tipo_cliente tc " + 
						"on c.idTipoCliente = tc.idTpoCliente " +
						"where c.dni like '"+dni+"%'";
			 
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Cliente c = null;
			TipoCliente tc = null;
			
			while (rs.next()) {
				c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombres(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setDni(rs.getString(4));
				c.setFechaNacimiento(rs.getDate(5));
				
				tc = new TipoCliente();
				tc.setNombre(rs.getString(6));
				
				c.setIdTipoCliente(tc);
				
				data.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
	
	public List<Cliente> listaCliente() {
		ArrayList<Cliente> data = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			con = MySqlDBConexion.getConexion();
			String sql = "select c.idCliente, c.nombres, c.apellidos, c.dni, c.fechaNacimiento, tc.nombre "+ 
						"from cliente c join tipo_cliente tc " + 
						"on c.idTipoCliente = tc.idTpoCliente";
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			Cliente c = null;
			TipoCliente tc = null;
			
			while (rs.next()) {
				c = new Cliente();
				c.setIdCliente(rs.getInt(1));
				c.setNombres(rs.getString(2));
				c.setApellidos(rs.getString(3));
				c.setDni(rs.getString(4));
				c.setFechaNacimiento(rs.getDate(5));
				
				tc = new TipoCliente();
				tc.setNombre(rs.getString(6));
				
				c.setIdTipoCliente(tc);
				
				data.add(c);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return data;
	}
}