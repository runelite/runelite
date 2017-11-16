import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("b")
   static byte[] field2180;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2048236785
   )
   @Export("index")
   int index;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 988857417
   )
   @Export("maxSize")
   int maxSize;

   static {
      field2180 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILdz;Ldz;I)V"
   )
   public IndexFile(int var1, CacheFile var2, CacheFile var3, int var4) {
      this.dataFile = null;
      this.indexFile = null;
      this.maxSize = 65000;
      this.index = var1;
      this.dataFile = var2;
      this.indexFile = var3;
      this.maxSize = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1852661346"
   )
   public byte[] method3028(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            Object var10000;
            if(this.indexFile.method2334() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2335(field2180, 0, 6);
               int var3 = ((field2180[0] & 255) << 16) + (field2180[2] & 255) + ((field2180[1] & 255) << 8);
               int var4 = (field2180[5] & 255) + ((field2180[3] & 255) << 16) + ((field2180[4] & 255) << 8);
               if(var3 >= 0 && var3 <= this.maxSize) {
                  if(var4 > 0 && (long)var4 <= this.dataFile.method2334() / 520L) {
                     byte[] var5 = new byte[var3];
                     int var6 = 0;

                     for(int var7 = 0; var6 < var3; ++var7) {
                        if(var4 == 0) {
                           var10000 = null;
                           return (byte[])var10000;
                        }

                        this.dataFile.seek((long)(var4 * 520));
                        int var8 = var3 - var6;
                        if(var8 > 512) {
                           var8 = 512;
                        }

                        this.dataFile.method2335(field2180, 0, var8 + 8);
                        int var9 = (field2180[1] & 255) + ((field2180[0] & 255) << 8);
                        int var10 = (field2180[3] & 255) + ((field2180[2] & 255) << 8);
                        int var11 = ((field2180[5] & 255) << 8) + ((field2180[4] & 255) << 16) + (field2180[6] & 255);
                        int var12 = field2180[7] & 255;
                        if(var9 != var1 || var7 != var10 || var12 != this.index) {
                           var10000 = null;
                           return (byte[])var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.dataFile.method2334() / 520L) {
                           var10000 = null;
                           return (byte[])var10000;
                        }

                        for(int var13 = 0; var13 < var8; ++var13) {
                           var5[var6++] = field2180[var13 + 8];
                        }

                        var4 = var11;
                     }

                     byte[] var18 = var5;
                     return var18;
                  } else {
                     var10000 = null;
                     return (byte[])var10000;
                  }
               } else {
                  var10000 = null;
                  return (byte[])var10000;
               }
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "1687125056"
   )
   public boolean method3029(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3038(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3038(var1, var2, var3, false);
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
      garbageValue = "290730126"
   )
   boolean method3038(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2334() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2335(field2180, 0, 6);
               var6 = (field2180[5] & 255) + ((field2180[3] & 255) << 16) + ((field2180[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.dataFile.method2334() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method2334() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2180[0] = (byte)(var3 >> 16);
            field2180[1] = (byte)(var3 >> 8);
            field2180[2] = (byte)var3;
            field2180[3] = (byte)(var6 >> 16);
            field2180[4] = (byte)(var6 >> 8);
            field2180[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2180, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label148: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.method2335(field2180, 0, 8);
                        } catch (EOFException var16) {
                           break label148;
                        }

                        var10 = (field2180[1] & 255) + ((field2180[0] & 255) << 8);
                        int var11 = (field2180[3] & 255) + ((field2180[2] & 255) << 8);
                        var9 = ((field2180[5] & 255) << 8) + ((field2180[4] & 255) << 16) + (field2180[6] & 255);
                        int var12 = field2180[7] & 255;
                        if(var10 != var1 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.dataFile.method2334() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method2334() + 519L) / 520L);
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

                     field2180[0] = (byte)(var1 >> 8);
                     field2180[1] = (byte)var1;
                     field2180[2] = (byte)(var8 >> 8);
                     field2180[3] = (byte)var8;
                     field2180[4] = (byte)(var9 >> 16);
                     field2180[5] = (byte)(var9 >> 8);
                     field2180[6] = (byte)var9;
                     field2180[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2180, 0, 8);
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

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "-864971467"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = Tile.font_p12full.method4824(var0, 250);
      int var6 = Tile.font_p12full.method4768(var0, 250) * 13;
      Rasterizer2D.method4981(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      Tile.font_p12full.method4774(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      Client.method1490(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2);
      if(var1) {
         class236.field3227.vmethod5065(0, 0);
      } else {
         class182.method3418(var3, var4, var5, var6);
      }

   }
}
