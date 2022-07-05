package com.retokrugermc.retokruger.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EditEmployeeRequest {

    private Integer employeeId;
    private String phone;
    private Date dateOfBirth;
    private String homeAddress;
    private Integer vaccineStatus;
    private Integer personId;
}
