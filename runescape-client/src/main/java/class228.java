import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public class class228 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 3712613059194391781L
   )
   long field3218;
   @ObfuscatedName("j")
   byte[] field3219;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4912434101388804413L
   )
   long field3220 = -1L;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1998630679
   )
   int field3221;
   @ObfuscatedName("d")
   byte[] field3222;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 8893637431354526553L
   )
   long field3223 = -1L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -832864089
   )
   int field3224 = 0;
   @ObfuscatedName("s")
   class227 field3225;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 8800871271611801729L
   )
   long field3227;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -3372290605365715599L
   )
   long field3228;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -1815949375018906565L
   )
   long field3229;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1121596007"
   )
   public long method4126() {
      return this.field3218;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "112"
   )
   public void method4127() throws IOException {
      this.method4133();
      this.field3225.method4121();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-22"
   )
   public void method4128(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3227 + (long)var3 > this.field3218) {
            this.field3218 = (long)var3 + this.field3227;
         }

         if(this.field3223 != -1L && (this.field3227 < this.field3223 || this.field3227 > (long)this.field3224 + this.field3223)) {
            this.method4133();
         }

         if(this.field3223 != -1L && (long)var3 + this.field3227 > (long)this.field3222.length + this.field3223) {
            int var4 = (int)((long)this.field3222.length - (this.field3227 - this.field3223));
            System.arraycopy(var1, var2, this.field3222, (int)(this.field3227 - this.field3223), var4);
            this.field3227 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3224 = this.field3222.length;
            this.method4133();
         }

         if(var3 <= this.field3222.length) {
            if(var3 > 0) {
               if(-1L == this.field3223) {
                  this.field3223 = this.field3227;
               }

               System.arraycopy(var1, var2, this.field3222, (int)(this.field3227 - this.field3223), var3);
               this.field3227 += (long)var3;
               if(this.field3227 - this.field3223 > (long)this.field3224) {
                  this.field3224 = (int)(this.field3227 - this.field3223);
               }
            }
         } else {
            if(this.field3228 != this.field3227) {
               this.field3225.method4105(this.field3227);
               this.field3228 = this.field3227;
            }

            this.field3225.method4106(var1, var2, var3);
            this.field3228 += (long)var3;
            if(this.field3228 > this.field3229) {
               this.field3229 = this.field3228;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3227 >= this.field3220 && this.field3227 < this.field3220 + (long)this.field3221) {
               var10 = this.field3227;
            } else if(this.field3220 >= this.field3227 && this.field3220 < this.field3227 + (long)var3) {
               var10 = this.field3220;
            }

            if((long)var3 + this.field3227 > this.field3220 && (long)var3 + this.field3227 <= (long)this.field3221 + this.field3220) {
               var6 = (long)var3 + this.field3227;
            } else if(this.field3220 + (long)this.field3221 > this.field3227 && (long)this.field3221 + this.field3220 <= (long)var3 + this.field3227) {
               var6 = (long)this.field3221 + this.field3220;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3227), this.field3219, (int)(var10 - this.field3220), var8);
            }

            this.field3227 += (long)var3;
         }

      } catch (IOException var9) {
         this.field3228 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-580724150"
   )
   public void method4130(byte[] var1) throws IOException {
      this.method4131(var1, 0, var1.length);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "29"
   )
   public void method4131(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field3223 != -1L && this.field3227 >= this.field3223 && this.field3227 + (long)var3 <= (long)this.field3224 + this.field3223) {
            System.arraycopy(this.field3222, (int)(this.field3227 - this.field3223), var1, var2, var3);
            this.field3227 += (long)var3;
            return;
         }

         long var4 = this.field3227;
         int var6 = var3;
         int var7;
         if(this.field3227 >= this.field3220 && this.field3227 < this.field3220 + (long)this.field3221) {
            var7 = (int)((long)this.field3221 - (this.field3227 - this.field3220));
            if(var7 > var3) {
               var7 = var3;
            }

            System.arraycopy(this.field3219, (int)(this.field3227 - this.field3220), var1, var2, var7);
            this.field3227 += (long)var7;
            var2 += var7;
            var3 -= var7;
         }

         if(var3 > this.field3219.length) {
            this.field3225.method4105(this.field3227);

            for(this.field3228 = this.field3227; var3 > 0; var3 -= var7) {
               var7 = this.field3225.method4119(var1, var2, var3);
               if(-1 == var7) {
                  break;
               }

               this.field3228 += (long)var7;
               this.field3227 += (long)var7;
               var2 += var7;
            }
         } else if(var3 > 0) {
            this.method4132();
            var7 = var3;
            if(var3 > this.field3221) {
               var7 = this.field3221;
            }

            System.arraycopy(this.field3219, 0, var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.field3227 += (long)var7;
         }

         if(-1L != this.field3223) {
            if(this.field3223 > this.field3227 && var3 > 0) {
               var7 = var2 + (int)(this.field3223 - this.field3227);
               if(var7 > var3 + var2) {
                  var7 = var2 + var3;
               }

               while(var2 < var7) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3227;
               }
            }

            long var8 = -1L;
            long var10 = -1L;
            if(this.field3223 >= var4 && this.field3223 < var4 + (long)var6) {
               var8 = this.field3223;
            } else if(var4 >= this.field3223 && var4 < this.field3223 + (long)this.field3224) {
               var8 = var4;
            }

            if((long)this.field3224 + this.field3223 > var4 && (long)this.field3224 + this.field3223 <= var4 + (long)var6) {
               var10 = (long)this.field3224 + this.field3223;
            } else if((long)var6 + var4 > this.field3223 && (long)var6 + var4 <= (long)this.field3224 + this.field3223) {
               var10 = (long)var6 + var4;
            }

            if(var8 > -1L && var10 > var8) {
               int var12 = (int)(var10 - var8);
               System.arraycopy(this.field3222, (int)(var8 - this.field3223), var1, var2 + (int)(var8 - var4), var12);
               if(var10 > this.field3227) {
                  var3 = (int)((long)var3 - (var10 - this.field3227));
                  this.field3227 = var10;
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "92"
   )
   void method4132() throws IOException {
      this.field3221 = 0;
      if(this.field3227 != this.field3228) {
         this.field3225.method4105(this.field3227);
         this.field3228 = this.field3227;
      }

      int var1;
      for(this.field3220 = this.field3227; this.field3221 < this.field3219.length; this.field3221 += var1) {
         var1 = this.field3225.method4119(this.field3219, this.field3221, this.field3219.length - this.field3221);
         if(-1 == var1) {
            break;
         }

         this.field3228 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "24"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3225 = var1;
      this.field3218 = this.field3229 = var1.method4108();
      this.field3219 = new byte[var2];
      this.field3222 = new byte[var3];
      this.field3227 = 0L;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113142630"
   )
   void method4133() throws IOException {
      if(this.field3223 != -1L) {
         if(this.field3223 != this.field3228) {
            this.field3225.method4105(this.field3223);
            this.field3228 = this.field3223;
         }

         this.field3225.method4106(this.field3222, 0, this.field3224);
         this.field3228 += -832864089L * (long)(this.field3224 * -115202281);
         if(this.field3228 > this.field3229) {
            this.field3229 = this.field3228;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3223 >= this.field3220 && this.field3223 < (long)this.field3221 + this.field3220) {
            var1 = this.field3223;
         } else if(this.field3220 >= this.field3223 && this.field3220 < (long)this.field3224 + this.field3223) {
            var1 = this.field3220;
         }

         if((long)this.field3224 + this.field3223 > this.field3220 && (long)this.field3224 + this.field3223 <= (long)this.field3221 + this.field3220) {
            var3 = (long)this.field3224 + this.field3223;
         } else if(this.field3220 + (long)this.field3221 > this.field3223 && (long)this.field3221 + this.field3220 <= this.field3223 + (long)this.field3224) {
            var3 = (long)this.field3221 + this.field3220;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3222, (int)(var1 - this.field3223), this.field3219, (int)(var1 - this.field3220), var5);
         }

         this.field3223 = -1L;
         this.field3224 = 0;
      }

   }

   @ObfuscatedName("j")
   public void method4141(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3227 = var1;
      }
   }
}
