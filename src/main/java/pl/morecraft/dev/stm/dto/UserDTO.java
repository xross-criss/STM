package pl.morecraft.dev.stm.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.validator.constraints.Email;
import org.joda.time.LocalDate;
import pl.morecraft.dev.stm.utils.JsonJodaLocalDateDeserializer;
import pl.morecraft.dev.stm.utils.JsonJodaLocalDateSerializer;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class UserDTO {

    @NotNull
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]*$")
    @NotNull
    @Size(min = 1, max = 32)
    private String login;

    @NotNull
    @Size(min = 6, max = 128)
    private String password;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(max = 50)
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(max = 50)
    private String secondName;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(max = 50)
    private String lastName;

    @Pattern(regexp = "^[a-zA-Z]*$")
    @Size(max = 50)
    private String title;

    @Email
    @Size(min = 6, max = 128)
    private String email;

    @JsonSerialize(using = JsonJodaLocalDateSerializer.class)
    @JsonDeserialize(using = JsonJodaLocalDateDeserializer.class)
    private LocalDate passwordExpireDate;

    private String status;

    private List<RoleAssignmentDTO> roleAssignments;

    @Pattern(regexp = "^/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/")
    @Size(max = 20)
    private String phone;

    public UserDTO() {
    }

    public UserDTO(Long id, String login, String password, String firstName, String secondName, String lastName, String title, String email, LocalDate passwordExpireDate, String status, List<RoleAssignmentDTO> roleAssignments, String phone) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.title = title;
        this.email = email;
        this.passwordExpireDate = passwordExpireDate;
        this.status = status;
        this.roleAssignments = roleAssignments;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getPasswordExpireDate() {
        return passwordExpireDate;
    }

    public void setPasswordExpireDate(LocalDate passwordExpireDate) {
        this.passwordExpireDate = passwordExpireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RoleAssignmentDTO> getRoleAssignments() {
        return roleAssignments;
    }

    public void setRoleAssignments(List<RoleAssignmentDTO> roleAssignments) {
        this.roleAssignments = roleAssignments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", passwordExpireDate=" + passwordExpireDate +
                ", status='" + status + '\'' +
                ", roleAssignments=" + roleAssignments +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
