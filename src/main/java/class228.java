import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
public class class228 {
   @ObfuscatedName("e")
   class227 field3218;
   @ObfuscatedName("w")
   byte[] field3219;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -7326987929213071941L
   )
   long field3220 = -1L;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -330242307459966811L
   )
   long field3222;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 3790235879725127465L
   )
   long field3223 = -1L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -129261547
   )
   int field3224;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -8429669894329452191L
   )
   long field3225;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -707069499
   )
   int field3226 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -1417518672427231197L
   )
   long field3227;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 7067049634005827101L
   )
   long field3228;
   @ObfuscatedName("p")
   byte[] field3229;

   @ObfuscatedName("w")
   public void method4135(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field3225 = var1;
      }
   }

   @ObfuscatedName("f")
   public long method4136() {
      return this.field3227;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-62"
   )
   public void method4137(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field3225 + (long)var3 > this.field3227) {
            this.field3227 = (long)var3 + this.field3225;
         }

         if(this.field3223 != -1L && (this.field3225 < this.field3223 || this.field3225 > (long)this.field3226 + this.field3223)) {
            this.method4149();
         }

         if(this.field3223 != -1L && this.field3225 + (long)var3 > (long)this.field3229.length + this.field3223) {
            int var4 = (int)((long)this.field3229.length - (this.field3225 - this.field3223));
            System.arraycopy(var1, var2, this.field3229, (int)(this.field3225 - this.field3223), var4);
            this.field3225 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field3226 = this.field3229.length;
            this.method4149();
         }

         if(var3 <= this.field3229.length) {
            if(var3 > 0) {
               if(-1L == this.field3223) {
                  this.field3223 = this.field3225;
               }

               System.arraycopy(var1, var2, this.field3229, (int)(this.field3225 - this.field3223), var3);
               this.field3225 += (long)var3;
               if(this.field3225 - this.field3223 > (long)this.field3226) {
                  this.field3226 = (int)(this.field3225 - this.field3223);
               }

            }
         } else {
            if(this.field3228 != this.field3225) {
               this.field3218.method4129(this.field3225);
               this.field3228 = this.field3225;
            }

            this.field3218.method4113(var1, var2, var3);
            this.field3228 += (long)var3;
            if(this.field3228 > this.field3222) {
               this.field3222 = this.field3228;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field3225 >= this.field3220 && this.field3225 < (long)this.field3224 + this.field3220) {
               var10 = this.field3225;
            } else if(this.field3220 >= this.field3225 && this.field3220 < this.field3225 + (long)var3) {
               var10 = this.field3220;
            }

            if(this.field3225 + (long)var3 > this.field3220 && this.field3225 + (long)var3 <= this.field3220 + (long)this.field3224) {
               var6 = (long)var3 + this.field3225;
            } else if(this.field3220 + (long)this.field3224 > this.field3225 && this.field3220 + (long)this.field3224 <= this.field3225 + (long)var3) {
               var6 = this.field3220 + (long)this.field3224;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field3225), this.field3219, (int)(var10 - this.field3220), var8);
            }

            this.field3225 += (long)var3;
         }
      } catch (IOException var9) {
         this.field3228 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-108362003"
   )
   public void method4138(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field3223 != -1L && this.field3225 >= this.field3223 && (long)var3 + this.field3225 <= (long)this.field3226 + this.field3223) {
            System.arraycopy(this.field3229, (int)(this.field3225 - this.field3223), var1, var2, var3);
            this.field3225 += (long)var3;
            return;
         }

         long var4 = this.field3225;
         int var7 = var3;
         int var8;
         if(this.field3225 >= this.field3220 && this.field3225 < (long)this.field3224 + this.field3220) {
            var8 = (int)((long)this.field3224 - (this.field3225 - this.field3220));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field3219, (int)(this.field3225 - this.field3220), var1, var2, var8);
            this.field3225 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field3219.length) {
            this.field3218.method4129(this.field3225);

            for(this.field3228 = this.field3225; var3 > 0; var3 -= var8) {
               var8 = this.field3218.method4121(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field3228 += (long)var8;
               this.field3225 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method4139();
            var8 = var3;
            if(var3 > this.field3224) {
               var8 = this.field3224;
            }

            System.arraycopy(this.field3219, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field3225 += (long)var8;
         }

         if(-1L != this.field3223) {
            if(this.field3223 > this.field3225 && var3 > 0) {
               var8 = var2 + (int)(this.field3223 - this.field3225);
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field3225;
               }
            }

            long var14 = -1L;
            long var10 = -1L;
            if(this.field3223 >= var4 && this.field3223 < var4 + (long)var7) {
               var14 = this.field3223;
            } else if(var4 >= this.field3223 && var4 < (long)this.field3226 + this.field3223) {
               var14 = var4;
            }

            if(this.field3223 + (long)this.field3226 > var4 && (long)this.field3226 + this.field3223 <= var4 + (long)var7) {
               var10 = (long)this.field3226 + this.field3223;
            } else if(var4 + (long)var7 > this.field3223 && var4 + (long)var7 <= this.field3223 + (long)this.field3226) {
               var10 = var4 + (long)var7;
            }

            if(var14 > -1L && var10 > var14) {
               int var12 = (int)(var10 - var14);
               System.arraycopy(this.field3229, (int)(var14 - this.field3223), var1, var2 + (int)(var14 - var4), var12);
               if(var10 > this.field3225) {
                  var3 = (int)((long)var3 - (var10 - this.field3225));
                  this.field3225 = var10;
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

   @ObfuscatedName("h")
   void method4139() throws IOException {
      this.field3224 = 0;
      if(this.field3225 != this.field3228) {
         this.field3218.method4129(this.field3225);
         this.field3228 = this.field3225;
      }

      int var1;
      for(this.field3220 = this.field3225; this.field3224 < this.field3219.length; this.field3224 += var1) {
         var1 = this.field3218.method4121(this.field3219, this.field3224, this.field3219.length - this.field3224);
         if(var1 == -1) {
            break;
         }

         this.field3228 += (long)var1;
      }

   }

   @ObfuscatedName("s")
   public void method4141(byte[] var1) throws IOException {
      this.method4138(var1, 0, var1.length);
   }

   public class228(class227 var1, int var2, int var3) throws IOException {
      this.field3218 = var1;
      this.field3227 = this.field3222 = var1.method4115();
      this.field3219 = new byte[var2];
      this.field3229 = new byte[var3];
      this.field3225 = 0L;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "38484402"
   )
   void method4149() throws IOException {
      if(-1L != this.field3223) {
         if(this.field3228 != this.field3223) {
            this.field3218.method4129(this.field3223);
            this.field3228 = this.field3223;
         }

         this.field3218.method4113(this.field3229, 0, this.field3226);
         this.field3228 += -707069499L * (long)(this.field3226 * 1453202701);
         if(this.field3228 > this.field3222) {
            this.field3222 = this.field3228;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field3223 >= this.field3220 && this.field3223 < this.field3220 + (long)this.field3224) {
            var1 = this.field3223;
         } else if(this.field3220 >= this.field3223 && this.field3220 < this.field3223 + (long)this.field3226) {
            var1 = this.field3220;
         }

         if(this.field3223 + (long)this.field3226 > this.field3220 && this.field3223 + (long)this.field3226 <= this.field3220 + (long)this.field3224) {
            var3 = (long)this.field3226 + this.field3223;
         } else if((long)this.field3224 + this.field3220 > this.field3223 && this.field3220 + (long)this.field3224 <= (long)this.field3226 + this.field3223) {
            var3 = (long)this.field3224 + this.field3220;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field3229, (int)(var1 - this.field3223), this.field3219, (int)(var1 - this.field3220), var5);
         }

         this.field3223 = -1L;
         this.field3226 = 0;
      }

   }

   @ObfuscatedName("e")
   public void method4157() throws IOException {
      this.method4149();
      this.field3218.method4114();
   }
}
