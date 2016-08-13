import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1623547779
   )
   @Export("width")
   public int width;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -640958829
   )
   @Export("height")
   int height;
   @ObfuscatedName("r")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("s")
   @Export("image")
   public Image image;
   @ObfuscatedName("bj")
   static class171 field1476;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "42"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-75"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1769215131"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public final void method1787() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass125;ILPlayer;IB)V",
      garbageValue = "50"
   )
   static final void method1791(class125 var0, int var1, Player var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 64) != 0) {
         var5 = var0.method2633();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.method2754(var6, 0, var5);
         class34.field791[var1] = var7;
         var2.method29(var7);
      }

      int var18;
      if((var3 & 16) != 0) {
         var5 = var0.method2635();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var18 = var0.method2633();
         class20.method568(var2, var5, var18);
      }

      if((var3 & 1) != 0) {
         var2.interacting = var0.method2635();
         if(var2.interacting == '\uffff') {
            var2.interacting = -1;
         }
      }

      if((var3 & 2) != 0) {
         var2.overhead = var0.method2663();
         if(var2.overhead.charAt(0) == 126) {
            var2.overhead = var2.overhead.substring(1);
            SecondaryBufferProvider.sendGameMessage(2, var2.name, var2.overhead);
         } else if(WidgetNode.localPlayer == var2) {
            SecondaryBufferProvider.sendGameMessage(2, var2.name, var2.overhead);
         }

         var2.field845 = false;
         var2.field885 = 0;
         var2.field881 = 0;
         var2.field847 = 150;
      }

      int var8;
      int var19;
      if((var3 & 128) != 0) {
         var5 = var0.method2633();
         int var9;
         int var10;
         int var11;
         if(var5 > 0) {
            for(var18 = 0; var18 < var5; ++var18) {
               var19 = -1;
               var8 = -1;
               var9 = -1;
               var11 = var0.method2646();
               if(var11 == 32767) {
                  var11 = var0.method2646();
                  var8 = var0.method2646();
                  var19 = var0.method2646();
                  var9 = var0.method2646();
               } else if(var11 != 32766) {
                  var8 = var0.method2646();
               } else {
                  var11 = -1;
               }

               var10 = var0.method2646();
               var2.method795(var11, var8, var19, var9, Client.gameCycle, var10);
            }
         }

         var18 = var0.method2633();
         if(var18 > 0) {
            for(var11 = 0; var11 < var18; ++var11) {
               var19 = var0.method2646();
               var8 = var0.method2646();
               if(var8 != 32767) {
                  var9 = var0.method2646();
                  var10 = var0.method2633();
                  int var12 = var8 > 0?var0.method2633():var10;
                  var2.method796(var19, Client.gameCycle, var8, var9, var10, var12);
               } else {
                  var2.method797(var19);
               }
            }
         }
      }

      if((var3 & 8) != 0) {
         var2.field859 = var0.method2635();
         if(var2.field849 == 0) {
            var2.field882 = var2.field859;
            var2.field859 = -1;
         }
      }

      if((var3 & 4) != 0) {
         var5 = var0.method2635();
         class155 var20 = (class155)class85.method1971(class128.method2954(), var0.method2633());
         boolean var21 = var0.method2633() == 1;
         var19 = var0.method2633();
         var8 = var0.offset;
         if(var2.name != null && null != var2.composition) {
            boolean var24 = false;
            if(var20.field2330 && class107.method2395(var2.name)) {
               var24 = true;
            }

            if(!var24 && Client.field564 == 0 && !var2.field51) {
               class34.field792.offset = 0;
               var0.method2754(class34.field792.payload, 0, var19);
               class34.field792.offset = 0;
               Buffer var23 = class34.field792;

               String var13;
               int var14;
               try {
                  var14 = var23.method2646();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var23.offset += class225.field3227.method2558(var23.payload, var23.offset, var15, 0, var14);
                  String var16 = NPC.method763(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var17) {
                  var13 = "Cabbage";
               }

               var13 = class226.method4169(class43.method906(var13));
               var2.overhead = var13.trim();
               var2.field885 = var5 >> 8;
               var2.field881 = var5 & 255;
               var2.field847 = 150;
               var2.field845 = var21;
               var2.inSequence = var2 != WidgetNode.localPlayer && var20.field2330 && "" != Client.field415 && var13.toLowerCase().indexOf(Client.field415) == -1;
               if(var20.field2329) {
                  var14 = var21?91:1;
               } else {
                  var14 = var21?90:2;
               }

               if(var20.field2325 != -1) {
                  SecondaryBufferProvider.sendGameMessage(var14, XClanMember.method615(var20.field2325) + var2.name, var13);
               } else {
                  SecondaryBufferProvider.sendGameMessage(var14, var2.name, var13);
               }
            }
         }

         var0.offset = var8 + var19;
      }

      if((var3 & 512) != 0) {
         var2.graphic = var0.method2635();
         var5 = var0.method2620();
         var2.field872 = var5 >> 16;
         var2.field871 = (var5 & '\uffff') + Client.gameCycle;
         var2.field890 = 0;
         var2.field858 = 0;
         if(var2.field871 > Client.gameCycle) {
            var2.field890 = -1;
         }

         if(var2.graphic == '\uffff') {
            var2.graphic = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field873 = var0.method2634();
         var2.field856 = var0.method2634();
         var2.field874 = var0.method2634();
         var2.field876 = var0.method2634();
         var2.field891 = var0.method2635() + Client.gameCycle;
         var2.field878 = var0.method2635() + Client.gameCycle;
         var2.field884 = var0.method2635();
         if(var2.field45) {
            var2.field873 += var2.field49;
            var2.field856 += var2.field56;
            var2.field874 += var2.field49;
            var2.field876 += var2.field56;
            var2.field849 = 0;
         } else {
            var2.field873 += var2.pathX[0];
            var2.field856 += var2.pathY[0];
            var2.field874 += var2.pathX[0];
            var2.field876 += var2.pathY[0];
            var2.field849 = 1;
         }

         var2.field839 = 0;
      }

      if((var3 & 1024) != 0) {
         class34.field781[var1] = var0.method2634();
      }

      if((var3 & 4096) != 0) {
         var4 = var0.method2634();
      }

      if((var3 & 256) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.method2663();
         }
      }

      if(var2.field45) {
         if(var4 == 127) {
            var2.method19(var2.field49, var2.field56);
         } else {
            byte var22;
            if(var4 != -1) {
               var22 = var4;
            } else {
               var22 = class34.field781[var1];
            }

            var2.method18(var2.field49, var2.field56, var22);
         }
      }

   }
}
