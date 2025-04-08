package com.example.recipes.domain.req;

import lombok.Data;

import java.io.Serializable;
@Data
public class CpRecipesListReq2 implements Serializable {

    String status;

    Long cuisineId;

    int topk;
}
