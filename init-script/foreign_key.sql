alter table dsi_user add constraint UK_userEmail  unique (email);

alter table dsi_api add constraint FK_apiSystemId foreign key (system_id) references dsi_system (system_id);

alter table dsi_default_api add constraint FK_defaultApiId foreign key (api_id) references dsi_api (api_id);

alter table dsi_menu_api add constraint FK_menuApiId foreign key (api_id) references dsi_api (api_id);

alter table dsi_menu_api add constraint FK_menuApiMenuId foreign key (menu_id) references dsi_menu (menu_id);

alter table dsi_menu_api add constraint FK_menuApiSystemId foreign key (system_id) references dsi_system (system_id);

alter table dsi_role_menu add constraint FK_roleMenuMenuId foreign key (menu_id) references dsi_menu (menu_id);

alter table dsi_role_menu add constraint FK_roleMenuRoleId foreign key (role_id) references dsi_role (role_id);

alter table dsi_role_menu add constraint FK_roleMenuSystemId foreign key (system_id) references dsi_system (system_id);

alter table dsi_user_role add constraint FK_userRoleRoleId foreign key (role_id) references dsi_role (role_id);

alter table dsi_user_role add constraint FK_userRoleSystemId foreign key (system_id) references dsi_system (system_id);

alter table dsi_user_role add constraint FK_userRoleUserId foreign key (user_id) references dsi_user (user_id);

alter table dsi_user_context add index FK34C94FA013068535 (user_id), add constraint FK34C94FA013068535 foreign key (user_id) references dsi_user (user_id);
