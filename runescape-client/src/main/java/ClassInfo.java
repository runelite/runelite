import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ju")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -594286837
   )
   public int field3741;
   @ObfuscatedName("i")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -101179661
   )
   public int field3743;
   @ObfuscatedName("w")
   public int[] field3744;
   @ObfuscatedName("z")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("j")
   public int[] field3746;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] args;
   @ObfuscatedName("t")
   public int[] field3748;
}
