package net.runelite.rs.client;

import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("he")
public class class227 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1
   )
   int field3201 = 0;
   @ObfuscatedName("m")
   byte[] field3202;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -4847866641759039997L
   )
   long field3203;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1030477751
   )
   int field3204;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2179345425311325979L
   )
   long field3205 = 1L;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -4899126995671847089L
   )
   long field3206 = 1L;
   @ObfuscatedName("j")
   class226 field3207;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 1598561066304863521L
   )
   long field3208;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -1570439813758860693L
   )
   long field3209;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -6041424951765965097L
   )
   long field3210;
   @ObfuscatedName("u")
   byte[] field3211;

   @ObfuscatedName("m")
   public void method4188(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3208 = var1;
      }
   }

   @ObfuscatedName("j")
   public void method4189() throws IOException {
      this.method4207();
      this.field3207.method4183();
   }

   @ObfuscatedName("l")
   public void method4190(byte[] var1) throws IOException {
      this.method4193(var1, 0, var1.length);
   }

   @ObfuscatedName("f")
   public long method4191() {
      return this.field3210;
   }

   @ObfuscatedName("u")
   public void method4193(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field3206 * -1L && this.field3208 >= this.field3206 * -1L && this.field3208 + (long)var3 <= (long)(this.field3201 * 1668340111) + this.field3206 * -1L) {
            System.arraycopy(this.field3211, (int)(this.field3208 - this.field3206 * -1L), var1, var2, var3);
            this.field3208 += (long)var3;
            return;
         }

         long var4 = this.field3208;
         int var7 = var3;
         int var8;
         if(this.field3208 >= this.field3205 * -1L && this.field3208 < (long)this.field3204 + this.field3205 * -1L) {
            var8 = (int)((long)this.field3204 - (this.field3208 - this.field3205 * -1L));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3202, (int)(this.field3208 - this.field3205 * -1L), var1, var2, var8);
            this.field3208 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3202.length) {
            this.field3207.method4173(this.field3208);

            for(this.field3203 = this.field3208 * -1L; var3 > 0; var3 -= var8) {
               var8 = this.field3207.method4177(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3203 += (long)var8 * -1L;
               this.field3208 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4194();
            var8 = var3;
            if(var3 > this.field3204) {
               var8 = this.field3204;
            }

            System.arraycopy(this.field3202, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3208 += (long)var8;
         }

         if(-1L != this.field3206 * -1L) {
            if(this.field3206 * -1L > this.field3208 && var3 > 0) {
               var8 = var2 + (int)(this.field3206 * -1L - this.field3208);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3208;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3206 * -1L >= var4 && this.field3206 * -1L < (long)var7 + var4) {
               var14 = this.field3206 * -1L;
            } else if(var4 >= this.field3206 * -1L && var4 < (long)(this.field3201 * 1668340111) + this.field3206 * -1L) {
               var14 = var4;
            }

            if(this.field3206 * -1L + (long)(this.field3201 * 1668340111) > var4 && (long)(this.field3201 * 1668340111) + this.field3206 * -1L <= (long)var7 + var4) {
               var10 = this.field3206 * -1L + (long)(this.field3201 * 1668340111);
            } else if((long)var7 + var4 > this.field3206 * -1L && var4 + (long)var7 <= (long)(this.field3201 * 1668340111) + this.field3206 * -1L) {
               var10 = (long)var7 + var4;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3211, (int)(var14 - this.field3206 * -1L), var1, (int)(var14 - var4) + var2, var12);
               if(var10 > this.field3208) {
                  var3 = (int)((long)var3 - (var10 - this.field3208));
                  this.field3208 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field3203 = 1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("a")
   void method4194() throws IOException {
      this.field3204 = 0;
      if(this.field3208 != this.field3203 * -1L) {
         this.field3207.method4173(this.field3208);
         this.field3203 = this.field3208 * -1L;
      }

      int var1;
      for(this.field3205 = this.field3208 * -1L; this.field3204 < this.field3202.length; this.field3204 += var1) {
         var1 = this.field3207.method4177(this.field3202, this.field3204, this.field3202.length - this.field3204);
         if(-1 == var1) {
            break;
         }

         this.field3203 += (long)var1 * -1L;
      }

   }

   @ObfuscatedName("h")
   public void method4195(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3208 + (long)var3 > this.field3210) {
            this.field3210 = (long)var3 + this.field3208;
         }

         if(this.field3206 * -1L != -1L && (this.field3208 < this.field3206 * -1L || this.field3208 > this.field3206 * -1L + (long)(this.field3201 * 1668340111))) {
            this.method4207();
         }

         if(-1L != this.field3206 * -1L && this.field3208 + (long)var3 > this.field3206 * -1L + (long)this.field3211.length) {
            int var4 = (int)((long)this.field3211.length - (this.field3208 - this.field3206 * -1L));
            System.arraycopy(var1, var2, this.field3211, (int)(this.field3208 - this.field3206 * -1L), var4);
            this.field3208 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3201 = this.field3211.length * -1285544593;
            this.method4207();
         }

         if(var3 <= this.field3211.length) {
            if(var3 > 0) {
               if(-1L == this.field3206 * -1L) {
                  this.field3206 = this.field3208 * -1L;
               }

               System.arraycopy(var1, var2, this.field3211, (int)(this.field3208 - this.field3206 * -1L), var3);
               this.field3208 += (long)var3;
               if(this.field3208 - this.field3206 * -1L > (long)(this.field3201 * 1668340111)) {
                  this.field3201 = (int)(this.field3208 - this.field3206 * -1L) * -1285544593;
               }

            }
         } else {
            if(this.field3208 != this.field3203 * -1L) {
               this.field3207.method4173(this.field3208);
               this.field3203 = this.field3208 * -1L;
            }

            this.field3207.method4185(var1, var2, var3);
            this.field3203 += -1L * (long)var3;
            if(this.field3203 * -1L > this.field3209) {
               this.field3209 = this.field3203 * -1L;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3208 >= this.field3205 * -1L && this.field3208 < (long)this.field3204 + this.field3205 * -1L) {
               var10 = this.field3208;
            } else if(this.field3205 * -1L >= this.field3208 && this.field3205 * -1L < this.field3208 + (long)var3) {
               var10 = this.field3205 * -1L;
            }

            if((long)var3 + this.field3208 > this.field3205 * -1L && this.field3208 + (long)var3 <= (long)this.field3204 + this.field3205 * -1L) {
               var6 = this.field3208 + (long)var3;
            } else if((long)this.field3204 + this.field3205 * -1L > this.field3208 && this.field3205 * -1L + (long)this.field3204 <= this.field3208 + (long)var3) {
               var6 = this.field3205 * -1L + (long)this.field3204;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)(var10 + (long)var2 - this.field3208), this.field3202, (int)(var10 - this.field3205 * -1L), var8);
            }

            this.field3208 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3203 = 1L;
         throw var9;
      }
   }

   public class227(class226 var1, int var2, int var3) throws IOException {
      this.field3207 = var1;
      this.field3210 = this.field3209 = var1.method4176();
      this.field3202 = new byte[var2];
      this.field3211 = new byte[var3];
      this.field3208 = 0L;
   }

   @ObfuscatedName("i")
   void method4207() throws IOException {
      if(this.field3206 * -1L != -1L) {
         if(this.field3206 * -1L != this.field3203 * -1L) {
            this.field3207.method4173(this.field3206 * -1L);
            this.field3203 = this.field3206;
         }

         this.field3207.method4185(this.field3211, 0, this.field3201 * 1668340111);
         this.field3203 += -1668340111L * (long)this.field3201;
         if(this.field3203 * -1L > this.field3209) {
            this.field3209 = this.field3203 * -1L;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3206 * -1L >= this.field3205 * -1L && this.field3206 * -1L < this.field3205 * -1L + (long)this.field3204) {
            var1 = this.field3206 * -1L;
         } else if(this.field3205 * -1L >= this.field3206 * -1L && this.field3205 * -1L < this.field3206 * -1L + (long)(this.field3201 * 1668340111)) {
            var1 = this.field3205 * -1L;
         }

         if((long)(this.field3201 * 1668340111) + this.field3206 * -1L > this.field3205 * -1L && this.field3206 * -1L + (long)(this.field3201 * 1668340111) <= this.field3205 * -1L + (long)this.field3204) {
            var3 = this.field3206 * -1L + (long)(this.field3201 * 1668340111);
         } else if(this.field3205 * -1L + (long)this.field3204 > this.field3206 * -1L && this.field3205 * -1L + (long)this.field3204 <= (long)(this.field3201 * 1668340111) + this.field3206 * -1L) {
            var3 = (long)this.field3204 + this.field3205 * -1L;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3211, (int)(var1 - this.field3206 * -1L), this.field3202, (int)(var1 - this.field3205 * -1L), var5);
         }

         this.field3206 = 1L;
         this.field3201 = 0;
      }

   }
}
