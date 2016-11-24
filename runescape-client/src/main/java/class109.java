import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public abstract class class109 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1528878866"
   )
   abstract void vmethod2090();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1778689612"
   )
   abstract int vmethod2091(int var1, int var2);

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-592587676"
   )
   public static int method2095(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "7"
   )
   static final void method2100() {
      int var0 = 64 + class49.field948 * 128;
      int var1 = Actor.field652 * 128 + 64;
      int var2 = class11.method161(var0, var1, class166.plane) - class63.field1085;
      if(XGrandExchangeOffer.cameraX < var0) {
         XGrandExchangeOffer.cameraX += Renderable.field1535 + RSCanvas.field1758 * (var0 - XGrandExchangeOffer.cameraX) / 1000;
         if(XGrandExchangeOffer.cameraX > var0) {
            XGrandExchangeOffer.cameraX = var0;
         }
      }

      if(XGrandExchangeOffer.cameraX > var0) {
         XGrandExchangeOffer.cameraX -= Renderable.field1535 + RSCanvas.field1758 * (XGrandExchangeOffer.cameraX - var0) / 1000;
         if(XGrandExchangeOffer.cameraX < var0) {
            XGrandExchangeOffer.cameraX = var0;
         }
      }

      if(Client.cameraZ < var2) {
         Client.cameraZ += (var2 - Client.cameraZ) * RSCanvas.field1758 / 1000 + Renderable.field1535;
         if(Client.cameraZ > var2) {
            Client.cameraZ = var2;
         }
      }

      if(Client.cameraZ > var2) {
         Client.cameraZ -= Renderable.field1535 + (Client.cameraZ - var2) * RSCanvas.field1758 / 1000;
         if(Client.cameraZ < var2) {
            Client.cameraZ = var2;
         }
      }

      if(Client.cameraY < var1) {
         Client.cameraY += Renderable.field1535 + (var1 - Client.cameraY) * RSCanvas.field1758 / 1000;
         if(Client.cameraY > var1) {
            Client.cameraY = var1;
         }
      }

      if(Client.cameraY > var1) {
         Client.cameraY -= Renderable.field1535 + (Client.cameraY - var1) * RSCanvas.field1758 / 1000;
         if(Client.cameraY < var1) {
            Client.cameraY = var1;
         }
      }

      var0 = class145.field2021 * 128 + 64;
      var1 = class37.field787 * 128 + 64;
      var2 = class11.method161(var0, var1, class166.plane) - class143.field2006;
      int var3 = var0 - XGrandExchangeOffer.cameraX;
      int var4 = var2 - Client.cameraZ;
      int var5 = var1 - Client.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class40.cameraPitch < var7) {
         class40.cameraPitch += XItemContainer.field128 + class9.field83 * (var7 - class40.cameraPitch) / 1000;
         if(class40.cameraPitch > var7) {
            class40.cameraPitch = var7;
         }
      }

      if(class40.cameraPitch > var7) {
         class40.cameraPitch -= XItemContainer.field128 + class9.field83 * (class40.cameraPitch - var7) / 1000;
         if(class40.cameraPitch < var7) {
            class40.cameraPitch = var7;
         }
      }

      int var9 = var8 - class104.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class104.cameraYaw += XItemContainer.field128 + class9.field83 * var9 / 1000;
         class104.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class104.cameraYaw -= -var9 * class9.field83 / 1000 + XItemContainer.field128;
         class104.cameraYaw &= 2047;
      }

      int var10 = var8 - class104.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class104.cameraYaw = var8;
      }

   }
}
