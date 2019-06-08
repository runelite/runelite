package api.vars;

/**
 * An enumeration of possible account types.
 */
public enum AccountType
{
	/**
	 * Normal account type.
	 */
	NORMAL,
	/**
	 * Ironman account type.
	 */
	IRONMAN,
	/**
	 * Ultimate ironman account type.
	 */
	ULTIMATE_IRONMAN,
	/**
	 * Hardcore ironman account type.
	 */
	HARDCORE_IRONMAN;

	/**
	 * Checks whether this type is an ironman.
	 *
	 * @return {@code true} if the type is any of the ironman types.
	 */
	public boolean isIronman()
	{
		return this.ordinal() >= IRONMAN.ordinal() && this.ordinal() <= HARDCORE_IRONMAN.ordinal();
	}

}