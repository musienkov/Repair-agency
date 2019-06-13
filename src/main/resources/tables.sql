alter table orders drop constraint order_fk_customer;
alter table orders drop constraint order_fk_master;
alter table feedback drop constraint feedback_fk_customer;
alter table feedback drop constraint feedback_fk_order;

drop table users;
drop table orders;
drop table feedback;


create table users
( 
    id          NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL PRIMARY KEY,
    name        VARCHAR2(50) ,
    login       VARCHAR2(50) ,
    password    VARCHAR2(30),
    role        VARCHAR2(20)
);



create table orders
(
    id              NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL PRIMARY KEY,
    customer_id     NUMBER,
    product         VARCHAR2(50),
    info            VARCHAR2(500),
    price           NUMBER,
    status          VARCHAR2(20),
    refusal_reason  VARCHAR2(100),
    master_id       NUMBER
);

create table feedback
(
    id              NUMBER GENERATED ALWAYS AS IDENTITY(START WITH 1 INCREMENT BY 1) NOT NULL PRIMARY KEY,
    customer_id NUMBER,
    order_id NUMBER,
    description VARCHAR2(4000)
);



alter table orders add constraint order_fk_customer FOREIGN KEY (customer_id) references users(id);
alter table orders add constraint order_fk_master FOREIGN KEY (master_id) references users(id);
alter table feedback add constraint feedback_fk_customer FOREIGN KEY (customer_id) references users(id);
alter table feedback add constraint feedback_fk_order FOREIGN KEY (order_id) references orders(id);

select * from feedback;
select f.id, f.customer_id, f.order_id, f.description from feedback f inner join orders o on f.order_id = o.id where o.master_id =22;


commit
