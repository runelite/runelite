import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class231 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1606235155
   )
   int field3266 = 0;
   @ObfuscatedName("q")
   byte[] field3267;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 5821274942707832187L
   )
   long field3268 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -533143455
   )
   int field3269;
   @ObfuscatedName("v")
   byte[] field3270;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8445716394208628961L
   )
   long field3271 = -1L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 6822881575700969425L
   )
   long field3273;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -3784534881598994779L
   )
   long field3274;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -3348158776734853401L
   )
   long field3275;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 1952104517141057467L
   )
   long field3276;
   @ObfuscatedName("k")
   FileOnDisk field3277;

   @ObfuscatedName("q")
   public void method4165(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3273 = var1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "949140242"
   )
   public long method4166() {
      return this.field3275;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-431129333"
   )
   public void method4167(byte[] var1) throws IOException {
      this.method4189(var1, 0, var1.length);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2057838846"
   )
   void method4169() throws IOException {
      this.field3269 = 0;
      if(this.field3273 != this.field3276) {
         this.field3277.method4144(this.field3273);
         this.field3276 = this.field3273;
      }

      int var1;
      for(this.field3268 = this.field3273; this.field3269 < this.field3267.length; this.field3269 += var1) {
         var1 = this.field3277.method4143(this.field3267, this.field3269, this.field3267.length - this.field3269);
         if(var1 == -1) {
            break;
         }

         this.field3276 += (long)var1;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1128312958"
   )
   void method4171() throws IOException {
      if(-1L != this.field3271) {
         if(this.field3271 != this.field3276) {
            this.field3277.method4144(this.field3271);
            this.field3276 = this.field3271;
         }

         this.field3277.method4145(this.field3270, 0, this.field3266);
         this.field3276 += 1606235155L * (long)(this.field3266 * -794642917);
         if(this.field3276 > this.field3274) {
            this.field3274 = this.field3276;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3271 >= this.field3268 && this.field3271 < this.field3268 + (long)this.field3269) {
            var1 = this.field3271;
         } else if(this.field3268 >= this.field3271 && this.field3268 < (long)this.field3266 + this.field3271) {
            var1 = this.field3268;
         }

         if((long)this.field3266 + this.field3271 > this.field3268 && this.field3271 + (long)this.field3266 <= this.field3268 + (long)this.field3269) {
            var3 = this.field3271 + (long)this.field3266;
         } else if((long)this.field3269 + this.field3268 > this.field3271 && (long)this.field3269 + this.field3268 <= this.field3271 + (long)this.field3266) {
            var3 = this.field3268 + (long)this.field3269;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3270, (int)(var1 - this.field3271), this.field3267, (int)(var1 - this.field3268), var5);
         }

         this.field3271 = -1L;
         this.field3266 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-429229619"
   )
   public void method4176(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3273 + (long)var3 > this.field3275) {
            this.field3275 = this.field3273 + (long)var3;
         }

         if(-1L != this.field3271 && (this.field3273 < this.field3271 || this.field3273 > (long)this.field3266 + this.field3271)) {
            this.method4171();
         }

         if(this.field3271 != -1L && this.field3273 + (long)var3 > this.field3271 + (long)this.field3270.length) {
            int var4 = (int)((long)this.field3270.length - (this.field3273 - this.field3271));
            System.arraycopy(var1, var2, this.field3270, (int)(this.field3273 - this.field3271), var4);
            this.field3273 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3266 = this.field3270.length;
            this.method4171();
         }

         if(var3 <= this.field3270.length) {
            if(var3 > 0) {
               if(this.field3271 == -1L) {
                  this.field3271 = this.field3273;
               }

               System.arraycopy(var1, var2, this.field3270, (int)(this.field3273 - this.field3271), var3);
               this.field3273 += (long)var3;
               if(this.field3273 - this.field3271 > (long)this.field3266) {
                  this.field3266 = (int)(this.field3273 - this.field3271);
               }

            }
         } else {
            if(this.field3273 != this.field3276) {
               this.field3277.method4144(this.field3273);
               this.field3276 = this.field3273;
            }

            this.field3277.method4145(var1, var2, var3);
            this.field3276 += (long)var3;
            if(this.field3276 > this.field3274) {
               this.field3274 = this.field3276;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3273 >= this.field3268 && this.field3273 < this.field3268 + (long)this.field3269) {
               var11 = this.field3273;
            } else if(this.field3268 >= this.field3273 && this.field3268 < (long)var3 + this.field3273) {
               var11 = this.field3268;
            }

            if((long)var3 + this.field3273 > this.field3268 && this.field3273 + (long)var3 <= this.field3268 + (long)this.field3269) {
               var6 = this.field3273 + (long)var3;
            } else if(this.field3268 + (long)this.field3269 > this.field3273 && (long)this.field3269 + this.field3268 <= (long)var3 + this.field3273) {
               var6 = this.field3268 + (long)this.field3269;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3273), this.field3267, (int)(var11 - this.field3268), var8);
            }

            this.field3273 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3276 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-67"
   )
   public void method4177() throws IOException {
      this.method4171();
      this.field3277.method4146();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class231(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field3277 = var1;
      this.field3275 = this.field3274 = var1.method4147();
      this.field3267 = new byte[var2];
      this.field3270 = new byte[var3];
      this.field3273 = 0L;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "23"
   )
   public void method4189(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3271 != -1L && this.field3273 >= this.field3271 && (long)var3 + this.field3273 <= (long)this.field3266 + this.field3271) {
            System.arraycopy(this.field3270, (int)(this.field3273 - this.field3271), var1, var2, var3);
            this.field3273 += (long)var3;
            return;
         }

         long var4 = this.field3273;
         int var7 = var3;
         int var8;
         if(this.field3273 >= this.field3268 && this.field3273 < (long)this.field3269 + this.field3268) {
            var8 = (int)((long)this.field3269 - (this.field3273 - this.field3268));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3267, (int)(this.field3273 - this.field3268), var1, var2, var8);
            this.field3273 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3267.length) {
            this.field3277.method4144(this.field3273);

            for(this.field3276 = this.field3273; var3 > 0; var3 -= var8) {
               var8 = this.field3277.method4143(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3276 += (long)var8;
               this.field3273 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4169();
            var8 = var3;
            if(var3 > this.field3269) {
               var8 = this.field3269;
            }

            System.arraycopy(this.field3267, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3273 += (long)var8;
         }

         if(this.field3271 != -1L) {
            if(this.field3271 > this.field3273 && var3 > 0) {
               var8 = var2 + (int)(this.field3271 - this.field3273);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3273;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3271 >= var4 && this.field3271 < var4 + (long)var7) {
               var15 = this.field3271;
            } else if(var4 >= this.field3271 && var4 < this.field3271 + (long)this.field3266) {
               var15 = var4;
            }

            if((long)this.field3266 + this.field3271 > var4 && this.field3271 + (long)this.field3266 <= (long)var7 + var4) {
               var10 = this.field3271 + (long)this.field3266;
            } else if((long)var7 + var4 > this.field3271 && (long)var7 + var4 <= (long)this.field3266 + this.field3271) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3270, (int)(var15 - this.field3271), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field3273) {
                  var3 = (int)((long)var3 - (var10 - this.field3273));
                  this.field3273 = var10;
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
}
