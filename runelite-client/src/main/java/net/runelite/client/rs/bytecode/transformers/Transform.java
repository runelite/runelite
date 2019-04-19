package net.runelite.client.rs.bytecode.transformers;

public interface Transform {

	void modify(Class clazz);
	void transform();

}
