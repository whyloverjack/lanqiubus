/**
 * 
 */
package com.jack.lanqiubus.core.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 结果集中的行数据，所有数据都从该类取出
 * 
 * Create on 2013-6-27 下午5:25:08
 * 
 * @author <a href="mailto:zhouyan@pzoomtech.com">ZhouYan</a.
 * 
 */
public class DataRow {

	/**
	 * 列信息,用于索引到别名的转换
	 */
	private ArrayList<Column> cols;

	/**
	 * 用于通过列别名获取数据
	 */
	private final Map<String, Object> mapRow = new HashMap<String, Object>();

	/**
	 * 使用相关列描述构造
	 * 
	 * @param cols
	 */
	public DataRow(ArrayList<Column> cols) {
		super();
		this.cols = cols;
	}

	/**
	 * 通过索引与列别名构造行数据
	 * 
	 * @param index
	 * @param columnLabel
	 * @param data
	 */
	protected void addRowData(String columnLabel, Object data) {
		mapRow.put(columnLabel, data);
	}

	/**
	 * 返回数据源
	 * @return
	 */
	protected Map<String, Object> getDataSource() {
		return mapRow;
	}

	/**
	 * 返回编辑器
	 * @return
	 */
	public DataRowEditor getEditor() {
		return new DataRowEditor(this);
	}

	/**
	 * 索引转列别名
	 * 
	 * @param index
	 */
	protected String toColumnLable(int index) {
		return cols.get(index - 1).getLable();
	}

	public String getString(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return "";
		return getString(toColumnLable(index));

	}

	public String getString(String columnLabel) {
		Object obj = mapRow.get(columnLabel);
		if (obj != null)
			return obj.toString();
		else
			return "";
	}

	public byte getByte(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Byte.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public byte getByte(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Byte.valueOf(mapRow.get(columnLabel).toString());
	}

	public boolean getBoolean(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return false;
		return Boolean.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public boolean getBoolean(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return false;
		return Boolean.valueOf(mapRow.get(columnLabel).toString());
	}

	public short getShort(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Short.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public short getShort(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Short.valueOf(mapRow.get(columnLabel).toString());
	}

	public int getInt(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Integer.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public int getInt(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Integer.valueOf(mapRow.get(columnLabel).toString());
	}

	public long getLong(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Long.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public long getLong(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Long.valueOf(mapRow.get(columnLabel).toString());
	}

	public float getFloat(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Float.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public float getFloat(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Float.valueOf(mapRow.get(columnLabel).toString());
	}

	public double getDouble(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return 0;
		return Double.valueOf(mapRow.get(toColumnLable(index)).toString());
	}

	public double getDouble(String columnLabel) {
		if (mapRow.get(columnLabel) == null)
			return 0;
		return Double.valueOf(mapRow.get(columnLabel).toString());
	}

	public Date getDate(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return null;
		return getDate(toColumnLable(index));
	}

	public Date getDate(String columnLabel) {
		try {
			Object obj = mapRow.get(columnLabel);
			if (obj == null)
				return null;
			String data = obj.toString();
			SimpleDateFormat format = null;
			if (data.indexOf(":") != -1) {
				format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			} else {
				format = new SimpleDateFormat("yyyy-MM-dd");
			}
			return format.parse(data);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public byte[] getBytes(int index) {
		if (mapRow.get(toColumnLable(index)) == null)
			return null;
		return getBytes(toColumnLable(index));
	}

	public byte[] getBytes(String columnLabel) {
		Object obj = mapRow.get(columnLabel);
		if (obj != null)
			return (byte[]) obj;
		else
			return null;
	}
}
