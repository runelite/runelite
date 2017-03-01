import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public final class class116 {
   @ObfuscatedName("n")
   class72 field1816 = null;
   @ObfuscatedName("g")
   class72 field1817 = null;
   @ObfuscatedName("x")
   static byte[] field1818 = new byte[520];
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1582061949
   )
   int field1819;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1589426511
   )
   int field1820 = '\ufde8';

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1271639467"
   )
   boolean method2331(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1816;
      synchronized(this.field1816) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1817.method1478() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1817.method1464((long)(var1 * 6));
               this.field1817.method1462(field1818, 0, 6);
               var6 = (field1818[5] & 255) + ((field1818[3] & 255) << 16) + ((field1818[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field1816.method1478() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1816.method1478() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1818[0] = (byte)(var3 >> 16);
            field1818[1] = (byte)(var3 >> 8);
            field1818[2] = (byte)var3;
            field1818[3] = (byte)(var6 >> 16);
            field1818[4] = (byte)(var6 >> 8);
            field1818[5] = (byte)var6;
            this.field1817.method1464((long)(6 * var1));
            this.field1817.method1481(field1818, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1816.method1464((long)(var6 * 520));

                        try {
                           this.field1816.method1462(field1818, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field1818[1] & 255) + ((field1818[0] & 255) << 8);
                        int var11 = ((field1818[2] & 255) << 8) + (field1818[3] & 255);
                        var9 = (field1818[6] & 255) + ((field1818[4] & 255) << 16) + ((field1818[5] & 255) << 8);
                        int var12 = field1818[7] & 255;
                        if(var1 != var14 || var11 != var8 || var12 != this.field1819) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1816.method1478() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1816.method1478() + 519L) / 520L);
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

                     field1818[0] = (byte)(var1 >> 8);
                     field1818[1] = (byte)var1;
                     field1818[2] = (byte)(var8 >> 8);
                     field1818[3] = (byte)var8;
                     field1818[4] = (byte)(var9 >> 16);
                     field1818[5] = (byte)(var9 >> 8);
                     field1818[6] = (byte)var9;
                     field1818[7] = (byte)this.field1819;
                     this.field1816.method1464((long)(520 * var6));
                     this.field1816.method1481(field1818, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1816.method1481(var2, var7, var14);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-899723528"
   )
   public byte[] method2332(int var1) {
      class72 var2 = this.field1816;
      synchronized(this.field1816) {
         try {
            Object var10000;
            if(this.field1817.method1478() < (long)(6 * var1 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1817.method1464((long)(6 * var1));
               this.field1817.method1462(field1818, 0, 6);
               int var3 = (field1818[2] & 255) + ((field1818[0] & 255) << 16) + ((field1818[1] & 255) << 8);
               int var4 = ((field1818[3] & 255) << 16) + ((field1818[4] & 255) << 8) + (field1818[5] & 255);
               if(var3 < 0 || var3 > this.field1820) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1816.method1478() / 520L) {
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

                     this.field1816.method1464((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1816.method1462(field1818, 0, var8 + 8);
                     int var9 = (field1818[1] & 255) + ((field1818[0] & 255) << 8);
                     int var10 = ((field1818[2] & 255) << 8) + (field1818[3] & 255);
                     int var11 = (field1818[6] & 255) + ((field1818[4] & 255) << 16) + ((field1818[5] & 255) << 8);
                     int var12 = field1818[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.field1819 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1816.method1478() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1818[8 + var13];
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "90"
   )
   public boolean method2333(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1816;
      synchronized(this.field1816) {
         if(var3 >= 0 && var3 <= this.field1820) {
            boolean var5 = this.method2331(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2331(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1819 = var1;
      this.field1816 = var2;
      this.field1817 = var3;
      this.field1820 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "256000"
   )
   public static void method2341(class182 var0) {
      class188.field2786 = var0;
   }
}
