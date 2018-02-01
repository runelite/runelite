import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kf")
@Implements("ClassInfo")
public class ClassInfo extends Node {
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1734690351
   )
   public int field3836;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -759987975
   )
   @Export("count")
   public int count;
   @ObfuscatedName("w")
   @Export("type")
   public int[] type;
   @ObfuscatedName("s")
   @Export("errorIdentifiers")
   public int[] errorIdentifiers;
   @ObfuscatedName("j")
   @Export("fields")
   public Field[] fields;
   @ObfuscatedName("a")
   public int[] field3841;
   @ObfuscatedName("t")
   @Export("methods")
   public Method[] methods;
   @ObfuscatedName("r")
   @Export("args")
   public byte[][][] args;
}
