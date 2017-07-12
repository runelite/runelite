import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class175 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 7188078096859727099L
   )
   static long field2417;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -5834433591966955239L
   )
   static long field2418;

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-102716775"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class24.method162(var0, var1, var2, var3, var4, var5, false);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-32"
   )
   static final int method3348(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + (var3 * (var0 & 16711935) + (var1 & 16711935) * var2 & -16711936) >> 8;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;B)V",
      garbageValue = "-33"
   )
   public static void method3347(IndexDataBase var0) {
      Enum.field3409 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1715828254"
   )
   public static void method3346(IndexDataBase var0) {
      class244.field3324 = var0;
   }
}
