import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String userName;
    private String userId;
    private LinkedHashSet<Ticket> taskAssigned;

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public User(String userName) {
        this.userName = userName;
        this.userId = UUID.randomUUID().toString();
        this.taskAssigned = new LinkedHashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(userId, user.userId) && Objects.equals(taskAssigned, user.taskAssigned);
    }

    public LinkedHashSet<Ticket> getTaskAssigned() {
        return taskAssigned;
    }

    public void displayWork() {
        System.out.println("User Name : " + userName);
        int num=1;
        if(taskAssigned.isEmpty()) {
            System.out.println("No Task Assigned");
        }
        for (Ticket ticket : taskAssigned) {
            System.out.println("Tasks: "+ num);
            System.out.println("Ticket ID: " + ticket.getTicketId());
            System.out.println("Ticket Title: " + ticket.getTicketTitle());
            System.out.println("Ticket Description: " + ticket.getTicketDescription());
            System.out.println("Ticket Status: " + ticket.getTicketStatus());
            System.out.println("Ticket Priority: " + ticket.getTicketPriority());
            System.out.println("Assigned By: " + ticket.getAssignedBy().getUserName());
            num++;
        }
    }
}
