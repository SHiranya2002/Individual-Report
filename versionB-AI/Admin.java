public class Admin extends User {
   

    public Admin(int adminId, String adminName, String adminEmail, String userPassword) {
        super(adminId, adminName, adminEmail, userPassword);
        
    }

    public void addEvent(){
        System.out.println("Event added successfully");
    }

    public void removeEvent(){
        System.out.println("Event removed successfully");
    }

    
}
