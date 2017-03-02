import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class149 {
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = -1511751807
   )
   static int field2026;
   @ObfuscatedName("o")
   static int[][][] field2027;
   @ObfuscatedName("pc")
   static short[] field2033;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LSpritePixels;",
      garbageValue = "1967435340"
   )
   public static SpritePixels[] method2823(class182 var0, String var1, String var2) {
      int var3 = var0.method3363(var1);
      int var4 = var0.method3407(var3, var2);
      return WidgetNode.method199(var0, var3, var4);
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   static boolean method2824(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }

   class149() throws Throwable {
      throw new Error();
   }
}
