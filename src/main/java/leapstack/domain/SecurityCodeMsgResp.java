package leapstack.domain;

import lombok.Data;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Data
public class SecurityCodeMsgResp {

    private int code;//200、315、403、414、416、500
    private String msg;//
    private String obj;//SecurityCode
}
