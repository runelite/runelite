import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("lp")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1705738965
   )
   public int field3948;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1237507683
   )
   @Export("count")
   public int count;
   @ObfuscatedName("o")
   @Export("type")
   public int[] type;
   @ObfuscatedName("j")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("k")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("x")
   public int[] field3947;
   @ObfuscatedName("z")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("p")
   @Export("args")
   public byte[][][] args;
}
