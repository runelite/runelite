import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class227 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6482634559351393967L
   )
   long field3208;
   @ObfuscatedName("r")
   byte[] field3209;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2386217319909709009L
   )
   long field3210 = 1L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1928111699
   )
   int field3211;
   @ObfuscatedName("y")
   byte[] field3212;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -690743759805837643L
   )
   long field3213 = 1L;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1
   )
   int field3214 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -80662537440627493L
   )
   long field3215;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 4476387695488403511L
   )
   long field3216;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 4920163314257680133L
   )
   long field3217;
   @ObfuscatedName("a")
   class226 field3218;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-10"
   )
   public void method4171(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field3213 * -1L != -1L && this.field3215 >= this.field3213 * -1L && (long)var3 + this.field3215 <= this.field3213 * -1L + (long)(this.field3214 * -946538707)) {
            System.arraycopy(this.field3212, (int)(this.field3215 - this.field3213 * -1L), var1, var2, var3);
            this.field3215 += (long)var3;
            return;
         }

         long var4 = this.field3215;
         int var7 = var3;
         int var8;
         if(this.field3215 >= this.field3210 * -1L && this.field3215 < this.field3210 * -1L + (long)this.field3211) {
            var8 = (int)((long)this.field3211 - (this.field3215 - this.field3210 * -1L));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3209, (int)(this.field3215 - this.field3210 * -1L), var1, var2, var8);
            this.field3215 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3209.length) {
            this.field3218.method4153(this.field3215);

            for(this.field3217 = this.field3215 * -1L; var3 > 0; var3 -= var8) {
               var8 = this.field3218.method4157(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3217 += (long)var8 * -1L;
               this.field3215 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4177();
            var8 = var3;
            if(var3 > this.field3211) {
               var8 = this.field3211;
            }

            System.arraycopy(this.field3209, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3215 += (long)var8;
         }

         if(-1L != this.field3213 * -1L) {
            if(this.field3213 * -1L > this.field3215 && var3 > 0) {
               var8 = var2 + (int)(this.field3213 * -1L - this.field3215);
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3215;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3213 * -1L >= var4 && this.field3213 * -1L < var4 + (long)var7) {
               var14 = this.field3213 * -1L;
            } else if(var4 >= this.field3213 * -1L && var4 < this.field3213 * -1L + (long)(this.field3214 * -946538707)) {
               var14 = var4;
            }

            if(this.field3213 * -1L + (long)(this.field3214 * -946538707) > var4 && (long)(this.field3214 * -946538707) + this.field3213 * -1L <= (long)var7 + var4) {
               var10 = this.field3213 * -1L + (long)(this.field3214 * -946538707);
            } else if((long)var7 + var4 > this.field3213 * -1L && var4 + (long)var7 <= (long)(this.field3214 * -946538707) + this.field3213 * -1L) {
               var10 = var4 + (long)var7;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3212, (int)(var14 - this.field3213 * -1L), var1, (int)(var14 - var4) + var2, var12);
               if(var10 > this.field3215) {
                  var3 = (int)((long)var3 - (var10 - this.field3215));
                  this.field3215 = var10;
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

   @ObfuscatedName("a")
   public void method4172() throws IOException {
      this.method4179();
      this.field3218.method4168();
   }

   @ObfuscatedName("r")
   public void method4173(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3215 = var1;
      }
   }

   @ObfuscatedName("f")
   public long method4174() {
      return this.field3216;
   }

   @ObfuscatedName("s")
   public void method4175(byte[] var1) throws IOException {
      this.method4171(var1, 0, var1.length);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-611546586"
   )
   void method4177() throws IOException {
      this.field3211 = 0;
      if(this.field3215 != this.field3217 * -1L) {
         this.field3218.method4153(this.field3215);
         this.field3217 = this.field3215 * -1L;
      }

      int var1;
      for(this.field3210 = this.field3215 * -1L; this.field3211 < this.field3209.length; this.field3211 += var1) {
         var1 = this.field3218.method4157(this.field3209, this.field3211, this.field3209.length - this.field3211);
         if(-1 == var1) {
            break;
         }

         this.field3217 += (long)var1 * -1L;
      }

   }

   public class227(class226 var1, int var2, int var3) throws IOException {
      this.field3218 = var1;
      this.field3216 = this.field3208 = var1.method4156();
      this.field3209 = new byte[var2];
      this.field3212 = new byte[var3];
      this.field3215 = 0L;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-571394639"
   )
   void method4179() throws IOException {
      if(-1L != this.field3213 * -1L) {
         if(this.field3213 * -1L != this.field3217 * -1L) {
            this.field3218.method4153(this.field3213 * -1L);
            this.field3217 = this.field3213;
         }

         this.field3218.method4154(this.field3212, 0, this.field3214 * -946538707);
         this.field3217 += 946538707L * (long)this.field3214;
         if(this.field3217 * -1L > this.field3208) {
            this.field3208 = this.field3217 * -1L;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3213 * -1L >= this.field3210 * -1L && this.field3213 * -1L < (long)this.field3211 + this.field3210 * -1L) {
            var1 = this.field3213 * -1L;
         } else if(this.field3210 * -1L >= this.field3213 * -1L && this.field3210 * -1L < this.field3213 * -1L + (long)(this.field3214 * -946538707)) {
            var1 = this.field3210 * -1L;
         }

         if(this.field3213 * -1L + (long)(this.field3214 * -946538707) > this.field3210 * -1L && this.field3213 * -1L + (long)(this.field3214 * -946538707) <= (long)this.field3211 + this.field3210 * -1L) {
            var3 = (long)(this.field3214 * -946538707) + this.field3213 * -1L;
         } else if(this.field3210 * -1L + (long)this.field3211 > this.field3213 * -1L && this.field3210 * -1L + (long)this.field3211 <= this.field3213 * -1L + (long)(this.field3214 * -946538707)) {
            var3 = this.field3210 * -1L + (long)this.field3211;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3212, (int)(var1 - this.field3213 * -1L), this.field3209, (int)(var1 - this.field3210 * -1L), var5);
         }

         this.field3213 = 1L;
         this.field3214 = 0;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1672152382"
   )
   public void method4195(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3215 + (long)var3 > this.field3216) {
            this.field3216 = this.field3215 + (long)var3;
         }

         if(-1L != this.field3213 * -1L && (this.field3215 < this.field3213 * -1L || this.field3215 > this.field3213 * -1L + (long)(this.field3214 * -946538707))) {
            this.method4179();
         }

         if(this.field3213 * -1L != -1L && (long)var3 + this.field3215 > this.field3213 * -1L + (long)this.field3212.length) {
            int var4 = (int)((long)this.field3212.length - (this.field3215 - this.field3213 * -1L));
            System.arraycopy(var1, var2, this.field3212, (int)(this.field3215 - this.field3213 * -1L), var4);
            this.field3215 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3214 = this.field3212.length * 1809674405;
            this.method4179();
         }

         if(var3 <= this.field3212.length) {
            if(var3 > 0) {
               if(this.field3213 * -1L == -1L) {
                  this.field3213 = this.field3215 * -1L;
               }

               System.arraycopy(var1, var2, this.field3212, (int)(this.field3215 - this.field3213 * -1L), var3);
               this.field3215 += (long)var3;
               if(this.field3215 - this.field3213 * -1L > (long)(this.field3214 * -946538707)) {
                  this.field3214 = (int)(this.field3215 - this.field3213 * -1L) * 1809674405;
               }

            }
         } else {
            if(this.field3217 * -1L != this.field3215) {
               this.field3218.method4153(this.field3215);
               this.field3217 = this.field3215 * -1L;
            }

            this.field3218.method4154(var1, var2, var3);
            this.field3217 += -1L * (long)var3;
            if(this.field3217 * -1L > this.field3208) {
               this.field3208 = this.field3217 * -1L;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3215 >= this.field3210 * -1L && this.field3215 < this.field3210 * -1L + (long)this.field3211) {
               var10 = this.field3215;
            } else if(this.field3210 * -1L >= this.field3215 && this.field3210 * -1L < (long)var3 + this.field3215) {
               var10 = this.field3210 * -1L;
            }

            if((long)var3 + this.field3215 > this.field3210 * -1L && (long)var3 + this.field3215 <= (long)this.field3211 + this.field3210 * -1L) {
               var6 = this.field3215 + (long)var3;
            } else if(this.field3210 * -1L + (long)this.field3211 > this.field3215 && (long)this.field3211 + this.field3210 * -1L <= this.field3215 + (long)var3) {
               var6 = (long)this.field3211 + this.field3210 * -1L;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3215), this.field3209, (int)(var10 - this.field3210 * -1L), var8);
            }

            this.field3215 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3217 = 1L;
         throw var9;
      }
   }
}
