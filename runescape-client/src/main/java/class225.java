import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class225 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "-512283144"
   )
   static void method3965(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var10 = World.worldList[var9];
            int var11 = class9.method53(var10, var8, var2, var3);
            int var12;
            if(var11 != 0) {
               if(var3) {
                  var12 = -var11;
               } else {
                  var12 = var11;
               }
            } else if(var4 == -1) {
               var12 = 0;
            } else {
               int var13 = class9.method53(var10, var8, var4, var5);
               if(var5) {
                  var12 = -var13;
               } else {
                  var12 = var13;
               }
            }

            if(var12 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method3965(var0, var7 - 1, var2, var3, var4, var5);
         method3965(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
