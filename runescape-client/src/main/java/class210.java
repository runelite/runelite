import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hf")
@Implements("ClassInfo")
public class class210 extends class208 {
   @ObfuscatedName("g")
   public int[] field3130;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -722582225
   )
   public int field3131;
   @ObfuscatedName("r")
   public int[] field3132;
   @ObfuscatedName("z")
   @Export("fields")
   public Field[] field3133;
   @ObfuscatedName("h")
   public int[] field3134;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1533406335
   )
   public int field3135;
   @ObfuscatedName("f")
   @Export("methods")
   public Method[] field3136;
   @ObfuscatedName("s")
   @Export("args")
   public byte[][][] field3137;
}
