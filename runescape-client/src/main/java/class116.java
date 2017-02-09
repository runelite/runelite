import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
public final class class116 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -574312905
   )
   int field1812;
   @ObfuscatedName("k")
   static byte[] field1813 = new byte[520];
   @ObfuscatedName("o")
   class72 field1814 = null;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1841581581
   )
   int field1816 = '\ufde8';
   @ObfuscatedName("x")
   static int[] field1818;
   @ObfuscatedName("y")
   class72 field1819 = null;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "-21"
   )
   public boolean method2227(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1819;
      synchronized(this.field1819) {
         if(var3 >= 0 && var3 <= this.field1816) {
            boolean var5 = this.method2229(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2229(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-2111630270"
   )
   boolean method2229(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1819;
      synchronized(this.field1819) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1814.method1412() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1814.method1404((long)(var1 * 6));
               this.field1814.method1413(field1813, 0, 6);
               var6 = (field1813[5] & 255) + ((field1813[4] & 255) << 8) + ((field1813[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field1819.method1412() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1819.method1412() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1813[0] = (byte)(var3 >> 16);
            field1813[1] = (byte)(var3 >> 8);
            field1813[2] = (byte)var3;
            field1813[3] = (byte)(var6 >> 16);
            field1813[4] = (byte)(var6 >> 8);
            field1813[5] = (byte)var6;
            this.field1814.method1404((long)(var1 * 6));
            this.field1814.method1394(field1813, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1819.method1404((long)(520 * var6));

                        try {
                           this.field1819.method1413(field1813, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field1813[1] & 255) + ((field1813[0] & 255) << 8);
                        int var11 = (field1813[3] & 255) + ((field1813[2] & 255) << 8);
                        var9 = (field1813[6] & 255) + ((field1813[5] & 255) << 8) + ((field1813[4] & 255) << 16);
                        int var12 = field1813[7] & 255;
                        if(var14 != var1 || var8 != var11 || this.field1812 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1819.method1412() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1819.method1412() + 519L) / 520L);
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

                     field1813[0] = (byte)(var1 >> 8);
                     field1813[1] = (byte)var1;
                     field1813[2] = (byte)(var8 >> 8);
                     field1813[3] = (byte)var8;
                     field1813[4] = (byte)(var9 >> 16);
                     field1813[5] = (byte)(var9 >> 8);
                     field1813[6] = (byte)var9;
                     field1813[7] = (byte)this.field1812;
                     this.field1819.method1404((long)(var6 * 520));
                     this.field1819.method1394(field1813, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1819.method1394(var2, var7, var14);
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

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1812 = var1;
      this.field1819 = var2;
      this.field1814 = var3;
      this.field1816 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1184803808"
   )
   public byte[] method2236(int var1) {
      class72 var2 = this.field1819;
      synchronized(this.field1819) {
         try {
            Object var10000;
            if(this.field1814.method1412() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1814.method1404((long)(var1 * 6));
               this.field1814.method1413(field1813, 0, 6);
               int var3 = (field1813[2] & 255) + ((field1813[1] & 255) << 8) + ((field1813[0] & 255) << 16);
               int var4 = (field1813[5] & 255) + ((field1813[4] & 255) << 8) + ((field1813[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field1816) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1819.method1412() / 520L) {
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

                     this.field1819.method1404((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1819.method1413(field1813, 0, var8 + 8);
                     int var9 = ((field1813[0] & 255) << 8) + (field1813[1] & 255);
                     int var10 = ((field1813[2] & 255) << 8) + (field1813[3] & 255);
                     int var11 = ((field1813[4] & 255) << 16) + ((field1813[5] & 255) << 8) + (field1813[6] & 255);
                     int var12 = field1813[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.field1812 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1819.method1412() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1813[var13 + 8];
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
}
