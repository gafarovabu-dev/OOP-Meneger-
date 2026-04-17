public class Proposal extends Person {
    private int id;
    private String title;
    private String description;
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Proposal(int id, String title, String description, String name, String email, String status) {
        super(name, email);
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isEmpty()) {
            this.title = title;
        }
    }

    public void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Status: " + status);
    }
}