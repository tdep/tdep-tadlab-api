package com.tdep.tadlab.entity;

import jakarta.persistence.*;

import java.util.Set;
//TODO: Create tools Table
//TODO: Create tool_links Table
@Entity
@Table(name="tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
//    @ManyToMany(
//            fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE,
//                    CascadeType.DETACH,
//                    CascadeType.REFRESH })
//    @JoinTable(
//            name = "project_tools",
//            joinColumns = @JoinColumn(name = "project_id"),
//            inverseJoinColumns = @JoinColumn(name = "tool_id"))
//    private Set<Project> projects;

    @Column(name = "name")
    private String name;

    @Column(name = "image_url")
    private String imageUrl;
    public Tool() {
    }

    public Tool(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

//    public Set<Project> getProject() { return projects; }
//    public void setProject(Set<Project> projects) { this.projects = projects; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String toString() {
        return "Tool [name=" + name + ", id=" + id + "]";
    }
}