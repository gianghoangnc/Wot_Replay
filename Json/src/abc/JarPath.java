package abc;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;


public class JarPath {
  public static void main(String[] args) {
    URL url = JarPath.class.getProtectionDomain().getCodeSource().getLocation(); //Gets the path
  	String jarPath = null;
		try {
			jarPath = URLDecoder.decode(url.getFile(), "UTF-8"); //Should fix it to be read correctly by the system
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
    String parentPath = new File(jarPath).getParentFile().getPath(); //Path of the jar
		parentPath = parentPath + File.separator;
    
    System.out.println("Path: " + parentPath);
  }
}
 