import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hl")
@Implements("ClassInfo")
public class class210 extends class208 {
   @ObfuscatedName("s")
   public int[] field3119;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1455138637
   )
   public int field3120;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 921039099
   )
   public int field3121;
   @ObfuscatedName("p")
   public int[] field3122;
   @ObfuscatedName("h")
   @Export("fields")
   public Field[] field3123;
   @ObfuscatedName("f")
   public int[] field3124;
   @ObfuscatedName("g")
   @Export("methods")
   public Method[] field3125;
   @ObfuscatedName("a")
   @Export("args")
   public byte[][][] field3126;
}
