import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("im")
   @ObfuscatedGetter(
      intValue = -348503395
   )
   @Export("menuX")
   static int menuX;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ldj;"
   )
   FileOnDisk field1671;
   @ObfuscatedName("p")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2673654514456511897L
   )
   long field1682;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1886034383
   )
   int field1672;
   @ObfuscatedName("v")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7789910294705908297L
   )
   long field1673;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1098434249
   )
   int field1674;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 307273387231398613L
   )
   @Export("position")
   long position;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -2230272936277235307L
   )
   @Export("length")
   long length;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 647538175209417333L
   )
   long field1668;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -6921223581891257695L
   )
   long field1678;

   @ObfuscatedSignature(
      signature = "(Ldj;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1682 = -1L;
      this.field1673 = -1L;
      this.field1674 = 0;
      this.field1671 = var1;
      this.field1668 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "2781"
   )
   public void method2452() throws IOException {
      this.method2447();
      this.field1671.close();
   }

   @ObfuscatedName("p")
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
      garbageValue = "-2023521078"
   )
   public long method2443() {
      return this.field1668;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1944932766"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2448(var1, 0, var1.length);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "39"
   )
   public void method2448(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1673 && this.position >= this.field1673 && (long)var3 + this.position <= this.field1673 + (long)this.field1674) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1673), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1682 && this.position < this.field1682 + (long)this.field1672) {
            var8 = (int)((long)this.field1672 - (this.position - this.field1682));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1682), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1671.seek(this.position);

            for(this.field1678 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1671.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1678 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2446();
            var8 = var3;
            if(var3 > this.field1672) {
               var8 = this.field1672;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(this.field1673 != -1L) {
            if(this.field1673 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1673 - this.position);
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
            if(this.field1673 >= var4 && this.field1673 < var4 + (long)var7) {
               var13 = this.field1673;
            } else if(var4 >= this.field1673 && var4 < (long)this.field1674 + this.field1673) {
               var13 = var4;
            }

            if(this.field1673 + (long)this.field1674 > var4 && this.field1673 + (long)this.field1674 <= (long)var7 + var4) {
               var10 = (long)this.field1674 + this.field1673;
            } else if(var4 + (long)var7 > this.field1673 && var4 + (long)var7 <= this.field1673 + (long)this.field1674) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1673), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1678 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2022048117"
   )
   void method2446() throws IOException {
      this.field1672 = 0;
      if(this.field1678 != this.position) {
         this.field1671.seek(this.position);
         this.field1678 = this.position;
      }

      int var1;
      for(this.field1682 = this.position; this.field1672 < this.readPayload.length; this.field1672 += var1) {
         var1 = this.field1671.read(this.readPayload, this.field1672, this.readPayload.length - this.field1672);
         if(var1 == -1) {
            break;
         }

         this.field1678 += (long)var1;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-833591143"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1668) {
            this.field1668 = this.position + (long)var3;
         }

         if(this.field1673 != -1L && (this.position < this.field1673 || this.position > this.field1673 + (long)this.field1674)) {
            this.method2447();
         }

         if(this.field1673 != -1L && this.position + (long)var3 > (long)this.writePayload.length + this.field1673) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1673));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1673), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1674 = this.writePayload.length;
            this.method2447();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(-1L == this.field1673) {
                  this.field1673 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1673), var3);
               this.position += (long)var3;
               if(this.position - this.field1673 > (long)this.field1674) {
                  this.field1674 = (int)(this.position - this.field1673);
               }

            }
         } else {
            if(this.position != this.field1678) {
               this.field1671.seek(this.position);
               this.field1678 = this.position;
            }

            this.field1671.write(var1, var2, var3);
            this.field1678 += (long)var3;
            if(this.field1678 > this.length) {
               this.length = this.field1678;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1682 && this.position < this.field1682 + (long)this.field1672) {
               var9 = this.position;
            } else if(this.field1682 >= this.position && this.field1682 < this.position + (long)var3) {
               var9 = this.field1682;
            }

            if(this.position + (long)var3 > this.field1682 && this.position + (long)var3 <= this.field1682 + (long)this.field1672) {
               var6 = (long)var3 + this.position;
            } else if((long)this.field1672 + this.field1682 > this.position && this.field1682 + (long)this.field1672 <= this.position + (long)var3) {
               var6 = this.field1682 + (long)this.field1672;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1682), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1678 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2035273083"
   )
   void method2447() throws IOException {
      if(this.field1673 != -1L) {
         if(this.field1673 != this.field1678) {
            this.field1671.seek(this.field1673);
            this.field1678 = this.field1673;
         }

         this.field1671.write(this.writePayload, 0, this.field1674);
         this.field1678 += (long)(this.field1674 * -600847225) * -1098434249L;
         if(this.field1678 > this.length) {
            this.length = this.field1678;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1673 >= this.field1682 && this.field1673 < (long)this.field1672 + this.field1682) {
            var1 = this.field1673;
         } else if(this.field1682 >= this.field1673 && this.field1682 < (long)this.field1674 + this.field1673) {
            var1 = this.field1682;
         }

         if(this.field1673 + (long)this.field1674 > this.field1682 && (long)this.field1674 + this.field1673 <= this.field1682 + (long)this.field1672) {
            var3 = this.field1673 + (long)this.field1674;
         } else if((long)this.field1672 + this.field1682 > this.field1673 && (long)this.field1672 + this.field1682 <= (long)this.field1674 + this.field1673) {
            var3 = this.field1682 + (long)this.field1672;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1673), this.readPayload, (int)(var1 - this.field1682), var5);
         }

         this.field1673 = -1L;
         this.field1674 = 0;
      }

   }
}
