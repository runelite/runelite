import java.io.EOFException;
import java.io.IOException;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 296619661
   )
   @Export("index")
   int index;
   @ObfuscatedName("c")
   static byte[] field1819 = new byte[520];
   @ObfuscatedName("d")
   class72 field1820 = null;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1856765907
   )
   int field1822 = '\ufde8';
   @ObfuscatedName("n")
   class72 field1825 = null;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "1"
   )
   public boolean method2234(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1825;
      synchronized(this.field1825) {
         if(var3 >= 0 && var3 <= this.field1822) {
            boolean var5 = this.method2235(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2235(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "1403989477"
   )
   boolean method2235(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1825;
      synchronized(this.field1825) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1820.method1396() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1820.method1395((long)(var1 * 6));
               this.field1820.method1401(field1819, 0, 6);
               var6 = ((field1819[4] & 255) << 8) + ((field1819[3] & 255) << 16) + (field1819[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field1825.method1396() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1825.method1396() + 519L) / 520L);
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
            this.field1820.method1395((long)(var1 * 6));
            this.field1820.method1415(field1819, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1825.method1395((long)(var6 * 520));

                        try {
                           this.field1825.method1401(field1819, 0, 8);
                        } catch (EOFException var16) {
                           break label143;
                        }

                        var14 = (field1819[1] & 255) + ((field1819[0] & 255) << 8);
                        int var11 = ((field1819[2] & 255) << 8) + (field1819[3] & 255);
                        var9 = (field1819[6] & 255) + ((field1819[4] & 255) << 16) + ((field1819[5] & 255) << 8);
                        int var12 = field1819[7] & 255;
                        if(var1 != var14 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1825.method1396() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1825.method1396() + 519L) / 520L);
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

                     field1819[0] = (byte)(var1 >> 8);
                     field1819[1] = (byte)var1;
                     field1819[2] = (byte)(var8 >> 8);
                     field1819[3] = (byte)var8;
                     field1819[4] = (byte)(var9 >> 16);
                     field1819[5] = (byte)(var9 >> 8);
                     field1819[6] = (byte)var9;
                     field1819[7] = (byte)this.index;
                     this.field1825.method1395((long)(var6 * 520));
                     this.field1825.method1415(field1819, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1825.method1415(var2, var7, var14);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "611406008"
   )
   public byte[] method2242(int var1) {
      class72 var2 = this.field1825;
      synchronized(this.field1825) {
         try {
            Object var10000;
            if(this.field1820.method1396() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1820.method1395((long)(var1 * 6));
               this.field1820.method1401(field1819, 0, 6);
               int var3 = ((field1819[0] & 255) << 16) + ((field1819[1] & 255) << 8) + (field1819[2] & 255);
               int var4 = (field1819[5] & 255) + ((field1819[3] & 255) << 16) + ((field1819[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field1822) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1825.method1396() / 520L) {
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

                     this.field1825.method1395((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1825.method1401(field1819, 0, var8 + 8);
                     int var9 = (field1819[1] & 255) + ((field1819[0] & 255) << 8);
                     int var10 = ((field1819[2] & 255) << 8) + (field1819[3] & 255);
                     int var11 = (field1819[6] & 255) + ((field1819[4] & 255) << 16) + ((field1819[5] & 255) << 8);
                     int var12 = field1819[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.index == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1825.method1396() / 520L) {
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
      signature = "(LCipherBuffer;II)Z",
      garbageValue = "-119979071"
   )
   static boolean method2245(CipherBuffer var0, int var1) {
      int var2 = var0.method2645(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method2645(1) != 0) {
            method2245(var0, var1);
         }

         var3 = var0.method2645(13);
         var4 = var0.method2645(13);
         boolean var12 = var0.method2645(1) == 1;
         if(var12) {
            class45.field899[++class45.field902 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field257 = var1;
            if(class45.field890[var1] != null) {
               var6.method227(class45.field890[var1]);
            }

            var6.field650 = class45.field900[var1];
            var6.interacting = class45.field897[var1];
            var7 = class45.field895[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field618[0] = class45.field889[var1];
            var6.field256 = (byte)var8;
            var6.method236(var3 + (var9 << 13) - class108.baseX, (var10 << 13) + var4 - GameEngine.baseY);
            var6.field255 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2645(2);
         var4 = class45.field895[var1];
         class45.field895[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method2645(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field895[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field895[var1] = (var8 << 14) + (var7 << 28) + var9;
            return false;
         } else {
            var3 = var0.method2645(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field895[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var11 + var7 & 255;
            class45.field895[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class72 var2, class72 var3, int var4) {
      this.index = var1;
      this.field1825 = var2;
      this.field1820 = var3;
      this.field1822 = var4;
   }

   @ObfuscatedName("d")
   public static String method2247(long var0) {
      class138.field2004.setTime(new Date(var0));
      int var2 = class138.field2004.get(7);
      int var3 = class138.field2004.get(5);
      int var4 = class138.field2004.get(2);
      int var5 = class138.field2004.get(1);
      int var6 = class138.field2004.get(11);
      int var7 = class138.field2004.get(12);
      int var8 = class138.field2004.get(13);
      return class138.field2002[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class138.field2003[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
