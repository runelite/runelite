import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class72 {
   @ObfuscatedName("j")
   byte[] field1183;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 7505549761015424379L
   )
   long field1184 = -1L;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1360677933
   )
   int field1185;
   @ObfuscatedName("w")
   byte[] field1186;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -8142219664020511061L
   )
   long field1187 = -1L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 6029925395907081361L
   )
   long field1188;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 310594709352248933L
   )
   long field1189;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2038116531
   )
   int field1190 = 0;
   @ObfuscatedName("x")
   FileOnDisk field1191;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 8534357590186480935L
   )
   long field1192;
   @ObfuscatedName("px")
   public static class103 field1193;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 2306436238320474119L
   )
   long field1195;
   @ObfuscatedName("r")
   public static Buffer field1196;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "255972076"
   )
   public void method1444() throws IOException {
      this.method1457();
      this.field1191.method1479();
   }

   @ObfuscatedName("j")
   public void method1446(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1189 = var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "309794182"
   )
   public void method1448(byte[] var1) throws IOException {
      this.method1474(var1, 0, var1.length);
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1191 = var1;
      this.field1188 = this.field1195 = var1.method1480();
      this.field1183 = new byte[var2];
      this.field1186 = new byte[var3];
      this.field1189 = 0L;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   void method1449() throws IOException {
      this.field1185 = 0;
      if(this.field1189 != this.field1192) {
         this.field1191.method1477(this.field1189);
         this.field1192 = this.field1189;
      }

      int var1;
      for(this.field1184 = this.field1189; this.field1185 < this.field1183.length; this.field1185 += var1) {
         var1 = this.field1191.method1476(this.field1183, this.field1185, this.field1183.length - this.field1185);
         if(var1 == -1) {
            break;
         }

         this.field1192 += (long)var1;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "185135170"
   )
   public void method1450(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1189 > this.field1188) {
            this.field1188 = this.field1189 + (long)var3;
         }

         if(-1L != this.field1187 && (this.field1189 < this.field1187 || this.field1189 > this.field1187 + (long)this.field1190)) {
            this.method1457();
         }

         if(-1L != this.field1187 && (long)var3 + this.field1189 > this.field1187 + (long)this.field1186.length) {
            int var4 = (int)((long)this.field1186.length - (this.field1189 - this.field1187));
            System.arraycopy(var1, var2, this.field1186, (int)(this.field1189 - this.field1187), var4);
            this.field1189 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1190 = this.field1186.length;
            this.method1457();
         }

         if(var3 <= this.field1186.length) {
            if(var3 > 0) {
               if(this.field1187 == -1L) {
                  this.field1187 = this.field1189;
               }

               System.arraycopy(var1, var2, this.field1186, (int)(this.field1189 - this.field1187), var3);
               this.field1189 += (long)var3;
               if(this.field1189 - this.field1187 > (long)this.field1190) {
                  this.field1190 = (int)(this.field1189 - this.field1187);
               }

            }
         } else {
            if(this.field1189 != this.field1192) {
               this.field1191.method1477(this.field1189);
               this.field1192 = this.field1189;
            }

            this.field1191.method1481(var1, var2, var3);
            this.field1192 += (long)var3;
            if(this.field1192 > this.field1195) {
               this.field1195 = this.field1192;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1189 >= this.field1184 && this.field1189 < this.field1184 + (long)this.field1185) {
               var9 = this.field1189;
            } else if(this.field1184 >= this.field1189 && this.field1184 < this.field1189 + (long)var3) {
               var9 = this.field1184;
            }

            if((long)var3 + this.field1189 > this.field1184 && this.field1189 + (long)var3 <= this.field1184 + (long)this.field1185) {
               var6 = this.field1189 + (long)var3;
            } else if(this.field1184 + (long)this.field1185 > this.field1189 && (long)this.field1185 + this.field1184 <= this.field1189 + (long)var3) {
               var6 = (long)this.field1185 + this.field1184;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1189), this.field1183, (int)(var9 - this.field1184), var8);
            }

            this.field1189 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1192 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1354675293"
   )
   void method1457() throws IOException {
      if(this.field1187 != -1L) {
         if(this.field1192 != this.field1187) {
            this.field1191.method1477(this.field1187);
            this.field1192 = this.field1187;
         }

         this.field1191.method1481(this.field1186, 0, this.field1190);
         this.field1192 += 2038116531L * (long)(this.field1190 * -1114964357);
         if(this.field1192 > this.field1195) {
            this.field1195 = this.field1192;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1187 >= this.field1184 && this.field1187 < this.field1184 + (long)this.field1185) {
            var1 = this.field1187;
         } else if(this.field1184 >= this.field1187 && this.field1184 < this.field1187 + (long)this.field1190) {
            var1 = this.field1184;
         }

         if(this.field1187 + (long)this.field1190 > this.field1184 && this.field1187 + (long)this.field1190 <= this.field1184 + (long)this.field1185) {
            var3 = (long)this.field1190 + this.field1187;
         } else if((long)this.field1185 + this.field1184 > this.field1187 && this.field1184 + (long)this.field1185 <= (long)this.field1190 + this.field1187) {
            var3 = (long)this.field1185 + this.field1184;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1186, (int)(var1 - this.field1187), this.field1183, (int)(var1 - this.field1184), var5);
         }

         this.field1187 = -1L;
         this.field1190 = 0;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1087300883"
   )
   public long method1458() {
      return this.field1188;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1081569008"
   )
   public void method1474(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1187 != -1L && this.field1189 >= this.field1187 && this.field1189 + (long)var3 <= (long)this.field1190 + this.field1187) {
            System.arraycopy(this.field1186, (int)(this.field1189 - this.field1187), var1, var2, var3);
            this.field1189 += (long)var3;
            return;
         }

         long var4 = this.field1189;
         int var7 = var3;
         int var8;
         if(this.field1189 >= this.field1184 && this.field1189 < this.field1184 + (long)this.field1185) {
            var8 = (int)((long)this.field1185 - (this.field1189 - this.field1184));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1183, (int)(this.field1189 - this.field1184), var1, var2, var8);
            this.field1189 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1183.length) {
            this.field1191.method1477(this.field1189);

            for(this.field1192 = this.field1189; var3 > 0; var3 -= var8) {
               var8 = this.field1191.method1476(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1192 += (long)var8;
               this.field1189 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1449();
            var8 = var3;
            if(var3 > this.field1185) {
               var8 = this.field1185;
            }

            System.arraycopy(this.field1183, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1189 += (long)var8;
         }

         if(this.field1187 != -1L) {
            if(this.field1187 > this.field1189 && var3 > 0) {
               var8 = (int)(this.field1187 - this.field1189) + var2;
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1189;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1187 >= var4 && this.field1187 < (long)var7 + var4) {
               var13 = this.field1187;
            } else if(var4 >= this.field1187 && var4 < (long)this.field1190 + this.field1187) {
               var13 = var4;
            }

            if(this.field1187 + (long)this.field1190 > var4 && (long)this.field1190 + this.field1187 <= var4 + (long)var7) {
               var10 = this.field1187 + (long)this.field1190;
            } else if((long)var7 + var4 > this.field1187 && (long)var7 + var4 <= (long)this.field1190 + this.field1187) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1186, (int)(var13 - this.field1187), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1189) {
                  var3 = (int)((long)var3 - (var10 - this.field1189));
                  this.field1189 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1192 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }
}
