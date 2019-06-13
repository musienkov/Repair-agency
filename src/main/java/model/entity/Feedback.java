package model.entity;

public class Feedback {

    private Long id;
    private Long customer_id;
    private Long order_id;
    private String  description;

    public Long getId() {
        return id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public Long getCustomerId() {
        return customer_id;
    }

    public String getDescription() {
        return description;
    }

    private Feedback (Builder builder) {

        this.id = builder.id;
        this.customer_id = builder.customer_id;
        this.description = builder.description;
        this.order_id = builder.order_id;
    }

    public static class Builder {
        private long id = 0;
        private long customer_id = 0;
        private String description = "";
        private long order_id = 0;


        public Builder setId(long id) {
            this.id = id;
            return this;
        }
        public Builder setOrderId(long order_id) {
            this.order_id = order_id;
            return this;
        }
        public Builder setCustomerId(long customer_id) {
            this.customer_id = customer_id;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Feedback build(){
            return new Feedback(this);
        }
    }
}
