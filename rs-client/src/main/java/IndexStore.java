import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("IndexStore")
public final class IndexStore {
   @ObfuscatedName("m")
   @Export("IndexStore_buffer")
   static byte[] IndexStore_buffer;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("dataFile")
   BufferedFile dataFile;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   @Export("indexFile")
   BufferedFile indexFile;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1982523283
   )
   @Export("index")
   int index;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -748616567
   )
   @Export("maxEntrySize")
   int maxEntrySize;

   static {
      IndexStore_buffer = new byte[520];
   }

   @ObfuscatedSignature(
      signature = "(ILdy;Ldy;I)V"
   )
   public IndexStore(int var1, BufferedFile var2, BufferedFile var3, int var4) {
      this.dataFile = null;
      this.indexFile = null;
      this.maxEntrySize = 65000;
      this.index = var1;
      this.dataFile = var2;
      this.indexFile = var3;
      this.maxEntrySize = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-294587791"
   )
   @Export("read")
   public byte[] read(int var1) {
      BufferedFile var2 = this.dataFile;
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
               if(var3 < 0 || var3 > this.maxEntrySize) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1750864122"
   )
   @Export("write")
   public boolean write(int var1, byte[] var2, int var3) {
      BufferedFile var4 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxEntrySize) {
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-944588642"
   )
   @Export("write0")
   boolean write0(int var1, byte[] var2, int var3, boolean var4) {
      BufferedFile var5 = this.dataFile;
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
                  label142: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.dataFile.seek((long)(var6 * 520));

                        try {
                           this.dataFile.read(IndexStore_buffer, 0, 8);
                        } catch (EOFException var16) {
                           break label142;
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILfe;Lfy;B)Z",
      garbageValue = "1"
   )
   static final boolean method3585(int var0, int var1, int var2, class179 var3, CollisionMap var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class178.__fi_q[var7][var8] = 99;
      class178.__fi_w[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class178.__fi_l[var11] = var0;
      int var20 = var11 + 1;
      class178.__fi_e[var11] = var1;
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
                           WidgetGroupParent.__bx_o = var5;
                           UrlRequester.__eo_u = var6;
                           return false;
                        }

                        var5 = class178.__fi_l[var12];
                        var6 = class178.__fi_e[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.xInset;
                        var15 = var6 - var4.yInset;
                        if(var3.vmethod3644(var2, var5, var6, var4)) {
                           WidgetGroupParent.__bx_o = var5;
                           UrlRequester.__eo_u = var6;
                           return true;
                        }

                        var16 = class178.__fi_w[var18][var19] + 1;
                        if(var18 > 0 && class178.__fi_q[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class178.__fi_l[var20] = var5 - 1;
                                 class178.__fi_e[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18 - 1][var19] = 2;
                                 class178.__fi_w[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class178.__fi_q[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class178.__fi_l[var20] = var5 + 1;
                                 class178.__fi_e[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18 + 1][var19] = 8;
                                 class178.__fi_w[var18 + 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class178.__fi_q[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class178.__fi_l[var20] = var5;
                                 class178.__fi_e[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18][var19 - 1] = 1;
                                 class178.__fi_w[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class178.__fi_q[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class178.__fi_l[var20] = var5;
                                 class178.__fi_e[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18][var19 + 1] = 4;
                                 class178.__fi_w[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class178.__fi_q[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class178.__fi_l[var20] = var5 - 1;
                                 class178.__fi_e[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18 - 1][var19 - 1] = 3;
                                 class178.__fi_w[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class178.__fi_q[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class178.__fi_l[var20] = var5 + 1;
                                 class178.__fi_e[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class178.__fi_q[var18 + 1][var19 - 1] = 9;
                                 class178.__fi_w[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class178.__fi_q[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label277;
                              }
                           }

                           class178.__fi_l[var20] = var5 - 1;
                           class178.__fi_e[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class178.__fi_q[var18 - 1][var19 + 1] = 6;
                           class178.__fi_w[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class178.__fi_q[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                  continue label300;
               }
            }

            class178.__fi_l[var20] = var5 + 1;
            class178.__fi_e[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class178.__fi_q[var18 + 1][var19 + 1] = 12;
            class178.__fi_w[var18 + 1][var19 + 1] = var16;
         }
      }
   }
}
