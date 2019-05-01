package com.hy.common;

/** Created by yaohou on 22:32 2019/4/3. description:标签类 */
public class Lable {
  private String id;
  private String message;

  public Lable() {}

  public Lable(String id, String message) {
    this.id = id;
    this.message = message;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
