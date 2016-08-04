import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class117 {
   @ObfuscatedName("b")
   @Export("worldServersDownload")
   static class18 field2027;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "620347252"
   )
   public static int method2559(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILclass137;Lclass171;B)V",
      garbageValue = "-21"
   )
   static void method2560(int var0, class137 var1, class171 var2) {
      byte[] var3 = null;
      class202 var4 = class173.field2765;
      synchronized(class173.field2765) {
         for(class172 var5 = (class172)class173.field2765.method3980(); null != var5; var5 = (class172)class173.field2765.method3970()) {
            if((long)var0 == var5.field3175 && var5.field2759 == var1 && var5.field2757 == 0) {
               var3 = var5.field2755;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3483(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.method3016(var0);
         var2.method3483(var1, var0, var8, true);
      }
   }
}
