create table cmm_cmmCache (
	cmmId LONG not null primary key,
	hashKey VARCHAR(75) null,
	hashValue VARCHAR(75) null,
	hashDateUpdate DATE null
);