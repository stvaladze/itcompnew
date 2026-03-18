package com.itcomp.model.employee;

import com.itcomp.enums.DeveloperLevel;


import java.util.ArrayList;
import java.util.List;

public class Developer extends Employee {

    private List<String> programmingLanguages = new ArrayList<>();
    private DeveloperLevel level;
    private List<String> tools = new ArrayList<>();


    public Developer(String name, String email, String phone, String country, String city, int id, double salary) {
        super(name, email, phone, country, city, id, salary);
    }

    @Override
    public void work() {

        System.out.println("Developer writes, reviews, and maintains code");
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void addProgrammingLanguage(String language) {
        programmingLanguages.add(language);
    }

    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
    }

    public DeveloperLevel getLevel() {
        return level;
    }

    public void setLevel(DeveloperLevel level) {
        this.level = level;
    }
}
