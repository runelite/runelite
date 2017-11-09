import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class232 {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;IIB)Ljt;",
      garbageValue = "-20"
   )
   public static Font method4242(IndexDataBase var0, IndexDataBase var1, int var2, int var3) {
      return !class72.method1184(var0, var2, var3)?null:class273.method5019(var1.getConfigData(var2, var3));
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIZIZI)V",
      garbageValue = "1326274237"
   )
   static void method4241(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = Coordinates.worldList[var6];
         Coordinates.worldList[var6] = Coordinates.worldList[var1];
         Coordinates.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = Coordinates.worldList[var9];
            int var12 = class14.method92(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class14.method92(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = Coordinates.worldList[var9];
               Coordinates.worldList[var9] = Coordinates.worldList[var7];
               Coordinates.worldList[var7++] = var14;
            }
         }

         Coordinates.worldList[var1] = Coordinates.worldList[var7];
         Coordinates.worldList[var7] = var8;
         method4241(var0, var7 - 1, var2, var3, var4, var5);
         method4241(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
