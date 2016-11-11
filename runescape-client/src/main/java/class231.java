import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
public class class231 {
   @ObfuscatedName("t")
   static int[] field3268;
   @ObfuscatedName("h")
   byte[] field3269;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -8422847373847331313L
   )
   long field3270;
   @ObfuscatedName("i")
   FileOnDisk field3271;
   @ObfuscatedName("n")
   byte[] field3272;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1660776293
   )
   int field3273 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1605242109
   )
   int field3274;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -2364206949503058431L
   )
   long field3275;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 5130818497080670357L
   )
   long field3276;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -6169871811474824107L
   )
   long field3277 = -1L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = -7479719489544401941L
   )
   long field3278;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 3465959526152246637L
   )
   long field3279 = -1L;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1554457952"
   )
   public void method4173() throws IOException {
      this.method4180();
      this.field3271.method4156();
   }

   @ObfuscatedName("h")
   public void method4174(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3275 = var1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "65535"
   )
   public void method4176(byte[] var1) throws IOException {
      this.method4177(var1, 0, var1.length);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-10"
   )
   public void method4177(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field3277 && this.field3275 >= this.field3277 && this.field3275 + (long)var3 <= (long)this.field3273 + this.field3277) {
            System.arraycopy(this.field3272, (int)(this.field3275 - this.field3277), var1, var2, var3);
            this.field3275 += (long)var3;
            return;
         }

         long var4 = this.field3275;
         int var7 = var3;
         int var8;
         if(this.field3275 >= this.field3279 && this.field3275 < this.field3279 + (long)this.field3274) {
            var8 = (int)((long)this.field3274 - (this.field3275 - this.field3279));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3269, (int)(this.field3275 - this.field3279), var1, var2, var8);
            this.field3275 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3269.length) {
            this.field3271.method4154(this.field3275);

            for(this.field3278 = this.field3275; var3 > 0; var3 -= var8) {
               var8 = this.field3271.method4157(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3278 += (long)var8;
               this.field3275 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4178();
            var8 = var3;
            if(var3 > this.field3274) {
               var8 = this.field3274;
            }

            System.arraycopy(this.field3269, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3275 += (long)var8;
         }

         if(this.field3277 != -1L) {
            if(this.field3277 > this.field3275 && var3 > 0) {
               var8 = var2 + (int)(this.field3277 - this.field3275);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3275;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field3277 >= var4 && this.field3277 < (long)var7 + var4) {
               var15 = this.field3277;
            } else if(var4 >= this.field3277 && var4 < (long)this.field3273 + this.field3277) {
               var15 = var4;
            }

            if(this.field3277 + (long)this.field3273 > var4 && this.field3277 + (long)this.field3273 <= var4 + (long)var7) {
               var10 = this.field3277 + (long)this.field3273;
            } else if(var4 + (long)var7 > this.field3277 && (long)var7 + var4 <= this.field3277 + (long)this.field3273) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field3272, (int)(var15 - this.field3277), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field3275) {
                  var3 = (int)((long)var3 - (var10 - this.field3275));
                  this.field3275 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field3278 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "31"
   )
   void method4178() throws IOException {
      this.field3274 = 0;
      if(this.field3278 != this.field3275) {
         this.field3271.method4154(this.field3275);
         this.field3278 = this.field3275;
      }

      int var1;
      for(this.field3279 = this.field3275; this.field3274 < this.field3269.length; this.field3274 += var1) {
         var1 = this.field3271.method4157(this.field3269, this.field3274, this.field3269.length - this.field3274);
         if(var1 == -1) {
            break;
         }

         this.field3278 += (long)var1;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1996050586"
   )
   public void method4179(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field3275 > this.field3270) {
            this.field3270 = (long)var3 + this.field3275;
         }

         if(this.field3277 != -1L && (this.field3275 < this.field3277 || this.field3275 > this.field3277 + (long)this.field3273)) {
            this.method4180();
         }

         if(this.field3277 != -1L && (long)var3 + this.field3275 > (long)this.field3272.length + this.field3277) {
            int var4 = (int)((long)this.field3272.length - (this.field3275 - this.field3277));
            System.arraycopy(var1, var2, this.field3272, (int)(this.field3275 - this.field3277), var4);
            this.field3275 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3273 = this.field3272.length;
            this.method4180();
         }

         if(var3 <= this.field3272.length) {
            if(var3 > 0) {
               if(this.field3277 == -1L) {
                  this.field3277 = this.field3275;
               }

               System.arraycopy(var1, var2, this.field3272, (int)(this.field3275 - this.field3277), var3);
               this.field3275 += (long)var3;
               if(this.field3275 - this.field3277 > (long)this.field3273) {
                  this.field3273 = (int)(this.field3275 - this.field3277);
               }

            }
         } else {
            if(this.field3275 != this.field3278) {
               this.field3271.method4154(this.field3275);
               this.field3278 = this.field3275;
            }

            this.field3271.method4153(var1, var2, var3);
            this.field3278 += (long)var3;
            if(this.field3278 > this.field3276) {
               this.field3276 = this.field3278;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field3275 >= this.field3279 && this.field3275 < this.field3279 + (long)this.field3274) {
               var11 = this.field3275;
            } else if(this.field3279 >= this.field3275 && this.field3279 < (long)var3 + this.field3275) {
               var11 = this.field3279;
            }

            if((long)var3 + this.field3275 > this.field3279 && this.field3275 + (long)var3 <= (long)this.field3274 + this.field3279) {
               var6 = (long)var3 + this.field3275;
            } else if((long)this.field3274 + this.field3279 > this.field3275 && (long)this.field3274 + this.field3279 <= (long)var3 + this.field3275) {
               var6 = this.field3279 + (long)this.field3274;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field3275), this.field3269, (int)(var11 - this.field3279), var8);
            }

            this.field3275 += (long)var3;
         }
      } catch (IOException var10) {
         this.field3278 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method4180() throws IOException {
      if(-1L != this.field3277) {
         if(this.field3277 != this.field3278) {
            this.field3271.method4154(this.field3277);
            this.field3278 = this.field3277;
         }

         this.field3271.method4153(this.field3272, 0, this.field3273);
         this.field3278 += 1660776293L * (long)(this.field3273 * 66923117);
         if(this.field3278 > this.field3276) {
            this.field3276 = this.field3278;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3277 >= this.field3279 && this.field3277 < this.field3279 + (long)this.field3274) {
            var1 = this.field3277;
         } else if(this.field3279 >= this.field3277 && this.field3279 < (long)this.field3273 + this.field3277) {
            var1 = this.field3279;
         }

         if((long)this.field3273 + this.field3277 > this.field3279 && this.field3277 + (long)this.field3273 <= (long)this.field3274 + this.field3279) {
            var3 = (long)this.field3273 + this.field3277;
         } else if((long)this.field3274 + this.field3279 > this.field3277 && this.field3279 + (long)this.field3274 <= (long)this.field3273 + this.field3277) {
            var3 = this.field3279 + (long)this.field3274;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3272, (int)(var1 - this.field3277), this.field3269, (int)(var1 - this.field3279), var5);
         }

         this.field3277 = -1L;
         this.field3273 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "7945"
   )
   public long method4185() {
      return this.field3270;
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class231(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field3271 = var1;
      this.field3270 = this.field3276 = var1.method4160();
      this.field3269 = new byte[var2];
      this.field3272 = new byte[var3];
      this.field3275 = 0L;
   }
}
