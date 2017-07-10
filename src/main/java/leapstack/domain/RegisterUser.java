package leapstack.domain;

import lombok.Data;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Data
public class RegisterUser {

    private String password;
    private String mobile;
    private String securityCode;

}
