import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class72 {
   @ObfuscatedName("x")
   FileOnDisk field1192;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = 1488588877
   )
   protected static int field1193;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -7386068124192975351L
   )
   long field1194;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 256873321
   )
   int field1195;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 247404847897193419L
   )
   long field1196 = -1L;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1417127219
   )
   int field1197 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 2415319581379627573L
   )
   long field1198;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = -3431323141139525315L
   )
   long field1199;
   @ObfuscatedName("y")
   byte[] field1200;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = -4628198586183037679L
   )
   long field1201;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 4666757469556927523L
   )
   long field1204 = -1L;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = 1120809171
   )
   static int field1205;
   @ObfuscatedName("n")
   byte[] field1206;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "100"
   )
   public void method1462(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field1204 && this.field1198 >= this.field1204 && this.field1198 + (long)var3 <= (long)this.field1197 + this.field1204) {
            System.arraycopy(this.field1200, (int)(this.field1198 - this.field1204), var1, var2, var3);
            this.field1198 += (long)var3;
            return;
         }

         long var4 = this.field1198;
         int var7 = var3;
         int var8;
         if(this.field1198 >= this.field1196 && this.field1198 < this.field1196 + (long)this.field1195) {
            var8 = (int)((long)this.field1195 - (this.field1198 - this.field1196));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1206, (int)(this.field1198 - this.field1196), var1, var2, var8);
            this.field1198 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1206.length) {
            this.field1192.method1486(this.field1198);

            for(this.field1201 = this.field1198; var3 > 0; var3 -= var8) {
               var8 = this.field1192.method1490(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1201 += (long)var8;
               this.field1198 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1473();
            var8 = var3;
            if(var3 > this.field1195) {
               var8 = this.field1195;
            }

            System.arraycopy(this.field1206, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1198 += (long)var8;
         }

         if(-1L != this.field1204) {
            if(this.field1204 > this.field1198 && var3 > 0) {
               var8 = var2 + (int)(this.field1204 - this.field1198);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1198;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1204 >= var4 && this.field1204 < var4 + (long)var7) {
               var13 = this.field1204;
            } else if(var4 >= this.field1204 && var4 < (long)this.field1197 + this.field1204) {
               var13 = var4;
            }

            if(this.field1204 + (long)this.field1197 > var4 && (long)this.field1197 + this.field1204 <= var4 + (long)var7) {
               var10 = this.field1204 + (long)this.field1197;
            } else if(var4 + (long)var7 > this.field1204 && (long)var7 + var4 <= this.field1204 + (long)this.field1197) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1200, (int)(var13 - this.field1204), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.field1198) {
                  var3 = (int)((long)var3 - (var10 - this.field1198));
                  this.field1198 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1201 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-22540"
   )
   public void method1463() throws IOException {
      this.method1465();
      this.field1192.method1488();
   }

   @ObfuscatedName("n")
   public void method1464(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1198 = var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "33"
   )
   void method1465() throws IOException {
      if(this.field1204 != -1L) {
         if(this.field1204 != this.field1201) {
            this.field1192.method1486(this.field1204);
            this.field1201 = this.field1204;
         }

         this.field1192.method1495(this.field1200, 0, this.field1197);
         this.field1201 += (long)(this.field1197 * -560144901) * 1417127219L;
         if(this.field1201 > this.field1199) {
            this.field1199 = this.field1201;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1204 >= this.field1196 && this.field1204 < this.field1196 + (long)this.field1195) {
            var1 = this.field1204;
         } else if(this.field1196 >= this.field1204 && this.field1196 < this.field1204 + (long)this.field1197) {
            var1 = this.field1196;
         }

         if((long)this.field1197 + this.field1204 > this.field1196 && (long)this.field1197 + this.field1204 <= this.field1196 + (long)this.field1195) {
            var3 = (long)this.field1197 + this.field1204;
         } else if(this.field1196 + (long)this.field1195 > this.field1204 && (long)this.field1195 + this.field1196 <= this.field1204 + (long)this.field1197) {
            var3 = (long)this.field1195 + this.field1196;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1200, (int)(var1 - this.field1204), this.field1206, (int)(var1 - this.field1196), var5);
         }

         this.field1204 = -1L;
         this.field1197 = 0;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1589909195"
   )
   public void method1466(byte[] var1) throws IOException {
      this.method1462(var1, 0, var1.length);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "397637288"
   )
   void method1473() throws IOException {
      this.field1195 = 0;
      if(this.field1198 != this.field1201) {
         this.field1192.method1486(this.field1198);
         this.field1201 = this.field1198;
      }

      int var1;
      for(this.field1196 = this.field1198; this.field1195 < this.field1206.length; this.field1195 += var1) {
         var1 = this.field1192.method1490(this.field1206, this.field1195, this.field1206.length - this.field1195);
         if(var1 == -1) {
            break;
         }

         this.field1201 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1192 = var1;
      this.field1194 = this.field1199 = var1.method1489();
      this.field1206 = new byte[var2];
      this.field1200 = new byte[var3];
      this.field1198 = 0L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "2"
   )
   public long method1478() {
      return this.field1194;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2030109657"
   )
   public void method1481(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1198 > this.field1194) {
            this.field1194 = (long)var3 + this.field1198;
         }

         if(this.field1204 != -1L && (this.field1198 < this.field1204 || this.field1198 > (long)this.field1197 + this.field1204)) {
            this.method1465();
         }

         if(-1L != this.field1204 && (long)var3 + this.field1198 > this.field1204 + (long)this.field1200.length) {
            int var4 = (int)((long)this.field1200.length - (this.field1198 - this.field1204));
            System.arraycopy(var1, var2, this.field1200, (int)(this.field1198 - this.field1204), var4);
            this.field1198 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1197 = this.field1200.length;
            this.method1465();
         }

         if(var3 <= this.field1200.length) {
            if(var3 > 0) {
               if(this.field1204 == -1L) {
                  this.field1204 = this.field1198;
               }

               System.arraycopy(var1, var2, this.field1200, (int)(this.field1198 - this.field1204), var3);
               this.field1198 += (long)var3;
               if(this.field1198 - this.field1204 > (long)this.field1197) {
                  this.field1197 = (int)(this.field1198 - this.field1204);
               }

            }
         } else {
            if(this.field1201 != this.field1198) {
               this.field1192.method1486(this.field1198);
               this.field1201 = this.field1198;
            }

            this.field1192.method1495(var1, var2, var3);
            this.field1201 += (long)var3;
            if(this.field1201 > this.field1199) {
               this.field1199 = this.field1201;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1198 >= this.field1196 && this.field1198 < this.field1196 + (long)this.field1195) {
               var9 = this.field1198;
            } else if(this.field1196 >= this.field1198 && this.field1196 < this.field1198 + (long)var3) {
               var9 = this.field1196;
            }

            if((long)var3 + this.field1198 > this.field1196 && (long)var3 + this.field1198 <= this.field1196 + (long)this.field1195) {
               var6 = this.field1198 + (long)var3;
            } else if(this.field1196 + (long)this.field1195 > this.field1198 && this.field1196 + (long)this.field1195 <= (long)var3 + this.field1198) {
               var6 = this.field1196 + (long)this.field1195;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1198), this.field1206, (int)(var9 - this.field1196), var8);
            }

            this.field1198 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1201 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LModIcon;",
      garbageValue = "-1667929095"
   )
   static ModIcon method1484(class182 var0, int var1, int var2) {
      if(!class137.method2556(var0, var1, var2)) {
         return null;
      } else {
         ModIcon var4 = new ModIcon();
         var4.width = class225.field3234;
         var4.originalHeight = class0.field2;
         var4.offsetX = class225.field3236[0];
         var4.offsetY = class145.field2013[0];
         var4.originalWidth = class186.field2775[0];
         var4.height = class225.field3235[0];
         var4.palette = class225.field3237;
         var4.pixels = Ignore.field211[0];
         WallObject.method1986();
         return var4;
      }
   }
}
