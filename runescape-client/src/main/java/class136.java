import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public abstract class class136 {
   @ObfuscatedName("pr")
   static class8 field2123;
   @ObfuscatedName("dd")
   @Export("region")
   static class89 field2126;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public abstract void vmethod3260();

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1964270008"
   )
   abstract int vmethod3261(int var1, int var2);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1378852005"
   )
   static boolean method3002(String var0, int var1) {
      return class14.method178(var0, var1, "openjs");
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(III)Ljava/lang/String;",
      garbageValue = "1385391862"
   )
   static final String method3003(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class16.method205(16711680):(var2 < -6?class16.method205(16723968):(var2 < -3?class16.method205(16740352):(var2 < 0?class16.method205(16756736):(var2 > 9?class16.method205('\uff00'):(var2 > 6?class16.method205(4259584):(var2 > 3?class16.method205(8453888):(var2 > 0?class16.method205(12648192):class16.method205(16776960))))))));
   }
}
