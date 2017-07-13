import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class43 {
   @ObfuscatedName("go")
   @Export("mapfunctions")
   static SpritePixels[] mapfunctions;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      intValue = -757455759
   )
   static int field559;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1078706799
   )
   int field552;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1297976311
   )
   int field562;
   @ObfuscatedName("n")
   int[][] field554;
   @ObfuscatedName("v")
   int[][] field556;
   @ObfuscatedName("r")
   int[][] field560;
   @ObfuscatedName("e")
   int[][] field557;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "64"
   )
   class43(int var1, int var2) {
      this.field552 = var1;
      this.field562 = var2;
      this.field554 = new int[var1][var2];
      this.field560 = new int[var1][var2];
      this.field556 = new int[var1][var2];
      this.field557 = new int[var1][var2];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "899579177"
   )
   int method629(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field552 && var2 < this.field562) {
         if(this.field556[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field554[var1][var2] / this.field557[var1][var2];
            int var4 = this.field560[var1][var2] / this.field557[var1][var2];
            int var5 = this.field556[var1][var2] / this.field557[var1][var2];
            return DState.method3120((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIILFloorUnderlayDefinition;I)V",
      garbageValue = "-1450139735"
   )
   void method623(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field552 && var2 - var3 <= this.field562) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field552, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field562, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field554[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field560[var9][var10] += var4.saturation;
                     this.field556[var9][var10] += var4.lightness;
                     ++this.field557[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1248332865"
   )
   static final boolean method630() {
      return class134.field1999;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)LSpritePixels;",
      garbageValue = "1989840981"
   )
   public static final SpritePixels method622(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-910593024"
   )
   public static void method628() {
      try {
         File var0 = new File(class66.userHome, "random.dat");
         int var2;
         if(var0.exists()) {
            class155.field2239 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var4 = 0; var4 < class77.field1212.length; ++var4) {
               for(var2 = 0; var2 < class2.cacheLocations.length; ++var2) {
                  File var3 = new File(class2.cacheLocations[var2] + class77.field1212[var4] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class155.field2239 = new CacheFile(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class155.field2239 == null) {
            RandomAccessFile var1 = new RandomAccessFile(var0, "rw");
            var2 = var1.read();
            var1.seek(0L);
            var1.write(var2);
            var1.seek(0L);
            var1.close();
            class155.field2239 = new CacheFile(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
