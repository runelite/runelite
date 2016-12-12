import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class72 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -5311494805039699409L
   )
   long field1180 = -1L;
   @ObfuscatedName("i")
   FileOnDisk field1181;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -1312962127991606087L
   )
   long field1182 = -1L;
   @ObfuscatedName("e")
   byte[] field1183;
   @ObfuscatedName("g")
   byte[] field1184;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -845845023
   )
   int field1185;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1399761245
   )
   int field1186 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -8821835675181388465L
   )
   long field1187;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8679909537273777761L
   )
   long field1188;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 4123173110925306899L
   )
   long field1189;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -1301244467921468199L
   )
   long field1190;
   @ObfuscatedName("jv")
   @ObfuscatedGetter(
      intValue = 47012819
   )
   static int field1191;

   @ObfuscatedName("e")
   public void method1356(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1187 = var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-197299266"
   )
   public void method1357() throws IOException {
      this.method1364();
      this.field1181.method1389();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-872975409"
   )
   public long method1359() {
      return this.field1189;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-16711936"
   )
   public void method1360(byte[] var1) throws IOException {
      this.method1361(var1, 0, var1.length);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-827316832"
   )
   public void method1361(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(-1L != this.field1180 && this.field1187 >= this.field1180 && (long)var3 + this.field1187 <= (long)this.field1186 + this.field1180) {
            System.arraycopy(this.field1184, (int)(this.field1187 - this.field1180), var1, var2, var3);
            this.field1187 += (long)var3;
            return;
         }

         long var4 = this.field1187;
         int var7 = var3;
         int var8;
         if(this.field1187 >= this.field1182 && this.field1187 < this.field1182 + (long)this.field1185) {
            var8 = (int)((long)this.field1185 - (this.field1187 - this.field1182));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1183, (int)(this.field1187 - this.field1182), var1, var2, var8);
            this.field1187 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1183.length) {
            this.field1181.method1391(this.field1187);

            for(this.field1190 = this.field1187; var3 > 0; var3 -= var8) {
               var8 = this.field1181.method1392(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1190 += (long)var8;
               this.field1187 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1362();
            var8 = var3;
            if(var3 > this.field1185) {
               var8 = this.field1185;
            }

            System.arraycopy(this.field1183, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1187 += (long)var8;
         }

         if(this.field1180 != -1L) {
            if(this.field1180 > this.field1187 && var3 > 0) {
               var8 = (int)(this.field1180 - this.field1187) + var2;
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1187;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field1180 >= var4 && this.field1180 < (long)var7 + var4) {
               var15 = this.field1180;
            } else if(var4 >= this.field1180 && var4 < (long)this.field1186 + this.field1180) {
               var15 = var4;
            }

            if((long)this.field1186 + this.field1180 > var4 && this.field1180 + (long)this.field1186 <= (long)var7 + var4) {
               var10 = (long)this.field1186 + this.field1180;
            } else if((long)var7 + var4 > this.field1180 && (long)var7 + var4 <= this.field1180 + (long)this.field1186) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field1184, (int)(var15 - this.field1180), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field1187) {
                  var3 = (int)((long)var3 - (var10 - this.field1187));
                  this.field1187 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field1190 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "250263986"
   )
   void method1362() throws IOException {
      this.field1185 = 0;
      if(this.field1187 != this.field1190) {
         this.field1181.method1391(this.field1187);
         this.field1190 = this.field1187;
      }

      int var1;
      for(this.field1182 = this.field1187; this.field1185 < this.field1183.length; this.field1185 += var1) {
         var1 = this.field1181.method1392(this.field1183, this.field1185, this.field1183.length - this.field1185);
         if(var1 == -1) {
            break;
         }

         this.field1190 += (long)var1;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1118695892"
   )
   void method1364() throws IOException {
      if(this.field1180 != -1L) {
         if(this.field1180 != this.field1190) {
            this.field1181.method1391(this.field1180);
            this.field1190 = this.field1180;
         }

         this.field1181.method1388(this.field1184, 0, this.field1186);
         this.field1190 += 1399761245L * (long)(this.field1186 * 555152117);
         if(this.field1190 > this.field1188) {
            this.field1188 = this.field1190;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1180 >= this.field1182 && this.field1180 < (long)this.field1185 + this.field1182) {
            var1 = this.field1180;
         } else if(this.field1182 >= this.field1180 && this.field1182 < this.field1180 + (long)this.field1186) {
            var1 = this.field1182;
         }

         if(this.field1180 + (long)this.field1186 > this.field1182 && this.field1180 + (long)this.field1186 <= (long)this.field1185 + this.field1182) {
            var3 = this.field1180 + (long)this.field1186;
         } else if((long)this.field1185 + this.field1182 > this.field1180 && this.field1182 + (long)this.field1185 <= (long)this.field1186 + this.field1180) {
            var3 = (long)this.field1185 + this.field1182;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1184, (int)(var1 - this.field1180), this.field1183, (int)(var1 - this.field1182), var5);
         }

         this.field1180 = -1L;
         this.field1186 = 0;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1755934648"
   )
   public void method1366(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1187 + (long)var3 > this.field1189) {
            this.field1189 = this.field1187 + (long)var3;
         }

         if(this.field1180 != -1L && (this.field1187 < this.field1180 || this.field1187 > this.field1180 + (long)this.field1186)) {
            this.method1364();
         }

         if(this.field1180 != -1L && this.field1187 + (long)var3 > (long)this.field1184.length + this.field1180) {
            int var4 = (int)((long)this.field1184.length - (this.field1187 - this.field1180));
            System.arraycopy(var1, var2, this.field1184, (int)(this.field1187 - this.field1180), var4);
            this.field1187 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1186 = this.field1184.length;
            this.method1364();
         }

         if(var3 <= this.field1184.length) {
            if(var3 > 0) {
               if(-1L == this.field1180) {
                  this.field1180 = this.field1187;
               }

               System.arraycopy(var1, var2, this.field1184, (int)(this.field1187 - this.field1180), var3);
               this.field1187 += (long)var3;
               if(this.field1187 - this.field1180 > (long)this.field1186) {
                  this.field1186 = (int)(this.field1187 - this.field1180);
               }

            }
         } else {
            if(this.field1190 != this.field1187) {
               this.field1181.method1391(this.field1187);
               this.field1190 = this.field1187;
            }

            this.field1181.method1388(var1, var2, var3);
            this.field1190 += (long)var3;
            if(this.field1190 > this.field1188) {
               this.field1188 = this.field1190;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field1187 >= this.field1182 && this.field1187 < (long)this.field1185 + this.field1182) {
               var11 = this.field1187;
            } else if(this.field1182 >= this.field1187 && this.field1182 < this.field1187 + (long)var3) {
               var11 = this.field1182;
            }

            if((long)var3 + this.field1187 > this.field1182 && (long)var3 + this.field1187 <= this.field1182 + (long)this.field1185) {
               var6 = (long)var3 + this.field1187;
            } else if(this.field1182 + (long)this.field1185 > this.field1187 && (long)this.field1185 + this.field1182 <= (long)var3 + this.field1187) {
               var6 = this.field1182 + (long)this.field1185;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)(var11 + (long)var2 - this.field1187), this.field1183, (int)(var11 - this.field1182), var8);
            }

            this.field1187 += (long)var3;
         }
      } catch (IOException var10) {
         this.field1190 = -1L;
         throw var10;
      }
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1181 = var1;
      this.field1189 = this.field1188 = var1.method1390();
      this.field1183 = new byte[var2];
      this.field1184 = new byte[var3];
      this.field1187 = 0L;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1697605065"
   )
   public static synchronized long method1385() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2108) {
         class155.field2109 += class155.field2108 - var0;
      }

      class155.field2108 = var0;
      return var0 + class155.field2109;
   }
}
