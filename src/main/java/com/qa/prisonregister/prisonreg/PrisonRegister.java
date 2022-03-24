package com.qa.prisonregister.prisonreg;

import java.util.Objects;

public class PrisonRegister {
	
	
		private long PrisonerId;
		private String name;
		private String crime; 
	    private String reasonInSolitaryConfinement;
	    private String  wardRelocationOnceReleased;
	    float totalPrisonSentenceInMonths;
	    float daysinSolitaryConfinement;
	    boolean gangMember;
	    boolean suicideWatch;
	    boolean repeatVisitor;
		
	    
	    
	    public PrisonRegister() {
			super();
			// TODO Auto-generated constructor stub
		}


	 // One constructor WITH id (retrieving data from the database)
		public PrisonRegister(long prisonerId, String name, String crime, String reasonInSolitaryConfinement,
				String wardRelocationOnceReleased, float totalPrisonSentenceInMonths, float daysinSolitaryConfinement,
				boolean gangMember, boolean suicideWatch, boolean repeatVisitor) {
			super();
			PrisonerId = prisonerId;
			this.name = name;
			this.crime = crime;
			this.reasonInSolitaryConfinement = reasonInSolitaryConfinement;
			this.wardRelocationOnceReleased = wardRelocationOnceReleased;
			this.totalPrisonSentenceInMonths = totalPrisonSentenceInMonths;
			this.daysinSolitaryConfinement = daysinSolitaryConfinement;
			this.gangMember = gangMember;
			this.suicideWatch = suicideWatch;
			this.repeatVisitor = repeatVisitor;
		}

		// One constructor WITHOUT ID (posting data into the database)
	public PrisonRegister(String name, String crime, String reasonInSolitaryConfinement,
			String wardRelocationOnceReleased, float totalPrisonSentenceInMonths, float daysinSolitaryConfinement,
			boolean gangMember, boolean suicideWatch, boolean repeatVisitor) {
		super();
		this.name = name;
		this.crime = crime;
		this.reasonInSolitaryConfinement = reasonInSolitaryConfinement;
		this.wardRelocationOnceReleased = wardRelocationOnceReleased;
		this.totalPrisonSentenceInMonths = totalPrisonSentenceInMonths;
		this.daysinSolitaryConfinement = daysinSolitaryConfinement;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		return daysinSolitaryConfinement;
	}


	public void setDaysinSolitaryConfinement(float daysinSolitaryConfinement) {
		this.daysinSolitaryConfinement = daysinSolitaryConfinement;
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
		return Objects.hash(PrisonerId, crime, daysinSolitaryConfinement, gangMember, name, reasonInSolitaryConfinement,
				repeatVisitor, suicideWatch, totalPrisonSentenceInMonths, wardRelocationOnceReleased);
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
				&& Float.floatToIntBits(daysinSolitaryConfinement) == Float
						.floatToIntBits(other.daysinSolitaryConfinement)
				&& gangMember == other.gangMember && Objects.equals(name, other.name)
				&& Objects.equals(reasonInSolitaryConfinement, other.reasonInSolitaryConfinement)
				&& repeatVisitor == other.repeatVisitor && suicideWatch == other.suicideWatch
				&& Float.floatToIntBits(totalPrisonSentenceInMonths) == Float
						.floatToIntBits(other.totalPrisonSentenceInMonths)
				&& Objects.equals(wardRelocationOnceReleased, other.wardRelocationOnceReleased);
	}


	@Override
	public String toString() {
		return "PrisonRegister [PrisonerId=" + PrisonerId + ", name=" + name + ", crime=" + crime
				+ ", reasonInSolitaryConfinement=" + reasonInSolitaryConfinement + ", wardRelocationOnceReleased="
				+ wardRelocationOnceReleased + ", totalPrisonSentenceInMonths=" + totalPrisonSentenceInMonths
				+ ", daysinSolitaryConfinement=" + daysinSolitaryConfinement + ", gangMember=" + gangMember
				+ ", suicideWatch=" + suicideWatch + ", repeatVisitor=" + repeatVisitor + "]";
	}


	public void setId(int i) {
		// TODO Auto-generated method stub
		
	}


	

	}
		
		



