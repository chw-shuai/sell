package com.imooc.sell.repository;

import com.imooc.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 常红伟
 *
 */

public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    /**
     * 根据openid查询某个人所有的id，并且分页显示
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster>findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
