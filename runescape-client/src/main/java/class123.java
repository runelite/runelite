import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class123 {
   @ObfuscatedName("i")
   FileOnDisk field1768;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 6949062048130023273L
   )
   long field1769;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -8294860196874617481L
   )
   long field1770;
   @ObfuscatedName("b")
   byte[] field1771;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -9114560677679904439L
   )
   long field1772;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1957434279
   )
   int field1773;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -4214202783838910033L
   )
   long field1774;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -2161467901031017993L
   )
   long field1775;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -4387812780738210057L
   )
   long field1776;
   @ObfuscatedName("c")
   byte[] field1777;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1576470587
   )
   int field1778;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "4"
   )
   public void method2315() throws IOException {
      this.method2322();
      this.field1768.method2348();
   }

   @ObfuscatedName("c")
   public void method2316(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1774 = var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1638058149"
   )
   public long method2317() {
      return this.field1776;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "-19686"
   )
   public void method2318(byte[] var1) throws IOException {
      this.method2329(var1, 0, var1.length);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1901578477"
   )
   public void method2321(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1774 > this.field1776) {
            this.field1776 = this.field1774 + (long)var3;
         }

         if(-1L != this.field1772 && (this.field1774 < this.field1772 || this.field1774 > (long)this.field1773 + this.field1772)) {
            this.method2322();
         }

         if(this.field1772 != -1L && (long)var3 + this.field1774 > this.field1772 + (long)this.field1771.length) {
            int var4 = (int)((long)this.field1771.length - (this.field1774 - this.field1772));
            System.arraycopy(var1, var2, this.field1771, (int)(this.field1774 - this.field1772), var4);
            this.field1774 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1773 = this.field1771.length;
            this.method2322();
         }

         if(var3 <= this.field1771.length) {
            if(var3 > 0) {
               if(-1L == this.field1772) {
                  this.field1772 = this.field1774;
               }

               System.arraycopy(var1, var2, this.field1771, (int)(this.field1774 - this.field1772), var3);
               this.field1774 += (long)var3;
               if(this.field1774 - this.field1772 > (long)this.field1773) {
                  this.field1773 = (int)(this.field1774 - this.field1772);
               }

            }
         } else {
            if(this.field1774 != this.field1770) {
               this.field1768.method2360(this.field1774);
               this.field1770 = this.field1774;
            }

            this.field1768.method2364(var1, var2, var3);
            this.field1770 += (long)var3;
            if(this.field1770 > this.field1775) {
               this.field1775 = this.field1770;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1774 >= this.field1769 && this.field1774 < (long)this.field1778 + this.field1769) {
               var9 = this.field1774;
            } else if(this.field1769 >= this.field1774 && this.field1769 < (long)var3 + this.field1774) {
               var9 = this.field1769;
            }

            if(this.field1774 + (long)var3 > this.field1769 && this.field1774 + (long)var3 <= this.field1769 + (long)this.field1778) {
               var6 = (long)var3 + this.field1774;
            } else if(this.field1769 + (long)this.field1778 > this.field1774 && this.field1769 + (long)this.field1778 <= (long)var3 + this.field1774) {
               var6 = this.field1769 + (long)this.field1778;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.field1774), this.field1777, (int)(var9 - this.field1769), var8);
            }

            this.field1774 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1770 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "13647675"
   )
   void method2322() throws IOException {
      if(-1L != this.field1772) {
         if(this.field1770 != this.field1772) {
            this.field1768.method2360(this.field1772);
            this.field1770 = this.field1772;
         }

         this.field1768.method2364(this.field1771, 0, this.field1773);
         this.field1770 += 1957434279L * (long)(this.field1773 * 1004233751);
         if(this.field1770 > this.field1775) {
            this.field1775 = this.field1770;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1772 >= this.field1769 && this.field1772 < this.field1769 + (long)this.field1778) {
            var1 = this.field1772;
         } else if(this.field1769 >= this.field1772 && this.field1769 < this.field1772 + (long)this.field1773) {
            var1 = this.field1769;
         }

         if(this.field1772 + (long)this.field1773 > this.field1769 && (long)this.field1773 + this.field1772 <= (long)this.field1778 + this.field1769) {
            var3 = (long)this.field1773 + this.field1772;
         } else if((long)this.field1778 + this.field1769 > this.field1772 && this.field1769 + (long)this.field1778 <= this.field1772 + (long)this.field1773) {
            var3 = (long)this.field1778 + this.field1769;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1771, (int)(var1 - this.field1772), this.field1777, (int)(var1 - this.field1769), var5);
         }

         this.field1772 = -1L;
         this.field1773 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "504000845"
   )
   public void method2329(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field1772 != -1L && this.field1774 >= this.field1772 && (long)var3 + this.field1774 <= (long)this.field1773 + this.field1772) {
            System.arraycopy(this.field1771, (int)(this.field1774 - this.field1772), var1, var2, var3);
            this.field1774 += (long)var3;
            return;
         }

         long var4 = this.field1774;
         int var7 = var3;
         int var8;
         if(this.field1774 >= this.field1769 && this.field1774 < this.field1769 + (long)this.field1778) {
            var8 = (int)((long)this.field1778 - (this.field1774 - this.field1769));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1777, (int)(this.field1774 - this.field1769), var1, var2, var8);
            this.field1774 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1777.length) {
            this.field1768.method2360(this.field1774);

            for(this.field1770 = this.field1774; var3 > 0; var3 -= var8) {
               var8 = this.field1768.method2343(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1770 += (long)var8;
               this.field1774 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method2334();
            var8 = var3;
            if(var3 > this.field1778) {
               var8 = this.field1778;
            }

            System.arraycopy(this.field1777, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1774 += (long)var8;
         }

         if(-1L != this.field1772) {
            if(this.field1772 > this.field1774 && var3 > 0) {
               var8 = var2 + (int)(this.field1772 - this.field1774);
               if(var8 > var3 + var2) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1774;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1772 >= var4 && this.field1772 < (long)var7 + var4) {
               var13 = this.field1772;
            } else if(var4 >= this.field1772 && var4 < (long)this.field1773 + this.field1772) {
               var13 = var4;
            }

            if(this.field1772 + (long)this.field1773 > var4 && (long)this.field1773 + this.field1772 <= (long)var7 + var4) {
               var10 = (long)this.field1773 + this.field1772;
            } else if((long)var7 + var4 > this.field1772 && (long)var7 + var4 <= (long)this.field1773 + this.field1772) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1771, (int)(var13 - this.field1772), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1774) {
                  var3 = (int)((long)var3 - (var10 - this.field1774));
                  this.field1774 = var10;
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

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class123(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1769 = -1L;
      this.field1772 = -1L;
      this.field1773 = 0;
      this.field1768 = var1;
      this.field1776 = this.field1775 = var1.method2344();
      this.field1777 = new byte[var2];
      this.field1771 = new byte[var3];
      this.field1774 = 0L;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method2334() throws IOException {
      this.field1778 = 0;
      if(this.field1770 != this.field1774) {
         this.field1768.method2360(this.field1774);
         this.field1770 = this.field1774;
      }

      int var1;
      for(this.field1769 = this.field1774; this.field1778 < this.field1777.length; this.field1778 += var1) {
         var1 = this.field1768.method2343(this.field1777, this.field1778, this.field1777.length - this.field1778);
         if(var1 == -1) {
            break;
         }

         this.field1770 += (long)var1;
      }

   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "-498052668"
   )
   static final void method2338(int var0, int var1, int var2, int var3, int var4) {
      GroundObject.field1883[0].method5017(var0, var1);
      GroundObject.field1883[1].method5017(var0, var1 + var3 - 16);
      Rasterizer2D.method4923(var0, var1 + 16, 16, var3 - 32, Client.field1007);
      int var5 = var3 * (var3 - 32) / var4;
      if(var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.method4923(var0, var1 + 16 + var6, 16, var5, Client.field1103);
      Rasterizer2D.method4944(var0, var6 + var1 + 16, var5, Client.field993);
      Rasterizer2D.method4944(var0 + 1, var1 + 16 + var6, var5, Client.field993);
      Rasterizer2D.method4982(var0, var6 + var1 + 16, 16, Client.field993);
      Rasterizer2D.method4982(var0, var6 + var1 + 17, 16, Client.field993);
      Rasterizer2D.method4944(var0 + 15, var1 + 16 + var6, var5, Client.field1009);
      Rasterizer2D.method4944(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field1009);
      Rasterizer2D.method4982(var0, var1 + 15 + var6 + var5, 16, Client.field1009);
      Rasterizer2D.method4982(var0 + 1, var6 + var1 + 14 + var5, 15, Client.field1009);
   }
}
