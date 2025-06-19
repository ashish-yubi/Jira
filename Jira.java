import java.util.HashMap;

public class Jira {
    HashMap<String,User> users;
    HashMap<String,Ticket> tickets; // <Ticket ID, Ticket>
    static Jira jira;
    private Jira(){
        users = new HashMap<>();
        tickets = new HashMap<>();
    }

    public static Jira getInstance() {
        if(jira == null){
            jira = new Jira();
        }
        return jira;
    }

    public String createUser(String userName){
        User user = new User(userName);
        String userId = user.getUserId();
        users.put(userId,user);
        return userId;
    }

    public String createTicket(String ticketTitle, String ticketDescription,
                             TicketPriority ticketPriority, String assignedTo, String assignedBy){
        Ticket ticket = new Ticket(ticketTitle, ticketDescription, ticketPriority,
               users.get(assignedTo), users.get(assignedBy));
        String ticketId = ticket.getTicketId();
        tickets.put(ticketId,ticket);
        return ticketId;
    }

    public void fetchUserHistory(String userId){
        User user = users.get(userId);
        user.displayWork();
    }

    public void updateTicketStatus(String ticketId, TicketStatus ticketStatus){
        Ticket ticket = tickets.get(ticketId);
        ticket.updateTicketStatus(ticketStatus);
    }

    public void updateTicketPriority(String ticketId, TicketPriority ticketPriority){
        Ticket ticket = tickets.get(ticketId);
        ticket.updateTicketPriority(ticketPriority);
    }

    public void assignTicket(String ticketId, String assignedTo, String assignedBy){
        Ticket ticket = tickets.get(ticketId);
        ticket.assignTicket(users.get(assignedTo), users.get(assignedBy));
    }

}
