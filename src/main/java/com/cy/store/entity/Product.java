package com.cy.store.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * @PackgeName: com.cy.store.entity
 * @ClassName: Product
 * @Author: zyp
 * Date: 2022/2/13 13:25
 * project name: store
 * @Version:
 * @Description:
 */
public class Product extends BaseEntity implements Serializable {

    /**
     * 商品id
     */
    private Integer id;

    /**
     * 分类id
     */
    private Integer categoryId;

    /**
     * 商品系列
     */
    private String itemType;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品卖点
     */
    private String sellPoint;

    /**
     * 商品单价
     */
    private Long price;

    /**
     * 库存数量
     */
    private Integer num;

    /**
     * 图片路径
     */
    private String image;

    /**
     * 商品状态  1：上架   2：下架   3：删除
     */
    private Integer status;

    /**
     * 显示优先级
     */
    private Integer priority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(categoryId, product.categoryId) &&
                Objects.equals(itemType, product.itemType) &&
                Objects.equals(title, product.title) &&
                Objects.equals(sellPoint, product.sellPoint) &&
                Objects.equals(price, product.price) &&
                Objects.equals(num, product.num) &&
                Objects.equals(image, product.image) &&
                Objects.equals(status, product.status) &&
                Objects.equals(priority, product.priority);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryId, itemType, title, sellPoint, price, num, image, status, priority);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", itemType='" + itemType + '\'' +
                ", title='" + title + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
