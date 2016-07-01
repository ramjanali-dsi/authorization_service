
INSERT INTO `service_authorization`.`dsi_system` (`system_id`, `is_active`, `name`, `short_name`, `tenant_id`, `version`) VALUES ('425744ba-6c10-47c0-91cf-5a4c05265b56', b'1', 'Hiringapp', 'HA', 'cc4e0554-6582-498b-9ae2-ad3c612f8e8e', '1');

INSERT INTO `service_authorization`.`dsi_user` (`user_id`, `created_by`, `created_date`, `email`, `first_name`, `gender`, `last_name`, `modified_by`, `modified_date`, `phone`, `tenant_id`, `version`) VALUES ('f9e9a19f-4859-4e8c-a8f4-dc134629a57b', '', '2016-07-01 00:00:00', 'sabbir@gmail.com', 'Sabbir', 'Male', 'Ahmed', '', '2016-07-01 00:00:00', '01676661557', 'cc4e0554-6582-498b-9ae2-ad3c612f8e8e', '1');


----------------------------------- Authenticate API List --------------------------------------

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('5ad26e94-f02b-45a0-8f01-5a78b59c8fff', b'1', 'v1/login_session', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('d0fe5493-5bac-470d-b924-16754cc131bd', b'1', 'v1/login_session', 'DELETE', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('4f0c3adc-a5cb-4a82-aaa8-d630dff0abae', b'1', 'v1/login_session', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('6d752110-f01f-4958-a46b-6842ebba5b62', b'1', 'v1/access_token', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('c79e0ddf-abf5-431f-8478-7bed057b2d9b', b'1', 'v1/password/reset', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('3349ac71-c9de-4638-bcdf-285743809f23', b'1', 'v1/password/change', 'POST', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');


----------------------------------- Authorized API List --------------------------------------

INSERT INTO `service_authorization`.`dsi_api` (`api_id`, `is_active`, `url`, `method`, `version`, `system_id`) VALUES ('f58a9fe2-b4fa-4ff0-b81a-fe10edb08031', b'1', 'v1/role', 'GET', '1', '425744ba-6c10-47c0-91cf-5a4c05265b56');


INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('b3127bfa-f581-4f3a-a0c9-10c621ca49a3', 'Public', '1', '5ad26e94-f02b-45a0-8f01-5a78b59c8fff');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('cefcf99c-30ea-4d77-b6a2-542d8c906cca', 'Authenticated', '1', 'd0fe5493-5bac-470d-b924-16754cc131bd');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('0bc7a08c-e892-4bb1-b781-f634fc211c48', 'Public', '1', 'c79e0ddf-abf5-431f-8478-7bed057b2d9b');

INSERT INTO `service_authorization`.`dsi_default_api` (`default_api_id`, `allow_type`, `version`, `api_id`) VALUES ('7a56c6ab-a9fb-466b-87ca-b5fa06948d46', 'Public', '1', '98fc604a-9cc8-4bd8-8435-395288470bfa');

