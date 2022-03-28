package com.qa.prisonregister.prisonreg;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PrisonRegister {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PrisonerId;

	@Column(nullable = false)
	private String prisonerName;

	@Column(nullable = false)
	private String crime;

	@Column(nullable = false)
	private String reasonInSolitaryConfinement;

	@Column(nullable = false)
	private String wardRelocationOnceReleased;

	@Column(nullable = false)
	float totalPrisonSentenceInMonths;

	@Column(nullable = false)
	float daysInSolitaryConfinement;

	@Column(nullable = false)
	boolean gangMember;

	@Column(nullable = false)
	boolean suicideWatch;

	@Column(nullable = false)
	boolean repeatVisitor;

	public PrisonRegister() {
		super();
		// TODO Auto-generated constructor stub
	}

	// One constructor WITH id (retrieving data from the database)
	public PrisonRegister(long prisonerId, String prisonerName, String crime, String reasonInSolitaryConfinement,
			String wardRelocationOnceReleased, float totalPrisonSentenceInMonths, float daysinSolitaryConfinement,
			boolean gangMember, boolean suicideWatch, boolean repeatVisitor) {
		super();
		PrisonerId = prisonerId;
		this.prisonerName = prisonerName;
		this.crime = crime;
		this.reasonInSolitaryConfinement = reasonInSolitaryConfinement;
		this.wardRelocationOnceReleased = wardRelocationOnceReleased;
		this.totalPrisonSentenceInMonths = totalPrisonSentenceInMonths;
		this.daysInSolitaryConfinement = daysinSolitaryConfinement;
		this.gangMember = gangMember;
		this.suicideWatch = suicideWatch;
		this.repeatVisitor = repeatVisitor;
	}

	// One constructor WITHOUT ID (posting data into the database)
	public PrisonRegister(String prisonerName, String crime, String reasonInSolitaryConfinement,
			String wardRelocationOnceReleased, float totalPrisonSentenceInMonths, float daysinSolitaryConfinement,
			boolean gangMember, boolean suicideWatch, boolean repeatVisitor) {
		super();
		this.prisonerName = prisonerName;
		this.crime = crime;
		this.reasonInSolitaryConfinement = reasonInSolitaryConfinement;
		this.wardRelocationOnceReleased = wardRelocationOnceReleased;
		this.totalPrisonSentenceInMonths = totalPrisonSentenceInMonths;
		this.daysInSolitaryConfinement = daysinSolitaryConfinement;
		this.gangMember = gangMember;
		this.suicideWatch = suicideWatch;
		this.repeatVisitor = repeatVisitor;
	}

	public long getPrisonerId() {
		return PrisonerId;
	}

	public void setPrisonerId(long prisonerId) {
		PrisonerId = prisonerId;
	}

	public String getprisonerName() {
		return prisonerName;
	}

	public void setprisonerName(String prisonerName) {
		this.prisonerName = prisonerName;
	}

	public String getCrime() {
		return crime;
	}

	public void setCrime(String crime) {
		this.crime = crime;
	}

	public String getReasonInSolitaryConfinement() {
		return reasonInSolitaryConfinement;
	}

	public void setReasonInSolitaryConfinement(String reasonInSolitaryConfinement) {
		this.reasonInSolitaryConfinement = reasonInSolitaryConfinement;
	}

	public String getWardRelocationOnceReleased() {
		return wardRelocationOnceReleased;
	}

	public void setWardRelocationOnceReleased(String wardRelocationOnceReleased) {
		this.wardRelocationOnceReleased = wardRelocationOnceReleased;
	}

	public float getTotalPrisonSentenceInMonths() {
		return totalPrisonSentenceInMonths;
	}

	public void setTotalPrisonSentenceInMonths(float totalPrisonSentenceInMonths) {
		this.totalPrisonSentenceInMonths = totalPrisonSentenceInMonths;
	}

	public float getDaysinSolitaryConfinement() {
		return daysInSolitaryConfinement;
	}

	public void setDaysinSolitaryConfinement(float daysinSolitaryConfinement) {
		this.daysInSolitaryConfinement = daysinSolitaryConfinement;
	}

	public boolean isGangMember() {
		return gangMember;
	}

	public void setGangMember(boolean gangMember) {
		this.gangMember = gangMember;
	}

	public boolean isSuicideWatch() {
		return suicideWatch;
	}

	public void setSuicideWatch(boolean suicideWatch) {
		this.suicideWatch = suicideWatch;
	}

	public boolean isRepeatVisitor() {
		return repeatVisitor;
	}

	public void setRepeatVisitor(boolean repeatVisitor) {
		this.repeatVisitor = repeatVisitor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(PrisonerId, crime, daysInSolitaryConfinement, gangMember, prisonerName,
				reasonInSolitaryConfinement, repeatVisitor, suicideWatch, totalPrisonSentenceInMonths,
				wardRelocationOnceReleased);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrisonRegister other = (PrisonRegister) obj;
		return PrisonerId == other.PrisonerId && Objects.equals(crime, other.crime)
				&& Float.floatToIntBits(daysInSolitaryConfinement) == Float
						.floatToIntBits(other.daysInSolitaryConfinement)
				&& gangMember == other.gangMember && Objects.equals(prisonerName, other.prisonerName)
				&& Objects.equals(reasonInSolitaryConfinement, other.reasonInSolitaryConfinement)
				&& repeatVisitor == other.repeatVisitor && suicideWatch == other.suicideWatch
				&& Float.floatToIntBits(totalPrisonSentenceInMonths) == Float
						.floatToIntBits(other.totalPrisonSentenceInMonths)
				&& Objects.equals(wardRelocationOnceReleased, other.wardRelocationOnceReleased);
	}

	@Override
	public String toString() {
		return "PrisonRegister [PrisonerId=" + PrisonerId + ", prisonerName=" + prisonerName + ", crime=" + crime
				+ ", reasonInSolitaryConfinement=" + reasonInSolitaryConfinement + ", wardRelocationOnceReleased="
				+ wardRelocationOnceReleased + ", totalPrisonSentenceInMonths=" + totalPrisonSentenceInMonths
				+ ", daysinSolitaryConfinement=" + daysInSolitaryConfinement + ", gangMember=" + gangMember
				+ ", suicideWatch=" + suicideWatch + ", repeatVisitor=" + repeatVisitor + "]";
	}

	public void setId(int i) {
		// TODO Auto-generated method stub

	}

}
