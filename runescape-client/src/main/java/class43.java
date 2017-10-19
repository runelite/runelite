import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class43 {
   @ObfuscatedName("lj")
   @ObfuscatedGetter(
      intValue = -1480953943
   )
   static int field593;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -835559075
   )
   int field591;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 16397277
   )
   int field588;
   @ObfuscatedName("q")
   int[][] field589;
   @ObfuscatedName("g")
   int[][] field587;
   @ObfuscatedName("o")
   int[][] field594;
   @ObfuscatedName("v")
   int[][] field592;

   class43(int var1, int var2) {
      this.field591 = var1;
      this.field588 = var2;
      this.field589 = new int[var1][var2];
      this.field594 = new int[var1][var2];
      this.field587 = new int[var1][var2];
      this.field592 = new int[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "6625"
   )
   int method608(int var1, int var2) {
      if(var1 >= 0 && var2 >= 0 && var1 < this.field591 && var2 < this.field588) {
         if(this.field587[var1][var2] == 0) {
            return 0;
         } else {
            int var3 = this.field589[var1][var2] / this.field592[var1][var2];
            int var4 = this.field594[var1][var2] / this.field592[var1][var2];
            int var5 = this.field587[var1][var2] / this.field592[var1][var2];
            return class28.method247((double)var3 / 256.0D, (double)var4 / 256.0D, (double)var5 / 256.0D);
         }
      } else {
         return 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIILix;I)V",
      garbageValue = "1557139451"
   )
   void method613(int var1, int var2, int var3, FloorUnderlayDefinition var4) {
      if(var4 != null) {
         if(var3 + var1 >= 0 && var3 + var2 >= 0) {
            if(var1 - var3 <= this.field591 && var2 - var3 <= this.field588) {
               int var5 = Math.max(0, var1 - var3);
               int var6 = Math.min(this.field591, var3 + var1);
               int var7 = Math.max(0, var2 - var3);
               int var8 = Math.min(this.field588, var3 + var2);

               for(int var9 = var5; var9 < var6; ++var9) {
                  for(int var10 = var7; var10 < var8; ++var10) {
                     this.field589[var9][var10] += var4.hue * 256 / var4.hueMultiplier;
                     this.field594[var9][var10] += var4.saturation;
                     this.field587[var9][var10] += var4.lightness;
                     ++this.field592[var9][var10];
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([Lhj;IIIZI)V",
      garbageValue = "-83714598"
   )
   static void method614(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class61.method1065(var6, var2, var3, var4);
            AbstractSoundSystem.method2114(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               GZipDecompressor.method3159(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZS)Z",
      garbageValue = "6627"
   )
   public static boolean method607(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
