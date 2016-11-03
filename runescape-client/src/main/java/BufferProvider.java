import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("f")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 842466903
   )
   @Export("width")
   public int width;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2046382803
   )
   @Export("height")
   int height;
   @ObfuscatedName("j")
   @Export("image")
   public Image image;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1439443042"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class145.plane][var0][var1];
      if(var2 == null) {
         Frames.region.method1982(class145.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method3864(); null != var6; var6 = (Item)var2.method3851()) {
            ItemComposition var7 = class22.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            Frames.region.method1982(class145.plane, var0, var1);
         } else {
            var2.method3845(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method3864(); var6 != null; var6 = (Item)var2.method3851()) {
               if(var6.id != var5.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            Frames.region.method1968(class145.plane, var0, var1, class109.method2439(var0 * 128 + 64, 64 + 128 * var1, class145.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "419331807"
   )
   abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   public final void method1720() {
      class82.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "42"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-98"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "21"
   )
   public static byte method1732(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Lclass157;",
      garbageValue = "-1743565004"
   )
   public static class157[] method1733() {
      return new class157[]{class157.field2326, class157.field2327, class157.field2330, class157.field2333, class157.field2329, class157.field2332};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "82"
   )
   static boolean method1734(String var0) {
      if(var0 == null) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-1552024560"
   )
   static final void method1735(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field507) {
         Client.field364 = 32;
      } else {
         Client.field364 = 0;
      }

      Client.field507 = false;
      int var7;
      if(class143.field2199 == 1 || !class124.field2066 && class143.field2199 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < 16 + var2) {
            var0.scrollY -= 4;
            class166.method3253(var0);
         } else if(var5 >= var1 && var5 < 16 + var1 && var6 >= var3 + var2 - 16 && var6 < var2 + var3) {
            var0.scrollY += 4;
            class166.method3253(var0);
         } else if(var5 >= var1 - Client.field364 && var5 < var1 + 16 + Client.field364 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = (var3 - 32) * var3 / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = (var4 - var3) * var8 / var9;
            class166.method3253(var0);
            Client.field507 = true;
         }
      }

      if(Client.field539 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.field539 * 45;
            class166.method3253(var0);
         }
      }

   }
}
