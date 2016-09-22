import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class231 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 6618726524064663413L
   )
   long field3265;
   @ObfuscatedName("d")
   byte[] field3266;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 963038668972241423L
   )
   long field3267 = -1L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -8653748955769720775L
   )
   long field3268 = -1L;
   @ObfuscatedName("z")
   byte[] field3269;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1903826991
   )
   int field3270;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 690182203
   )
   int field3271 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 36015609679292695L
   )
   long field3272;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 8234421314569946931L
   )
   long field3273;
   @ObfuscatedName("a")
   FileOnDisk field3274;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 3119775477617203783L
   )
   long field3275;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1095807075"
   )
   public void method4199() throws IOException {
      this.method4205();
      this.field3274.method4197();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   public void method4200(byte[] var1) throws IOException {
      this.method4203(var1, 0, var1.length);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "15"
   )
   public long method4201() {
      return this.field3265;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "56"
   )
   public void method4203(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field3267 && this.field3272 >= this.field3267 && this.field3272 + (long)var3 <= (long)this.field3271 + this.field3267) {
            System.arraycopy(this.field3269, (int)(this.field3272 - this.field3267), var1, var2, var3);
            this.field3272 += (long)var3;
            return;
         }

         long var4 = this.field3272;
         int var7 = var3;
         int var8;
         if(this.field3272 >= this.field3268 && this.field3272 < this.field3268 + (long)this.field3270) {
            var8 = (int)((long)this.field3270 - (this.field3272 - this.field3268));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3266, (int)(this.field3272 - this.field3268), var1, var2, var8);
            this.field3272 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3266.length) {
            this.field3274.method4174(this.field3272);

            for(this.field3275 = this.field3272; var3 > 0; var3 -= var8) {
               var8 = this.field3274.method4178(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3275 += (long)var8;
               this.field3272 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4204();
            var8 = var3;
            if(var3 > this.field3270) {
               var8 = this.field3270;
            }

            System.arraycopy(this.field3266, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3272 += (long)var8;
         }

         if(this.field3267 != -1L) {
            if(this.field3267 > this.field3272 && var3 > 0) {
               var8 = (int)(this.field3267 - this.field3272) + var2;
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3272;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3267 >= var4 && this.field3267 < var4 + (long)var7) {
               var15 = this.field3267;
            } else if(var4 >= this.field3267 && var4 < (long)this.field3271 + this.field3267) {
               var15 = var4;
            }

            if(this.field3267 + (long)this.field3271 > var4 && (long)this.field3271 + this.field3267 <= var4 + (long)var7) {
               var10 = this.field3267 + (long)this.field3271;
            } else if(var4 + (long)var7 > this.field3267 && (long)var7 + var4 <= this.field3267 + (long)this.field3271) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3269, (int)(var15 - this.field3267), var1, var2 + (int)(var15 - var4), var12);
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "94"
   )
   void method4204() throws IOException {
      this.field3270 = 0;
      if(this.field3272 != this.field3275) {
         this.field3274.method4174(this.field3272);
         this.field3275 = this.field3272;
      }

      int var1;
      for(this.field3268 = this.field3272; this.field3270 < this.field3266.length; this.field3270 += var1) {
         var1 = this.field3274.method4178(this.field3266, this.field3270, this.field3266.length - this.field3270);
         if(var1 == -1) {
            break;
         }

         this.field3275 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class231(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field3274 = var1;
      long var10003 = var1.method4180();
      this.field3273 = var10003 * 8234421314569946931L;
      this.field3265 = var10003;
      this.field3266 = new byte[var2];
      this.field3269 = new byte[var3];
      this.field3272 = 0L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1941382717"
   )
   void method4205() throws IOException {
      if(this.field3267 != -1L) {
         if(this.field3275 != this.field3267) {
            this.field3274.method4174(this.field3267);
            this.field3275 = this.field3267;
         }

         this.field3274.method4175(this.field3269, 0, this.field3271);
         this.field3275 += (long)(this.field3271 * -966409997) * 690182203L;
         if(this.field3275 > this.field3273) {
            this.field3273 = this.field3275;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3267 >= this.field3268 && this.field3267 < (long)this.field3270 + this.field3268) {
            var1 = this.field3267;
         } else if(this.field3268 >= this.field3267 && this.field3268 < (long)this.field3271 + this.field3267) {
            var1 = this.field3268;
         }

         if((long)this.field3271 + this.field3267 > this.field3268 && (long)this.field3271 + this.field3267 <= (long)this.field3270 + this.field3268) {
            var3 = (long)this.field3271 + this.field3267;
         } else if((long)this.field3270 + this.field3268 > this.field3267 && (long)this.field3270 + this.field3268 <= this.field3267 + (long)this.field3271) {
            var3 = this.field3268 + (long)this.field3270;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3269, (int)(var1 - this.field3267), this.field3266, (int)(var1 - this.field3268), var5);
         }

         this.field3267 = -1L;
         this.field3271 = 0;
      }

   }

   @ObfuscatedName("d")
   public void method4209(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3272 = var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-202763850"
   )
   public void method4214(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3272 > this.field3265) {
            this.field3265 = this.field3272 + (long)var3;
         }

         if(-1L != this.field3267 && (this.field3272 < this.field3267 || this.field3272 > this.field3267 + (long)this.field3271)) {
            this.method4205();
         }

         if(this.field3267 != -1L && (long)var3 + this.field3272 > this.field3267 + (long)this.field3269.length) {
            int var4 = (int)((long)this.field3269.length - (this.field3272 - this.field3267));
            System.arraycopy(var1, var2, this.field3269, (int)(this.field3272 - this.field3267), var4);
            this.field3272 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3271 = this.field3269.length;
            this.method4205();
         }

         if(var3 <= this.field3269.length) {
            if(var3 > 0) {
               if(this.field3267 == -1L) {
                  this.field3267 = this.field3272;
               }

               System.arraycopy(var1, var2, this.field3269, (int)(this.field3272 - this.field3267), var3);
               this.field3272 += (long)var3;
               if(this.field3272 - this.field3267 > (long)this.field3271) {
                  this.field3271 = (int)(this.field3272 - this.field3267);
               }

            }
         } else {
            if(this.field3272 != this.field3275) {
               this.field3274.method4174(this.field3272);
               this.field3275 = this.field3272;
            }

            this.field3274.method4175(var1, var2, var3);
            this.field3275 += (long)var3;
            if(this.field3275 > this.field3273) {
               this.field3273 = this.field3275;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3272 >= this.field3268 && this.field3272 < (long)this.field3270 + this.field3268) {
               var11 = this.field3272;
            } else if(this.field3268 >= this.field3272 && this.field3268 < this.field3272 + (long)var3) {
               var11 = this.field3268;
            }

            if(this.field3272 + (long)var3 > this.field3268 && this.field3272 + (long)var3 <= this.field3268 + (long)this.field3270) {
               var6 = (long)var3 + this.field3272;
            } else if((long)this.field3270 + this.field3268 > this.field3272 && this.field3268 + (long)this.field3270 <= this.field3272 + (long)var3) {
               var6 = this.field3268 + (long)this.field3270;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3272), this.field3266, (int)(var11 - this.field3268), var8);
            }

            this.field3272 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3275 = -1L;
         throw var10;
      }
   }
}
