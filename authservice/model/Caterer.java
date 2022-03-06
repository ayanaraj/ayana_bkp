package gbs.project.authservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cateres_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Caterer {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, name = "caterer_name")
    private String catererName;
    @Column(nullable = false, name = "location")
    private String location;
    @Column(nullable = false, name = "phone_number")
    private Integer phno;
    @Column(nullable = false, name = "caterer_usernmae")
    private String catererUsername;
    @Column(nullable = false, name = "caterer_password")
    private String catererPassword;
    //@Column(nullable =false,name = "role")
    //private String role;
}
