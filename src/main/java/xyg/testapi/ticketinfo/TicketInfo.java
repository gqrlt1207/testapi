package xyg.testapi.ticketinfo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "ticketinfo")

public class TicketInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="incident")
    private String incident;
    @Column(name="shortdescription")
    private String ShortDescription;
    @Column(name="problemdescription")
    private String ProblemDescription;
    @Column(name="ostype")
    private String ostype;
    @Column(name="ipaddress")
    private String ipaddress;
    @Column(name="openeddatestamp")
    private String openedDateStamp;
    @Column(name="servername")
    private String servername;
    @Column(name="assignedgroup")
    private String AssignedGroup;
    @Column(name="snowstatus")
    private String SnowStatus;
    @Column(name="processedbybonita")
    private boolean processedbybonita;
    
    public String getIncident() {
		return incident;
	}

	public void setIncident(String incident) {
		this.incident = incident;
	}

	public String getShortDescription() {
		return ShortDescription;
	}

	public void setShortDescription(String shortDescription) {
		ShortDescription = shortDescription;
	}

	public String getProblemDescription() {
		return ProblemDescription;
	}

	public void setProblemDescription(String problemDescription) {
		ProblemDescription = problemDescription;
	}

	public boolean isProcessedbybonita() {
		return processedbybonita;
	}

	public void setProcessedbybonita(boolean processedbybonita) {
		this.processedbybonita = processedbybonita;
	}

	public String getSnowStatus() {
		return SnowStatus;
	}

	public void setSnowStatus(String snowStatus) {
		SnowStatus = snowStatus;
	}

	public String getAssignedGroup() {
		return AssignedGroup;
	}

	public void setAssignedGroup(String assignedGroup) {
		AssignedGroup = assignedGroup;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public String getOpenedDateStamp() {
		return openedDateStamp;
	}

	public void setOpenedDateStamp(String openedDateStamp) {
		this.openedDateStamp = openedDateStamp;
	}

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getOstype() {
		return ostype;
	}

	public void setOstype(String ostype) {
		this.ostype = ostype;
	}
}

