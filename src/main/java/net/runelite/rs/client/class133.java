package net.runelite.rs.client;

import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("er")
public final class class133 {
   @ObfuscatedName("m")
   class227 field2055 = null;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1896356483
   )
   int field2057;
   @ObfuscatedName("h")
   static byte[][][] field2058;
   @ObfuscatedName("j")
   static byte[] field2059 = new byte[520];
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 513528253
   )
   static int field2060;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -644577751
   )
   int field2061 = '\ufde8';
   @ObfuscatedName("f")
   class227 field2062 = null;

   @ObfuscatedName("j")
   public byte[] method2898(int var1) {
      class227 var2 = this.field2055;
      synchronized(this.field2055) {
         try {
            Object var10000;
            if(this.field2062.method4191() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2062.method4188((long)(var1 * 6));
               this.field2062.method4193(field2059, 0, 6);
               int var3 = (field2059[2] & 255) + ((field2059[0] & 255) << 16) + ((field2059[1] & 255) << 8);
               int var4 = ((field2059[4] & 255) << 8) + ((field2059[3] & 255) << 16) + (field2059[5] & 255);
               if(var3 < 0 || var3 > this.field2061) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2055.method4191() / 520L) {
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

                     this.field2055.method4188((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2055.method4193(field2059, 0, var8 + 8);
                     int var9 = (field2059[1] & 255) + ((field2059[0] & 255) << 8);
                     int var10 = (field2059[3] & 255) + ((field2059[2] & 255) << 8);
                     int var11 = ((field2059[5] & 255) << 8) + ((field2059[4] & 255) << 16) + (field2059[6] & 255);
                     int var12 = field2059[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field2057 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2055.method4191() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2059[8 + var13];
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

   @ObfuscatedName("m")
   public boolean method2899(int var1, byte[] var2, int var3) {
      class227 var4 = this.field2055;
      synchronized(this.field2055) {
         if(var3 >= 0 && var3 <= this.field2061) {
            boolean var5 = this.method2900(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2900(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("f")
   boolean method2900(int var1, byte[] var2, int var3, boolean var4) {
      class227 var5 = this.field2055;
      synchronized(this.field2055) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2062.method4191() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2062.method4188((long)(var1 * 6));
               this.field2062.method4193(field2059, 0, 6);
               var6 = (field2059[5] & 255) + ((field2059[3] & 255) << 16) + ((field2059[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2055.method4191() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2055.method4191() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2059[0] = (byte)(var3 >> 16);
            field2059[1] = (byte)(var3 >> 8);
            field2059[2] = (byte)var3;
            field2059[3] = (byte)(var6 >> 16);
            field2059[4] = (byte)(var6 >> 8);
            field2059[5] = (byte)var6;
            this.field2062.method4188((long)(6 * var1));
            this.field2062.method4195(field2059, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2055.method4188((long)(520 * var6));

                        try {
                           this.field2055.method4193(field2059, 0, 8);
                        } catch (EOFException var14) {
                           break label143;
                        }

                        var10 = ((field2059[0] & 255) << 8) + (field2059[1] & 255);
                        int var11 = (field2059[3] & 255) + ((field2059[2] & 255) << 8);
                        var9 = ((field2059[4] & 255) << 16) + ((field2059[5] & 255) << 8) + (field2059[6] & 255);
                        int var12 = field2059[7] & 255;
                        if(var1 != var10 || var11 != var8 || this.field2057 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2055.method4191() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(0 == var9) {
                        var4 = false;
                        var9 = (int)((this.field2055.method4191() + 519L) / 520L);
                        if(0 == var9) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2059[0] = (byte)(var1 >> 8);
                     field2059[1] = (byte)var1;
                     field2059[2] = (byte)(var8 >> 8);
                     field2059[3] = (byte)var8;
                     field2059[4] = (byte)(var9 >> 16);
                     field2059[5] = (byte)(var9 >> 8);
                     field2059[6] = (byte)var9;
                     field2059[7] = (byte)this.field2057;
                     this.field2055.method4188((long)(var6 * 520));
                     this.field2055.method4195(field2059, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2055.method4195(var2, var7, var10);
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

   public class133(int var1, class227 var2, class227 var3, int var4) {
      this.field2057 = var1;
      this.field2055 = var2;
      this.field2062 = var3;
      this.field2061 = var4;
   }
}
