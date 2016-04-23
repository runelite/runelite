import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class135 {
   @ObfuscatedName("h")
   public static File field2063;
   @ObfuscatedName("m")
   static Hashtable field2064 = new Hashtable(16);
   @ObfuscatedName("j")
   public static boolean field2065 = false;
   @ObfuscatedName("nj")
   static class55 field2066;
   @ObfuscatedName("bx")
   static class168 field2069;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-339467891"
   )
   static final int method2844() {
      if(class4.field75.field145) {
         return class28.field655;
      } else {
         int var0 = class148.method3106(class122.field1991, class24.field603, class28.field655);
         return var0 - class115.field1952 < 800 && (class5.field84[class28.field655][class122.field1991 >> 7][class24.field603 >> 7] & 4) != 0?class28.field655:3;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "-788730225"
   )
   static final int method2845(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class91.field1572[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "-472273110"
   )
   public static String method2846(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < var2 + 0; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2637[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[1 + var4] & 255;
            var3.append(class161.field2637[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class161.field2637[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2637[var7 & 63]);
            } else {
               var3.append(class161.field2637[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2637[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }
}
