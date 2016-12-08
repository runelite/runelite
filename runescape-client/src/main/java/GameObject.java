import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -852121769
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -595483545
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1904207077
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 396309601
   )
   @Export("height")
   int height;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 826696365
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 278462567
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1215852797
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 301124393
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1256245805
   )
   int field1611;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -130583175
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1535025785
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 871375557
   )
   @Export("y")
   int y;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -727243423
   )
   int field1617;
   @ObfuscatedName("hu")
   @ObfuscatedGetter(
      intValue = 188449883
   )
   @Export("menuX")
   static int menuX;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IIIIIII)V",
      garbageValue = "-79376180"
   )
   static final void method1878(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class10.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var14 = class10.tileHeights[0][var2];
                  int var11 = 932731 + var2 + var4;
                  int var12 = var5 + var3 + 556238;
                  int var13 = class0.method7('넵' + var11, var12 + 91923, 4) - 128 + (class0.method7(var11 + 10294, '鎽' + var12, 2) - 128 >> 1) + (class0.method7(var11, var12, 1) - 128 >> 2);
                  var13 = 35 + (int)(0.3D * (double)var13);
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var14[var3] = -var13 * 8;
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
                  class10.tileHeights[var1][var2][var3] = class10.tileHeights[var1 - 1][var2][var3] - 8 * var8;
               }
               break;
            }

            if(var7 <= 49) {
               class204.field3072[var1][var2][var3] = var0.readByte();
               class183.field2737[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class10.field82[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class10.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class10.field83[var1][var2][var3] = (byte)(var7 - 81);
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

   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/awt/Color;ZI)V",
      garbageValue = "-864324819"
   )
   protected static final void method1879(int var0, String var1, Color var2, boolean var3) {
      try {
         Graphics var4 = class36.canvas.getGraphics();
         if(class10.field103 == null) {
            class10.field103 = new Font("Helvetica", 1, 13);
            FaceNormal.field1555 = class36.canvas.getFontMetrics(class10.field103);
         }

         if(var3) {
            var4.setColor(Color.black);
            var4.fillRect(0, 0, TextureProvider.field1200, class94.field1584);
         }

         if(var2 == null) {
            var2 = new Color(140, 17, 17);
         }

         try {
            if(DecorativeObject.field1597 == null) {
               DecorativeObject.field1597 = class36.canvas.createImage(304, 34);
            }

            Graphics var5 = DecorativeObject.field1597.getGraphics();
            var5.setColor(var2);
            var5.drawRect(0, 0, 303, 33);
            var5.fillRect(2, 2, 3 * var0, 30);
            var5.setColor(Color.black);
            var5.drawRect(1, 1, 301, 31);
            var5.fillRect(2 + var0 * 3, 2, 300 - 3 * var0, 30);
            var5.setFont(class10.field103);
            var5.setColor(Color.white);
            var5.drawString(var1, (304 - FaceNormal.field1555.stringWidth(var1)) / 2, 22);
            var4.drawImage(DecorativeObject.field1597, TextureProvider.field1200 / 2 - 152, class94.field1584 / 2 - 18, (ImageObserver)null);
         } catch (Exception var8) {
            int var6 = TextureProvider.field1200 / 2 - 152;
            int var7 = class94.field1584 / 2 - 18;
            var4.setColor(var2);
            var4.drawRect(var6, var7, 303, 33);
            var4.fillRect(2 + var6, var7 + 2, var0 * 3, 30);
            var4.setColor(Color.black);
            var4.drawRect(1 + var6, var7 + 1, 301, 31);
            var4.fillRect(3 * var0 + var6 + 2, var7 + 2, 300 - 3 * var0, 30);
            var4.setFont(class10.field103);
            var4.setColor(Color.white);
            var4.drawString(var1, var6 + (304 - FaceNormal.field1555.stringWidth(var1)) / 2, var7 + 22);
         }
      } catch (Exception var9) {
         class36.canvas.repaint();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;I)V",
      garbageValue = "-778542065"
   )
   public static void method1880(class182 var0, class182 var1) {
      NPCComposition.field3014 = var0;
      NPCComposition.field2994 = var1;
   }
}
