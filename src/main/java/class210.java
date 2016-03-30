import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ho")
@Implements("ClassInfo")
public class class210 extends class208 {
   @ObfuscatedName("p")
   public int[] field3130;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1908447773
   )
   public int field3131;
   @ObfuscatedName("m")
   @Export("args")
   public byte[][][] field3132;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1175544931
   )
   public int field3133;
   @ObfuscatedName("e")
   @Export("fields")
   public Field[] field3134;
   @ObfuscatedName("y")
   public int[] field3135;
   @ObfuscatedName("c")
   @Export("methods")
   public Method[] field3136;
   @ObfuscatedName("t")
   public int[] field3137;
}
