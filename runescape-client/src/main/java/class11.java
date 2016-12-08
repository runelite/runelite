import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class11 {
   @ObfuscatedName("dz")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 359835555
   )
   int field109 = -1;
   @ObfuscatedName("b")
   int[] field110;
   @ObfuscatedName("g")
   String[] field111;
   @ObfuscatedName("o")
   class48 field113;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "677777177"
   )
   static void method144(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method2299((long)var0);
      if(null != var1) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "67"
   )
   static class48 method145(int var0) {
      class48 var1 = (class48)class48.field946.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field2844.method3203(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2731();
            var1.field952 = var3.readUnsignedShort();
            var1.field947 = var3.readUnsignedShort();
            var1.field951 = var3.readUnsignedShort();
            var1.field953 = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2890();
            var1.field950 = new int[var4];
            var1.field948 = new int[var4];
            var1.field949 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field950[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.field949[var5] = var3.method2780();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field948[var5] = var3.method2731();
               } else {
                  var1.field948[var5] = var3.readUnsignedByte();
               }
            }

            class48.field946.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1415215045"
   )
   static final void method146() {
      for(int var0 = 0; var0 < Client.field328; ++var0) {
         int var1 = Client.field384[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field332.readUnsignedByte();
         int var4;
         if((var3 & 32) != 0) {
            var2.graphic = Client.field332.method2751();
            var4 = Client.field332.method2731();
            var2.field654 = var4 >> 16;
            var2.field644 = Client.gameCycle + (var4 & '\uffff');
            var2.field642 = 0;
            var2.field664 = 0;
            if(var2.field644 > Client.gameCycle) {
               var2.field642 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 4) != 0) {
            var2.composition = class30.getNpcDefinition(Client.field332.method2770());
            var2.field612 = var2.composition.field2999;
            var2.field657 = var2.composition.field3011;
            var2.field624 = var2.composition.field3005;
            var2.field640 = var2.composition.field3006;
            var2.field615 = var2.composition.field3007;
            var2.field648 = var2.composition.field3008;
            var2.idlePoseAnimation = var2.composition.field3002;
            var2.field646 = var2.composition.field3003;
            var2.field610 = var2.composition.field3024;
         }

         if((var3 & 2) != 0) {
            var2.overhead = Client.field332.method2780();
            var2.field619 = 100;
         }

         if((var3 & 64) != 0) {
            var2.interacting = Client.field332.method2770();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         int var5;
         int var6;
         if((var3 & 8) != 0) {
            var4 = Client.field332.method2770();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field332.method2892();
            if(var4 == var2.animation && var4 != -1) {
               var6 = class31.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field639 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field626 = 0;
               }

               if(var6 == 2) {
                  var2.field626 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class31.getAnimation(var4).forcedPriority >= class31.getAnimation(var2.animation).forcedPriority) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field639 = 0;
               var2.actionAnimationDisable = var5;
               var2.field626 = 0;
               var2.field663 = var2.field656;
            }
         }

         int var7;
         if((var3 & 1) != 0) {
            var4 = Client.field332.method2870();
            var5 = Client.field332.method2870();
            var6 = var2.x - (var4 - class107.baseX - class107.baseX) * 64;
            var7 = var2.y - (var5 - XClanMember.baseY - XClanMember.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field614 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 16) != 0) {
            var4 = Client.field332.method2892();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field332.method2842();
                  if(var6 == 32767) {
                     var6 = Client.field332.method2842();
                     var8 = Client.field332.method2842();
                     var7 = Client.field332.method2842();
                     var9 = Client.field332.method2842();
                  } else if(var6 != 32766) {
                     var8 = Client.field332.method2842();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field332.method2842();
                  var2.method577(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field332.readUnsignedByte();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field332.method2842();
                  var8 = Client.field332.method2842();
                  if(var8 != 32767) {
                     var9 = Client.field332.method2842();
                     var10 = Client.field332.method2753();
                     int var11 = var8 > 0?Client.field332.method2892():var10;
                     var2.method574(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method571(var7);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2124356946"
   )
   public static final boolean method147() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1696 == class105.field1723) {
            return false;
         } else {
            class177.field2670 = class105.field1715[class105.field1723];
            class88.field1529 = class105.field1714[class105.field1723];
            class105.field1723 = class105.field1723 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(LWidget;IIII)V",
      garbageValue = "-172806883"
   )
   static final void method148(Widget var0, int var1, int var2, int var3) {
      class164 var4 = var0.method3114(false);
      if(var4 != null) {
         if(Client.field520 < 3) {
            class159.field2139.method4059(var1, var2, var4.field2164, var4.field2165, 25, 25, Client.mapAngle, 256, var4.field2162, var4.field2168);
         } else {
            class219.method3921(var1, var2, 0, var4.field2162, var4.field2168);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1721480085"
   )
   public static void method149(boolean var0) {
      if(Widget.isMembersWorld != var0) {
         class170.method3174();
         Widget.isMembersWorld = var0;
      }

   }
}
