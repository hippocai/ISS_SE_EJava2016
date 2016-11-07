package com.nus.iss.ejava.ca3.POJO;

import com.nus.iss.ejava.ca3.POJO.PodBean;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:51:07")
@StaticMetamodel(DeliveryBean.class)
public class DeliveryBean_ { 

    public static volatile SingularAttribute<DeliveryBean, PodBean> podBean;
    public static volatile SingularAttribute<DeliveryBean, String> address;
    public static volatile SingularAttribute<DeliveryBean, String> phone;
    public static volatile SingularAttribute<DeliveryBean, String> name;
    public static volatile SingularAttribute<DeliveryBean, Long> pkgId;
    public static volatile SingularAttribute<DeliveryBean, Date> createDate;

}