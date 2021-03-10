package com.bdqn.entity;


import java.util.Date;

public class Room {

  private int id;
  private int roomNo;
  private String roomType;
  private int peopleConut;
  private double rent;
  private int isRental;
  private Date createTime;
  private Date updatedTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getRoomNo() {
    return roomNo;
  }

  public void setRoomNo(int roomNo) {
    this.roomNo = roomNo;
  }


  public String getRoomType() {
    return roomType;
  }

  public void setRoomType(String roomType) {
    this.roomType = roomType;
  }


  public int getPeopleConut() {
    return peopleConut;
  }

  public void setPeopleConut(int peopleConut) {
    this.peopleConut = peopleConut;
  }


  public double getRent() {
    return rent;
  }

  public void setRent(double rent) {
    this.rent = rent;
  }


  public int getIsRental() {
    return isRental;
  }

  public void setIsRental(int isRental) {
    this.isRental = isRental;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }


  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

}
