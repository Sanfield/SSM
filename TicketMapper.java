package com.xasxt.ticket.dao;

import java.util.List;
import java.util.Map;

import com.xasxt.ticket.vo.TripStationFeeInfo;
import com.xasxt.ticket.vo.TripTicketInfo;

public interface TicketMapper {

	/**
	 * ���ݴ���İ�α���б��ֱ�ͳ��ÿ������Ѿ��۳���Ʊ��
	 * 
	 * @param idList
	 * @return
	 */
	List<TripStationFeeInfo> getSaledTicketByTrip(List<String> idList);

	/**
	 * ��ȡʣ��Ʊ��
	 * 
	 * @param tripId
	 * @return
	 */
	int getMaxSeatNum(String tripId);

	/**
	 * ����ʵ��Ʊ��(����Ʊ��+���ӷ�+վ���)
	 * 
	 * @param condition
	 * @return
	 */
	Float getRealPrice(Map<String, Object> condition);

	/**
	 * ����һ����λ��
	 * 
	 * @param map
	 * @return
	 */
	int getNewSeatNum(Map<String, Object> map);

	int printTicket(Map<String, Object> map);

	/**
	 * �������ں���·��ţ��鿴ÿ����ε���Ʊ���
	 * 
	 * @param condition
	 * @return
	 */
	List<TripTicketInfo> getDailyTicketInfo(Map<String, Object> condition);

}
