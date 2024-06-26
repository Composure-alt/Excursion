


/* Реализация паттерна "Строитель"
Пример "Cистема планирования экскурсий по парку развлечений"
*/


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Excursion {
    private String hotel;
    private String hotelRoom;
    private String rideTickets;
    private String restaurantReservation;
    private String roomServiceOrder;
    private LocalDate startDate;
    private int durationInDays;
    private List<String> participants;

    private Excursion(TourBuilder builder) {
        this.hotel = builder.hotel;
        this.hotelRoom = builder.hotelRoom;
        this.rideTickets = builder.rideTickets;
        this.restaurantReservation = builder.restaurantReservation;
        this.roomServiceOrder = builder.roomServiceOrder;
        this.startDate = builder.startDate;
        this.durationInDays = builder.durationInDays;
        this.participants = builder.participants;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Подробности экскурсии:\n");
        sb.append("Отель: ").append(hotel).append('\n');
        sb.append("Номер в отеле: ").append(hotelRoom).append('\n');
        sb.append("Билеты на аттракцион: ").append(rideTickets).append('\n');
        sb.append("Заказ столика в ресторане: ").append(restaurantReservation).append('\n');
        sb.append("Заказ еды и напитков в номер: ").append(roomServiceOrder).append('\n');
        if (startDate != null) {
            sb.append("Дата начала экскурсии: ").append(startDate).append('\n');
        }
        sb.append("Продолжительность экскурсии (в днях): ").append(durationInDays).append('\n');
        if (participants != null && !participants.isEmpty()) {
            sb.append("Участники экскурсии: ").append(participants).append('\n');
        }
        return sb.toString();
    }

    public static class TourBuilder {
        private String hotel;
        private String hotelRoom;
        private String rideTickets;
        private String restaurantReservation;
        private String roomServiceOrder;
        private LocalDate startDate;
        private int durationInDays;
        private List<String> participants;

        public TourBuilder setHotel(String hotel) {
            ExcursionValidator.validateHotel(hotel);
            this.hotel = hotel;
            return this;
        }

        public TourBuilder sethotelRoom(String hotelRoom) {
            ExcursionValidator.validateHotelRoom(hotelRoom);
            this.hotelRoom = hotelRoom;
            return this;
        }

        public TourBuilder setRideTickets(String rideTickets) {
            ExcursionValidator.validateRideTickets(rideTickets);
            this.rideTickets = rideTickets;
            return this;
        }

        public TourBuilder setRestaurantReservation(String restaurantReservation) {
            ExcursionValidator.validateRestaurantReservation(restaurantReservation);
            this.restaurantReservation = restaurantReservation;
            return this;
        }

        public TourBuilder setRoomServiceOrder(String roomServiceOrder) {
            ExcursionValidator.validateRoomServiceOrder(roomServiceOrder);
            this.roomServiceOrder = roomServiceOrder;
            return this;
        }

        public TourBuilder setStartDate(LocalDate startDate) {
            ExcursionValidator.validateStartDate(startDate);
            this.startDate = startDate;
            return this;
        }

        public TourBuilder setDurationInDays(int durationInDays) {
            ExcursionValidator.validateDurationInDays(durationInDays);
            this.durationInDays = durationInDays;
            return this;
        }

        public TourBuilder setParticipants(List<String> participants) {
            ExcursionValidator.validateParticipants(participants);
            this.participants = new ArrayList<>(participants);
            return this;
        }

        public Excursion build() {
            return new Excursion(this);
        }
    }
}
