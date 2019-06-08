package net.runelite.runeloader.inject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.objectweb.asm.tree.AbstractInsnNode;

public class Injection
{
	private static final Gson decoder = (new GsonBuilder()).registerTypeAdapter(AbstractInsnNode.class, new InstructionDeserializer()).create();

	public InjectionModscript resource;

	public static InjectionModscript load(InputStream in)
	{
		return decoder.fromJson(new InputStreamReader(in), Injection.class).resource;
	}
}
