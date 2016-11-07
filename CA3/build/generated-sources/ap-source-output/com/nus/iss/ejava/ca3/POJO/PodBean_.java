package com.nus.iss.ejava.ca3.POJO;

import com.nus.iss.ejava.ca3.POJO.DeliveryBean;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-11-07T17:51:07")
@StaticMetamodel(PodBean.class)
public class PodBean_ { 

    public static volatile SingularAttribute<PodBean, String> note;
    public static volatile SingularAttribute<PodBean, byte[]> image;
    public static volatile SingularAttribute<PodBean, Long> ackId;
    public static volatile SingularAttribute<PodBean, DeliveryBean> delivery;
    public static volatile SingularAttribute<PodBean, Date> deliveryDate;
    public static volatile SingularAttribute<PodBean, Long> podId;

}