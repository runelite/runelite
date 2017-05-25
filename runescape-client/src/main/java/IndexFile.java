import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("h")
   static byte[] field2258;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1626530313
   )
   @Export("index")
   int index;
   @ObfuscatedName("q")
   class123 field2260;
   @ObfuscatedName("u")
   class123 field2261;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1455023899
   )
   int field2262;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-2006891739"
   )
   boolean method3057(int var1, byte[] var2, int var3, boolean var4) {
      class123 var5 = this.field2261;
      synchronized(this.field2261) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2260.method2374() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2260.method2358((long)(var1 * 6));
               this.field2260.method2361(field2258, 0, 6);
               var6 = (field2258[5] & 255) + ((field2258[4] & 255) << 8) + ((field2258[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2261.method2374() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2261.method2374() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2258[0] = (byte)(var3 >> 16);
            field2258[1] = (byte)(var3 >> 8);
            field2258[2] = (byte)var3;
            field2258[3] = (byte)(var6 >> 16);
            field2258[4] = (byte)(var6 >> 8);
            field2258[5] = (byte)var6;
            this.field2260.method2358((long)(var1 * 6));
            this.field2260.method2356(field2258, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2261.method2358((long)(var6 * 520));

                        try {
                           this.field2261.method2361(field2258, 0, 8);
                        } catch (EOFException var16) {
                           break label146;
                        }

                        var14 = (field2258[1] & 255) + ((field2258[0] & 255) << 8);
                        int var11 = (field2258[3] & 255) + ((field2258[2] & 255) << 8);
                        var9 = ((field2258[5] & 255) << 8) + ((field2258[4] & 255) << 16) + (field2258[6] & 255);
                        int var12 = field2258[7] & 255;
                        if(var1 != var14 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2261.method2374() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2261.method2374() + 519L) / 520L);
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

                     field2258[0] = (byte)(var1 >> 8);
                     field2258[1] = (byte)var1;
                     field2258[2] = (byte)(var8 >> 8);
                     field2258[3] = (byte)var8;
                     field2258[4] = (byte)(var9 >> 16);
                     field2258[5] = (byte)(var9 >> 8);
                     field2258[6] = (byte)var9;
                     field2258[7] = (byte)this.index;
                     this.field2261.method2358((long)(var6 * 520));
                     this.field2261.method2356(field2258, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2261.method2356(var2, var7, var14);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "-7"
   )
   public byte[] method3058(int var1) {
      class123 var2 = this.field2261;
      synchronized(this.field2261) {
         try {
            Object var10000;
            if(this.field2260.method2374() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2260.method2358((long)(var1 * 6));
               this.field2260.method2361(field2258, 0, 6);
               int var3 = (field2258[2] & 255) + ((field2258[1] & 255) << 8) + ((field2258[0] & 255) << 16);
               int var4 = (field2258[5] & 255) + ((field2258[4] & 255) << 8) + ((field2258[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field2262) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2261.method2374() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;

                  for(int var7 = 0; var6 < var3; ++var7) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2261.method2358((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2261.method2361(field2258, 0, var8 + 8);
                     int var9 = (field2258[1] & 255) + ((field2258[0] & 255) << 8);
                     int var10 = ((field2258[2] & 255) << 8) + (field2258[3] & 255);
                     int var11 = (field2258[6] & 255) + ((field2258[5] & 255) << 8) + ((field2258[4] & 255) << 16);
                     int var12 = field2258[7] & 255;
                     if(var9 != var1 || var10 != var7 || this.index != var12) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     if(var11 < 0 || (long)var11 > this.field2261.method2374() / 520L) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     for(int var13 = 0; var13 < var8; ++var13) {
                        var5[var6++] = field2258[var13 + 8];
                     }

                     var4 = var11;
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
      signature = "(ILclass123;Lclass123;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class123 var2, class123 var3, int var4) {
      this.field2261 = null;
      this.field2260 = null;
      this.field2262 = '\ufde8';
      this.index = var1;
      this.field2261 = var2;
      this.field2260 = var3;
      this.field2262 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method3065() {
      short var0 = 256;
      int var1;
      if(class92.field1424 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1424 > 768) {
               class30.field430[var1] = class33.method354(World.field1265[var1], class24.field365[var1], 1024 - class92.field1424);
            } else if(class92.field1424 > 256) {
               class30.field430[var1] = class24.field365[var1];
            } else {
               class30.field430[var1] = class33.method354(class24.field365[var1], World.field1265[var1], 256 - class92.field1424);
            }
         }
      } else if(class92.field1419 > 0) {
         for(var1 = 0; var1 < 256; ++var1) {
            if(class92.field1419 > 768) {
               class30.field430[var1] = class33.method354(World.field1265[var1], class2.field10[var1], 1024 - class92.field1419);
            } else if(class92.field1419 > 256) {
               class30.field430[var1] = class2.field10[var1];
            } else {
               class30.field430[var1] = class33.method354(class2.field10[var1], World.field1265[var1], 256 - class92.field1419);
            }
         }
      } else {
         for(var1 = 0; var1 < 256; ++var1) {
            class30.field430[var1] = World.field1265[var1];
         }
      }

      Rasterizer2D.method4998(class92.field1416, 9, class92.field1416 + 128, var0 + 7);
      class92.field1429.method5130(class92.field1416, 0);
      Rasterizer2D.method5009();
      var1 = 0;
      int var2 = class40.field541.width * 9 + class92.field1416;

      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class92.field1423[var3] / var0;
         var5 = var4 + 22;
         if(var5 < 0) {
            var5 = 0;
         }

         var1 += var5;

         for(var6 = var5; var6 < 128; ++var6) {
            var7 = class5.field33[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class30.field430[var7];
               var10 = class40.field541.pixels[var2];
               class40.field541.pixels[var2++] = ((var10 & 16711935) * var9 + (var7 & 16711935) * var8 & -16711936) + ((var7 & '\uff00') * var8 + var9 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var2 += var5 + class40.field541.width - 128;
      }

      Rasterizer2D.method4998(class92.field1416 + 765 - 128, 9, class92.field1416 + 765, var0 + 7);
      class269.field3672.method5130(class92.field1416 + 382, 0);
      Rasterizer2D.method5009();
      var1 = 0;
      var2 = class40.field541.width * 9 + 24 + 637 + class92.field1416;

      for(var3 = 1; var3 < var0 - 1; ++var3) {
         var4 = (var0 - var3) * class92.field1423[var3] / var0;
         var5 = 103 - var4;
         var2 += var4;

         for(var6 = 0; var6 < var5; ++var6) {
            var7 = class5.field33[var1++];
            if(var7 != 0) {
               var8 = var7;
               var9 = 256 - var7;
               var7 = class30.field430[var7];
               var10 = class40.field541.pixels[var2];
               class40.field541.pixels[var2++] = (var8 * (var7 & 16711935) + (var10 & 16711935) * var9 & -16711936) + ((var10 & '\uff00') * var9 + var8 * (var7 & '\uff00') & 16711680) >> 8;
            } else {
               ++var2;
            }
         }

         var1 += 128 - var5;
         var2 += class40.field541.width - var5 - var4;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-463459175"
   )
   public boolean method3067(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2261;
      synchronized(this.field2261) {
         if(var3 >= 0 && var3 <= this.field2262) {
            boolean var5 = this.method3057(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3057(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-2"
   )
   public static byte[] method3071(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class9.method41(var3):var3;
      } else if(var0 instanceof class176) {
         class176 var2 = (class176)var0;
         return var2.vmethod3421();
      } else {
         throw new IllegalArgumentException();
      }
   }

   static {
      field2258 = new byte[520];
   }
}
