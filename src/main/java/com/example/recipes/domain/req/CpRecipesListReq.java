package com.example.recipes.domain.req;

import com.example.recipes.domain.base.BaseReq;
import lombok.Data;

@Data
public class CpRecipesListReq extends BaseReq {
    String status;
}
