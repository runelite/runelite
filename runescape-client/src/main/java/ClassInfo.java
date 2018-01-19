import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ka")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -29682327
   )
   public int field3821;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 513477631
   )
   @Export("count")
   public int count;
   @ObfuscatedName("y")
   @Export("type")
   public int[] type;
   @ObfuscatedName("r")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("h")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("d")
   public int[] field3825;
   @ObfuscatedName("s")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("b")
   @Export("args")
   public byte[][][] args;
}
