import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("ArchiveDisk")
public final class ArchiveDisk
{
   @ObfuscatedName("m")
   @Export("ArchiveDisk_buffer")
   static byte[] ArchiveDisk_buffer;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("datFile")
   BufferedFile datFile;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("idxFile")
   BufferedFile idxFile;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1982523283
   )
   @Export("archive")
   int archive;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -748616567
   )
   @Export("maxEntrySize")
   int maxEntrySize;

   @ObfuscatedSignature(
      signature = "(ILdy;Ldy;I)V"
   )
   public ArchiveDisk(int var1, BufferedFile var2, BufferedFile var3, int var4) {
      this.datFile = null;
      this.idxFile = null;
      this.maxEntrySize = 65000;
      this.archive = var1;
      this.datFile = var2;
      this.idxFile = var3;
      this.maxEntrySize = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-294587791"
   )
   @Export("read")
   public byte[] read(int var1) {
      BufferedFile var2 = this.datFile;
      synchronized(this.datFile) {
         byte[] var10000;
         try {
            Object var4;
            if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
               var4 = null;
               var10000 = ((byte[])var4);
               return var10000;
            }

            this.idxFile.seek((long)(var1 * 6));
            this.idxFile.read(ArchiveDisk_buffer, 0, 6);
            int var5 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
            int var6 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
            if (var5 < 0 || var5 > this.maxEntrySize) {
               var4 = null;
               var10000 = ((byte[])var4);
               return var10000;
            }

            if (var6 > 0 && (long)var6 <= this.datFile.length() / 520L) {
               byte[] var7 = new byte[var5];
               int var8 = 0;
               int var9 = 0;

               while (var8 < var5) {
                  if (var6 == 0) {
                     var4 = null;
                     var10000 = ((byte[])var4);
                     return var10000;
                  }

                  this.datFile.seek((long)(var6 * 520));
                  int var10 = var5 - var8;
                  if (var10 > 512) {
                     var10 = 512;
                  }

                  this.datFile.read(ArchiveDisk_buffer, 0, var10 + 8);
                  int var11 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                  int var12 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                  int var13 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                  int var14 = ArchiveDisk_buffer[7] & 255;
                  if (var11 == var1 && var9 == var12 && var14 == this.archive) {
                     if (var13 >= 0 && (long)var13 <= this.datFile.length() / 520L) {
                        for (int var15 = 0; var15 < var10; ++var15) {
                           var7[var8++] = ArchiveDisk_buffer[var15 + 8];
                        }

                        var6 = var13;
                        ++var9;
                        continue;
                     }

                     var4 = null;
                     var10000 = ((byte[])var4);
                     return var10000;
                  }

                  var4 = null;
                  var10000 = ((byte[])var4);
                  return var10000;
               }

               var10000 = var7;
               return var10000;
            }

            var4 = null;
            var10000 = ((byte[])var4);
         } catch (IOException var17) {
            return null;
         }

         return var10000;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1750864122"
   )
   @Export("write")
   public boolean write(int var1, byte[] var2, int var3) {
      BufferedFile var4 = this.datFile;
      synchronized(this.datFile) {
         if (var3 >= 0 && var3 <= this.maxEntrySize) {
            boolean var6 = this.write0(var1, var2, var3, true);
            if (!var6) {
               var6 = this.write0(var1, var2, var3, false);
            }

            return var6;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-944588642"
   )
   @Export("write0")
   boolean write0(int var1, byte[] var2, int var3, boolean var4) {
      BufferedFile var5 = this.datFile;
      synchronized(this.datFile) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if (var4) {
               if (this.idxFile.length() < (long)(var1 * 6 + 6)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.idxFile.seek((long)(var1 * 6));
               this.idxFile.read(ArchiveDisk_buffer, 0, 6);
               var7 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var7 <= 0 || (long)var7 > this.datFile.length() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.datFile.length() + 519L) / 520L);
               if (var7 == 0) {
                  var7 = 1;
               }
            }

            ArchiveDisk_buffer[0] = (byte)(var3 >> 16);
            ArchiveDisk_buffer[1] = (byte)(var3 >> 8);
            ArchiveDisk_buffer[2] = (byte)var3;
            ArchiveDisk_buffer[3] = (byte)(var7 >> 16);
            ArchiveDisk_buffer[4] = (byte)(var7 >> 8);
            ArchiveDisk_buffer[5] = (byte)var7;
            this.idxFile.seek((long)(var1 * 6));
            this.idxFile.write(ArchiveDisk_buffer, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while (true) {
               if (var9 < var3) {
                  label129: {
                     int var11 = 0;
                     int var12;
                     if (var4) {
                        this.datFile.seek((long)(var7 * 520));

                        try {
                           this.datFile.read(ArchiveDisk_buffer, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                        int var13 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                        var11 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                        int var14 = ArchiveDisk_buffer[7] & 255;
                        if (var12 != var1 || var13 != var10 || var14 != this.archive) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if (var11 < 0 || (long)var11 > this.datFile.length() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if (var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.datFile.length() + 519L) / 520L);
                        if (var11 == 0) {
                           ++var11;
                        }

                        if (var7 == var11) {
                           ++var11;
                        }
                     }

                     if (var3 - var9 <= 512) {
                        var11 = 0;
                     }

                     ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
                     ArchiveDisk_buffer[1] = (byte)var1;
                     ArchiveDisk_buffer[2] = (byte)(var10 >> 8);
                     ArchiveDisk_buffer[3] = (byte)var10;
                     ArchiveDisk_buffer[4] = (byte)(var11 >> 16);
                     ArchiveDisk_buffer[5] = (byte)(var11 >> 8);
                     ArchiveDisk_buffer[6] = (byte)var11;
                     ArchiveDisk_buffer[7] = (byte)this.archive;
                     this.datFile.seek((long)(var7 * 520));
                     this.datFile.write(ArchiveDisk_buffer, 0, 8);
                     var12 = var3 - var9;
                     if (var12 > 512) {
                        var12 = 512;
                     }

                     this.datFile.write(var2, var9, var12);
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILfe;Lfy;B)Z",
      garbageValue = "1"
   )
   static final boolean method3585(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class178.directions[var7][var8] = 99;
      class178.distances[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class178.bufferX[var11] = var0;
      int var13 = var11 + 1;
      class178.bufferY[var11] = var1;
      int[][] var14 = var4.flags;

      label204:
      while (var13 != var12) {
         var5 = class178.bufferX[var12];
         var6 = class178.bufferY[var12];
         var12 = var12 + 1 & 4095;
         int var19 = var5 - var9;
         int var20 = var6 - var10;
         int var15 = var5 - var4.xInset;
         int var16 = var6 - var4.yInset;
         if (var3.vmethod3644(var2, var5, var6, var4)) {
            InterfaceParent.field986 = var5;
            UrlRequester.field929 = var6;
            return true;
         }

         int var17 = class178.distances[var19][var20] + 1;
         int var18;
         if (var19 > 0 && class178.directions[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var16 + var2 - 1] & 19136824) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2 - 1) {
                  class178.bufferX[var13] = var5 - 1;
                  class178.bufferY[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19 - 1][var20] = 2;
                  class178.distances[var19 - 1][var20] = var17;
                  break;
               }

               if ((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var19 < 128 - var2 && class178.directions[var19 + 1][var20] == 0 && (var14[var15 + var2][var16] & 19136899) == 0 && (var14[var15 + var2][var16 + var2 - 1] & 19136992) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2 - 1) {
                  class178.bufferX[var13] = var5 + 1;
                  class178.bufferY[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19 + 1][var20] = 8;
                  class178.distances[var19 + 1][var20] = var17;
                  break;
               }

               if ((var14[var15 + var2][var16 + var18] & 19136995) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var20 > 0 && class178.directions[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2 - 1) {
                  class178.bufferX[var13] = var5;
                  class178.bufferY[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19][var20 - 1] = 1;
                  class178.distances[var19][var20 - 1] = var17;
                  break;
               }

               if ((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var20 < 128 - var2 && class178.directions[var19][var20 + 1] == 0 && (var14[var15][var16 + var2] & 19136824) == 0 && (var14[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2 - 1) {
                  class178.bufferX[var13] = var5;
                  class178.bufferY[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19][var20 + 1] = 4;
                  class178.distances[var19][var20 + 1] = var17;
                  break;
               }

               if ((var14[var18 + var15][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var19 > 0 && var20 > 0 && class178.directions[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2) {
                  class178.bufferX[var13] = var5 - 1;
                  class178.bufferY[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19 - 1][var20 - 1] = 3;
                  class178.distances[var19 - 1][var20 - 1] = var17;
                  break;
               }

               if ((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var19 < 128 - var2 && var20 > 0 && class178.directions[var19 + 1][var20 - 1] == 0 && (var14[var15 + var2][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2) {
                  class178.bufferX[var13] = var5 + 1;
                  class178.bufferY[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19 + 1][var20 - 1] = 9;
                  class178.distances[var19 + 1][var20 - 1] = var17;
                  break;
               }

               if ((var14[var15 + var2][var18 + (var16 - 1)] & 19136995) != 0 || (var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var19 > 0 && var20 < 128 - var2 && class178.directions[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
            var18 = 1;

            while (true) {
               if (var18 >= var2) {
                  class178.bufferX[var13] = var5 - 1;
                  class178.bufferY[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class178.directions[var19 - 1][var20 + 1] = 6;
                  class178.distances[var19 - 1][var20 + 1] = var17;
                  break;
               }

               if ((var14[var15 - 1][var16 + var18] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if (var19 < 128 - var2 && var20 < 128 - var2 && class178.directions[var19 + 1][var20 + 1] == 0 && (var14[var15 + var2][var16 + var2] & 19136992) == 0) {
            for (var18 = 1; var18 < var2; ++var18) {
               if ((var14[var15 + var18][var16 + var2] & 19137016) != 0 || (var14[var15 + var2][var18 + var16] & 19136995) != 0) {
                  continue label204;
               }
            }

            class178.bufferX[var13] = var5 + 1;
            class178.bufferY[var13] = var6 + 1;
            var13 = var13 + 1 & 4095;
            class178.directions[var19 + 1][var20 + 1] = 12;
            class178.distances[var19 + 1][var20 + 1] = var17;
         }
      }

      InterfaceParent.field986 = var5;
      UrlRequester.field929 = var6;
      return false;
   }

   static {
      ArchiveDisk_buffer = new byte[520];
   }
}
