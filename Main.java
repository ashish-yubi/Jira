import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to jira");

        Jira jira = Jira.getInstance();

        String ashishUserId = jira.createUser("Ashish");
        String aditiUserId = jira.createUser("Aditi Tapi");
        String ashishMohankaUserId = jira.createUser("Ashish Mohanka");

        System.out.println("Ashish : " + ashishUserId);
        System.out.println("Aditi : " + aditiUserId);
        System.out.println("Ashish Mohanka : " + ashishMohankaUserId);



        String ticketId1 = jira.createTicket("Ticket 1", "Description 1", TicketPriority.LOW,
                ashishMohankaUserId, aditiUserId);

        String ticketId2 = jira.createTicket("Ticket 2", "Description 2", TicketPriority.MEDIUM,
                ashishMohankaUserId, aditiUserId);

        String ticketId3 = jira.createTicket("Ticket 3", "Description 3", TicketPriority.HIGH,
                ashishUserId, aditiUserId);

        String ticketId4 = jira.createTicket("Ticket 4", "Description 4", TicketPriority.LOW,
                ashishUserId, aditiUserId);

        System.out.println("Ticket 1 : " + ticketId1);
        System.out.println("Ticket 2 : " + ticketId2);
        System.out.println("Ticket 3 : " + ticketId3);
        System.out.println("Ticket 4 : " + ticketId4);

        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("For exiting operation press 1");
            System.out.println("For fetching user history press 2");
            System.out.println("For updating ticket status press 3");
            System.out.println("For updating ticket priority press 4");
            System.out.println("For assigning ticket press 5");
            System.out.println("For displaying user work press 6");


            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1){
                break;
            }else if(choice == 2){
                String userId = sc.nextLine();
                jira.fetchUserHistory(userId);
            }else if(choice == 3){
                String ticketId = sc.next();
                String ticketStatus = sc.next();
                jira.updateTicketStatus(ticketId, TicketStatus.valueOf(ticketStatus));
            }else if(choice == 4){
                String ticketId = sc.next();
                String ticketPriority = sc.next();
                jira.updateTicketPriority(ticketId, TicketPriority.valueOf(ticketPriority));
            }else if(choice == 5){
                String ticketId = sc.next();
                String assignedTo = sc.next();
                String assignedBy = sc.next();
                jira.assignTicket(ticketId, assignedTo, assignedBy);
            }else if(choice == 6){
                String userId = sc.next();
                jira.fetchUserHistory(userId);
            }
        }






    }
}