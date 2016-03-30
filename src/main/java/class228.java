import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class228 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 1470911407869804975L
   )
   long field3221 = -1L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1682649379
   )
   int field3222;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 1192556713024714439L
   )
   long field3223 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 720526093021397705L
   )
   long field3224;
   @ObfuscatedName("e")
   byte[] field3225;
   @ObfuscatedName("w")
   class227 field3226;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1343052417
   )
   int field3227 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -1629492854077179389L
   )
   long field3228;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -5028576264240495357L
   )
   long field3229;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 8507363370320174395L
   )
   long field3230;
   @ObfuscatedName("x")
   byte[] field3231;

   @ObfuscatedName("w")
   public void method4151() throws IOException {
      this.method4158();
      this.field3226.method4130();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   void method4152() throws IOException {
      this.field3222 = 0;
      if(this.field3228 != this.field3224) {
         this.field3226.method4147(this.field3224);
         this.field3228 = this.field3224;
      }

      int var1;
      for(this.field3223 = this.field3224; this.field3222 < this.field3231.length; this.field3222 += var1) {
         var1 = this.field3226.method4131(this.field3231, this.field3222, this.field3231.length - this.field3222);
         if(var1 == -1) {
            break;
         }

         this.field3228 += (long)var1;
      }

   }

   @ObfuscatedName("p")
   public void method4154(byte[] var1) throws IOException {
      this.method4155(var1, 0, var1.length);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-908018447"
   )
   public void method4155(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field3221 != -1L && this.field3224 >= this.field3221 && this.field3224 + (long)var3 <= (long)this.field3227 + this.field3221) {
            System.arraycopy(this.field3225, (int)(this.field3224 - this.field3221), var1, var2, var3);
            this.field3224 += (long)var3;
            return;
         }

         long var4 = this.field3224;
         int var7 = var3;
         int var8;
         if(this.field3224 >= this.field3223 && this.field3224 < (long)this.field3222 + this.field3223) {
            var8 = (int)((long)this.field3222 - (this.field3224 - this.field3223));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3231, (int)(this.field3224 - this.field3223), var1, var2, var8);
            this.field3224 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3231.length) {
            this.field3226.method4147(this.field3224);

            for(this.field3228 = this.field3224; var3 > 0; var3 -= var8) {
               var8 = this.field3226.method4131(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3228 += (long)var8;
               this.field3224 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4152();
            var8 = var3;
            if(var3 > this.field3222) {
               var8 = this.field3222;
            }

            System.arraycopy(this.field3231, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3224 += (long)var8;
         }

         if(-1L != this.field3221) {
            if(this.field3221 > this.field3224 && var3 > 0) {
               var8 = (int)(this.field3221 - this.field3224) + var2;
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3224;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3221 >= var4 && this.field3221 < var4 + (long)var7) {
               var14 = this.field3221;
            } else if(var4 >= this.field3221 && var4 < (long)this.field3227 + this.field3221) {
               var14 = var4;
            }

            if(this.field3221 + (long)this.field3227 > var4 && this.field3221 + (long)this.field3227 <= (long)var7 + var4) {
               var10 = this.field3221 + (long)this.field3227;
            } else if(var4 + (long)var7 > this.field3221 && var4 + (long)var7 <= (long)this.field3227 + this.field3221) {
               var10 = (long)var7 + var4;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3225, (int)(var14 - this.field3221), var1, (int)(var14 - var4) + var2, var12);
               if(var10 > this.field3224) {
                  var3 = (int)((long)var3 - (var10 - this.field3224));
                  this.field3224 = var10;
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

   @ObfuscatedName("t")
   public long method4156() {
      return this.field3230;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "15"
   )
   public void method4157(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3224 > this.field3230) {
            this.field3230 = (long)var3 + this.field3224;
         }

         if(this.field3221 != -1L && (this.field3224 < this.field3221 || this.field3224 > (long)this.field3227 + this.field3221)) {
            this.method4158();
         }

         if(-1L != this.field3221 && this.field3224 + (long)var3 > (long)this.field3225.length + this.field3221) {
            int var4 = (int)((long)this.field3225.length - (this.field3224 - this.field3221));
            System.arraycopy(var1, var2, this.field3225, (int)(this.field3224 - this.field3221), var4);
            this.field3224 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3227 = this.field3225.length;
            this.method4158();
         }

         if(var3 <= this.field3225.length) {
            if(var3 > 0) {
               if(this.field3221 == -1L) {
                  this.field3221 = this.field3224;
               }

               System.arraycopy(var1, var2, this.field3225, (int)(this.field3224 - this.field3221), var3);
               this.field3224 += (long)var3;
               if(this.field3224 - this.field3221 > (long)this.field3227) {
                  this.field3227 = (int)(this.field3224 - this.field3221);
               }

            }
         } else {
            if(this.field3228 != this.field3224) {
               this.field3226.method4147(this.field3224);
               this.field3228 = this.field3224;
            }

            this.field3226.method4143(var1, var2, var3);
            this.field3228 += (long)var3;
            if(this.field3228 > this.field3229) {
               this.field3229 = this.field3228;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3224 >= this.field3223 && this.field3224 < this.field3223 + (long)this.field3222) {
               var10 = this.field3224;
            } else if(this.field3223 >= this.field3224 && this.field3223 < (long)var3 + this.field3224) {
               var10 = this.field3223;
            }

            if((long)var3 + this.field3224 > this.field3223 && (long)var3 + this.field3224 <= (long)this.field3222 + this.field3223) {
               var6 = (long)var3 + this.field3224;
            } else if(this.field3223 + (long)this.field3222 > this.field3224 && this.field3223 + (long)this.field3222 <= this.field3224 + (long)var3) {
               var6 = this.field3223 + (long)this.field3222;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3224), this.field3231, (int)(var10 - this.field3223), var8);
            }

            this.field3224 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3228 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-29"
   )
   void method4158() throws IOException {
      if(this.field3221 != -1L) {
         if(this.field3228 != this.field3221) {
            this.field3226.method4147(this.field3221);
            this.field3228 = this.field3221;
         }

         this.field3226.method4143(this.field3225, 0, this.field3227);
         this.field3228 += 1343052417L * (long)(this.field3227 * -279911039);
         if(this.field3228 > this.field3229) {
            this.field3229 = this.field3228;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3221 >= this.field3223 && this.field3221 < (long)this.field3222 + this.field3223) {
            var1 = this.field3221;
         } else if(this.field3223 >= this.field3221 && this.field3223 < (long)this.field3227 + this.field3221) {
            var1 = this.field3223;
         }

         if(this.field3221 + (long)this.field3227 > this.field3223 && (long)this.field3227 + this.field3221 <= (long)this.field3222 + this.field3223) {
            var3 = this.field3221 + (long)this.field3227;
         } else if((long)this.field3222 + this.field3223 > this.field3221 && (long)this.field3222 + this.field3223 <= this.field3221 + (long)this.field3227) {
            var3 = (long)this.field3222 + this.field3223;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3225, (int)(var1 - this.field3221), this.field3231, (int)(var1 - this.field3223), var5);
         }

         this.field3221 = -1L;
         this.field3227 = 0;
      }

   }

   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3226 = var1;
      this.field3230 = this.field3229 = var1.method4132();
      this.field3231 = new byte[var2];
      this.field3225 = new byte[var3];
      this.field3224 = 0L;
   }

   @ObfuscatedName("x")
   public void method4169(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3224 = var1;
      }
   }
}
