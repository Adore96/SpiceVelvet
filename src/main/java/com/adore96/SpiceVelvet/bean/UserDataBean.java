package com.adore96.SpiceVelvet.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author kasun_k ON 12/16/21
 * @project SpiceVelvet
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDataBean {
    private String id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String telephone;
}
