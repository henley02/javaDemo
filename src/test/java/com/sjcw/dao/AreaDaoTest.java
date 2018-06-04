package com.sjcw.dao;

import com.sjcw.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by jdd on 2018/6/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    /**
     * 列出区域列表
     *
     * @return areaList
     */
    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 验证预期值和实际值是否相符
        assertEquals(2, areaList.size());
    }

    /**
     * 根据Id列出具体区域
     *
     * @return area
     */
    @Test
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("上海", area.getAreaName());
    }

    /**
     * 插入区域信息
     *
     * @return
     */
    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum = areaDao.insertArea(area);
        assertEquals(1, effectedNum);
    }

    /**
     * 更新区域信息
     *
     * @return
     */
    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setAreaId(3);

        area.setLastEditTime(new Date());
        int effectedNum = areaDao.updateArea(area);
        assertEquals(1, effectedNum);
    }

    /**
     * 删除区域信息
     *
     * @return
     */
    @Test
    public void deleteArea() {
        areaDao.deleteArea(3);
    }
}
