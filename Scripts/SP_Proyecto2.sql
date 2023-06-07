--Delete Amenity 

select 
reservation.IDUSER ,
users.IDENTIFICATIONCARD,
reservationxroom2.CHECKIN,
reservationxroom2.CHECKOUT,
room.name,
reservationxroom2.AdminPrice

from reservationxroom2
inner join reservation on reservation.IDreservation = reservationxroom2.IDreservation
inner join users on reservation.IDUSER = users.IDUSER
inner join room on reservationxroom2.idroom = room.idroom
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `Delete_AmenityHotel`(p_idAmenity int,p_idHotel int)
delete  from amenityxhotel where 
IDamenity = p_idAmenity and idHotel = p_idHotel$$
DELIMITER ;

--Edit Canton

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `editCanton`(
P_NAME varchar(35),
P_IDCanton int,
P_CREATIONUSERS varchar(10)
)
UPDATE `ale`.`canton`
SET
`NAME` = P_NAME,
`MODDATE` = current_timestamp(),
`MODUSER` = P_CREATIONUSERS
WHERE `IDCanton` = P_IDCanton$$
DELIMITER ;


--Edit country

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `editCountry`(
P_NAME varchar(35),
P_IDCountry int,
P_CREATIONUSERS varchar(10)
)
UPDATE `ale`.`country`
SET
`NAME` = P_NAME,
`MODDATE` = current_timestamp(),
`MODUSER` = P_CREATIONUSERS
WHERE `IDCOUNTRY` = P_IDCountry$$
DELIMITER ;

--Edit district

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `editDistrict`(
P_NAME varchar(35),
P_IDDistrict int,
P_CREATIONUSERS varchar(10)
)
UPDATE `ale`.`district`
SET
`NAME` = P_NAME,
`MODDATE` = current_timestamp(),
`MODUSER` = P_CREATIONUSERS
WHERE `IDDistrict` = P_IDDistrict$$
DELIMITER ;



--editState


DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `editState`(
P_NAME varchar(35),
P_IDState int,
P_CREATIONUSERS varchar(10)
)
UPDATE `ale`.`state`
SET
`NAME` = P_NAME,
`MODDATE` = current_timestamp(),
`MODUSER` = P_CREATIONUSERS
WHERE `IDState` = P_IDState$$
DELIMITER ;


--getAllAmenities


DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getAllAmenities`()
select idAmenity,name  from amenity$$
DELIMITER ;


--getAmenitiesByHotel

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getAmenitiesByHotel`(p_idHotel int)
select * from amenityxhotelview where IDhotel = p_idHotel$$
DELIMITER ;



--getCantonbyState
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getCantonsByState`(IN p_stateID INT)
select * from Canton where idState = p_stateID$$
DELIMITER ;


--GetCategories

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `GetCategories`()
SELECT *  FROM roomcategory$$
DELIMITER ;


--GetCountries
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getCountries`()
select * from country$$
DELIMITER ;

--GetDiscounts

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getDiscounts`()
select * from discount$$
DELIMITER ;



--getDiscountsHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getDiscountsHotel`(IN p_idHotel VARCHAR(255))
select * from  discountHotel WHERE idHotel = p_idHotel$$
DELIMITER ;


--getDiscounts total by hotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getDiscountTotalByHotel`(IN p_idHotel VARCHAR(255))
BEGIN
    -- Select the desired users based on the provided username
    SELECT *
    FROM discountHotelView
    WHERE idHotel = p_idHotel;
END$$
DELIMITER ;

--getDisctrictByCanton
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getDistrictsByCanton`(IN p_cantonID INT)
select * from District where idCanton = p_cantonID$$
DELIMITER ;



--getHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `GetHotels`()
SELECT *  FROM viewHotelInfo$$
DELIMITER ;



--getHotelsByDistricts

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getHotelsByDistrict`(p_district int)
select * from viewhotelinfo where IDDISTRICT = p_district$$
DELIMITER ;


--getPayments
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getPayments`(IN p_idHotel VARCHAR(255))
BEGIN
    -- Select the desired users based on the provided username
    SELECT *
    FROM paymentxhotelview
    WHERE idHotel = p_idHotel;
END$$
DELIMITER ;

--getPaymentsByHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getPaymentsByHotel`(IN p_idHotel VARCHAR(255))
BEGIN
    -- Select the desired users based on the provided username
    SELECT *
    FROM paymentxhotelview
    WHERE idHotel = p_idHotel;
END$$
DELIMITER ;

--getReservationsFromHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getReservationsFromHotel`(p_idHotel int)
select * from viewreservation where IDhotel = p_idHotel$$
DELIMITER ;

--getReviewsHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getReviewsHotel`(p_idHotel int)
select *  from viewreviewshotel where 
idHotel = p_idHotel$$
DELIMITER ;

--getRoomfromHotel
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getRoomFromHotel`(p_idHotel int)
select * from viewroomshotel where IDhotel = p_idHotel$$
DELIMITER ;

--getstateBycountry
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getStateByCountry`(IN p_countryID INT)
select * from STATE where idCountry = p_countryID$$
DELIMITER ;


--getUsersCurs
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getUsersCurs`(IN p_username VARCHAR(255))
BEGIN
    -- Select the desired users based on the provided username
    SELECT *
    FROM users
    WHERE username = p_username;
END$$
DELIMITER ;

--getReservationFromHotel

DROP VIEW IF EXISTS viewRoomReservHotel;
DELIMITER //
CREATE VIEW viewRoomReservHotel AS
	SELECT 
    Hotel.Name,
    countRooms(Hotel.idHotel),
    countReservations(Hotel.idHotel)
    FROM Hotel;
//
DELIMITER ;

DROP FUNCTION IF EXISTS countRooms;
DELIMITER //
CREATE FUNCTION countRooms(p_idHotel INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE numberOfRooms INT;
	SELECT COUNT(idRoom)
    FROM Room
    INNER JOIN Hotel ON Room.idHotel = Hotel.idHotel
    WHERE p_idHotel = Hotel.idHotel
    INTO numberOfRooms;
    RETURN numberOfRooms;
END;
//
DELIMITER ;

DROP FUNCTION IF EXISTS countReservations;
DELIMITER //
CREATE FUNCTION countReservations(p_idHotel INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
	DECLARE numberOfReserv INT;
	SELECT COUNT(idReservationXRoom)
    FROM ReservationXRoom
    INNER JOIN Room ON ReservationXRoom.idRoom = Room.idRoom
    INNER JOIN Hotel ON Room.idHotel = Hotel.idHotel
    WHERE p_idHotel = Hotel.idHotel
    INTO numberOfReserv;
    RETURN numberOfReserv;
END;
//
DELIMITER ;

DROP PROCEDURE IF EXISTS getRoomsReservfromHotel;

DELIMITER //
CREATE PROCEDURE getRoomsReservfromHotel()
	SELECT * FROM viewRoomReservHotel;
//
DELIMITER ;

--getNRommMoreReserv()
create procedure getNRommMoreReserv()
select room.IDroom,count(*) count , sum( reservationxroom2.adminprice) as sum from reservationxroom2
inner join room
on room.IDroom = reservationxroom2.IDROOM
group by room.IDroom
order by count desc

--HotelsTotal
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `getRoomsReservfromHotelAll`()
SELECT * FROM viewRoomReservHotel$$
DELIMITER ;

--Statistics by age range and gender
DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `userByAgeGender`(age1 int, age2 int, gender varchar(32))
select count(*) as totalUsers from usersAgeView
 where age between age1 and age2
 and type = gender$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`katy`@`localhost` PROCEDURE `userByAgeRange`(age1 int, age2 int)
select * from usersAgeView
 where age between age1 and age2$$
DELIMITER ;






