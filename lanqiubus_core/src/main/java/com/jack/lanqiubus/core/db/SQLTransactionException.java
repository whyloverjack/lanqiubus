/**
 * 
 */
package com.jack.lanqiubus.core.db;

import java.sql.SQLException;

/**
 * 
 * 事务操作异常
 *
 * Create on 2013-10-24 上午11:53:42
 *
 * @author <a href="mailto:zhouyan@pzoomtech.com">ZhouYan</a>. 
 * 
 */
public class SQLTransactionException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SQLTransactionException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason, String sqlState, int vendorCode, Throwable cause) {
		super(reason, sqlState, vendorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason, String SQLState, int vendorCode) {
		super(reason, SQLState, vendorCode);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason, String sqlState, Throwable cause) {
		super(reason, sqlState, cause);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason, String SQLState) {
		super(reason, SQLState);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason, Throwable cause) {
		super(reason, cause);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(String reason) {
		super(reason);
		// TODO Auto-generated constructor stub
	}

	public SQLTransactionException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
