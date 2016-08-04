import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class231 {
   @ObfuscatedName("g")
   byte[] field3261;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -466152385
   )
   int field3262 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -8355677701584610615L
   )
   long field3263 = -1L;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -544576673
   )
   int field3264;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 7887600779993265319L
   )
   long field3265 = -1L;
   @ObfuscatedName("h")
   byte[] field3266;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 2101476718047691957L
   )
   long field3267;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 2200077563333191141L
   )
   long field3268;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -7342760407355761393L
   )
   long field3269;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -8590438853098608629L
   )
   long field3270;
   @ObfuscatedName("l")
   class230 field3271;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2133104429"
   )
   public void method4292() throws IOException {
      this.method4302();
      this.field3271.method4283();
   }

   @ObfuscatedName("g")
   public void method4293(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3268 = var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "651809370"
   )
   public void method4295(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3265 != -1L && this.field3268 >= this.field3265 && (long)var3 + this.field3268 <= this.field3265 + (long)this.field3262) {
            System.arraycopy(this.field3266, (int)(this.field3268 - this.field3265), var1, var2, var3);
            this.field3268 += (long)var3;
            return;
         }

         long var4 = this.field3268;
         int var7 = var3;
         int var8;
         if(this.field3268 >= this.field3263 && this.field3268 < (long)this.field3264 + this.field3263) {
            var8 = (int)((long)this.field3264 - (this.field3268 - this.field3263));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3261, (int)(this.field3268 - this.field3263), var1, var2, var8);
            this.field3268 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3261.length) {
            this.field3271.method4271(this.field3268);

            for(this.field3267 = this.field3268; var3 > 0; var3 -= var8) {
               var8 = this.field3271.method4274(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3267 += (long)var8;
               this.field3268 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4310();
            var8 = var3;
            if(var3 > this.field3264) {
               var8 = this.field3264;
            }

            System.arraycopy(this.field3261, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3268 += (long)var8;
         }

         if(-1L != this.field3265) {
            if(this.field3265 > this.field3268 && var3 > 0) {
               var8 = var2 + (int)(this.field3265 - this.field3268);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3268;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3265 >= var4 && this.field3265 < (long)var7 + var4) {
               var15 = this.field3265;
            } else if(var4 >= this.field3265 && var4 < (long)this.field3262 + this.field3265) {
               var15 = var4;
            }

            if(this.field3265 + (long)this.field3262 > var4 && this.field3265 + (long)this.field3262 <= (long)var7 + var4) {
               var10 = (long)this.field3262 + this.field3265;
            } else if(var4 + (long)var7 > this.field3265 && var4 + (long)var7 <= this.field3265 + (long)this.field3262) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3266, (int)(var15 - this.field3265), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3268) {
                  var3 = (int)((long)var3 - (var10 - this.field3268));
                  this.field3268 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3267 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-49"
   )
   public void method4297(byte[] var1) throws IOException {
      this.method4295(var1, 0, var1.length);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-447336967"
   )
   public void method4298(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3268 > this.field3270) {
            this.field3270 = this.field3268 + (long)var3;
         }

         if(this.field3265 != -1L && (this.field3268 < this.field3265 || this.field3268 > (long)this.field3262 + this.field3265)) {
            this.method4302();
         }

         if(this.field3265 != -1L && this.field3268 + (long)var3 > this.field3265 + (long)this.field3266.length) {
            int var4 = (int)((long)this.field3266.length - (this.field3268 - this.field3265));
            System.arraycopy(var1, var2, this.field3266, (int)(this.field3268 - this.field3265), var4);
            this.field3268 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3262 = this.field3266.length;
            this.method4302();
         }

         if(var3 <= this.field3266.length) {
            if(var3 > 0) {
               if(this.field3265 == -1L) {
                  this.field3265 = this.field3268;
               }

               System.arraycopy(var1, var2, this.field3266, (int)(this.field3268 - this.field3265), var3);
               this.field3268 += (long)var3;
               if(this.field3268 - this.field3265 > (long)this.field3262) {
                  this.field3262 = (int)(this.field3268 - this.field3265);
               }

            }
         } else {
            if(this.field3268 != this.field3267) {
               this.field3271.method4271(this.field3268);
               this.field3267 = this.field3268;
            }

            this.field3271.method4275(var1, var2, var3);
            this.field3267 += (long)var3;
            if(this.field3267 > this.field3269) {
               this.field3269 = this.field3267;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3268 >= this.field3263 && this.field3268 < (long)this.field3264 + this.field3263) {
               var11 = this.field3268;
            } else if(this.field3263 >= this.field3268 && this.field3263 < this.field3268 + (long)var3) {
               var11 = this.field3263;
            }

            if(this.field3268 + (long)var3 > this.field3263 && (long)var3 + this.field3268 <= (long)this.field3264 + this.field3263) {
               var6 = (long)var3 + this.field3268;
            } else if(this.field3263 + (long)this.field3264 > this.field3268 && (long)this.field3264 + this.field3263 <= (long)var3 + this.field3268) {
               var6 = (long)this.field3264 + this.field3263;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3268), this.field3261, (int)(var11 - this.field3263), var8);
            }

            this.field3268 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3267 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "721584403"
   )
   void method4302() throws IOException {
      if(-1L != this.field3265) {
         if(this.field3267 != this.field3265) {
            this.field3271.method4271(this.field3265);
            this.field3267 = this.field3265;
         }

         this.field3271.method4275(this.field3266, 0, this.field3262);
         this.field3267 += -466152385L * (long)(this.field3262 * 636148671);
         if(this.field3267 > this.field3269) {
            this.field3269 = this.field3267;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3265 >= this.field3263 && this.field3265 < this.field3263 + (long)this.field3264) {
            var1 = this.field3265;
         } else if(this.field3263 >= this.field3265 && this.field3263 < this.field3265 + (long)this.field3262) {
            var1 = this.field3263;
         }

         if(this.field3265 + (long)this.field3262 > this.field3263 && (long)this.field3262 + this.field3265 <= this.field3263 + (long)this.field3264) {
            var3 = (long)this.field3262 + this.field3265;
         } else if((long)this.field3264 + this.field3263 > this.field3265 && (long)this.field3264 + this.field3263 <= this.field3265 + (long)this.field3262) {
            var3 = (long)this.field3264 + this.field3263;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3266, (int)(var1 - this.field3265), this.field3261, (int)(var1 - this.field3263), var5);
         }

         this.field3265 = -1L;
         this.field3262 = 0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1602698974"
   )
   public long method4303() {
      return this.field3270;
   }

   @ObfuscatedSignature(
      signature = "(Lclass230;II)V",
      garbageValue = "0"
   )
   public class231(class230 var1, int var2, int var3) throws IOException {
      this.field3271 = var1;
      long var10003 = var1.method4273();
      this.field3269 = var10003 * -7342760407355761393L;
      this.field3270 = var10003;
      this.field3261 = new byte[var2];
      this.field3266 = new byte[var3];
      this.field3268 = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1857101203"
   )
   void method4310() throws IOException {
      this.field3264 = 0;
      if(this.field3268 != this.field3267) {
         this.field3271.method4271(this.field3268);
         this.field3267 = this.field3268;
      }

      int var1;
      for(this.field3263 = this.field3268; this.field3264 < this.field3261.length; this.field3264 += var1) {
         var1 = this.field3271.method4274(this.field3261, this.field3264, this.field3261.length - this.field3264);
         if(var1 == -1) {
            break;
         }

         this.field3267 += (long)var1;
      }

   }
}
