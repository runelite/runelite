import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dg")
@Implements("CacheFile")
public class CacheFile {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -3570013832331581231L
   )
   long field1748;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1245892039
   )
   int field1742;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 8103283104049854083L
   )
   long field1749;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 539619462515577885L
   )
   long field1751;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -4186230399938378807L
   )
   @Export("position")
   long position;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -6536828193705498661L
   )
   long field1739;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ldk;"
   )
   FileOnDisk field1741;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1032130717
   )
   int field1745;
   @ObfuscatedName("v")
   @Export("writePayload")
   byte[] writePayload;
   @ObfuscatedName("j")
   @Export("readPayload")
   byte[] readPayload;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 3415267441663217359L
   )
   @Export("length")
   long length;

   @ObfuscatedSignature(
      signature = "(Ldk;II)V"
   )
   public CacheFile(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1739 = -1L;
      this.field1751 = -1L;
      this.field1745 = 0;
      this.field1741 = var1;
      this.field1748 = this.length = var1.length();
      this.readPayload = new byte[var2];
      this.writePayload = new byte[var3];
      this.position = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-105"
   )
   void method2345() throws IOException {
      if(this.field1751 != -1L) {
         if(this.field1749 != this.field1751) {
            this.field1741.seek(this.field1751);
            this.field1749 = this.field1751;
         }

         this.field1741.write(this.writePayload, 0, this.field1745);
         this.field1749 += -1032130717L * (long)(this.field1745 * -344585653);
         if(this.field1749 > this.length) {
            this.length = this.field1749;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1751 >= this.field1739 && this.field1751 < (long)this.field1742 + this.field1739) {
            var1 = this.field1751;
         } else if(this.field1739 >= this.field1751 && this.field1739 < this.field1751 + (long)this.field1745) {
            var1 = this.field1739;
         }

         if((long)this.field1745 + this.field1751 > this.field1739 && this.field1751 + (long)this.field1745 <= (long)this.field1742 + this.field1739) {
            var3 = (long)this.field1745 + this.field1751;
         } else if(this.field1739 + (long)this.field1742 > this.field1751 && this.field1739 + (long)this.field1742 <= this.field1751 + (long)this.field1745) {
            var3 = this.field1739 + (long)this.field1742;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.writePayload, (int)(var1 - this.field1751), this.readPayload, (int)(var1 - this.field1739), var5);
         }

         this.field1751 = -1L;
         this.field1745 = 0;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1596116688"
   )
   public void method2338(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1751 != -1L && this.position >= this.field1751 && this.position + (long)var3 <= this.field1751 + (long)this.field1745) {
            System.arraycopy(this.writePayload, (int)(this.position - this.field1751), var1, var2, var3);
            this.position += (long)var3;
            return;
         }

         long var4 = this.position;
         int var7 = var3;
         int var8;
         if(this.position >= this.field1739 && this.position < (long)this.field1742 + this.field1739) {
            var8 = (int)((long)this.field1742 - (this.position - this.field1739));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.readPayload, (int)(this.position - this.field1739), var1, var2, var8);
            this.position += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.readPayload.length) {
            this.field1741.seek(this.position);

            for(this.field1749 = this.position; var3 > 0; var3 -= var8) {
               var8 = this.field1741.read(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1749 += (long)var8;
               this.position += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2333();
            var8 = var3;
            if(var3 > this.field1742) {
               var8 = this.field1742;
            }

            System.arraycopy(this.readPayload, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.position += (long)var8;
         }

         if(-1L != this.field1751) {
            if(this.field1751 > this.position && var3 > 0) {
               var8 = var2 + (int)(this.field1751 - this.position);
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
            if(this.field1751 >= var4 && this.field1751 < var4 + (long)var7) {
               var13 = this.field1751;
            } else if(var4 >= this.field1751 && var4 < (long)this.field1745 + this.field1751) {
               var13 = var4;
            }

            if((long)this.field1745 + this.field1751 > var4 && (long)this.field1745 + this.field1751 <= (long)var7 + var4) {
               var10 = (long)this.field1745 + this.field1751;
            } else if((long)var7 + var4 > this.field1751 && (long)var7 + var4 <= (long)this.field1745 + this.field1751) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.writePayload, (int)(var13 - this.field1751), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.position) {
                  var3 = (int)((long)var3 - (var10 - this.position));
                  this.position = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1749 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "937871288"
   )
   public long method2331() {
      return this.field1748;
   }

   @ObfuscatedName("j")
   @Export("seek")
   public void seek(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.position = var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-143808790"
   )
   @Export("write")
   public void write(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.position > this.field1748) {
            this.field1748 = this.position + (long)var3;
         }

         if(-1L != this.field1751 && (this.position < this.field1751 || this.position > (long)this.field1745 + this.field1751)) {
            this.method2345();
         }

         if(-1L != this.field1751 && (long)var3 + this.position > this.field1751 + (long)this.writePayload.length) {
            int var4 = (int)((long)this.writePayload.length - (this.position - this.field1751));
            System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1751), var4);
            this.position += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1745 = this.writePayload.length;
            this.method2345();
         }

         if(var3 <= this.writePayload.length) {
            if(var3 > 0) {
               if(this.field1751 == -1L) {
                  this.field1751 = this.position;
               }

               System.arraycopy(var1, var2, this.writePayload, (int)(this.position - this.field1751), var3);
               this.position += (long)var3;
               if(this.position - this.field1751 > (long)this.field1745) {
                  this.field1745 = (int)(this.position - this.field1751);
               }

            }
         } else {
            if(this.position != this.field1749) {
               this.field1741.seek(this.position);
               this.field1749 = this.position;
            }

            this.field1741.write(var1, var2, var3);
            this.field1749 += (long)var3;
            if(this.field1749 > this.length) {
               this.length = this.field1749;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.position >= this.field1739 && this.position < this.field1739 + (long)this.field1742) {
               var9 = this.position;
            } else if(this.field1739 >= this.position && this.field1739 < (long)var3 + this.position) {
               var9 = this.field1739;
            }

            if((long)var3 + this.position > this.field1739 && this.position + (long)var3 <= this.field1739 + (long)this.field1742) {
               var6 = this.position + (long)var3;
            } else if(this.field1739 + (long)this.field1742 > this.position && this.field1739 + (long)this.field1742 <= (long)var3 + this.position) {
               var6 = this.field1739 + (long)this.field1742;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.position), this.readPayload, (int)(var9 - this.field1739), var8);
            }

            this.position += (long)var3;
         }
      } catch (IOException var12) {
         this.field1749 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-113"
   )
   void method2333() throws IOException {
      this.field1742 = 0;
      if(this.field1749 != this.position) {
         this.field1741.seek(this.position);
         this.field1749 = this.position;
      }

      int var1;
      for(this.field1739 = this.position; this.field1742 < this.readPayload.length; this.field1742 += var1) {
         var1 = this.field1741.read(this.readPayload, this.field1742, this.readPayload.length - this.field1742);
         if(var1 == -1) {
            break;
         }

         this.field1749 += (long)var1;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2073950931"
   )
   public void method2329() throws IOException {
      this.method2345();
      this.field1741.close();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "14"
   )
   @Export("read")
   public void read(byte[] var1) throws IOException {
      this.method2338(var1, 0, var1.length);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1907857924"
   )
   static final void method2351(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class61.field750[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5 + 1][var4];
               }

               if(var4 == var1 && var4 > 0) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class61.tileHeights[0][var5][var4] = class61.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
