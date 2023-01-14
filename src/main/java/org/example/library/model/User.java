package org.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

//adnotacja @Data - tworzy gettery, setter itd.
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String login;
    private String password;
    private String name;
}
