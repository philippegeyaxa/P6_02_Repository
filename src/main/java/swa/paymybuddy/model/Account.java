package swa.paymybuddy.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@IdClass(AccountId.class)
public class Account {

	public static final int TYPE_INTERNAL = 0;
	public static final int TYPE_EXTERNAL = 1;
	
	@Id
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_user_id"))
    User userId;
	
	@Id
	@Column(columnDefinition = "TINYINT", nullable = true)
	int type;
	
	@Column(columnDefinition = "DECIMAL(9,3)", nullable = false)
	BigDecimal balance;

	@Column(length = 11, nullable = true)
	String bic; // only for external accounts

	@Column(length = 34, nullable = true)
	String iban; // only for external accounts

	public Account(int userId, int accountType) // to create an empty account
	{
		this.userId = new User(userId);
		type = accountType;
		balance = new BigDecimal(0);
		bic = "";
		iban = "";
	}
}
