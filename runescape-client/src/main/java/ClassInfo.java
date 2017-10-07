import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("js")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -833037437
   )
   public int field3756;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1008687613
   )
   @Export("count")
   public int count;
   @ObfuscatedName("p")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("e")
   @Export("type")
   public int[] type;
   @ObfuscatedName("q")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("s")
   public int[] field3761;
   @ObfuscatedName("r")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("g")
   @Export("args")
   public byte[][][] args;
}
