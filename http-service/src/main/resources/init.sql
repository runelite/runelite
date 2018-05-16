-- set time zone
set @@global.time_zone = '+00:00';
-- create runelite:runelite user
create user if not exists 'runelite'@'localhost' identified by 'runelite';
-- create databases
create database if not exists runelite;
create database if not exists `runelite-cache2`;
create database if not exists `runelite-tracker`;
-- grant privileges to databases to our runelite user
grant all on runelite.* to 'runelite'@'localhost' identified by 'runelite';
grant all on `runelite-cache2`.* to 'runelite'@'localhost' identified by 'runelite';
grant all on `runelite-tracker`.* to 'runelite'@'localhost' identified by 'runelite';
flush privileges;
