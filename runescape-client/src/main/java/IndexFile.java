import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("t")
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("a")
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1938425157
   )
   static int field2289;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1810596781
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1878247999
   )
   @Export("index")
   int index;
   @ObfuscatedName("w")
   static byte[] field2293;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1504968457"
   )
   public byte[] method2997(int var1) {
      CacheFile var2 = this.dataFile;
      CacheFile var3 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            Object var4;
            byte[] var10000;
            if(this.indexFile.method2335() < (long)(var1 * 6 + 6)) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            } else {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2361(field2293, 0, 6);
               int var5 = ((field2293[0] & 255) << 16) + ((field2293[1] & 255) << 8) + (field2293[2] & 255);
               int var6 = ((field2293[4] & 255) << 8) + ((field2293[3] & 255) << 16) + (field2293[5] & 255);
               if(var5 >= 0 && var5 <= this.maxSize) {
                  if(var6 > 0 && (long)var6 <= this.dataFile.method2335() / 520L) {
                     byte[] var7 = new byte[var5];
                     int var8 = 0;

                     for(int var9 = 0; var8 < var5; ++var9) {
                        if(var6 == 0) {
                           var4 = null;
                           var10000 = (byte[])((byte[])var4);
                           return var10000;
                        }

                        this.dataFile.seek((long)(var6 * 520));
                        int var10 = var5 - var8;
                        if(var10 > 512) {
                           var10 = 512;
                        }

                        this.dataFile.method2361(field2293, 0, var10 + 8);
                        int var11 = ((field2293[0] & 255) << 8) + (field2293[1] & 255);
                        int var12 = (field2293[3] & 255) + ((field2293[2] & 255) << 8);
                        int var13 = (field2293[6] & 255) + ((field2293[5] & 255) << 8) + ((field2293[4] & 255) << 16);
                        int var14 = field2293[7] & 255;
                        if(var11 != var1 || var12 != var9 || this.index != var14) {
                           var4 = null;
                           var10000 = (byte[])((byte[])var4);
                           return var10000;
                        }

                        if(var13 < 0 || (long)var13 > this.dataFile.method2335() / 520L) {
                           var4 = null;
                           var10000 = (byte[])((byte[])var4);
                           return var10000;
                        }

                        for(int var15 = 0; var15 < var10; ++var15) {
                           var7[var8++] = field2293[var15 + 8];
                        }

                        var6 = var13;
                     }

                     var10000 = var7;
                     return var10000;
                  } else {
                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }
               } else {
                  var4 = null;
                  return (byte[])((byte[])var4);
               }
            }
         } catch (IOException var17) {
            return null;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1963797605"
   )
   boolean method3000(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      CacheFile var6 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2335() < (long)(var1 * 6 + 6)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2361(field2293, 0, 6);
               var7 = ((field2293[4] & 255) << 8) + ((field2293[3] & 255) << 16) + (field2293[5] & 255);
               if(var7 <= 0 || (long)var7 > this.dataFile.method2335() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.dataFile.method2335() + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            field2293[0] = (byte)(var3 >> 16);
            field2293[1] = (byte)(var3 >> 8);
            field2293[2] = (byte)var3;
            field2293[3] = (byte)(var7 >> 16);
            field2293[4] = (byte)(var7 >> 8);
            field2293[5] = (byte)var7;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2293, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while(true) {
               if(var9 < var3) {
                  label129: {
                     int var11 = 0;
                     int var12;
                     if(var4) {
                        this.dataFile.seek((long)(var7 * 520));

                        try {
                           this.dataFile.method2361(field2293, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = ((field2293[0] & 255) << 8) + (field2293[1] & 255);
                        int var13 = (field2293[3] & 255) + ((field2293[2] & 255) << 8);
                        var11 = (field2293[6] & 255) + ((field2293[5] & 255) << 8) + ((field2293[4] & 255) << 16);
                        int var14 = field2293[7] & 255;
                        if(var12 != var1 || var13 != var10 || this.index != var14) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.dataFile.method2335() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if(var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.dataFile.method2335() + 519L) / 520L);
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

                     field2293[0] = (byte)(var1 >> 8);
                     field2293[1] = (byte)var1;
                     field2293[2] = (byte)(var10 >> 8);
                     field2293[3] = (byte)var10;
                     field2293[4] = (byte)(var11 >> 16);
                     field2293[5] = (byte)(var11 >> 8);
                     field2293[6] = (byte)var11;
                     field2293[7] = (byte)this.index;
                     this.dataFile.seek((long)(var7 * 520));
                     this.dataFile.write(field2293, 0, 8);
                     var12 = var3 - var9;
                     if(var12 > 512) {
                        var12 = 512;
                     }

                     this.dataFile.write(var2, var9, var12);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "0"
   )
   public boolean method3002(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var6 = this.method3000(var1, var2, var3, true);
            if(!var6) {
               var6 = this.method3000(var1, var2, var3, false);
            }

            return var6;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILCacheFile;LCacheFile;I)V",
      garbageValue = "500000"
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

   static {
      field2293 = new byte[520];
   }
}
