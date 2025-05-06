/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.java.Class;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author owner
 */

//Manual Creates OTP for firs time use
public class hashedbrown {
    public static void main(String[] args) {
        String password = "1234";
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));

        System.out.println("Hashed Password: " + hashedPassword);
    }
}

