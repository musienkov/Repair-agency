package model.entity;

public class Order {

    private Long id;
    private Long customer_id;
    private String product;
    private String info;
    private double price;
    private STATUS status;
    private Long master_id;
    private String refusal_reason;




    public enum STATUS{
        UNKNOWN,
        ACCEPTED,
        REJECTED,
        COMPLETED

    }




    private Order(Builder builder) {
        this.id = builder.id;
        this.customer_id = builder.customer_id;
        this.product = builder.product;
        this.info = builder.info;
        this.price = builder.price;
        this.status = builder.status;
        this.master_id = builder.master_id;
        this.refusal_reason = builder.refusal_reason;
    }


    public Long getId() {
        return id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public String getProduct() {
        return product;
    }

    public String getInfo() {
        return info;
    }

    public double getPrice() {
        return price;
    }

    public STATUS getStatus() {
        return status;
    }

    public Long getMaster_id() {
        return master_id;
    }

    public String getRefusal_reason() {
        return refusal_reason;
    }

    public static class Builder {
        private long id = 0;
        private long customer_id = 0;
        private String product = "";
        private String info = "";
        private double price = 0;
        private STATUS status = STATUS.UNKNOWN;
        private long master_id = 0;
        private String refusal_reason = "";

        public Builder setId(long id) {
            this.id = id;
            return this;
        }



        public Builder setCustomerId(long customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }
        public Builder setInfo(String info) {
            this.info = info;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }
        public Builder setStatus(String stringStatus) {
            this.status = STATUS.valueOf(stringStatus.toUpperCase());
            return this;
        }
        public Builder setMasterId(long master_id) {
            this.master_id = master_id;
            return this;
        }

        public Builder setRefusalReason(String refusal_reason) {
            this.refusal_reason = refusal_reason;
            return this;
        }

        public Order build(){
            return new Order(this);
        }

    }
}
