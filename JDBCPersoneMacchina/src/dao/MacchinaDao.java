package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Macchina;
import model.MacchinaPersona;
import utility.DataSource;

public class MacchinaDao {

	//1-Create
	
	public boolean creaMacchina(String targa,String modello){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into MACCHINA(TARGA,MODELLO)"+" VALUES(?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, targa);
			pst.setString(2, modello);
			
			int rs=pst.executeUpdate();
			if(rs>0) bool=true;
			
			
		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();}
			finally{
			if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		return bool;
		
	}
	
	//create 2
	
	public int creaMacchinaId(String targa,String modello){
		int bool=0;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into MACCHINA(TARGA,MODELLO)"+" VALUES(?,?)";
			pst=con.prepareStatement(sql,new String[]{"id_macchina"});
			//in tal modo genero e ritorno l'id della macchina che ho creato
			pst.setString(1, targa);
			pst.setString(2, modello);
			
			pst.executeUpdate();
			ResultSet rs=pst.getGeneratedKeys();
			
			if(rs.next() && rs!=null) {
				bool=rs.getInt(1);
				
			}
			
			
		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();}
			finally{
			if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		return bool;
		
	}
	//2-Read
	
	public Macchina getMacchina(String targa){
		Macchina m=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="select*from Macchina where targa=?";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, targa);
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				int id_macchina=rs.getInt(1);
				String modello=rs.getString(3);
				
				m=new Macchina(id_macchina,targa,modello);	
			}
			
			
		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();}
			finally{
			if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
	
		return m;
	}
	
	//2-Read
	
		public Macchina getMacchina(int id_macchina){
			Macchina m=null;
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="select*from Macchina where id_macchina=?";
				
				pst=con.prepareStatement(sql);
				
				pst.setInt(1, id_macchina);
				
				rs=pst.executeQuery();
				
				if(rs.next()) {
					
					
					String targa=rs.getString(2);
					String modello=rs.getString(3);
					
					m=new Macchina(id_macchina,targa,modello);	
				}
				
				
			}catch(SQLException|PropertyVetoException|IOException e){
				e.printStackTrace();}
				finally{
				if(pst!=null)
					try {
						pst.close();
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
		
			return m;
		}
	//3-Update
	public boolean aggiornaMacchina(String targa,String modello){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="Update MACCHINA set modello=? where targa=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, modello);
			pst.setString(2, targa);
			
			int rs=pst.executeUpdate();
			if(rs>0) bool=true;
			
			
		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();}
			finally{
			if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		return bool;
		
	}
	
	//4-Delete
	public boolean rimuoviMacchina(String targa,String modello){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="Delete MACCHINA where targa=? and modello=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, targa);
			pst.setString(2, modello);
			
			int rs=pst.executeUpdate();
			if(rs>0) bool=true;
			
			
		}catch(SQLException|PropertyVetoException|IOException e){
			e.printStackTrace();}
			finally{
			if(pst!=null)
				try {
					pst.close();
				} catch (SQLException e) {
				
					e.printStackTrace();
				}
			}
		return bool;
		
	}

	public Map<Integer, Macchina> getTutteLeMacchineDiUnaPersona(int id) {
		Map<Integer,Macchina> MacchineDellaPersona=new HashMap<Integer,Macchina>() ;
		Connection con=null;
		String sql="select MACCHINA.id_macchina,MACCHINA.modello,MACCHINA.targa "
				+ "from MACCHINAPERSONA,MACCHINA "
				+ "where MACCHINAPERSONA.id_persona=? and MACCHINA.id_macchina=MACCHINAPERSONA.id_macchina";
		//join=relazione tra tabelle
		
		try {
			con=DataSource.getInstance().getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
			
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()){//finchè ne vede una sotto esegue while
				int id_macchina=rs.getInt(1);
				String modello=rs.getString(2);
				String targa=rs.getString(3);
				Macchina m=new Macchina(id_macchina,targa,modello);
				MacchineDellaPersona.put(id_macchina, m);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		return MacchineDellaPersona;
	}

	public Map<Integer, Macchina> getTutteLeMacchine() {
		Map<Integer,Macchina> Macchine=new HashMap<Integer,Macchina>() ;
		Connection con=null;
		String sql="select *from Macchina";
		//join=relazione tra tabelle
		
		try {
			con=DataSource.getInstance().getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
		
			ResultSet rs=pst.executeQuery();
			while(rs.next()){//finchè ne vede una sotto esegue while
				int id_macchina=rs.getInt(1);
				String modello=rs.getString(2);
				String targa=rs.getString(3);
				
				Macchina m=new Macchina(id_macchina,targa,modello);
				Macchine.put(id_macchina, m);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		return Macchine;
	}
	
	

	
}
