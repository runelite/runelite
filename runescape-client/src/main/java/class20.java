import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class20 extends Node {
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1725364283
   )
   static int field589;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 264985437
   )
   int field590;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 393240591
   )
   int field591;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 105082329
   )
   int field592;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2014429423
   )
   int field594;
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 1771537381
   )
   public static int field597;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "751308638"
   )
   static SpritePixels method529() {
      SpritePixels var0 = new SpritePixels();
      var0.field1453 = class169.field2713;
      var0.field1459 = class79.field1435;
      var0.field1458 = class79.field1439[0];
      var0.field1457 = class79.field1438[0];
      var0.width = class79.field1443[0];
      var0.height = class79.field1440[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class79.field1441[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class129.field2092[var2[var3] & 255];
      }

      ChatLineBuffer.method649();
      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "399388133"
   )
   void method530(int var1, int var2, int var3, int var4) {
      this.field594 = var1;
      this.field590 = var2;
      this.field591 = var3;
      this.field592 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass125;ILPlayer;IB)V",
      garbageValue = "66"
   )
   static final void method532(class125 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 1) != 0) {
         var5 = var0.method2544();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2555(var6, 0, var5);
         class34.field784[var1] = var7;
         var2.method15(var7);
      }

      int var19;
      if((var3 & 64) != 0) {
         var5 = var0.method2546();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var19 = var0.method2544();
         class26.method579(var2, var5, var19);
      }

      if((var3 & 2) != 0) {
         var2.interacting = var0.method2546();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 8) != 0) {
         var2.overhead = var0.method2552();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            class110.method2416(2, var2.name, var2.overhead);
         } else if(var2 == class138.localPlayer) {
            class110.method2416(2, var2.name, var2.overhead);
         }

         var2.field849 = false;
         var2.field852 = 0;
         var2.field891 = 0;
         var2.field847 = 150;
      }

      int var9;
      int var10;
      if((var3 & 128) != 0) {
         var5 = var0.method2544();
         int var8;
         int var11;
         int var20;
         if(var5 > 0) {
            for(var19 = 0; var19 < var5; ++var19) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var20 = var0.method2573();
               if(var20 == 32767) {
                  var20 = var0.method2573();
                  var9 = var0.method2573();
                  var8 = var0.method2573();
                  var10 = var0.method2573();
               } else if(var20 != 32766) {
                  var9 = var0.method2573();
               } else {
                  var20 = -1;
               }

               var11 = var0.method2573();
               var2.method784(var20, var9, var8, var10, Client.gameCycle, var11);
            }
         }

         var19 = var0.method2544();
         if(var19 > 0) {
            for(var20 = 0; var20 < var19; ++var20) {
               var8 = var0.method2573();
               var9 = var0.method2573();
               if(var9 != 32767) {
                  var10 = var0.method2573();
                  var11 = var0.method2544();
                  int var12 = var9 > 0?var0.method2544():var11;
                  var2.method785(var8, Client.gameCycle, var9, var10, var11, var12);
               } else {
                  var2.method786(var8);
               }
            }
         }
      }

      if((var3 & 4) != 0) {
         var2.field863 = var0.method2546();
         if(var2.field889 == 0) {
            var2.field886 = var2.field863;
            var2.field863 = -1;
         }
      }

      if((var3 & 16) != 0) {
         var5 = var0.method2546();
         class155[] var25 = new class155[]{class155.field2314, class155.field2311, class155.field2312, class155.field2310, class155.field2309, class155.field2319};
         class155 var26 = (class155)class140.method2957(var25, var0.method2544());
         boolean var28 = var0.method2544() == 1;
         var9 = var0.method2544();
         var10 = var0.offset;
         if(var2.name != null && null != var2.composition) {
            boolean var29 = false;
            if(var26.field2320 && class128.method2839(var2.name)) {
               var29 = true;
            }

            if(!var29 && Client.field442 == 0 && !var2.field45) {
               class34.field774.offset = 0;
               var0.method2555(class34.field774.payload, 0, var9);
               class34.field774.offset = 0;
               Buffer var13 = class34.field774;

               String var14;
               int var15;
               String var17;
               try {
                  var15 = var13.method2573();
                  if(var15 > 32767) {
                     var15 = 32767;
                  }

                  byte[] var16 = new byte[var15];
                  var13.offset += class225.field3236.method2479(var13.payload, var13.offset, var16, 0, var15);
                  var17 = RSCanvas.method2975(var16, 0, var15);
                  var14 = var17;
               } catch (Exception var24) {
                  var14 = "Cabbage";
               }

               var14 = class226.method4066(class129.method2849(var14));
               var2.overhead = var14.trim();
               var2.field852 = var5 >> 8;
               var2.field891 = var5 & 255;
               var2.field847 = 150;
               var2.field849 = var28;
               var2.inSequence = class138.localPlayer != var2 && var26.field2320 && Client.field505 != "" && var14.toLowerCase().indexOf(Client.field505) == -1;
               if(var26.field2315) {
                  var15 = var28?91:1;
               } else {
                  var15 = var28?90:2;
               }

               if(var26.field2317 != -1) {
                  int var18 = var26.field2317;
                  var17 = "<img=" + var18 + ">";
                  class110.method2416(var15, var17 + var2.name, var14);
               } else {
                  class110.method2416(var15, var2.name, var14);
               }
            }
         }

         var0.offset = var9 + var10;
      }

      if((var3 & 2048) != 0) {
         var2.graphic = var0.method2546();
         var5 = var0.method2549();
         var2.field876 = var5 >> 16;
         var2.field835 = (var5 & '\uffff') + Client.gameCycle;
         var2.field873 = 0;
         var2.field874 = 0;
         if(var2.field835 > Client.gameCycle) {
            var2.field873 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 512) != 0) {
         var2.field841 = var0.method2545();
         var2.field879 = var0.method2545();
         var2.field858 = var0.method2545();
         var2.field855 = var0.method2545();
         var2.field881 = var0.method2546() + Client.gameCycle;
         var2.field882 = var0.method2546() + Client.gameCycle;
         var2.field892 = var0.method2546();
         if(var2.field55) {
            var2.field841 += var2.field56;
            var2.field879 += var2.field33;
            var2.field858 += var2.field56;
            var2.field855 += var2.field33;
            var2.field889 = 0;
         } else {
            var2.field841 += var2.pathX[0];
            var2.field879 += var2.pathY[0];
            var2.field858 += var2.pathX[0];
            var2.field855 += var2.pathY[0];
            var2.field889 = 1;
         }

         var2.field894 = 0;
      }

      if((var3 & 4096) != 0) {
         class34.field777[var1] = var0.method2545();
      }

      if((var3 & 1024) != 0) {
         var4 = var0.method2545();
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2552();
         }
      }

      if(var2.field55) {
         if(var4 == 127) {
            var2.method19(var2.field56, var2.field33);
         } else {
            byte var27;
            if(var4 != -1) {
               var27 = var4;
            } else {
               var27 = class34.field777[var1];
            }

            var2.method18(var2.field56, var2.field33, var27);
         }
      }

   }

   class20(int var1, int var2, int var3, int var4) {
      this.field594 = var1;
      this.field590 = var2;
      this.field591 = var3;
      this.field592 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "57"
   )
   public static void method533(boolean var0) {
      if(null != class174.field2768) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2529(var0?2:3);
            var1.method2531(0);
            class174.field2768.method3028(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class174.field2768.method3029();
            } catch (Exception var3) {
               ;
            }

            ++class174.field2772;
            class174.field2768 = null;
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1591532723"
   )
   static void method534() {
      if(class33.field758) {
         class180.field2958 = null;
         class33.field743 = null;
         class33.field744 = null;
         class33.field745 = null;
         class164.field2694 = null;
         Client.field583 = null;
         class33.field770 = null;
         XItemContainer.field236 = null;
         class14.field223 = null;
         class12.field200 = null;
         class16.field254 = null;
         Projectile.field134 = null;
         TextureProvider.field1671 = null;
         class130.field2103 = null;
         class109.field1925 = null;
         class155.field2308 = null;
         class33.field754 = null;
         class52.field1139 = null;
         SecondaryBufferProvider.field1434 = null;
         class79.field1442 = null;
         Frames.field1832 = null;
         GameObject.field1727 = null;
         class186.field3010 = 1;
         class35.field800 = null;
         FrameMap.field1823 = -1;
         class186.field3015 = -1;
         class186.field3016 = 0;
         class186.field3017 = false;
         class54.field1154 = 2;
         method533(true);
         class33.field758 = false;
      }
   }
}
