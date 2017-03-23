import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class72 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 4885350045281609083L
   )
   long field1199 = -1L;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1806190361
   )
   int field1202;
   @ObfuscatedName("r")
   byte[] field1203;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 1151046678926547127L
   )
   long field1204 = -1L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1273298325
   )
   int field1205 = 0;
   @ObfuscatedName("i")
   byte[] field1206;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -546422704641058415L
   )
   long field1207;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -8464598803199593253L
   )
   long field1208;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -2378970190477564891L
   )
   long field1209;
   @ObfuscatedName("f")
   FileOnDisk field1212;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -3487437644089915183L
   )
   long field1213;

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   static final void method1413() {
      if(Client.field459 != Sequence.plane) {
         Client.field459 = Sequence.plane;
         class22.method203(Sequence.plane);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1789563406"
   )
   public long method1414() {
      return this.field1208;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "8"
   )
   public void method1415(byte[] var1) throws IOException {
      this.method1416(var1, 0, var1.length);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-656370548"
   )
   public void method1416(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1204 && this.field1213 >= this.field1204 && this.field1213 + (long)var3 <= (long)this.field1205 + this.field1204) {
            System.arraycopy(this.field1203, (int)(this.field1213 - this.field1204), var1, var2, var3);
            this.field1213 += (long)var3;
            return;
         }

         long var4 = this.field1213;
         int var7 = var3;
         int var8;
         if(this.field1213 >= this.field1199 && this.field1213 < this.field1199 + (long)this.field1202) {
            var8 = (int)((long)this.field1202 - (this.field1213 - this.field1199));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1206, (int)(this.field1213 - this.field1199), var1, var2, var8);
            this.field1213 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1206.length) {
            this.field1212.method1453(this.field1213);

            for(this.field1209 = this.field1213; var3 > 0; var3 -= var8) {
               var8 = this.field1212.method1450(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1209 += (long)var8;
               this.field1213 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1417();
            var8 = var3;
            if(var3 > this.field1202) {
               var8 = this.field1202;
            }

            System.arraycopy(this.field1206, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1213 += (long)var8;
         }

         if(this.field1204 != -1L) {
            if(this.field1204 > this.field1213 && var3 > 0) {
               var8 = var2 + (int)(this.field1204 - this.field1213);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1213;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1204 >= var4 && this.field1204 < var4 + (long)var7) {
               var13 = this.field1204;
            } else if(var4 >= this.field1204 && var4 < this.field1204 + (long)this.field1205) {
               var13 = var4;
            }

            if((long)this.field1205 + this.field1204 > var4 && (long)this.field1205 + this.field1204 <= var4 + (long)var7) {
               var10 = this.field1204 + (long)this.field1205;
            } else if(var4 + (long)var7 > this.field1204 && var4 + (long)var7 <= (long)this.field1205 + this.field1204) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1203, (int)(var13 - this.field1204), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1213) {
                  var3 = (int)((long)var3 - (var10 - this.field1213));
                  this.field1213 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1209 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1299360626"
   )
   void method1417() throws IOException {
      this.field1202 = 0;
      if(this.field1213 != this.field1209) {
         this.field1212.method1453(this.field1213);
         this.field1209 = this.field1213;
      }

      int var1;
      for(this.field1199 = this.field1213; this.field1202 < this.field1206.length; this.field1202 += var1) {
         var1 = this.field1212.method1450(this.field1206, this.field1202, this.field1206.length - this.field1202);
         if(var1 == -1) {
            break;
         }

         this.field1209 += (long)var1;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1527983723"
   )
   void method1419() throws IOException {
      if(this.field1204 != -1L) {
         if(this.field1204 != this.field1209) {
            this.field1212.method1453(this.field1204);
            this.field1209 = this.field1204;
         }

         this.field1212.method1447(this.field1203, 0, this.field1205);
         this.field1209 += (long)(this.field1205 * 1695638973) * 1273298325L;
         if(this.field1209 > this.field1207) {
            this.field1207 = this.field1209;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1204 >= this.field1199 && this.field1204 < this.field1199 + (long)this.field1202) {
            var1 = this.field1204;
         } else if(this.field1199 >= this.field1204 && this.field1199 < (long)this.field1205 + this.field1204) {
            var1 = this.field1199;
         }

         if((long)this.field1205 + this.field1204 > this.field1199 && this.field1204 + (long)this.field1205 <= this.field1199 + (long)this.field1202) {
            var3 = this.field1204 + (long)this.field1205;
         } else if((long)this.field1202 + this.field1199 > this.field1204 && (long)this.field1202 + this.field1199 <= (long)this.field1205 + this.field1204) {
            var3 = (long)this.field1202 + this.field1199;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1203, (int)(var1 - this.field1204), this.field1206, (int)(var1 - this.field1199), var5);
         }

         this.field1204 = -1L;
         this.field1205 = 0;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1212 = var1;
      this.field1208 = this.field1207 = var1.method1449();
      this.field1206 = new byte[var2];
      this.field1203 = new byte[var3];
      this.field1213 = 0L;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   public void method1435() throws IOException {
      this.method1419();
      this.field1212.method1448();
   }

   @ObfuscatedName("i")
   public void method1437(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1213 = var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1883740354"
   )
   public static int method1439(String var0) {
      return var0.length() + 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1702386045"
   )
   public static String method1440(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;
      int var5 = var1;

      int var8;
      for(int var6 = var2 + var1; var5 < var6; var3[var4++] = (char)var8) {
         int var7 = var0[var5++] & 255;
         if(var7 < 128) {
            if(var7 == 0) {
               var8 = '�';
            } else {
               var8 = var7;
            }
         } else if(var7 < 192) {
            var8 = '�';
         } else if(var7 < 224) {
            if(var5 < var6 && (var0[var5] & 192) == 128) {
               var8 = (var7 & 31) << 6 | var0[var5++] & 63;
               if(var8 < 128) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 240) {
            if(1 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[1 + var5] & 192) == 128) {
               var8 = (var7 & 15) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 < 2048) {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else if(var7 < 248) {
            if(2 + var5 < var6 && (var0[var5] & 192) == 128 && (var0[var5 + 1] & 192) == 128 && (var0[2 + var5] & 192) == 128) {
               var8 = (var7 & 7) << 18 | (var0[var5++] & 63) << 12 | (var0[var5++] & 63) << 6 | var0[var5++] & 63;
               if(var8 >= 65536 && var8 <= 1114111) {
                  var8 = '�';
               } else {
                  var8 = '�';
               }
            } else {
               var8 = '�';
            }
         } else {
            var8 = '�';
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-92"
   )
   static void method1441() {
      int var0 = GameEngine.field1792;
      int var1 = GameEngine.field1782;
      int var2 = CombatInfo1.field682 - class32.field755 - var0;
      int var3 = class33.field758 - class168.field2207 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field433.method2163();
            int var5 = 0;
            int var6 = 0;
            if(CollisionData.field1860 == var4) {
               Insets var7 = CollisionData.field1860.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class33.field758);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, CombatInfo1.field682, var1);
            }

            if(var2 > 0) {
               var9.fillRect(CombatInfo1.field682 + var5 - var2, var6, var2, class33.field758);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class33.field758 + var6 - var3, CombatInfo1.field682, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1017199961"
   )
   public void method1443(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1213 + (long)var3 > this.field1208) {
            this.field1208 = this.field1213 + (long)var3;
         }

         if(-1L != this.field1204 && (this.field1213 < this.field1204 || this.field1213 > (long)this.field1205 + this.field1204)) {
            this.method1419();
         }

         if(-1L != this.field1204 && this.field1213 + (long)var3 > (long)this.field1203.length + this.field1204) {
            int var4 = (int)((long)this.field1203.length - (this.field1213 - this.field1204));
            System.arraycopy(var1, var2, this.field1203, (int)(this.field1213 - this.field1204), var4);
            this.field1213 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1205 = this.field1203.length;
            this.method1419();
         }

         if(var3 <= this.field1203.length) {
            if(var3 > 0) {
               if(-1L == this.field1204) {
                  this.field1204 = this.field1213;
               }

               System.arraycopy(var1, var2, this.field1203, (int)(this.field1213 - this.field1204), var3);
               this.field1213 += (long)var3;
               if(this.field1213 - this.field1204 > (long)this.field1205) {
                  this.field1205 = (int)(this.field1213 - this.field1204);
               }

            }
         } else {
            if(this.field1213 != this.field1209) {
               this.field1212.method1453(this.field1213);
               this.field1209 = this.field1213;
            }

            this.field1212.method1447(var1, var2, var3);
            this.field1209 += (long)var3;
            if(this.field1209 > this.field1207) {
               this.field1207 = this.field1209;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1213 >= this.field1199 && this.field1213 < this.field1199 + (long)this.field1202) {
               var9 = this.field1213;
            } else if(this.field1199 >= this.field1213 && this.field1199 < this.field1213 + (long)var3) {
               var9 = this.field1199;
            }

            if(this.field1213 + (long)var3 > this.field1199 && (long)var3 + this.field1213 <= this.field1199 + (long)this.field1202) {
               var6 = this.field1213 + (long)var3;
            } else if(this.field1199 + (long)this.field1202 > this.field1213 && (long)this.field1202 + this.field1199 <= (long)var3 + this.field1213) {
               var6 = (long)this.field1202 + this.field1199;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.field1213), this.field1206, (int)(var9 - this.field1199), var8);
            }

            this.field1213 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1209 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-238022879"
   )
   static void method1444(String var0) {
      class156.field2133 = var0;

      try {
         String var1 = Client.field433.getParameter(class214.field3173.field3161);
         String var2 = Client.field433.getParameter(class214.field3174.field3161);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class44.method840(class45.method867() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class100.method1983(Client.field433, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
