import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class170 {
   @ObfuscatedName("gm")
   static Widget field2345;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1596643659
   )
   public static int field2346;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -892393279
   )
   public static int field2347;
   @ObfuscatedName("j")
   static int[] field2349;

   @ObfuscatedName("ed")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-1788272709"
   )
   static int method3147(Widget var0) {
      class133 var1 = (class133)Client.widgetFlags.method2274((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.field1901:var0.field2281;
   }
}
