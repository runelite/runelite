import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class47 {
   @ObfuscatedName("ep")
   @ObfuscatedGetter(
      intValue = 269992007
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1205565233
   )
   static int field608;
   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexModels")
   static IndexData indexModels;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexedSprite field601;
   @ObfuscatedName("gc")
   @ObfuscatedGetter(
      intValue = -1999600263
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2106419741
   )
   public int field611;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public Coordinates field602;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   public Coordinates field609;

   @ObfuscatedSignature(
      signature = "(ILhh;Lhh;)V"
   )
   public class47(int var1, Coordinates var2, Coordinates var3) {
      this.field611 = var1;
      this.field602 = var2;
      this.field609 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-118"
   )
   @Export("setItemTableSlot")
   static void setItemTableSlot(int var0, int var1, int var2, int var3) {
      XItemContainer var4 = (XItemContainer)XItemContainer.itemContainers.get((long)var0);
      if(var4 == null) {
         var4 = new XItemContainer();
         XItemContainer.itemContainers.put(var4, (long)var0);
      }

      if(var4.itemIds.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.itemIds.length; ++var7) {
            var5[var7] = var4.itemIds[var7];
            var6[var7] = var4.stackSizes[var7];
         }

         for(var7 = var4.itemIds.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.itemIds = var5;
         var4.stackSizes = var6;
      }

      var4.itemIds[var1] = var2;
      var4.stackSizes[var1] = var3;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(Lcr;B)V",
      garbageValue = "20"
   )
   static final void method737(Actor var0) {
      if(var0.field1230 != 0) {
         if(var0.interacting != -1) {
            Object var1 = null;
            if(var0.interacting < '耀') {
               var1 = Client.cachedNPCs[var0.interacting];
            } else if(var0.interacting >= '耀') {
               var1 = Client.cachedPlayers[var0.interacting - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.x - ((Actor)var1).x;
               int var3 = var0.y - ((Actor)var1).y;
               if(var2 != 0 || var3 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field1245) {
               var0.interacting = -1;
               var0.field1245 = false;
            }
         }

         if(var0.field1246 != -1 && (var0.queueSize == 0 || var0.field1276 > 0)) {
            var0.orientation = var0.field1246;
            var0.field1246 = -1;
         }

         int var4 = var0.orientation - var0.angle & 2047;
         if(var4 == 0 && var0.field1245) {
            var0.interacting = -1;
            var0.field1245 = false;
         }

         if(var4 != 0) {
            ++var0.field1247;
            boolean var6;
            if(var4 > 1024) {
               var0.angle -= var0.field1230;
               var6 = true;
               if(var4 < var0.field1230 || var4 > 2048 - var0.field1230) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1247 > 25 || var6)) {
                  if(var0.field1241 != -1) {
                     var0.poseAnimation = var0.field1241;
                  } else {
                     var0.poseAnimation = var0.field1226;
                  }
               }
            } else {
               var0.angle += var0.field1230;
               var6 = true;
               if(var4 < var0.field1230 || var4 > 2048 - var0.field1230) {
                  var0.angle = var0.orientation;
                  var6 = false;
               }

               if(var0.idlePoseAnimation == var0.poseAnimation && (var0.field1247 > 25 || var6)) {
                  if(var0.field1225 != -1) {
                     var0.poseAnimation = var0.field1225;
                  } else {
                     var0.poseAnimation = var0.field1226;
                  }
               }
            }

            var0.angle &= 2047;
         } else {
            var0.field1247 = 0;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Lik;",
      garbageValue = "683685782"
   )
   public static class253 method738(int var0) {
      class253 var1 = (class253)class253.field3382.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class253.field3385.getConfigData(34, var0);
         var1 = new class253();
         if(var2 != null) {
            var1.method4473(new Buffer(var2));
         }

         var1.method4475();
         class253.field3382.put(var1, (long)var0);
         return var1;
      }
   }
}
