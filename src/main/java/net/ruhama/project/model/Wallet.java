/**
 * 
 */
package net.ruhama.project.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author MaJiD
 *
 */
@Entity
@Table(name="wallet")
public class Wallet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JoinColumn(name="current_balance", nullable = false)
	private Double current_balance;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="owner", nullable = true)
	private User owner;
	
	@JoinColumn(name="created_at", nullable = false)
	private Date created_at;
	
	@JoinColumn(name="last_update", nullable = false)
	private Date last_update;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="created_by", nullable = true)
	private User created_by;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="last_update_by", nullable = true)
	private User last_update_by;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the current_balance
	 */
	public Double getCurrent_balance() {
		return current_balance;
	}

	/**
	 * @param current_balance the current_balance to set
	 */
	public void setCurrent_balance(Double current_balance) {
		this.current_balance = current_balance;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the last_update
	 */
	public Date getLast_update() {
		return last_update;
	}

	/**
	 * @param last_update the last_update to set
	 */
	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	/**
	 * @return the created_by
	 */
	public User getCreated_by() {
		return created_by;
	}

	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	/**
	 * @return the last_update_by
	 */
	public User getLast_update_by() {
		return last_update_by;
	}

	/**
	 * @param last_update_by the last_update_by to set
	 */
	public void setLast_update_by(User last_update_by) {
		this.last_update_by = last_update_by;
	}
	
	@Override
	public String toString() {
		return "Wallet [id=" + id + ", current_balance=" + current_balance + ", owner=" + owner + "]";
	}

}
