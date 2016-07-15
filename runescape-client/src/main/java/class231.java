import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class231 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -1566334754829782779L
   )
   long field3264;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 371365237
   )
   int field3265 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -555417183011089997L
   )
   long field3266 = -1L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 944321283
   )
   int field3267;
   @ObfuscatedName("e")
   class230 field3268;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 8769163548256720679L
   )
   long field3269;
   @ObfuscatedName("r")
   byte[] field3270;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -8307216757374894379L
   )
   long field3271;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 833122974071099475L
   )
   long field3272;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -3666340043854947543L
   )
   long field3273 = -1L;
   @ObfuscatedName("l")
   byte[] field3274;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1093555703"
   )
   public void method4231() throws IOException {
      this.method4238();
      this.field3268.method4213();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "294421766"
   )
   public void method4233(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3273 != -1L && this.field3271 >= this.field3273 && (long)var3 + this.field3271 <= (long)this.field3265 + this.field3273) {
            System.arraycopy(this.field3270, (int)(this.field3271 - this.field3273), var1, var2, var3);
            this.field3271 += (long)var3;
            return;
         }

         long var4 = this.field3271;
         int var7 = var3;
         int var8;
         if(this.field3271 >= this.field3266 && this.field3271 < this.field3266 + (long)this.field3267) {
            var8 = (int)((long)this.field3267 - (this.field3271 - this.field3266));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3274, (int)(this.field3271 - this.field3266), var1, var2, var8);
            this.field3271 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3274.length) {
            this.field3268.method4211(this.field3271);

            for(this.field3269 = this.field3271; var3 > 0; var3 -= var8) {
               var8 = this.field3268.method4215(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3269 += (long)var8;
               this.field3271 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4236();
            var8 = var3;
            if(var3 > this.field3267) {
               var8 = this.field3267;
            }

            System.arraycopy(this.field3274, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3271 += (long)var8;
         }

         if(-1L != this.field3273) {
            if(this.field3273 > this.field3271 && var3 > 0) {
               var8 = var2 + (int)(this.field3273 - this.field3271);
               if(var8 > var3 + var2) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3271;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3273 >= var4 && this.field3273 < var4 + (long)var7) {
               var15 = this.field3273;
            } else if(var4 >= this.field3273 && var4 < this.field3273 + (long)this.field3265) {
               var15 = var4;
            }

            if(this.field3273 + (long)this.field3265 > var4 && (long)this.field3265 + this.field3273 <= var4 + (long)var7) {
               var10 = (long)this.field3265 + this.field3273;
            } else if((long)var7 + var4 > this.field3273 && (long)var7 + var4 <= this.field3273 + (long)this.field3265) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3270, (int)(var15 - this.field3273), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3271) {
                  var3 = (int)((long)var3 - (var10 - this.field3271));
                  this.field3271 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3269 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1011002343"
   )
   public void method4234(byte[] var1) throws IOException {
      this.method4233(var1, 0, var1.length);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1041423013"
   )
   void method4236() throws IOException {
      this.field3267 = 0;
      if(this.field3269 != this.field3271) {
         this.field3268.method4211(this.field3271);
         this.field3269 = this.field3271;
      }

      int var1;
      for(this.field3266 = this.field3271; this.field3267 < this.field3274.length; this.field3267 += var1) {
         var1 = this.field3268.method4215(this.field3274, this.field3267, this.field3274.length - this.field3267);
         if(var1 == -1) {
            break;
         }

         this.field3269 += (long)var1;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2097493189"
   )
   public long method4237() {
      return this.field3264;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-387437614"
   )
   void method4238() throws IOException {
      if(this.field3273 != -1L) {
         if(this.field3273 != this.field3269) {
            this.field3268.method4211(this.field3273);
            this.field3269 = this.field3273;
         }

         this.field3268.method4212(this.field3270, 0, this.field3265);
         this.field3269 += (long)(this.field3265 * 1325388509) * 371365237L;
         if(this.field3269 > this.field3272) {
            this.field3272 = this.field3269;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3273 >= this.field3266 && this.field3273 < this.field3266 + (long)this.field3267) {
            var1 = this.field3273;
         } else if(this.field3266 >= this.field3273 && this.field3266 < this.field3273 + (long)this.field3265) {
            var1 = this.field3266;
         }

         if(this.field3273 + (long)this.field3265 > this.field3266 && (long)this.field3265 + this.field3273 <= (long)this.field3267 + this.field3266) {
            var3 = this.field3273 + (long)this.field3265;
         } else if((long)this.field3267 + this.field3266 > this.field3273 && (long)this.field3267 + this.field3266 <= this.field3273 + (long)this.field3265) {
            var3 = this.field3266 + (long)this.field3267;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3270, (int)(var1 - this.field3273), this.field3274, (int)(var1 - this.field3266), var5);
         }

         this.field3273 = -1L;
         this.field3265 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass230;II)V",
      garbageValue = "0"
   )
   public class231(class230 var1, int var2, int var3) throws IOException {
      this.field3268 = var1;
      this.field3264 = this.field3272 = var1.method4214();
      this.field3274 = new byte[var2];
      this.field3270 = new byte[var3];
      this.field3271 = 0L;
   }

   @ObfuscatedName("l")
   public void method4252(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3271 = var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-23233264"
   )
   public void method4255(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3271 > this.field3264) {
            this.field3264 = (long)var3 + this.field3271;
         }

         if(this.field3273 != -1L && (this.field3271 < this.field3273 || this.field3271 > this.field3273 + (long)this.field3265)) {
            this.method4238();
         }

         if(-1L != this.field3273 && (long)var3 + this.field3271 > this.field3273 + (long)this.field3270.length) {
            int var4 = (int)((long)this.field3270.length - (this.field3271 - this.field3273));
            System.arraycopy(var1, var2, this.field3270, (int)(this.field3271 - this.field3273), var4);
            this.field3271 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3265 = this.field3270.length;
            this.method4238();
         }

         if(var3 <= this.field3270.length) {
            if(var3 > 0) {
               if(-1L == this.field3273) {
                  this.field3273 = this.field3271;
               }

               System.arraycopy(var1, var2, this.field3270, (int)(this.field3271 - this.field3273), var3);
               this.field3271 += (long)var3;
               if(this.field3271 - this.field3273 > (long)this.field3265) {
                  this.field3265 = (int)(this.field3271 - this.field3273);
               }

            }
         } else {
            if(this.field3269 != this.field3271) {
               this.field3268.method4211(this.field3271);
               this.field3269 = this.field3271;
            }

            this.field3268.method4212(var1, var2, var3);
            this.field3269 += (long)var3;
            if(this.field3269 > this.field3272) {
               this.field3272 = this.field3269;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3271 >= this.field3266 && this.field3271 < this.field3266 + (long)this.field3267) {
               var11 = this.field3271;
            } else if(this.field3266 >= this.field3271 && this.field3266 < (long)var3 + this.field3271) {
               var11 = this.field3266;
            }

            if((long)var3 + this.field3271 > this.field3266 && (long)var3 + this.field3271 <= (long)this.field3267 + this.field3266) {
               var6 = this.field3271 + (long)var3;
            } else if((long)this.field3267 + this.field3266 > this.field3271 && this.field3266 + (long)this.field3267 <= (long)var3 + this.field3271) {
               var6 = (long)this.field3267 + this.field3266;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3271), this.field3274, (int)(var11 - this.field3266), var8);
            }

            this.field3271 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3269 = -1L;
         throw var10;
      }
   }
}
