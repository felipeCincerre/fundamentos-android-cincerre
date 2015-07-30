package com.example.administrador.myapplication.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.administrador.myapplication.model.persistence.SQLiteClientRepository;
import com.example.administrador.myapplication.model.persistence.SQLiteUserRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrador on 30/07/2015.
 */
public class User implements Serializable, Parcelable {

    private Integer id;
    private String login;
    private String password;

    public User() {
        super();
    }

    public User(Parcel in) {
        super();
        readToParcel(in);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return !(password != null ? !password.equals(user.password) : user.password != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id == null ? -1 : id);
        dest.writeString(login == null ? "" : login);
        dest.writeString(password == null ? "" : password);
    }

    private void readToParcel(Parcel in) {
        int partialId = in.readInt();
        id = partialId == -1 ? null : partialId;
        login = in.readString();
        password = in.readString();
    }
    public void save() {
        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword("admin");
        SQLiteUserRepository.getInstance().save(admin);
    }

    public List<User> authentication() {
        return SQLiteUserRepository.getInstance().authentication(this);
    }

    public List<User> getAll() {
        return SQLiteUserRepository.getInstance().getAll();
    }


    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {


        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
