import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("ArchiveDisk")
public final class ArchiveDisk {
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
   public byte[] read(int entry) {
      BufferedFile var2 = this.datFile;
      synchronized(this.datFile) {
         try {
            byte[] var4;
            Object var5;
            byte[] var10000;
            if (this.idxFile.length() < (long)(entry * 6 + 6)) {
               var5 = null;
               var4 = ((byte[])var5);
               var10000 = var4;
               return var10000;
            } else {
               this.idxFile.seek((long)(entry * 6));
               this.idxFile.read(ArchiveDisk_buffer, 0, 6);
               int var6 = ((ArchiveDisk_buffer[0] & 255) << 16) + (ArchiveDisk_buffer[2] & 255) + ((ArchiveDisk_buffer[1] & 255) << 8);
               int var7 = (ArchiveDisk_buffer[5] & 255) + ((ArchiveDisk_buffer[3] & 255) << 16) + ((ArchiveDisk_buffer[4] & 255) << 8);
               if (var6 < 0 || var6 > this.maxEntrySize) {
                  var5 = null;
                  var4 = ((byte[])var5);
                  var10000 = var4;
                  return var10000;
               } else if (var7 <= 0 || (long)var7 > this.datFile.length() / 520L) {
                  var5 = null;
                  var4 = ((byte[])var5);
                  return var4;
               } else {
                  byte[] var8 = new byte[var6];
                  int var9 = 0;
                  int var10 = 0;

                  while (var9 < var6) {
                     if (var7 == 0) {
                        var5 = null;
                        var4 = ((byte[])var5);
                        var10000 = var4;
                        return var10000;
                     }

                     this.datFile.seek((long)(var7 * 520));
                     int var11 = var6 - var9;
                     if (var11 > 512) {
                        var11 = 512;
                     }

                     this.datFile.read(ArchiveDisk_buffer, 0, var11 + 8);
                     int var12 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                     int var13 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                     int var14 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                     int var15 = ArchiveDisk_buffer[7] & 255;
                     if (var12 == entry && var10 == var13 && var15 == this.archive) {
                        if (var14 >= 0 && (long)var14 <= this.datFile.length() / 520L) {
                           for (int var16 = 0; var16 < var11; ++var16) {
                              var8[var9++] = ArchiveDisk_buffer[var16 + 8];
                           }

                           var7 = var14;
                           ++var10;
                           continue;
                        }

                        var5 = null;
                        var4 = ((byte[])var5);
                        var10000 = var4;
                        return var10000;
                     }

                     var5 = null;
                     var4 = ((byte[])var5);
                     var10000 = var4;
                     return var10000;
                  }

                  var10000 = var8;
                  return var10000;
               }
            }
         } catch (IOException var18) {
            return null;
         }
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
            int var10 = 0;
            int var11 = 0;

            while (true) {
               if (var10 < var3) {
                  label129: {
                     int var12 = 0;
                     int var13;
                     if (var4) {
                        this.datFile.seek((long)(var7 * 520));

                        try {
                           this.datFile.read(ArchiveDisk_buffer, 0, 8);
                        } catch (EOFException var17) {
                           break label129;
                        }

                        var13 = (ArchiveDisk_buffer[1] & 255) + ((ArchiveDisk_buffer[0] & 255) << 8);
                        int var14 = (ArchiveDisk_buffer[3] & 255) + ((ArchiveDisk_buffer[2] & 255) << 8);
                        var12 = ((ArchiveDisk_buffer[5] & 255) << 8) + ((ArchiveDisk_buffer[4] & 255) << 16) + (ArchiveDisk_buffer[6] & 255);
                        int var15 = ArchiveDisk_buffer[7] & 255;
                        if (var13 != var1 || var14 != var11 || var15 != this.archive) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if (var12 < 0 || (long)var12 > this.datFile.length() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if (var12 == 0) {
                        var4 = false;
                        var12 = (int)((this.datFile.length() + 519L) / 520L);
                        if (var12 == 0) {
                           ++var12;
                        }

                        if (var7 == var12) {
                           ++var12;
                        }
                     }

                     if (var3 - var10 <= 512) {
                        var12 = 0;
                     }

                     ArchiveDisk_buffer[0] = (byte)(var1 >> 8);
                     ArchiveDisk_buffer[1] = (byte)var1;
                     ArchiveDisk_buffer[2] = (byte)(var11 >> 8);
                     ArchiveDisk_buffer[3] = (byte)var11;
                     ArchiveDisk_buffer[4] = (byte)(var12 >> 16);
                     ArchiveDisk_buffer[5] = (byte)(var12 >> 8);
                     ArchiveDisk_buffer[6] = (byte)var12;
                     ArchiveDisk_buffer[7] = (byte)this.archive;
                     this.datFile.seek((long)(var7 * 520));
                     this.datFile.write(ArchiveDisk_buffer, 0, 8);
                     var13 = var3 - var10;
                     if (var13 > 512) {
                        var13 = 512;
                     }

                     this.datFile.write(var2, var10, var13);
                     var10 += var13;
                     var7 = var12;
                     ++var11;
                     continue;
                  }
               }

               var8 = true;
               var10000 = var8;
               return var10000;
            }
         } catch (IOException var18) {
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

      while (true) {
         label241:
         while (true) {
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            int var20;
            do {
               do {
                  do {
                     label218:
                     do {
                        if (var13 == var12) {
                           InterfaceParent.field986 = var5;
                           UrlRequester.field929 = var6;
                           return false;
                        }

                        var5 = class178.bufferX[var12];
                        var6 = class178.bufferY[var12];
                        var12 = var12 + 1 & 4095;
                        var15 = var5 - var9;
                        var16 = var6 - var10;
                        var17 = var5 - var4.xInset;
                        var18 = var6 - var4.yInset;
                        if (var3.vmethod3644(var2, var5, var6, var4)) {
                           InterfaceParent.field986 = var5;
                           UrlRequester.field929 = var6;
                           return true;
                        }

                        var19 = class178.distances[var15][var16] + 1;
                        if (var15 > 0 && class178.directions[var15 - 1][var16] == 0 && (var14[var17 - 1][var18] & 19136782) == 0 && (var14[var17 - 1][var18 + var2 - 1] & 19136824) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2 - 1) {
                                 class178.bufferX[var13] = var5 - 1;
                                 class178.bufferY[var13] = var6;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15 - 1][var16] = 2;
                                 class178.distances[var15 - 1][var16] = var19;
                                 break;
                              }

                              if ((var14[var17 - 1][var20 + var18] & 19136830) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var15 < 128 - var2 && class178.directions[var15 + 1][var16] == 0 && (var14[var17 + var2][var18] & 19136899) == 0 && (var14[var17 + var2][var18 + var2 - 1] & 19136992) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2 - 1) {
                                 class178.bufferX[var13] = var5 + 1;
                                 class178.bufferY[var13] = var6;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15 + 1][var16] = 8;
                                 class178.distances[var15 + 1][var16] = var19;
                                 break;
                              }

                              if ((var14[var17 + var2][var18 + var20] & 19136995) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var16 > 0 && class178.directions[var15][var16 - 1] == 0 && (var14[var17][var18 - 1] & 19136782) == 0 && (var14[var17 + var2 - 1][var18 - 1] & 19136899) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2 - 1) {
                                 class178.bufferX[var13] = var5;
                                 class178.bufferY[var13] = var6 - 1;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15][var16 - 1] = 1;
                                 class178.distances[var15][var16 - 1] = var19;
                                 break;
                              }

                              if ((var14[var20 + var17][var18 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var16 < 128 - var2 && class178.directions[var15][var16 + 1] == 0 && (var14[var17][var18 + var2] & 19136824) == 0 && (var14[var17 + var2 - 1][var18 + var2] & 19136992) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2 - 1) {
                                 class178.bufferX[var13] = var5;
                                 class178.bufferY[var13] = var6 + 1;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15][var16 + 1] = 4;
                                 class178.distances[var15][var16 + 1] = var19;
                                 break;
                              }

                              if ((var14[var20 + var17][var18 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var15 > 0 && var16 > 0 && class178.directions[var15 - 1][var16 - 1] == 0 && (var14[var17 - 1][var18 - 1] & 19136782) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2) {
                                 class178.bufferX[var13] = var5 - 1;
                                 class178.bufferY[var13] = var6 - 1;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15 - 1][var16 - 1] = 3;
                                 class178.distances[var15 - 1][var16 - 1] = var19;
                                 break;
                              }

                              if ((var14[var17 - 1][var20 + (var18 - 1)] & 19136830) != 0 || (var14[var20 + (var17 - 1)][var18 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var15 < 128 - var2 && var16 > 0 && class178.directions[var15 + 1][var16 - 1] == 0 && (var14[var17 + var2][var18 - 1] & 19136899) == 0) {
                           var20 = 1;

                           while (true) {
                              if (var20 >= var2) {
                                 class178.bufferX[var13] = var5 + 1;
                                 class178.bufferY[var13] = var6 - 1;
                                 var13 = var13 + 1 & 4095;
                                 class178.directions[var15 + 1][var16 - 1] = 9;
                                 class178.distances[var15 + 1][var16 - 1] = var19;
                                 break;
                              }

                              if ((var14[var17 + var2][var20 + (var18 - 1)] & 19136995) != 0 || (var14[var20 + var17][var18 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var20;
                           }
                        }

                        if (var15 > 0 && var16 < 128 - var2 && class178.directions[var15 - 1][var16 + 1] == 0 && (var14[var17 - 1][var18 + var2] & 19136824) == 0) {
                           for (var20 = 1; var20 < var2; ++var20) {
                              if ((var14[var17 - 1][var18 + var20] & 19136830) != 0 || (var14[var20 + (var17 - 1)][var18 + var2] & 19137016) != 0) {
                                 continue label218;
                              }
                           }

                           class178.bufferX[var13] = var5 - 1;
                           class178.bufferY[var13] = var6 + 1;
                           var13 = var13 + 1 & 4095;
                           class178.directions[var15 - 1][var16 + 1] = 6;
                           class178.distances[var15 - 1][var16 + 1] = var19;
                        }
                     } while(var15 >= 128 - var2);
                  } while(var16 >= 128 - var2);
               } while(class178.directions[var15 + 1][var16 + 1] != 0);
            } while((var14[var17 + var2][var18 + var2] & 19136992) != 0);

            for (var20 = 1; var20 < var2; ++var20) {
               if ((var14[var17 + var20][var18 + var2] & 19137016) != 0 || (var14[var17 + var2][var20 + var18] & 19136995) != 0) {
                  continue label241;
               }
            }

            class178.bufferX[var13] = var5 + 1;
            class178.bufferY[var13] = var6 + 1;
            var13 = var13 + 1 & 4095;
            class178.directions[var15 + 1][var16 + 1] = 12;
            class178.distances[var15 + 1][var16 + 1] = var19;
         }
      }
   }

   static {
      ArchiveDisk_buffer = new byte[520];
   }
}
