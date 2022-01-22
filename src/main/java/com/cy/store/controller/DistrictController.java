package com.cy.store.controller;

import com.cy.store.entity.District;
import com.cy.store.service.IDistrictService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: DistrictController
 * @Author: zyp
 * Date: 2022/1/16 14:09
 * project name: store
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {

    @Autowired
    private IDistrictService districtService;

    @RequestMapping({"/", ""})
    public JsonResult<List<District>> getByParent(String parent) {
        List<District> list = districtService.getByParent(parent);
        return new JsonResult<>(OK, list);
    }
}
