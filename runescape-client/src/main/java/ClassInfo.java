import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ji")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1680071359
   )
   public int field3749;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1265742163
   )
   @Export("count")
   public int count;
   @ObfuscatedName("r")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("a")
   @Export("type")
   public int[] type;
   @ObfuscatedName("o")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("n")
   public int[] field3748;
   @ObfuscatedName("q")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("b")
   @Export("args")
   public byte[][][] args;
}
