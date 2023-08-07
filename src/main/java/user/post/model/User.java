package user.post.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.Accessors;


@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {
    private int id;
    private String email;
    private String name;
    private String job;

    // Constructors, getters, and setters
    // You can generate these using your IDE or write them manually.
}