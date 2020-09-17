create table if not exists repayment_order(
	repayment_id varchar(32) not null,
	loan_id varchar(32),
	create_time datetime not null,
	repayment_plan_id varchar(32),
	amount decimal(16, 2) not null default 0,
	repayment_bank_account varchar(32),
	repay_sts varchar(2),
	primary key (repayment_id)
);