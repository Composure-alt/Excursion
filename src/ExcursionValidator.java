

// Проверка полей на пустоту

import java.time.LocalDate;
import java.util.List;

public class ExcursionValidator {

    public static void validateHotel(String hotel) {
        if (hotel == null || hotel.isEmpty()) {
            throw new IllegalArgumentException("Название отеля не может быть пустым!");
        }
    }

    public static void validateHotelRoom(String hotelRoom) {
        if (hotelRoom == null) {
            throw new IllegalArgumentException("Номер отеля не может быть пустым!");
        }
    }

    public static void validateRideTickets(String rideTickets) {
        if (rideTickets == null) {
            throw new IllegalArgumentException("Билеты на аттракцион не могут быть пустым!");
        }
    }

    public static void validateRestaurantReservation(String restaurantReservation) {
        if (restaurantReservation == null) {
            throw new IllegalArgumentException("Заказ столика в ресторане не может быть пустым!");
        }
    }

    public static void validateRoomServiceOrder(String roomServiceOrder) {
        if (roomServiceOrder == null) {
            throw new IllegalArgumentException("Заказ еды и напитков в номер не может быть пустым!");
        }
    }

    public static void validateStartDate(LocalDate startDate) {
        if (startDate == null) {
            throw new IllegalArgumentException("Дата начала экскурсии не может быть пустым!");
        }
    }

    public static void validateDurationInDays(int durationInDays) {
        if (durationInDays <= 0) {
            throw new IllegalArgumentException("Продолжительность экскурсии должна быть положительным числом!");
        }
    }

    public static void validateParticipants(List<String> participants) {
        if (participants == null || participants.isEmpty()) {
            throw new IllegalArgumentException("Список участников экскурсии не может быть пустым!");
        }
    }
}
