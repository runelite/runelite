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
   @Export("__q")
   long __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -846810907
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @Export("writeBuffer")
   byte[] writeBuffer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 5249231081498323007L
   )
   @Export("__u")
   long __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1558233611
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -6819476051574242871L
   )
   @Export("__l")
   long __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -3728247331531750871L
   )
   @Export("__e")
   long __e;
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
   @Export("__d")
   long __d;

   @ObfuscatedSignature(
      signature = "(Ldk;II)V"
   )
   public BufferedFile(AccessFile var1, int var2, int var3) throws IOException {
      this.__q = -1L;
      this.__u = -1L;
      this.__g = 0;
      this.accessFile = var1;
      this.capacity = this.__e = var1.length();
      this.readBuffer = new byte[var2];
      this.writeBuffer = new byte[var3];
      this.__l = 0L;
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
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.__l = var1;
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
   public void readFill(byte[] var1) throws IOException {
      this.read(var1, 0, var1.length);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-35"
   )
   @Export("read")
   public void read(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.__u && this.__l >= this.__u && this.__l + (long)var3 <= this.__u + (long)this.__g) {
            System.arraycopy(this.writeBuffer, (int)(this.__l - this.__u), var1, var2, var3);
            this.__l += (long)var3;
            return;
         }

         long var4 = this.__l;
         int var6 = var3;
         int var7;
         if(this.__l >= this.__q && this.__l < this.__q + (long)this.__w) {
            var7 = (int)((long)this.__w - (this.__l - this.__q));
            if(var7 > var3) {
               var7 = var3;
            }

            System.arraycopy(this.readBuffer, (int)(this.__l - this.__q), var1, var2, var7);
            this.__l += (long)var7;
            var2 += var7;
            var3 -= var7;
         }

         if(var3 > this.readBuffer.length) {
            this.accessFile.seek(this.__l);

            for(this.__d = this.__l; var3 > 0; var3 -= var7) {
               var7 = this.accessFile.read(var1, var2, var3);
               if(var7 == -1) {
                  break;
               }

               this.__d += (long)var7;
               this.__l += (long)var7;
               var2 += var7;
            }
         } else if(var3 > 0) {
            this.load();
            var7 = var3;
            if(var3 > this.__w) {
               var7 = this.__w;
            }

            System.arraycopy(this.readBuffer, 0, var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.__l += (long)var7;
         }

         if(-1L != this.__u) {
            if(this.__u > this.__l && var3 > 0) {
               var7 = var2 + (int)(this.__u - this.__l);
               if(var7 > var3 + var2) {
                  var7 = var3 + var2;
               }

               while(var2 < var7) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.__l;
               }
            }

            long var8 = -1L;
            long var10 = -1L;
            if(this.__u >= var4 && this.__u < var4 + (long)var6) {
               var8 = this.__u;
            } else if(var4 >= this.__u && var4 < this.__u + (long)this.__g) {
               var8 = var4;
            }

            if((long)this.__g + this.__u > var4 && this.__u + (long)this.__g <= var4 + (long)var6) {
               var10 = (long)this.__g + this.__u;
            } else if((long)var6 + var4 > this.__u && (long)var6 + var4 <= this.__u + (long)this.__g) {
               var10 = (long)var6 + var4;
            }

            if(var8 > -1L && var10 > var8) {
               int var12 = (int)(var10 - var8);
               System.arraycopy(this.writeBuffer, (int)(var8 - this.__u), var1, (int)(var8 - var4) + var2, var12);
               if(var10 > this.__l) {
                  var3 = (int)((long)var3 - (var10 - this.__l));
                  this.__l = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.__d = -1L;
         throw var13;
      }

      if(var3 > 0) {
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
      this.__w = 0;
      if(this.__d != this.__l) {
         this.accessFile.seek(this.__l);
         this.__d = this.__l;
      }

      int var1;
      for(this.__q = this.__l; this.__w < this.readBuffer.length; this.__w += var1) {
         var1 = this.accessFile.read(this.readBuffer, this.__w, this.readBuffer.length - this.__w);
         if(var1 == -1) {
            break;
         }

         this.__d += (long)var1;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-601174169"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.__l + (long)var3 > this.capacity) {
            this.capacity = this.__l + (long)var3;
         }

         if(-1L != this.__u && (this.__l < this.__u || this.__l > this.__u + (long)this.__g)) {
            this.flush();
         }

         if(this.__u != -1L && (long)var3 + this.__l > this.__u + (long)this.writeBuffer.length) {
            int var4 = (int)((long)this.writeBuffer.length - (this.__l - this.__u));
            System.arraycopy(var1, var2, this.writeBuffer, (int)(this.__l - this.__u), var4);
            this.__l += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.__g = this.writeBuffer.length;
            this.flush();
         }

         if(var3 <= this.writeBuffer.length) {
            if(var3 > 0) {
               if(this.__u == -1L) {
                  this.__u = this.__l;
               }

               System.arraycopy(var1, var2, this.writeBuffer, (int)(this.__l - this.__u), var3);
               this.__l += (long)var3;
               if(this.__l - this.__u > (long)this.__g) {
                  this.__g = (int)(this.__l - this.__u);
               }
            }
         } else {
            if(this.__d != this.__l) {
               this.accessFile.seek(this.__l);
               this.__d = this.__l;
            }

            this.accessFile.write(var1, var2, var3);
            this.__d += (long)var3;
            if(this.__d > this.__e) {
               this.__e = this.__d;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.__l >= this.__q && this.__l < (long)this.__w + this.__q) {
               var10 = this.__l;
            } else if(this.__q >= this.__l && this.__q < (long)var3 + this.__l) {
               var10 = this.__q;
            }

            if(this.__l + (long)var3 > this.__q && (long)var3 + this.__l <= (long)this.__w + this.__q) {
               var6 = this.__l + (long)var3;
            } else if((long)this.__w + this.__q > this.__l && this.__q + (long)this.__w <= (long)var3 + this.__l) {
               var6 = (long)this.__w + this.__q;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)(var10 + (long)var2 - this.__l), this.readBuffer, (int)(var10 - this.__q), var8);
            }

            this.__l += (long)var3;
         }

      } catch (IOException var9) {
         this.__d = -1L;
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
      if(this.__u != -1L) {
         if(this.__u != this.__d) {
            this.accessFile.seek(this.__u);
            this.__d = this.__u;
         }

         this.accessFile.write(this.writeBuffer, 0, this.__g);
         this.__d += (long)(this.__g * 1290782301) * -1558233611L;
         if(this.__d > this.__e) {
            this.__e = this.__d;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.__u >= this.__q && this.__u < (long)this.__w + this.__q) {
            var1 = this.__u;
         } else if(this.__q >= this.__u && this.__q < this.__u + (long)this.__g) {
            var1 = this.__q;
         }

         if(this.__u + (long)this.__g > this.__q && this.__u + (long)this.__g <= this.__q + (long)this.__w) {
            var3 = this.__u + (long)this.__g;
         } else if((long)this.__w + this.__q > this.__u && (long)this.__w + this.__q <= (long)this.__g + this.__u) {
            var3 = this.__q + (long)this.__w;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writeBuffer, (int)(var1 - this.__u), this.readBuffer, (int)(var1 - this.__q), var5);
         }

         this.__u = -1L;
         this.__g = 0;
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
   static String colorStartTag(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
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
