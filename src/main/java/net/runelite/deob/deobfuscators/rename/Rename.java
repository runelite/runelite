package net.runelite.deob.deobfuscators.rename;

import edu.ucla.sspace.graph.Graph;
import edu.ucla.sspace.graph.isomorphism.IsomorphismTester;
import edu.ucla.sspace.graph.isomorphism.TypedVF2IsomorphismTester;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.runelite.deob.ClassFile;
import net.runelite.deob.ClassGroup;
import net.runelite.deob.Field;
import net.runelite.deob.Method;
import net.runelite.deob.attributes.code.Instruction;
import net.runelite.deob.attributes.code.instruction.types.InvokeInstruction;
import net.runelite.deob.execution.Execution;
import net.runelite.deob.execution.Frame;
import net.runelite.deob.signature.Signature;
import net.runelite.deob.signature.Type;

public class Rename
{
	public static int hash(Object... objects)
	{
		MessageDigest md;
		try
		{
			md = MessageDigest.getInstance("MD5");
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RuntimeException(ex);
		}
		for (Object o : objects)
			md.update(o.toString().getBytes());
		byte[] b = md.digest();
		
		ByteBuffer buf = ByteBuffer.wrap(b);
		return buf.getInt() ^ buf.getInt() ^ buf.getInt() ^ buf.getInt();
	}
	
	public static int hashType(Type type)
	{
		int dimms = type.getArrayDims();
		String t = type.getType();
		if (t.startsWith("L"))
			t = "class";
		return hash(dimms, t);
	}
	
	public static int fingerprintField(Field f)
	{
		return hashType(f.getType());
	}
	
	private int fingerprintMethod(Method m)
	{
		int type = hashType(m.getNameAndType().getDescriptorType());
		
		Signature sig = m.getDescriptor();
		for (int i = 0; i < sig.size(); ++i)
		{
			Type t = sig.getTypeOfArg(i);
			type ^= hashType(t);
		}
		
		return type;
	}
	
	private int fingerprintClass(ClassFile cf)
	{
		int hash = 0;
		
		ClassFile f = cf.getParent();
		if (f != null)
			hash ^= fingerprintClass(f);
		
		for (ClassFile i : cf.getInterfaces().getMyInterfaces())
			hash ^= fingerprintClass(i);
		
		int count = 0;
		for (Field fi : cf.getFields().getFields())
		{
			if (fi.isStatic())
				continue;
			
			hash ^= fingerprintField(fi) << (count++ % 16);
		}
		
		return hash;
	}
//	private static boolean isExpressionInstruction(Instruction in)
//	{
//		return
//			in instanceof SetFieldInstruction ||
//			(in instanceof LVTInstruction && ((LVTInstruction) in).store()) ||
//			in instanceof InvokeInstruction ||
//			in instanceof ComparisonInstruction;
//	}
//	
//	private static List<Instruction> getExprIns(Frame frame)
//	{
//		return frame.getInstructions().stream().map(i -> i.getInstruction()).filter(i -> isExpressionInstruction(i)).collect(Collectors.toList());
//	}
//	
//	private static boolean equalsFrames(Frame one, Frame two)
//	{
//		List<Instruction> oneIns = getExprIns(one),
//			twoIns = getExprIns(two);
//		
//		if (oneIns.size() != twoIns.size() || oneIns.isEmpty())
//			return false;
//		
//		for (int i = 0; i < oneIns.size(); ++i)
//		{
//			Instruction i1 = oneIns.get(i),
//				i2 = twoIns.get(i);
//			
//			if (i1.getType() != i2.getType())
//				return false;
//		}
//		
//		if (one.getMethod().getName().startsWith("method") && two.getMethod().getName().startsWith("method"))
//		{
//			int i =5;
//		}
//		return true;
//	}
	
	private void printInfo(ClassGroup group)
	{
		int fields = 0, methods = 0;
		for (ClassFile cf : group.getClasses())
		{
			methods += cf.getMethods().getMethods().stream().filter(m -> !m.isStatic()).count();
			fields += cf.getFields().getFields().stream().filter(f -> !f.isStatic()).count();
		}
		System.out.println("Classes: " + group.getClasses().size() + " fields " + fields + " methods " + methods);
	}
	
	public void run(ClassGroup one, ClassGroup two)
	{
		Execution eone = new Execution(one);
		eone.populateInitialMethods();
		eone.run();
		
		Execution etwo = new Execution(two);
		etwo.populateInitialMethods();
		etwo.run();
		
		List<Frame> f1 = eone.processedFrames.stream().filter(f -> f.getMethod() == one.findClass("client").findMethod("init")).collect(Collectors.toList());
		List<Frame> f2 = etwo.processedFrames.stream().filter(f -> f.getMethod() == two.findClass("client").findMethod("init")).collect(Collectors.toList());
		
		Frame ff1 = f1.get(0), ff2 = f2.get(0);
		
		Graph g1 = ff1.getGraph(), g2 = ff2.getGraph();
		
		IsomorphismTester isoTest = new TypedVF2IsomorphismTester();
		System.out.println(isoTest.areIsomorphic(g1, g2));
		
		Map<Integer, Integer> mapping = isoTest.findIsomorphism(g1, g2);
		Map<Integer, Instruction> map1 = ff1.getIdMap(), map2 = ff2.getIdMap();
		
		for (Entry<Integer, Integer> e : mapping.entrySet())
		{
			if (e.getKey() == null || e.getValue() == null)
			{
				assert e.getKey() == e.getValue();
				continue;
			}
			
			Instruction i1 = map1.get(e.getKey());
			Instruction i2 = map2.get(e.getValue());
			
			assert i1.getClass() == i2.getClass();
			
			InvokeInstruction ii1 = (InvokeInstruction) i1, ii2 = (InvokeInstruction) i2;
			System.out.println("MATCH " + ii1.getMethods().get(0).getName() + " -> " + ii2.getMethods().get(0).getName());
		}
		
		System.out.print(eone);
//		for (ClassFile cf : one.getClasses())
//		{
//			if (!cf.getFields().getFields().stream().anyMatch(f -> !f.isStatic()))
//				continue;
//			
//			ClassInfo info = new ClassInfo(cf);
//			info.build();
//			
//			for (ClassFile cf2 : two.getClasses())
//			{
//				if (!cf2.getFields().getFields().stream().anyMatch(f -> !f.isStatic()))
//				{
//					continue;
//				}
//				
//				ClassInfo info2 = new ClassInfo(cf2);
//				info2.build();
//				
//				if (info.equals(info2))
//				{
//					System.out.println("cl match " + cf.getName() + " -> " + cf2.getName());
//				}
//			}
//		}
//		GraphInfo graphOne = new GraphInfo(one);
//		graphOne.populate();
//		
//		GraphInfo graphTwo = new GraphInfo(two);
//		graphTwo.populate();
//		
//		//Map<Integer, Integer> mapping = new HashMap<>();
//		
////		for (ClassFile cf : one.getClasses())
////		{
////			ClassFile cf2 = two.findClass(cf.getName());
////			assert cf2 != null;
////			mapping.put(graphOne.getIds().toId(cf), graphTwo.getIds().toId(cf2));
////		}
////		
//		//graphOne.getGraph().
//		System.out.println(graphOne.getGraph().size());
//		System.out.println(graphTwo.getGraph().size());
//		
//		printInfo(one);
//		printInfo(two);
//		
//		//graphOne.getGraph().
//		
//		IsomorphismTester isoTest = new TypedVF2IsomorphismTester();
//		System.out.println(isoTest.areIsomorphic(graphOne.getGraph(), graphTwo.getGraph()));
//		Execution ex1 = new Execution(one);
//		ex1.populateInitialMethods();
//		ex1.run();
//		
//		Execution ex2 = new Execution(two);
//		ex2.populateInitialMethods();
//		ex2.run();
//		
//		for (Frame f : ex1.processedFrames)
//			for (Frame f2 : ex2.processedFrames)
//			{
//				if (f.getMethod().getName().equals("vmethod2976") && f2.getMethod().getName().equals("method3115"))
//				{
//					if (equalsFrames(f, f2))
//						System.out.println(f.getMethod().getName() + " " + f2.getMethod().getName());
//				}
//			}
	}
}
