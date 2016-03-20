import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ei")
public final class class133 {
   @ObfuscatedName("a")
   static byte[] field2064 = new byte[520];
   @ObfuscatedName("f")
   class227 field2066 = null;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -864763929
   )
   int field2067;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 782502415
   )
   int field2068 = '\ufde8';
   @ObfuscatedName("cl")
   static class142 field2069;
   @ObfuscatedName("r")
   class227 field2070 = null;

   @ObfuscatedName("f")
   boolean method2867(int var1, byte[] var2, int var3, boolean var4) {
      class227 var5 = this.field2070;
      synchronized(this.field2070) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2066.method4174() < (long)(6 + var1 * 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2066.method4173((long)(6 * var1));
               this.field2066.method4171(field2064, 0, 6);
               var6 = ((field2064[3] & 255) << 16) + ((field2064[4] & 255) << 8) + (field2064[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2070.method4174() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2070.method4174() + 519L) / 520L);
               if(0 == var6) {
                  var6 = 1;
               }
            }

            field2064[0] = (byte)(var3 >> 16);
            field2064[1] = (byte)(var3 >> 8);
            field2064[2] = (byte)var3;
            field2064[3] = (byte)(var6 >> 16);
            field2064[4] = (byte)(var6 >> 8);
            field2064[5] = (byte)var6;
            this.field2066.method4173((long)(6 * var1));
            this.field2066.method4195(field2064, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label147: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2070.method4173((long)(520 * var6));

                        try {
                           this.field2070.method4171(field2064, 0, 8);
                        } catch (EOFException var14) {
                           break label147;
                        }

                        var10 = ((field2064[0] & 255) << 8) + (field2064[1] & 255);
                        int var11 = (field2064[3] & 255) + ((field2064[2] & 255) << 8);
                        var9 = ((field2064[5] & 255) << 8) + ((field2064[4] & 255) << 16) + (field2064[6] & 255);
                        int var12 = field2064[7] & 255;
                        if(var1 != var10 || var8 != var11 || var12 != this.field2067) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2070.method4174() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2070.method4174() + 519L) / 520L);
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

                     field2064[0] = (byte)(var1 >> 8);
                     field2064[1] = (byte)var1;
                     field2064[2] = (byte)(var8 >> 8);
                     field2064[3] = (byte)var8;
                     field2064[4] = (byte)(var9 >> 16);
                     field2064[5] = (byte)(var9 >> 8);
                     field2064[6] = (byte)var9;
                     field2064[7] = (byte)this.field2067;
                     this.field2070.method4173((long)(520 * var6));
                     this.field2070.method4195(field2064, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2070.method4195(var2, var7, var10);
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

   @ObfuscatedName("r")
   public boolean method2868(int var1, byte[] var2, int var3) {
      class227 var4 = this.field2070;
      synchronized(this.field2070) {
         if(var3 >= 0 && var3 <= this.field2068) {
            boolean var5 = this.method2867(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2867(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   public class133(int var1, class227 var2, class227 var3, int var4) {
      this.field2067 = var1;
      this.field2070 = var2;
      this.field2066 = var3;
      this.field2068 = var4;
   }

   @ObfuscatedName("a")
   public byte[] method2872(int var1) {
      class227 var2 = this.field2070;
      synchronized(this.field2070) {
         try {
            Object var10000;
            if(this.field2066.method4174() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2066.method4173((long)(var1 * 6));
               this.field2066.method4171(field2064, 0, 6);
               int var3 = (field2064[2] & 255) + ((field2064[0] & 255) << 16) + ((field2064[1] & 255) << 8);
               int var4 = ((field2064[4] & 255) << 8) + ((field2064[3] & 255) << 16) + (field2064[5] & 255);
               if(var3 < 0 || var3 > this.field2068) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2070.method4174() / 520L) {
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

                     this.field2070.method4173((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2070.method4171(field2064, 0, 8 + var8);
                     int var9 = ((field2064[0] & 255) << 8) + (field2064[1] & 255);
                     int var10 = (field2064[3] & 255) + ((field2064[2] & 255) << 8);
                     int var11 = (field2064[6] & 255) + ((field2064[4] & 255) << 16) + ((field2064[5] & 255) << 8);
                     int var12 = field2064[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.field2067 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2070.method4174() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2064[8 + var13];
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

   @ObfuscatedName("a")
   public static int method2873(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(1 == var1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }
}
