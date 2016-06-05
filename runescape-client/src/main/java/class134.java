import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public final class class134 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1338762371
   )
   int field2088;
   @ObfuscatedName("h")
   class228 field2090 = null;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -353964303
   )
   int field2092 = '\ufde8';
   @ObfuscatedName("o")
   public static class228[] field2093;
   @ObfuscatedName("t")
   static byte[] field2094 = new byte[520];
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1793116201
   )
   static int field2095;
   @ObfuscatedName("g")
   class228 field2096 = null;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "0"
   )
   public boolean method2831(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2096;
      synchronized(this.field2096) {
         if(var3 >= 0 && var3 <= this.field2092) {
            boolean var5 = this.method2832(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2832(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass228;Lclass228;I)V",
      garbageValue = "500000"
   )
   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2088 = var1;
      this.field2096 = var2;
      this.field2090 = var3;
      this.field2092 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1992337681"
   )
   boolean method2832(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2096;
      synchronized(this.field2096) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2090.method4097() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2090.method4096((long)(6 * var1));
               this.field2090.method4104(field2094, 0, 6);
               var6 = ((field2094[3] & 255) << 16) + ((field2094[4] & 255) << 8) + (field2094[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2096.method4097() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2096.method4097() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2094[0] = (byte)(var3 >> 16);
            field2094[1] = (byte)(var3 >> 8);
            field2094[2] = (byte)var3;
            field2094[3] = (byte)(var6 >> 16);
            field2094[4] = (byte)(var6 >> 8);
            field2094[5] = (byte)var6;
            this.field2090.method4096((long)(6 * var1));
            this.field2090.method4113(field2094, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label135: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        label154: {
                           this.field2096.method4096((long)(var6 * 520));

                           try {
                              this.field2096.method4104(field2094, 0, 8);
                           } catch (EOFException var16) {
                              break label135;
                           }

                           var14 = ((field2094[0] & 255) << 8) + (field2094[1] & 255);
                           int var11 = ((field2094[2] & 255) << 8) + (field2094[3] & 255);
                           var9 = (field2094[6] & 255) + ((field2094[5] & 255) << 8) + ((field2094[4] & 255) << 16);
                           int var12 = field2094[7] & 255;
                           if(var14 == var1 && var8 == var11 && this.field2088 == var12) {
                              if(var9 >= 0 && (long)var9 <= this.field2096.method4097() / 520L) {
                                 break label154;
                              }

                              var10000 = false;
                              return var10000;
                           }

                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2096.method4097() + 519L) / 520L);
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

                     field2094[0] = (byte)(var1 >> 8);
                     field2094[1] = (byte)var1;
                     field2094[2] = (byte)(var8 >> 8);
                     field2094[3] = (byte)var8;
                     field2094[4] = (byte)(var9 >> 16);
                     field2094[5] = (byte)(var9 >> 8);
                     field2094[6] = (byte)var9;
                     field2094[7] = (byte)this.field2088;
                     this.field2096.method4096((long)(520 * var6));
                     this.field2096.method4113(field2094, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2096.method4113(var2, var7, var14);
                     var7 += var14;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1907520946"
   )
   public byte[] method2833(int var1) {
      class228 var2 = this.field2096;
      synchronized(this.field2096) {
         try {
            Object var10000;
            if(this.field2090.method4097() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2090.method4096((long)(6 * var1));
               this.field2090.method4104(field2094, 0, 6);
               int var3 = ((field2094[0] & 255) << 16) + ((field2094[1] & 255) << 8) + (field2094[2] & 255);
               int var4 = (field2094[5] & 255) + ((field2094[3] & 255) << 16) + ((field2094[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2092) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2096.method4097() / 520L) {
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

                     this.field2096.method4096((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2096.method4104(field2094, 0, 8 + var8);
                     int var9 = (field2094[1] & 255) + ((field2094[0] & 255) << 8);
                     int var10 = (field2094[3] & 255) + ((field2094[2] & 255) << 8);
                     int var11 = ((field2094[5] & 255) << 8) + ((field2094[4] & 255) << 16) + (field2094[6] & 255);
                     int var12 = field2094[7] & 255;
                     if(var1 == var9 && var10 == var7 && this.field2088 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2096.method4097() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2094[var13 + 8];
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

                  byte[] var18 = var5;
                  return var18;
               }
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-2022356729"
   )
   public static boolean method2842(int var0) {
      return (var0 >> 29 & 1) != 0;
   }
}
