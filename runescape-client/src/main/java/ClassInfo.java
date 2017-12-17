import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kb")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2116971695
   )
   public int field3819;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1480288181
   )
   @Export("count")
   public int count;
   @ObfuscatedName("e")
   @Export("type")
   public int[] type;
   @ObfuscatedName("k")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("u")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("z")
   public int[] field3820;
   @ObfuscatedName("t")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("f")
   @Export("args")
   public byte[][][] args;
}
