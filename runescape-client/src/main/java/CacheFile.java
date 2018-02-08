import java.awt.FontMetrics;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("an")
   static FontMetrics field1462;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lcs;"
   )
   @Export("accessFile")
   FileOnDisk accessFile;
   @ObfuscatedName("g")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -7904432655459778789L
   )
   long field1467;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 153192335
   )
   int field1461;
   @ObfuscatedName("i")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 2987665189945972835L
   )
   long field1463;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -229056163
   )
   int field1460;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4384069549311636543L
   )
   @Export("position")
   long position;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 9027379672096387417L
   )
   @Export("length")
   long length;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 8928485690236685793L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 2378210238404632707L
   )
   long field1464;

   @ObfuscatedSignature(
      signature = "(Lcs;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1467 = -1L;
      this.field1463 = -1L;
      this.field1460 = 0;
      this.accessFile = var1;
      this.capacity = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("g")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1829819939"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1718803535"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1405118549"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1463 != -1L && this.position >= this.field1463 && (long)var3 + this.position <= this.field1463 + (long)this.field1460) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1463), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1467 && this.position < this.field1467 + (long)this.field1461) {
            var8 = (int)((long)this.field1461 - (this.position - this.field1467));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1467), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.accessFile.seek(this.position);

            for(this.field1464 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.accessFile.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1464 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.load();
            var8 = var3;
            if(var3 > this.field1461) {
               var8 = this.field1461;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1463) {
            if(this.field1463 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1463 - this.position);
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
            if(this.field1463 >= var4 && this.field1463 < var4 + (long)var7) {
               var13 = this.field1463;
            } else if(var4 >= this.field1463 && var4 < this.field1463 + (long)this.field1460) {
               var13 = var4;
            }

            if((long)this.field1460 + this.field1463 > var4 && this.field1463 + (long)this.field1460 <= (long)var7 + var4) {
               var10 = (long)this.field1460 + this.field1463;
            } else if((long)var7 + var4 > this.field1463 && (long)var7 + var4 <= this.field1463 + (long)this.field1460) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1463), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1464 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "363854668"
   )
   @Export("load")
   void load() throws IOException {
      this.field1461 = 0;
      if(this.position != this.field1464) {
         this.accessFile.seek(this.position);
         this.field1464 = this.position;
      }

      int var1;
      for(this.field1467 = this.position; this.field1461 < this.readPayload.length; this.field1461 += var1) {
         var1 = this.accessFile.read(this.readPayload, this.field1461, this.readPayload.length - this.field1461);
         if(var1 == -1) {
            break;
         }

         this.field1464 += (long)var1;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-805245572"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.position + (long)var3 > this.capacity) {
            this.capacity = this.position + (long)var3;
         }

         if(this.field1463 != -1L && (this.position < this.field1463 || this.position > (long)this.field1460 + this.field1463)) {
            this.flush();
         }

         if(this.field1463 != -1L && this.position + (long)var3 > (long)this.writePayload.length + this.field1463) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1463));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1463), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1460 = this.writePayload.length;
            this.flush();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1463) {
                  this.field1463 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1463), var3);
               this.position += (long)var3;
               if(this.position - this.field1463 > (long)this.field1460) {
                  this.field1460 = (int)(this.position - this.field1463);
               }

            }
         } else {
            if(this.field1464 != this.position) {
               this.accessFile.seek(this.position);
               this.field1464 = this.position;
            }

            this.accessFile.write(var1, var2, var3);
            this.field1464 += (long)var3;
            if(this.field1464 > this.length) {
               this.length = this.field1464;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1467 && this.position < (long)this.field1461 + this.field1467) {
               var9 = this.position;
            } else if(this.field1467 >= this.position && this.field1467 < (long)var3 + this.position) {
               var9 = this.field1467;
            }

            if(this.position + (long)var3 > this.field1467 && (long)var3 + this.position <= this.field1467 + (long)this.field1461) {
               var6 = this.position + (long)var3;
            } else if(this.field1467 + (long)this.field1461 > this.position && this.field1467 + (long)this.field1461 <= (long)var3 + this.position) {
               var6 = this.field1467 + (long)this.field1461;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1467), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1464 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "928532206"
   )
   @Export("flush")
   void flush() throws IOException {
      if(-1L != this.field1463) {
         if(this.field1463 != this.field1464) {
            this.accessFile.seek(this.field1463);
            this.field1464 = this.field1463;
         }

         this.accessFile.write(this.writePayload, 0, this.field1460);
         this.field1464 += (long)(this.field1460 * -2129495307) * -229056163L;
         if(this.field1464 > this.length) {
            this.length = this.field1464;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1463 >= this.field1467 && this.field1463 < (long)this.field1461 + this.field1467) {
            var1 = this.field1463;
         } else if(this.field1467 >= this.field1463 && this.field1467 < this.field1463 + (long)this.field1460) {
            var1 = this.field1467;
         }

         if((long)this.field1460 + this.field1463 > this.field1467 && this.field1463 + (long)this.field1460 <= (long)this.field1461 + this.field1467) {
            var3 = (long)this.field1460 + this.field1463;
         } else if((long)this.field1461 + this.field1467 > this.field1463 && this.field1467 + (long)this.field1461 <= this.field1463 + (long)this.field1460) {
            var3 = (long)this.field1461 + this.field1467;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1463), this.readPayload, (int)(var1 - this.field1467), var5);
         }

         this.field1463 = -1L;
         this.field1460 = 0;
      }

   }
}
