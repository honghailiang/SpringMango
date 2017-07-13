package com.mango.jtt.po;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by DELL on 2017/4/19.
 * 订单地址信息
 */
@Embeddable
public class Address extends BaseBean {
    @Column(name = "ADDRESS_STREET")
    private String street;
    @Column(name = "ADDRESS_ZIPCODE")
    private String zipcode;
    @Column(name = "ADDRESS_CITY")
    private String city;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
