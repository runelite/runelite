import java.awt.FontMetrics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class48 extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1944073517
   )
   public int field1055;
   @ObfuscatedName("f")
   public static class170 field1057;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2003224659
   )
   public int field1058 = -1;
   @ObfuscatedName("v")
   public boolean field1059 = true;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2019037915
   )
   public int field1060 = -1;
   @ObfuscatedName("bf")
   protected static FontMetrics field1061;
   @ObfuscatedName("e")
   public static NodeCache field1062 = new NodeCache(64);
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -289148015
   )
   public int field1063;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1974654133
   )
   public int field1064;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1292281025
   )
   public int field1065;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 384812053
   )
   public int field1066;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -776889663
   )
   public int field1069 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1139109335
   )
   public int field1070;

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1015957255"
   )
   static final void method968(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field482; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field485[var4] = true;
         }
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   static final void method969() {
      for(int var0 = 0; var0 < Client.field323; ++var0) {
         int var1 = Client.field456[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field327.method2656();
         if((var3 & 16) != 0) {
            var2.interacting = Client.field327.method2570();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 1) != 0) {
            var4 = Client.field327.method2562();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field327.method2546();
                  if(var6 == 32767) {
                     var6 = Client.field327.method2546();
                     var8 = Client.field327.method2546();
                     var7 = Client.field327.method2546();
                     var9 = Client.field327.method2546();
                  } else if(var6 != 32766) {
                     var8 = Client.field327.method2546();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field327.method2546();
                  var2.method769(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field327.method2562();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field327.method2546();
                  var8 = Client.field327.method2546();
                  if(var8 != 32767) {
                     var9 = Client.field327.method2546();
                     var10 = Client.field327.method2561();
                     int var11 = var8 > 0?Client.field327.method2677():var10;
                     var2.method770(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method767(var7);
                  }
               }
            }
         }

         if((var3 & 64) != 0) {
            var2.overhead = Client.field327.method2541();
            var2.field832 = 100;
         }

         if((var3 & 2) != 0) {
            var2.composition = World.getNpcDefinition(Client.field327.method2569());
            var2.field842 = var2.composition.field894;
            var2.field869 = var2.composition.field888;
            var2.field824 = var2.composition.field895;
            var2.field825 = var2.composition.field893;
            var2.field826 = var2.composition.field897;
            var2.field827 = var2.composition.field892;
            var2.idlePoseAnimation = var2.composition.field889;
            var2.field847 = var2.composition.field912;
            var2.field823 = var2.composition.field919;
         }

         if((var3 & 4) != 0) {
            var4 = Client.field327.method2568();
            var5 = Client.field327.method2568();
            var6 = var2.x - (var4 - class32.baseX - class32.baseX) * 64;
            var7 = var2.y - (var5 - class8.baseY - class8.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field844 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 8) != 0) {
            var2.graphic = Client.field327.method2535();
            var4 = Client.field327.method2565();
            var2.field860 = var4 >> 16;
            var2.field846 = (var4 & '\uffff') + Client.gameCycle;
            var2.field835 = 0;
            var2.field855 = 0;
            if(var2.field846 > Client.gameCycle) {
               var2.field835 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 32) != 0) {
            var4 = Client.field327.method2569();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field327.method2656();
            if(var2.animation == var4 && var4 != -1) {
               var6 = class62.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field850 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field852 = 0;
               }

               if(var6 == 2) {
                  var2.field852 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class62.getAnimation(var4).field1005 >= class62.getAnimation(var2.animation).field1005) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field850 = 0;
               var2.actionAnimationDisable = var5;
               var2.field852 = 0;
               var2.field875 = var2.field867;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1010472529"
   )
   public void method970(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2656();
         if(var3 == 0) {
            return;
         }

         this.method971(var1, var3, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "555371190"
   )
   void method971(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1069 = var1.method2537();
      } else if(var2 == 2) {
         this.field1058 = var1.method2656();
      } else if(var2 == 5) {
         this.field1059 = false;
      } else if(var2 == 7) {
         this.field1060 = var1.method2537();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "671574856"
   )
   void method972(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1065 = (int)(256.0D * var12);
      this.field1055 = (int)(var14 * 256.0D);
      this.field1063 = (int)(256.0D * var16);
      if(this.field1055 < 0) {
         this.field1055 = 0;
      } else if(this.field1055 > 255) {
         this.field1055 = 255;
      }

      if(this.field1063 < 0) {
         this.field1063 = 0;
      } else if(this.field1063 > 255) {
         this.field1063 = 255;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "36"
   )
   public void method982() {
      if(this.field1060 != -1) {
         this.method972(this.field1060);
         this.field1064 = this.field1065;
         this.field1070 = this.field1055;
         this.field1066 = this.field1063;
      }

      this.method972(this.field1069);
   }
}
