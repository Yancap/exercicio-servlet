package br.com.ibm.models.repositories;

import br.com.ibm.models.UsersModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UsersRepository {
  private List<UsersModel> usersList = new ArrayList<>();

  public UsersModel create(String name, String email, String password) {
    boolean isEmailExist = usersList.stream().anyMatch(users -> users.getEmail().equals(email));
    if(isEmailExist) {
      throw new RuntimeException("This Email already exists");
    }
    UsersModel user = new UsersModel(name, email, password);
    usersList.add(user);
    return user;
  }

  public UsersModel findByEmailAndPassword(String email, String password) {
    var user = usersList.stream()
            .filter(userdata -> userdata.getEmail().equals(email) && userdata.getPassword().equals(password))
            .toList()
            .get(0);
    if(user == null) {
      throw new RuntimeException("User not found");
    }
    return user;

  }
}
