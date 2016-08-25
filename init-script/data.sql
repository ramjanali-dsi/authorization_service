
INSERT INTO `service_authorization`.`dsi_system` (`system_id`, `is_active`, `name`, `short_name`, `tenant_id`, `version`) VALUES ('425744ba-6c10-47c0-91cf-5a4c05265b56', b'1', 'Hiringapp', 'HA', 'cc4e0554-6582-498b-9ae2-ad3c612f8e8e', '1');

INSERT INTO `service_authorization`.`dsi_user` (`user_id`, `created_by`, `created_date`, `email`, `first_name`, `gender`, `last_name`, `modified_by`, `modified_date`, `phone`, `tenant_id`, `version`) VALUES ('f9e9a19f-4859-4e8c-a8f4-dc134629a57b', '', '2016-07-01 00:00:00', 'sabbir@gmail.com', 'Sabbir', 'Male', 'Ahmed', '', '2016-07-01 00:00:00', '01676661557', 'cc4e0554-6582-498b-9ae2-ad3c612f8e8e', '1');


----------------------------------- Authenticate API List --------------------------------------

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('5ad26e94-f02b-45a0-8f01-5a78b59c8fff', b'1', 'v1/login_session', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('d0fe5493-5bac-470d-b924-16754cc131bd', b'1', 'v1/login_session', 'DELETE', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('4f0c3adc-a5cb-4a82-aaa8-d630dff0abae', b'1', 'v1/login_session', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('6d752110-f01f-4958-a46b-6842ebba5b62', b'1', 'v1/access_token', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('c79e0ddf-abf5-431f-8478-7bed057b2d9b', b'1', 'v1/password/reset', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('3349ac71-c9de-4638-bcdf-285743809f23', b'1', 'v1/password/change', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('f58a9fe2-b4fa-4ff0-b81a-fe10edb08031', b'1', 'v1/role', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('d70b697c-33f1-4109-b5ab-e5ea1640f064', b'1', 'v1/menu', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('9f138829-690d-4567-a18c-c3714aa597e2', b'1', 'v1/user_session', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('0a1bb3a9-67a0-4c89-af88-e575edc602bf', b'1', 'v1/user_session', 'PUT', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('81d0c3d2-0b76-449e-992e-61167120ad0c', b'1', 'v1/user_session', 'DELETE', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('87528562-327b-481e-9827-095edaa1f32c', b'1', 'v1/user_session/is_valid', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('5457535d-27ff-4939-96a2-b29a08ab5d87', b'1', 'v1/user', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('ffe06fd4-53f0-4cdd-a273-68d0ed7849f3', b'1', 'v1/login_session/create', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');




----------------------------------- Authorized API List --------------------------------------

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('b3127bfa-f581-4f3a-a0c9-10c621ca49a3', 'Public', '1', '5ad26e94-f02b-45a0-8f01-5a78b59c8fff');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('cefcf99c-30ea-4d77-b6a2-542d8c906cca', 'Authenticated', '1', 'd0fe5493-5bac-470d-b924-16754cc131bd');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('0bc7a08c-e892-4bb1-b781-f634fc211c48', 'Public', '1', 'c79e0ddf-abf5-431f-8478-7bed057b2d9b');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('9b9324ab-37e0-47c2-9c3e-ba07016a1eee', 'System', '1', '9f138829-690d-4567-a18c-c3714aa597e2');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('7dfbaacd-ce0a-44fe-aa4a-9088edfc0507', 'Authenticated', '1', '4f0c3adc-a5cb-4a82-aaa8-d630dff0abae');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('44f167ca-8747-4e77-94c2-ffbcee87ad74', 'System', '1', '87528562-327b-481e-9827-095edaa1f32c');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('4cd6c7cf-a4d7-4799-b69a-fbe7c0ec2ce0', 'Authenticated', '1', '6d752110-f01f-4958-a46b-6842ebba5b62');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('ffcbf122-0244-4138-a26a-985c83aad786', 'System', '1', '0a1bb3a9-67a0-4c89-af88-e575edc602bf');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('a846a1fb-becd-4b02-8e81-946234f454e5', 'System', '1', '81d0c3d2-0b76-449e-992e-61167120ad0c');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('64da36cd-4bb7-42cd-89be-1001e52b1088', 'Authenticated', '1', 'c79e0ddf-abf5-431f-8478-7bed057b2d9b');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('d4583f3b-00c7-4d97-8e42-aebbd6437ce8', 'Authenticated', '1', 'd70b697c-33f1-4109-b5ab-e5ea1640f064');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('c3d8e711-8fe4-4678-9a37-7c8a7550e28a', 'System', '1', '5457535d-27ff-4939-96a2-b29a08ab5d87');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('28c89cf2-3e39-4fbb-9d5f-389a8bc3431f', 'System', '1', 'ffe06fd4-53f0-4cdd-a273-68d0ed7849f3');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('1f7f0ade-12a4-4918-a9c5-9116cf29a6ac', 'Authenticated', '1', 'f58a9fe2-b4fa-4ff0-b81a-fe10edb08031');

