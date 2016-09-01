import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
public class class231 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 4339626348602222315L
   )
   long field3264;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6840557597173990659L
   )
   long field3265 = -1L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1289395095
   )
   int field3266;
   @ObfuscatedName("i")
   byte[] field3267;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 7950696806969029539L
   )
   long field3268 = -1L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 990373119667230997L
   )
   long field3269;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1787071652469387599L
   )
   long field3270;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -8601900965408711181L
   )
   long field3271;
   @ObfuscatedName("r")
   byte[] field3272;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2047476589
   )
   int field3273 = 0;
   @ObfuscatedName("x")
   FileOnDisk field3274;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "8"
   )
   public void method4157(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3269 + (long)var3 > this.field3270) {
            this.field3270 = this.field3269 + (long)var3;
         }

         if(-1L != this.field3268 && (this.field3269 < this.field3268 || this.field3269 > this.field3268 + (long)this.field3273)) {
            this.method4167();
         }

         if(-1L != this.field3268 && (long)var3 + this.field3269 > (long)this.field3267.length + this.field3268) {
            int var4 = (int)((long)this.field3267.length - (this.field3269 - this.field3268));
            System.arraycopy(var1, var2, this.field3267, (int)(this.field3269 - this.field3268), var4);
            this.field3269 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3273 = this.field3267.length;
            this.method4167();
         }

         if(var3 <= this.field3267.length) {
            if(var3 > 0) {
               if(-1L == this.field3268) {
                  this.field3268 = this.field3269;
               }

               System.arraycopy(var1, var2, this.field3267, (int)(this.field3269 - this.field3268), var3);
               this.field3269 += (long)var3;
               if(this.field3269 - this.field3268 > (long)this.field3273) {
                  this.field3273 = (int)(this.field3269 - this.field3268);
               }

            }
         } else {
            if(this.field3269 != this.field3264) {
               this.field3274.method4134(this.field3269);
               this.field3264 = this.field3269;
            }

            this.field3274.method4135(var1, var2, var3);
            this.field3264 += (long)var3;
            if(this.field3264 > this.field3271) {
               this.field3271 = this.field3264;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3269 >= this.field3265 && this.field3269 < this.field3265 + (long)this.field3266) {
               var11 = this.field3269;
            } else if(this.field3265 >= this.field3269 && this.field3265 < (long)var3 + this.field3269) {
               var11 = this.field3265;
            }

            if(this.field3269 + (long)var3 > this.field3265 && (long)var3 + this.field3269 <= this.field3265 + (long)this.field3266) {
               var6 = (long)var3 + this.field3269;
            } else if((long)this.field3266 + this.field3265 > this.field3269 && this.field3265 + (long)this.field3266 <= (long)var3 + this.field3269) {
               var6 = this.field3265 + (long)this.field3266;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3269), this.field3272, (int)(var11 - this.field3265), var8);
            }

            this.field3269 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3264 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "811219077"
   )
   public void method4158() throws IOException {
      this.method4167();
      this.field3274.method4136();
   }

   @ObfuscatedName("r")
   public void method4159(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3269 = var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1746630152"
   )
   public long method4160() {
      return this.field3270;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "25"
   )
   public void method4161(byte[] var1) throws IOException {
      this.method4173(var1, 0, var1.length);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "855686660"
   )
   void method4163() throws IOException {
      this.field3266 = 0;
      if(this.field3269 != this.field3264) {
         this.field3274.method4134(this.field3269);
         this.field3264 = this.field3269;
      }

      int var1;
      for(this.field3265 = this.field3269; this.field3266 < this.field3272.length; this.field3266 += var1) {
         var1 = this.field3274.method4154(this.field3272, this.field3266, this.field3272.length - this.field3266);
         if(var1 == -1) {
            break;
         }

         this.field3264 += (long)var1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-71"
   )
   void method4167() throws IOException {
      if(-1L != this.field3268) {
         if(this.field3264 != this.field3268) {
            this.field3274.method4134(this.field3268);
            this.field3264 = this.field3268;
         }

         this.field3274.method4135(this.field3267, 0, this.field3273);
         this.field3264 += (long)(this.field3273 * 112295525) * 2047476589L;
         if(this.field3264 > this.field3271) {
            this.field3271 = this.field3264;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3268 >= this.field3265 && this.field3268 < (long)this.field3266 + this.field3265) {
            var1 = this.field3268;
         } else if(this.field3265 >= this.field3268 && this.field3265 < this.field3268 + (long)this.field3273) {
            var1 = this.field3265;
         }

         if(this.field3268 + (long)this.field3273 > this.field3265 && this.field3268 + (long)this.field3273 <= this.field3265 + (long)this.field3266) {
            var3 = this.field3268 + (long)this.field3273;
         } else if(this.field3265 + (long)this.field3266 > this.field3268 && this.field3265 + (long)this.field3266 <= (long)this.field3273 + this.field3268) {
            var3 = (long)this.field3266 + this.field3265;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3267, (int)(var1 - this.field3268), this.field3272, (int)(var1 - this.field3265), var5);
         }

         this.field3268 = -1L;
         this.field3273 = 0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "995197253"
   )
   public void method4173(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field3268 != -1L && this.field3269 >= this.field3268 && this.field3269 + (long)var3 <= (long)this.field3273 + this.field3268) {
            System.arraycopy(this.field3267, (int)(this.field3269 - this.field3268), var1, var2, var3);
            this.field3269 += (long)var3;
            return;
         }

         long var4 = this.field3269;
         int var7 = var3;
         int var8;
         if(this.field3269 >= this.field3265 && this.field3269 < (long)this.field3266 + this.field3265) {
            var8 = (int)((long)this.field3266 - (this.field3269 - this.field3265));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3272, (int)(this.field3269 - this.field3265), var1, var2, var8);
            this.field3269 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3272.length) {
            this.field3274.method4134(this.field3269);

            for(this.field3264 = this.field3269; var3 > 0; var3 -= var8) {
               var8 = this.field3274.method4154(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3264 += (long)var8;
               this.field3269 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4163();
            var8 = var3;
            if(var3 > this.field3266) {
               var8 = this.field3266;
            }

            System.arraycopy(this.field3272, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3269 += (long)var8;
         }

         if(-1L != this.field3268) {
            if(this.field3268 > this.field3269 && var3 > 0) {
               var8 = var2 + (int)(this.field3268 - this.field3269);
               if(var8 > var3 + var2) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3269;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3268 >= var4 && this.field3268 < var4 + (long)var7) {
               var15 = this.field3268;
            } else if(var4 >= this.field3268 && var4 < this.field3268 + (long)this.field3273) {
               var15 = var4;
            }

            if(this.field3268 + (long)this.field3273 > var4 && (long)this.field3273 + this.field3268 <= (long)var7 + var4) {
               var10 = this.field3268 + (long)this.field3273;
            } else if(var4 + (long)var7 > this.field3268 && var4 + (long)var7 <= this.field3268 + (long)this.field3273) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3267, (int)(var15 - this.field3268), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3269) {
                  var3 = (int)((long)var3 - (var10 - this.field3269));
                  this.field3269 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3264 = -1L;
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
      this.field3274 = var1;
      this.field3270 = this.field3271 = var1.method4137();
      this.field3272 = new byte[var2];
      this.field3267 = new byte[var3];
      this.field3269 = 0L;
   }
}
