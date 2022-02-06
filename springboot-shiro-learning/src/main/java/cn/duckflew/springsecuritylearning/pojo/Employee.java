package cn.duckflew.springsecuritylearning.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name; //姓名
  private String gender; //性别
  private java.sql.Date birthday;
  @Column(name = "idcard")
  private String idCard; //身份证
  private String wedlock; //婚姻状 况
  private String nation; //民族
  @Column(name = "nativeplace")
  private String nativePlace;   //籍贯
  private String politic ;    //政治面貌
  private String email;
  private String phone;  //电话
  private String address;  //联系地址
  @Column(name = "tiptopdegree")
  private String tiptopDegree;  //最高学历
  private String specialty;  //专业
  private String school;  //毕业院校
  @Column(name = "begindate")
  private java.sql.Date beginDate; //入职日期
  @Column(name = "notWorkDate")
  private java.sql.Date notWorkDate;  //离职日期
  private Integer workAge;   //工龄
  private Integer salaryId;  //薪资账套ID
}
