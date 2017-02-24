import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class72 {
   @ObfuscatedName("f")
   static String[] field1191;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1732770869
   )
   int field1192 = 0;
   @ObfuscatedName("d")
   byte[] field1193;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1271332591
   )
   int field1194;
   @ObfuscatedName("j")
   byte[] field1195;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 1759242123506542655L
   )
   long field1196 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 8708656130651006721L
   )
   long field1198;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -6798284278136573467L
   )
   long field1199;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 6119512683104940867L
   )
   long field1200;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 4554586030906319747L
   )
   long field1201;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -2914364668553689261L
   )
   long field1202 = -1L;
   @ObfuscatedName("q")
   FileOnDisk field1203;
   @ObfuscatedName("mz")
   static class24[] field1204;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3457"
   )
   public void method1430() throws IOException {
      this.method1447();
      this.field1203.method1475();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)LModIcon;",
      garbageValue = "0"
   )
   public static ModIcon method1431(class182 var0, String var1, String var2) {
      int var3 = var0.method3335(var1);
      int var4 = var0.method3319(var3, var2);
      ModIcon var5;
      if(!class94.method1979(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class165.method3168();
      }

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1527857537"
   )
   void method1435() throws IOException {
      this.field1194 = 0;
      if(this.field1198 != this.field1201) {
         this.field1203.method1468(this.field1198);
         this.field1201 = this.field1198;
      }

      int var1;
      for(this.field1202 = this.field1198; this.field1194 < this.field1193.length; this.field1194 += var1) {
         var1 = this.field1203.method1472(this.field1193, this.field1194, this.field1193.length - this.field1194);
         if(var1 == -1) {
            break;
         }

         this.field1201 += (long)var1;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-128"
   )
   public void method1436(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1198 + (long)var3 > this.field1200) {
            this.field1200 = this.field1198 + (long)var3;
         }

         if(this.field1196 != -1L && (this.field1198 < this.field1196 || this.field1198 > (long)this.field1192 + this.field1196)) {
            this.method1447();
         }

         if(-1L != this.field1196 && (long)var3 + this.field1198 > this.field1196 + (long)this.field1195.length) {
            int var4 = (int)((long)this.field1195.length - (this.field1198 - this.field1196));
            System.arraycopy(var1, var2, this.field1195, (int)(this.field1198 - this.field1196), var4);
            this.field1198 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1192 = this.field1195.length;
            this.method1447();
         }

         if(var3 <= this.field1195.length) {
            if(var3 > 0) {
               if(this.field1196 == -1L) {
                  this.field1196 = this.field1198;
               }

               System.arraycopy(var1, var2, this.field1195, (int)(this.field1198 - this.field1196), var3);
               this.field1198 += (long)var3;
               if(this.field1198 - this.field1196 > (long)this.field1192) {
                  this.field1192 = (int)(this.field1198 - this.field1196);
               }

            }
         } else {
            if(this.field1201 != this.field1198) {
               this.field1203.method1468(this.field1198);
               this.field1201 = this.field1198;
            }

            this.field1203.method1469(var1, var2, var3);
            this.field1201 += (long)var3;
            if(this.field1201 > this.field1199) {
               this.field1199 = this.field1201;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1198 >= this.field1202 && this.field1198 < this.field1202 + (long)this.field1194) {
               var9 = this.field1198;
            } else if(this.field1202 >= this.field1198 && this.field1202 < (long)var3 + this.field1198) {
               var9 = this.field1202;
            }

            if((long)var3 + this.field1198 > this.field1202 && this.field1198 + (long)var3 <= this.field1202 + (long)this.field1194) {
               var6 = this.field1198 + (long)var3;
            } else if(this.field1202 + (long)this.field1194 > this.field1198 && this.field1202 + (long)this.field1194 <= this.field1198 + (long)var3) {
               var6 = (long)this.field1194 + this.field1202;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1198), this.field1193, (int)(var9 - this.field1202), var8);
            }

            this.field1198 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1201 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "86"
   )
   public void method1441(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1196 != -1L && this.field1198 >= this.field1196 && (long)var3 + this.field1198 <= (long)this.field1192 + this.field1196) {
            System.arraycopy(this.field1195, (int)(this.field1198 - this.field1196), var1, var2, var3);
            this.field1198 += (long)var3;
            return;
         }

         long var4 = this.field1198;
         int var7 = var3;
         int var8;
         if(this.field1198 >= this.field1202 && this.field1198 < this.field1202 + (long)this.field1194) {
            var8 = (int)((long)this.field1194 - (this.field1198 - this.field1202));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1193, (int)(this.field1198 - this.field1202), var1, var2, var8);
            this.field1198 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1193.length) {
            this.field1203.method1468(this.field1198);

            for(this.field1201 = this.field1198; var3 > 0; var3 -= var8) {
               var8 = this.field1203.method1472(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1201 += (long)var8;
               this.field1198 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1435();
            var8 = var3;
            if(var3 > this.field1194) {
               var8 = this.field1194;
            }

            System.arraycopy(this.field1193, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1198 += (long)var8;
         }

         if(-1L != this.field1196) {
            if(this.field1196 > this.field1198 && var3 > 0) {
               var8 = (int)(this.field1196 - this.field1198) + var2;
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1198;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1196 >= var4 && this.field1196 < var4 + (long)var7) {
               var13 = this.field1196;
            } else if(var4 >= this.field1196 && var4 < (long)this.field1192 + this.field1196) {
               var13 = var4;
            }

            if((long)this.field1192 + this.field1196 > var4 && this.field1196 + (long)this.field1192 <= (long)var7 + var4) {
               var10 = (long)this.field1192 + this.field1196;
            } else if((long)var7 + var4 > this.field1196 && (long)var7 + var4 <= this.field1196 + (long)this.field1192) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1195, (int)(var13 - this.field1196), var1, var2 + (int)(var13 - var4), var12);
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-51"
   )
   public void method1446(byte[] var1) throws IOException {
      this.method1441(var1, 0, var1.length);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "30262"
   )
   void method1447() throws IOException {
      if(-1L != this.field1196) {
         if(this.field1196 != this.field1201) {
            this.field1203.method1468(this.field1196);
            this.field1201 = this.field1196;
         }

         this.field1203.method1469(this.field1195, 0, this.field1192);
         this.field1201 += (long)(this.field1192 * 2026342883) * -1732770869L;
         if(this.field1201 > this.field1199) {
            this.field1199 = this.field1201;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1196 >= this.field1202 && this.field1196 < (long)this.field1194 + this.field1202) {
            var1 = this.field1196;
         } else if(this.field1202 >= this.field1196 && this.field1202 < (long)this.field1192 + this.field1196) {
            var1 = this.field1202;
         }

         if((long)this.field1192 + this.field1196 > this.field1202 && this.field1196 + (long)this.field1192 <= this.field1202 + (long)this.field1194) {
            var3 = this.field1196 + (long)this.field1192;
         } else if((long)this.field1194 + this.field1202 > this.field1196 && (long)this.field1194 + this.field1202 <= (long)this.field1192 + this.field1196) {
            var3 = (long)this.field1194 + this.field1202;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1195, (int)(var1 - this.field1196), this.field1193, (int)(var1 - this.field1202), var5);
         }

         this.field1196 = -1L;
         this.field1192 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1203 = var1;
      this.field1200 = this.field1199 = var1.method1477();
      this.field1193 = new byte[var2];
      this.field1195 = new byte[var3];
      this.field1198 = 0L;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "111"
   )
   public long method1452() {
      return this.field1200;
   }

   @ObfuscatedName("d")
   public void method1453(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1198 = var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "-1208868423"
   )
   public static void method1464(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1919 = 1;
      class167.field2182 = var0;
      class11.field130 = var1;
      class138.field1918 = var2;
      class1.field16 = var3;
      class165.field2163 = var4;
      FileOnDisk.field1209 = 10000;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "1120588593"
   )
   static final int method1465(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + (var1 & '\uff00') * var2 & 16711680) + (var3 * (var0 & 16711935) + var2 * (var1 & 16711935) & -16711936) >> 8;
   }
}
