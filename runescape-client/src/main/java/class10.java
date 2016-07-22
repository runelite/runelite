import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
public class class10 extends class110 {
   @ObfuscatedName("x")
   static byte[][] field151;
   @ObfuscatedName("h")
   public static class183 field152;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1115260891
   )
   @Export("cameraYaw")
   static int field155;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILclass111;B)Z",
      garbageValue = "-26"
   )
   protected boolean vmethod2446(int var1, int var2, int var3, class111 var4) {
      return var2 == super.field1940 && super.field1938 == var3;
   }

   @ObfuscatedName("ec")
   @ObfuscatedSignature(
      signature = "(Lclass176;II)Ljava/lang/String;",
      garbageValue = "1582859680"
   )
   static String method127(class176 var0, int var1) {
      return !class151.method3170(class12.method151(var0), var1) && null == var0.field2895?null:(var0.field2812 != null && var0.field2812.length > var1 && null != var0.field2812[var1] && var0.field2812[var1].trim().length() != 0?var0.field2812[var1]:null);
   }
}
