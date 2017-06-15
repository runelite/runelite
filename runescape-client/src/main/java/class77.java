import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class77 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1339191673
   )
   int field1199;
   @ObfuscatedName("m")
   class153 field1200;
   @ObfuscatedName("e")
   DataInputStream field1201;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -6851430450453721005L
   )
   long field1202;
   @ObfuscatedName("z")
   byte[] field1203;
   @ObfuscatedName("t")
   byte[] field1204;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1589856761
   )
   int field1205;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1490312177
   )
   int field1206;
   @ObfuscatedName("v")
   static Buffer field1207;

   class77(class154 var1, URL var2) {
      this.field1204 = new byte[4];
      this.field1200 = var1.method2835(var2);
      this.field1206 = 0;
      this.field1202 = class166.method2970() + 30000L;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-2136887713"
   )
   byte[] method1436() throws IOException {
      if(class166.method2970() > this.field1202) {
         throw new IOException();
      } else {
         if(this.field1206 == 0) {
            if(this.field1200.field2237 == 2) {
               throw new IOException();
            }

            if(this.field1200.field2237 == 1) {
               this.field1201 = (DataInputStream)this.field1200.field2241;
               this.field1206 = 1;
            }
         }

         if(this.field1206 == 1) {
            this.field1199 += this.field1201.read(this.field1204, this.field1199, this.field1204.length - this.field1199);
            if(this.field1199 == 4) {
               int var1 = (new Buffer(this.field1204)).readInt();
               this.field1203 = new byte[var1];
               this.field1206 = 2;
            }
         }

         if(this.field1206 == 2) {
            this.field1205 += this.field1201.read(this.field1203, this.field1205, this.field1203.length - this.field1205);
            if(this.field1203.length == this.field1205) {
               return this.field1203;
            }
         }

         return null;
      }
   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-274780839"
   )
   static final int method1438(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = class61.tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * class61.tileHeights[var5][var3][var4] >> 7;
         int var9 = var6 * class61.tileHeights[var5][var3 + 1][var4 + 1] + class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return (128 - var7) * var8 + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }

   @ObfuscatedName("gz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method1439() {
      int var0 = class109.menuX;
      int var1 = class24.menuY;
      int var2 = class154.menuWidth;
      int var3 = class37.menuHeight;
      int var4 = 6116423;
      Rasterizer2D.method4826(var0, var1, var2, var3, var4);
      Rasterizer2D.method4826(var0 + 1, var1 + 1, var2 - 2, 16, 0);
      Rasterizer2D.method4888(var0 + 1, var1 + 18, var2 - 2, var3 - 19, 0);
      class64.field788.method4647("Choose Option", var0 + 3, var1 + 14, var4, -1);
      int var5 = class59.field730;
      int var6 = class59.field731;

      int var7;
      int var8;
      int var9;
      for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
         var8 = var1 + 31 + (Client.menuOptionCount - 1 - var7) * 15;
         var9 = 16777215;
         if(var5 > var0 && var5 < var0 + var2 && var6 > var8 - 13 && var6 < var8 + 3) {
            var9 = 16776960;
         }

         Font var10 = class64.field788;
         String var11;
         if(var7 < 0) {
            var11 = "";
         } else if(Client.menuTargets[var7].length() > 0) {
            var11 = Client.menuOptions[var7] + " " + Client.menuTargets[var7];
         } else {
            var11 = Client.menuOptions[var7];
         }

         var10.method4647(var11, var0 + 3, var8, var9, 0);
      }

      var7 = class109.menuX;
      var8 = class24.menuY;
      var9 = class154.menuWidth;
      int var12 = class37.menuHeight;

      for(int var13 = 0; var13 < Client.field1109; ++var13) {
         if(Client.widgetPositionX[var13] + Client.widgetBoundsWidth[var13] > var7 && Client.widgetPositionX[var13] < var7 + var9 && Client.widgetPositionY[var13] + Client.widgetBoundsHeight[var13] > var8 && Client.widgetPositionY[var13] < var8 + var12) {
            Client.field1112[var13] = true;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "-1783641298"
   )
   public static void method1440(class69 var0) {
      class46.method671(var0, 200000);
   }
}
