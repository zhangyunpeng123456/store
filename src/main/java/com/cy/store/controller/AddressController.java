package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.service.IAddressService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @PackgeName: com.cy.store.controller
 * @ClassName: AddressController
 * @Author: zyp
 * Date: 2022/1/15 18:01
 * project name: store
 * @Version:
 * @Description: 用户收货地址Controller
 */
@RestController
@RequestMapping("/addresses")
public class AddressController extends BaseController {

    @Autowired
    private IAddressService addressService;

    @RequestMapping("/add_new_address")
    public JsonResult<Void> addNewAddress(Address address, HttpSession session) {
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        addressService.addNewAddress(uid, username, address);
        return new JsonResult<>(OK);
    }

    @RequestMapping({"", "/"})
    public JsonResult<List<Address>> getAddressByUid(HttpSession session) {
        List<Address> addresses = addressService.getByUid(getUidFromSession(session));
        return new JsonResult<>(OK, addresses);
    }

    @RequestMapping("/{id}/set_default")
    public JsonResult<Void> setDefault(@PathVariable("id") Integer aid, HttpSession session){
        addressService.setDefault(aid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }

    @PostMapping("/{aid}/delete")
    public JsonResult<Void> delete(@PathVariable("aid") Integer aid, HttpSession session){
        addressService.delete(aid, getUidFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(OK);
    }
}
