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
   @ObfuscatedName("q")
   static byte[] field2253;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -28252367
   )
   static int field2255;
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field2256;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lcv;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1372251657
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1225310945
   )
   @Export("index")
   int index;

   static {
      field2253 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILcv;Lcv;I)V"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-359330151"
   )
   boolean method3051(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method1887() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method1889(field2253, 0, 6);
               var6 = ((field2253[4] & 255) << 8) + (field2253[5] & 255) + ((field2253[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.dataFile.method1887() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method1887() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2253[0] = (byte)(var3 >> 16);
            field2253[1] = (byte)(var3 >> 8);
            field2253[2] = (byte)var3;
            field2253[3] = (byte)(var6 >> 16);
            field2253[4] = (byte)(var6 >> 8);
            field2253[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2253, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label149: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.method1889(field2253, 0, 8);
                        } catch (EOFException var16) {
                           break label149;
                        }

                        var10 = ((field2253[0] & 255) << 8) + (field2253[1] & 255);
                        int var11 = (field2253[3] & 255) + ((field2253[2] & 255) << 8);
                        var9 = ((field2253[5] & 255) << 8) + (field2253[6] & 255) + ((field2253[4] & 255) << 16);
                        int var12 = field2253[7] & 255;
                        if(var10 != var1 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.dataFile.method1887() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method1887() + 519L) / 520L);
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

                     field2253[0] = (byte)(var1 >> 8);
                     field2253[1] = (byte)var1;
                     field2253[2] = (byte)(var8 >> 8);
                     field2253[3] = (byte)var8;
                     field2253[4] = (byte)(var9 >> 16);
                     field2253[5] = (byte)(var9 >> 8);
                     field2253[6] = (byte)var9;
                     field2253[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2253, 0, 8);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-948884647"
   )
   public boolean method3044(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3051(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3051(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-16711936"
   )
   public byte[] method3043(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         Object var10000;
         try {
            if(this.indexFile.method1887() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            }

            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.method1889(field2253, 0, 6);
            int var3 = ((field2253[0] & 255) << 16) + ((field2253[1] & 255) << 8) + (field2253[2] & 255);
            int var4 = ((field2253[4] & 255) << 8) + (field2253[5] & 255) + ((field2253[3] & 255) << 16);
            if(var3 < 0 || var3 > this.maxSize) {
               var10000 = null;
               return (byte[])var10000;
            }

            if(var4 > 0 && (long)var4 <= this.dataFile.method1887() / 520L) {
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

                  this.dataFile.method1889(field2253, 0, var8 + 8);
                  int var9 = ((field2253[0] & 255) << 8) + (field2253[1] & 255);
                  int var10 = (field2253[3] & 255) + ((field2253[2] & 255) << 8);
                  int var11 = ((field2253[5] & 255) << 8) + (field2253[6] & 255) + ((field2253[4] & 255) << 16);
                  int var12 = field2253[7] & 255;
                  if(var9 != var1 || var10 != var7 || var12 != this.index) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  if(var11 < 0 || (long)var11 > this.dataFile.method1887() / 520L) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  for(int var13 = 0; var13 < var8; ++var13) {
                     var5[var6++] = field2253[var13 + 8];
                  }

                  var4 = var11;
               }

               byte[] var18 = var5;
               return var18;
            }

            var10000 = null;
         } catch (IOException var16) {
            return null;
         }

         return (byte[])var10000;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "382"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?class202.method3687(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "94"
   )
   public static boolean method3055(char var0) {
      return var0 >= 48 && var0 <= 57;
   }
}
