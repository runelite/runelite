import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("ClassInfo")
public class class210 extends class208 {
   @ObfuscatedName("c")
   int[] field3127;
   @ObfuscatedName("r")
   @Export("methods")
   Method[] field3128;
   @ObfuscatedName("d")
   int[] field3129;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1693199609
   )
   int field3130;
   @ObfuscatedName("y")
   @Export("fields")
   Field[] field3131;
   @ObfuscatedName("k")
   int[] field3132;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1825780175
   )
   int field3133;
   @ObfuscatedName("p")
   @Export("args")
   byte[][][] field3134;
   @ObfuscatedName("s")
   public static String field3135;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "-445031302"
   )
   public static class173 method4010(int var0, int var1) {
      class173 var2 = class20.method641(var0);
      return -1 == var1?var2:(var2 != null && null != var2.field2867 && var1 < var2.field2867.length?var2.field2867[var1]:null);
   }
}
