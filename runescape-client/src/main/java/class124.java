import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public class class124 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "317019313"
   )
   public static String method2807(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "0"
   )
   public static boolean method2813(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;III)Lclass224;",
      garbageValue = "-1542798015"
   )
   public static class224 method2814(class167 var0, class167 var1, int var2, int var3) {
      if(!class94.method2227(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3286(var2, var3);
         class224 var4;
         if(var5 == null) {
            var4 = null;
         } else {
            class224 var6 = new class224(var5, class76.field1397, class52.field1178, class28.field690, class31.field744, class7.field135, class76.field1400);
            class33.method749();
            var4 = var6;
         }

         return var4;
      }
   }
}
