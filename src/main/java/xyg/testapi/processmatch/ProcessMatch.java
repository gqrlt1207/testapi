package xyg.testapi.processmatch;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "processmatch")

public class ProcessMatch {
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
    
    @Column(name="alerttype")
    private String alerttype;
    @Column(name="bonitaprocess")
    private String bonitaprocess;
    @Column(name="bonitaprocessversion")
    private String bonitaprocessversion;
    @Column(name="contractinfo")
    private String contractinfo;
    @Column(name="ostype")
    private String ostype;
        
    
}
