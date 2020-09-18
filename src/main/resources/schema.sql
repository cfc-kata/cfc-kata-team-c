create table if not exists repayment_order(
	repayment_id varchar(32) not null,
	loan_id varchar(32),
	create_time datetime not null,
	repayment_plan_id varchar(32),
	amount decimal(16, 2) not null default 0,
	repayment_bank_account varchar(32),
	repay_sts varchar(2),
	version int(10),
	primary key (repayment_id)
);

create table if not exists contract (
    id varchar(20) not null,
    create_time datetime not null,
    customer_id varchar(20) not null,
    customer_name varchar(100) not null,
    customer_id_number varchar(18) not null,
    customer_phone varchar(40) not null,
    interest_rate decimal(12, 2) not null default 0,
    commitment decimal(12, 2) not null default 0,
    repayment_type varchar(20) not null,
    maturity_date datetime not null,
    status varchar(40) not null,
    version int not null,
    primary key (id)
);