package rest.exception;


public abstract class ShopException extends FmtException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3380804964544248558L;

	public ShopException(String baseName, String errorCode, Object[] params) {
		super(baseName, errorCode, params);
	}
}
