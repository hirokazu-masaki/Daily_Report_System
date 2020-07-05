package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "likes")
@NamedQueries({
    @NamedQuery(
            name = "getAllLikes",
            query = "SELECT r FROM Report AS r ORDER BY r.id DESC"
            ),
    @NamedQuery(
            name = "getLikesCount",
            query = "SELECT COUNT(r) FROM Report AS r"
            ),
})

@Entity
public class Like {
    @Id
    @Column(name = "like_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer like_id;

    @Column(name = "like_employee_id")
    private Integer like_employee_id;

    @JoinColumn(name = "liked_report_id")
    private Integer liked_report_id;


    public Integer getLike_id() {
        return like_id;
    }

    public void setLike_id(Integer like_id) {
        this.like_id = like_id;
    }

    public Integer getLike_employee_id() {
        return like_employee_id;
    }

    public void setLike_employee_id(Integer like_employee_id) {
        this.like_employee_id = like_employee_id;
    }

    public Integer getLiked_report_id() {
        return liked_report_id;
    }

    public void setLiked_report_id(Integer liked_report_id) {
        this.liked_report_id = liked_report_id;
    }

}