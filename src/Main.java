

/* Тут я использую библиотеку Swing для создания простого GUI,
чтобы заполнять параметры тура в отдельном окне(просто для красоты)
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private JFrame frame;
    private JTextField hotelField;
    private JTextField hotelRoomField;
    private JTextField rideTicketsField;
    private JTextField restaurantField;
    private JTextField roomServiceField;
    private JTextField startDateField;
    private JTextField durationField;
    private JTextArea participantsArea;

    public Main() {
        frame = new JFrame("Главное окно");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Отель:"));
        hotelField = new JTextField();
        panel.add(hotelField);

        panel.add(new JLabel("Бронирование номера в отеле (номер комнаты):"));
        hotelRoomField = new JTextField();
        panel.add(hotelRoomField);

        panel.add(new JLabel("Билеты на аттракцион (название аттракциона):"));
        rideTicketsField = new JTextField();
        panel.add(rideTicketsField);

        panel.add(new JLabel("Заказ столика в ресторане (№ столика, время):"));
        restaurantField = new JTextField();
        panel.add(restaurantField);

        panel.add(new JLabel("Заказ еды и напитков в номер (№ номера, заказ):"));
        roomServiceField = new JTextField();
        panel.add(roomServiceField);

        panel.add(new JLabel("Дата начала экскурсии (гггг-мм-дд):"));
        startDateField = new JTextField();
        panel.add(startDateField);

        panel.add(new JLabel("Продолжительность экскурсии (в днях):"));
        durationField = new JTextField();
        panel.add(durationField);

        panel.add(new JLabel("Участники экскурсии (разделитель - запятая):"));
        participantsArea = new JTextArea();
        panel.add(new JScrollPane(participantsArea));

        JButton createButton = new JButton("Создать экскурсию");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createTour();
            }
        });
        panel.add(createButton);

        frame.add(panel);
        frame.setVisible(true);
    }

    private void createTour() {
        try {
            Excursion tour = new Excursion.TourBuilder()
                    .setHotel(hotelField.getText())
                    .sethotelRoom(hotelRoomField.getText())
                    .setRideTickets(rideTicketsField.getText())
                    .setRestaurantReservation(restaurantField.getText())
                    .setRoomServiceOrder(roomServiceField.getText())
                    .setStartDate(LocalDate.parse(startDateField.getText()))
                    .setDurationInDays(Integer.parseInt(durationField.getText()))
                    .setParticipants(parseParticipants(participantsArea.getText()))
                    .build();


            JOptionPane.showMessageDialog(frame, "Тур успешно создан:\n\n" + tour.toString());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Ошибка при создании тура: " + ex.getMessage(), "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private List<String> parseParticipants(String input) {
        String[] participants = input.split(",");
        List<String> participantList = new ArrayList<>();
        for (String participant : participants) {
            participantList.add(participant.trim());
        }
        return participantList;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
