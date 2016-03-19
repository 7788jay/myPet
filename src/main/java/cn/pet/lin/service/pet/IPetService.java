/*
{*****************************************************************************
{  宠物商店 v1.0																		
{  模块：宠物表; InnoDB free: 10240 kB											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-02-14  林伟樘        新建	
{ 	                                                                     
{*****************************************************************************	
*/

package cn.pet.lin.service.pet;

import cn.pet.lin.domain.pet.Pet;
import cn.pet.lin.dao.pet.IPetDAO;
import cn.pet.lin.service.IBaseService;

import java.util.List;
import java.util.Map;

/**
 * 《宠物表》 业务逻辑服务接口
 *
 * @author 林伟樘
 */
public interface IPetService extends IBaseService<IPetDAO, Pet> {

    /**
     * 根据条件查询宠物
     *
     * @param condition
     * @param offset
     * @param pageSize
     * @return
     */
    List<Pet> queryPageEx(Map<String, Object> condition, int offset, int pageSize, String orderBy, String sortBy);

    /**
     * 统计拓展
     *
     * @param condition
     * @return
     */
    int countEx(Map<String, Object> condition);
}