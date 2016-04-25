import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class class228 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -3638759437946453395L
   )
   long field3221 = -1L;
   @ObfuscatedName("h")
   byte[] field3222;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5996942549074938011L
   )
   long field3223 = -1L;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 657532269
   )
   int field3224;
   @ObfuscatedName("x")
   byte[] field3225;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 5563733132897322089L
   )
   long field3226;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1553097729
   )
   int field3227 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 1761298927870619411L
   )
   long field3228;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 4226391153127281825L
   )
   long field3229;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -1959727452819372833L
   )
   long field3230;
   @ObfuscatedName("j")
   class227 field3231;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2015439751"
   )
   void method4107() throws IOException {
      if(this.field3221 != -1L) {
         if(this.field3226 != this.field3221) {
            this.field3231.method4089(this.field3221);
            this.field3226 = this.field3221;
         }

         this.field3231.method4097(this.field3225, 0, this.field3227);
         this.field3226 += -1553097729L * (long)(this.field3227 * 1703044095);
         if(this.field3226 > this.field3229) {
            this.field3229 = this.field3226;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3221 >= this.field3223 && this.field3221 < this.field3223 + (long)this.field3224) {
            var1 = this.field3221;
         } else if(this.field3223 >= this.field3221 && this.field3223 < this.field3221 + (long)this.field3227) {
            var1 = this.field3223;
         }

         if(this.field3221 + (long)this.field3227 > this.field3223 && (long)this.field3227 + this.field3221 <= this.field3223 + (long)this.field3224) {
            var3 = (long)this.field3227 + this.field3221;
         } else if(this.field3223 + (long)this.field3224 > this.field3221 && this.field3223 + (long)this.field3224 <= (long)this.field3227 + this.field3221) {
            var3 = (long)this.field3224 + this.field3223;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3225, (int)(var1 - this.field3221), this.field3222, (int)(var1 - this.field3223), var5);
         }

         this.field3221 = -1L;
         this.field3227 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-70"
   )
   public long method4108() {
      return this.field3230;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-181164596"
   )
   public void method4109(byte[] var1) throws IOException {
      this.method4123(var1, 0, var1.length);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1867033618"
   )
   public void method4112(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3228 + (long)var3 > this.field3230) {
            this.field3230 = (long)var3 + this.field3228;
         }

         if(-1L != this.field3221 && (this.field3228 < this.field3221 || this.field3228 > (long)this.field3227 + this.field3221)) {
            this.method4107();
         }

         if(-1L != this.field3221 && this.field3228 + (long)var3 > this.field3221 + (long)this.field3225.length) {
            int var4 = (int)((long)this.field3225.length - (this.field3228 - this.field3221));
            System.arraycopy(var1, var2, this.field3225, (int)(this.field3228 - this.field3221), var4);
            this.field3228 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3227 = this.field3225.length;
            this.method4107();
         }

         if(var3 <= this.field3225.length) {
            if(var3 > 0) {
               if(-1L == this.field3221) {
                  this.field3221 = this.field3228;
               }

               System.arraycopy(var1, var2, this.field3225, (int)(this.field3228 - this.field3221), var3);
               this.field3228 += (long)var3;
               if(this.field3228 - this.field3221 > (long)this.field3227) {
                  this.field3227 = (int)(this.field3228 - this.field3221);
               }

            }
         } else {
            if(this.field3226 != this.field3228) {
               this.field3231.method4089(this.field3228);
               this.field3226 = this.field3228;
            }

            this.field3231.method4097(var1, var2, var3);
            this.field3226 += (long)var3;
            if(this.field3226 > this.field3229) {
               this.field3229 = this.field3226;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3228 >= this.field3223 && this.field3228 < this.field3223 + (long)this.field3224) {
               var10 = this.field3228;
            } else if(this.field3223 >= this.field3228 && this.field3223 < this.field3228 + (long)var3) {
               var10 = this.field3223;
            }

            if((long)var3 + this.field3228 > this.field3223 && (long)var3 + this.field3228 <= this.field3223 + (long)this.field3224) {
               var6 = (long)var3 + this.field3228;
            } else if((long)this.field3224 + this.field3223 > this.field3228 && (long)this.field3224 + this.field3223 <= (long)var3 + this.field3228) {
               var6 = this.field3223 + (long)this.field3224;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)(var10 + (long)var2 - this.field3228), this.field3222, (int)(var10 - this.field3223), var8);
            }

            this.field3228 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3226 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "672302121"
   )
   void method4117() throws IOException {
      this.field3224 = 0;
      if(this.field3228 != this.field3226) {
         this.field3231.method4089(this.field3228);
         this.field3226 = this.field3228;
      }

      int var1;
      for(this.field3223 = this.field3228; this.field3224 < this.field3222.length; this.field3224 += var1) {
         var1 = this.field3231.method4093(this.field3222, this.field3224, this.field3222.length - this.field3224);
         if(var1 == -1) {
            break;
         }

         this.field3226 += (long)var1;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method4118() throws IOException {
      this.method4107();
      this.field3231.method4088();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "522691555"
   )
   public void method4123(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3221 != -1L && this.field3228 >= this.field3221 && (long)var3 + this.field3228 <= this.field3221 + (long)this.field3227) {
            System.arraycopy(this.field3225, (int)(this.field3228 - this.field3221), var1, var2, var3);
            this.field3228 += (long)var3;
            return;
         }

         long var4 = this.field3228;
         int var7 = var3;
         int var8;
         if(this.field3228 >= this.field3223 && this.field3228 < this.field3223 + (long)this.field3224) {
            var8 = (int)((long)this.field3224 - (this.field3228 - this.field3223));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3222, (int)(this.field3228 - this.field3223), var1, var2, var8);
            this.field3228 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3222.length) {
            this.field3231.method4089(this.field3228);

            for(this.field3226 = this.field3228; var3 > 0; var3 -= var8) {
               var8 = this.field3231.method4093(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3226 += (long)var8;
               this.field3228 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4117();
            var8 = var3;
            if(var3 > this.field3224) {
               var8 = this.field3224;
            }

            System.arraycopy(this.field3222, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3228 += (long)var8;
         }

         if(this.field3221 != -1L) {
            if(this.field3221 > this.field3228 && var3 > 0) {
               var8 = (int)(this.field3221 - this.field3228) + var2;
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3228;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3221 >= var4 && this.field3221 < (long)var7 + var4) {
               var14 = this.field3221;
            } else if(var4 >= this.field3221 && var4 < this.field3221 + (long)this.field3227) {
               var14 = var4;
            }

            if(this.field3221 + (long)this.field3227 > var4 && (long)this.field3227 + this.field3221 <= (long)var7 + var4) {
               var10 = this.field3221 + (long)this.field3227;
            } else if(var4 + (long)var7 > this.field3221 && (long)var7 + var4 <= this.field3221 + (long)this.field3227) {
               var10 = (long)var7 + var4;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3225, (int)(var14 - this.field3221), var1, var2 + (int)(var14 - var4), var12);
               if(var10 > this.field3228) {
                  var3 = (int)((long)var3 - (var10 - this.field3228));
                  this.field3228 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field3226 = -1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "5200"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3231 = var1;
      long var10003 = var1.method4092();
      this.field3229 = var10003 * 4226391153127281825L;
      this.field3230 = var10003;
      this.field3222 = new byte[var2];
      this.field3225 = new byte[var3];
      this.field3228 = 0L;
   }

   @ObfuscatedName("h")
   public void method4132(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3228 = var1;
      }
   }
}
