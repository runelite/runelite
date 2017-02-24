import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hi")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("h")
   public int[] field3235;
   @ObfuscatedName("c")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -986266567
   )
   public int field3237;
   @ObfuscatedName("p")
   public int[] field3238;
   @ObfuscatedName("j")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("n")
   public int[] field3240;
   @ObfuscatedName("r")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1345827995
   )
   public int field3242;
}
