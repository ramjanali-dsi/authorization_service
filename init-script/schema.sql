create table dsi_api (api_id varchar(40) not null, is_active bit, url varchar(255), version integer not null, system_id varchar(40) not null, primary key (api_id));

create table dsi_default_api (default_api_id varchar(40) not null, allow_type varchar(20), version integer not null, api_id varchar(40) not null, primary key (default_api_id));

create table dsi_menu (menu_id varchar(40) not null, description TEXT, is_active bit, name varchar(50), parent_menu_id varchar(40), version integer not null, primary key (menu_id));

create table dsi_menu_api (menu_api_id varchar(40) not null, is_active bit, version integer not null, api_id varchar(40) not null, menu_id varchar(40) not null, system_id varchar(40) not null, primary key (menu_api_id));

create table dsi_role (role_id varchar(40) not null, is_active bit, name varchar(50), version integer not null, primary key (role_id));

create table dsi_role_menu (role_menu_id varchar(40) not null, is_active bit, version integer not null, menu_id varchar(40) not null, role_id varchar(40) not null, system_id varchar(40) not null, primary key (role_menu_id));

create table dsi_system (system_id varchar(40) not null, is_active bit, name varchar(50), short_name varchar(40), tenant_id varchar(40) not null, version integer not null, primary key (system_id));

create table dsi_user (user_id varchar(40) not null, created_by varchar(40) not null, created_date datetime, email varchar(40) not null, first_name varchar(40), gender varchar(10), last_name varchar(40), modified_by varchar(40) not null, modified_date datetime, phone varchar(20), tenant_id varchar(40) not null, version integer not null, primary key (user_id));

create table dsi_user_role (user_role_id varchar(40) not null, created_by varchar(40) not null, created_date datetime, is_active bit, modified_by varchar(40) not null, modified_date datetime, version integer not null, role_id varchar(40) not null, system_id varchar(40) not null, user_id varchar(40) not null, primary key (user_role_id));