/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  beethoven
 * Created: Aug 7, 2016
 */

INSERT INTO barang (id,nama_barang,stok_barang) VALUES
('1','kerdus','2'),
('2','Mouse','3');

INSERT INTO `c_security_role` (`id`,`nama`,`description`) VALUES
('admin','admin','Application User'),
('user','user','Application User');

INSERT INTO `c_security_permission` (`id`,`permission_label`,`permission_value`) VALUES
('customer_update','Edit Customer','ROLE_CUSTOMER_UPDATE'),
('customer_view','View Customer','ROLE_CUSTOMER_VIEW'),
('customer_create','Create Customer','ROLE_CUSTOMER_CREATE'),
('customer_delete','Delete Customer','ROLE_CUSTOMER_DELETE'),
('user_view','View User','ROLE_USER_VIEW');

INSERT INTO `c_security_role_permission` (`id_role`,`id_permission`) VALUES
('admin','customer_update'),
('admin','customer_view'),
('admin','customer_create'),
('admin','customer_delete'),
('user','customer_view'),
('user','user_view'),
('admin','user_view');

INSERT INTO `c_security_user` (`id`,`username`,`password`,`active`,`id_role`) VALUES
('1','admin','admin',true,'admin'),
('2','user','user',true,'user');