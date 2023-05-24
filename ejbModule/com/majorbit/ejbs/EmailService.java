package com.majorbit.ejbs;


import javax.ejb.Remote;

import com.majorbit.model.Email;
@Remote
public interface EmailService {
	public String sendmail(Email email);
}
