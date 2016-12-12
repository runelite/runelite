import java.awt.datatransfer.Clipboard;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public final class class116 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1273508589
   )
   int field1809;
   @ObfuscatedName("f")
   class72 field1810 = null;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1799758135
   )
   int field1811 = '\ufde8';
   @ObfuscatedName("k")
   class72 field1812 = null;
   @ObfuscatedName("pt")
   static Clipboard field1814;
   @ObfuscatedName("js")
   @ObfuscatedGetter(
      intValue = 1261600693
   )
   static int field1815;
   @ObfuscatedName("e")
   static byte[] field1816 = new byte[520];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "18"
   )
   boolean method2198(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1810;
      synchronized(this.field1810) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1812.method1359() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1812.method1356((long)(6 * var1));
               this.field1812.method1361(field1816, 0, 6);
               var6 = ((field1816[3] & 255) << 16) + ((field1816[4] & 255) << 8) + (field1816[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field1810.method1359() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1810.method1359() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1816[0] = (byte)(var3 >> 16);
            field1816[1] = (byte)(var3 >> 8);
            field1816[2] = (byte)var3;
            field1816[3] = (byte)(var6 >> 16);
            field1816[4] = (byte)(var6 >> 8);
            field1816[5] = (byte)var6;
            this.field1812.method1356((long)(6 * var1));
            this.field1812.method1366(field1816, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1810.method1356((long)(var6 * 520));

                        try {
                           this.field1810.method1361(field1816, 0, 8);
                        } catch (EOFException var16) {
                           break label143;
                        }

                        var14 = ((field1816[0] & 255) << 8) + (field1816[1] & 255);
                        int var11 = (field1816[3] & 255) + ((field1816[2] & 255) << 8);
                        var9 = ((field1816[4] & 255) << 16) + ((field1816[5] & 255) << 8) + (field1816[6] & 255);
                        int var12 = field1816[7] & 255;
                        if(var14 != var1 || var8 != var11 || var12 != this.field1809) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1810.method1359() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1810.method1359() + 519L) / 520L);
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

                     field1816[0] = (byte)(var1 >> 8);
                     field1816[1] = (byte)var1;
                     field1816[2] = (byte)(var8 >> 8);
                     field1816[3] = (byte)var8;
                     field1816[4] = (byte)(var9 >> 16);
                     field1816[5] = (byte)(var9 >> 8);
                     field1816[6] = (byte)var9;
                     field1816[7] = (byte)this.field1809;
                     this.field1810.method1356((long)(520 * var6));
                     this.field1810.method1366(field1816, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1810.method1366(var2, var7, var14);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "-917574158"
   )
   public static void method2199(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1914 = 1;
      class145.field2014 = var0;
      class30.field693 = var1;
      class138.field1915 = var2;
      ItemLayer.field1220 = var3;
      ItemLayer.field1221 = var4;
      class138.field1916 = 10000;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-557161960"
   )
   static final byte[] method2200(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.method2844();
      if(var3 < 0 || class182.field2713 != 0 && var3 > class182.field2713) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var6 = new byte[var3];
         var1.method2770(var6, 0, var3);
         return var6;
      } else {
         int var4 = var1.method2844();
         if(var4 >= 0 && (class182.field2713 == 0 || var4 <= class182.field2713)) {
            byte[] var5 = new byte[var4];
            if(var2 == 1) {
               class147.method2701(var5, var4, var0, var3, 9);
            } else {
               class182.field2723.method2695(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1809 = var1;
      this.field1810 = var2;
      this.field1812 = var3;
      this.field1811 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "111"
   )
   public byte[] method2206(int var1) {
      class72 var2 = this.field1810;
      synchronized(this.field1810) {
         try {
            Object var10000;
            if(this.field1812.method1359() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1812.method1356((long)(6 * var1));
               this.field1812.method1361(field1816, 0, 6);
               int var3 = (field1816[2] & 255) + ((field1816[1] & 255) << 8) + ((field1816[0] & 255) << 16);
               int var4 = (field1816[5] & 255) + ((field1816[4] & 255) << 8) + ((field1816[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field1811) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1810.method1359() / 520L) {
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

                     this.field1810.method1356((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1810.method1361(field1816, 0, var8 + 8);
                     int var9 = (field1816[1] & 255) + ((field1816[0] & 255) << 8);
                     int var10 = ((field1816[2] & 255) << 8) + (field1816[3] & 255);
                     int var11 = ((field1816[4] & 255) << 16) + ((field1816[5] & 255) << 8) + (field1816[6] & 255);
                     int var12 = field1816[7] & 255;
                     if(var1 == var9 && var10 == var7 && var12 == this.field1809) {
                        if(var11 >= 0 && (long)var11 <= this.field1810.method1359() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1816[var13 + 8];
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-79"
   )
   static final int method2207(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (789221 + var2 * var2 * 15731) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "61"
   )
   public boolean method2208(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1810;
      synchronized(this.field1810) {
         if(var3 >= 0 && var3 <= this.field1811) {
            boolean var5 = this.method2198(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2198(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }
}
