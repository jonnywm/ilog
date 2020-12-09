package br.com.ilog.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author jonny
 */
@Data
@ToString(exclude = "userCourses")
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(80)")
    private String nome;
    @Column(columnDefinition = "varchar(20)")
    private String telefone;
    @Column(columnDefinition = "varchar(255)")
    private String endereco;
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataAdmissao;
    @Column(columnDefinition = "varchar(20)")
    private String login;
    @Column()
    private String senha;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<UserCourse> userCourses;
}
