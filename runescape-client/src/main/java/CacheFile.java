import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -4108413842644483853L
   )
   long field1770;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2140786687
   )
   int field1764;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 5258019074692138753L
   )
   long field1771;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -7144953046650802317L
   )
   long field1767;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -3519649255073480597L
   )
   @Export("position")
   long position;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 3197111509161844153L
   )
   long field1761;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ldr;"
   )
   FileOnDisk field1763;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -50630873
   )
   int field1766;
   @ObfuscatedName("x")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("h")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 7946523511696296127L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldr;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1761 = -1L;
      this.field1767 = -1L;
      this.field1766 = 0;
      this.field1763 = var1;
      this.field1770 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2369(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1767 && this.position >= this.field1767 && this.position + (long)var3 <= this.field1767 + (long)this.field1766) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1767), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1761 && this.position < this.field1761 + (long)this.field1764) {
            var8 = (int)((long)this.field1764 - (this.position - this.field1761));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1761), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1763.seek(this.position);

            for(this.field1771 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1763.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1771 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2366();
            var8 = var3;
            if(var3 > this.field1764) {
               var8 = this.field1764;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1767) {
            if(this.field1767 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1767 - this.position);
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
            if(this.field1767 >= var4 && this.field1767 < var4 + (long)var7) {
               var13 = this.field1767;
            } else if(var4 >= this.field1767 && var4 < (long)this.field1766 + this.field1767) {
               var13 = var4;
            }

            if((long)this.field1766 + this.field1767 > var4 && this.field1767 + (long)this.field1766 <= var4 + (long)var7) {
               var10 = this.field1767 + (long)this.field1766;
            } else if((long)var7 + var4 > this.field1767 && (long)var7 + var4 <= (long)this.field1766 + this.field1767) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1767), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1771 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1907271488"
   )
   void method2361() throws IOException {
      if(-1L != this.field1767) {
         if(this.field1771 != this.field1767) {
            this.field1763.seek(this.field1767);
            this.field1771 = this.field1767;
         }

         this.field1763.write(this.writePayload, 0, this.field1766);
         this.field1771 += (long)(this.field1766 * -794226537) * -50630873L;
         if(this.field1771 > this.length) {
            this.length = this.field1771;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1767 >= this.field1761 && this.field1767 < (long)this.field1764 + this.field1761) {
            var1 = this.field1767;
         } else if(this.field1761 >= this.field1767 && this.field1761 < this.field1767 + (long)this.field1766) {
            var1 = this.field1761;
         }

         if((long)this.field1766 + this.field1767 > this.field1761 && this.field1767 + (long)this.field1766 <= (long)this.field1764 + this.field1761) {
            var3 = (long)this.field1766 + this.field1767;
         } else if(this.field1761 + (long)this.field1764 > this.field1767 && (long)this.field1764 + this.field1761 <= this.field1767 + (long)this.field1766) {
            var3 = this.field1761 + (long)this.field1764;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1767), this.readPayload, (int)(var1 - this.field1761), var5);
         }

         this.field1767 = -1L;
         this.field1766 = 0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-952923342"
   )
   public long method2354() {
      return this.field1770;
   }

   @ObfuscatedName("h")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1317396215"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1770) {
            this.field1770 = this.position + (long)var3;
         }

         if(this.field1767 != -1L && (this.position < this.field1767 || this.position > this.field1767 + (long)this.field1766)) {
            this.method2361();
         }

         if(this.field1767 != -1L && (long)var3 + this.position > this.field1767 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1767));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1767), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1766 = this.writePayload.length;
            this.method2361();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1767) {
                  this.field1767 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1767), var3);
               this.position += (long)var3;
               if(this.position - this.field1767 > (long)this.field1766) {
                  this.field1766 = (int)(this.position - this.field1767);
               }

            }
         } else {
            if(this.field1771 != this.position) {
               this.field1763.seek(this.position);
               this.field1771 = this.position;
            }

            this.field1763.write(var1, var2, var3);
            this.field1771 += (long)var3;
            if(this.field1771 > this.length) {
               this.length = this.field1771;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1761 && this.position < this.field1761 + (long)this.field1764) {
               var9 = this.position;
            } else if(this.field1761 >= this.position && this.field1761 < (long)var3 + this.position) {
               var9 = this.field1761;
            }

            if((long)var3 + this.position > this.field1761 && (long)var3 + this.position <= (long)this.field1764 + this.field1761) {
               var6 = this.position + (long)var3;
            } else if((long)this.field1764 + this.field1761 > this.position && (long)this.field1764 + this.field1761 <= this.position + (long)var3) {
               var6 = this.field1761 + (long)this.field1764;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.position), this.readPayload, (int)(var9 - this.field1761), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1771 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-45"
   )
   void method2366() throws IOException {
      this.field1764 = 0;
      if(this.position != this.field1771) {
         this.field1763.seek(this.position);
         this.field1771 = this.position;
      }

      int var1;
      for(this.field1761 = this.position; this.field1764 < this.readPayload.length; this.field1764 += var1) {
         var1 = this.field1763.read(this.readPayload, this.field1764, this.readPayload.length - this.field1764);
         if(var1 == -1) {
            break;
         }

         this.field1771 += (long)var1;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-5"
   )
   public void method2372() throws IOException {
      this.method2361();
      this.field1763.close();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2046527414"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2369(var1, 0, var1.length);
   }
}
