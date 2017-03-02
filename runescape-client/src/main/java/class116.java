import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public final class class116 {
   @ObfuscatedName("t")
   class72 field1812 = null;
   @ObfuscatedName("l")
   class72 field1813 = null;
   @ObfuscatedName("b")
   static byte[] field1814 = new byte[520];
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1410118733
   )
   int field1816 = '\ufde8';
   @ObfuscatedName("by")
   static ModIcon[] field1817;
   @ObfuscatedName("o")
   public static class72[] field1821;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1546762577
   )
   int field1823;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1611529807"
   )
   public boolean method2309(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1813;
      synchronized(this.field1813) {
         if(var3 >= 0 && var3 <= this.field1816) {
            boolean var5 = this.method2310(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2310(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "1251711753"
   )
   boolean method2310(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1813;
      synchronized(this.field1813) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1812.method1463() < (long)(6 + 6 * var1)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1812.method1436((long)(6 * var1));
               this.field1812.method1439(field1814, 0, 6);
               var6 = (field1814[5] & 255) + ((field1814[4] & 255) << 8) + ((field1814[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field1813.method1463() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1813.method1463() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1814[0] = (byte)(var3 >> 16);
            field1814[1] = (byte)(var3 >> 8);
            field1814[2] = (byte)var3;
            field1814[3] = (byte)(var6 >> 16);
            field1814[4] = (byte)(var6 >> 8);
            field1814[5] = (byte)var6;
            this.field1812.method1436((long)(6 * var1));
            this.field1812.method1461(field1814, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1813.method1436((long)(520 * var6));

                        try {
                           this.field1813.method1439(field1814, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = ((field1814[0] & 255) << 8) + (field1814[1] & 255);
                        int var11 = ((field1814[2] & 255) << 8) + (field1814[3] & 255);
                        var9 = (field1814[6] & 255) + ((field1814[5] & 255) << 8) + ((field1814[4] & 255) << 16);
                        int var12 = field1814[7] & 255;
                        if(var1 != var14 || var8 != var11 || var12 != this.field1823) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1813.method1463() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1813.method1463() + 519L) / 520L);
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

                     field1814[0] = (byte)(var1 >> 8);
                     field1814[1] = (byte)var1;
                     field1814[2] = (byte)(var8 >> 8);
                     field1814[3] = (byte)var8;
                     field1814[4] = (byte)(var9 >> 16);
                     field1814[5] = (byte)(var9 >> 8);
                     field1814[6] = (byte)var9;
                     field1814[7] = (byte)this.field1823;
                     this.field1813.method1436((long)(520 * var6));
                     this.field1813.method1461(field1814, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1813.method1461(var2, var7, var14);
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
      this.field1823 = var1;
      this.field1813 = var2;
      this.field1812 = var3;
      this.field1816 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "970163386"
   )
   public byte[] method2312(int var1) {
      class72 var2 = this.field1813;
      synchronized(this.field1813) {
         try {
            Object var10000;
            if(this.field1812.method1463() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1812.method1436((long)(6 * var1));
               this.field1812.method1439(field1814, 0, 6);
               int var3 = (field1814[2] & 255) + ((field1814[1] & 255) << 8) + ((field1814[0] & 255) << 16);
               int var4 = (field1814[5] & 255) + ((field1814[4] & 255) << 8) + ((field1814[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field1816) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1813.method1463() / 520L) {
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

                     this.field1813.method1436((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1813.method1439(field1814, 0, 8 + var8);
                     int var9 = ((field1814[0] & 255) << 8) + (field1814[1] & 255);
                     int var10 = ((field1814[2] & 255) << 8) + (field1814[3] & 255);
                     int var11 = ((field1814[5] & 255) << 8) + ((field1814[4] & 255) << 16) + (field1814[6] & 255);
                     int var12 = field1814[7] & 255;
                     if(var1 == var9 && var10 == var7 && var12 == this.field1823) {
                        if(var11 >= 0 && (long)var11 <= this.field1813.method1463() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1814[8 + var13];
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
