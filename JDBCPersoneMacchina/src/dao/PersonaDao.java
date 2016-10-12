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
import model.Persona;
import utility.DataSource;

public class PersonaDao {
	//1-Create
	public boolean creaPersona(String nome,String cognome,String cf){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into PERSONA(NOME,COGNOME,CF) VALUES(?,?,?)";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, cf);
			
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
	
	
	//Create
	public int creaPersonaId(String nome,String cognome,String cf){
		int bool=0;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="insert into PERSONA(NOME,COGNOME,CF) VALUES(?,?,?)";
			pst=con.prepareStatement(sql,new String[]{"id_persona"});
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, cf);
			
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
	
	public Persona getPersona(String nome,String cognome,String cf){
		Persona p=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="select*from PERSONA where nome=? and cognome=? and cf=?";
			
			pst=con.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, cf);
			
			rs=pst.executeQuery();
			
			if(rs.next()) {
				
				int id_persona=rs.getInt(1);
				p=new Persona(id_persona,nome,cognome,cf);	
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
	
		return p;
	}
	
	//3-Update
	public boolean aggiornaPersona(int id,String nome,String cognome,String cf){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="Update PERSONA set nome=?,cognome=?,cf=? where id_persona=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, cf);
			pst.setInt(4, id);
			
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
	public boolean rimuoviPersona(String nome,String cognome,String cf){
		boolean bool=false;
		Connection con=null;
		PreparedStatement pst=null;
		try{
			con=DataSource.getInstance().getConnection();
			String sql="Delete PERSONA where nome=? and cognome=? and cf=?";
			pst=con.prepareStatement(sql);
			
			pst.setString(1, nome);
			pst.setString(2, cognome);
			pst.setString(3, cf);

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
	
	
	
	public Map<Integer, Persona> getTutteLePersone() {
		Map<Integer,Persona> Persone=new HashMap<Integer,Persona>() ;
		Connection con=null;
		String sql="select *from Persona";
		//join=relazione tra tabelle
		
		try {
			con=DataSource.getInstance().getConnection();
			PreparedStatement pst=con.prepareStatement(sql);
		
			ResultSet rs=pst.executeQuery();
			while(rs.next()){//finchè ne vede una sotto esegue while
				int id_persona=rs.getInt(1);
				String nome=rs.getString(2);
				String cognome=rs.getString(3);
				String cf=rs.getString(4);
				
				Persona p=new Persona(id_persona,nome,cognome,cf);
				Persone.put(id_persona, p);
			}
			
		} catch (SQLException | IOException | PropertyVetoException e) {
			
			e.printStackTrace();
		}
		
		return Persone;
	}
	
}
