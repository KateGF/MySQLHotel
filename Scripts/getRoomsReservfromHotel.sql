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