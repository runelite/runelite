import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class118 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -122197303
   )
   public static int field1676;
   @ObfuscatedName("o")
   static int[] field1673;
   @ObfuscatedName("f")
   int[][] field1677;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -589034293
   )
   int field1674;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -906069983
   )
   int field1675;

   public class118(int var1, int var2) {
      if(var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if(var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.field1675 = var1;
         this.field1674 = var2;
         this.field1677 = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.field1677[var7];
            double var9 = 6.0D + (double)var7 / (double)var1;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if(var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if(var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = 3.141592653589793D * ((double)var11 - var9);
               double var17 = var13;
               if(var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
               var8[var11] = (int)Math.floor(0.5D + 65536.0D * var17);
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1435412965"
   )
   byte[] method2180(byte[] var1) {
      if(this.field1677 != null) {
         int var2 = (int)((long)this.field1674 * (long)var1.length / (long)this.field1675) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.field1677[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var4 + var9] += var7 * var8[var9];
            }

            var5 += this.field1674;
            var9 = var5 / this.field1675;
            var4 += var9;
            var5 -= var9 * this.field1675;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   int method2181(int var1) {
      if(this.field1677 != null) {
         var1 = (int)((long)this.field1674 * (long)var1 / (long)this.field1675);
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-103"
   )
   int method2188(int var1) {
      if(this.field1677 != null) {
         var1 = (int)((long)var1 * (long)this.field1674 / (long)this.field1675) + 6;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Lff;",
      garbageValue = "1432660067"
   )
   public static Timer method2191() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-2004937219"
   )
   static File method2190(String var0) {
      if(!class157.field2232) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2235.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2233, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2235.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   public static final void method2185(int var0, int var1) {
      class134.field1967 = var0;
      class134.field1964 = var1;
      class134.field1973 = true;
      class134.field1970 = 0;
      class134.field1965 = false;
   }
}
