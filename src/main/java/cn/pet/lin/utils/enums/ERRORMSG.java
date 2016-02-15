package cn.pet.lin.utils.enums;

/**
 */
public enum ERRORMSG {

	/**
	 * 参数异常
	 */
	ADD_ERROR("1000001", "添加失败！"),
	PARAM_ISERROR("1000002", "参数错误"),
	PARAM_ISNULL("1000003", "参数不能为空"),
	SINGLE_LOGIN("1000030","单点登录异常"),
	REPEAT_MENU("1000038","菜单名已存在"),
	ENABLE_EXC("1000039","启用异常！"),
	AUTH_NOCACHE_INF("1000040","没有实现IUserAuthCache接口！"),
	AUTH_NOPERMISSION("1000041","抱歉，您没有此操作权限，请联系管理员！");

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
	private ERRORMSG(String code, String message) {
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