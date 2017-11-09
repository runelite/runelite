import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("kr")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1588656449
   )
   public int field3798;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1991497775
   )
   @Export("count")
   public int count;
   @ObfuscatedName("j")
   @Export("type")
   public int[] type;
   @ObfuscatedName("v")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("x")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("e")
   public int[] field3803;
   @ObfuscatedName("l")
   @Export("methods")
   public Method[] methods;
}
