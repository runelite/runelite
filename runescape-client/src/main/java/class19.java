import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
final class class19 implements Comparator {
   @ObfuscatedName("rj")
   static class291 field337;
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = -794911601
   )
   @Export("baseX")
   static int baseX;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-59949622"
   )
   int method150(class14 var1, class14 var2) {
      return var1.field291 < var2.field291?-1:(var2.field291 == var1.field291?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method150((class14)var1, (class14)var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-838652791"
   )
   public static boolean method160(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "241220468"
   )
   public static void method162(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method162(var0, var1, var2, var5 - 1);
         method162(var0, var1, var5 + 1, var3);
      }

   }
}
