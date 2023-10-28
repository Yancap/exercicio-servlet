package br.com.ibm.models;

import br.com.ibm.models.repositories.UsersRepository;

public class Database {
  public UsersRepository users;
  private static final Database instance;

  static {
    instance = new Database(new UsersRepository());
  }

  private Database(UsersRepository users) {
    this.users = users;
    this.users.create("Yan Gabriel Ferreira", "yan@email.com", "12345");
    this.users.create("John Doe", "john@email.com", "12345");
  }

  public static Database getInstance(){
    return instance;
  }
}
