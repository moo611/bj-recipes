package com.example.recipes.domain.req;

import lombok.Data;

import java.io.Serializable;
@Data
public class ChangePwdReq implements Serializable {

    String oldPwd;

    String newPwd;
}
