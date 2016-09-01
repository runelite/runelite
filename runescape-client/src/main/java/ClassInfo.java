import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hr")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("l")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("j")
   public int[] field3177;
   @ObfuscatedName("z")
   public int[] field3179;
   @ObfuscatedName("i")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("b")
   public int[] field3181;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 548257821
   )
   public int field3182;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1907926765
   )
   public int field3184;
}
