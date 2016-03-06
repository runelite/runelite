package net.runelite.rs.client;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ha")
public class class227 {
   @ObfuscatedName("f")
   byte[] field3210;
   @ObfuscatedName("l")
   byte[] field3211;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -745377394923957131L
   )
   long field3212 = 1L;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1999179927
   )
   int field3213;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1
   )
   int field3214 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -8771189220046487503L
   )
   long field3215 = 1L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 7008274525299166563L
   )
   long field3216;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 3373720934166540617L
   )
   long field3217;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 2536029770696785063L
   )
   long field3218;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 1986136506093569725L
   )
   long field3219;
   @ObfuscatedName("j")
   class226 field3220;

   @ObfuscatedName("a")
   public long method4083() {
      return this.field3219;
   }

   @ObfuscatedName("l")
   public void method4084(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3216 = var1;
      }
   }

   @ObfuscatedName("f")
   public void method4085(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field3215 * -1L && this.field3216 >= this.field3215 * -1L && this.field3216 + (long)var3 <= (long)(this.field3214 * 1027711275) + this.field3215 * -1L) {
            System.arraycopy(this.field3210, (int)(this.field3216 - this.field3215 * -1L), var1, var2, var3);
            this.field3216 += (long)var3;
            return;
         }

         long var4 = this.field3216;
         int var7 = var3;
         int var8;
         if(this.field3216 >= this.field3212 * -1L && this.field3216 < this.field3212 * -1L + (long)this.field3213) {
            var8 = (int)((long)this.field3213 - (this.field3216 - this.field3212 * -1L));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3211, (int)(this.field3216 - this.field3212 * -1L), var1, var2, var8);
            this.field3216 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3211.length) {
            this.field3220.method4060(this.field3216);

            for(this.field3217 = this.field3216 * -1L; var3 > 0; var3 -= var8) {
               var8 = this.field3220.method4068(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3217 += -1L * (long)var8;
               this.field3216 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4086();
            var8 = var3;
            if(var3 > this.field3213) {
               var8 = this.field3213;
            }

            System.arraycopy(this.field3211, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3216 += (long)var8;
         }

         if(this.field3215 * -1L != -1L) {
            if(this.field3215 * -1L > this.field3216 && var3 > 0) {
               var8 = (int)(this.field3215 * -1L - this.field3216) + var2;
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3216;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3215 * -1L >= var4 && this.field3215 * -1L < var4 + (long)var7) {
               var14 = this.field3215 * -1L;
            } else if(var4 >= this.field3215 * -1L && var4 < (long)(this.field3214 * 1027711275) + this.field3215 * -1L) {
               var14 = var4;
            }

            if(this.field3215 * -1L + (long)(this.field3214 * 1027711275) > var4 && (long)(this.field3214 * 1027711275) + this.field3215 * -1L <= var4 + (long)var7) {
               var10 = this.field3215 * -1L + (long)(this.field3214 * 1027711275);
            } else if((long)var7 + var4 > this.field3215 * -1L && var4 + (long)var7 <= (long)(this.field3214 * 1027711275) + this.field3215 * -1L) {
               var10 = var4 + (long)var7;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3210, (int)(var14 - this.field3215 * -1L), var1, var2 + (int)(var14 - var4), var12);
               if(var10 > this.field3216) {
                  var3 = (int)((long)var3 - (var10 - this.field3216));
                  this.field3216 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field3217 = 1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("m")
   void method4086() throws IOException {
      this.field3213 = 0;
      if(this.field3217 * -1L != this.field3216) {
         this.field3220.method4060(this.field3216);
         this.field3217 = this.field3216 * -1L;
      }

      int var1;
      for(this.field3212 = this.field3216 * -1L; this.field3213 < this.field3211.length; this.field3213 += var1) {
         var1 = this.field3220.method4068(this.field3211, this.field3213, this.field3211.length - this.field3213);
         if(var1 == -1) {
            break;
         }

         this.field3217 += (long)var1 * -1L;
      }

   }

   @ObfuscatedName("o")
   public void method4087(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3216 + (long)var3 > this.field3219) {
            this.field3219 = this.field3216 + (long)var3;
         }

         if(this.field3215 * -1L != -1L && (this.field3216 < this.field3215 * -1L || this.field3216 > (long)(this.field3214 * 1027711275) + this.field3215 * -1L)) {
            this.method4103();
         }

         if(-1L != this.field3215 * -1L && this.field3216 + (long)var3 > this.field3215 * -1L + (long)this.field3210.length) {
            int var4 = (int)((long)this.field3210.length - (this.field3216 - this.field3215 * -1L));
            System.arraycopy(var1, var2, this.field3210, (int)(this.field3216 - this.field3215 * -1L), var4);
            this.field3216 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3214 = this.field3210.length * -2104093309;
            this.method4103();
         }

         if(var3 <= this.field3210.length) {
            if(var3 > 0) {
               if(this.field3215 * -1L == -1L) {
                  this.field3215 = this.field3216 * -1L;
               }

               System.arraycopy(var1, var2, this.field3210, (int)(this.field3216 - this.field3215 * -1L), var3);
               this.field3216 += (long)var3;
               if(this.field3216 - this.field3215 * -1L > (long)(this.field3214 * 1027711275)) {
                  this.field3214 = (int)(this.field3216 - this.field3215 * -1L) * -2104093309;
               }

            }
         } else {
            if(this.field3216 != this.field3217 * -1L) {
               this.field3220.method4060(this.field3216);
               this.field3217 = this.field3216 * -1L;
            }

            this.field3220.method4061(var1, var2, var3);
            this.field3217 += (long)var3 * -1L;
            if(this.field3217 * -1L > this.field3218) {
               this.field3218 = this.field3217 * -1L;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3216 >= this.field3212 * -1L && this.field3216 < (long)this.field3213 + this.field3212 * -1L) {
               var10 = this.field3216;
            } else if(this.field3212 * -1L >= this.field3216 && this.field3212 * -1L < this.field3216 + (long)var3) {
               var10 = this.field3212 * -1L;
            }

            if(this.field3216 + (long)var3 > this.field3212 * -1L && (long)var3 + this.field3216 <= (long)this.field3213 + this.field3212 * -1L) {
               var6 = this.field3216 + (long)var3;
            } else if(this.field3212 * -1L + (long)this.field3213 > this.field3216 && this.field3212 * -1L + (long)this.field3213 <= this.field3216 + (long)var3) {
               var6 = this.field3212 * -1L + (long)this.field3213;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3216), this.field3211, (int)(var10 - this.field3212 * -1L), var8);
            }

            this.field3216 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3217 = 1L;
         throw var9;
      }
   }

   public class227(class226 var1, int var2, int var3) throws IOException {
      this.field3220 = var1;
      this.field3219 = this.field3218 = var1.method4067();
      this.field3211 = new byte[var2];
      this.field3210 = new byte[var3];
      this.field3216 = 0L;
   }

   @ObfuscatedName("j")
   public void method4091() throws IOException {
      this.method4103();
      this.field3220.method4069();
   }

   @ObfuscatedName("h")
   void method4103() throws IOException {
      if(this.field3215 * -1L != -1L) {
         if(this.field3215 * -1L != this.field3217 * -1L) {
            this.field3220.method4060(this.field3215 * -1L);
            this.field3217 = this.field3215;
         }

         this.field3220.method4061(this.field3210, 0, this.field3214 * 1027711275);
         this.field3217 += -1027711275L * (long)this.field3214;
         if(this.field3217 * -1L > this.field3218) {
            this.field3218 = this.field3217 * -1L;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3215 * -1L >= this.field3212 * -1L && this.field3215 * -1L < this.field3212 * -1L + (long)this.field3213) {
            var1 = this.field3215 * -1L;
         } else if(this.field3212 * -1L >= this.field3215 * -1L && this.field3212 * -1L < this.field3215 * -1L + (long)(this.field3214 * 1027711275)) {
            var1 = this.field3212 * -1L;
         }

         if(this.field3215 * -1L + (long)(this.field3214 * 1027711275) > this.field3212 * -1L && this.field3215 * -1L + (long)(this.field3214 * 1027711275) <= (long)this.field3213 + this.field3212 * -1L) {
            var3 = (long)(this.field3214 * 1027711275) + this.field3215 * -1L;
         } else if(this.field3212 * -1L + (long)this.field3213 > this.field3215 * -1L && (long)this.field3213 + this.field3212 * -1L <= this.field3215 * -1L + (long)(this.field3214 * 1027711275)) {
            var3 = this.field3212 * -1L + (long)this.field3213;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3210, (int)(var1 - this.field3215 * -1L), this.field3211, (int)(var1 - this.field3212 * -1L), var5);
         }

         this.field3215 = 1L;
         this.field3214 = 0;
      }

   }

   @ObfuscatedName("i")
   public void method4108(byte[] var1) throws IOException {
      this.method4085(var1, 0, var1.length);
   }
}
