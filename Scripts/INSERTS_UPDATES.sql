-- Inserts with exceptions

DROP PROCEDURE IF EXISTS `KT`.`INSERT_AMENITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_AMENITY`(IN p_Name VARCHAR(4000), IN p_IdHotel INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Amenity(Name, idHotel) VALUES (p_Name, p_IdHotel);
        COMMIT;
	END IF;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_AMENITYXROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_AMENITYXROOM` (IN p_idAmenity INT, IN p_idRoom INT)
BEGIN
	INSERT INTO AmenityXRoom (idAmenity, idRoom) VALUES (p_idAmenity, p_idRoom);
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_CANTON`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_CANTON` (IN p_name VARCHAR(4000), IN p_idState INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Canton(Name, idState) VALUES (p_Name, p_idState);
		COMMIT;
	END IF;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_COUNTRY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_COUNTRY` (IN p_name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Country(Name) VALUES(p_name);
		COMMIT;
	END IF;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_DISCOUNT`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_DISCOUNT` (IN p_ExpireDate DATETIME, IN p_Code VARCHAR(4000), IN p_Percentage INT)
BEGIN
  INSERT INTO Discount (ExpireDate, Code, Percentage) VALUES (p_ExpireDate, p_Code, p_Percentage);
  COMMIT;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_DISTRICT`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_DISTRICT` (IN p_name VARCHAR(4000), IN p_idCanton INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO District(Name, idCanton) VALUES(p_name, p_idCanton);
		COMMIT;
	END IF;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_EMAIL`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_EMAIL` (IN p_ElectronicMail VARCHAR(4000), IN p_idUser DOUBLE)
BEGIN
	IF p_ElectronicMail NOT LIKE '%@%' THEN
		SIGNAL SQLSTATE '10002'
        SET MESSAGE_TEXT = 'Wrong email format';
	ELSE
		INSERT INTO Email(ElectronicMail, idUser) VALUES(p_ElectronicMail, p_idUser);
		COMMIT;
	END IF;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_FAVORITE`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_FAVORITE` (IN p_idUser INT, IN p_idHotel INT)
BEGIN
	INSERT INTO Favorite(idUser, idHotel) VALUES (p_idUser, p_idHotel);
	COMMIT;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_FEEDBACK`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_FEEDBACK` (IN p_comment VARCHAR(4000), IN p_idReservation INT)
BEGIN
	INSERT INTO Feedback(commment, idReservation) VALUES (p_comment, p_idReservation);
	COMMIT;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS `KT`.`INSERT_GENDER`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_GENDER` (IN p_TypeGender VARCHAR(4000))
BEGIN
	IF p_TypeGender LIKE '%0%' OR p_TypeGender LIKE '%1%' OR p_TypeGender LIKE '%2%' OR p_TypeGender LIKE '%3%' OR p_TypeGender LIKE '%4%'
    OR p_TypeGender LIKE '%5%' OR p_TypeGender LIKE '%6%' OR p_TypeGender LIKE '%7%' OR p_TypeGender LIKE '%8%' OR p_TypeGender LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Type contains integer characters';
	ELSE
		INSERT INTO Gender(Type) VALUES (p_TypeGender);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_HOTEL`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_HOTEL` (IN p_Name VARCHAR(4000), IN p_RegisterDate DATETIME, IN p_idDistrict INT, IN p_idClasification INT, IN p_idDiscount INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Hotel(Name, RegisterDate, idDistrict, idClasification, idDiscount) VALUES (p_Name, p_RegisterDate, p_idDistrict, p_idClasification, p_idDiscount);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_HOTELCLASIFICATION`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_HOTELCLASIFICATION` (IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO HotelClasification(Name) VALUES (p_Name);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_IDTYPE`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_IDTYPE` (IN p_Mask VARCHAR(4000), IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO IDType(Mask, name) VALUES(p_Mask, p_Name);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PARAMETER`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PARAMETER` (IN p_name VARCHAR(4000), IN p_value INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Parameter(name, value) VALUES (p_name, p_value);
        COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PAYMENTMETHOD`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PAYMENTMETHOD` (IN p_namePaymentMethod VARCHAR(4000))
BEGIN
	IF p_namePaymentMethod LIKE '%0%' OR p_namePaymentMethod LIKE '%1%' OR p_namePaymentMethod LIKE '%2%' OR p_namePaymentMethod LIKE '%3%' OR p_namePaymentMethod LIKE '%4%'
    OR p_namePaymentMethod LIKE '%5%' OR p_namePaymentMethod LIKE '%6%' OR p_namePaymentMethod LIKE '%7%' OR p_namePaymentMethod LIKE '%8%' OR p_namePaymentMethod LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO PaymentMethod(namePaymentMethod) VALUES (p_namePaymentMethod);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PAYMENTMETHODXHOTEL`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PAYMENTMETHODXHOTEL` (IN p_idPaymentMethod INT, IN p_idHotel INT)
BEGIN
	INSERT INTO PaymentMethodXHotel (idPaymentMethod, idHotel) VALUES (p_idPaymentMethod, p_idHotel);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_NATIONALITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_NATIONALITY` (IN p_name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Nationality (name) VALUES (p_name);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PENALTY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PENALTY` (IN p_days VARCHAR(4000), IN p_time INT, IN p_money INT)
BEGIN
	INSERT INTO Penalty(days, time, money) VALUES (p_days , p_time , p_money);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PHONENUMBER`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PHONENUMBER` (IN p_PhoneNumber BIGINT)
BEGIN
	INSERT INTO PhoneNumber (PhoneNumber) VALUES (p_PhoneNumber);
	COMMIT; 
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_PHOTO`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_PHOTO` (IN p_picture VARCHAR(4000), IN p_idHotel INT)
BEGIN
	INSERT INTO Photo(picture, idHotel) VALUES (p_picture, p_idHotel );
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_RESERVATION`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_RESERVATION` (IN p_idUser INT, IN p_idPayment INT, IN p_idPenalty INT)
BEGIN
	INSERT INTO Reservation(idUser, idPayment, idPenalty) VALUES (p_idUser, p_idPayment, p_idPenalty);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_RESERVATIONXROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_RESERVATIONXROOM` (IN p_AdminPrice DECIMAL(10,2), IN p_CheckIn DATETIME, IN p_CheckOut DATETIME, IN p_idReservation DOUBLE, IN p_idRoom DOUBLE, IN p_idDiscount DOUBLE)
BEGIN
	INSERT INTO ReservationXRoom(AdminPrice, CheckIn, CheckOut, idReservation, idRoom, idDiscount) VALUES (p_AdminPrice, p_CheckIn, p_CheckOut, p_idReservation, p_idRoom, p_idDiscount);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_REVIEW`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_REVIEW` (IN p_Star INT, IN p_idReservation INT)
BEGIN
	INSERT INTO Review(Star, idReservation) VALUES (p_Star, p_idReservation);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_ROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_ROOM` (IN p_Name VARCHAR(4000), IN p_Capacity INT, IN p_RecommendedPrice DECIMAL(10,2), IN p_IdHotel INT, IN p_idRoomCategory INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Room(Name, Capacity, RecommendedPrice, IdHotel, idRoomCategory) VALUES (p_Name, p_Capacity, p_RecommendedPrice, p_IdHotel, p_idRoomCategory);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_ROOMCATEGORY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_ROOMCATEGORY` (IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO RoomCategory(name) VALUES (p_Name);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_STATE`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_STATE` (IN p_Name VARCHAR(4000), IN p_idCountry INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO State(Name, idCountry) VALUES(p_Name, p_idCountry);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_USER`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_USER` (IN p_Photo VARCHAR(4000), IN p_IdentificationCard VARCHAR(4000),  IN p_FirstName VARCHAR(4000), IN p_MiddleName VARCHAR(4000), IN p_LastName VARCHAR(4000),
									 IN p_SecondSurname VARCHAR(4000), IN p_Username VARCHAR(4000), IN p_Password VARCHAR(4000), IN p_BirthDate DATETIME, IN p_idDistrict INT, IN p_idType INT,
									 IN p_idGender INT, IN p_idUserType INT, IN p_idHotelAdmin INT)
BEGIN
	IF ((p_FirstName LIKE '%0%' OR p_FirstName LIKE '%1%' OR p_FirstName LIKE '%2%' OR p_FirstName LIKE '%3%' OR p_FirstName LIKE '%4%' OR p_FirstName LIKE '%5%' OR p_FirstName LIKE '%6%' OR p_FirstName LIKE '%7%' OR p_FirstName LIKE '%8%' OR p_FirstName LIKE '%9%') OR 
		(p_MiddleName LIKE '%0%' OR p_MiddleName LIKE '%1%' OR p_MiddleName LIKE '%2%' OR p_MiddleName LIKE '%3%' OR p_MiddleName LIKE '%4%' OR p_MiddleName LIKE '%5%' OR p_MiddleName LIKE '%6%' OR p_MiddleName LIKE '%7%' OR p_MiddleName LIKE '%8%' OR p_MiddleName LIKE '%9%') OR
        (p_LastName LIKE '%0%' OR p_LastName LIKE '%1%' OR p_LastName LIKE '%2%' OR p_LastName LIKE '%3%' OR p_LastName LIKE '%4%' OR p_LastName LIKE '%5%' OR p_LastName LIKE '%6%' OR p_LastName LIKE '%7%' OR p_LastName LIKE '%8%' OR p_LastName LIKE '%9%') OR
        (p_SecondSurname LIKE '%0%' OR p_SecondSurname LIKE '%1%' OR p_SecondSurname LIKE '%2%' OR p_SecondSurname LIKE '%3%' OR p_SecondSurname LIKE '%4%' OR p_SecondSurname LIKE '%5%' OR p_SecondSurname LIKE '%6%' OR p_SecondSurname LIKE '%7%' OR p_SecondSurname LIKE '%8%' OR p_SecondSurname LIKE '%9%'))
    THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		INSERT INTO Users(photo, identificationcard, firstname, middlename,lastname,
						secondsurname, username, password, birthdate,
						iddistrict, idtype, idgender, idusertype, idhoteladmin)
		VALUES (p_Photo, p_IdentificationCard, p_FirstName, p_MiddleName,
				p_LastName, p_SecondSurname, p_Username, p_Password, p_BirthDate,p_idDistrict,
				p_idType,p_idGender, p_idUserType, p_idHotelAdmin);
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_USERTYPE`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_USERTYPE` (IN p_description VARCHAR(4000))
BEGIN
	INSERT INTO UserType(description) VALUES (p_description);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_USERXNATIONALITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_USERXNATIONALITY` (IN p_idUser INT, IN p_idNationality INT)
BEGIN
	INSERT INTO UserXNationality(idUser, idNationality) VALUES(p_idUser, p_idNationality);
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`INSERT_USERXPHONENUMBER`;
DELIMITER //
CREATE PROCEDURE `KT`.`INSERT_USERXPHONENUMBER` (IN p_idUser INT, IN p_idPhoneNumber INT)
BEGIN
	INSERT INTO UserXPhoneNumber(idUser, idPhoneNumber) VALUES( p_idUser, p_idPhoneNumber);
	COMMIT;
END;
//
DELIMITER ;

-- Updates with exceptions
DROP PROCEDURE IF EXISTS `KT`.`UPDATE_AMENITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_AMENITY` (IN p_idAmenity INT, IN p_Name VARCHAR(4000), IN p_IdHotel INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Amenity
		SET name = p_Name, idHotel = p_IdHotel
		WHERE idAmenity = p_idAmenity;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_AMENITYXROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_AMENITYXROOM` (IN p_idAmenityXRoom INT, IN p_idAmenity INT, IN p_idRoom INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE AmenityXRoom
		SET idAmenity = p_idAmenity, idRoom = p_idRoom
		WHERE idAmenityXRoom = p_idAmenityXRoom;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_CANTON`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_CANTON` (IN p_idCanton INT, IN p_Name VARCHAR(4000), IN p_idState INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Canton
		SET Name = p_Name, idState = p_idState
		WHERE idCanton = p_idCanton;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_COUNTRY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_COUNTRY` (IN p_idCountry INT, IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Country
		SET Name = p_name
		WHERE Idcountry = p_idCountry;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_DISCOUNT`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_DISCOUNT` (IN p_idDiscount INT, IN p_ExpireDate DATETIME, IN p_Code VARCHAR(4000), IN p_Percentage INT)
BEGIN 
	UPDATE Discount
	SET ExpireDate = p_ExpireDate, Code = p_Code, Percentage = p_Percentage
	WHERE  idDiscount = p_idDiscount;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_DISTRICT`;

DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_DISTRICT` (IN p_idDistrict INT, IN p_Name VARCHAR(4000), IN p_idCanton INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE District
		SET Name = p_Name, idCanton = p_idCanton
		WHERE idDistrict = p_idDistrict;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_EMAIL`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_EMAIL` (IN p_idEmail INT, IN p_ElectronicMail VARCHAR(4000), IN p_idUser INT)
BEGIN
	IF p_ElectronicMail NOT LIKE '%@%' THEN
		SIGNAL SQLSTATE '10002'
        SET MESSAGE_TEXT = 'Wrong email format';
	ELSE
		UPDATE Email
		SET ElectronicMail = p_ElectronicMail, idUser = p_idUser
		WHERE idEmail = p_idEmail;
		COMMIT;
	END IF;

END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_FAVORITE`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_FAVORITE` (IN p_idFavorite INT, IN p_idUser INT, IN p_idHotel INT)
BEGIN
	UPDATE Favorite
	SET idUser = p_idUser, idHotel = p_idHotel
	WHERE idFavorite = p_idFavorite;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_FEEDBACK`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_FEEDBACK` (IN p_idFeedback INT, IN p_comment VARCHAR(4000), IN p_idReservation INT)
BEGIN
	UPDATE Feedback
	SET commment = p_comment, idReservation = p_idReservation       
	WHERE idFeedback = p_idFeedback;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_GENDER`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_GENDER` (IN p_idGender INT, IN p_TypeGender INT)
BEGIN
	IF p_TypeGender LIKE '%0%' OR p_TypeGender LIKE '%1%' OR p_TypeGender LIKE '%2%' OR p_TypeGender LIKE '%3%' OR p_TypeGender LIKE '%4%'
    OR p_TypeGender LIKE '%5%' OR p_TypeGender LIKE '%6%' OR p_TypeGender LIKE '%7%' OR p_TypeGender LIKE '%8%' OR p_TypeGender LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Type contains integer characters';
	ELSE
		UPDATE Gender
		SET Type = p_TypeGender
		WHERE idGender = p_idGender;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_HOTEL`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_HOTEL` (IN p_idHotel INT, IN p_Name VARCHAR(4000), IN p_RegisterDate DATETIME, IN p_idDistrict INT, IN p_idClasification INT, IN p_idDiscount INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Hotel
		SET Name = p_Name, RegisterDate = p_RegisterDate, idDistrict = p_idDistrict, idClasification = p_idClasification, idDiscount = p_idDiscount
		WHERE idHotel = p_idHotel;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_HOTELCLASIFICATION`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_HOTELCLASIFICATION` (IN p_idHotelClasification INT, IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE HotelClasification
		SET Name = p_Name
		WHERE idHotelClasification = p_idHotelClasification;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_IDTYPE`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_IDTYPE` (IN p_idIDType INT, IN p_Mask VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE IDType
		SET Mask = p_Mask
		WHERE ididType = p_idIDType;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_NATIONALITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_NATIONALITY` (IN p_idNationality INT, IN p_name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Nationality
		SET name = p_name
		WHERE idNationality = p_idNationality;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PARAMETER`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PARAMETER` (IN p_idParameter INT, IN p_name VARCHAR(4000), IN p_value INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Parameter 
		SET name = p_name, value = p_value        
		WHERE idParameter = p_idParameter;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PAYMENTMETHOD`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PAYMENTMETHOD` (IN p_idPaymentMethod INT, IN p_namePaymentMethod VARCHAR(4000))
BEGIN
	IF p_namePaymentMethod LIKE '%0%' OR p_namePaymentMethod LIKE '%1%' OR p_namePaymentMethod LIKE '%2%' OR p_namePaymentMethod LIKE '%3%' OR p_namePaymentMethod LIKE '%4%'
    OR p_namePaymentMethod LIKE '%5%' OR p_namePaymentMethod LIKE '%6%' OR p_namePaymentMethod LIKE '%7%' OR p_namePaymentMethod LIKE '%8%' OR p_namePaymentMethod LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE PaymentMethod
		SET namePaymentMethod = p_namePaymentMethod       
		WHERE idPaymentMethod = p_idPaymentMethod;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PAYMENTMETHODXHOTEL`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PAYMENTMETHODXHOTEL` (IN p_idPaymentMethodXHotel INT, IN p_idPaymentMethod INT, IN p_idHotel INT)
BEGIN
	UPDATE PaymentMethodXHotel
	SET idPaymentMethod = p_idPaymentMethod, idHotel = p_idHotel
	WHERE idPaymentMethodXHotel = p_idPaymentMethodXHotel;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PENALTY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PENALTY` (IN p_idPenalty INT, IN p_days VARCHAR(4000), IN p_time INT, IN p_money INT)
BEGIN
	UPDATE Penalty
	SET days = p_days, time  = p_time, money = p_money        
	WHERE idPenalty = p_idPenalty;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PHONENUMBER`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PHONENUMBER` (IN p_idPhoneNumber INT,IN p_PhoneNumber BIGINT)
BEGIN
	UPDATE PhoneNumber
	SET PhoneNumber = p_PhoneNumber 
	WHERE idPhoneNumber = p_idPhoneNumber;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_PHOTO`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_PHOTO` (IN p_idPhoto INT, IN p_picture VARCHAR(4000), IN p_idHotel INT)
BEGIN
	UPDATE Photo 
	SET picture = p_picture, idHotel  = p_idHotel 
	WHERE idPhoto = p_idPhoto;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_RESERVATION`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_RESERVATION` (IN p_idReservation INT, IN p_idUser INT, IN p_idPayment INT, IN p_idPenalty INT)
BEGIN
	UPDATE Reservation
	SET idUser = p_idUser, idPayment = p_idPayment, idPenalty = p_idPenalty         
	WHERE idReservation = p_idReservation;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_RESERVATIONXROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_RESERVATIONXROOM` (IN p_idReservationXRoom INT, IN p_AdminPrice INT, IN p_CheckIn DATETIME, IN p_CheckOut DATETIME, IN p_idReservation INT, IN p_idRoom INT, IN p_idDiscount INT)
BEGIN
	UPDATE ReservationXRoom
	SET AdminPrice = p_AdminPrice, CheckIn = p_CheckIn, CheckOut = p_CheckOut, idReservation = p_idReservation, idRoom = p_idRoom, idDiscount = p_idDiscount
	WHERE idReservationXRoom = p_idReservationXRoom;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_REVIEW`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_REVIEW` (IN p_idReview INT, IN p_Star INT, IN p_idReservation INT)
BEGIN
	UPDATE Review
	SET Star = p_Star, idReservation = p_idReservation
	WHERE idReview = p_idReview;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_ROOM`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_ROOM` (IN p_idRoom INT, IN p_Name VARCHAR(4000), IN p_Capacity INT, IN p_RecommendedPrice INT, IN p_IdHotel INT, IN p_idRoomCategory INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Room
		SET Name = p_Name, Capacity = p_Capacity, RecommendedPrice = p_RecommendedPrice, IdHotel = p_IdHotel, idRoomCategory = p_idRoomCategory
		WHERE idRoom = p_idRoom;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_ROOMCATEGORY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_ROOMCATEGORY` (IN p_idRoomCategory INT, IN p_Name VARCHAR(4000))
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE RoomCategory
		SET name = p_Name
		WHERE idRoomCategory = p_idRoomCategory;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_STATE`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_STATE` (IN p_idState INT, IN p_Name VARCHAR(4000), IN p_idCountry INT)
BEGIN
	IF p_name LIKE '%0%' OR p_name LIKE '%1%' OR p_name LIKE '%2%' OR p_name LIKE '%3%' OR p_name LIKE '%4%'
    OR p_name LIKE '%5%' OR p_name LIKE '%6%' OR p_name LIKE '%7%' OR p_name LIKE '%8%' OR p_name LIKE '%9%' THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE State
		SET Name = p_Name, idCountry = p_idCountry
		WHERE idState = p_idState;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_USER`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_USER` (IN p_idUser INT, IN p_Photo INT, IN p_IdentificationCard VARCHAR(4000), IN p_FirstName VARCHAR(4000), IN p_MiddleName VARCHAR(4000), IN p_LastName VARCHAR(4000),
IN p_SecondSurname VARCHAR(4000), IN p_Username VARCHAR(4000), IN p_Password VARCHAR(4000), IN p_BirthDate DATETIME, IN p_idDistrict INT, IN p_idType INT, IN p_idGender INT, IN p_idUserType INT, IN p_idHotelAdmin INT)
BEGIN
	IF ((p_FirstName LIKE '%0%' OR p_FirstName LIKE '%1%' OR p_FirstName LIKE '%2%' OR p_FirstName LIKE '%3%' OR p_FirstName LIKE '%4%' OR p_FirstName LIKE '%5%' OR p_FirstName LIKE '%6%' OR p_FirstName LIKE '%7%' OR p_FirstName LIKE '%8%' OR p_FirstName LIKE '%9%') OR 
		(p_MiddleName LIKE '%0%' OR p_MiddleName LIKE '%1%' OR p_MiddleName LIKE '%2%' OR p_MiddleName LIKE '%3%' OR p_MiddleName LIKE '%4%' OR p_MiddleName LIKE '%5%' OR p_MiddleName LIKE '%6%' OR p_MiddleName LIKE '%7%' OR p_MiddleName LIKE '%8%' OR p_MiddleName LIKE '%9%') OR
        (p_LastName LIKE '%0%' OR p_LastName LIKE '%1%' OR p_LastName LIKE '%2%' OR p_LastName LIKE '%3%' OR p_LastName LIKE '%4%' OR p_LastName LIKE '%5%' OR p_LastName LIKE '%6%' OR p_LastName LIKE '%7%' OR p_LastName LIKE '%8%' OR p_LastName LIKE '%9%') OR
        (p_SecondSurname LIKE '%0%' OR p_SecondSurname LIKE '%1%' OR p_SecondSurname LIKE '%2%' OR p_SecondSurname LIKE '%3%' OR p_SecondSurname LIKE '%4%' OR p_SecondSurname LIKE '%5%' OR p_SecondSurname LIKE '%6%' OR p_SecondSurname LIKE '%7%' OR p_SecondSurname LIKE '%8%' OR p_SecondSurname LIKE '%9%'))
    THEN
		SIGNAL SQLSTATE '10001'
        SET MESSAGE_TEXT = 'Name contains integer characters';
	ELSE
		UPDATE Users
		SET iduser = p_idUser, photo = p_Photo, identificationcard = p_IdentificationCard, firstname = p_FirstName,
		middlename = p_MiddleName, lastname = p_LastName, secondsurname = p_SecondSurname,
		username = p_Username , password = p_Password, birthdate = p_BirthDate, iddistrict = p_idDistrict, idtype = p_idType,
		idgender = p_idGender, idusertype = p_idUserType, idhoteladmin = p_idHotelAdmin
		WHERE idUser = p_idUser;
		COMMIT;
	END IF;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_USERTYPE`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_USERTYPE` (IN p_idUserType INT, IN p_description VARCHAR(4000)) 
BEGIN
	UPDATE UserType
	SET description = p_description       
	WHERE idUserType = p_idUserType;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_USERXNATIONALITY`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_USERXNATIONALITY` (IN p_idUserxNationality INT, IN p_idUser INT, IN p_idNationality INT)
BEGIN
	UPDATE UserXNationality
	SET idUser = p_idUser, idNationality = p_idNationality
	WHERE idUserxNationality = p_idUserxNationality;
	COMMIT;
END;
//
DELIMITER ;


DROP PROCEDURE IF EXISTS `KT`.`UPDATE_USERXPHONENUMBER`;
DELIMITER //
CREATE PROCEDURE `KT`.`UPDATE_USERXPHONENUMBER` (IN p_idUserXPhoneNumber INT, IN p_idUser INT, IN p_idPhoneNumber INT)
BEGIN
	UPDATE UserXPhoneNumber
	SET idUser = p_idUser, idPhoneNumber = p_idPhoneNumber
	WHERE idUserXPhoneNumber = p_idUserXPhoneNumber;
	COMMIT;
END;
//
DELIMITER ;