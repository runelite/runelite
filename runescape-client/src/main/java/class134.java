import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public final class class134 {
   @ObfuscatedName("h")
   class228 field2053 = null;
   @ObfuscatedName("m")
   class228 field2054 = null;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1930398907
   )
   int field2055;
   @ObfuscatedName("j")
   static byte[] field2056 = new byte[520];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -788405465
   )
   int field2057 = '\ufde8';

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Lclass44;",
      garbageValue = "1938841786"
   )
   public static class44 method2830(int var0) {
      class44 var1 = (class44)class44.field1012.method3704((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class44.field1010.method3217(3, var0);
         var1 = new class44();
         if(null != var2) {
            var1.method903(new class119(var2));
         }

         class44.field1012.method3706(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-399131215"
   )
   public byte[] method2831(int var1) {
      class228 var2 = this.field2053;
      synchronized(this.field2053) {
         try {
            Object var10000;
            if(this.field2054.method4108() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2054.method4132((long)(6 * var1));
               this.field2054.method4123(field2056, 0, 6);
               int var3 = ((field2056[0] & 255) << 16) + ((field2056[1] & 255) << 8) + (field2056[2] & 255);
               int var4 = ((field2056[4] & 255) << 8) + ((field2056[3] & 255) << 16) + (field2056[5] & 255);
               if(var3 < 0 || var3 > this.field2057) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2053.method4108() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(0 == var4) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2053.method4132((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2053.method4123(field2056, 0, 8 + var8);
                     int var9 = ((field2056[0] & 255) << 8) + (field2056[1] & 255);
                     int var10 = (field2056[3] & 255) + ((field2056[2] & 255) << 8);
                     int var11 = (field2056[6] & 255) + ((field2056[4] & 255) << 16) + ((field2056[5] & 255) << 8);
                     int var12 = field2056[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field2055 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2053.method4108() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2056[8 + var13];
                           }

                           var4 = var11;
                           ++var7;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var17 = var5;
                  return var17;
               }
            }
         } catch (IOException var15) {
            return null;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "83"
   )
   public boolean method2832(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2053;
      synchronized(this.field2053) {
         if(var3 >= 0 && var3 <= this.field2057) {
            boolean var5 = this.method2833(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2833(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "2094873892"
   )
   boolean method2833(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2053;
      synchronized(this.field2053) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2054.method4108() < (long)(6 + 6 * var1)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2054.method4132((long)(var1 * 6));
               this.field2054.method4123(field2056, 0, 6);
               var6 = ((field2056[4] & 255) << 8) + ((field2056[3] & 255) << 16) + (field2056[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2053.method4108() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2053.method4108() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2056[0] = (byte)(var3 >> 16);
            field2056[1] = (byte)(var3 >> 8);
            field2056[2] = (byte)var3;
            field2056[3] = (byte)(var6 >> 16);
            field2056[4] = (byte)(var6 >> 8);
            field2056[5] = (byte)var6;
            this.field2054.method4132((long)(var1 * 6));
            this.field2054.method4112(field2056, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2053.method4132((long)(var6 * 520));

                        try {
                           this.field2053.method4123(field2056, 0, 8);
                        } catch (EOFException var14) {
                           break label144;
                        }

                        var10 = ((field2056[0] & 255) << 8) + (field2056[1] & 255);
                        int var11 = ((field2056[2] & 255) << 8) + (field2056[3] & 255);
                        var9 = (field2056[6] & 255) + ((field2056[5] & 255) << 8) + ((field2056[4] & 255) << 16);
                        int var12 = field2056[7] & 255;
                        if(var10 != var1 || var11 != var8 || var12 != this.field2055) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2053.method4108() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2053.method4108() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2056[0] = (byte)(var1 >> 8);
                     field2056[1] = (byte)var1;
                     field2056[2] = (byte)(var8 >> 8);
                     field2056[3] = (byte)var8;
                     field2056[4] = (byte)(var9 >> 16);
                     field2056[5] = (byte)(var9 >> 8);
                     field2056[6] = (byte)var9;
                     field2056[7] = (byte)this.field2055;
                     this.field2053.method4132((long)(var6 * 520));
                     this.field2053.method4112(field2056, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2053.method4112(var2, var7, var10);
                     var7 += var10;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var15) {
            return false;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass228;Lclass228;I)V",
      garbageValue = "500000"
   )
   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2055 = var1;
      this.field2053 = var2;
      this.field2054 = var3;
      this.field2057 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2027699076"
   )
   public static void method2838() {
      if(class136.field2076.toLowerCase().indexOf("microsoft") != -1) {
         class137.field2108[186] = 57;
         class137.field2108[187] = 27;
         class137.field2108[188] = 71;
         class137.field2108[189] = 26;
         class137.field2108[190] = 72;
         class137.field2108[191] = 73;
         class137.field2108[192] = 58;
         class137.field2108[219] = 42;
         class137.field2108[220] = 74;
         class137.field2108[221] = 43;
         class137.field2108[222] = 59;
         class137.field2108[223] = 28;
      } else {
         class137.field2108[44] = 71;
         class137.field2108[45] = 26;
         class137.field2108[46] = 72;
         class137.field2108[47] = 73;
         class137.field2108[59] = 57;
         class137.field2108[61] = 27;
         class137.field2108[91] = 42;
         class137.field2108[92] = 74;
         class137.field2108[93] = 43;
         class137.field2108[192] = 28;
         class137.field2108[222] = 58;
         class137.field2108[520] = 59;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "0"
   )
   public static boolean method2840(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         return true;
      } catch (Exception var4) {
         return false;
      }
   }
}
