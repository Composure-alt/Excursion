

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

    private final JFrame frame;
    private final JComboBox<String> hotelComboBox;
    private final JComboBox<String> hotelRoomComboBox;
    private final JTextField rideTicketsField;
    private final JTextField restaurantField;
    private final JTextField roomServiceField;
    private final JTextField startDateField;
    private final JTextField durationField;
    private final JTextArea participantsArea;

    public Main() {
        frame = new JFrame("Главное окно");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2));

        panel.add(new JLabel("Отель:"));
        hotelComboBox = new JComboBox<>(new String[]{"Броско", "Восход", "Bridge Resort", "Богатырь", "Фрегат", "Коринтия"});
        hotelComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateHotelRoomComboBox();
            }
        });

        panel.add(hotelComboBox);

        panel.add(new JLabel("Бронирование номера в отеле (номер комнаты):"));
        hotelRoomComboBox = new JComboBox<>();
        panel.add(hotelRoomComboBox);


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

        updateHotelRoomComboBox();
    }

    private void updateHotelRoomComboBox() {
        String selectedHotel = (String) hotelComboBox.getSelectedItem();
        hotelRoomComboBox.removeAllItems();
        switch (selectedHotel) {
            case "Броско":
                for (int i = 1; i <= 25; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
            case "Восход":
                for (int i = 1; i <= 80; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
            case "Bridge Resort":
                for (int i = 1; i <= 10; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
            case "Богатырь":
                for (int i = 1; i <= 125; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
            case "Фрегат":
                for (int i = 1; i <= 315; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
            case "Коринтия":
                for (int i = 1; i <= 66; i++) {
                    hotelRoomComboBox.addItem(String.valueOf(i));
                }
                break;
        }
    }


    private void createTour() {
        try {
            Excursion tour = new Excursion.TourBuilder()
                    .setHotel((String) hotelComboBox.getSelectedItem())
                    .sethotelRoom((String) hotelRoomComboBox.getSelectedItem())
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
