import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1949617757
   )
   int field1460;
   @ObfuscatedName("a")
   int[][] field1461;
   @ObfuscatedName("i")
   int[] field1462;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -778283383
   )
   int field1463;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = 1453237237
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("s")
   static String field1465;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -259272587
   )
   public static int field1466;
   @ObfuscatedName("lj")
   static class216 field1467;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;B)I",
      garbageValue = "119"
   )
   static int method1664(class182 var0, class182 var1) {
      int var2 = 0;
      if(var0.method3280("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3280("logo", "")) {
         ++var2;
      }

      if(var1.method3280("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3280("titlebox", "")) {
         ++var2;
      }

      if(var1.method3280("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3280("runes", "")) {
         ++var2;
      }

      if(var1.method3280("title_mute", "")) {
         ++var2;
      }

      if(var1.method3263("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3263("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3280("sl_back", "");
      var1.method3280("sl_flags", "");
      var1.method3280("sl_arrows", "");
      var1.method3280("sl_stars", "");
      var1.method3280("sl_button", "");
      return var2;
   }

   FrameMap(int var1, byte[] var2) {
      this.field1463 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1460 = var3.readUnsignedByte();
      this.field1462 = new int[this.field1460];
      this.field1461 = new int[this.field1460][];

      int var4;
      for(var4 = 0; var4 < this.field1460; ++var4) {
         this.field1462[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.field1460; ++var4) {
         this.field1461[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.field1460; ++var4) {
         for(int var5 = 0; var5 < this.field1461[var4].length; ++var5) {
            this.field1461[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIIS)V",
      garbageValue = "-9894"
   )
   static final void method1665(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var12 = class10.tileHeights[0][var2];
                  int var9 = 932731 + var2 + var4;
                  int var10 = var3 + 556238 + var5;
                  int var11 = class112.method2055(var9 + '넵', 91923 + var10, 4) - 128 + (class112.method2055(10294 + var9, '鎽' + var10, 2) - 128 >> 1) + (class112.method2055(var9, var10, 1) - 128 >> 2);
                  var11 = 35 + (int)(0.3D * (double)var11);
                  if(var11 < 10) {
                     var11 = 10;
                  } else if(var11 > 60) {
                     var11 = 60;
                  }

                  var12[var3] = 8 * -var11;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class10.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class10.overlayIds[var1][var2][var3] = var0.readByte();
               class10.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class174.overlayRotations[var1][var2][var3] = (byte)(var6 + (var7 - 2) & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1727501694"
   )
   public static void method1666(boolean var0) {
      if(null != class185.field2737) {
         try {
            Buffer var1 = new Buffer(4);
            var1.method2760(var0?2:3);
            var1.method2914(0);
            class185.field2737.method2018(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class185.field2737.method2026();
            } catch (Exception var3) {
               ;
            }

            ++class185.field2736;
            class185.field2737 = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1379722108"
   )
   static int method1667(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("sj")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "-693397327"
   )
   protected static final void method1668(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class165.canvas.getGraphics();
         if(null == CombatInfoListHolder.field752) {
            CombatInfoListHolder.field752 = new Font("Helvetica", 1, 13);
            RSCanvas.field1745 = class165.canvas.getFontMetrics(CombatInfoListHolder.field752);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, class0.field1, class65.field1099);
         }

         if(null == var2) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(class178.field2658 == null) {
               class178.field2658 = class165.canvas.createImage(304, 34);
            }

            Graphics var5 = class178.field2658.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, var0 * 3, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - var0 * 3, 30);
            var5.setFont(CombatInfoListHolder.field752);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - RSCanvas.field1745.stringWidth(var1)) / 2, 22);
            var4.drawImage(class178.field2658, class0.field1 / 2 - 152, class65.field1099 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = class0.field1 / 2 - 152;
            int var7 = class65.field1099 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(var6 + 2, var7 + 2, 3 * var0, 30);
            var4.setColor(Color.black);
            var4.drawRect(var6 + 1, var7 + 1, 301, 31);
            var4.fillRect(2 + var6 + var0 * 3, 2 + var7, 300 - var0 * 3, 30);
            var4.setFont(CombatInfoListHolder.field752);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - RSCanvas.field1745.stringWidth(var1)) / 2, 22 + var7);
         }
      } catch (Exception var9) {
         class165.canvas.repaint();
      }

   }
}
