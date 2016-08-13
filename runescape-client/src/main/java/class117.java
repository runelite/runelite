import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class117 {
   @ObfuscatedName("b")
   @Export("worldServersDownload")
   static class18 worldServersDownload;

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
      Deque var4 = class173.field2765;
      Deque var5 = class173.field2765;
      synchronized(class173.field2765) {
         for(class172 var6 = (class172)class173.field2765.method3980(); null != var6; var6 = (class172)class173.field2765.method3970()) {
            if((long)var0 == var6.hash && var6.field2759 == var1 && var6.field2757 == 0) {
               var3 = var6.field2755;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method3483(var1, var0, var3, true);
      } else {
         byte[] var9 = var1.method3016(var0);
         var2.method3483(var1, var0, var9, true);
      }

   }
}
