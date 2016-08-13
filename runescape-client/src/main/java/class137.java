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
      class231 var5 = this.field2128;
      synchronized(this.field2128) {
         if(var3 >= 0 && var3 <= this.field2132) {
            boolean var6 = this.method3007(var1, var2, var3, true);
            if(!var6) {
               var6 = this.method3007(var1, var2, var3, false);
            }

            return var6;
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
      class231 var6 = this.field2128;
      synchronized(this.field2128) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if(var4) {
               if(this.field2135.method4303() < (long)(var1 * 6 + 6)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.field2135.method4293((long)(var1 * 6));
               this.field2135.method4295(field2130, 0, 6);
               var7 = (field2130[5] & 255) + ((field2130[4] & 255) << 8) + ((field2130[3] & 255) << 16);
               if(var7 <= 0 || (long)var7 > this.field2128.method4303() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.field2128.method4303() + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            field2130[0] = (byte)(var3 >> 16);
            field2130[1] = (byte)(var3 >> 8);
            field2130[2] = (byte)var3;
            field2130[3] = (byte)(var7 >> 16);
            field2130[4] = (byte)(var7 >> 8);
            field2130[5] = (byte)var7;
            this.field2135.method4293((long)(6 * var1));
            this.field2135.method4298(field2130, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while(true) {
               if(var9 < var3) {
                  label129: {
                     int var11 = 0;
                     int var12;
                     if(var4) {
                        this.field2128.method4293((long)(var7 * 520));

                        try {
                           this.field2128.method4295(field2130, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = (field2130[1] & 255) + ((field2130[0] & 255) << 8);
                        int var13 = ((field2130[2] & 255) << 8) + (field2130[3] & 255);
                        var11 = (field2130[6] & 255) + ((field2130[4] & 255) << 16) + ((field2130[5] & 255) << 8);
                        int var14 = field2130[7] & 255;
                        if(var1 != var12 || var13 != var10 || var14 != this.field2131) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.field2128.method4303() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if(var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.field2128.method4303() + 519L) / 520L);
                        if(var11 == 0) {
                           ++var11;
                        }

                        if(var11 == var7) {
                           ++var11;
                        }
                     }

                     if(var3 - var9 <= 512) {
                        var11 = 0;
                     }

                     field2130[0] = (byte)(var1 >> 8);
                     field2130[1] = (byte)var1;
                     field2130[2] = (byte)(var10 >> 8);
                     field2130[3] = (byte)var10;
                     field2130[4] = (byte)(var11 >> 16);
                     field2130[5] = (byte)(var11 >> 8);
                     field2130[6] = (byte)var11;
                     field2130[7] = (byte)this.field2131;
                     this.field2128.method4293((long)(var7 * 520));
                     this.field2128.method4298(field2130, 0, 8);
                     var12 = var3 - var9;
                     if(var12 > 512) {
                        var12 = 512;
                     }

                     this.field2128.method4298(var2, var9, var12);
                     var9 += var12;
                     var7 = var11;
                     ++var10;
                     continue;
                  }
               }

               var8 = true;
               var10000 = var8;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "-23"
   )
   public static ModIcon method3010(class170 var0, String var1, String var2) {
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
      signature = "(IILclass110;LCollisionData;I)Z",
      garbageValue = "662864465"
   )
   static final boolean method3015(int var0, int var1, class110 var2, CollisionData var3) {
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
      int var13 = var10 + 1;
      class109.field1942[var10] = var1;
      int[][] var14 = var3.flags;

      while(var13 != var11) {
         var4 = class109.field1935[var11];
         var5 = class109.field1942[var11];
         var11 = 1 + var11 & 4095;
         int var15 = var4 - var8;
         int var16 = var5 - var9;
         int var17 = var4 - var3.x;
         int var18 = var5 - var3.y;
         if(var2.vmethod2486(2, var4, var5, var3)) {
            class93.field1634 = var4;
            class109.field1937 = var5;
            return true;
         }

         int var19 = 1 + class109.field1938[var15][var16];
         if(var15 > 0 && class109.field1941[var15 - 1][var16] == 0 && (var14[var17 - 1][var18] & 19136782) == 0 && (var14[var17 - 1][var18 + 1] & 19136824) == 0) {
            class109.field1935[var13] = var4 - 1;
            class109.field1942[var13] = var5;
            var13 = var13 + 1 & 4095;
            class109.field1941[var15 - 1][var16] = 2;
            class109.field1938[var15 - 1][var16] = var19;
         }

         if(var15 < 126 && class109.field1941[var15 + 1][var16] == 0 && (var14[var17 + 2][var18] & 19136899) == 0 && (var14[var17 + 2][var18 + 1] & 19136992) == 0) {
            class109.field1935[var13] = var4 + 1;
            class109.field1942[var13] = var5;
            var13 = 1 + var13 & 4095;
            class109.field1941[1 + var15][var16] = 8;
            class109.field1938[var15 + 1][var16] = var19;
         }

         if(var16 > 0 && class109.field1941[var15][var16 - 1] == 0 && (var14[var17][var18 - 1] & 19136782) == 0 && (var14[var17 + 1][var18 - 1] & 19136899) == 0) {
            class109.field1935[var13] = var4;
            class109.field1942[var13] = var5 - 1;
            var13 = 1 + var13 & 4095;
            class109.field1941[var15][var16 - 1] = 1;
            class109.field1938[var15][var16 - 1] = var19;
         }

         if(var16 < 126 && class109.field1941[var15][var16 + 1] == 0 && (var14[var17][var18 + 2] & 19136824) == 0 && (var14[var17 + 1][var18 + 2] & 19136992) == 0) {
            class109.field1935[var13] = var4;
            class109.field1942[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class109.field1941[var15][var16 + 1] = 4;
            class109.field1938[var15][1 + var16] = var19;
         }

         if(var15 > 0 && var16 > 0 && class109.field1941[var15 - 1][var16 - 1] == 0 && (var14[var17 - 1][var18] & 19136830) == 0 && (var14[var17 - 1][var18 - 1] & 19136782) == 0 && (var14[var17][var18 - 1] & 19136911) == 0) {
            class109.field1935[var13] = var4 - 1;
            class109.field1942[var13] = var5 - 1;
            var13 = 1 + var13 & 4095;
            class109.field1941[var15 - 1][var16 - 1] = 3;
            class109.field1938[var15 - 1][var16 - 1] = var19;
         }

         if(var15 < 126 && var16 > 0 && class109.field1941[1 + var15][var16 - 1] == 0 && (var14[var17 + 1][var18 - 1] & 19136911) == 0 && (var14[var17 + 2][var18 - 1] & 19136899) == 0 && (var14[2 + var17][var18] & 19136995) == 0) {
            class109.field1935[var13] = var4 + 1;
            class109.field1942[var13] = var5 - 1;
            var13 = var13 + 1 & 4095;
            class109.field1941[var15 + 1][var16 - 1] = 9;
            class109.field1938[1 + var15][var16 - 1] = var19;
         }

         if(var15 > 0 && var16 < 126 && class109.field1941[var15 - 1][var16 + 1] == 0 && (var14[var17 - 1][1 + var18] & 19136830) == 0 && (var14[var17 - 1][var18 + 2] & 19136824) == 0 && (var14[var17][2 + var18] & 19137016) == 0) {
            class109.field1935[var13] = var4 - 1;
            class109.field1942[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class109.field1941[var15 - 1][var16 + 1] = 6;
            class109.field1938[var15 - 1][var16 + 1] = var19;
         }

         if(var15 < 126 && var16 < 126 && class109.field1941[var15 + 1][var16 + 1] == 0 && (var14[1 + var17][2 + var18] & 19137016) == 0 && (var14[var17 + 2][2 + var18] & 19136992) == 0 && (var14[var17 + 2][1 + var18] & 19136995) == 0) {
            class109.field1935[var13] = var4 + 1;
            class109.field1942[var13] = 1 + var5;
            var13 = 1 + var13 & 4095;
            class109.field1941[1 + var15][var16 + 1] = 12;
            class109.field1938[1 + var15][1 + var16] = var19;
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
      class231 var3 = this.field2128;
      synchronized(this.field2128) {
         byte[] var10000;
         try {
            Object var4;
            if(this.field2135.method4303() < (long)(6 + 6 * var1)) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            this.field2135.method4293((long)(6 * var1));
            this.field2135.method4295(field2130, 0, 6);
            int var5 = ((field2130[0] & 255) << 16) + ((field2130[1] & 255) << 8) + (field2130[2] & 255);
            int var6 = (field2130[5] & 255) + ((field2130[3] & 255) << 16) + ((field2130[4] & 255) << 8);
            if(var5 < 0 || var5 > this.field2132) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            if(var6 > 0 && (long)var6 <= this.field2128.method4303() / 520L) {
               byte[] var7 = new byte[var5];
               int var8 = 0;
               int var9 = 0;

               while(var8 < var5) {
                  if(var6 == 0) {
                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }

                  this.field2128.method4293((long)(520 * var6));
                  int var10 = var5 - var8;
                  if(var10 > 512) {
                     var10 = 512;
                  }

                  this.field2128.method4295(field2130, 0, 8 + var10);
                  int var11 = ((field2130[0] & 255) << 8) + (field2130[1] & 255);
                  int var12 = ((field2130[2] & 255) << 8) + (field2130[3] & 255);
                  int var13 = (field2130[6] & 255) + ((field2130[5] & 255) << 8) + ((field2130[4] & 255) << 16);
                  int var14 = field2130[7] & 255;
                  if(var11 == var1 && var12 == var9 && var14 == this.field2131) {
                     if(var13 >= 0 && (long)var13 <= this.field2128.method4303() / 520L) {
                        for(int var15 = 0; var15 < var10; ++var15) {
                           var7[var8++] = field2130[8 + var15];
                        }

                        var6 = var13;
                        ++var9;
                        continue;
                     }

                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }

                  var4 = null;
                  var10000 = (byte[])((byte[])var4);
                  return var10000;
               }

               var10000 = var7;
               return var10000;
            }

            var4 = null;
            var10000 = (byte[])((byte[])var4);
         } catch (IOException var17) {
            return null;
         }

         return var10000;
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
