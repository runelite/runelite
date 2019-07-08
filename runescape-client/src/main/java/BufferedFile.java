import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("BufferedFile")
public class BufferedFile {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   @Export("accessFile")
   AccessFile accessFile;
   @ObfuscatedName("f")
   @Export("readBuffer")
   byte[] readBuffer;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -7773729680030815835L
   )
   long field47;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -846810907
   )
   int field48;
   @ObfuscatedName("o")
   @Export("writeBuffer")
   byte[] writeBuffer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 5249231081498323007L
   )
   long field49;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1558233611
   )
   int field50;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -6819476051574242871L
   )
   long field51;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -3728247331531750871L
   )
   long field52;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 2663146692618913943L
   )
   @Export("capacity")
   long capacity;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 5720856138805191881L
   )
   long field53;

   @ObfuscatedSignature(
      signature = "(Ldk;II)V"
   )
   public BufferedFile(AccessFile var1, int var2, int var3) throws IOException {
      this.field47 = -1L;
      this.field49 = -1L;
      this.field50 = 0;
      this.accessFile = var1;
      this.capacity = this.field52 = var1.length();
      this.readBuffer = new byte[var2];
      this.writeBuffer = new byte[var3];
      this.field51 = 0L;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1424469113"
   )
   @Export("close")
   public void close() throws IOException {
      this.flush();
      this.accessFile.close();
   }

   @ObfuscatedName("f")
   @Export("seek")
   public void seek(long index) throws IOException {
      if (index < 0L) {
         throw new IOException("");
      } else {
         this.field51 = index;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "0"
   )
   @Export("length")
   public long length() {
      return this.capacity;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "617965847"
   )
   @Export("readFill")
   public void readFill(byte[] dst) throws IOException {
      this.read(dst, 0, dst.length);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-35"
   )
   @Export("read")
   public void read(byte[] dst, int dstIndex, int length) throws IOException {
      try {
         if (length + dstIndex > dst.length) {
            throw new ArrayIndexOutOfBoundsException(length + dstIndex - dst.length);
         }

         if (-1L != this.field49 && this.field51 >= this.field49 && this.field51 + (long)length <= this.field49 + (long)this.field50) {
            System.arraycopy(this.writeBuffer, (int)(this.field51 - this.field49), dst, dstIndex, length);
            this.field51 += (long)length;
            return;
         }

         long var4 = this.field51;
         int var6 = length;
         int var7;
         if (this.field51 >= this.field47 && this.field51 < this.field47 + (long)this.field48) {
            var7 = (int)((long)this.field48 - (this.field51 - this.field47));
            if (var7 > length) {
               var7 = length;
            }

            System.arraycopy(this.readBuffer, (int)(this.field51 - this.field47), dst, dstIndex, var7);
            this.field51 += (long)var7;
            dstIndex += var7;
            length -= var7;
         }

         if (length > this.readBuffer.length) {
            this.accessFile.seek(this.field51);

            for (this.field53 = this.field51; length > 0; length -= var7) {
               var7 = this.accessFile.read(dst, dstIndex, length);
               if (var7 == -1) {
                  break;
               }

               this.field53 += (long)var7;
               this.field51 += (long)var7;
               dstIndex += var7;
            }
         } else if (length > 0) {
            this.load();
            var7 = length;
            if (length > this.field48) {
               var7 = this.field48;
            }

            System.arraycopy(this.readBuffer, 0, dst, dstIndex, var7);
            dstIndex += var7;
            length -= var7;
            this.field51 += (long)var7;
         }

         if (-1L != this.field49) {
            if (this.field49 > this.field51 && length > 0) {
               var7 = dstIndex + (int)(this.field49 - this.field51);
               if (var7 > length + dstIndex) {
                  var7 = length + dstIndex;
               }

               while (dstIndex < var7) {
                  dst[dstIndex++] = 0;
                  --length;
                  ++this.field51;
               }
            }

            long var8 = -1L;
            long var10 = -1L;
            if (this.field49 >= var4 && this.field49 < var4 + (long)var6) {
               var8 = this.field49;
            } else if (var4 >= this.field49 && var4 < this.field49 + (long)this.field50) {
               var8 = var4;
            }

            if ((long)this.field50 + this.field49 > var4 && this.field49 + (long)this.field50 <= var4 + (long)var6) {
               var10 = (long)this.field50 + this.field49;
            } else if ((long)var6 + var4 > this.field49 && (long)var6 + var4 <= this.field49 + (long)this.field50) {
               var10 = (long)var6 + var4;
            }

            if (var8 > -1L && var10 > var8) {
               int var12 = (int)(var10 - var8);
               System.arraycopy(this.writeBuffer, (int)(var8 - this.field49), dst, (int)(var8 - var4) + dstIndex, var12);
               if (var10 > this.field51) {
                  length = (int)((long)length - (var10 - this.field51));
                  this.field51 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field53 = -1L;
         throw var13;
      }

      if (length > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2020905321"
   )
   @Export("load")
   void load() throws IOException {
      this.field48 = 0;
      if (this.field53 != this.field51) {
         this.accessFile.seek(this.field51);
         this.field53 = this.field51;
      }

      int var1;
      for (this.field47 = this.field51; this.field48 < this.readBuffer.length; this.field48 += var1) {
         var1 = this.accessFile.read(this.readBuffer, this.field48, this.readBuffer.length - this.field48);
         if (var1 == -1) {
            break;
         }

         this.field53 += (long)var1;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-601174169"
   )
   @Export("write")
   public void write(byte[] src, int srcIndex, int length) throws IOException {
      try {
         if (this.field51 + (long)length > this.capacity) {
            this.capacity = this.field51 + (long)length;
         }

         if (-1L != this.field49 && (this.field51 < this.field49 || this.field51 > this.field49 + (long)this.field50)) {
            this.flush();
         }

         if (this.field49 != -1L && (long)length + this.field51 > this.field49 + (long)this.writeBuffer.length) {
            int var4 = (int)((long)this.writeBuffer.length - (this.field51 - this.field49));
            System.arraycopy(src, srcIndex, this.writeBuffer, (int)(this.field51 - this.field49), var4);
            this.field51 += (long)var4;
            srcIndex += var4;
            length -= var4;
            this.field50 = this.writeBuffer.length;
            this.flush();
         }

         if (length <= this.writeBuffer.length) {
            if (length > 0) {
               if (this.field49 == -1L) {
                  this.field49 = this.field51;
               }

               System.arraycopy(src, srcIndex, this.writeBuffer, (int)(this.field51 - this.field49), length);
               this.field51 += (long)length;
               if (this.field51 - this.field49 > (long)this.field50) {
                  this.field50 = (int)(this.field51 - this.field49);
               }
            }
         } else {
            if (this.field53 != this.field51) {
               this.accessFile.seek(this.field51);
               this.field53 = this.field51;
            }

            this.accessFile.write(src, srcIndex, length);
            this.field53 += (long)length;
            if (this.field53 > this.field52) {
               this.field52 = this.field53;
            }

            long var10 = -1L;
            long var6 = -1L;
            if (this.field51 >= this.field47 && this.field51 < (long)this.field48 + this.field47) {
               var10 = this.field51;
            } else if (this.field47 >= this.field51 && this.field47 < (long)length + this.field51) {
               var10 = this.field47;
            }

            if (this.field51 + (long)length > this.field47 && (long)length + this.field51 <= (long)this.field48 + this.field47) {
               var6 = this.field51 + (long)length;
            } else if ((long)this.field48 + this.field47 > this.field51 && this.field47 + (long)this.field48 <= (long)length + this.field51) {
               var6 = (long)this.field48 + this.field47;
            }

            if (var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(src, (int)(var10 + (long)srcIndex - this.field51), this.readBuffer, (int)(var10 - this.field47), var8);
            }

            this.field51 += (long)length;
         }

      } catch (IOException var9) {
         this.field53 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-931421226"
   )
   @Export("flush")
   void flush() throws IOException {
      if (this.field49 != -1L) {
         if (this.field49 != this.field53) {
            this.accessFile.seek(this.field49);
            this.field53 = this.field49;
         }

         this.accessFile.write(this.writeBuffer, 0, this.field50);
         this.field53 += (long)(this.field50 * 1290782301) * -1558233611L;
         if (this.field53 > this.field52) {
            this.field52 = this.field53;
         }

         long var1 = -1L;
         long var3 = -1L;
         if (this.field49 >= this.field47 && this.field49 < (long)this.field48 + this.field47) {
            var1 = this.field49;
         } else if (this.field47 >= this.field49 && this.field47 < this.field49 + (long)this.field50) {
            var1 = this.field47;
         }

         if (this.field49 + (long)this.field50 > this.field47 && this.field49 + (long)this.field50 <= this.field47 + (long)this.field48) {
            var3 = this.field49 + (long)this.field50;
         } else if ((long)this.field48 + this.field47 > this.field49 && (long)this.field48 + this.field47 <= (long)this.field50 + this.field49) {
            var3 = this.field47 + (long)this.field48;
         }

         if (var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writeBuffer, (int)(var1 - this.field49), this.readBuffer, (int)(var1 - this.field47), var5);
         }

         this.field49 = -1L;
         this.field50 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/net/Socket;IIB)Lfu;",
      garbageValue = "110"
   )
   public static AbstractSocket method2719(Socket var0, int var1, int var2) throws IOException {
      return new BufferedNetSocket(var0, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-792629541"
   )
   @Export("colorStartTag")
   static String colorStartTag(int color) {
      return "<col=" + Integer.toHexString(color) + ">";
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(I)Llz;",
      garbageValue = "-1653835085"
   )
   @Export("worldMap")
   static WorldMap worldMap() {
      return class60.worldMap0;
   }
}
