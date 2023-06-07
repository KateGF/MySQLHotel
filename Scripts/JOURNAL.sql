-- TABLE JOURNAL
DROP TABLE IF EXISTS Journal;
CREATE TABLE Journal (
    nameSchema VARCHAR(100),
    nameTable VARCHAR(100),
    nameColumn VARCHAR(100),
	modDate DATE,
    newValue VARCHAR(100)
);

-- INSERT INTO JOURNAL
DROP PROCEDURE IF EXISTS `KT`.`INSERT_JOURNAL`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_JOURNAL`(p_nameSchema VARCHAR(100), p_nameTable VARCHAR(100), p_nameColumn VARCHAR(100), p_modDate DATE, p_newValue VARCHAR(100))
BEGIN
	INSERT INTO Journal (nameSchema, nameTable, nameColumn, modDate, newValue) VALUES (p_nameSchema, p_nameTable, p_nameColumn, p_modDate, p_newValue);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalUsers`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalUsers` BEFORE INSERT ON `KT`.`Users` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'FirstName', SYSDATE(), NEW.FirstName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'MiddleName', SYSDATE(), NEW.MiddleName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'LastName', SYSDATE(), NEW.LastName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'SecondSurname', SYSDATE(), NEW.SecondSurname);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Photo', SYSDATE(), NEW.Photo);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'IdentificationCard', SYSDATE(), NEW.IdentificationCard);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Username', SYSDATE(), NEW.Username);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Password', SYSDATE(), NEW.Password);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'BirthDate', SYSDATE(), NEW.BirthDate);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idDistrict', SYSDATE(), NEW.idDistrict);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idType', SYSDATE(), NEW.idType);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idGender', SYSDATE(), NEW.idGender);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idUserType', SYSDATE(), NEW.idUserType);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idHotelAdmin', SYSDATE(), NEW.idHotelAdmin);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalUsers`;
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalUsers` BEFORE UPDATE ON `KT`.`Users` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'FirstName', SYSDATE(), NEW.FirstName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'MiddleName', SYSDATE(), NEW.MiddleName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'LastName', SYSDATE(), NEW.LastName);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'SecondSurname', SYSDATE(), NEW.SecondSurname);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Photo', SYSDATE(), NEW.Photo);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'IdentificationCard', SYSDATE(), NEW.IdentificationCard);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Username', SYSDATE(), NEW.Username);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'Password', SYSDATE(), NEW.Password);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'BirthDate', SYSDATE(), NEW.BirthDate);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idDistrict', SYSDATE(), NEW.idDistrict);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idType', SYSDATE(), NEW.idType);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idGender', SYSDATE(), NEW.idGender);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idUserType', SYSDATE(), NEW.idUserType);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Users', 'idHotelAdmin', SYSDATE(), NEW.idHotelAdmin);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalIDType`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalIDType` BEFORE INSERT ON `KT`.`IDType` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'IDType', 'Mask', SYSDATE(), NEW.Mask);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'IDType', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalIDType`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalIDType` BEFORE UPDATE ON `KT`.`IDType` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'IDType', 'Mask', SYSDATE(), NEW.Mask);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'IDType', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalCountry`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalCountry` BEFORE INSERT ON `KT`.`Country` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Country', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalCountry`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalCountry` BEFORE UPDATE ON `KT`.`Country` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Country', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalState`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalState` BEFORE INSERT ON `KT`.`State` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'State', 'Name', SYSDATE(), NEW.Name);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'State', 'idCountry', SYSDATE(), NEW.idCountry);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalState`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalState` BEFORE UPDATE ON `KT`.`State` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'State', 'Name', SYSDATE(), NEW.Name);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'State', 'idCountry', SYSDATE(), NEW.idCountry);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalCanton`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalCanton` BEFORE INSERT ON `KT`.`Canton` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'idState', SYSDATE(), NEW.idState);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalCanton`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalCanton` BEFORE UPDATE ON `KT`.`Canton` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'idState', SYSDATE(), NEW.idState);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalDistrict`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalDistrict` BEFORE INSERT ON `KT`.`District` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'District', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'idCanton', SYSDATE(), NEW.idCanton);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalDistrict`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalDistrict` BEFORE UPDATE ON `KT`.`District` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'District', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Canton', 'idCanton', SYSDATE(), NEW.idCanton);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalNationality`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalNationality` BEFORE INSERT ON `KT`.`Nationality` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Nationality', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalNationality`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalNationality` BEFORE UPDATE ON `KT`.`Nationality` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Nationality', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalGender`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalGender` BEFORE INSERT ON `KT`.`Gender` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Gender', 'Type', SYSDATE(), NEW.Type);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalGender`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalGender` BEFORE UPDATE ON `KT`.`Gender` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Gender', 'Type', SYSDATE(), NEW.Type);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalPhoneNumber`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalPhoneNumber` BEFORE INSERT ON `KT`.`PhoneNumber` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'PhoneNumber', 'PhoneNumber', SYSDATE(), NEW.phonenumber);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalPhoneNumber`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalPhoneNumber` BEFORE UPDATE ON `KT`.`PhoneNumber` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'PhoneNumber', 'PhoneNumber', SYSDATE(), NEW.phonenumber);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalParameter`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalParameter` BEFORE INSERT ON `KT`.`Parameter` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Parameter', 'Value', SYSDATE(), NEW.Value);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Parameter', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalParameter`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalParameter` BEFORE UPDATE ON `KT`.`Parameter` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Parameter', 'Value', SYSDATE(), NEW.Value);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Parameter', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalUserType`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalUserType` BEFORE INSERT ON `KT`.`UserType` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserType', 'Description', SYSDATE(), NEW.Description);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalUserType`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalUserType` BEFORE UPDATE ON `KT`.`UserType` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserType', 'Description', SYSDATE(), NEW.Description);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalUserXPhone`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalUserXPhone` BEFORE INSERT ON `KT`.`UserXPhoneNumber` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXPhoneNumber', 'idUser', SYSDATE(), NEW.idUser);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXPhoneNumber', 'idPhoneNumber', SYSDATE(), NEW.idPhoneNumber);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalUserXPhone`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalUserXPhone` BEFORE UPDATE ON `KT`.`UserXPhoneNumber` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXPhoneNumber', 'idUser', SYSDATE(), NEW.idUser);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXPhoneNumber', 'idPhoneNumber', SYSDATE(), NEW.idPhoneNumber);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalFavorite`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalFavorite` BEFORE INSERT ON `KT`.`Favorite` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Favorite', 'idUser', SYSDATE(), NEW.idUser);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Favorite', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalFavorite`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalFavorite` BEFORE UPDATE ON `KT`.`Favorite` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Favorite', 'idUser', SYSDATE(), NEW.idUser);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Favorite', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalEmail`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalEmail` BEFORE INSERT ON `KT`.`Email` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Email', 'ElectronicMail', SYSDATE(), NEW.ElectronicMail);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Email', 'idUser', SYSDATE(), NEW.idUser);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalEmail`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalEmail` BEFORE UPDATE ON `KT`.`Email` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Email', 'ElectronicMail', SYSDATE(), NEW.ElectronicMail);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Email', 'idUser', SYSDATE(), NEW.idUser);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalUserXNat`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalUserXNat` BEFORE INSERT ON `KT`.`UserXNationality` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXNationality', 'idNationality', SYSDATE(), NEW.idNationality);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXNationality', 'idUser', SYSDATE(), NEW.idUser);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalUserXNat`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalUserXNat` BEFORE UPDATE ON `KT`.`UserXNationality` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXNationality', 'idNationality', SYSDATE(), NEW.idNationality);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'UserXNationality', 'idUser', SYSDATE(), NEW.idUser);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalPhoto`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalPhoto` BEFORE INSERT ON `KT`.`Photo` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Photo', 'Picture', SYSDATE(), NEW.Picture);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Photo', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalPhoto`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalPhoto` BEFORE UPDATE ON `KT`.`Photo` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Photo', 'Picture', SYSDATE(), NEW.Picture);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Photo', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalReservation`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalReservation` BEFORE INSERT ON `KT`.`Reservation` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idUser', SYSDATE(), NEW.idUser);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idPayment', SYSDATE(), NEW.idPayment);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idPenalty', SYSDATE(), NEW.idPenalty);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalReservation`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalReservation` BEFORE UPDATE ON `KT`.`Reservation` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idUser', SYSDATE(), NEW.idUser);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idPayment', SYSDATE(), NEW.idPayment);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Reservation', 'idPenalty', SYSDATE(), NEW.idPenalty);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalPenalty`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalPenalty` BEFORE INSERT ON `KT`.`Penalty` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Days', SYSDATE(), NEW.Days);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Time', SYSDATE(), NEW.Time);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Money', SYSDATE(), NEW.Money);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalPenalty`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalPenalty` BEFORE UPDATE ON `KT`.`Penalty` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Days', SYSDATE(), NEW.Days);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Time', SYSDATE(), NEW.Time);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Penalty', 'Money', SYSDATE(), NEW.Money);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalPayment`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalPayment` BEFORE INSERT ON `KT`.`PaymentMethod` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethod', 'NamePaymentMethod', SYSDATE(), NEW.NamePaymentMethod);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalPayment`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalPayment` BEFORE UPDATE ON `KT`.`PaymentMethod` FOR EACH ROW
BEGIN
		CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethod', 'NamePaymentMethod', SYSDATE(), NEW.NamePaymentMethod);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalDiscount`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalDiscount` BEFORE INSERT ON `KT`.`Discount` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'ExpireDate', SYSDATE(), NEW.ExpireDate);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'Code', SYSDATE(), NEW.Code);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'Percentage', SYSDATE(), NEW.Percentage);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalDiscount`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalDiscount` BEFORE UPDATE ON `KT`.`Discount` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'ExpireDate', SYSDATE(), NEW.ExpireDate);
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'Code', SYSDATE(), NEW.Code);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Discount', 'Percentage', SYSDATE(), NEW.Percentage);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalRoomCategory`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalRoomCategory` BEFORE INSERT ON `KT`.`RoomCategory` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'RoomCategory', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalRoomCategory`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalRoomCategory` BEFORE UPDATE ON `KT`.`RoomCategory` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'RoomCategory', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalAmenity`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalAmenity` BEFORE INSERT ON `KT`.`Amenity` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Amenity', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Amenity', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalAmenity`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalAmenity` BEFORE UPDATE ON `KT`.`Amenity` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Amenity', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Amenity', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalHotelClasification`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalHotelClasification` BEFORE INSERT ON `KT`.`HotelClasification` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'HotelClasification', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalHotelClasification`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalHotelClasification` BEFORE UPDATE ON `KT`.`HotelClasification` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'HotelClasification', 'Name', SYSDATE(), NEW.Name);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalHotel`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalHotel` BEFORE INSERT ON `KT`.`Hotel` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'RegisterDate', SYSDATE(), NEW.RegisterDate);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idDistrict', SYSDATE(), NEW.idDistrict);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idClasification', SYSDATE(), NEW.idClasification);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idDiscount', SYSDATE(), NEW.idDiscount);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalHotel`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalHotel` BEFORE UPDATE ON `KT`.`Hotel` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'RegisterDate', SYSDATE(), NEW.RegisterDate);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idDistrict', SYSDATE(), NEW.idDistrict);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idClasification', SYSDATE(), NEW.idClasification);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Hotel', 'idDiscount', SYSDATE(), NEW.idDiscount);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalRoom` BEFORE INSERT ON `KT`.`Room` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'Capacity', SYSDATE(), NEW.Capacity);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'RecommendedPrice', SYSDATE(), NEW.RecommendedPrice);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'idHotel', SYSDATE(), NEW.idHotel);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'idRoomCategory', SYSDATE(), NEW.idRoomCategory);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalRoom` BEFORE UPDATE ON `KT`.`Room` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'Name', SYSDATE(), NEW.Name);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'Capacity', SYSDATE(), NEW.Capacity);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'RecommendedPrice', SYSDATE(), NEW.RecommendedPrice);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'idHotel', SYSDATE(), NEW.idHotel);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Room', 'idRoomCategory', SYSDATE(), NEW.idRoomCategory);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalAmenityXRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalAmenityXRoom` BEFORE INSERT ON `KT`.`AmenityXRoom` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'AmenityXRoom', 'idAmenity', SYSDATE(), NEW.idAmenity);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'AmenityXRoom', 'idRoom', SYSDATE(), NEW.idRoom);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalAmenityXRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalAmenityXRoom` BEFORE UPDATE ON `KT`.`AmenityXRoom` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'AmenityXRoom', 'idAmenity', SYSDATE(), NEW.idAmenity);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'AmenityXRoom', 'idRoom', SYSDATE(), NEW.idRoom);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalPayMetXHotel`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalPayMetXHotel` BEFORE INSERT ON `KT`.`PaymentMethodXHotel` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethodXHotel', 'idPaymentMethod', SYSDATE(), NEW.idPaymentMethod);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethodXHotel', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalPayMetXHotel`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalPayMetXHotel` BEFORE UPDATE ON `KT`.`PaymentMethodXHotel` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethodXHotel', 'idPaymentMethod', SYSDATE(), NEW.idPaymentMethod);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'PaymentMethodXHotel', 'idHotel', SYSDATE(), NEW.idHotel);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalFeedback`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalFeedback` BEFORE INSERT ON `KT`.`Feedback` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Feedback', 'Commment', SYSDATE(), NEW.Commment);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Feedback', 'idReservation', SYSDATE(), NEW.idReservation);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalFeedback`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalFeedback` BEFORE UPDATE ON `KT`.`Feedback` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Feedback', 'Commment', SYSDATE(), NEW.Commment);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Feedback', 'idReservation', SYSDATE(), NEW.idReservation);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalReview`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalReview` BEFORE INSERT ON `KT`.`Review` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Review', 'Star', SYSDATE(), NEW.Star);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Review', 'idReservation', SYSDATE(), NEW.idReservation);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalReview`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalReview` BEFORE UPDATE ON `KT`.`Review` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'Review', 'Star', SYSDATE(), NEW.Star);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'Review', 'idReservation', SYSDATE(), NEW.idReservation);
END;
//
DELIMITER ;


DROP TRIGGER IF EXISTS `KT`.`beforeInsertJournalReservXRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeInsertJournalReservXRoom` BEFORE INSERT ON `KT`.`ReservationXRoom` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'AdminPrice', SYSDATE(), NEW.AdminPrice);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'CheckIn', SYSDATE(), NEW.CheckIn);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'CheckOut', SYSDATE(), NEW.CheckOut);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idReservation', SYSDATE(), NEW.idReservation);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idRoom', SYSDATE(), NEW.idRoom);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idDiscount', SYSDATE(), NEW.idDiscount);
END;
//
DELIMITER ;

DROP TRIGGER IF EXISTS `KT`.`beforeUpdateJournalReservXRoom`; 
DELIMITER //
CREATE TRIGGER `KT`.`beforeUpdateJournalReservXRoom` BEFORE UPDATE ON `KT`.`ReservationXRoom` FOR EACH ROW
BEGIN
	CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'AdminPrice', SYSDATE(), NEW.AdminPrice);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'CheckIn', SYSDATE(), NEW.CheckIn);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'CheckOut', SYSDATE(), NEW.CheckOut);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idReservation', SYSDATE(), NEW.idReservation);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idRoom', SYSDATE(), NEW.idRoom);
    CALL `kt`.`INSERT_JOURNAL`('KT', 'ReservationXRoom', 'idDiscount', SYSDATE(), NEW.idDiscount);
END;
//
DELIMITER ;