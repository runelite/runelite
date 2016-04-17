import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hn")
public class class228 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1873287341
   )
   int field3221 = 0;
   @ObfuscatedName("w")
   byte[] field3222;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -81179750367190875L
   )
   long field3223 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1926690935
   )
   int field3224;
   @ObfuscatedName("y")
   byte[] field3225;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 9164460083696772013L
   )
   long field3226 = -1L;
   @ObfuscatedName("a")
   class227 field3227;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -5314015476944922313L
   )
   long field3228;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 3661599768449357477L
   )
   long field3229;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -1546539734518756603L
   )
   long field3230;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -4691632461063870233L
   )
   long field3231;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "123"
   )
   void method4221() throws IOException {
      this.field3224 = 0;
      if(this.field3231 != this.field3228) {
         this.field3227.method4219(this.field3231);
         this.field3228 = this.field3231;
      }

      int var1;
      for(this.field3223 = this.field3231; this.field3224 < this.field3222.length; this.field3224 += var1) {
         var1 = this.field3227.method4205(this.field3222, this.field3224, this.field3222.length - this.field3224);
         if(var1 == -1) {
            break;
         }

         this.field3228 += (long)var1;
      }

   }

   @ObfuscatedName("w")
   public void method4222(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3231 = var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-21"
   )
   public void method4224(byte[] var1) throws IOException {
      this.method4244(var1, 0, var1.length);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "145120423"
   )
   public void method4225() throws IOException {
      this.method4228();
      this.field3227.method4202();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1369636931"
   )
   public long method4226() {
      return this.field3230;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-91"
   )
   public void method4227(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3231 > this.field3230) {
            this.field3230 = this.field3231 + (long)var3;
         }

         if(-1L != this.field3226 && (this.field3231 < this.field3226 || this.field3231 > this.field3226 + (long)this.field3221)) {
            this.method4228();
         }

         if(-1L != this.field3226 && this.field3231 + (long)var3 > (long)this.field3225.length + this.field3226) {
            int var4 = (int)((long)this.field3225.length - (this.field3231 - this.field3226));
            System.arraycopy(var1, var2, this.field3225, (int)(this.field3231 - this.field3226), var4);
            this.field3231 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3221 = this.field3225.length;
            this.method4228();
         }

         if(var3 <= this.field3225.length) {
            if(var3 > 0) {
               if(-1L == this.field3226) {
                  this.field3226 = this.field3231;
               }

               System.arraycopy(var1, var2, this.field3225, (int)(this.field3231 - this.field3226), var3);
               this.field3231 += (long)var3;
               if(this.field3231 - this.field3226 > (long)this.field3221) {
                  this.field3221 = (int)(this.field3231 - this.field3226);
               }

            }
         } else {
            if(this.field3228 != this.field3231) {
               this.field3227.method4219(this.field3231);
               this.field3228 = this.field3231;
            }

            this.field3227.method4201(var1, var2, var3);
            this.field3228 += (long)var3;
            if(this.field3228 > this.field3229) {
               this.field3229 = this.field3228;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3231 >= this.field3223 && this.field3231 < (long)this.field3224 + this.field3223) {
               var10 = this.field3231;
            } else if(this.field3223 >= this.field3231 && this.field3223 < this.field3231 + (long)var3) {
               var10 = this.field3223;
            }

            if(this.field3231 + (long)var3 > this.field3223 && (long)var3 + this.field3231 <= this.field3223 + (long)this.field3224) {
               var6 = this.field3231 + (long)var3;
            } else if((long)this.field3224 + this.field3223 > this.field3231 && this.field3223 + (long)this.field3224 <= this.field3231 + (long)var3) {
               var6 = (long)this.field3224 + this.field3223;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3231), this.field3222, (int)(var10 - this.field3223), var8);
            }

            this.field3231 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3228 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "90"
   )
   void method4228() throws IOException {
      if(-1L != this.field3226) {
         if(this.field3226 != this.field3228) {
            this.field3227.method4219(this.field3226);
            this.field3228 = this.field3226;
         }

         this.field3227.method4201(this.field3225, 0, this.field3221);
         this.field3228 += (long)(this.field3221 * -1109849307) * 1873287341L;
         if(this.field3228 > this.field3229) {
            this.field3229 = this.field3228;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3226 >= this.field3223 && this.field3226 < this.field3223 + (long)this.field3224) {
            var1 = this.field3226;
         } else if(this.field3223 >= this.field3226 && this.field3223 < this.field3226 + (long)this.field3221) {
            var1 = this.field3223;
         }

         if((long)this.field3221 + this.field3226 > this.field3223 && (long)this.field3221 + this.field3226 <= (long)this.field3224 + this.field3223) {
            var3 = (long)this.field3221 + this.field3226;
         } else if((long)this.field3224 + this.field3223 > this.field3226 && this.field3223 + (long)this.field3224 <= (long)this.field3221 + this.field3226) {
            var3 = this.field3223 + (long)this.field3224;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3225, (int)(var1 - this.field3226), this.field3222, (int)(var1 - this.field3223), var5);
         }

         this.field3226 = -1L;
         this.field3221 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "24"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3227 = var1;
      this.field3230 = this.field3229 = var1.method4203();
      this.field3222 = new byte[var2];
      this.field3225 = new byte[var3];
      this.field3231 = 0L;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "335003081"
   )
   public void method4244(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field3226 && this.field3231 >= this.field3226 && this.field3231 + (long)var3 <= this.field3226 + (long)this.field3221) {
            System.arraycopy(this.field3225, (int)(this.field3231 - this.field3226), var1, var2, var3);
            this.field3231 += (long)var3;
            return;
         }

         long var4 = this.field3231;
         int var7 = var3;
         int var8;
         if(this.field3231 >= this.field3223 && this.field3231 < this.field3223 + (long)this.field3224) {
            var8 = (int)((long)this.field3224 - (this.field3231 - this.field3223));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3222, (int)(this.field3231 - this.field3223), var1, var2, var8);
            this.field3231 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3222.length) {
            this.field3227.method4219(this.field3231);

            for(this.field3228 = this.field3231; var3 > 0; var3 -= var8) {
               var8 = this.field3227.method4205(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3228 += (long)var8;
               this.field3231 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4221();
            var8 = var3;
            if(var3 > this.field3224) {
               var8 = this.field3224;
            }

            System.arraycopy(this.field3222, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3231 += (long)var8;
         }

         if(-1L != this.field3226) {
            if(this.field3226 > this.field3231 && var3 > 0) {
               var8 = var2 + (int)(this.field3226 - this.field3231);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3231;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3226 >= var4 && this.field3226 < var4 + (long)var7) {
               var14 = this.field3226;
            } else if(var4 >= this.field3226 && var4 < this.field3226 + (long)this.field3221) {
               var14 = var4;
            }

            if(this.field3226 + (long)this.field3221 > var4 && (long)this.field3221 + this.field3226 <= var4 + (long)var7) {
               var10 = (long)this.field3221 + this.field3226;
            } else if((long)var7 + var4 > this.field3226 && (long)var7 + var4 <= (long)this.field3221 + this.field3226) {
               var10 = (long)var7 + var4;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3225, (int)(var14 - this.field3226), var1, (int)(var14 - var4) + var2, var12);
               if(var10 > this.field3231) {
                  var3 = (int)((long)var3 - (var10 - this.field3231));
                  this.field3231 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field3228 = -1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }
}
