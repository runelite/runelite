import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public final class class116 {
   @ObfuscatedName("d")
   class72 field1813 = null;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -873631339
   )
   static int field1815;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -703274027
   )
   int field1816;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1441718691
   )
   int field1817 = '\ufde8';
   @ObfuscatedName("q")
   static byte[] field1818 = new byte[520];
   @ObfuscatedName("bn")
   static class184 field1819;
   @ObfuscatedName("h")
   class72 field1824 = null;
   @ObfuscatedName("pk")
   static class230 field1825;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1263553282"
   )
   public byte[] method2293(int var1) {
      class72 var2 = this.field1824;
      synchronized(this.field1824) {
         try {
            Object var10000;
            if(this.field1813.method1452() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1813.method1453((long)(6 * var1));
               this.field1813.method1441(field1818, 0, 6);
               int var3 = ((field1818[0] & 255) << 16) + ((field1818[1] & 255) << 8) + (field1818[2] & 255);
               int var4 = (field1818[5] & 255) + ((field1818[3] & 255) << 16) + ((field1818[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field1817) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1824.method1452() / 520L) {
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

                     this.field1824.method1453((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1824.method1441(field1818, 0, 8 + var8);
                     int var9 = ((field1818[0] & 255) << 8) + (field1818[1] & 255);
                     int var10 = ((field1818[2] & 255) << 8) + (field1818[3] & 255);
                     int var11 = ((field1818[4] & 255) << 16) + ((field1818[5] & 255) << 8) + (field1818[6] & 255);
                     int var12 = field1818[7] & 255;
                     if(var1 == var9 && var10 == var7 && this.field1816 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1824.method1452() / 520L) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "87"
   )
   public boolean method2295(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1824;
      synchronized(this.field1824) {
         if(var3 >= 0 && var3 <= this.field1817) {
            boolean var5 = this.method2301(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2301(var1, var2, var3, false);
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
      this.field1816 = var1;
      this.field1824 = var2;
      this.field1813 = var3;
      this.field1817 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1981895018"
   )
   boolean method2301(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1824;
      synchronized(this.field1824) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1813.method1452() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1813.method1453((long)(var1 * 6));
               this.field1813.method1441(field1818, 0, 6);
               var6 = ((field1818[3] & 255) << 16) + ((field1818[4] & 255) << 8) + (field1818[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field1824.method1452() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1824.method1452() + 519L) / 520L);
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
            this.field1813.method1453((long)(6 * var1));
            this.field1813.method1436(field1818, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label142: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1824.method1453((long)(520 * var6));

                        try {
                           this.field1824.method1441(field1818, 0, 8);
                        } catch (EOFException var16) {
                           break label142;
                        }

                        var14 = (field1818[1] & 255) + ((field1818[0] & 255) << 8);
                        int var11 = ((field1818[2] & 255) << 8) + (field1818[3] & 255);
                        var9 = ((field1818[4] & 255) << 16) + ((field1818[5] & 255) << 8) + (field1818[6] & 255);
                        int var12 = field1818[7] & 255;
                        if(var1 != var14 || var8 != var11 || this.field1816 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1824.method1452() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1824.method1452() + 519L) / 520L);
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

                     field1818[0] = (byte)(var1 >> 8);
                     field1818[1] = (byte)var1;
                     field1818[2] = (byte)(var8 >> 8);
                     field1818[3] = (byte)var8;
                     field1818[4] = (byte)(var9 >> 16);
                     field1818[5] = (byte)(var9 >> 8);
                     field1818[6] = (byte)var9;
                     field1818[7] = (byte)this.field1816;
                     this.field1824.method1453((long)(520 * var6));
                     this.field1824.method1436(field1818, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1824.method1436(var2, var7, var14);
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

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIIIII)V",
      garbageValue = "-470973957"
   )
   static final void method2304(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.field386) {
         Client.field478 = 32;
      } else {
         Client.field478 = 0;
      }

      Client.field386 = false;
      int var7;
      if(class115.field1794 == 1 || !class15.field173 && class115.field1794 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class174.method3276(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class174.method3276(var0);
         } else if(var5 >= var1 - Client.field478 && var5 < Client.field478 + 16 + var1 && var6 >= 16 + var2 && var6 < var2 + var3 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class174.method3276(var0);
            Client.field386 = true;
         }
      }

      if(Client.field503 != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var2 + var3) {
            var0.scrollY += Client.field503 * 45;
            class174.method3276(var0);
         }
      }

   }
}
