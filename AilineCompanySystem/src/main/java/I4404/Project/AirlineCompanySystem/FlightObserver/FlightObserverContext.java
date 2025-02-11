package I4404.Project.AirlineCompanySystem.FlightObserver;

import I4404.Project.AirlineCompanySystem.models.Passenger;
import I4404.Project.AirlineCompanySystem.models.Ticket;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FlightObserverContext implements  FlightObserver {
    private static final List<String> notifications = new ArrayList<>();
    private static final List<String> passengerNotifications = new ArrayList<>();

    @Override
    public void notifyObservers(String message, List<Ticket> Tickets) {
        for (Ticket ticket : Tickets) {
            Long passengerId = ticket.getPassengerId();
            sendNotification(passengerId, message);
        }
    }

    private static void sendNotification(Long passengerId, String message) {
        String fullMessage = "Notification for passenger of id " + passengerId + ": " + message;
        System.out.println(fullMessage);
        notifications.add(fullMessage);
    }

    public static List<String> getNotifications(Long PassengerId) {
        for (String notification : notifications) {
            if (notification.contains("passenger of id " + PassengerId)) {
                passengerNotifications.add(notification);

            } }
            return passengerNotifications ;
        }
    }
