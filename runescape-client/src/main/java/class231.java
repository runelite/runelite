import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class231 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1
   )
   int field3268 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 2900203370878728679L
   )
   long field3269;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 7955860655215134657L
   )
   long field3270;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1093197131
   )
   int field3271;
   @ObfuscatedName("v")
   byte[] field3272;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -5816493189313150907L
   )
   long field3273 = -1L;
   @ObfuscatedName("e")
   byte[] field3274;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -9037721460911263769L
   )
   long field3275;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -1657895912833855371L
   )
   long field3276;
   @ObfuscatedName("f")
   FileOnDisk field3277;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 3938781316953066847L
   )
   long field3278 = -1L;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-14"
   )
   public void method4211() throws IOException {
      this.method4217();
      this.field3277.method4191();
   }

   @ObfuscatedName("e")
   public void method4212(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3275 = var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-52"
   )
   public long method4213() {
      return this.field3269;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "738974332"
   )
   void method4214() throws IOException {
      this.field3271 = 0;
      if(this.field3275 != this.field3270) {
         this.field3277.method4189(this.field3275);
         this.field3270 = this.field3275;
      }

      int var1;
      for(this.field3278 = this.field3275; this.field3271 < this.field3274.length; this.field3271 += var1) {
         var1 = this.field3277.method4193(this.field3274, this.field3271, this.field3274.length - this.field3271);
         if(var1 == -1) {
            break;
         }

         this.field3270 += (long)var1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1500170310"
   )
   public void method4215(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3273 != -1L && this.field3275 >= this.field3273 && (long)var3 + this.field3275 <= this.field3273 + (long)(this.field3268 * -2832727)) {
            System.arraycopy(this.field3272, (int)(this.field3275 - this.field3273), var1, var2, var3);
            this.field3275 += (long)var3;
            return;
         }

         long var4 = this.field3275;
         int var7 = var3;
         int var8;
         if(this.field3275 >= this.field3278 && this.field3275 < this.field3278 + (long)this.field3271) {
            var8 = (int)((long)this.field3271 - (this.field3275 - this.field3278));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3274, (int)(this.field3275 - this.field3278), var1, var2, var8);
            this.field3275 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3274.length) {
            this.field3277.method4189(this.field3275);

            for(this.field3270 = this.field3275; var3 > 0; var3 -= var8) {
               var8 = this.field3277.method4193(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3270 += (long)var8;
               this.field3275 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4214();
            var8 = var3;
            if(var3 > this.field3271) {
               var8 = this.field3271;
            }

            System.arraycopy(this.field3274, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3275 += (long)var8;
         }

         if(-1L != this.field3273) {
            if(this.field3273 > this.field3275 && var3 > 0) {
               var8 = (int)(this.field3273 - this.field3275) + var2;
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3275;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3273 >= var4 && this.field3273 < var4 + (long)var7) {
               var15 = this.field3273;
            } else if(var4 >= this.field3273 && var4 < (long)(this.field3268 * -2832727) + this.field3273) {
               var15 = var4;
            }

            if((long)(this.field3268 * -2832727) + this.field3273 > var4 && this.field3273 + (long)(this.field3268 * -2832727) <= (long)var7 + var4) {
               var10 = (long)(this.field3268 * -2832727) + this.field3273;
            } else if(var4 + (long)var7 > this.field3273 && var4 + (long)var7 <= this.field3273 + (long)(this.field3268 * -2832727)) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3272, (int)(var15 - this.field3273), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3275) {
                  var3 = (int)((long)var3 - (var10 - this.field3275));
                  this.field3275 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3270 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class231(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field3277 = var1;
      this.field3269 = this.field3276 = var1.method4206();
      this.field3274 = new byte[var2];
      this.field3272 = new byte[var3];
      this.field3275 = 0L;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135823684"
   )
   void method4217() throws IOException {
      if(-1L != this.field3273) {
         if(this.field3270 != this.field3273) {
            this.field3277.method4189(this.field3273);
            this.field3270 = this.field3273;
         }

         this.field3277.method4190(this.field3272, 0, this.field3268 * -2832727);
         this.field3270 += -2832727L * (long)this.field3268;
         if(this.field3270 > this.field3276) {
            this.field3276 = this.field3270;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3273 >= this.field3278 && this.field3273 < this.field3278 + (long)this.field3271) {
            var1 = this.field3273;
         } else if(this.field3278 >= this.field3273 && this.field3278 < this.field3273 + (long)(this.field3268 * -2832727)) {
            var1 = this.field3278;
         }

         if(this.field3273 + (long)(this.field3268 * -2832727) > this.field3278 && this.field3273 + (long)(this.field3268 * -2832727) <= this.field3278 + (long)this.field3271) {
            var3 = (long)(this.field3268 * -2832727) + this.field3273;
         } else if((long)this.field3271 + this.field3278 > this.field3273 && (long)this.field3271 + this.field3278 <= this.field3273 + (long)(this.field3268 * -2832727)) {
            var3 = this.field3278 + (long)this.field3271;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3272, (int)(var1 - this.field3273), this.field3274, (int)(var1 - this.field3278), var5);
         }

         this.field3273 = -1L;
         this.field3268 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2104691151"
   )
   public void method4222(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3275 > this.field3269) {
            this.field3269 = this.field3275 + (long)var3;
         }

         if(-1L != this.field3273 && (this.field3275 < this.field3273 || this.field3275 > (long)(this.field3268 * -2832727) + this.field3273)) {
            this.method4217();
         }

         if(this.field3273 != -1L && this.field3275 + (long)var3 > (long)this.field3272.length + this.field3273) {
            int var4 = (int)((long)this.field3272.length - (this.field3275 - this.field3273));
            System.arraycopy(var1, var2, this.field3272, (int)(this.field3275 - this.field3273), var4);
            this.field3275 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3268 = this.field3272.length * -2065220199;
            this.method4217();
         }

         if(var3 <= this.field3272.length) {
            if(var3 > 0) {
               if(this.field3273 == -1L) {
                  this.field3273 = this.field3275;
               }

               System.arraycopy(var1, var2, this.field3272, (int)(this.field3275 - this.field3273), var3);
               this.field3275 += (long)var3;
               if(this.field3275 - this.field3273 > (long)(this.field3268 * -2832727)) {
                  this.field3268 = (int)(this.field3275 - this.field3273) * -2065220199;
               }

            }
         } else {
            if(this.field3270 != this.field3275) {
               this.field3277.method4189(this.field3275);
               this.field3270 = this.field3275;
            }

            this.field3277.method4190(var1, var2, var3);
            this.field3270 += (long)var3;
            if(this.field3270 > this.field3276) {
               this.field3276 = this.field3270;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3275 >= this.field3278 && this.field3275 < this.field3278 + (long)this.field3271) {
               var11 = this.field3275;
            } else if(this.field3278 >= this.field3275 && this.field3278 < (long)var3 + this.field3275) {
               var11 = this.field3278;
            }

            if((long)var3 + this.field3275 > this.field3278 && this.field3275 + (long)var3 <= this.field3278 + (long)this.field3271) {
               var6 = this.field3275 + (long)var3;
            } else if((long)this.field3271 + this.field3278 > this.field3275 && this.field3278 + (long)this.field3271 <= this.field3275 + (long)var3) {
               var6 = (long)this.field3271 + this.field3278;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3275), this.field3274, (int)(var11 - this.field3278), var8);
            }

            this.field3275 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3270 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2098006050"
   )
   public void method4229(byte[] var1) throws IOException {
      this.method4215(var1, 0, var1.length);
   }
}
