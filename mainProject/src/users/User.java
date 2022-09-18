package users;

import java.io.Serializable;


public abstract class User implements Serializable{
    protected String email;
    protected String password;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public void setEmailAddress(String email) {
        this.email = email;
    }

   public String getEmailAddress() {
        return email;
    }    

   
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
    public boolean verifyUser(String email, String password){
        if(this.email.equals(email)){
            if(this.password.equals(password)){
                return true;
            }
        }
        return false;
    }
    
}
