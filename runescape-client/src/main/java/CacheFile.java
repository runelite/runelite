import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   @Export("scrollbarSprites")
   static IndexedSprite[] scrollbarSprites;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldx;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("q")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 6564084455742484359L
   )
   long field1637;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 682611899
   )
   int field1638;
   @ObfuscatedName("a")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1421090251964238209L
   )
   long field1640;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1226333559
   )
   int field1642;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 3815525136156543595L
   )
   @Export("position")
   long position;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 3764226554642405077L
   )
   @Export("length")
   long length;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -993749523884333199L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -6587697539488708079L
   )
   long field1645;

   @ObfuscatedSignature(
      signature = "(Ldx;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1637 = -1L;
      this.field1640 = -1L;
      this.field1642 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "466710870"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("q")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "15"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "29"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1830332114"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1640 && this.position >= this.field1640 && (long)var3 + this.position <= (long)this.field1642 + this.field1640) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1640), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1637 && this.position < (long)this.field1638 + this.field1637) {
            var8 = (int)((long)this.field1638 - (this.position - this.field1637));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1637), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1645 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1645 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1638) {
               var8 = this.field1638;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1640) {
            if(this.field1640 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1640 - this.position);
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
            if(this.field1640 >= var4 && this.field1640 < var4 + (long)var7) {
               var13 = this.field1640;
            } else if(var4 >= this.field1640 && var4 < (long)this.field1642 + this.field1640) {
               var13 = var4;
            }

            if(this.field1640 + (long)this.field1642 > var4 && (long)this.field1642 + this.field1640 <= var4 + (long)var7) {
               var10 = this.field1640 + (long)this.field1642;
            } else if(var4 + (long)var7 > this.field1640 && (long)var7 + var4 <= this.field1640 + (long)this.field1642) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1640), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1645 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "594054156"
   )
   @Export("load")
   void load() throws IOException {
      this.field1638 = 0;
      if(this.position != this.field1645) {
         this.accessFile.seek(this.position);
         this.field1645 = this.position;
      }

      int var1;
      for(this.field1637 = this.position; this.field1638 < this.readPayload.length; this.field1638 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1638, this.readPayload.length - this.field1638);
         if(var1 == -1) {
            break;
         }

         this.field1645 += (long)var1;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1956895129"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(-1L != this.field1640 && (this.position < this.field1640 || this.position > (long)this.field1642 + this.field1640)) {
            this.flush();
         }

         if(-1L != this.field1640 && (long)var3 + this.position > (long)this.writePayload.length + this.field1640) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1640));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1640), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1642 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1640) {
                  this.field1640 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1640), var3);
               this.position += (long)var3;
               if(this.position - this.field1640 > (long)this.field1642) {
                  this.field1642 = (int)(this.position - this.field1640);
               }

            }
         } else {
            if(this.position != this.field1645) {
               this.accessFile.seek(this.position);
               this.field1645 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1645 += (long)var3;
            if(this.field1645 > this.length) {
               this.length = this.field1645;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1637 && this.position < this.field1637 + (long)this.field1638) {
               var9 = this.position;
            } else if(this.field1637 >= this.position && this.field1637 < (long)var3 + this.position) {
               var9 = this.field1637;
            }

            if(this.position + (long)var3 > this.field1637 && (long)var3 + this.position <= this.field1637 + (long)this.field1638) {
               var6 = this.position + (long)var3;
            } else if(this.field1637 + (long)this.field1638 > this.position && (long)this.field1638 + this.field1637 <= this.position + (long)var3) {
               var6 = this.field1637 + (long)this.field1638;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1637), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1645 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "792997164"
   )
   @Export("flush")
   void flush() throws IOException {
      if(this.field1640 != -1L) {
         if(this.field1640 != this.field1645) {
            this.accessFile.seek(this.field1640);
            this.field1645 = this.field1640;
         }

         this.accessFile.write(this.writePayload, 0, this.field1642);
         this.field1645 += -1226333559L * (long)(this.field1642 * 1507357625);
         if(this.field1645 > this.length) {
            this.length = this.field1645;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1640 >= this.field1637 && this.field1640 < (long)this.field1638 + this.field1637) {
            var1 = this.field1640;
         } else if(this.field1637 >= this.field1640 && this.field1637 < (long)this.field1642 + this.field1640) {
            var1 = this.field1637;
         }

         if(this.field1640 + (long)this.field1642 > this.field1637 && (long)this.field1642 + this.field1640 <= this.field1637 + (long)this.field1638) {
            var3 = this.field1640 + (long)this.field1642;
         } else if((long)this.field1638 + this.field1637 > this.field1640 && (long)this.field1638 + this.field1637 <= (long)this.field1642 + this.field1640) {
            var3 = this.field1637 + (long)this.field1638;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1640), this.readPayload, (int)(var1 - this.field1637), var5);
         }

         this.field1640 = -1L;
         this.field1642 = 0;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1129563689"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3337 != 0 && var3 > IndexDataBase.field3337) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 >= 0 && (IndexDataBase.field3337 == 0 || var6 <= IndexDataBase.field3337)) {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class187.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         } else {
            throw new RuntimeException();
         }
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-552802169"
   )
   static final boolean method2534(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
