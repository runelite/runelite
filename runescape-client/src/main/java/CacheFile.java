import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field1665;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("v")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -5333997756694413375L
   )
   long field1673;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1702832157
   )
   int field1666;
   @ObfuscatedName("h")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4127161431796046795L
   )
   long field1668;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -269499139
   )
   int field1674;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 6538862031506056999L
   )
   @Export("position")
   long position;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5593322699123253025L
   )
   @Export("length")
   long length;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1841172937382574949L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -6177854366748523917L
   )
   long field1671;

   @ObfuscatedSignature(
      signature = "(Ldg;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1673 = -1L;
      this.field1668 = -1L;
      this.field1674 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("v")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2071850579"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1731565934"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-75886459"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1668 != -1L && this.position >= this.field1668 && this.position + (long)var3 <= this.field1668 + (long)this.field1674) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1668), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1673 && this.position < (long)this.field1666 + this.field1673) {
            var8 = (int)((long)this.field1666 - (this.position - this.field1673));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1673), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1671 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1671 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1666) {
               var8 = this.field1666;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1668 != -1L) {
            if(this.field1668 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1668 - this.position);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.position;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1668 >= var4 && this.field1668 < (long)var7 + var4) {
               var13 = this.field1668;
            } else if(var4 >= this.field1668 && var4 < this.field1668 + (long)this.field1674) {
               var13 = var4;
            }

            if(this.field1668 + (long)this.field1674 > var4 && (long)this.field1674 + this.field1668 <= (long)var7 + var4) {
               var10 = this.field1668 + (long)this.field1674;
            } else if((long)var7 + var4 > this.field1668 && (long)var7 + var4 <= this.field1668 + (long)this.field1674) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1668), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1671 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "54"
   )
   @Export("load")
   void load() throws IOException {
      this.field1666 = 0;
      if(this.position != this.field1671) {
         this.accessFile.seek(this.position);
         this.field1671 = this.position;
      }

      int var1;
      for(this.field1673 = this.position; this.field1666 < this.readPayload.length; this.field1666 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1666, this.readPayload.length - this.field1666);
         if(var1 == -1) {
            break;
         }

         this.field1671 += (long)var1;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-701918833"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(-1L != this.field1668 && (this.position < this.field1668 || this.position > this.field1668 + (long)this.field1674)) {
            this.flush();
         }

         if(this.field1668 != -1L && this.position + (long)var3 > (long)this.writePayload.length + this.field1668) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1668));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1668), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1674 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1668) {
                  this.field1668 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1668), var3);
               this.position += (long)var3;
               if(this.position - this.field1668 > (long)this.field1674) {
                  this.field1674 = (int)(this.position - this.field1668);
               }

            }
         } else {
            if(this.field1671 != this.position) {
               this.accessFile.seek(this.position);
               this.field1671 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1671 += (long)var3;
            if(this.field1671 > this.length) {
               this.length = this.field1671;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1673 && this.position < this.field1673 + (long)this.field1666) {
               var9 = this.position;
            } else if(this.field1673 >= this.position && this.field1673 < (long)var3 + this.position) {
               var9 = this.field1673;
            }

            if(this.position + (long)var3 > this.field1673 && (long)var3 + this.position <= this.field1673 + (long)this.field1666) {
               var6 = (long)var3 + this.position;
            } else if(this.field1673 + (long)this.field1666 > this.position && (long)this.field1666 + this.field1673 <= (long)var3 + this.position) {
               var6 = (long)this.field1666 + this.field1673;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1673), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1671 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2105392535"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1668) {
         if(this.field1668 != this.field1671) {
            this.accessFile.seek(this.field1668);
            this.field1671 = this.field1668;
         }

         this.accessFile.write(this.writePayload, 0, this.field1674);
         this.field1671 += (long)(this.field1674 * 558987349) * -269499139L;
         if(this.field1671 > this.length) {
            this.length = this.field1671;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1668 >= this.field1673 && this.field1668 < this.field1673 + (long)this.field1666) {
            var1 = this.field1668;
         } else if(this.field1673 >= this.field1668 && this.field1673 < this.field1668 + (long)this.field1674) {
            var1 = this.field1673;
         }

         if(this.field1668 + (long)this.field1674 > this.field1673 && (long)this.field1674 + this.field1668 <= this.field1673 + (long)this.field1666) {
            var3 = this.field1668 + (long)this.field1674;
         } else if((long)this.field1666 + this.field1673 > this.field1668 && this.field1673 + (long)this.field1666 <= (long)this.field1674 + this.field1668) {
            var3 = (long)this.field1666 + this.field1673;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1668), this.readPayload, (int)(var1 - this.field1673), var5);
         }

         this.field1668 = -1L;
         this.field1674 = 0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "-1546294930"
   )
   static final boolean method2415(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class133.Viewport_mouseY + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class133.Viewport_mouseY - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class133.Viewport_mouseX + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class133.Viewport_mouseX - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lkg;",
      garbageValue = "1225722066"
   )
   @Export("createSprite")
   public static final SpritePixels createSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var4 << 40) + ((long)var2 << 38) + ((long)var1 << 16) + (long)var0 + ((long)var3 << 42);
      SpritePixels var8;
      if(!var5) {
         var8 = (SpritePixels)ItemComposition.itemSpriteCache.get(var6);
         if(var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = class115.getItemDefinition(var0);
      if(var1 > 1 && var9.countObj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.countCo[var11] && var9.countCo[var11] != 0) {
               var10 = var9.countObj[var11];
            }
         }

         if(var10 != -1) {
            var9 = class115.getItemDefinition(var10);
         }
      }

      Model var19 = var9.getModel(1);
      if(var19 == null) {
         return null;
      } else {
         SpritePixels var20 = null;
         if(var9.notedTemplate != -1) {
            var20 = createSprite(var9.note, 10, 1, 0, 0, true);
            if(var20 == null) {
               return null;
            }
         } else if(var9.notedId != -1) {
            var20 = createSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.int3 != -1) {
            var20 = createSprite(var9.int2, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.graphicsPixels;
         int var13 = Rasterizer2D.graphicsPixelsWidth;
         int var14 = Rasterizer2D.graphicsPixelsHeight;
         int[] var15 = new int[4];
         Rasterizer2D.copyDrawRegion(var15);
         var8 = new SpritePixels(36, 32);
         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         Rasterizer2D.reset();
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.method2671(16, 16);
         Graphics3D.rasterGouraudLowRes = false;
         if(var9.int3 != -1) {
            var20.drawAt(0, 0);
         }

         int var16 = var9.zoom2d;
         if(var5) {
            var16 = (int)(1.5D * (double)var16);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = var16 * Graphics3D.SINE[var9.xan2d] >> 16;
         int var18 = var16 * Graphics3D.COSINE[var9.xan2d] >> 16;
         var19.calculateBoundsCylinder();
         var19.method2590(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var19.modelHeight / 2 + var17 + var9.offsetY2d, var18 + var9.offsetY2d);
         if(var9.notedId != -1) {
            var20.drawAt(0, 0);
         }

         if(var2 >= 1) {
            var8.method5278(1);
         }

         if(var2 >= 2) {
            var8.method5278(16777215);
         }

         if(var3 != 0) {
            var8.method5306(var3);
         }

         Rasterizer2D.setRasterBuffer(var8.pixels, 36, 32);
         if(var9.notedTemplate != -1) {
            var20.drawAt(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            GrandExchangeOffer.field297.method4950(Client.getItemStackAmountText(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            ItemComposition.itemSpriteCache.put(var8, var6);
         }

         Rasterizer2D.setRasterBuffer(var12, var13, var14);
         Rasterizer2D.setDrawRegion(var15);
         Graphics3D.Rasterizer3D_method1();
         Graphics3D.rasterGouraudLowRes = true;
         return var8;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1565858607"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3323 != 0 && var3 > IndexDataBase.field3323) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3323 != 0 && var6 > IndexDataBase.field3323) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class178.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }
}
