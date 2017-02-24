import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class18 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 529590619
   )
   int field197;
   @ObfuscatedName("h")
   Widget field198;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1421605037
   )
   int field200;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -488160669
   )
   int field201;
   @ObfuscatedName("o")
   String field202;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -212847505
   )
   int field203;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2109026847
   )
   int field204;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -251084133
   )
   int field205;
   @ObfuscatedName("ps")
   @ObfuscatedGetter(
      intValue = 1720834473
   )
   static int field208;
   @ObfuscatedName("q")
   Object[] field209;
   @ObfuscatedName("r")
   Widget field210;
   @ObfuscatedName("d")
   boolean field213;
   @ObfuscatedName("ez")
   static ModIcon[] field215;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;I)V",
      garbageValue = "1650914999"
   )
   static void method198(Font var0, Font var1) {
      if(class32.field744 == null) {
         class32.field744 = class31.method711(class165.field2167, "sl_back", "");
      }

      if(Ignore.field221 == null) {
         Ignore.field221 = Frames.method1957(class165.field2167, "sl_flags", "");
      }

      if(class36.field797 == null) {
         class36.field797 = Frames.method1957(class165.field2167, "sl_arrows", "");
      }

      if(class10.field101 == null) {
         class10.field101 = Frames.method1957(class165.field2167, "sl_stars", "");
      }

      Rasterizer2D.method4011(class41.field839, 23, 765, 480, 0);
      Rasterizer2D.method4016(class41.field839, 0, 125, 23, 12425273, 9135624);
      Rasterizer2D.method4016(class41.field839 + 125, 0, 640, 23, 5197647, 2697513);
      var0.method3901("Select a world", 62 + class41.field839, 15, 0, -1);
      if(null != class10.field101) {
         class10.field101[1].method4122(140 + class41.field839, 1);
         var1.method3898("Members only world", 152 + class41.field839, 10, 16777215, -1);
         class10.field101[0].method4122(140 + class41.field839, 12);
         var1.method3898("Free world", class41.field839 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(class36.field797 != null) {
         int var2 = 280 + class41.field839;
         if(World.field698[0] == 0 && World.field697[0] == 0) {
            class36.field797[2].method4122(var2, 4);
         } else {
            class36.field797[0].method4122(var2, 4);
         }

         if(World.field698[0] == 0 && World.field697[0] == 1) {
            class36.field797[3].method4122(15 + var2, 4);
         } else {
            class36.field797[1].method4122(15 + var2, 4);
         }

         var0.method3898("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class41.field839;
         if(World.field698[0] == 1 && World.field697[0] == 0) {
            class36.field797[2].method4122(var3, 4);
         } else {
            class36.field797[0].method4122(var3, 4);
         }

         if(World.field698[0] == 1 && World.field697[0] == 1) {
            class36.field797[3].method4122(var3 + 15, 4);
         } else {
            class36.field797[1].method4122(15 + var3, 4);
         }

         var0.method3898("Players", 32 + var3, 17, 16777215, -1);
         var4 = 500 + class41.field839;
         if(World.field698[0] == 2 && World.field697[0] == 0) {
            class36.field797[2].method4122(var4, 4);
         } else {
            class36.field797[0].method4122(var4, 4);
         }

         if(World.field698[0] == 2 && World.field697[0] == 1) {
            class36.field797[3].method4122(15 + var4, 4);
         } else {
            class36.field797[1].method4122(15 + var4, 4);
         }

         var0.method3898("Location", var4 + 32, 17, 16777215, -1);
         var5 = 610 + class41.field839;
         if(World.field698[0] == 3 && World.field697[0] == 0) {
            class36.field797[2].method4122(var5, 4);
         } else {
            class36.field797[0].method4122(var5, 4);
         }

         if(World.field698[0] == 3 && World.field697[0] == 1) {
            class36.field797[3].method4122(var5 + 15, 4);
         } else {
            class36.field797[1].method4122(15 + var5, 4);
         }

         var0.method3898("Type", var5 + 32, 17, 16777215, -1);
      }

      Rasterizer2D.method4011(708 + class41.field839, 4, 50, 16, 0);
      var1.method3901("Cancel", 25 + class41.field839 + 708, 16, 16777215, -1);
      class41.field868 = -1;
      if(null != class32.field744) {
         byte var23 = 88;
         byte var24 = 19;
         var4 = 765 / (var23 + 1);
         var5 = 480 / (1 + var24);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= World.field703) {
               --var4;
            }

            if(var4 * (var5 - 1) >= World.field703) {
               --var5;
            }

            if(var4 * (var5 - 1) >= World.field703) {
               --var5;
            }
         } while(var6 != var5 || var7 != var4);

         var6 = (765 - var4 * var23) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var24) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var23 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var24 * var5 - var7 * (var5 - 1)) / 2;
         int var10 = 23 + var9;
         int var11 = class41.field839 + var8;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < World.field703; ++var14) {
            World var15 = World.worldList[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.playerCount);
            if(var15.playerCount == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.playerCount > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method648()) {
               if(var15.method668()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method647()) {
               var19 = 16711680;
               if(var15.method668()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method645()) {
               if(var15.method668()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method668()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class115.field1792 >= var11 && class115.field1799 >= var10 && class115.field1792 < var23 + var11 && class115.field1799 < var24 + var10 && var16) {
               class41.field868 = var14;
               class32.field744[var18].method4177(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class32.field744[var18].method4171(var11, var10);
            }

            if(Ignore.field221 != null) {
               Ignore.field221[(var15.method668()?8:0) + var15.location].method4122(29 + var11, var10);
            }

            var0.method3901(Integer.toString(var15.id), 15 + var11, 5 + var10 + var24 / 2, var19, -1);
            var1.method3901(var17, 60 + var11, var24 / 2 + var10 + 5, 268435455, -1);
            var10 += var24 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = var9 + 23;
               var11 += var23 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3921(World.worldList[class41.field868].activity) + 6;
            int var20 = 8 + var1.field3105;
            Rasterizer2D.method4011(class115.field1792 - var14 / 2, 5 + 20 + class115.field1799, var14, var20, 16777120);
            Rasterizer2D.method4017(class115.field1792 - var14 / 2, 5 + class115.field1799 + 20, var14, var20, 0);
            var1.method3901(World.worldList[class41.field868].activity, class115.field1792, var1.field3105 + 5 + 20 + class115.field1799 + 4, 0, -1);
         }
      }

      try {
         Graphics var21 = GameObject.canvas.getGraphics();
         CombatInfo1.bufferProvider.draw(var21, 0, 0);
      } catch (Exception var22) {
         GameObject.canvas.repaint();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1983172431"
   )
   static String method199(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "69126888"
   )
   static void method200(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field727 = var0;
      var5.field723 = var1 * 128;
      var5.field737 = var2 * 128;
      int var6 = var3.sizeX;
      int var7 = var3.sizeY;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.sizeY;
         var7 = var3.sizeX;
      }

      var5.field725 = (var6 + var1) * 128;
      var5.field730 = (var2 + var7) * 128;
      var5.field736 = var3.ambientSoundId;
      var5.field724 = var3.field2922 * 128;
      var5.field728 = var3.field2938;
      var5.field731 = var3.field2936;
      var5.field732 = var3.field2941;
      if(var3.impostorIds != null) {
         var5.field735 = var3;
         var5.method707();
      }

      class31.field733.method2453(var5);
      if(var5.field732 != null) {
         var5.field721 = var5.field728 + (int)(Math.random() * (double)(var5.field731 - var5.field728));
      }

   }
}
