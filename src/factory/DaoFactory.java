package factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	
	private static Properties p=new Properties();
    private DaoFactory(){  	
        try {
        	InputStream in=DaoFactory.class.getClassLoader().getResourceAsStream("factory/dao.properties");
        	p.load(in);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
    };
    private static final DaoFactory instance=new DaoFactory();
    public static DaoFactory getInstance(){
    	return instance;
    }
    public<T>T createDao(Class<T> interfaceClass){
    	
    	String key=interfaceClass.getSimpleName();
    	String className=p.getProperty(key);
    	
    	try {
			return (T)Class.forName(className).newInstance();
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}
