package cn.duckflew.springsecuritylearning.pojo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>
 *
 * </p>
 *
 * @author duckflew
 * @since 2021-03-24
 */
@Getter
@Setter
@Table(name = "t_role")
@Entity
@ToString
public class Role implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String nameZh;

    @ManyToMany(mappedBy = "adminRoles",fetch = FetchType.EAGER)
    Set<User> admins=new HashSet<>();

}
