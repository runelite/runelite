package net.runelite.asm;

import java.util.Iterator;
import net.runelite.asm.attributes.Annotations;
import net.runelite.asm.attributes.annotation.Annotation;
import org.jetbrains.annotations.NotNull;

public interface Annotated extends Iterable<Annotation>
{
	Annotations getAnnotations();

	@NotNull
	default Iterator<Annotation> iterator()
	{
		return getAnnotations().iterator();
	}
}
