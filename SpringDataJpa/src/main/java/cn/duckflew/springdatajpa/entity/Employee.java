package cn.duckflew.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String gender;
  private java.sql.Date birthday;
  @Column(name = "idcard")
  private String idCard;
  private String wedlock;
  private long nationId;
  @Column(name = "nativeplace")
  private String nativePlace;
  private long politicId;
  private String email;
  private String phone;
  private String address;
  private long departmentId;
  private long jobLevelId;
  private long posId;
  @Column(name = "engageform")
  private String engageForm;
  @Column(name = "tiptopdegree")
  private String tiptopDegree;
  private String specialty;
  private String school;
  @Column(name = "begindate")
  private java.sql.Date beginDate;
  @Column(name = "workstate")
  private String workState;
  @Column(name = "workid")
  private String workId;
  private double contractTerm;
  @Column(name = "conversiontime")
  private java.sql.Date conversionTime;
  @Column(name = "not_work_date")
  private java.sql.Date notWorkDate;
  @Column(name = "begincontract")
  private java.sql.Date beginContract;
  @Column(name = "endcontract")
  private java.sql.Date endContract;
  private long workAge;
  private long salaryId;
}
