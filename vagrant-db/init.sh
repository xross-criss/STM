#!/usr/bin/env bash

sudo apt-get update
sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password password root'
sudo debconf-set-selections <<< 'mysql-server mysql-server/root_password_again password root'
sudo apt-get install -y vim curl python-software-properties
sudo apt-get update
sudo apt-get -y install mysql-server
sed -i "s/^bind-address/#bind-address/" /etc/mysql/my.cnf
mysql -u root -proot -e "CREATE DATABASE dev_bdb CHARACTER SET utf8;"
mysql -u root -proot -e "CREATE USER 'bdb_user'@'%' IDENTIFIED BY 'BdBPass'; FLUSH PRIVILEGES;"
mysql -u root -proot -e "GRANT ALL PRIVILEGES ON dev_bdb.* TO 'bdb_user'@'%'; FLUSH PRIVILEGES;"
mysql -u root -proot -e "GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION; FLUSH PRIVILEGES;"
sudo /etc/init.d/mysql restart
