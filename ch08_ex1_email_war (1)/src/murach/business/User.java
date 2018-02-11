package murach.business;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    Date currentDate;
    private String ctxemail;

    public String getCtxemail() {
		return ctxemail;
	}

	public void setCtxemail(String ctxemail) {
		this.ctxemail = ctxemail;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public User() {
        firstName = "";
        lastName = "";
        email = "";
    }

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
