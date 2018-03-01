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
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldi;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("z")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 1719556681172017347L
   )
   long field1675;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 379482547
   )
   int field1676;
   @ObfuscatedName("e")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 544770467943734887L
   )
   long field1678;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 927981125
   )
   int field1679;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6368528782559031761L
   )
   @Export("position")
   long position;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3284025277606081479L
   )
   @Export("length")
   long length;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 7207119517482588555L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 9107848659361622329L
   )
   long field1673;

   @ObfuscatedSignature(
      signature = "(Ldi;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1675 = -1L;
      this.field1678 = -1L;
      this.field1679 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2144623368"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("z")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-404273319"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-493291292"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1678 != -1L && this.position >= this.field1678 && (long)var3 + this.position <= (long)this.field1679 + this.field1678) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1678), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1675 && this.position < this.field1675 + (long)this.field1676) {
            var8 = (int)((long)this.field1676 - (this.position - this.field1675));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1675), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1673 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1673 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1676) {
               var8 = this.field1676;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1678 != -1L) {
            if(this.field1678 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1678 - this.position);
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
            if(this.field1678 >= var4 && this.field1678 < (long)var7 + var4) {
               var13 = this.field1678;
            } else if(var4 >= this.field1678 && var4 < (long)this.field1679 + this.field1678) {
               var13 = var4;
            }

            if((long)this.field1679 + this.field1678 > var4 && (long)this.field1679 + this.field1678 <= var4 + (long)var7) {
               var10 = this.field1678 + (long)this.field1679;
            } else if((long)var7 + var4 > this.field1678 && (long)var7 + var4 <= (long)this.field1679 + this.field1678) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1678), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1673 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1779677866"
   )
   @Export("load")
   void load() throws IOException {
      this.field1676 = 0;
      if(this.field1673 != this.position) {
         this.accessFile.seek(this.position);
         this.field1673 = this.position;
      }

      int var1;
      for(this.field1675 = this.position; this.field1676 < this.readPayload.length; this.field1676 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1676, this.readPayload.length - this.field1676);
         if(var1 == -1) {
            break;
         }

         this.field1673 += (long)var1;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "4"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(-1L != this.field1678 && (this.position < this.field1678 || this.position > this.field1678 + (long)this.field1679)) {
            this.flush();
         }

         if(-1L != this.field1678 && this.position + (long)var3 > (long)this.writePayload.length + this.field1678) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1678));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1678), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1679 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1678) {
                  this.field1678 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1678), var3);
               this.position += (long)var3;
               if(this.position - this.field1678 > (long)this.field1679) {
                  this.field1679 = (int)(this.position - this.field1678);
               }

            }
         } else {
            if(this.position != this.field1673) {
               this.accessFile.seek(this.position);
               this.field1673 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1673 += (long)var3;
            if(this.field1673 > this.length) {
               this.length = this.field1673;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1675 && this.position < this.field1675 + (long)this.field1676) {
               var9 = this.position;
            } else if(this.field1675 >= this.position && this.field1675 < this.position + (long)var3) {
               var9 = this.field1675;
            }

            if((long)var3 + this.position > this.field1675 && (long)var3 + this.position <= this.field1675 + (long)this.field1676) {
               var6 = this.position + (long)var3;
            } else if((long)this.field1676 + this.field1675 > this.position && (long)this.field1676 + this.field1675 <= this.position + (long)var3) {
               var6 = this.field1675 + (long)this.field1676;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1675), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1673 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1423319948"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1678) {
         if(this.field1673 != this.field1678) {
            this.accessFile.seek(this.field1678);
            this.field1673 = this.field1678;
         }

         this.accessFile.write(this.writePayload, 0, this.field1679);
         this.field1673 += (long)(this.field1679 * -423918451) * 927981125L;
         if(this.field1673 > this.length) {
            this.length = this.field1673;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1678 >= this.field1675 && this.field1678 < this.field1675 + (long)this.field1676) {
            var1 = this.field1678;
         } else if(this.field1675 >= this.field1678 && this.field1675 < this.field1678 + (long)this.field1679) {
            var1 = this.field1675;
         }

         if((long)this.field1679 + this.field1678 > this.field1675 && (long)this.field1679 + this.field1678 <= this.field1675 + (long)this.field1676) {
            var3 = (long)this.field1679 + this.field1678;
         } else if(this.field1675 + (long)this.field1676 > this.field1678 && (long)this.field1676 + this.field1675 <= (long)this.field1679 + this.field1678) {
            var3 = (long)this.field1676 + this.field1675;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1678), this.readPayload, (int)(var1 - this.field1675), var5);
         }

         this.field1678 = -1L;
         this.field1679 = 0;
      }

   }
}
