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
@Table(name = "customer_data")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false, name = "customer_name")
    private String customerName;
    @Column(nullable = false, name = "username")
    private String userName;
    @Column(nullable = false, name = "password")
    private String password;
    @Column(nullable = false, name = "phone_number")
    private Integer phoneNumber;
    @Column(nullable = false, name = "adress")
    private String address;
    //@Column(nullable =false,name = "role")
    //private String role;
    
}
