package info.sigterm.deob.attributes.code;

import java.io.DataInputStream;
import java.io.IOException;

class Exception
{
	private Exceptions exceptions;

	private int startPc;
	private int endPc;
	private int handlerPc;
	private int catchType;

	Exception(Exceptions exceptions) throws IOException
	{
		this.exceptions = exceptions;

		DataInputStream is = exceptions.getCode().getAttributes().getStream();

		startPc = is.readUnsignedShort();
		endPc = is.readUnsignedShort();
		handlerPc = is.readUnsignedShort();
		catchType = is.readUnsignedShort();
	}
}
