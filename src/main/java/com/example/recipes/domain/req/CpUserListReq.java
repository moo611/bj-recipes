package com.example.recipes.domain.req;

import com.example.recipes.domain.base.BaseReq;
import lombok.Data;

@Data
public class CpUserListReq extends BaseReq {

    String role;
}
