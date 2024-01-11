package com.ygback.domain;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@Table(schema = "usr",name = "user_account")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class UserAccount
{
    public enum UserAccountStatus {
        ACTIVE(0),
        INACTIVE(1);
        private final Integer value;

        UserAccountStatus(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        public static UserAccountStatus fromString(String name)
        {

            return Stream.of(UserAccountStatus.values())
                .filter(type -> type.name().equalsIgnoreCase(name)).findFirst().orElseThrow( ()-> new IllegalArgumentException(
                    "Unknown value " + name + ", Allowed values are " + Arrays.toString(values())));
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @GenericGenerator(name = "hibernateSequence", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {@org.hibernate.annotations.Parameter(name = "increment_size",value = "50")})
    @Column(name = "web_id", unique = true, nullable = false)
    private Long webId;

    @Version
    @Column(nullable = false)
    private Integer version;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @PrePersist
    @PreUpdate
    public void onUpdate()
    {
        if (createdDate == null)
        {
            createdDate = new Date();
        }
        this.setUpdateDate(new Date());
    }

    @Column(name = "external_id")
    private String externalId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "pin_code")
    private Integer pinCode;

    @Column(name = "status")
    private UserAccountStatus status;

    @Column (name = "phone_number")
    private String phoneNumber;

    @Column (name = "fcm_token")
    private String fcmToken;

    @Column (name = "gender")
    private String gender;

    @Column (name = "device_id")
    private String deviceId;

}
