package com.example.AnyVehicle.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="users")
public class UserApplication implements UserDetails {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String username;
    private String phone;
    private String password;
    private String role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Request> requests;

//
//    @ManyToMany
//    @JoinTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"),
//                inverseJoinColumns = @JoinColumn(name="role_id"))
//    private Set<Role> roles = new HashSet<>();


    // empty constructor, required by Hibernate
    public UserApplication(){

    }

    // constructor to create objects out of the model
    public UserApplication(String firstName, String lastName,String username, String phone, String password, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.role = role;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

   public void setUsername(String username){
        this.username = username;
   }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //
//    public Set<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Set<Role> roles) {
//        this.roles = roles;
//    }
//
//    public void addRole(Role role){
//        this.roles.add(role);
//    }
}
