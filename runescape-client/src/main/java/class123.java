import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class123 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 7376093749725553211L
   )
   long field1760;
   @ObfuscatedName("w")
   byte[] field1761;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1239948097
   )
   int field1762;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 5862811482911134065L
   )
   long field1763;
   @ObfuscatedName("s")
   byte[] field1764;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 399662376206831619L
   )
   long field1765;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -346472151
   )
   int field1766;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8105764437903030387L
   )
   long field1767;
   @ObfuscatedName("i")
   FileOnDisk field1768;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -3978987609542710011L
   )
   long field1769;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5197997983002785857L
   )
   long field1770;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1613876135"
   )
   public void method2333() throws IOException {
      this.method2340();
      this.field1768.method2381();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-59967697"
   )
   public long method2335() {
      return this.field1769;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "0"
   )
   public void method2336(byte[] var1) throws IOException {
      this.method2361(var1, 0, var1.length);
   }

   @ObfuscatedName("w")
   public void method2338(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1760 = var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1735528379"
   )
   public void method2339(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1760 > this.field1769) {
            this.field1769 = (long)var3 + this.field1760;
         }

         if(-1L != this.field1763 && (this.field1760 < this.field1763 || this.field1760 > (long)this.field1766 + this.field1763)) {
            this.method2340();
         }

         if(-1L != this.field1763 && (long)var3 + this.field1760 > this.field1763 + (long)this.field1764.length) {
            int var4 = (int)((long)this.field1764.length - (this.field1760 - this.field1763));
            System.arraycopy(var1, var2, this.field1764, (int)(this.field1760 - this.field1763), var4);
            this.field1760 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1766 = this.field1764.length;
            this.method2340();
         }

         if(var3 <= this.field1764.length) {
            if(var3 > 0) {
               if(this.field1763 == -1L) {
                  this.field1763 = this.field1760;
               }

               System.arraycopy(var1, var2, this.field1764, (int)(this.field1760 - this.field1763), var3);
               this.field1760 += (long)var3;
               if(this.field1760 - this.field1763 > (long)this.field1766) {
                  this.field1766 = (int)(this.field1760 - this.field1763);
               }

            }
         } else {
            if(this.field1770 != this.field1760) {
               this.field1768.method2374(this.field1760);
               this.field1770 = this.field1760;
            }

            this.field1768.method2363(var1, var2, var3);
            this.field1770 += (long)var3;
            if(this.field1770 > this.field1767) {
               this.field1767 = this.field1770;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1760 >= this.field1765 && this.field1760 < (long)this.field1762 + this.field1765) {
               var9 = this.field1760;
            } else if(this.field1765 >= this.field1760 && this.field1765 < (long)var3 + this.field1760) {
               var9 = this.field1765;
            }

            if((long)var3 + this.field1760 > this.field1765 && this.field1760 + (long)var3 <= this.field1765 + (long)this.field1762) {
               var6 = this.field1760 + (long)var3;
            } else if((long)this.field1762 + this.field1765 > this.field1760 && (long)this.field1762 + this.field1765 <= this.field1760 + (long)var3) {
               var6 = (long)this.field1762 + this.field1765;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1760), this.field1761, (int)(var9 - this.field1765), var8);
            }

            this.field1760 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1770 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "516600203"
   )
   void method2340() throws IOException {
      if(-1L != this.field1763) {
         if(this.field1763 != this.field1770) {
            this.field1768.method2374(this.field1763);
            this.field1770 = this.field1763;
         }

         this.field1768.method2363(this.field1764, 0, this.field1766);
         this.field1770 += (long)(this.field1766 * 1085860633) * -346472151L;
         if(this.field1770 > this.field1767) {
            this.field1767 = this.field1770;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1763 >= this.field1765 && this.field1763 < this.field1765 + (long)this.field1762) {
            var1 = this.field1763;
         } else if(this.field1765 >= this.field1763 && this.field1765 < this.field1763 + (long)this.field1766) {
            var1 = this.field1765;
         }

         if((long)this.field1766 + this.field1763 > this.field1765 && this.field1763 + (long)this.field1766 <= this.field1765 + (long)this.field1762) {
            var3 = this.field1763 + (long)this.field1766;
         } else if((long)this.field1762 + this.field1765 > this.field1763 && this.field1765 + (long)this.field1762 <= (long)this.field1766 + this.field1763) {
            var3 = (long)this.field1762 + this.field1765;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1764, (int)(var1 - this.field1763), this.field1761, (int)(var1 - this.field1765), var5);
         }

         this.field1763 = -1L;
         this.field1766 = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LModIcon;B)V",
      garbageValue = "3"
   )
   static final void method2346(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < GraphicsObject.field1382.length; ++var2) {
         GraphicsObject.field1382[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         GraphicsObject.field1382[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class14.field293[var5] = (GraphicsObject.field1382[var5 + 128] + GraphicsObject.field1382[var5 - 1] + GraphicsObject.field1382[1 + var5] + GraphicsObject.field1382[var5 - 128]) / 4;
            }
         }

         int[] var8 = GraphicsObject.field1382;
         GraphicsObject.field1382 = class14.field293;
         class14.field293 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + 16 + var0.offsetX;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = var5 + (var6 << 7);
                  GraphicsObject.field1382[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   void method2347() throws IOException {
      this.field1762 = 0;
      if(this.field1770 != this.field1760) {
         this.field1768.method2374(this.field1760);
         this.field1770 = this.field1760;
      }

      int var1;
      for(this.field1765 = this.field1760; this.field1762 < this.field1761.length; this.field1762 += var1) {
         var1 = this.field1768.method2367(this.field1761, this.field1762, this.field1761.length - this.field1762);
         if(var1 == -1) {
            break;
         }

         this.field1770 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class123(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1765 = -1L;
      this.field1763 = -1L;
      this.field1766 = 0;
      this.field1768 = var1;
      this.field1769 = this.field1767 = var1.method2379();
      this.field1761 = new byte[var2];
      this.field1764 = new byte[var3];
      this.field1760 = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-11"
   )
   public void method2361(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1763 && this.field1760 >= this.field1763 && (long)var3 + this.field1760 <= this.field1763 + (long)this.field1766) {
            System.arraycopy(this.field1764, (int)(this.field1760 - this.field1763), var1, var2, var3);
            this.field1760 += (long)var3;
            return;
         }

         long var4 = this.field1760;
         int var7 = var3;
         int var8;
         if(this.field1760 >= this.field1765 && this.field1760 < this.field1765 + (long)this.field1762) {
            var8 = (int)((long)this.field1762 - (this.field1760 - this.field1765));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1761, (int)(this.field1760 - this.field1765), var1, var2, var8);
            this.field1760 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1761.length) {
            this.field1768.method2374(this.field1760);

            for(this.field1770 = this.field1760; var3 > 0; var3 -= var8) {
               var8 = this.field1768.method2367(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1770 += (long)var8;
               this.field1760 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2347();
            var8 = var3;
            if(var3 > this.field1762) {
               var8 = this.field1762;
            }

            System.arraycopy(this.field1761, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1760 += (long)var8;
         }

         if(this.field1763 != -1L) {
            if(this.field1763 > this.field1760 && var3 > 0) {
               var8 = (int)(this.field1763 - this.field1760) + var2;
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1760;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1763 >= var4 && this.field1763 < (long)var7 + var4) {
               var13 = this.field1763;
            } else if(var4 >= this.field1763 && var4 < this.field1763 + (long)this.field1766) {
               var13 = var4;
            }

            if(this.field1763 + (long)this.field1766 > var4 && this.field1763 + (long)this.field1766 <= (long)var7 + var4) {
               var10 = (long)this.field1766 + this.field1763;
            } else if(var4 + (long)var7 > this.field1763 && (long)var7 + var4 <= (long)this.field1766 + this.field1763) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1764, (int)(var13 - this.field1763), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.field1760) {
                  var3 = (int)((long)var3 - (var10 - this.field1760));
                  this.field1760 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1770 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }
}
