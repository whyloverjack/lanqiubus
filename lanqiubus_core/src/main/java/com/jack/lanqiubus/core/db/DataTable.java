/**
 * 
 */
package com.jack.lanqiubus.core.db;

import java.util.ArrayList;

/**
 * 
 * SQL执行结果集，所有结果都在内存中保存包括元数据与内容
 * 
 * Create on 2013-6-27 下午5:23:04
 * 
 * @author <a href="mailto:zhouyan@pzoomtech.com">ZhouYan</a.
 * 
 */
public class DataTable {

	/**
	 * 列描述
	 */
	private ArrayList<Column> cols;
	/**
	 * 行数据
	 */
	private ArrayList<DataRow> rows;

	/**
	 * @param cols
	 * @param rows
	 */
	public DataTable(ArrayList<Column> cols, ArrayList<DataRow> rows) {
		super();
		this.cols = cols;
		this.rows = rows;
	}

	public int getRowCount() {
		return rows.size();
	}

	public int getColCount() {
		return cols.size();
	}

	/**
	 * @return the cols
	 */
	public Column[] getCols() {
		return cols.toArray(new Column[cols.size()]);
	}

	/**
	 * @return the rows
	 */
	public DataRow[] getRows() {
		return rows.toArray(new DataRow[rows.size()]);
	}

	public DataRow getRow(int index) {
		return rows.get(index - 1);
	}

	/**
	 * 添加结果集列
	 * @param col
	 * @return
	 */
	protected void addColumn(String lable, int type, String typeName) {
		Column newCol = new Column();
		newCol.setLable(lable);
		newCol.setType(type);
		newCol.setTypeName(typeName);
		cols.add(newCol);
	}

	/**
	 * 添加行数据
	 * @param dr
	 */
	protected void addRow(DataRow dr) {
		rows.add(dr);
	}

	/**
	 * 创建结果集编辑器
	 * @return
	 */
	public DataTableEditor getEditor() {
		return new DataTableEditor(this);
	}

}
