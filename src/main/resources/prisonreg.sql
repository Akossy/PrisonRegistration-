DROP TABLE IF EXISTS `PRISON_REGISTER` CASCADE;
CREATE TABLE PRISON_REGISTER(

prisoner_id INT AUTO_INCREMENT,
prisoner_name VARCHAR (255) NOT NULL,
crime VARCHAR (255) NOT NULL, 
reason_in_solitary_confinement VARCHAR (255) NOT NULL,
ward_relocation_once_released VARCHAR (10)  NOT NULL,
total_prison_sentence_in_months FLOAT NOT NULL, 
days_in_solitary_confinement FLOAT NOT NULL,
gang_member boolean NOT NULL,
suicide_watch boolean NOT NULL, 
repeat_visitor boolean NOT NULL,

PRIMARY KEY (prisoner_id)
);
INSERT INTO `prison_register` (`prisoner_name`,`crime`,`reason_in_solitary_confinement`,`ward_relocation_once_released`,`days_in_solitary_confinement`,`total_prison_sentence_in_months`,`gang_member`,`suicide_watch`,`repeat_visitor`) VALUES ('name','crime','reason','a', 1, 1, true, true, true);
INSERT INTO `prison_register` (`prisoner_name`,`crime`,`reason_in_solitary_confinement`,`ward_relocation_once_released`,`days_in_solitary_confinement`,`total_prison_sentence_in_months`,`gang_member`,`suicide_watch`,`repeat_visitor`) VALUES ('name','crime','reason','b', 2, 2, true, true, true);

