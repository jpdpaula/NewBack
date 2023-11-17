package senac.java.Domain;

import org.json.JSONObject;

import java.util.List;

public class Users {
    int id = 0;
    public static String nome = "";
    public static String lastName = "";
    public static int age = 0;
    public static String address = "";
    public static String email = "";
    public static String password = "";
    public static String cpf = "";

    public Users(){
    }

    public Users(String nome, String lastName, int age,
                 String address, String email, String password,
                 String cpf){

        this.nome = nome;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.email = email;
        this.password = password;
        this.cpf = cpf;
    }

    public String getNome(){
        return nome;
    }

    public void setName(String name){
        this.nome = name;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getCpf(){

        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public JSONObject toJson(){
        JSONObject json = new JSONObject();

        json.put("name", nome);
        json.put("lastName", lastName);
        json.put("age", age);
        json.put("address", address);
        json.put("email", email);
        json.put("password", password);
        json.put("cpf", cpf);

        return json;
    }

    public JSONObject arrayToJson(List<Users> usersList) {
        JSONObject json = new JSONObject();

        if (!usersList.isEmpty()) {
            var keyJson = 1;

            for (Users users : usersList) {

                JSONObject jsonFor = new JSONObject();

                jsonFor.put("name", users.getNome());
                jsonFor.put("lastName", users.getLastName());
                jsonFor.put("age", users.getAge());
                jsonFor.put("address", users.getAddress());
                jsonFor.put("email", users.getEmail());
                jsonFor.put("password", users.getPassword());
                jsonFor.put("cpf", users.getCpf());

                json.put(String.valueOf(keyJson), jsonFor);

                keyJson++;
            }
            return json;
        }

        else{
            return null;
        }
    }

    public static Users getUsers(int index, List<Users> usersList){
        if(index >= 0 && index < usersList.size()) {

            return usersList.get(index);
        }

        else{
            return null;
        }
    }

    public static List<Users> getAllUsers(List<Users> usersList){
        return usersList;
    }
}