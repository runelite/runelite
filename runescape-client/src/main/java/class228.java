import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hc")
public class class228 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 503596671
   )
   int field3220 = 0;
   @ObfuscatedName("i")
   byte[] field3221;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -7311377203839913695L
   )
   long field3222 = -1L;
   @ObfuscatedName("t")
   class227 field3223;
   @ObfuscatedName("z")
   byte[] field3224;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6781351793831333531L
   )
   long field3225 = -1L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 194313451
   )
   int field3226;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -5735494360419948467L
   )
   long field3227;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 6472984456953622739L
   )
   long field3228;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 5041905220808627315L
   )
   long field3229;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 8286683292088550883L
   )
   long field3230;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "350619314"
   )
   public void method4095() throws IOException {
      this.method4099();
      this.field3223.method4074();
   }

   @ObfuscatedName("i")
   public void method4096(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3227 = var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "24"
   )
   public long method4097() {
      return this.field3229;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "576900346"
   )
   public void method4098(byte[] var1) throws IOException {
      this.method4104(var1, 0, var1.length);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-533005252"
   )
   void method4099() throws IOException {
      if(this.field3225 != -1L) {
         if(this.field3230 != this.field3225) {
            this.field3223.method4072(this.field3225);
            this.field3230 = this.field3225;
         }

         this.field3223.method4073(this.field3224, 0, this.field3220);
         this.field3230 += 503596671L * (long)(this.field3220 * -940476033);
         if(this.field3230 > this.field3228) {
            this.field3228 = this.field3230;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3225 >= this.field3222 && this.field3225 < this.field3222 + (long)this.field3226) {
            var1 = this.field3225;
         } else if(this.field3222 >= this.field3225 && this.field3222 < (long)this.field3220 + this.field3225) {
            var1 = this.field3222;
         }

         if(this.field3225 + (long)this.field3220 > this.field3222 && (long)this.field3220 + this.field3225 <= (long)this.field3226 + this.field3222) {
            var3 = (long)this.field3220 + this.field3225;
         } else if((long)this.field3226 + this.field3222 > this.field3225 && (long)this.field3226 + this.field3222 <= this.field3225 + (long)this.field3220) {
            var3 = (long)this.field3226 + this.field3222;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3224, (int)(var1 - this.field3225), this.field3221, (int)(var1 - this.field3222), var5);
         }

         this.field3225 = -1L;
         this.field3220 = 0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-389814485"
   )
   void method4100() throws IOException {
      this.field3226 = 0;
      if(this.field3227 != this.field3230) {
         this.field3223.method4072(this.field3227);
         this.field3230 = this.field3227;
      }

      int var1;
      for(this.field3222 = this.field3227; this.field3226 < this.field3221.length; this.field3226 += var1) {
         var1 = this.field3223.method4086(this.field3221, this.field3226, this.field3221.length - this.field3226);
         if(var1 == -1) {
            break;
         }

         this.field3230 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "24"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3223 = var1;
      this.field3229 = this.field3228 = var1.method4075();
      this.field3221 = new byte[var2];
      this.field3224 = new byte[var3];
      this.field3227 = 0L;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1434374827"
   )
   public void method4104(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field3225 && this.field3227 >= this.field3225 && this.field3227 + (long)var3 <= (long)this.field3220 + this.field3225) {
            System.arraycopy(this.field3224, (int)(this.field3227 - this.field3225), var1, var2, var3);
            this.field3227 += (long)var3;
            return;
         }

         long var4 = this.field3227;
         int var7 = var3;
         int var8;
         if(this.field3227 >= this.field3222 && this.field3227 < (long)this.field3226 + this.field3222) {
            var8 = (int)((long)this.field3226 - (this.field3227 - this.field3222));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3221, (int)(this.field3227 - this.field3222), var1, var2, var8);
            this.field3227 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3221.length) {
            this.field3223.method4072(this.field3227);

            for(this.field3230 = this.field3227; var3 > 0; var3 -= var8) {
               var8 = this.field3223.method4086(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3230 += (long)var8;
               this.field3227 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4100();
            var8 = var3;
            if(var3 > this.field3226) {
               var8 = this.field3226;
            }

            System.arraycopy(this.field3221, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3227 += (long)var8;
         }

         if(-1L != this.field3225) {
            if(this.field3225 > this.field3227 && var3 > 0) {
               var8 = var2 + (int)(this.field3225 - this.field3227);
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3227;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3225 >= var4 && this.field3225 < var4 + (long)var7) {
               var15 = this.field3225;
            } else if(var4 >= this.field3225 && var4 < this.field3225 + (long)this.field3220) {
               var15 = var4;
            }

            if(this.field3225 + (long)this.field3220 > var4 && this.field3225 + (long)this.field3220 <= var4 + (long)var7) {
               var10 = (long)this.field3220 + this.field3225;
            } else if((long)var7 + var4 > this.field3225 && var4 + (long)var7 <= (long)this.field3220 + this.field3225) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3224, (int)(var15 - this.field3225), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field3227) {
                  var3 = (int)((long)var3 - (var10 - this.field3227));
                  this.field3227 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3230 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "1181"
   )
   public void method4113(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3227 + (long)var3 > this.field3229) {
            this.field3229 = this.field3227 + (long)var3;
         }

         if(this.field3225 != -1L && (this.field3227 < this.field3225 || this.field3227 > this.field3225 + (long)this.field3220)) {
            this.method4099();
         }

         if(this.field3225 != -1L && (long)var3 + this.field3227 > (long)this.field3224.length + this.field3225) {
            int var4 = (int)((long)this.field3224.length - (this.field3227 - this.field3225));
            System.arraycopy(var1, var2, this.field3224, (int)(this.field3227 - this.field3225), var4);
            this.field3227 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3220 = this.field3224.length;
            this.method4099();
         }

         if(var3 <= this.field3224.length) {
            if(var3 > 0) {
               if(-1L == this.field3225) {
                  this.field3225 = this.field3227;
               }

               System.arraycopy(var1, var2, this.field3224, (int)(this.field3227 - this.field3225), var3);
               this.field3227 += (long)var3;
               if(this.field3227 - this.field3225 > (long)this.field3220) {
                  this.field3220 = (int)(this.field3227 - this.field3225);
               }

            }
         } else {
            if(this.field3230 != this.field3227) {
               this.field3223.method4072(this.field3227);
               this.field3230 = this.field3227;
            }

            this.field3223.method4073(var1, var2, var3);
            this.field3230 += (long)var3;
            if(this.field3230 > this.field3228) {
               this.field3228 = this.field3230;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3227 >= this.field3222 && this.field3227 < (long)this.field3226 + this.field3222) {
               var11 = this.field3227;
            } else if(this.field3222 >= this.field3227 && this.field3222 < (long)var3 + this.field3227) {
               var11 = this.field3222;
            }

            if((long)var3 + this.field3227 > this.field3222 && (long)var3 + this.field3227 <= this.field3222 + (long)this.field3226) {
               var6 = (long)var3 + this.field3227;
            } else if(this.field3222 + (long)this.field3226 > this.field3227 && this.field3222 + (long)this.field3226 <= this.field3227 + (long)var3) {
               var6 = this.field3222 + (long)this.field3226;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field3227), this.field3221, (int)(var11 - this.field3222), var8);
            }

            this.field3227 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3230 = -1L;
         throw var10;
      }
   }
}
