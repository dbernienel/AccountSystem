package za.ac.nwu.ac.domain.dto;

import io.swagger.annotations.ApiModel;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;

@ApiModel(value = "Member",
        description = "A DTO that represents a Member"
)
public class MemberDto implements Serializable {

    private Long id;
    private String name;
    private String surName;

    public MemberDto(Long id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public MemberDto() {
    }

    public MemberDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.surName = member.getSurName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }

}
