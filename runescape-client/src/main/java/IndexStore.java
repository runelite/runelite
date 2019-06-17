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
      BufferedFile var3 = this.dataFile;
      synchronized(this.dataFile) {
         byte[] var10000;
         try {
            Object var4;
            if(this.indexFile.length() < (long)(var1 * 6 + 6)) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.read(IndexStore_buffer, 0, 6);
            int var5 = ((IndexStore_buffer[0] & 255) << 16) + (IndexStore_buffer[2] & 255) + ((IndexStore_buffer[1] & 255) << 8);
            int var6 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
            if(var5 < 0 || var5 > this.maxEntrySize) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            }

            if(var6 > 0 && (long)var6 <= this.dataFile.length() / 520L) {
               byte[] var7 = new byte[var5];
               int var8 = 0;
               int var9 = 0;

               while(var8 < var5) {
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

                  this.dataFile.read(IndexStore_buffer, 0, var10 + 8);
                  int var11 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                  int var12 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                  int var13 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                  int var14 = IndexStore_buffer[7] & 255;
                  if(var11 == var1 && var9 == var12 && var14 == this.index) {
                     if(var13 >= 0 && (long)var13 <= this.dataFile.length() / 520L) {
                        for(int var15 = 0; var15 < var10; ++var15) {
                           var7[var8++] = IndexStore_buffer[var15 + 8];
                        }

                        var6 = var13;
                        ++var9;
                        continue;
                     }

                     var4 = null;
                     var10000 = (byte[])((byte[])var4);
                     return var10000;
                  }

                  var4 = null;
                  var10000 = (byte[])((byte[])var4);
                  return var10000;
               }

               var10000 = var7;
               return var10000;
            }

            var4 = null;
            var10000 = (byte[])((byte[])var4);
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
      BufferedFile var4 = this.dataFile;
      BufferedFile var5 = this.dataFile;
      synchronized(this.dataFile) {
         if(var3 >= 0 && var3 <= this.maxEntrySize) {
            boolean var6 = this.write0(var1, var2, var3, true);
            if(!var6) {
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
      BufferedFile var5 = this.dataFile;
      BufferedFile var6 = this.dataFile;
      synchronized(this.dataFile) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if(var4) {
               if(this.indexFile.length() < (long)(var1 * 6 + 6)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.indexFile.seek((long)(var1 * 6));
               this.indexFile.read(IndexStore_buffer, 0, 6);
               var7 = (IndexStore_buffer[5] & 255) + ((IndexStore_buffer[3] & 255) << 16) + ((IndexStore_buffer[4] & 255) << 8);
               if(var7 <= 0 || (long)var7 > this.dataFile.length() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.dataFile.length() + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            IndexStore_buffer[0] = (byte)(var3 >> 16);
            IndexStore_buffer[1] = (byte)(var3 >> 8);
            IndexStore_buffer[2] = (byte)var3;
            IndexStore_buffer[3] = (byte)(var7 >> 16);
            IndexStore_buffer[4] = (byte)(var7 >> 8);
            IndexStore_buffer[5] = (byte)var7;
            this.indexFile.seek((long)(var1 * 6));
            this.indexFile.write(IndexStore_buffer, 0, 6);
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
                           this.dataFile.read(IndexStore_buffer, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = (IndexStore_buffer[1] & 255) + ((IndexStore_buffer[0] & 255) << 8);
                        int var13 = (IndexStore_buffer[3] & 255) + ((IndexStore_buffer[2] & 255) << 8);
                        var11 = ((IndexStore_buffer[5] & 255) << 8) + ((IndexStore_buffer[4] & 255) << 16) + (IndexStore_buffer[6] & 255);
                        int var14 = IndexStore_buffer[7] & 255;
                        if(var12 != var1 || var13 != var10 || var14 != this.index) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.dataFile.length() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if(var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.dataFile.length() + 519L) / 520L);
                        if(var11 == 0) {
                           ++var11;
                        }

                        if(var7 == var11) {
                           ++var11;
                        }
                     }

                     if(var3 - var9 <= 512) {
                        var11 = 0;
                     }

                     IndexStore_buffer[0] = (byte)(var1 >> 8);
                     IndexStore_buffer[1] = (byte)var1;
                     IndexStore_buffer[2] = (byte)(var10 >> 8);
                     IndexStore_buffer[3] = (byte)var10;
                     IndexStore_buffer[4] = (byte)(var11 >> 16);
                     IndexStore_buffer[5] = (byte)(var11 >> 8);
                     IndexStore_buffer[6] = (byte)var11;
                     IndexStore_buffer[7] = (byte)this.index;
                     this.dataFile.seek((long)(var7 * 520));
                     this.dataFile.write(IndexStore_buffer, 0, 8);
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
      int var13 = var11 + 1;
      class178.__fi_e[var11] = var1;
      int[][] var14 = var4.flags;

      label204:
      while(var13 != var12) {
         var5 = class178.__fi_l[var12];
         var6 = class178.__fi_e[var12];
         var12 = var12 + 1 & 4095;
         int var19 = var5 - var9;
         int var20 = var6 - var10;
         int var15 = var5 - var4.xInset;
         int var16 = var6 - var4.yInset;
         if(var3.vmethod3644(var2, var5, var6, var4)) {
            WidgetGroupParent.__bx_o = var5;
            UrlRequester.__eo_u = var6;
            return true;
         }

         int var17 = class178.__fi_w[var19][var20] + 1;
         int var18;
         if(var19 > 0 && class178.__fi_q[var19 - 1][var20] == 0 && (var14[var15 - 1][var16] & 19136782) == 0 && (var14[var15 - 1][var16 + var2 - 1] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class178.__fi_l[var13] = var5 - 1;
                  class178.__fi_e[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20] = 2;
                  class178.__fi_w[var19 - 1][var20] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + var16] & 19136830) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && class178.__fi_q[var19 + 1][var20] == 0 && (var14[var15 + var2][var16] & 19136899) == 0 && (var14[var15 + var2][var16 + var2 - 1] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class178.__fi_l[var13] = var5 + 1;
                  class178.__fi_e[var13] = var6;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19 + 1][var20] = 8;
                  class178.__fi_w[var19 + 1][var20] = var17;
                  break;
               }

               if((var14[var15 + var2][var16 + var18] & 19136995) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 > 0 && class178.__fi_q[var19][var20 - 1] == 0 && (var14[var15][var16 - 1] & 19136782) == 0 && (var14[var15 + var2 - 1][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class178.__fi_l[var13] = var5;
                  class178.__fi_e[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19][var20 - 1] = 1;
                  class178.__fi_w[var19][var20 - 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var20 < 128 - var2 && class178.__fi_q[var19][var20 + 1] == 0 && (var14[var15][var16 + var2] & 19136824) == 0 && (var14[var15 + var2 - 1][var16 + var2] & 19136992) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2 - 1) {
                  class178.__fi_l[var13] = var5;
                  class178.__fi_e[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19][var20 + 1] = 4;
                  class178.__fi_w[var19][var20 + 1] = var17;
                  break;
               }

               if((var14[var18 + var15][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 > 0 && class178.__fi_q[var19 - 1][var20 - 1] == 0 && (var14[var15 - 1][var16 - 1] & 19136782) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class178.__fi_l[var13] = var5 - 1;
                  class178.__fi_e[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20 - 1] = 3;
                  class178.__fi_w[var19 - 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var18 + (var16 - 1)] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 > 0 && class178.__fi_q[var19 + 1][var20 - 1] == 0 && (var14[var15 + var2][var16 - 1] & 19136899) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class178.__fi_l[var13] = var5 + 1;
                  class178.__fi_e[var13] = var6 - 1;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19 + 1][var20 - 1] = 9;
                  class178.__fi_w[var19 + 1][var20 - 1] = var17;
                  break;
               }

               if((var14[var15 + var2][var18 + (var16 - 1)] & 19136995) != 0 || (var14[var18 + var15][var16 - 1] & 19136911) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 > 0 && var20 < 128 - var2 && class178.__fi_q[var19 - 1][var20 + 1] == 0 && (var14[var15 - 1][var16 + var2] & 19136824) == 0) {
            var18 = 1;

            while(true) {
               if(var18 >= var2) {
                  class178.__fi_l[var13] = var5 - 1;
                  class178.__fi_e[var13] = var6 + 1;
                  var13 = var13 + 1 & 4095;
                  class178.__fi_q[var19 - 1][var20 + 1] = 6;
                  class178.__fi_w[var19 - 1][var20 + 1] = var17;
                  break;
               }

               if((var14[var15 - 1][var16 + var18] & 19136830) != 0 || (var14[var18 + (var15 - 1)][var16 + var2] & 19137016) != 0) {
                  break;
               }

               ++var18;
            }
         }

         if(var19 < 128 - var2 && var20 < 128 - var2 && class178.__fi_q[var19 + 1][var20 + 1] == 0 && (var14[var15 + var2][var16 + var2] & 19136992) == 0) {
            for(var18 = 1; var18 < var2; ++var18) {
               if((var14[var15 + var18][var16 + var2] & 19137016) != 0 || (var14[var15 + var2][var18 + var16] & 19136995) != 0) {
                  continue label204;
               }
            }

            class178.__fi_l[var13] = var5 + 1;
            class178.__fi_e[var13] = var6 + 1;
            var13 = var13 + 1 & 4095;
            class178.__fi_q[var19 + 1][var20 + 1] = 12;
            class178.__fi_w[var19 + 1][var20 + 1] = var17;
         }
      }

      WidgetGroupParent.__bx_o = var5;
      UrlRequester.__eo_u = var6;
      return false;
   }

   static {
      IndexStore_buffer = new byte[520];
   }
}
