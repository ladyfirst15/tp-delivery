package myProject_LSP;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name="Delivery_table")
public class Delivery {

    @Autowired
    @Transient
    DeliveryRepository deliveryRepository;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String status;
    private Long orderId;

    @PrePersist
    public void onPrePersist(){
        System.out.println(this.getStatus() + "^^^^^^^^^^^^^^^^^^^^^^^^^");
        if("SHIPPED".equals(this.getStatus())){
            Shipped shipped = new Shipped();
            BeanUtils.copyProperties(this, shipped);
            shipped.publishAfterCommit();
        }else if("SHIP_CANCEL".equals(this.getStatus())){ //취소


            System.out.println("34!!!!!!!!!!!!1");
            System.out.println("this.getOrderId()@@@@@@@@@@" + this.getOrderId());

            //deliveryRepository.findById(this.getId());

            //deliveryRepository.findByOrderId(this.getOrderId());
            //Optional<Delivery> orderOptional = deliveryRepository.findByOrderId(this.getOrderId());

            System.out.println("39!!!!!!!!!!!!1");

            //Delivery delivery = orderOptional.get();

            System.out.println("43!!!!!!!!!!!!1");

            //this.id = delivery.getId();

            System.out.println("47!!!!!!!!!!!!1");

            this.setStatus("SHIP_CANCELLED");

            ShippedCancelled shippedCancelled = new ShippedCancelled();
            BeanUtils.copyProperties(this, shippedCancelled);
            shippedCancelled.publishAfterCommit();
        }


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }




}
