package br.com.ilog.test.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tb_course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, columnDefinition = "varchar(100)")
    private String titulo;
    @Column(nullable = false, columnDefinition = "varchar(300)")
    private String descricao;
    @Column(nullable = false)
    private Integer cargaHoraria;
    private BigDecimal valor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<UserCourse> userCourses;
}
