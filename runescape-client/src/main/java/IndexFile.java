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
   @ObfuscatedName("w")
   static byte[] field2268;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1038935731
   )
   @Export("index")
   int index;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 270052319
   )
   @Export("maxSize")
   int maxSize;

   static {
      field2268 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILdv;Ldv;I)V"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1355993554"
   )
   public byte[] method3060(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            Object var10000;
            if(this.indexFile.method2392() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2380(field2268, 0, 6);
               int var3 = ((field2268[0] & 255) << 16) + (field2268[2] & 255) + ((field2268[1] & 255) << 8);
               int var4 = (field2268[5] & 255) + ((field2268[3] & 255) << 16) + ((field2268[4] & 255) << 8);
               if(var3 >= 0 && var3 <= this.maxSize) {
                  if(var4 > 0 && (long)var4 <= this.dataFile.method2392() / 520L) {
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

                        this.dataFile.method2380(field2268, 0, var8 + 8);
                        int var9 = (field2268[1] & 255) + ((field2268[0] & 255) << 8);
                        int var10 = (field2268[3] & 255) + ((field2268[2] & 255) << 8);
                        int var11 = ((field2268[5] & 255) << 8) + ((field2268[4] & 255) << 16) + (field2268[6] & 255);
                        int var12 = field2268[7] & 255;
                        if(var9 == var1 && var10 == var7 && var12 == this.index) {
                           if(var11 >= 0 && (long)var11 <= this.dataFile.method2392() / 520L) {
                              for(int var13 = 0; var13 < var8; ++var13) {
                                 var5[var6++] = field2268[var13 + 8];
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
      signature = "(I[BIB)Z",
      garbageValue = "118"
   )
   public boolean method3058(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3069(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3069(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-2065069040"
   )
   boolean method3069(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2392() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2380(field2268, 0, 6);
               var6 = (field2268[5] & 255) + ((field2268[3] & 255) << 16) + ((field2268[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.dataFile.method2392() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method2392() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2268[0] = (byte)(var3 >> 16);
            field2268[1] = (byte)(var3 >> 8);
            field2268[2] = (byte)var3;
            field2268[3] = (byte)(var6 >> 16);
            field2268[4] = (byte)(var6 >> 8);
            field2268[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2268, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.method2380(field2268, 0, 8);
                        } catch (EOFException var16) {
                           break label143;
                        }

                        var10 = (field2268[1] & 255) + ((field2268[0] & 255) << 8);
                        int var11 = (field2268[3] & 255) + ((field2268[2] & 255) << 8);
                        var9 = ((field2268[5] & 255) << 8) + ((field2268[4] & 255) << 16) + (field2268[6] & 255);
                        int var12 = field2268[7] & 255;
                        if(var10 != var1 || var8 != var11 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.dataFile.method2392() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method2392() + 519L) / 520L);
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

                     field2268[0] = (byte)(var1 >> 8);
                     field2268[1] = (byte)var1;
                     field2268[2] = (byte)(var8 >> 8);
                     field2268[3] = (byte)var8;
                     field2268[4] = (byte)(var9 >> 16);
                     field2268[5] = (byte)(var9 >> 8);
                     field2268[6] = (byte)var9;
                     field2268[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2268, 0, 8);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lct;",
      garbageValue = "-972830657"
   )
   static Script method3057(int var0) {
      Script var1 = (Script)Script.field1522.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = WorldMapType1.indexScripts.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = class22.method172(var2);
            Script.field1522.put(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILip;IIIZI)V",
      garbageValue = "-1830181280"
   )
   public static void method3070(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2500 = 1;
      ContextMenuRow.field1392 = var1;
      class203.field2502 = var2;
      class203.field2505 = var3;
      class10.field268 = var4;
      DynamicObject.field1539 = var5;
      class36.field523 = var0;
   }
}
