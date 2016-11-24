import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class227 {
   @ObfuscatedName("n")
   static class126 field3232 = new class126();

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)V",
      garbageValue = "71"
   )
   static final void method4318(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = class84.field1444[var6];
         var12 = class84.field1445[var6];
         var13 = var12 * var9 - var5 * var11 >> 16;
         var10 = var5 * var12 + var9 * var11 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = class84.field1444[var7];
         var12 = class84.field1445[var7];
         var13 = var11 * var10 + var12 * var8 >> 16;
         var10 = var12 * var10 - var8 * var11 >> 16;
         var8 = var13;
      }

      XGrandExchangeOffer.cameraX = var0 - var8;
      Client.cameraZ = var1 - var9;
      Client.cameraY = var2 - var10;
      class40.cameraPitch = var3;
      class104.cameraYaw = var4;
   }
}
