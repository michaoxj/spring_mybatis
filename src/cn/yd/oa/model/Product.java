package cn.yd.oa.model;

import java.util.Date;

// 类-->表   对象-->记录   属性 ---> 字段
public class Product extends Object {

	// public String toString() {
	// return getClass().getName() + "@" + Integer.toHexString(hashCode());
	// }

	@Override // 此方法重写父类的某个方法
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", remark=" + remark + ", date=" + date
				+ "]";
	}

	// 属性是私有的,不能直接访问.
	private Integer id;

	private String name;
	private Double price;
	private String remark;
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		System.out.println("getName..........");
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
