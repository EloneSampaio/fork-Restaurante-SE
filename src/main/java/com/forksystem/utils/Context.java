package com.forksystem.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/*
 * Padrão de projecto singleton
 * usado para retornar uma unica instancia da classe
 */
public class Context {
	
	public static Context stancia=null;
	
	
	
	
	private Context(){
		
     	
	}
	
	public static synchronized Context getInstace(){
		
		if(stancia==null){
		stancia	=new Context();
		}
		return stancia;
		
	}
	
	public ClassPathXmlApplicationContext getContexto(){
		
		ClassPathXmlApplicationContext  con=new ClassPathXmlApplicationContext("applicationContext.xml");
		  return con;
	}

}
