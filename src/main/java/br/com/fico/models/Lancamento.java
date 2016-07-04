package br.com.fico.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.fico.helpers.BigDecimalToStringSerializerHelper;
import br.com.fico.helpers.CalendarToStringSerializerHelpser;
import br.com.fico.helpers.DateTimeHelper;
import br.com.fico.helpers.StringToBigDecimalDeserializerHelper;
import br.com.fico.helpers.StringToCalendarDeserializerHelper;

@Entity
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String description;

	@Temporal(TemporalType.DATE)
	@JsonSerialize(using = CalendarToStringSerializerHelpser.class)
	@JsonDeserialize(using = StringToCalendarDeserializerHelper.class)
	private Calendar date = Calendar.getInstance();

	@Column(nullable = false)
	@JsonSerialize(using = BigDecimalToStringSerializerHelper.class)
	@JsonDeserialize(using = StringToBigDecimalDeserializerHelper.class)
	private BigDecimal amount = new BigDecimal(0.00);
	/**
	 * org.hibernate.type.NumericBooleanType 1=true, 0=false
	 */
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean paid = false;

	@ManyToOne(optional = false)
	private Bank bank;

	public Lancamento() {
		super();
	}

	public Lancamento(Long id, String description, Calendar date, BigDecimal amount, Boolean paid) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.paid = paid;
	}
	
	public Lancamento(Long id, String description, Calendar date, BigDecimal amount, Boolean paid, Bank bank) {
		this(id, description, date, amount, paid); 
		this.bank = bank;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Boolean getPaid() {
		return paid;
	}

	public void setPaid(Boolean paid) {
		this.paid = paid;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", description=" + description + ", date=" + DateTimeHelper.toDate(date) + ", amount=" + amount
				+ ", paid=" + paid + ", bank=" + bank + "]";
	}

}
