import java.awt.FontMetrics;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public final class class137 {
   @ObfuscatedName("r")
   class231 field2120 = null;
   @ObfuscatedName("j")
   class231 field2121 = null;
   @ObfuscatedName("x")
   static byte[] field2123 = new byte[520];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 339880013
   )
   int field2124 = '\ufde8';
   @ObfuscatedName("bf")
   protected static FontMetrics field2125;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1812758545
   )
   int field2128;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-286442011"
   )
   public boolean method2912(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2120;
      synchronized(this.field2120) {
         if(var3 >= 0 && var3 <= this.field2124) {
            boolean var5 = this.method2914(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2914(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1633947991"
   )
   public byte[] method2913(int var1) {
      class231 var2 = this.field2120;
      synchronized(this.field2120) {
         try {
            Object var10000;
            if(this.field2121.method4160() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2121.method4159((long)(6 * var1));
               this.field2121.method4173(field2123, 0, 6);
               int var3 = (field2123[2] & 255) + ((field2123[1] & 255) << 8) + ((field2123[0] & 255) << 16);
               int var4 = (field2123[5] & 255) + ((field2123[3] & 255) << 16) + ((field2123[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2124) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2120.method4160() / 520L) {
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

                     this.field2120.method4159((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2120.method4173(field2123, 0, 8 + var8);
                     int var9 = (field2123[1] & 255) + ((field2123[0] & 255) << 8);
                     int var10 = (field2123[3] & 255) + ((field2123[2] & 255) << 8);
                     int var11 = ((field2123[5] & 255) << 8) + ((field2123[4] & 255) << 16) + (field2123[6] & 255);
                     int var12 = field2123[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.field2128 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2120.method4160() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2123[8 + var13];
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

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2128 = var1;
      this.field2120 = var2;
      this.field2121 = var3;
      this.field2124 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "-118"
   )
   boolean method2914(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2120;
      synchronized(this.field2120) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2121.method4160() < (long)(6 + 6 * var1)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2121.method4159((long)(var1 * 6));
               this.field2121.method4173(field2123, 0, 6);
               var6 = (field2123[5] & 255) + ((field2123[4] & 255) << 8) + ((field2123[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2120.method4160() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2120.method4160() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2123[0] = (byte)(var3 >> 16);
            field2123[1] = (byte)(var3 >> 8);
            field2123[2] = (byte)var3;
            field2123[3] = (byte)(var6 >> 16);
            field2123[4] = (byte)(var6 >> 8);
            field2123[5] = (byte)var6;
            this.field2121.method4159((long)(var1 * 6));
            this.field2121.method4157(field2123, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label147: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2120.method4159((long)(var6 * 520));

                        try {
                           this.field2120.method4173(field2123, 0, 8);
                        } catch (EOFException var16) {
                           break label147;
                        }

                        var14 = ((field2123[0] & 255) << 8) + (field2123[1] & 255);
                        int var11 = (field2123[3] & 255) + ((field2123[2] & 255) << 8);
                        var9 = (field2123[6] & 255) + ((field2123[4] & 255) << 16) + ((field2123[5] & 255) << 8);
                        int var12 = field2123[7] & 255;
                        if(var1 != var14 || var11 != var8 || this.field2128 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2120.method4160() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2120.method4160() + 519L) / 520L);
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

                     field2123[0] = (byte)(var1 >> 8);
                     field2123[1] = (byte)var1;
                     field2123[2] = (byte)(var8 >> 8);
                     field2123[3] = (byte)var8;
                     field2123[4] = (byte)(var9 >> 16);
                     field2123[5] = (byte)(var9 >> 8);
                     field2123[6] = (byte)var9;
                     field2123[7] = (byte)this.field2128;
                     this.field2120.method4159((long)(520 * var6));
                     this.field2120.method4157(field2123, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2120.method4157(var2, var7, var14);
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

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-221070808"
   )
   static final String method2916(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }
}
