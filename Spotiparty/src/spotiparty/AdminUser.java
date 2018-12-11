/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

/**
 *
 * @author Utilizador
 */
public class AdminUser extends User{

    public boolean is_Admin;
    
    public AdminUser(User u, boolean Admin) {
        super(u);
        is_Admin = true;
    }
    
    public boolean is_Admin(){
        return is_Admin;
    }
    
}
