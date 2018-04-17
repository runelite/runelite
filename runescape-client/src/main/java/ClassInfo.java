import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lf")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -118365863
   )
   public int field3947;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -363288857
   )
   @Export("count")
   public int count;
   @ObfuscatedName("t")
   @Export("type")
   public int[] type;
   @ObfuscatedName("d")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("h")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("z")
   public int[] field3951;
   @ObfuscatedName("i")
   @Export("methods")
   public Method[] methods;
}
