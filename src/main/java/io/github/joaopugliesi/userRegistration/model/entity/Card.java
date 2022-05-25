package io.github.joaopugliesi.userRegistration.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_card;
	
	@Column(nullable = false, length = 8, unique = true)
	private String cardNumber;
	
	@Column(nullable = false, length = 150)
	private String name;
	
	@Column(nullable = false)
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CardType cardType;

	public Integer getId_card() {
		return id_card;
	}

	public void setId_card(Integer id_card) {
		this.id_card = id_card;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CardType getCardType() {
		return cardType;
	}

	public void setCardType(CardType cardType) {
		this.cardType = cardType;
	}
	
}
