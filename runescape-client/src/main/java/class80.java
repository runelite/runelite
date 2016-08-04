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
public abstract class class80 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1623547779
   )
   @Export("width")
   public int field1470;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -640958829
   )
   @Export("height")
   int field1472;
   @ObfuscatedName("r")
   @Export("pixels")
   public int[] field1474;
   @ObfuscatedName("s")
   @Export("image")
   public Image field1475;
   @ObfuscatedName("bj")
   static class171 field1476;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "42"
   )
   public abstract void vmethod1964(int var1, int var2, Component var3);

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-75"
   )
   public abstract void vmethod1963(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "1769215131"
   )
   public abstract void vmethod1965(Graphics var1, int var2, int var3);

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-76"
   )
   public final void method1787() {
      class82.method1879(this.field1474, this.field1470, this.field1472);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass125;ILclass2;IB)V",
      garbageValue = "50"
   )
   static final void method1791(class125 var0, int var1, class2 var2, int var3) {
      byte var4 = -1;
      int var5;
      if((var3 & 64) != 0) {
         var5 = var0.method2633();
         byte[] var6 = new byte[var5];
         class122 var7 = new class122(var6);
         var0.method2754(var6, 0, var5);
         class34.field791[var1] = var7;
         var2.method29(var7);
      }

      int var17;
      if((var3 & 16) != 0) {
         var5 = var0.method2635();
         if(var5 == '\uffff') {
            var5 = -1;
         }

         var17 = var0.method2633();
         class20.method568(var2, var5, var17);
      }

      if((var3 & 1) != 0) {
         var2.field844 = var0.method2635();
         if(var2.field844 == '\uffff') {
            var2.field844 = -1;
         }
      }

      if((var3 & 2) != 0) {
         var2.field835 = var0.method2663();
         if(var2.field835.charAt(0) == 126) {
            var2.field835 = var2.field835.substring(1);
            class78.method1721(2, var2.field58, var2.field835);
         } else if(class3.field65 == var2) {
            class78.method1721(2, var2.field58, var2.field835);
         }

         var2.field845 = false;
         var2.field885 = 0;
         var2.field881 = 0;
         var2.field847 = 150;
      }

      int var8;
      int var9;
      if((var3 & 128) != 0) {
         var5 = var0.method2633();
         int var10;
         int var11;
         int var18;
         if(var5 > 0) {
            for(var17 = 0; var17 < var5; ++var17) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var18 = var0.method2646();
               if(var18 == 32767) {
                  var18 = var0.method2646();
                  var9 = var0.method2646();
                  var8 = var0.method2646();
                  var10 = var0.method2646();
               } else if(var18 != 32766) {
                  var9 = var0.method2646();
               } else {
                  var18 = -1;
               }

               var11 = var0.method2646();
               var2.method795(var18, var9, var8, var10, client.field305, var11);
            }
         }

         var17 = var0.method2633();
         if(var17 > 0) {
            for(var18 = 0; var18 < var17; ++var18) {
               var8 = var0.method2646();
               var9 = var0.method2646();
               if(var9 != 32767) {
                  var10 = var0.method2646();
                  var11 = var0.method2633();
                  int var12 = var9 > 0?var0.method2633():var11;
                  var2.method796(var8, client.field305, var9, var10, var11, var12);
               } else {
                  var2.method797(var8);
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
         class155 var23 = (class155)class85.method1971(class128.method2954(), var0.method2633());
         boolean var26 = var0.method2633() == 1;
         var8 = var0.method2633();
         var9 = var0.field2050;
         if(var2.field58 != null && null != var2.field31) {
            boolean var25 = false;
            if(var23.field2330 && class107.method2395(var2.field58)) {
               var25 = true;
            }

            if(!var25 && client.field564 == 0 && !var2.field51) {
               class34.field792.field2050 = 0;
               var0.method2754(class34.field792.field2051, 0, var8);
               class34.field792.field2050 = 0;
               class122 var19 = class34.field792;

               String var13;
               int var14;
               try {
                  var14 = var19.method2646();
                  if(var14 > 32767) {
                     var14 = 32767;
                  }

                  byte[] var15 = new byte[var14];
                  var19.field2050 += class225.field3227.method2558(var19.field2051, var19.field2050, var15, 0, var14);
                  String var16 = class36.method763(var15, 0, var14);
                  var13 = var16;
               } catch (Exception var22) {
                  var13 = "Cabbage";
               }

               var13 = class226.method4169(class43.method906(var13));
               var2.field835 = var13.trim();
               var2.field885 = var5 >> 8;
               var2.field881 = var5 & 255;
               var2.field847 = 150;
               var2.field845 = var26;
               var2.field852 = var2 != class3.field65 && var23.field2330 && "" != client.field415 && var13.toLowerCase().indexOf(client.field415) == -1;
               if(var23.field2329) {
                  var14 = var26?91:1;
               } else {
                  var14 = var26?90:2;
               }

               if(var23.field2325 != -1) {
                  class78.method1721(var14, class25.method615(var23.field2325) + var2.field58, var13);
               } else {
                  class78.method1721(var14, var2.field58, var13);
               }
            }
         }

         var0.field2050 = var9 + var8;
      }

      if((var3 & 512) != 0) {
         var2.field868 = var0.method2635();
         var5 = var0.method2620();
         var2.field872 = var5 >> 16;
         var2.field871 = (var5 & '\uffff') + client.field305;
         var2.field890 = 0;
         var2.field858 = 0;
         if(var2.field871 > client.field305) {
            var2.field890 = -1;
         }

         if(var2.field868 == '\uffff') {
            var2.field868 = -1;
         }
      }

      if((var3 & 2048) != 0) {
         var2.field873 = var0.method2634();
         var2.field856 = var0.method2634();
         var2.field874 = var0.method2634();
         var2.field876 = var0.method2634();
         var2.field891 = var0.method2635() + client.field305;
         var2.field878 = var0.method2635() + client.field305;
         var2.field884 = var0.method2635();
         if(var2.field45) {
            var2.field873 += var2.field49;
            var2.field856 += var2.field56;
            var2.field874 += var2.field49;
            var2.field876 += var2.field56;
            var2.field849 = 0;
         } else {
            var2.field873 += var2.field886[0];
            var2.field856 += var2.field887[0];
            var2.field874 += var2.field886[0];
            var2.field876 += var2.field887[0];
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
            var2.field50[var5] = var0.method2663();
         }
      }

      if(var2.field45) {
         if(var4 == 127) {
            var2.method19(var2.field49, var2.field56);
         } else {
            byte var24;
            if(var4 != -1) {
               var24 = var4;
            } else {
               var24 = class34.field781[var1];
            }

            var2.method18(var2.field49, var2.field56, var24);
         }
      }

   }
}
