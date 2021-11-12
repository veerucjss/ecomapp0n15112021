package com.cjss.ecomapp.model;
import javax.persistence.*;

@Entity
public class CustomerAddress {
    @Id
    @Column(name = "id", nullable = false)
    private Long id ;
    @Column
    private String addline1;
    @Column
    private String addline2;
    @Column
    private int postalcode;
    @Column
    private String state;
    @Column
    private String city;
    @Column
    private boolean shippingaddr1;
    @Column
    private boolean shippingaddr2;

    public CustomerAddress(String mpnagar, String kkdpalli, int i, String ap, String amaravathi) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerAddress(String npnagar, String kukatpalli, int i, String ap, String amaravathi, boolean b, boolean b1){}

    public CustomerAddress(Long id, String addline1, String addline2, int postalcode, String state, String city, boolean shippingaddr1, boolean shippingaddr2) {
        this.id = id;
        this.addline1 = addline1;
        this.addline2 = addline2;
        this.postalcode = postalcode;
        this.state = state;
        this.city = city;
        this.shippingaddr1 = shippingaddr1;
        this.shippingaddr2 = shippingaddr2;
    }

    public String getAddline1() {
        return addline1;
    }

    public void setAddline1(String addline1) {
        this.addline1 = addline1;
    }

    public String getAddline2() {
        return addline2;
    }

    public void setAddline2(String addline2) {
        this.addline2 = addline2;
    }
}
