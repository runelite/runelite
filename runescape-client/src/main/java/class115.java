import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class115 {
   @ObfuscatedName("t")
   public static int[] field1599;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1087875361
   )
   int field1601;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -892215269
   )
   int field1598;
   @ObfuscatedName("m")
   int[][] field1603;

   public class115(int var1, int var2) {
      if(var2 != var1) {
         int var3 = class33.method360(var1, var2);
         var1 /= var3;
         var2 /= var3;
         this.field1601 = var1;
         this.field1598 = var2;
         this.field1603 = new int[var1][14];

         for(int var4 = 0; var4 < var1; ++var4) {
            int[] var5 = this.field1603[var4];
            double var6 = 6.0D + (double)var4 / (double)var1;
            int var8 = (int)Math.floor(var6 - 7.0D + 1.0D);
            if(var8 < 0) {
               var8 = 0;
            }

            int var9 = (int)Math.ceil(var6 + 7.0D);
            if(var9 > 14) {
               var9 = 14;
            }

            for(double var10 = (double)var2 / (double)var1; var8 < var9; ++var8) {
               double var12 = ((double)var8 - var6) * 3.141592653589793D;
               double var14 = var10;
               if(var12 < -1.0E-4D || var12 > 1.0E-4D) {
                  var14 = var10 * (Math.sin(var12) / var12);
               }

               var14 *= 0.54D + 0.46D * Math.cos(((double)var8 - var6) * 0.2243994752564138D);
               var5[var8] = (int)Math.floor(65536.0D * var14 + 0.5D);
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-2007002635"
   )
   byte[] method2211(byte[] var1) {
      if(this.field1603 != null) {
         int var2 = (int)((long)this.field1598 * (long)var1.length / (long)this.field1601) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1603[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var8[var9] * var7;
            }

            var5 += this.field1598;
            var9 = var5 / this.field1601;
            var4 += var9;
            var5 -= var9 * this.field1601;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + 32768 >> 16;
            if(var10 < -128) {
               var1[var6] = -128;
            } else if(var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "15"
   )
   int method2212(int var1) {
      if(this.field1603 != null) {
         var1 = (int)((long)var1 * (long)this.field1598 / (long)this.field1601);
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "851446851"
   )
   int method2210(int var1) {
      if(this.field1603 != null) {
         var1 = (int)((long)this.field1598 * (long)var1 / (long)this.field1601) + 6;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZB)Z",
      garbageValue = "-3"
   )
   static boolean method2216(File var0, boolean var1) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1822129768"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class295.field3849 = var1.readUnsignedShort();
      class295.field3848 = new int[class295.field3849];
      class295.offsetsY = new int[class295.field3849];
      class295.field3845 = new int[class295.field3849];
      class285.field3788 = new int[class295.field3849];
      class15.spritePixels = new byte[class295.field3849][];
      var1.offset = var0.length - 7 - class295.field3849 * 8;
      class295.field3846 = var1.readUnsignedShort();
      class295.field3847 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class295.field3849; ++var3) {
         class295.field3848[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3849; ++var3) {
         class295.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3849; ++var3) {
         class295.field3845[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class295.field3849; ++var3) {
         class285.field3788[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class295.field3849 * 8 - (var2 - 1) * 3;
      field1599 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         field1599[var3] = var1.read24BitInt();
         if(field1599[var3] == 0) {
            field1599[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class295.field3849; ++var3) {
         int var4 = class295.field3845[var3];
         int var5 = class285.field3788[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class15.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }
}
