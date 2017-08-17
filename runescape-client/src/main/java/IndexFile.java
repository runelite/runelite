import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("j")
   static byte[] field2283;
   @ObfuscatedName("ar")
   static java.awt.Font field2289;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "Ljd;"
   )
   public static BufferProvider field2286;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldt;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1679596271
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1333912205
   )
   @Export("index")
   int index;

   static {
      field2283 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILdt;Ldt;I)V"
   )
   public IndexFile(int var1, CacheFile var2, CacheFile var3, int var4) {
      this.dataFile = null;
      this.indexFile = null;
      this.maxSize = '\ufde8';
      this.index = var1;
      this.dataFile = var2;
      this.indexFile = var3;
      this.maxSize = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "58"
   )
   boolean method3033(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2354() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2369(field2283, 0, 6);
               var6 = (field2283[5] & 255) + ((field2283[3] & 255) << 16) + ((field2283[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.dataFile.method2354() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method2354() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2283[0] = (byte)(var3 >> 16);
            field2283[1] = (byte)(var3 >> 8);
            field2283[2] = (byte)var3;
            field2283[3] = (byte)(var6 >> 16);
            field2283[4] = (byte)(var6 >> 8);
            field2283[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2283, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label135: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        label155: {
                           this.dataFile.seek((long)(var6 * 520));

                           try {
                              this.dataFile.method2369(field2283, 0, 8);
                           } catch (EOFException var16) {
                              break label135;
                           }

                           var10 = (field2283[1] & 255) + ((field2283[0] & 255) << 8);
                           int var11 = (field2283[3] & 255) + ((field2283[2] & 255) << 8);
                           var9 = ((field2283[5] & 255) << 8) + ((field2283[4] & 255) << 16) + (field2283[6] & 255);
                           int var12 = field2283[7] & 255;
                           if(var10 == var1 && var8 == var11 && var12 == this.index) {
                              if(var9 >= 0 && (long)var9 <= this.dataFile.method2354() / 520L) {
                                 break label155;
                              }

                              var10000 = false;
                              return var10000;
                           }

                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method2354() + 519L) / 520L);
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

                     field2283[0] = (byte)(var1 >> 8);
                     field2283[1] = (byte)var1;
                     field2283[2] = (byte)(var8 >> 8);
                     field2283[3] = (byte)var8;
                     field2283[4] = (byte)(var9 >> 16);
                     field2283[5] = (byte)(var9 >> 8);
                     field2283[6] = (byte)var9;
                     field2283[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2283, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.dataFile.write(var2, var7, var10);
                     var7 += var10;
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
      signature = "(I[BIB)Z",
      garbageValue = "-121"
   )
   public boolean method3035(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3033(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3033(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "35019837"
   )
   public byte[] method3039(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         Object var10000;
         try {
            if(this.indexFile.method2354() >= (long)(var1 * 6 + 6)) {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2369(field2283, 0, 6);
               int var3 = ((field2283[0] & 255) << 16) + (field2283[2] & 255) + ((field2283[1] & 255) << 8);
               int var4 = (field2283[5] & 255) + ((field2283[3] & 255) << 16) + ((field2283[4] & 255) << 8);
               if(var3 >= 0 && var3 <= this.maxSize) {
                  if(var4 > 0 && (long)var4 <= this.dataFile.method2354() / 520L) {
                     byte[] var5 = new byte[var3];
                     int var6 = 0;
                     int var7 = 0;

                     while(var6 < var3) {
                        if(var4 == 0) {
                           var10000 = null;
                           return (byte[])var10000;
                        }

                        this.dataFile.seek((long)(var4 * 520));
                        int var8 = var3 - var6;
                        if(var8 > 512) {
                           var8 = 512;
                        }

                        this.dataFile.method2369(field2283, 0, var8 + 8);
                        int var9 = (field2283[1] & 255) + ((field2283[0] & 255) << 8);
                        int var10 = (field2283[3] & 255) + ((field2283[2] & 255) << 8);
                        int var11 = ((field2283[5] & 255) << 8) + ((field2283[4] & 255) << 16) + (field2283[6] & 255);
                        int var12 = field2283[7] & 255;
                        if(var9 == var1 && var10 == var7 && var12 == this.index) {
                           if(var11 >= 0 && (long)var11 <= this.dataFile.method2354() / 520L) {
                              for(int var13 = 0; var13 < var8; ++var13) {
                                 var5[var6++] = field2283[var13 + 8];
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

                  var10000 = null;
                  return (byte[])var10000;
               }

               var10000 = null;
               return (byte[])var10000;
            }

            var10000 = null;
         } catch (IOException var16) {
            return null;
         }

         return (byte[])var10000;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1459199769"
   )
   public static int method3032(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILfe;Lfc;I)Z",
      garbageValue = "-287905226"
   )
   public static final boolean method3041(int var0, int var1, int var2, class164 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class163.field2307[var7][var8] = 99;
      class163.field2308[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class163.field2310[var11] = var0;
      int var20 = var11 + 1;
      class163.field2311[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label300:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label277:
                     do {
                        if(var20 == var12) {
                           class164.field2316 = var5;
                           class163.field2309 = var6;
                           return false;
                        }

                        var5 = class163.field2310[var12];
                        var6 = class163.field2311[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod3088(var2, var5, var6, var4)) {
                           class164.field2316 = var5;
                           class163.field2309 = var6;
                           return true;
                        }

                        var16 = class163.field2308[var18][var19] + 1;
                        if(var18 > 0 && class163.field2307[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && 0 == (var13[var14 - 1][var15 + var2 - 1] & 19136824)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class163.field2310[var20] = var5 - 1;
                                 class163.field2311[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18 - 1][var19] = 2;
                                 class163.field2308[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class163.field2307[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && 0 == (var13[var14 + var2][var15 + var2 - 1] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class163.field2310[var20] = var5 + 1;
                                 class163.field2311[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18 + 1][var19] = 8;
                                 class163.field2308[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class163.field2307[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class163.field2310[var20] = var5;
                                 class163.field2311[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18][var19 - 1] = 1;
                                 class163.field2308[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class163.field2307[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && 0 == (var13[var14 + var2 - 1][var15 + var2] & 19136992)) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class163.field2310[var20] = var5;
                                 class163.field2311[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18][var19 + 1] = 4;
                                 class163.field2308[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class163.field2307[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class163.field2310[var20] = var5 - 1;
                                 class163.field2311[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18 - 1][var19 - 1] = 3;
                                 class163.field2308[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class163.field2307[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class163.field2310[var20] = var5 + 1;
                                 class163.field2311[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class163.field2307[var18 + 1][var19 - 1] = 9;
                                 class163.field2308[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if(0 != (var13[var14 + var2][var17 + (var15 - 1)] & 19136995) || 0 != (var13[var17 + var14][var15 - 1] & 19136911)) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class163.field2307[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label277;
                              }
                           }

                           class163.field2310[var20] = var5 - 1;
                           class163.field2311[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class163.field2307[var18 - 1][var19 + 1] = 6;
                           class163.field2308[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class163.field2307[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label300;
               }
            }

            class163.field2310[var20] = var5 + 1;
            class163.field2311[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class163.field2307[var18 + 1][var19 + 1] = 12;
            class163.field2308[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
