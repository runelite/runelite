import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fn")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("b")
   @Export("IndexStore_buffer")
   static byte[] IndexStore_buffer;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1906406729
   )
   @Export("index")
   int index;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 520658687
   )
   @Export("maxSize")
   int maxSize;

   static {
      IndexStore_buffer = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILde;Lde;I)V"
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
      garbageValue = "-2086222028"
   )
   @Export("read")
   public byte[] read(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            Object var10000;
            if(this.indexFile.length() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.read(IndexStore_buffer, 0, 6);
               int var3 = ((IndexStore_buffer[0] & 255) << 16) + (IndexStore_buffer[2] & 255) + ((IndexStore_buffer[1] & 255) << 8);
               int var4 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
               if(var3 < 0 || var3 > this.maxSize) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.dataFile.length() / 520L) {
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

                     this.dataFile.seek((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.dataFile.read(IndexStore_buffer, 0, var8 + 8);
                     int var9 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                     int var10 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                     int var11 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                     int var12 = IndexStore_buffer[7] & 255;
                     if(var9 == var1 && var7 == var10 && var12 == this.index) {
                        if(var11 >= 0 && (long)var11 <= this.dataFile.length() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = IndexStore_buffer[var13 + 8];
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "317110943"
   )
   @Export("write")
   public boolean write(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.write0(var1, var2, var3, true);
            if(!var5) {
               var5 = this.write0(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "175165616"
   )
   @Export("write0")
   boolean write0(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.length() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.read(IndexStore_buffer, 0, 6);
               var6 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.dataFile.length() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.length() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            IndexStore_buffer[0] = (byte)(var3 >> 16);
            IndexStore_buffer[1] = (byte)(var3 >> 8);
            IndexStore_buffer[2] = (byte)var3;
            IndexStore_buffer[3] = (byte)(var6 >> 16);
            IndexStore_buffer[4] = (byte)(var6 >> 8);
            IndexStore_buffer[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(IndexStore_buffer, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.read(IndexStore_buffer, 0, 8);
                        } catch (EOFException var16) {
                           break label146;
                        }

                        var14 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                        int var11 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                        var9 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                        int var12 = IndexStore_buffer[7] & 255;
                        if(var14 != var1 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.dataFile.length() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.length() + 519L) / 520L);
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

                     IndexStore_buffer[0] = (byte)(var1 >> 8);
                     IndexStore_buffer[1] = (byte)var1;
                     IndexStore_buffer[2] = (byte)(var8 >> 8);
                     IndexStore_buffer[3] = (byte)var8;
                     IndexStore_buffer[4] = (byte)(var9 >> 16);
                     IndexStore_buffer[5] = (byte)(var9 >> 8);
                     IndexStore_buffer[6] = (byte)var9;
                     IndexStore_buffer[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(IndexStore_buffer, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.dataFile.write(var2, var7, var14);
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1056750927"
   )
   static int method3358(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Ljk;",
      garbageValue = "1788136272"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }
}
