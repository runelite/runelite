import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ho")
public class class231 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1619030143
   )
   int field3266;
   @ObfuscatedName("z")
   byte[] field3267;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 9072694105259156701L
   )
   long field3268 = -1L;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -6641875807647110547L
   )
   long field3269;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -8413288858173410731L
   )
   long field3270;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 7247996261755924869L
   )
   long field3271 = -1L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -279943317
   )
   int field3272 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1230198042780358471L
   )
   long field3273;
   @ObfuscatedName("p")
   byte[] field3274;
   @ObfuscatedName("s")
   FileOnDisk field3275;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 8412507630140242671L
   )
   long field3276;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1196597029"
   )
   void method4140() throws IOException {
      if(-1L != this.field3271) {
         if(this.field3271 != this.field3276) {
            this.field3275.method4126(this.field3271);
            this.field3276 = this.field3271;
         }

         this.field3275.method4124(this.field3274, 0, this.field3272);
         this.field3276 += -279943317L * (long)(this.field3272 * -239235773);
         if(this.field3276 > this.field3270) {
            this.field3270 = this.field3276;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3271 >= this.field3268 && this.field3271 < this.field3268 + (long)this.field3266) {
            var1 = this.field3271;
         } else if(this.field3268 >= this.field3271 && this.field3268 < this.field3271 + (long)this.field3272) {
            var1 = this.field3268;
         }

         if(this.field3271 + (long)this.field3272 > this.field3268 && this.field3271 + (long)this.field3272 <= this.field3268 + (long)this.field3266) {
            var3 = (long)this.field3272 + this.field3271;
         } else if((long)this.field3266 + this.field3268 > this.field3271 && this.field3268 + (long)this.field3266 <= this.field3271 + (long)this.field3272) {
            var3 = (long)this.field3266 + this.field3268;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3274, (int)(var1 - this.field3271), this.field3267, (int)(var1 - this.field3268), var5);
         }

         this.field3271 = -1L;
         this.field3272 = 0;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "87"
   )
   public void method4141() throws IOException {
      this.method4140();
      this.field3275.method4128();
   }

   @ObfuscatedName("z")
   public void method4142(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3269 = var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-2111026788"
   )
   public long method4143() {
      return this.field3273;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-575569346"
   )
   public void method4144(byte[] var1) throws IOException {
      this.method4145(var1, 0, var1.length);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1608209823"
   )
   public void method4145(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field3271 != -1L && this.field3269 >= this.field3271 && this.field3269 + (long)var3 <= this.field3271 + (long)this.field3272) {
            System.arraycopy(this.field3274, (int)(this.field3269 - this.field3271), var1, var2, var3);
            this.field3269 += (long)var3;
            return;
         }

         long var4 = this.field3269;
         int var7 = var3;
         int var8;
         if(this.field3269 >= this.field3268 && this.field3269 < this.field3268 + (long)this.field3266) {
            var8 = (int)((long)this.field3266 - (this.field3269 - this.field3268));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3267, (int)(this.field3269 - this.field3268), var1, var2, var8);
            this.field3269 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3267.length) {
            this.field3275.method4126(this.field3269);

            for(this.field3276 = this.field3269; var3 > 0; var3 -= var8) {
               var8 = this.field3275.method4127(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3276 += (long)var8;
               this.field3269 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4146();
            var8 = var3;
            if(var3 > this.field3266) {
               var8 = this.field3266;
            }

            System.arraycopy(this.field3267, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3269 += (long)var8;
         }

         if(this.field3271 != -1L) {
            if(this.field3271 > this.field3269 && var3 > 0) {
               var8 = var2 + (int)(this.field3271 - this.field3269);
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3269;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3271 >= var4 && this.field3271 < (long)var7 + var4) {
               var15 = this.field3271;
            } else if(var4 >= this.field3271 && var4 < this.field3271 + (long)this.field3272) {
               var15 = var4;
            }

            if(this.field3271 + (long)this.field3272 > var4 && (long)this.field3272 + this.field3271 <= (long)var7 + var4) {
               var10 = this.field3271 + (long)this.field3272;
            } else if(var4 + (long)var7 > this.field3271 && (long)var7 + var4 <= this.field3271 + (long)this.field3272) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3274, (int)(var15 - this.field3271), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3269) {
                  var3 = (int)((long)var3 - (var10 - this.field3269));
                  this.field3269 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3276 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1211313950"
   )
   void method4146() throws IOException {
      this.field3266 = 0;
      if(this.field3269 != this.field3276) {
         this.field3275.method4126(this.field3269);
         this.field3276 = this.field3269;
      }

      int var1;
      for(this.field3268 = this.field3269; this.field3266 < this.field3267.length; this.field3266 += var1) {
         var1 = this.field3275.method4127(this.field3267, this.field3266, this.field3267.length - this.field3266);
         if(var1 == -1) {
            break;
         }

         this.field3276 += (long)var1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "51"
   )
   public void method4147(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3269 + (long)var3 > this.field3273) {
            this.field3273 = (long)var3 + this.field3269;
         }

         if(-1L != this.field3271 && (this.field3269 < this.field3271 || this.field3269 > this.field3271 + (long)this.field3272)) {
            this.method4140();
         }

         if(-1L != this.field3271 && (long)var3 + this.field3269 > (long)this.field3274.length + this.field3271) {
            int var4 = (int)((long)this.field3274.length - (this.field3269 - this.field3271));
            System.arraycopy(var1, var2, this.field3274, (int)(this.field3269 - this.field3271), var4);
            this.field3269 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3272 = this.field3274.length;
            this.method4140();
         }

         if(var3 <= this.field3274.length) {
            if(var3 > 0) {
               if(this.field3271 == -1L) {
                  this.field3271 = this.field3269;
               }

               System.arraycopy(var1, var2, this.field3274, (int)(this.field3269 - this.field3271), var3);
               this.field3269 += (long)var3;
               if(this.field3269 - this.field3271 > (long)this.field3272) {
                  this.field3272 = (int)(this.field3269 - this.field3271);
               }

            }
         } else {
            if(this.field3269 != this.field3276) {
               this.field3275.method4126(this.field3269);
               this.field3276 = this.field3269;
            }

            this.field3275.method4124(var1, var2, var3);
            this.field3276 += (long)var3;
            if(this.field3276 > this.field3270) {
               this.field3270 = this.field3276;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3269 >= this.field3268 && this.field3269 < this.field3268 + (long)this.field3266) {
               var11 = this.field3269;
            } else if(this.field3268 >= this.field3269 && this.field3268 < this.field3269 + (long)var3) {
               var11 = this.field3268;
            }

            if(this.field3269 + (long)var3 > this.field3268 && this.field3269 + (long)var3 <= (long)this.field3266 + this.field3268) {
               var6 = this.field3269 + (long)var3;
            } else if(this.field3268 + (long)this.field3266 > this.field3269 && this.field3268 + (long)this.field3266 <= this.field3269 + (long)var3) {
               var6 = this.field3268 + (long)this.field3266;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3269), this.field3267, (int)(var11 - this.field3268), var8);
            }

            this.field3269 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3276 = -1L;
         throw var10;
      }
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class231(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field3275 = var1;
      long var10003 = var1.method4130();
      this.field3270 = var10003 * -8413288858173410731L;
      this.field3273 = var10003;
      this.field3267 = new byte[var2];
      this.field3274 = new byte[var3];
      this.field3269 = 0L;
   }
}
