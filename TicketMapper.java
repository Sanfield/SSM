package com.xasxt.ticket.dao;

import java.util.List;
import java.util.Map;

import com.xasxt.ticket.vo.TripStationFeeInfo;
import com.xasxt.ticket.vo.TripTicketInfo;

public interface TicketMapper {

	/**
	 * 根据传入的班次编号列表，分别统计每个班次已经售出的票数
	 * 
	 * @param idList
	 * @return
	 */
	List<TripStationFeeInfo> getSaledTicketByTrip(List<String> idList);

	/**
	 * 获取剩余票数
	 * 
	 * @param tripId
	 * @return
	 */
	int getMaxSeatNum(String tripId);

	/**
	 * 计算实际票价(基本票价+附加费+站务费)
	 * 
	 * @param condition
	 * @return
	 */
	Float getRealPrice(Map<String, Object> condition);

	/**
	 * 分配一个座位号
	 * 
	 * @param map
	 * @return
	 */
	int getNewSeatNum(Map<String, Object> map);

	int printTicket(Map<String, Object> map);

	/**
	 * 根据日期和线路编号，查看每个班次的售票情况
	 * 
	 * @param condition
	 * @return
	 */
	List<TripTicketInfo> getDailyTicketInfo(Map<String, Object> condition);

}
