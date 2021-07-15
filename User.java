//package miniproject;

 
class User {
 private String TIME,Monday,Tuesday,Wednesday,Thursday,Friday;
public User(String TIME,String Monday,String Tuesday,String Wednesday,String Thursday,String Friday)
{
    this.TIME=TIME;
    this.Monday=Monday;
    this.Tuesday=Tuesday;
    this.Wednesday=Wednesday;
    this.Thursday=Thursday;
    this.Friday=Friday;    
}

    

public String getTIME(){
    return TIME;
}
public String getMonday(){
    return Monday;
}
public String getTuesday(){
    return Tuesday;
}
public String getWednesday(){
    return Wednesday;
}
public String getThursday(){
    return Thursday;
}
public String getFriday(){
    return Friday;
}
}
