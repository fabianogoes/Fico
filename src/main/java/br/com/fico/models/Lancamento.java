package br.com.fico.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
public class Lancamento {

	@Id @GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String description;
	@Temporal(TemporalType.DATE)
	private Date date = Calendar.getInstance().getTime();
	@Column(nullable=false)
	private BigDecimal amount = new BigDecimal(1000.00);
	@Column(nullable=false)
	/**
	 * org.hibernate.type.NumericBooleanType
	 * 1=true, 0=false
	 */
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean paid = false;

	public Lancamento() {
		super();
	}

	public Lancamento(Long id, String description, Date date, BigDecimal amount, Boolean paid) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.amount = amount;
		this.paid = paid;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
		return "Lancamento [id=" + id + ", description=" + description + ", date=" + date + ", amount=" + amount
				+ ", paid=" + paid + "]";
	}

}
