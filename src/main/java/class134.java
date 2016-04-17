import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
public final class class134 {
   @ObfuscatedName("pl")
   static class134 field2072;
   @ObfuscatedName("w")
   class228 field2073 = null;
   @ObfuscatedName("d")
   class228 field2074 = null;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1511637305
   )
   int field2075;
   @ObfuscatedName("a")
   static byte[] field2076 = new byte[520];
   @ObfuscatedName("e")
   static int[] field2077;
   @ObfuscatedName("ps")
   static class8 field2078;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -637692735
   )
   int field2079 = '\ufde8';

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "1031952143"
   )
   public boolean method2977(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2073;
      synchronized(this.field2073) {
         if(var3 >= 0 && var3 <= this.field2079) {
            boolean var5 = this.method2978(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2978(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "0"
   )
   boolean method2978(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2073;
      synchronized(this.field2073) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2074.method4226() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2074.method4222((long)(6 * var1));
               this.field2074.method4244(field2076, 0, 6);
               var6 = (field2076[5] & 255) + ((field2076[3] & 255) << 16) + ((field2076[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2073.method4226() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2073.method4226() + 519L) / 520L);
               if(0 == var6) {
                  var6 = 1;
               }
            }

            field2076[0] = (byte)(var3 >> 16);
            field2076[1] = (byte)(var3 >> 8);
            field2076[2] = (byte)var3;
            field2076[3] = (byte)(var6 >> 16);
            field2076[4] = (byte)(var6 >> 8);
            field2076[5] = (byte)var6;
            this.field2074.method4222((long)(6 * var1));
            this.field2074.method4227(field2076, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2073.method4222((long)(520 * var6));

                        try {
                           this.field2073.method4244(field2076, 0, 8);
                        } catch (EOFException var14) {
                           break label146;
                        }

                        var10 = ((field2076[0] & 255) << 8) + (field2076[1] & 255);
                        int var11 = (field2076[3] & 255) + ((field2076[2] & 255) << 8);
                        var9 = (field2076[6] & 255) + ((field2076[4] & 255) << 16) + ((field2076[5] & 255) << 8);
                        int var12 = field2076[7] & 255;
                        if(var1 != var10 || var8 != var11 || var12 != this.field2075) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2073.method4226() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2073.method4226() + 519L) / 520L);
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

                     field2076[0] = (byte)(var1 >> 8);
                     field2076[1] = (byte)var1;
                     field2076[2] = (byte)(var8 >> 8);
                     field2076[3] = (byte)var8;
                     field2076[4] = (byte)(var9 >> 16);
                     field2076[5] = (byte)(var9 >> 8);
                     field2076[6] = (byte)var9;
                     field2076[7] = (byte)this.field2075;
                     this.field2073.method4222((long)(520 * var6));
                     this.field2073.method4227(field2076, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2073.method4227(var2, var7, var10);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2104833805"
   )
   public byte[] method2979(int var1) {
      class228 var2 = this.field2073;
      synchronized(this.field2073) {
         try {
            Object var10000;
            if(this.field2074.method4226() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2074.method4222((long)(var1 * 6));
               this.field2074.method4244(field2076, 0, 6);
               int var3 = (field2076[2] & 255) + ((field2076[1] & 255) << 8) + ((field2076[0] & 255) << 16);
               int var4 = (field2076[5] & 255) + ((field2076[3] & 255) << 16) + ((field2076[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2079) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2073.method4226() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2073.method4222((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2073.method4244(field2076, 0, 8 + var8);
                     int var9 = ((field2076[0] & 255) << 8) + (field2076[1] & 255);
                     int var10 = ((field2076[2] & 255) << 8) + (field2076[3] & 255);
                     int var11 = (field2076[6] & 255) + ((field2076[5] & 255) << 8) + ((field2076[4] & 255) << 16);
                     int var12 = field2076[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field2075 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2073.method4226() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2076[var13 + 8];
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

   @ObfuscatedSignature(
      signature = "(ILclass228;Lclass228;I)V",
      garbageValue = "500000"
   )
   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2075 = var1;
      this.field2073 = var2;
      this.field2074 = var3;
      this.field2079 = var4;
   }
}
