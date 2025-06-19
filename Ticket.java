import java.util.Date;
import java.util.UUID;

public class Ticket {
    private String ticketId;
    private String ticketTitle;
    private String ticketDescription;
    private TicketStatus ticketStatus;
    private TicketPriority ticketPriority;
    private User assignedTo;
    private User assignedBy;
    private Date dateCreated;

    public String getTicketTitle() {
        return ticketTitle;
    }

    public String getTicketId() {
        return ticketId;
    }

    public TicketPriority getTicketPriority() {
        return ticketPriority;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public User getAssignedBy() {
        return assignedBy;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public Ticket(String ticketTitle, String ticketDescription,
                  TicketPriority ticketPriority, User assignedTo, User assignedBy) {
        this.ticketId = UUID.randomUUID().toString();
        this.ticketTitle = ticketTitle;
        this.ticketDescription = ticketDescription;
        this.ticketStatus = TicketStatus.TODO;
        this.ticketPriority = ticketPriority;
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
        this.dateCreated = new Date();
        assignedTo.getTaskAssigned().add(this);
    }

    public void assignTicket(User assignedTo, User assignedBy) {
        if(this.ticketStatus.equals(TicketStatus.CLOSED)) {
            System.out.println("Ticket is closed");
            return;
        }
        User currentAssignedTo = this.assignedTo;
        if (!currentAssignedTo.equals(assignedTo)){
            currentAssignedTo.getTaskAssigned().remove(this);
            assignedTo.getTaskAssigned().add(this);
        }
        this.assignedTo = assignedTo;
        this.assignedBy = assignedBy;
    }

    public void updateTicketPriority(TicketPriority ticketPriority) {
        if(this.ticketStatus.equals(TicketStatus.CLOSED)) {
            System.out.println("Ticket is closed");
            return;
        }
        this.ticketPriority = ticketPriority;
    }

    public void updateTicketStatus(TicketStatus ticketStatus) {
        if(this.ticketStatus.equals(TicketStatus.CLOSED)) {
            System.out.println("Ticket is closed");
            return;
        }
        this.ticketStatus = ticketStatus;
    }

}
