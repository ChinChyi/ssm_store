package com.example.demo.entity;

public class User {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.email
     *
     * @mbggenerated
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.firstname
     *
     * @mbggenerated
     */
    private String firstname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.lastname
     *
     * @mbggenerated
     */
    private String lastname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.password
     *
     * @mbggenerated
     */
    private String password;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.email
     *
     * @return the value of user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.email
     *
     * @param email the value for user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.firstname
     *
     * @return the value of user.firstname
     *
     * @mbggenerated
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.firstname
     *
     * @param firstname the value for user.firstname
     *
     * @mbggenerated
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname == null ? null : firstname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.lastname
     *
     * @return the value of user.lastname
     *
     * @mbggenerated
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.lastname
     *
     * @param lastname the value for user.lastname
     *
     * @mbggenerated
     */
    public void setLastname(String lastname) {
        this.lastname = lastname == null ? null : lastname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.password
     *
     * @return the value of user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.password
     *
     * @param password the value for user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}