package net.runelite.deob.attributes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Unknown extends Attribute
{
	private byte[] data;

	public Unknown(Attributes attributes) throws IOException
	{
		super(attributes, AttributeType.UNKNOWN);

		int len = this.getLength();
		DataInputStream is = attributes.getStream();

		data = new byte[len];

		int read = 0;
		while (read < len)
		{
			int i = is.read(data, read, len - read);

			if (i < 0)
				throw new IOException("EOF");

			read += i;
		}

		assert read == len;
	}

	@Override
	public void writeAttr(DataOutputStream out) throws IOException
	{
		out.write(data);
	}
}
