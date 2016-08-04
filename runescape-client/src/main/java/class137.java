import java.awt.Image;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public final class class137 {
   @ObfuscatedName("g")
   class231 field2128 = null;
   @ObfuscatedName("qn")
   static Image field2129;
   @ObfuscatedName("l")
   static byte[] field2130 = new byte[520];
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 863052927
   )
   int field2131;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 759743639
   )
   int field2132 = '\ufde8';
   @ObfuscatedName("r")
   class231 field2135 = null;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-702111487"
   )
   public boolean method3004(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2128;
      synchronized(this.field2128) {
         if(var3 >= 0 && var3 <= this.field2132) {
            boolean var5 = this.method3007(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3007(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-507474051"
   )
   boolean method3007(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2128;
      synchronized(this.field2128) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2135.method4303() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2135.method4293((long)(var1 * 6));
               this.field2135.method4295(field2130, 0, 6);
               var6 = (field2130[5] & 255) + ((field2130[4] & 255) << 8) + ((field2130[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2128.method4303() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2128.method4303() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2130[0] = (byte)(var3 >> 16);
            field2130[1] = (byte)(var3 >> 8);
            field2130[2] = (byte)var3;
            field2130[3] = (byte)(var6 >> 16);
            field2130[4] = (byte)(var6 >> 8);
            field2130[5] = (byte)var6;
            this.field2135.method4293((long)(6 * var1));
            this.field2135.method4298(field2130, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2128.method4293((long)(var6 * 520));

                        try {
                           this.field2128.method4295(field2130, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = (field2130[1] & 255) + ((field2130[0] & 255) << 8);
                        int var11 = ((field2130[2] & 255) << 8) + (field2130[3] & 255);
                        var9 = (field2130[6] & 255) + ((field2130[4] & 255) << 16) + ((field2130[5] & 255) << 8);
                        int var12 = field2130[7] & 255;
                        if(var1 != var14 || var11 != var8 || var12 != this.field2131) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2128.method4303() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2128.method4303() + 519L) / 520L);
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

                     field2130[0] = (byte)(var1 >> 8);
                     field2130[1] = (byte)var1;
                     field2130[2] = (byte)(var8 >> 8);
                     field2130[3] = (byte)var8;
                     field2130[4] = (byte)(var9 >> 16);
                     field2130[5] = (byte)(var9 >> 8);
                     field2130[6] = (byte)var9;
                     field2130[7] = (byte)this.field2131;
                     this.field2128.method4293((long)(var6 * 520));
                     this.field2128.method4298(field2130, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2128.method4298(var2, var7, var14);
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)Lclass83;",
      garbageValue = "-23"
   )
   public static class83 method3010(class170 var0, String var1, String var2) {
      int var3 = var0.method3410(var1);
      int var4 = var0.method3459(var3, var2);
      return class26.method626(var0, var3, var4);
   }

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2131 = var1;
      this.field2128 = var2;
      this.field2135 = var3;
      this.field2132 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILclass110;Lclass111;I)Z",
      garbageValue = "662864465"
   )
   static final boolean method3015(int var0, int var1, class110 var2, class111 var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class109.field1941[var6][var7] = 99;
      class109.field1938[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class109.field1935[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class109.field1942[var10001] = var1;
      int[][] var12 = var3.field1969;

      while(var18 != var11) {
         var4 = class109.field1935[var11];
         var5 = class109.field1942[var11];
         var11 = 1 + var11 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.field1965;
         int var14 = var5 - var3.field1966;
         if(var2.vmethod2486(2, var4, var5, var3)) {
            class93.field1634 = var4;
            class109.field1937 = var5;
            return true;
         }

         int var15 = 1 + class109.field1938[var16][var17];
         if(var16 > 0 && class109.field1941[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class109.field1935[var18] = var4 - 1;
            class109.field1942[var18] = var5;
            var18 = var18 + 1 & 4095;
            class109.field1941[var16 - 1][var17] = 2;
            class109.field1938[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class109.field1941[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class109.field1935[var18] = var4 + 1;
            class109.field1942[var18] = var5;
            var18 = 1 + var18 & 4095;
            class109.field1941[1 + var16][var17] = 8;
            class109.field1938[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class109.field1941[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class109.field1935[var18] = var4;
            class109.field1942[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1941[var16][var17 - 1] = 1;
            class109.field1938[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class109.field1941[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class109.field1935[var18] = var4;
            class109.field1942[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class109.field1941[var16][var17 + 1] = 4;
            class109.field1938[var16][1 + var17] = var15;
         }

         if(var16 > 0 && var17 > 0 && class109.field1941[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class109.field1935[var18] = var4 - 1;
            class109.field1942[var18] = var5 - 1;
            var18 = 1 + var18 & 4095;
            class109.field1941[var16 - 1][var17 - 1] = 3;
            class109.field1938[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class109.field1941[1 + var16][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[2 + var13][var14] & 19136995) == 0) {
            class109.field1935[var18] = var4 + 1;
            class109.field1942[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class109.field1941[var16 + 1][var17 - 1] = 9;
            class109.field1938[1 + var16][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class109.field1941[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][1 + var14] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][2 + var14] & 19137016) == 0) {
            class109.field1935[var18] = var4 - 1;
            class109.field1942[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class109.field1941[var16 - 1][var17 + 1] = 6;
            class109.field1938[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class109.field1941[var16 + 1][var17 + 1] == 0 && (var12[1 + var13][2 + var14] & 19137016) == 0 && (var12[var13 + 2][2 + var14] & 19136992) == 0 && (var12[var13 + 2][1 + var14] & 19136995) == 0) {
            class109.field1935[var18] = var4 + 1;
            class109.field1942[var18] = 1 + var5;
            var18 = 1 + var18 & 4095;
            class109.field1941[1 + var16][var17 + 1] = 12;
            class109.field1938[1 + var16][1 + var17] = var15;
         }
      }

      class93.field1634 = var4;
      class109.field1937 = var5;
      return false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "623284145"
   )
   public byte[] method3016(int var1) {
      class231 var2 = this.field2128;
      synchronized(this.field2128) {
         try {
            Object var10000;
            if(this.field2135.method4303() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2135.method4293((long)(6 * var1));
               this.field2135.method4295(field2130, 0, 6);
               int var3 = ((field2130[0] & 255) << 16) + ((field2130[1] & 255) << 8) + (field2130[2] & 255);
               int var4 = (field2130[5] & 255) + ((field2130[3] & 255) << 16) + ((field2130[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2132) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2128.method4303() / 520L) {
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

                     this.field2128.method4293((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2128.method4295(field2130, 0, 8 + var8);
                     int var9 = ((field2130[0] & 255) << 8) + (field2130[1] & 255);
                     int var10 = ((field2130[2] & 255) << 8) + (field2130[3] & 255);
                     int var11 = (field2130[6] & 255) + ((field2130[5] & 255) << 8) + ((field2130[4] & 255) << 16);
                     int var12 = field2130[7] & 255;
                     if(var9 == var1 && var10 == var7 && var12 == this.field2131) {
                        if(var11 >= 0 && (long)var11 <= this.field2128.method4303() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2130[8 + var13];
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass170;B)V",
      garbageValue = "0"
   )
   public static void method3017(class170 var0) {
      class52.field1152 = var0;
   }
}
