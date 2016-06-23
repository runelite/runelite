import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class228 {
   @ObfuscatedName("l")
   byte[] field3219;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -6817503244510771231L
   )
   long field3220;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = 5755620726659992251L
   )
   long field3221 = -1L;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2130113775
   )
   int field3222;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -4190183937861851617L
   )
   long field3223 = -1L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 7116036250311922903L
   )
   long field3224;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1643985421
   )
   int field3225 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -6521162079870003505L
   )
   long field3226;
   @ObfuscatedName("f")
   class227 field3227;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6702563708356401947L
   )
   long field3228;
   @ObfuscatedName("u")
   byte[] field3229;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1766552509
   )
   static int field3230;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2024813944"
   )
   void method4165() throws IOException {
      this.field3222 = 0;
      if(this.field3226 != this.field3224) {
         this.field3227.method4147(this.field3226);
         this.field3224 = this.field3226;
      }

      int var1;
      for(this.field3221 = this.field3226; this.field3222 < this.field3229.length; this.field3222 += var1) {
         var1 = this.field3227.method4146(this.field3229, this.field3222, this.field3229.length - this.field3222);
         if(var1 == -1) {
            break;
         }

         this.field3224 += (long)var1;
      }

   }

   @ObfuscatedName("u")
   public void method4167(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3226 = var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2126226972"
   )
   public void method4169(byte[] var1) throws IOException {
      this.method4170(var1, 0, var1.length);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1011079590"
   )
   public void method4170(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field3223 && this.field3226 >= this.field3223 && (long)var3 + this.field3226 <= (long)this.field3225 + this.field3223) {
            System.arraycopy(this.field3219, (int)(this.field3226 - this.field3223), var1, var2, var3);
            this.field3226 += (long)var3;
            return;
         }

         long var4 = this.field3226;
         int var7 = var3;
         int var8;
         if(this.field3226 >= this.field3221 && this.field3226 < this.field3221 + (long)this.field3222) {
            var8 = (int)((long)this.field3222 - (this.field3226 - this.field3221));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3229, (int)(this.field3226 - this.field3221), var1, var2, var8);
            this.field3226 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3229.length) {
            this.field3227.method4147(this.field3226);

            for(this.field3224 = this.field3226; var3 > 0; var3 -= var8) {
               var8 = this.field3227.method4146(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3224 += (long)var8;
               this.field3226 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4165();
            var8 = var3;
            if(var3 > this.field3222) {
               var8 = this.field3222;
            }

            System.arraycopy(this.field3229, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3226 += (long)var8;
         }

         if(-1L != this.field3223) {
            if(this.field3223 > this.field3226 && var3 > 0) {
               var8 = var2 + (int)(this.field3223 - this.field3226);
               if(var8 > var3 + var2) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3226;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3223 >= var4 && this.field3223 < var4 + (long)var7) {
               var15 = this.field3223;
            } else if(var4 >= this.field3223 && var4 < (long)this.field3225 + this.field3223) {
               var15 = var4;
            }

            if(this.field3223 + (long)this.field3225 > var4 && (long)this.field3225 + this.field3223 <= (long)var7 + var4) {
               var10 = this.field3223 + (long)this.field3225;
            } else if(var4 + (long)var7 > this.field3223 && var4 + (long)var7 <= this.field3223 + (long)this.field3225) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3219, (int)(var15 - this.field3223), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field3226) {
                  var3 = (int)((long)var3 - (var10 - this.field3226));
                  this.field3226 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3224 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method4173() throws IOException {
      if(-1L != this.field3223) {
         if(this.field3224 != this.field3223) {
            this.field3227.method4147(this.field3223);
            this.field3224 = this.field3223;
         }

         this.field3227.method4158(this.field3219, 0, this.field3225);
         this.field3224 += 1643985421L * (long)(this.field3225 * 406496453);
         if(this.field3224 > this.field3220) {
            this.field3220 = this.field3224;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3223 >= this.field3221 && this.field3223 < this.field3221 + (long)this.field3222) {
            var1 = this.field3223;
         } else if(this.field3221 >= this.field3223 && this.field3221 < (long)this.field3225 + this.field3223) {
            var1 = this.field3221;
         }

         if(this.field3223 + (long)this.field3225 > this.field3221 && this.field3223 + (long)this.field3225 <= this.field3221 + (long)this.field3222) {
            var3 = this.field3223 + (long)this.field3225;
         } else if(this.field3221 + (long)this.field3222 > this.field3223 && this.field3221 + (long)this.field3222 <= this.field3223 + (long)this.field3225) {
            var3 = (long)this.field3222 + this.field3221;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3219, (int)(var1 - this.field3223), this.field3229, (int)(var1 - this.field3221), var5);
         }

         this.field3223 = -1L;
         this.field3225 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass227;II)V",
      garbageValue = "0"
   )
   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3227 = var1;
      long var10003 = var1.method4150();
      this.field3220 = var10003 * -6817503244510771231L;
      this.field3228 = var10003;
      this.field3229 = new byte[var2];
      this.field3219 = new byte[var3];
      this.field3226 = 0L;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1941962897"
   )
   public void method4179() throws IOException {
      this.method4173();
      this.field3227.method4149();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1937386286"
   )
   public long method4182() {
      return this.field3228;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-93"
   )
   public void method4189(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3226 > this.field3228) {
            this.field3228 = this.field3226 + (long)var3;
         }

         if(this.field3223 != -1L && (this.field3226 < this.field3223 || this.field3226 > (long)this.field3225 + this.field3223)) {
            this.method4173();
         }

         if(-1L != this.field3223 && this.field3226 + (long)var3 > (long)this.field3219.length + this.field3223) {
            int var4 = (int)((long)this.field3219.length - (this.field3226 - this.field3223));
            System.arraycopy(var1, var2, this.field3219, (int)(this.field3226 - this.field3223), var4);
            this.field3226 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3225 = this.field3219.length;
            this.method4173();
         }

         if(var3 <= this.field3219.length) {
            if(var3 > 0) {
               if(-1L == this.field3223) {
                  this.field3223 = this.field3226;
               }

               System.arraycopy(var1, var2, this.field3219, (int)(this.field3226 - this.field3223), var3);
               this.field3226 += (long)var3;
               if(this.field3226 - this.field3223 > (long)this.field3225) {
                  this.field3225 = (int)(this.field3226 - this.field3223);
               }

            }
         } else {
            if(this.field3226 != this.field3224) {
               this.field3227.method4147(this.field3226);
               this.field3224 = this.field3226;
            }

            this.field3227.method4158(var1, var2, var3);
            this.field3224 += (long)var3;
            if(this.field3224 > this.field3220) {
               this.field3220 = this.field3224;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3226 >= this.field3221 && this.field3226 < this.field3221 + (long)this.field3222) {
               var11 = this.field3226;
            } else if(this.field3221 >= this.field3226 && this.field3221 < this.field3226 + (long)var3) {
               var11 = this.field3221;
            }

            if((long)var3 + this.field3226 > this.field3221 && (long)var3 + this.field3226 <= (long)this.field3222 + this.field3221) {
               var6 = this.field3226 + (long)var3;
            } else if((long)this.field3222 + this.field3221 > this.field3226 && this.field3221 + (long)this.field3222 <= this.field3226 + (long)var3) {
               var6 = (long)this.field3222 + this.field3221;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3226), this.field3229, (int)(var11 - this.field3221), var8);
            }

            this.field3226 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3224 = -1L;
         throw var10;
      }
   }
}
