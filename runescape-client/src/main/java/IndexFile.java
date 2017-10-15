import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("k")
   static byte[] field2286;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("dataFile")
   CacheFile dataFile;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("indexFile")
   CacheFile indexFile;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 129691001
   )
   @Export("maxSize")
   int maxSize;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2071696037
   )
   @Export("index")
   int index;

   static {
      field2286 = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILdz;Ldz;I)V"
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "33940061"
   )
   boolean method3092(int var1, byte[] var2, int var3, boolean var4) {
      CacheFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.indexFile.method2412() < (long)(6 + var1 * 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.method2426(field2286, 0, 6);
               var6 = (field2286[5] & 255) + ((field2286[3] & 255) << 16) + ((field2286[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.dataFile.method2412() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.dataFile.method2412() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2286[0] = (byte)(var3 >> 16);
            field2286[1] = (byte)(var3 >> 8);
            field2286[2] = (byte)var3;
            field2286[3] = (byte)(var6 >> 16);
            field2286[4] = (byte)(var6 >> 8);
            field2286[5] = (byte)var6;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(field2286, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.method2426(field2286, 0, 8);
                        } catch (EOFException var16) {
                           break label146;
                        }

                        var10 = (field2286[1] & 255) + ((field2286[0] & 255) << 8);
                        int var11 = (field2286[3] & 255) + ((field2286[2] & 255) << 8);
                        var9 = ((field2286[5] & 255) << 8) + ((field2286[4] & 255) << 16) + (field2286[6] & 255);
                        int var12 = field2286[7] & 255;
                        if(var10 != var1 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.dataFile.method2412() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.dataFile.method2412() + 519L) / 520L);
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

                     field2286[0] = (byte)(var1 >> 8);
                     field2286[1] = (byte)var1;
                     field2286[2] = (byte)(var8 >> 8);
                     field2286[3] = (byte)var8;
                     field2286[4] = (byte)(var9 >> 16);
                     field2286[5] = (byte)(var9 >> 8);
                     field2286[6] = (byte)var9;
                     field2286[7] = (byte)this.index;
                     this.dataFile.seek((long)(var6 * 520));
                     this.dataFile.write(field2286, 0, 8);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-640221245"
   )
   public boolean method3091(int var1, byte[] var2, int var3) {
      CacheFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxSize) {
            boolean var5 = this.method3092(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3092(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "24"
   )
   public byte[] method3100(int var1) {
      CacheFile var2 = this.dataFile;
      synchronized(this.dataFile) {
         Object var10000;
         try {
            if(this.indexFile.method2412() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            }

            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.method2426(field2286, 0, 6);
            int var3 = ((field2286[0] & 255) << 16) + (field2286[2] & 255) + ((field2286[1] & 255) << 8);
            int var4 = (field2286[5] & 255) + ((field2286[3] & 255) << 16) + ((field2286[4] & 255) << 8);
            if(var3 < 0 || var3 > this.maxSize) {
               var10000 = null;
               return (byte[])var10000;
            }

            if(var4 > 0 && (long)var4 <= this.dataFile.method2412() / 520L) {
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

                  this.dataFile.method2426(field2286, 0, var8 + 8);
                  int var9 = (field2286[1] & 255) + ((field2286[0] & 255) << 8);
                  int var10 = (field2286[3] & 255) + ((field2286[2] & 255) << 8);
                  int var11 = ((field2286[5] & 255) << 8) + ((field2286[4] & 255) << 16) + (field2286[6] & 255);
                  int var12 = field2286[7] & 255;
                  if(var9 != var1 || var7 != var10 || var12 != this.index) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  if(var11 < 0 || (long)var11 > this.dataFile.method2412() / 520L) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  for(int var13 = 0; var13 < var8; ++var13) {
                     var5[var6++] = field2286[var13 + 8];
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

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1307709164"
   )
   static final void method3106() {
      if(Client.field974 > 0) {
         class181.method3546();
      } else {
         Client.field929.method4993();
         FrameMap.setGameState(40);
         class54.field688 = class268.rssocket;
         class268.rssocket = null;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/io/File;",
      garbageValue = "-1781564878"
   )
   public static File method3104(String var0) {
      if(!class157.field2265) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class157.field2267.get(var0);
         if(var1 != null) {
            return var1;
         } else {
            File var2 = new File(class157.field2264, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class157.field2267.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;IIIZI)V",
      garbageValue = "987427476"
   )
   public static void method3094(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class203.field2521 = 1;
      class203.field2522 = var0;
      class203.field2520 = var1;
      Frames.field2138 = var2;
      class148.field2203 = var3;
      BufferProvider.field3778 = var4;
      class288.field3814 = 10000;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-69119060"
   )
   static final boolean method3107(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label69:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label69;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = Occluder.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.field3439 != 0 || var15.interactType == 1 || var15.field3476) {
                     if(!var15.method4619()) {
                        ++Client.field980;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1294370326"
   )
   static char method3103(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
