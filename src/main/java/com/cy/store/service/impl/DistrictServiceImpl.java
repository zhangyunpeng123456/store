package com.cy.store.service.impl;

import com.cy.store.entity.District;
import com.cy.store.mapper.DistrictMapper;
import com.cy.store.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @PackgeName: com.cy.store.service.impl
 * @ClassName: DistrictServiceImpl
 * @Author: zyp
 * Date: 2022/1/16 13:38
 * project name: store
 * @Version:
 * @Description:
 */
@Service
public class DistrictServiceImpl implements IDistrictService {

    @Resource
    private DistrictMapper districtMapper;

    @Override
    public List<District> getByParent(String parent) {
        /**
         * 在进行网络数据传输时，为了尽量避免无效数据的传递，可以将无效数据设置为null,
         * 这样可以节省流量、提升传输效率
         */
        List<District> list = districtMapper.findByParent(parent);
        for(District district : list){
            district.setId(null);
            district.setParent(null);
        }
        return list;
    }

    @Override
    public String getNameByCode(String code) {
        return districtMapper.findNameByCode(code);
    }


}
