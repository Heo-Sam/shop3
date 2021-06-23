create table cart (
    c_idx number(4) not null primary key,
    userid varchar2(50) not null,
    p_num varchar2(10) not null,
    p_name varchar2(50) not null,
    p_price	number(10)	not null,
    p_saleprice number(10)not null,
    quant number(4),
    FOREIGN KEY (userid) REFERENCES members(id)
);

create sequence cart_seq
increment by 1
start with 1;



