package pl.morecraft.dev.stm.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prv_user")
@Getter
@Setter
@NoArgsConstructor
public class User extends PrivilegeObject {


}
