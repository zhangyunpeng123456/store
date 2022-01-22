package com.cy.store.mapper;

import com.cy.store.entity.District;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @PackgeName: com.cy.store.mapper
 * @ClassName: DistrictMapper
 * @Author: zyp
 * Date: 2022/1/16 13:19
 * project name: store
 * @Version:
 * @Description:
 */
@Repository
public interface DistrictMapper {

    /**
     * 根据父代号查询区域信息
     * @param parent 父代号
     * @return 某个父区域下的所有区域列表
     */
    List<District> findByParent(String parent);

    /**
     * 根据省/市/区代号查询省/市/区的名称
     * @param code 代号
     * @return
     */
    String findNameByCode(String code);
}
