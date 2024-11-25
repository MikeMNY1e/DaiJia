package com.lwt.daijia.model.entity.customer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author lwt
 * @version 1.0.0
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerLoginInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "客户id")
    private Long id;

    @Schema(description = "微信openid")
    private String wxOpenId;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "头像")
    private String avatarUrl;

    @Schema(description = "是否绑定手机号")
    private Boolean isBindPhone;
}