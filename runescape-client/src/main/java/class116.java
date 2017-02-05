import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
public final class class116 {
   @ObfuscatedName("g")
   class72 field1818 = null;
   @ObfuscatedName("p")
   static byte[] field1819 = new byte[520];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2038849519
   )
   int field1820;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -142165433
   )
   int field1821 = '\ufde8';
   @ObfuscatedName("x")
   class72 field1823 = null;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-85"
   )
   public byte[] method2240(int var1) {
      class72 var2 = this.field1818;
      synchronized(this.field1818) {
         try {
            Object var10000;
            if(this.field1823.method1393() < (long)(6 * var1 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1823.method1369((long)(6 * var1));
               this.field1823.method1371(field1819, 0, 6);
               int var3 = (field1819[2] & 255) + ((field1819[0] & 255) << 16) + ((field1819[1] & 255) << 8);
               int var4 = ((field1819[4] & 255) << 8) + ((field1819[3] & 255) << 16) + (field1819[5] & 255);
               if(var3 < 0 || var3 > this.field1821) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1818.method1393() / 520L) {
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

                     this.field1818.method1369((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1818.method1371(field1819, 0, var8 + 8);
                     int var9 = (field1819[1] & 255) + ((field1819[0] & 255) << 8);
                     int var10 = ((field1819[2] & 255) << 8) + (field1819[3] & 255);
                     int var11 = ((field1819[4] & 255) << 16) + ((field1819[5] & 255) << 8) + (field1819[6] & 255);
                     int var12 = field1819[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.field1820 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1818.method1393() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1819[var13 + 8];
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "111"
   )
   public static void method2241(class182 var0) {
      FloorUnderlayDefinition.field2811 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "525491987"
   )
   boolean method2242(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1818;
      synchronized(this.field1818) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1823.method1393() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1823.method1369((long)(var1 * 6));
               this.field1823.method1371(field1819, 0, 6);
               var6 = (field1819[5] & 255) + ((field1819[4] & 255) << 8) + ((field1819[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field1818.method1393() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1818.method1393() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1819[0] = (byte)(var3 >> 16);
            field1819[1] = (byte)(var3 >> 8);
            field1819[2] = (byte)var3;
            field1819[3] = (byte)(var6 >> 16);
            field1819[4] = (byte)(var6 >> 8);
            field1819[5] = (byte)var6;
            this.field1823.method1369((long)(var1 * 6));
            this.field1823.method1373(field1819, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1818.method1369((long)(520 * var6));

                        try {
                           this.field1818.method1371(field1819, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = (field1819[1] & 255) + ((field1819[0] & 255) << 8);
                        int var11 = (field1819[3] & 255) + ((field1819[2] & 255) << 8);
                        var9 = ((field1819[5] & 255) << 8) + ((field1819[4] & 255) << 16) + (field1819[6] & 255);
                        int var12 = field1819[7] & 255;
                        if(var14 != var1 || var11 != var8 || var12 != this.field1820) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1818.method1393() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1818.method1393() + 519L) / 520L);
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

                     field1819[0] = (byte)(var1 >> 8);
                     field1819[1] = (byte)var1;
                     field1819[2] = (byte)(var8 >> 8);
                     field1819[3] = (byte)var8;
                     field1819[4] = (byte)(var9 >> 16);
                     field1819[5] = (byte)(var9 >> 8);
                     field1819[6] = (byte)var9;
                     field1819[7] = (byte)this.field1820;
                     this.field1818.method1369((long)(var6 * 520));
                     this.field1818.method1373(field1819, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1818.method1373(var2, var7, var14);
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "-9"
   )
   public boolean method2246(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1818;
      synchronized(this.field1818) {
         if(var3 >= 0 && var3 <= this.field1821) {
            boolean var5 = this.method2242(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2242(var1, var2, var3, false);
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
      this.field1820 = var1;
      this.field1818 = var2;
      this.field1823 = var3;
      this.field1821 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-880578261"
   )
   static int method2251(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method2374((long)var0);
      if(null == var2) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var1 == var2.itemIds[var4]) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }
}
