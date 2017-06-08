import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public abstract class class9 extends Node {
   @ObfuscatedName("fx")
   static byte[][] field248;
   @ObfuscatedName("rq")
   static GarbageCollectorMXBean field251;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1644713427
   )
   static int field253;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1699185912"
   )
   abstract void vmethod62();

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-1064499354"
   )
   public static void method59(IndexDataBase var0, String var1, String var2, int var3, boolean var4) {
      int var5 = var0.method4141(var1);
      int var6 = var0.method4209(var5, var2);
      class182.method3430(var0, var5, var6, var3, var4);
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static final String method60(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class60.method996('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class60.method996(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class60.method996(16776960) + var1 + "</col>");
   }
}
