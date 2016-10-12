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

public class MacchinaPersonaDao {
	
	//1-Create
		public boolean creaMacchinaPersona(int id_persona,int id_macchina){
			boolean bool=false;
			Connection con=null;
			PreparedStatement pst=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="insert into MACCHINAPERSONA(id_macchina,id_persona) VALUES(?,?)";
				pst=con.prepareStatement(sql);
				
				pst.setInt(1,id_macchina);
				pst.setInt(2,id_persona);
	
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
		
		//2-Read1
		
		public MacchinaPersona getMacchinaDaPersona(int id_persona){
			MacchinaPersona m=null;
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="select*from MACCHINAPERSONA where id_persona=?";
				
				pst=con.prepareStatement(sql);
				
				
				pst.setInt(1,id_persona );
				
				
				rs=pst.executeQuery();
				
				if(rs.next()) {
					int id_macchina=rs.getInt(1);
					
					m=new MacchinaPersona(id_persona,id_macchina);	
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
		//2-Read2
		
		public MacchinaPersona getDaMacchinaPersona(int id_macchina){
			MacchinaPersona m=null;
			Connection con=null;
			PreparedStatement pst=null;
			ResultSet rs=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="select*from MACCHINAPERSONA where id_macchina=?";
				
				pst=con.prepareStatement(sql);
				
				
				pst.setInt(1,id_macchina);
				
				
				rs=pst.executeQuery();
				
				if(rs.next()) {
					int id_persona=rs.getInt(2);
					
					m=new MacchinaPersona(id_persona,id_macchina);	
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
		
		
		//3-Update1
		public boolean aggiornaPersonaMacchina(int id_macchina,int id_persona){
			boolean bool=false;
			Connection con=null;
			PreparedStatement pst=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="Update MACCHINAPERSONA set id_persona=? where id_macchina=?";
				pst=con.prepareStatement(sql);
				
				pst.setInt(1, id_persona);
				pst.setInt(2, id_macchina);
				
				
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
		
		
		//3-Update1
				public boolean aggiornaMacchinaDiPersona(int id_macchina,int id_persona){
					boolean bool=false;
					Connection con=null;
					PreparedStatement pst=null;
					try{
						con=DataSource.getInstance().getConnection();
						String sql="Update MACCHINAPERSONA set id_macchina=? where id_persona=?";
						pst=con.prepareStatement(sql);
						
						pst.setInt(1, id_macchina);
						pst.setInt(2, id_persona);
						
						
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
		
		
		//4-Delete1
		public boolean rimuoviMacchinaDiPersona(int id_persona){
			boolean bool=false;
			Connection con=null;
			PreparedStatement pst=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="Delete MACCHINAPERSONA where id_persona=?";
				pst=con.prepareStatement(sql);
				
				pst.setInt(1, id_persona);

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
	
		
		//delete2
		public boolean rimuoviMacchinaPersona(int id_macchina){
			boolean bool=false;
			Connection con=null;
			PreparedStatement pst=null;
			try{
				con=DataSource.getInstance().getConnection();
				String sql="Delete MACCHINAPERSONA where id_macchina=?";
				pst=con.prepareStatement(sql);
				
				pst.setInt(1, id_macchina);

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
		
	
}
