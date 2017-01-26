import java.awt.Component;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class72 {
   @ObfuscatedName("d")
   byte[] field1176;
   @ObfuscatedName("g")
   byte[] field1177;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -8013583937617003135L
   )
   long field1178 = -1L;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1306733639
   )
   int field1179;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1088719719
   )
   int field1180 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 6908086520270610499L
   )
   long field1181 = -1L;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      longValue = 6534174630721828291L
   )
   long field1183;
   @ObfuscatedName("p")
   FileOnDisk field1184;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      longValue = 1636065362604993959L
   )
   long field1185;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = 933263903053527277L
   )
   long field1186;
   @ObfuscatedName("ne")
   @ObfuscatedGetter(
      intValue = 22682085
   )
   static int field1187;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -4981462013163240571L
   )
   long field1188;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-349366030"
   )
   public void method1368() throws IOException {
      this.method1374();
      this.field1184.method1403();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1184 = var1;
      this.field1185 = this.field1186 = var1.method1418();
      this.field1177 = new byte[var2];
      this.field1176 = new byte[var3];
      this.field1183 = 0L;
   }

   @ObfuscatedName("g")
   public void method1369(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1183 = var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "498218905"
   )
   public void method1370(byte[] var1) throws IOException {
      this.method1371(var1, 0, var1.length);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "98438756"
   )
   public void method1371(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1181 && this.field1183 >= this.field1181 && this.field1183 + (long)var3 <= this.field1181 + (long)this.field1180) {
            System.arraycopy(this.field1176, (int)(this.field1183 - this.field1181), var1, var2, var3);
            this.field1183 += (long)var3;
            return;
         }

         long var4 = this.field1183;
         int var7 = var3;
         int var8;
         if(this.field1183 >= this.field1178 && this.field1183 < (long)this.field1179 + this.field1178) {
            var8 = (int)((long)this.field1179 - (this.field1183 - this.field1178));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1177, (int)(this.field1183 - this.field1178), var1, var2, var8);
            this.field1183 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1177.length) {
            this.field1184.method1404(this.field1183);

            for(this.field1188 = this.field1183; var3 > 0; var3 -= var8) {
               var8 = this.field1184.method1405(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1188 += (long)var8;
               this.field1183 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1372();
            var8 = var3;
            if(var3 > this.field1179) {
               var8 = this.field1179;
            }

            System.arraycopy(this.field1177, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1183 += (long)var8;
         }

         if(-1L != this.field1181) {
            if(this.field1181 > this.field1183 && var3 > 0) {
               var8 = var2 + (int)(this.field1181 - this.field1183);
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1183;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1181 >= var4 && this.field1181 < (long)var7 + var4) {
               var13 = this.field1181;
            } else if(var4 >= this.field1181 && var4 < this.field1181 + (long)this.field1180) {
               var13 = var4;
            }

            if((long)this.field1180 + this.field1181 > var4 && this.field1181 + (long)this.field1180 <= (long)var7 + var4) {
               var10 = (long)this.field1180 + this.field1181;
            } else if(var4 + (long)var7 > this.field1181 && var4 + (long)var7 <= this.field1181 + (long)this.field1180) {
               var10 = var4 + (long)var7;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1176, (int)(var13 - this.field1181), var1, var2 + (int)(var13 - var4), var12);
               if(var10 > this.field1183) {
                  var3 = (int)((long)var3 - (var10 - this.field1183));
                  this.field1183 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1188 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1407630627"
   )
   void method1372() throws IOException {
      this.field1179 = 0;
      if(this.field1188 != this.field1183) {
         this.field1184.method1404(this.field1183);
         this.field1188 = this.field1183;
      }

      int var1;
      for(this.field1178 = this.field1183; this.field1179 < this.field1177.length; this.field1179 += var1) {
         var1 = this.field1184.method1405(this.field1177, this.field1179, this.field1177.length - this.field1179);
         if(var1 == -1) {
            break;
         }

         this.field1188 += (long)var1;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "872722892"
   )
   public void method1373(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1183 + (long)var3 > this.field1185) {
            this.field1185 = (long)var3 + this.field1183;
         }

         if(this.field1181 != -1L && (this.field1183 < this.field1181 || this.field1183 > (long)this.field1180 + this.field1181)) {
            this.method1374();
         }

         if(this.field1181 != -1L && this.field1183 + (long)var3 > this.field1181 + (long)this.field1176.length) {
            int var4 = (int)((long)this.field1176.length - (this.field1183 - this.field1181));
            System.arraycopy(var1, var2, this.field1176, (int)(this.field1183 - this.field1181), var4);
            this.field1183 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1180 = this.field1176.length;
            this.method1374();
         }

         if(var3 <= this.field1176.length) {
            if(var3 > 0) {
               if(-1L == this.field1181) {
                  this.field1181 = this.field1183;
               }

               System.arraycopy(var1, var2, this.field1176, (int)(this.field1183 - this.field1181), var3);
               this.field1183 += (long)var3;
               if(this.field1183 - this.field1181 > (long)this.field1180) {
                  this.field1180 = (int)(this.field1183 - this.field1181);
               }

            }
         } else {
            if(this.field1188 != this.field1183) {
               this.field1184.method1404(this.field1183);
               this.field1188 = this.field1183;
            }

            this.field1184.method1402(var1, var2, var3);
            this.field1188 += (long)var3;
            if(this.field1188 > this.field1186) {
               this.field1186 = this.field1188;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1183 >= this.field1178 && this.field1183 < this.field1178 + (long)this.field1179) {
               var9 = this.field1183;
            } else if(this.field1178 >= this.field1183 && this.field1178 < this.field1183 + (long)var3) {
               var9 = this.field1178;
            }

            if((long)var3 + this.field1183 > this.field1178 && this.field1183 + (long)var3 <= (long)this.field1179 + this.field1178) {
               var6 = this.field1183 + (long)var3;
            } else if(this.field1178 + (long)this.field1179 > this.field1183 && this.field1178 + (long)this.field1179 <= this.field1183 + (long)var3) {
               var6 = this.field1178 + (long)this.field1179;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)((long)var2 + var9 - this.field1183), this.field1177, (int)(var9 - this.field1178), var8);
            }

            this.field1183 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1188 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-96"
   )
   void method1374() throws IOException {
      if(this.field1181 != -1L) {
         if(this.field1181 != this.field1188) {
            this.field1184.method1404(this.field1181);
            this.field1188 = this.field1181;
         }

         this.field1184.method1402(this.field1176, 0, this.field1180);
         this.field1188 += 1088719719L * (long)(this.field1180 * 1455579223);
         if(this.field1188 > this.field1186) {
            this.field1186 = this.field1188;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1181 >= this.field1178 && this.field1181 < (long)this.field1179 + this.field1178) {
            var1 = this.field1181;
         } else if(this.field1178 >= this.field1181 && this.field1178 < (long)this.field1180 + this.field1181) {
            var1 = this.field1178;
         }

         if(this.field1181 + (long)this.field1180 > this.field1178 && this.field1181 + (long)this.field1180 <= (long)this.field1179 + this.field1178) {
            var3 = (long)this.field1180 + this.field1181;
         } else if((long)this.field1179 + this.field1178 > this.field1181 && this.field1178 + (long)this.field1179 <= this.field1181 + (long)this.field1180) {
            var3 = (long)this.field1179 + this.field1178;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1176, (int)(var1 - this.field1181), this.field1177, (int)(var1 - this.field1178), var5);
         }

         this.field1181 = -1L;
         this.field1180 = 0;
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-1715845832"
   )
   static final void method1390(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1438[var6];
            int var9 = class84.field1452[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (256 + Client.mapScaleDelta);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method4154(var10 + var5.field2156 / 2 - var4.maxWidth / 2, var5.field2153 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2156, var5.field2153, var5.field2152, var5.field2150);
            } else {
               var4.method4144(var10 + var5.field2156 / 2 + var0 - var4.maxWidth / 2, var1 + var5.field2153 / 2 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1296458554"
   )
   public long method1393() {
      return this.field1185;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "2113299189"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "78"
   )
   public static void method1398(Component var0) {
      var0.removeMouseListener(class115.mouse);
      var0.removeMouseMotionListener(class115.mouse);
      var0.removeFocusListener(class115.mouse);
      class115.field1806 = 0;
   }
}
