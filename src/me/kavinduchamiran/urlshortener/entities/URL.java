package me.kavinduchamiran.urlshortener.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import me.kavinduchamiran.urlshortener.generator.UUIDIDGenerator;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
@Table(name = "urls")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class URL {
    @Id
    @GeneratedValue(generator = "uuidIdGenerator")
    @GenericGenerator(name = "uuidIdGenerator", type = UUIDIDGenerator.class)
    private String id;

    @NotNull
    @Size(min = 1, max = 200)
    private String longUrl;

    private boolean isPasswordProtected;

    private String password;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User createdBy;

    private Date createdOn;

    private Date expiresOn;
}
