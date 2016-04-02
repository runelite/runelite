import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public final class class134 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1502781045
   )
   int field2064 = '\ufde8';
   @ObfuscatedName("w")
   class228 field2065 = null;
   @ObfuscatedName("f")
   class228 field2066 = null;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 408518253
   )
   int field2067;
   @ObfuscatedName("qg")
   public static class77 field2070;
   @ObfuscatedName("e")
   static byte[] field2071 = new byte[520];

   @ObfuscatedName("e")
   public byte[] method2851(int var1) {
      class228 var2 = this.field2065;
      synchronized(this.field2065) {
         try {
            Object var10000;
            if(this.field2066.method4136() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2066.method4135((long)(var1 * 6));
               this.field2066.method4138(field2071, 0, 6);
               int var3 = ((field2071[0] & 255) << 16) + ((field2071[1] & 255) << 8) + (field2071[2] & 255);
               int var4 = ((field2071[4] & 255) << 8) + ((field2071[3] & 255) << 16) + (field2071[5] & 255);
               if(var3 < 0 || var3 > this.field2064) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2065.method4136() / 520L) {
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

                     this.field2065.method4135((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2065.method4138(field2071, 0, var8 + 8);
                     int var9 = (field2071[1] & 255) + ((field2071[0] & 255) << 8);
                     int var10 = (field2071[3] & 255) + ((field2071[2] & 255) << 8);
                     int var11 = ((field2071[4] & 255) << 16) + ((field2071[5] & 255) << 8) + (field2071[6] & 255);
                     int var12 = field2071[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.field2067 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2065.method4136() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2071[8 + var13];
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

   @ObfuscatedName("e")
   public static String method2853(byte[] var0) {
      return class20.method566(var0, 0, var0.length);
   }

   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2067 = var1;
      this.field2065 = var2;
      this.field2066 = var3;
      this.field2064 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "10"
   )
   public static String method2854(int var0, int var1) {
      if(var0 < 0) {
         return Integer.toString(var0, var1);
      } else {
         int var2 = 2;

         for(int var3 = var0 / var1; var3 != 0; ++var2) {
            var3 /= var1;
         }

         char[] var4 = new char[var2];
         var4[0] = 43;

         for(int var5 = var2 - 1; var5 > 0; --var5) {
            int var6 = var0;
            var0 /= var1;
            int var7 = var6 - var0 * var1;
            if(var7 >= 10) {
               var4[var5] = (char)(87 + var7);
            } else {
               var4[var5] = (char)(var7 + 48);
            }
         }

         return new String(var4);
      }
   }

   @ObfuscatedName("w")
   public boolean method2859(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2065;
      synchronized(this.field2065) {
         if(var3 >= 0 && var3 <= this.field2064) {
            boolean var5 = this.method2863(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2863(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("cx")
   static final void method2861(int var0, int var1, int var2, int var3, int var4) {
      class217.field3162[0].method1880(var0, var1);
      class217.field3162[1].method1880(var0, var3 + var1 - 16);
      class79.method1809(var0, var1 + 16, 16, var3 - 32, client.field357);
      int var5 = (var3 - 32) * var3 / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      class79.method1809(var0, var6 + var1 + 16, 16, var5, client.field330);
      class79.method1819(var0, var6 + 16 + var1, var5, client.field360);
      class79.method1819(1 + var0, var1 + 16 + var6, var5, client.field360);
      class79.method1822(var0, var6 + 16 + var1, 16, client.field360);
      class79.method1822(var0, var1 + 17 + var6, 16, client.field360);
      class79.method1819(15 + var0, var1 + 16 + var6, var5, client.field475);
      class79.method1819(var0 + 14, var6 + var1 + 17, var5 - 1, client.field475);
      class79.method1822(var0, 15 + var1 + var6 + var5, 16, client.field475);
      class79.method1822(var0 + 1, var6 + var1 + 14 + var5, 15, client.field475);
   }

   @ObfuscatedName("f")
   boolean method2863(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2065;
      synchronized(this.field2065) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2066.method4136() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2066.method4135((long)(var1 * 6));
               this.field2066.method4138(field2071, 0, 6);
               var6 = ((field2071[3] & 255) << 16) + ((field2071[4] & 255) << 8) + (field2071[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2065.method4136() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2065.method4136() + 519L) / 520L);
               if(0 == var6) {
                  var6 = 1;
               }
            }

            field2071[0] = (byte)(var3 >> 16);
            field2071[1] = (byte)(var3 >> 8);
            field2071[2] = (byte)var3;
            field2071[3] = (byte)(var6 >> 16);
            field2071[4] = (byte)(var6 >> 8);
            field2071[5] = (byte)var6;
            this.field2066.method4135((long)(6 * var1));
            this.field2066.method4137(field2071, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label141: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2065.method4135((long)(var6 * 520));

                        try {
                           this.field2065.method4138(field2071, 0, 8);
                        } catch (EOFException var14) {
                           break label141;
                        }

                        var10 = (field2071[1] & 255) + ((field2071[0] & 255) << 8);
                        int var11 = ((field2071[2] & 255) << 8) + (field2071[3] & 255);
                        var9 = (field2071[6] & 255) + ((field2071[4] & 255) << 16) + ((field2071[5] & 255) << 8);
                        int var12 = field2071[7] & 255;
                        if(var1 != var10 || var8 != var11 || this.field2067 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2065.method4136() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2065.method4136() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var9 == var6) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2071[0] = (byte)(var1 >> 8);
                     field2071[1] = (byte)var1;
                     field2071[2] = (byte)(var8 >> 8);
                     field2071[3] = (byte)var8;
                     field2071[4] = (byte)(var9 >> 16);
                     field2071[5] = (byte)(var9 >> 8);
                     field2071[6] = (byte)var9;
                     field2071[7] = (byte)this.field2067;
                     this.field2065.method4135((long)(520 * var6));
                     this.field2065.method4137(field2071, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2065.method4137(var2, var7, var10);
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

   @ObfuscatedName("f")
   public static int method2864(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(1 == var2?7 - var0 - (var3 - 1):(2 == var2?7 - var1 - (var4 - 1):var0));
   }
}
