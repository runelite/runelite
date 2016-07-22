import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class231 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -30833093
   )
   int field3265 = 0;
   @ObfuscatedName("w")
   byte[] field3266;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -560711848122551987L
   )
   long field3267 = -1L;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 782910667
   )
   int field3268;
   @ObfuscatedName("g")
   byte[] field3269;
   @ObfuscatedName("m")
   class230 field3270;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -905968963595954915L
   )
   long field3271 = -1L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -1404119699611194463L
   )
   long field3272;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 7870121284411286619L
   )
   long field3273;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -54930091130580983L
   )
   long field3274;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -4873980106465471229L
   )
   long field3275;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "599927437"
   )
   public void method4226() throws IOException {
      this.method4233();
      this.field3270.method4223();
   }

   @ObfuscatedName("w")
   public void method4227(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3272 = var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-20394273"
   )
   public long method4228() {
      return this.field3274;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2058127503"
   )
   void method4231() throws IOException {
      this.field3268 = 0;
      if(this.field3275 != this.field3272) {
         this.field3270.method4206(this.field3272);
         this.field3275 = this.field3272;
      }

      int var1;
      for(this.field3267 = this.field3272; this.field3268 < this.field3266.length; this.field3268 += var1) {
         var1 = this.field3270.method4210(this.field3266, this.field3268, this.field3266.length - this.field3268);
         if(var1 == -1) {
            break;
         }

         this.field3275 += (long)var1;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1603927812"
   )
   void method4233() throws IOException {
      if(-1L != this.field3271) {
         if(this.field3275 != this.field3271) {
            this.field3270.method4206(this.field3271);
            this.field3275 = this.field3271;
         }

         this.field3270.method4207(this.field3269, 0, this.field3265);
         this.field3275 += -30833093L * (long)(this.field3265 * -1318493453);
         if(this.field3275 > this.field3273) {
            this.field3273 = this.field3275;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3271 >= this.field3267 && this.field3271 < this.field3267 + (long)this.field3268) {
            var1 = this.field3271;
         } else if(this.field3267 >= this.field3271 && this.field3267 < this.field3271 + (long)this.field3265) {
            var1 = this.field3267;
         }

         if(this.field3271 + (long)this.field3265 > this.field3267 && this.field3271 + (long)this.field3265 <= this.field3267 + (long)this.field3268) {
            var3 = (long)this.field3265 + this.field3271;
         } else if((long)this.field3268 + this.field3267 > this.field3271 && this.field3267 + (long)this.field3268 <= (long)this.field3265 + this.field3271) {
            var3 = this.field3267 + (long)this.field3268;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3269, (int)(var1 - this.field3271), this.field3266, (int)(var1 - this.field3267), var5);
         }

         this.field3271 = -1L;
         this.field3265 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass230;II)V",
      garbageValue = "0"
   )
   public class231(class230 var1, int var2, int var3) throws IOException {
      this.field3270 = var1;
      this.field3274 = this.field3273 = var1.method4214();
      this.field3266 = new byte[var2];
      this.field3269 = new byte[var3];
      this.field3272 = 0L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-18"
   )
   public void method4238(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3271 != -1L && this.field3272 >= this.field3271 && this.field3272 + (long)var3 <= (long)this.field3265 + this.field3271) {
            System.arraycopy(this.field3269, (int)(this.field3272 - this.field3271), var1, var2, var3);
            this.field3272 += (long)var3;
            return;
         }

         long var4 = this.field3272;
         int var7 = var3;
         int var8;
         if(this.field3272 >= this.field3267 && this.field3272 < this.field3267 + (long)this.field3268) {
            var8 = (int)((long)this.field3268 - (this.field3272 - this.field3267));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3266, (int)(this.field3272 - this.field3267), var1, var2, var8);
            this.field3272 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3266.length) {
            this.field3270.method4206(this.field3272);

            for(this.field3275 = this.field3272; var3 > 0; var3 -= var8) {
               var8 = this.field3270.method4210(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3275 += (long)var8;
               this.field3272 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4231();
            var8 = var3;
            if(var3 > this.field3268) {
               var8 = this.field3268;
            }

            System.arraycopy(this.field3266, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3272 += (long)var8;
         }

         if(-1L != this.field3271) {
            if(this.field3271 > this.field3272 && var3 > 0) {
               var8 = var2 + (int)(this.field3271 - this.field3272);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3272;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3271 >= var4 && this.field3271 < (long)var7 + var4) {
               var15 = this.field3271;
            } else if(var4 >= this.field3271 && var4 < this.field3271 + (long)this.field3265) {
               var15 = var4;
            }

            if((long)this.field3265 + this.field3271 > var4 && this.field3271 + (long)this.field3265 <= (long)var7 + var4) {
               var10 = this.field3271 + (long)this.field3265;
            } else if((long)var7 + var4 > this.field3271 && (long)var7 + var4 <= this.field3271 + (long)this.field3265) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3269, (int)(var15 - this.field3271), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field3272) {
                  var3 = (int)((long)var3 - (var10 - this.field3272));
                  this.field3272 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3275 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "40232879"
   )
   public void method4240(byte[] var1) throws IOException {
      this.method4238(var1, 0, var1.length);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "105"
   )
   public void method4241(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3272 + (long)var3 > this.field3274) {
            this.field3274 = this.field3272 + (long)var3;
         }

         if(-1L != this.field3271 && (this.field3272 < this.field3271 || this.field3272 > this.field3271 + (long)this.field3265)) {
            this.method4233();
         }

         if(this.field3271 != -1L && this.field3272 + (long)var3 > this.field3271 + (long)this.field3269.length) {
            int var4 = (int)((long)this.field3269.length - (this.field3272 - this.field3271));
            System.arraycopy(var1, var2, this.field3269, (int)(this.field3272 - this.field3271), var4);
            this.field3272 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3265 = this.field3269.length;
            this.method4233();
         }

         if(var3 <= this.field3269.length) {
            if(var3 > 0) {
               if(this.field3271 == -1L) {
                  this.field3271 = this.field3272;
               }

               System.arraycopy(var1, var2, this.field3269, (int)(this.field3272 - this.field3271), var3);
               this.field3272 += (long)var3;
               if(this.field3272 - this.field3271 > (long)this.field3265) {
                  this.field3265 = (int)(this.field3272 - this.field3271);
               }

            }
         } else {
            if(this.field3275 != this.field3272) {
               this.field3270.method4206(this.field3272);
               this.field3275 = this.field3272;
            }

            this.field3270.method4207(var1, var2, var3);
            this.field3275 += (long)var3;
            if(this.field3275 > this.field3273) {
               this.field3273 = this.field3275;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3272 >= this.field3267 && this.field3272 < this.field3267 + (long)this.field3268) {
               var11 = this.field3272;
            } else if(this.field3267 >= this.field3272 && this.field3267 < (long)var3 + this.field3272) {
               var11 = this.field3267;
            }

            if((long)var3 + this.field3272 > this.field3267 && this.field3272 + (long)var3 <= this.field3267 + (long)this.field3268) {
               var6 = this.field3272 + (long)var3;
            } else if(this.field3267 + (long)this.field3268 > this.field3272 && (long)this.field3268 + this.field3267 <= (long)var3 + this.field3272) {
               var6 = this.field3267 + (long)this.field3268;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3272), this.field3266, (int)(var11 - this.field3267), var8);
            }

            this.field3272 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3275 = -1L;
         throw var10;
      }
   }
}
