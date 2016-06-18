import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class228 {
   @ObfuscatedName("x")
   byte[] field3217;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = 686000516273211501L
   )
   long field3218 = -1L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -97669977
   )
   int field3219 = 0;
   @ObfuscatedName("g")
   byte[] field3220;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 780753941
   )
   int field3221;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 2766682133600503747L
   )
   long field3222 = -1L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -7417838913833004285L
   )
   long field3223;
   @ObfuscatedName("b")
   class227 field3224;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 1577957268646545397L
   )
   long field3225;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 5958549411275461421L
   )
   long field3226;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 2844981164138289937L
   )
   long field3227;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-7384"
   )
   void method4130() throws IOException {
      if(-1L != this.field3222) {
         if(this.field3222 != this.field3227) {
            this.field3224.method4114(this.field3222);
            this.field3227 = this.field3222;
         }

         this.field3224.method4127(this.field3217, 0, this.field3219);
         this.field3227 += (long)(this.field3219 * 611138327) * -97669977L;
         if(this.field3227 > this.field3225) {
            this.field3225 = this.field3227;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3222 >= this.field3218 && this.field3222 < this.field3218 + (long)this.field3221) {
            var1 = this.field3222;
         } else if(this.field3218 >= this.field3222 && this.field3218 < this.field3222 + (long)this.field3219) {
            var1 = this.field3218;
         }

         if((long)this.field3219 + this.field3222 > this.field3218 && (long)this.field3219 + this.field3222 <= (long)this.field3221 + this.field3218) {
            var3 = this.field3222 + (long)this.field3219;
         } else if((long)this.field3221 + this.field3218 > this.field3222 && (long)this.field3221 + this.field3218 <= this.field3222 + (long)this.field3219) {
            var3 = this.field3218 + (long)this.field3221;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3217, (int)(var1 - this.field3222), this.field3220, (int)(var1 - this.field3218), var5);
         }

         this.field3222 = -1L;
         this.field3219 = 0;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "642628573"
   )
   public void method4131() throws IOException {
      this.method4130();
      this.field3224.method4116();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "-24724"
   )
   public long method4132() {
      return this.field3223;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-474702643"
   )
   public void method4134(byte[] var1) throws IOException {
      this.method4135(var1, 0, var1.length);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-210315969"
   )
   public void method4135(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field3222 && this.field3226 >= this.field3222 && (long)var3 + this.field3226 <= this.field3222 + (long)this.field3219) {
            System.arraycopy(this.field3217, (int)(this.field3226 - this.field3222), var1, var2, var3);
            this.field3226 += (long)var3;
            return;
         }

         long var4 = this.field3226;
         int var7 = var3;
         int var8;
         if(this.field3226 >= this.field3218 && this.field3226 < this.field3218 + (long)this.field3221) {
            var8 = (int)((long)this.field3221 - (this.field3226 - this.field3218));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3220, (int)(this.field3226 - this.field3218), var1, var2, var8);
            this.field3226 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3220.length) {
            this.field3224.method4114(this.field3226);

            for(this.field3227 = this.field3226; var3 > 0; var3 -= var8) {
               var8 = this.field3224.method4118(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3227 += (long)var8;
               this.field3226 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4138();
            var8 = var3;
            if(var3 > this.field3221) {
               var8 = this.field3221;
            }

            System.arraycopy(this.field3220, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3226 += (long)var8;
         }

         if(-1L != this.field3222) {
            if(this.field3222 > this.field3226 && var3 > 0) {
               var8 = (int)(this.field3222 - this.field3226) + var2;
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3226;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3222 >= var4 && this.field3222 < var4 + (long)var7) {
               var15 = this.field3222;
            } else if(var4 >= this.field3222 && var4 < (long)this.field3219 + this.field3222) {
               var15 = var4;
            }

            if(this.field3222 + (long)this.field3219 > var4 && this.field3222 + (long)this.field3219 <= (long)var7 + var4) {
               var10 = (long)this.field3219 + this.field3222;
            } else if(var4 + (long)var7 > this.field3222 && var4 + (long)var7 <= this.field3222 + (long)this.field3219) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3217, (int)(var15 - this.field3222), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3226) {
                  var3 = (int)((long)var3 - (var10 - this.field3226));
                  this.field3226 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3227 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "58251267"
   )
   public void method4137(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3226 + (long)var3 > this.field3223) {
            this.field3223 = (long)var3 + this.field3226;
         }

         if(-1L != this.field3222 && (this.field3226 < this.field3222 || this.field3226 > (long)this.field3219 + this.field3222)) {
            this.method4130();
         }

         if(this.field3222 != -1L && this.field3226 + (long)var3 > this.field3222 + (long)this.field3217.length) {
            int var4 = (int)((long)this.field3217.length - (this.field3226 - this.field3222));
            System.arraycopy(var1, var2, this.field3217, (int)(this.field3226 - this.field3222), var4);
            this.field3226 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3219 = this.field3217.length;
            this.method4130();
         }

         if(var3 <= this.field3217.length) {
            if(var3 > 0) {
               if(-1L == this.field3222) {
                  this.field3222 = this.field3226;
               }

               System.arraycopy(var1, var2, this.field3217, (int)(this.field3226 - this.field3222), var3);
               this.field3226 += (long)var3;
               if(this.field3226 - this.field3222 > (long)this.field3219) {
                  this.field3219 = (int)(this.field3226 - this.field3222);
               }

            }
         } else {
            if(this.field3227 != this.field3226) {
               this.field3224.method4114(this.field3226);
               this.field3227 = this.field3226;
            }

            this.field3224.method4127(var1, var2, var3);
            this.field3227 += (long)var3;
            if(this.field3227 > this.field3225) {
               this.field3225 = this.field3227;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3226 >= this.field3218 && this.field3226 < (long)this.field3221 + this.field3218) {
               var11 = this.field3226;
            } else if(this.field3218 >= this.field3226 && this.field3218 < this.field3226 + (long)var3) {
               var11 = this.field3218;
            }

            if(this.field3226 + (long)var3 > this.field3218 && (long)var3 + this.field3226 <= this.field3218 + (long)this.field3221) {
               var6 = this.field3226 + (long)var3;
            } else if(this.field3218 + (long)this.field3221 > this.field3226 && this.field3218 + (long)this.field3221 <= (long)var3 + this.field3226) {
               var6 = (long)this.field3221 + this.field3218;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3226), this.field3220, (int)(var11 - this.field3218), var8);
            }

            this.field3226 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3227 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "716718603"
   )
   void method4138() throws IOException {
      this.field3221 = 0;
      if(this.field3227 != this.field3226) {
         this.field3224.method4114(this.field3226);
         this.field3227 = this.field3226;
      }

      int var1;
      for(this.field3218 = this.field3226; this.field3221 < this.field3220.length; this.field3221 += var1) {
         var1 = this.field3224.method4118(this.field3220, this.field3221, this.field3220.length - this.field3221);
         if(var1 == -1) {
            break;
         }

         this.field3227 += (long)var1;
      }

   }

   @ObfuscatedName("g")
   public void method4146(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3226 = var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "0"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3224 = var1;
      this.field3223 = this.field3225 = var1.method4113();
      this.field3220 = new byte[var2];
      this.field3217 = new byte[var3];
      this.field3226 = 0L;
   }
}
