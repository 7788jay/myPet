package cn.pet.lin.utils.enums;

/**
 */
public enum SUCCESSMSG {

	/**
	 * 成功提示
	 */
	SUCCESS_COMPLETE("0100001","操作成功"),
	DELETE_COMPLETE("0100002","删除成功"),
	ADD_COMPLETE("0100003","新增成功"),
	UPDATE_COMPLETE("0100004","更新成功");

	/** The code. */
	private final String code;

	/** The message. */
	private final String message;

	/**
	 * Instantiates a new error type.
	 *
	 * @param code
	 *            the code
	 * @param message
	 *            the message
	 */
	private SUCCESSMSG(String code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * Gets the code.
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Gets the message.
	 * 
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}