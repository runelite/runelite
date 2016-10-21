import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
public class class10 extends class110 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "-790374412"
   )
   protected boolean vmethod2401(int var1, int var2, int var3, CollisionData var4) {
      return super.field1938 == var2 && super.field1935 == var3;
   }

   @ObfuscatedName("dz")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass178;I)V",
      garbageValue = "-608237629"
   )
   static final void method123(int var0, int var1, int var2, int var3, SpritePixels var4, class178 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapScale + Client.mapAngle & 2047;
         int var8 = class94.field1635[var7];
         int var9 = class94.field1646[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (Client.mapScaleDelta + 256);
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var9 * var3 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         ObjectComposition.field972.method1774(var0 + 94 + var14 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class18.method194(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-22"
   )
   public static boolean method124(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "329305653"
   )
   static final void method125(Actor var0) {
      if(var0.field869 != 0) {
         if(var0.interacting != -1) {
            Object var4 = null;
            if(var0.interacting < '耀') {
               var4 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var4 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(null != var4) {
               int var2 = var0.x - ((Actor)var4).x;
               int var3 = var0.y - ((Actor)var4).y;
               if(var2 != 0 || var3 != 0) {
                  var0.field873 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field877) {
               var0.interacting = -1;
               var0.field877 = false;
            }
         }

         if(var0.field844 != -1 && (var0.field867 == 0 || var0.field872 > 0)) {
            var0.field873 = var0.field844;
            var0.field844 = -1;
         }

         int var1 = var0.field873 - var0.angle & 2047;
         if(var1 == 0 && var0.field877) {
            var0.interacting = -1;
            var0.field877 = false;
         }

         if(var1 != 0) {
            ++var0.field868;
            boolean var6;
            if(var1 > 1024) {
               var0.angle -= var0.field869;
               var6 = true;
               if(var1 < var0.field869 || var1 > 2048 - var0.field869) {
                  var0.angle = var0.field873;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field868 > 25 || var6)) {
                  if(var0.field847 != -1) {
                     var0.poseAnimation = var0.field847;
                  } else {
                     var0.poseAnimation = var0.field824;
                  }
               }
            } else {
               var0.angle += var0.field869;
               var6 = true;
               if(var1 < var0.field869 || var1 > 2048 - var0.field869) {
                  var0.angle = var0.field873;
                  var6 = false;
               }

               if(var0.poseAnimation == var0.idlePoseAnimation && (var0.field868 > 25 || var6)) {
                  if(var0.field823 != -1) {
                     var0.poseAnimation = var0.field823;
                  } else {
                     var0.poseAnimation = var0.field824;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field868 = 0;
         }

      }
   }
}
