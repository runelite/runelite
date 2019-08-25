package net.runelite.injector.raw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.runelite.asm.Field;
import net.runelite.asm.Method;
import net.runelite.asm.attributes.Code;
import net.runelite.asm.attributes.code.Instruction;
import net.runelite.asm.attributes.code.InstructionType;
import net.runelite.asm.attributes.code.Instructions;
import net.runelite.asm.attributes.code.instruction.types.LVTInstruction;
import net.runelite.asm.attributes.code.instructions.ALoad;
import net.runelite.asm.attributes.code.instructions.ArrayStore;
import net.runelite.asm.attributes.code.instructions.GetField;
import net.runelite.asm.attributes.code.instructions.GetStatic;
import net.runelite.asm.attributes.code.instructions.IALoad;
import net.runelite.asm.attributes.code.instructions.IAStore;
import net.runelite.asm.attributes.code.instructions.ILoad;
import net.runelite.asm.attributes.code.instructions.IOr;
import net.runelite.asm.attributes.code.instructions.ISub;
import net.runelite.asm.attributes.code.instructions.InvokeStatic;
import net.runelite.asm.attributes.code.instructions.LDC;
import net.runelite.asm.execution.Execution;
import net.runelite.asm.execution.InstructionContext;
import net.runelite.asm.pool.Class;
import net.runelite.asm.signature.Signature;
import net.runelite.injector.Inject;
import static net.runelite.injector.InjectUtil.findDeobField;
import static net.runelite.injector.InjectUtil.findStaticMethod;
import net.runelite.injector.InjectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RasterizerHook
{
	// TODO: Should probably make this better
	private static final Logger logger = LoggerFactory.getLogger(ClearColorBuffer.class);
	private static final int val = -16777216;

	private static final String font_alpha = "AbstractFont_placeGlyphAlpha";
	private static final String circle_alpha = "Rasterizer2D_drawCircleAlpha";
	private static final String line_alpha = "Rasterizer2D_drawHorizontalLineAlpha";
	private static final String line_alpha2 = "Rasterizer2D_drawVerticalLineAlpha";
	private static final String fill_rect_alpha = "Rasterizer2D_fillRectangleAlpha";
	private static final String r3d_vert = "Rasterizer3D_vertAlpha";
	private static final String r3d_horiz = "Rasterizer3D_horizAlpha";
	private static final String r3d_field = "Rasterizer3D_alpha";
	private static final String sprite_alpha1 = "Sprite_drawTransparent";
	private static final String sprite_alpha2 = "Sprite_drawTransScaled";

	private static final String font = "AbstractFont_placeGlyph";
	private static final String rast3D = "Rasterizer3D_iDontKnow";
	private static final String rast3D2 = "Rasterizer3D_textureAlpha";
	private static final String sprite = "Sprite_draw";
	private static final String sprite2 = "Sprite_drawScaled";
	private static final String sprite3 = "Sprite_drawTransOverlay";
	private static final String sprite4 = "Sprite_drawTransBg";
	private static final String indexedSprite = "IndexedSprite_something";
	private static final String indexedSprite2 = "IndexedSprite_two";

	private static final net.runelite.asm.pool.Method drawAlpha = new net.runelite.asm.pool.Method(
		new Class("client"),
		"drawAlpha",
		new Signature("([IIII)V")
	);
	private final Inject inject;
	private int count;

	public RasterizerHook(Inject inject)
	{
		this.inject = inject;
	}

	public void inject() throws InjectionException
	{
		runDrawAlpha();

		logger.info("Injected {} drawAlpha's", count);
		assert count == 35 : "Either too many or not enough drawAlpha's were injected";

		count = 0;

		runVars();

		run();
	}

	private void runDrawAlpha() throws InjectionException
	{
		runR3DAlpha(r3d_horiz, 15, r3d_field);
		runR3DAlpha(r3d_vert, 12, r3d_field);
		runFontAlpha(font_alpha, 1, 9); // speshul cause 255 - var9
		runAlpha(circle_alpha, 2, 4);
		runAlpha(line_alpha, 1, 4);
		runAlpha(line_alpha2, 1, 4);
		runAlpha(fill_rect_alpha, 1, 5);
		runAlpha(sprite_alpha1, 1, 9, 0);
		runAlpha(sprite_alpha2, 1, 12, 0);
	}

	private void runR3DAlpha(String methodName, int req, String fieldName) throws InjectionException
	{
		Method meth = findStaticMethod(inject, methodName);
		Field field = findDeobField(inject, fieldName);
		Instructions ins = meth.getCode().getInstructions();
		int varIdx = 0; // This is obviously dumb but I cba making this better
		int added = 0;

		List<Integer> indices = new ArrayList<>();
		for (Instruction i : meth.findLVTInstructionsForVariable(varIdx))
		{
			indices.add(ins.getInstructions().indexOf(i));
		}

		if (indices.isEmpty())
		{
			throw new InjectionException("Couldn't find hook location in " + methodName);
		}

		for (int i : indices)
		{
			for (int codeIndex = i + added; codeIndex < ins.getInstructions().size(); codeIndex++)
			{
				if (ins.getInstructions().get(codeIndex) instanceof IAStore)
				{
					ins.getInstructions().set(codeIndex, new InvokeStatic(ins, drawAlpha));

					ins.getInstructions().add(codeIndex, new ISub(ins, InstructionType.ISUB));
					ins.getInstructions().add(codeIndex, new GetStatic(ins, field.getPoolField()));
					ins.getInstructions().add(codeIndex, new LDC(ins, 255));
					added++;
					count++;
					break;
				}
			}
		}
	}

	private void runAlpha(String methodName, int req, int extraArg) throws InjectionException
	{
		runAlpha(methodName, req, extraArg, -1);
	}

	private void runAlpha(String methodName, int req, int extraArg, int varIndex) throws InjectionException
	{
		final net.runelite.asm.pool.Field pixels = findDeobField(inject, "Rasterizer2D_pixels").getPoolField();
		Method meth = findStaticMethod(inject, methodName);
		if (meth == null)
		{
			throw new InjectionException(methodName + " couldnt be found");
		}

		Code code = meth.getCode();
		Instructions ins = code.getInstructions();
		int added = 0;

		List<Integer> indices = new ArrayList<>();
		for (Instruction i : ins.getInstructions())
		{
			if (!(i instanceof IALoad) && !(i instanceof GetField) && !(i instanceof ALoad))
			{
				continue;
			}

			if (i instanceof GetField)
			{
				if (((GetField) i).getField().equals(pixels))
				{
					indices.add(ins.getInstructions().indexOf(i));
				}
			}
			else if ((i instanceof ALoad) && varIndex >= 0 && ((LVTInstruction) i).getVariableIndex() == varIndex)
			{
				indices.add(ins.getInstructions().indexOf(i));
			}
			else if (varIndex == -1)
			{
				indices.add(ins.getInstructions().indexOf(i));
			}
		}

		if (indices.isEmpty())
		{
			throw new InjectionException("Couldn't find hook location in " + methodName);
		}

		int oldCount = count;

		for (int i : indices)
		{
			for (int codeIndex = i + added; codeIndex < ins.getInstructions().size(); codeIndex++)
			{
				if (ins.getInstructions().get(codeIndex) instanceof IAStore)
				{
					ins.getInstructions().set(codeIndex, new InvokeStatic(ins, drawAlpha));
					if (extraArg != -1)
					{
						ins.getInstructions().add(codeIndex, new ILoad(ins, extraArg));
						added++;
					}
					count++;
					break;
				}
			}
		}

		if (count - oldCount > req)
		{
			throw new InjectionException("Too many drawAlpha's were injected into " + methodName);
		}
	}

	private void runFontAlpha(String methodName, int req, int extraArg) throws InjectionException
	{
		Method meth = findStaticMethod(inject, methodName);
		Instructions ins = meth.getCode().getInstructions();
		int varIdx = 0; // This is obviously dumb but I cba making this better
		int added = 0;

		List<Integer> indices = new ArrayList<>();
		for (Instruction i : meth.findLVTInstructionsForVariable(varIdx))
		{
			indices.add(ins.getInstructions().indexOf(i));
		}

		if (indices.isEmpty())
		{
			throw new InjectionException("Couldn't find hook location in " + methodName);
		}

		int oldCount = count;

		for (int i : indices)
		{
			for (int codeIndex = i + added; codeIndex < ins.getInstructions().size(); codeIndex++)
			{
				if (ins.getInstructions().get(codeIndex) instanceof IAStore)
				{
					ins.getInstructions().set(codeIndex, new InvokeStatic(ins, drawAlpha));

					ins.getInstructions().add(codeIndex, new ISub(ins, InstructionType.ISUB));
					ins.getInstructions().add(codeIndex, new ILoad(ins, extraArg));
					ins.getInstructions().add(codeIndex, new LDC(ins, 255));
					added++;
					count++;
					break;
				}
			}
		}

		if (count - req != oldCount)
		{
			throw new InjectionException(req != oldCount ? req > count - oldCount ? "Not enough" : "Too many" : "No" + " drawAlpha's were injected into " + methodName);
		}
	}

	private void runVars() throws InjectionException
	{
		runOnMethodWithVar(rast3D, 0);
		runOnMethodWithVar(rast3D2, 0);
		// 36 expected
		runOnMethodWithVar(font, 0);
		// 5 expected
		runOnMethodWithVar(sprite, 1);
		runOnMethodWithVar(sprite2, 0);
		runOnMethodWithVar(sprite3, 0);
		runOnMethodWithVar(sprite4, 0);
		// 12 expected
		runOnMethodWithVar(indexedSprite, 0);
		runOnMethodWithVar(indexedSprite2, 0);
		// 6 expected
	}

	private void run() throws InjectionException
	{
		final int startCount = count; // Cause you can't just count shit ty
		final net.runelite.asm.pool.Field pixels = findDeobField(inject, "Rasterizer2D_pixels").getPoolField();

		Execution ex = new Execution(inject.getVanilla());
		ex.populateInitialMethods();

		Set<Instruction> done = new HashSet<>();
		ex.addExecutionVisitor((InstructionContext ic) ->
		{
			Instruction i = ic.getInstruction();
			Instructions ins = i.getInstructions();
			Code code = ins.getCode();
			Method method = code.getMethod();
			//logger.debug(i.toString());

			if (!(i instanceof IAStore))
			{
				return;
			}

			if (!done.add(i))
			{
				return;
			}

			ArrayStore as = (ArrayStore) i;
			Field fieldBeingSet = as.getMyField(ic);

			if (fieldBeingSet == null)
			{
				return;
			}

			if (!fieldBeingSet.getPoolField().equals(pixels))
			{
				return;
			}

			int index = ins.getInstructions().indexOf(i);

			if (!(ins.getInstructions().get(index - 1) instanceof ILoad) && !ic.getPops().get(0).getValue().isUnknownOrNull())
			{
				if ((int) ic.getPops().get(0).getValue().getValue() == 0)
				{
					logger.debug("Didn't add hook in method {}.{}. {} added, {} total, value 0", method.getClassFile().getClassName(), method.getName(), count - startCount, count);
					return;
				}
			}

			ins.getInstructions().add(index, new IOr(ins, InstructionType.IOR)); // Add instructions backwards
			ins.getInstructions().add(index, new LDC(ins, val));
			count++;
			logger.debug("Added hook in method {}.{}. {} added, {} total", method.getClassFile().getClassName(), method.getName(), count - startCount, count);
		});

		ex.run();
	}

	private void runOnMethodWithVar(String meth, int varIndex) throws InjectionException
	{
		Method method = findStaticMethod(inject, meth);

		Instructions ins = method.getCode().getInstructions();
		List<Integer> indices = new ArrayList<>();

		for (Instruction i : method.findLVTInstructionsForVariable(varIndex))
		{
			int index = ins.getInstructions().indexOf(i);

			assert index != -1;
			assert ins.getInstructions().get(index + 1) instanceof ILoad; // Index in the array

			indices.add(index);
		}

		int added = 0;
		for (int i : indices)
		{
			for (int codeIndex = i + added; codeIndex < ins.getInstructions().size(); codeIndex++)
			{
				if (ins.getInstructions().get(codeIndex) instanceof IAStore)
				{
					added += 2;
					count++;
					ins.addInstruction(codeIndex, new IOr(ins, InstructionType.IOR)); // Add instructions backwards
					ins.addInstruction(codeIndex, new LDC(ins, val));
					break;
				}
			}
		}

		logger.info("Added {} instructions in {}. {} total", added >>> 1, meth, count);
	}
}
