create sequence guid_seq;

create table parent (
	id INTEGER PRIMARY KEY,
	
);

create table son1(
	id INTEGER PRIMARY KEY,
	id_parent number(9,0),
	str varchar(12)
);

create table son2(
	id INTEGER PRIMARY KEY,
	id_parent number(9,0),
	str varchar(12)
);