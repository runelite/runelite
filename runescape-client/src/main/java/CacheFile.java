import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("q")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2121763124377358739L
   )
   long field1668;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 583668773
   )
   int field1662;
   @ObfuscatedName("l")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 8157491183431505231L
   )
   long field1665;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1408660169
   )
   int field1666;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -470869676014934995L
   )
   @Export("position")
   long position;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -4752483023239206751L
   )
   @Export("length")
   long length;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -107293355636894513L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 5001898978440913711L
   )
   long field1670;

   @ObfuscatedSignature(
      signature = "(Lde;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1668 = -1L;
      this.field1665 = -1L;
      this.field1666 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-833088813"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-924901955"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "16"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1764510042"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1665 && this.position >= this.field1665 && (long)var3 + this.position <= (long)this.field1666 + this.field1665) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1665), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1668 && this.position < this.field1668 + (long)this.field1662) {
            var8 = (int)((long)this.field1662 - (this.position - this.field1668));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1668), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1670 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1670 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1662) {
               var8 = this.field1662;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1665 != -1L) {
            if(this.field1665 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1665 - this.position);
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
            if(this.field1665 >= var4 && this.field1665 < (long)var7 + var4) {
               var13 = this.field1665;
            } else if(var4 >= this.field1665 && var4 < (long)this.field1666 + this.field1665) {
               var13 = var4;
            }

            if(this.field1665 + (long)this.field1666 > var4 && (long)this.field1666 + this.field1665 <= var4 + (long)var7) {
               var10 = this.field1665 + (long)this.field1666;
            } else if(var4 + (long)var7 > this.field1665 && var4 + (long)var7 <= (long)this.field1666 + this.field1665) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1665), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1670 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "983750832"
   )
   @Export("load")
   void load() throws IOException {
      this.field1662 = 0;
      if(this.field1670 != this.position) {
         this.accessFile.seek(this.position);
         this.field1670 = this.position;
      }

      int var1;
      for(this.field1668 = this.position; this.field1662 < this.readPayload.length; this.field1662 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1662, this.readPayload.length - this.field1662);
         if(var1 == -1) {
            break;
         }

         this.field1670 += (long)var1;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2022730929"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.capacity) {
            this.capacity = (long)var3 + this.position;
         }

         if(this.field1665 != -1L && (this.position < this.field1665 || this.position > (long)this.field1666 + this.field1665)) {
            this.flush();
         }

         if(this.field1665 != -1L && (long)var3 + this.position > this.field1665 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1665));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1665), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1666 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1665) {
                  this.field1665 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1665), var3);
               this.position += (long)var3;
               if(this.position - this.field1665 > (long)this.field1666) {
                  this.field1666 = (int)(this.position - this.field1665);
               }

            }
         } else {
            if(this.position != this.field1670) {
               this.accessFile.seek(this.position);
               this.field1670 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1670 += (long)var3;
            if(this.field1670 > this.length) {
               this.length = this.field1670;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1668 && this.position < (long)this.field1662 + this.field1668) {
               var9 = this.position;
            } else if(this.field1668 >= this.position && this.field1668 < this.position + (long)var3) {
               var9 = this.field1668;
            }

            if(this.position + (long)var3 > this.field1668 && this.position + (long)var3 <= (long)this.field1662 + this.field1668) {
               var6 = this.position + (long)var3;
            } else if(this.field1668 + (long)this.field1662 > this.position && this.field1668 + (long)this.field1662 <= this.position + (long)var3) {
               var6 = (long)this.field1662 + this.field1668;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1668), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1670 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   @Export("flush")
   void flush() throws IOException {
      if(this.field1665 != -1L) {
         if(this.field1665 != this.field1670) {
            this.accessFile.seek(this.field1665);
            this.field1670 = this.field1665;
         }

         this.accessFile.write(this.writePayload, 0, this.field1666);
         this.field1670 += (long)(this.field1666 * -633452679) * 1408660169L;
         if(this.field1670 > this.length) {
            this.length = this.field1670;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1665 >= this.field1668 && this.field1665 < (long)this.field1662 + this.field1668) {
            var1 = this.field1665;
         } else if(this.field1668 >= this.field1665 && this.field1668 < (long)this.field1666 + this.field1665) {
            var1 = this.field1668;
         }

         if(this.field1665 + (long)this.field1666 > this.field1668 && this.field1665 + (long)this.field1666 <= this.field1668 + (long)this.field1662) {
            var3 = (long)this.field1666 + this.field1665;
         } else if(this.field1668 + (long)this.field1662 > this.field1665 && this.field1668 + (long)this.field1662 <= this.field1665 + (long)this.field1666) {
            var3 = this.field1668 + (long)this.field1662;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1665), this.readPayload, (int)(var1 - this.field1668), var5);
         }

         this.field1665 = -1L;
         this.field1666 = 0;
      }

   }
}
