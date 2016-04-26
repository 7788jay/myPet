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

package cn.pet.lin.dao.pet;

import cn.pet.lin.dao.IBaseDAO;
import cn.pet.lin.pet.Pet;
import cn.pet.lin.pet.PetEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《宠物表》 数据访问接口
 *
 * @author 林伟樘
 */
public interface IPetDAO extends IBaseDAO<Pet> {


    /**
     * 根据条件查询宠物
     *
     * @param condition
     * @param offset
     * @param rows
     * @return
     */
    List<Pet> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows, @Param("orderBy") String orderBy, @Param("sortBy") String sortBy);

    /**
     * 统计拓展
     *
     * @param condition
     * @return
     */
    int countEx(@Param("condition") Map<String, Object> condition);

    /**
     * 查询销量高的宠物
     *
     * @param offset
     * @param rows
     * @return
     */
    List<PetEx> queryPetOrderSum(@Param("offset") int offset, @Param("rows") int rows);

}