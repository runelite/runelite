import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
public class class72 {
   @ObfuscatedName("x")
   byte[] field1169;
   @ObfuscatedName("u")
   FileOnDisk field1170;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -753804405
   )
   int field1171;
   @ObfuscatedName("f")
   byte[] field1172;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -8306356363713647379L
   )
   long field1173 = -1L;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1104528531
   )
   int field1174 = 0;
   @ObfuscatedName("ad")
   static class102 field1175;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -4086655520996602049L
   )
   long field1176;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 4865812290908579065L
   )
   long field1177;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = -4587461545545511719L
   )
   long field1178;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2128647052361037071L
   )
   long field1179 = -1L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = -2842565589829403031L
   )
   long field1182;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-309292285"
   )
   public void method1334() throws IOException {
      this.method1358();
      this.field1170.method1365();
   }

   @ObfuscatedName("x")
   public void method1335(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1182 = var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1611366285"
   )
   public void method1337(byte[] var1) throws IOException {
      this.method1338(var1, 0, var1.length);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "76"
   )
   public void method1338(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1173 && this.field1182 >= this.field1173 && this.field1182 + (long)var3 <= (long)this.field1174 + this.field1173) {
            System.arraycopy(this.field1172, (int)(this.field1182 - this.field1173), var1, var2, var3);
            this.field1182 += (long)var3;
            return;
         }

         long var4 = this.field1182;
         int var6 = var3;
         int var7;
         if(this.field1182 >= this.field1179 && this.field1182 < this.field1179 + (long)this.field1171) {
            var7 = (int)((long)this.field1171 - (this.field1182 - this.field1179));
            if(var7 > var3) {
               var7 = var3;
            }

            System.arraycopy(this.field1169, (int)(this.field1182 - this.field1179), var1, var2, var7);
            this.field1182 += (long)var7;
            var2 += var7;
            var3 -= var7;
         }

         if(var3 > this.field1169.length) {
            this.field1170.method1369(this.field1182);

            for(this.field1178 = this.field1182; var3 > 0; var3 -= var7) {
               var7 = this.field1170.method1368(var1, var2, var3);
               if(var7 == -1) {
                  break;
               }

               this.field1178 += (long)var7;
               this.field1182 += (long)var7;
               var2 += var7;
            }
         } else if(var3 > 0) {
            this.method1339();
            var7 = var3;
            if(var3 > this.field1171) {
               var7 = this.field1171;
            }

            System.arraycopy(this.field1169, 0, var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.field1182 += (long)var7;
         }

         if(-1L != this.field1173) {
            if(this.field1173 > this.field1182 && var3 > 0) {
               var7 = (int)(this.field1173 - this.field1182) + var2;
               if(var7 > var2 + var3) {
                  var7 = var2 + var3;
               }

               while(var2 < var7) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1182;
               }
            }

            long var8 = -1L;
            long var10 = -1L;
            if(this.field1173 >= var4 && this.field1173 < var4 + (long)var6) {
               var8 = this.field1173;
            } else if(var4 >= this.field1173 && var4 < this.field1173 + (long)this.field1174) {
               var8 = var4;
            }

            if((long)this.field1174 + this.field1173 > var4 && (long)this.field1174 + this.field1173 <= (long)var6 + var4) {
               var10 = this.field1173 + (long)this.field1174;
            } else if(var4 + (long)var6 > this.field1173 && (long)var6 + var4 <= this.field1173 + (long)this.field1174) {
               var10 = var4 + (long)var6;
            }

            if(var8 > -1L && var10 > var8) {
               int var12 = (int)(var10 - var8);
               System.arraycopy(this.field1172, (int)(var8 - this.field1173), var1, var2 + (int)(var8 - var4), var12);
               if(var10 > this.field1182) {
                  var3 = (int)((long)var3 - (var10 - this.field1182));
                  this.field1182 = var10;
               }
            }
         }
      } catch (IOException var13) {
         this.field1178 = -1L;
         throw var13;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "66"
   )
   void method1339() throws IOException {
      this.field1171 = 0;
      if(this.field1182 != this.field1178) {
         this.field1170.method1369(this.field1182);
         this.field1178 = this.field1182;
      }

      int var1;
      for(this.field1179 = this.field1182; this.field1171 < this.field1169.length; this.field1171 += var1) {
         var1 = this.field1170.method1368(this.field1169, this.field1171, this.field1169.length - this.field1171);
         if(var1 == -1) {
            break;
         }

         this.field1178 += (long)var1;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1470836048"
   )
   public long method1341() {
      return this.field1177;
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1170 = var1;
      this.field1177 = this.field1176 = var1.method1367();
      this.field1169 = new byte[var2];
      this.field1172 = new byte[var3];
      this.field1182 = 0L;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1535763315"
   )
   void method1358() throws IOException {
      if(-1L != this.field1173) {
         if(this.field1173 != this.field1178) {
            this.field1170.method1369(this.field1173);
            this.field1178 = this.field1173;
         }

         this.field1170.method1375(this.field1172, 0, this.field1174);
         this.field1178 += -1104528531L * (long)(this.field1174 * 309986917);
         if(this.field1178 > this.field1176) {
            this.field1176 = this.field1178;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1173 >= this.field1179 && this.field1173 < (long)this.field1171 + this.field1179) {
            var1 = this.field1173;
         } else if(this.field1179 >= this.field1173 && this.field1179 < this.field1173 + (long)this.field1174) {
            var1 = this.field1179;
         }

         if(this.field1173 + (long)this.field1174 > this.field1179 && (long)this.field1174 + this.field1173 <= this.field1179 + (long)this.field1171) {
            var3 = this.field1173 + (long)this.field1174;
         } else if((long)this.field1171 + this.field1179 > this.field1173 && (long)this.field1171 + this.field1179 <= this.field1173 + (long)this.field1174) {
            var3 = (long)this.field1171 + this.field1179;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1172, (int)(var1 - this.field1173), this.field1169, (int)(var1 - this.field1179), var5);
         }

         this.field1173 = -1L;
         this.field1174 = 0;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-717015163"
   )
   public void method1360(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1182 + (long)var3 > this.field1177) {
            this.field1177 = (long)var3 + this.field1182;
         }

         if(this.field1173 != -1L && (this.field1182 < this.field1173 || this.field1182 > this.field1173 + (long)this.field1174)) {
            this.method1358();
         }

         if(-1L != this.field1173 && this.field1182 + (long)var3 > this.field1173 + (long)this.field1172.length) {
            int var4 = (int)((long)this.field1172.length - (this.field1182 - this.field1173));
            System.arraycopy(var1, var2, this.field1172, (int)(this.field1182 - this.field1173), var4);
            this.field1182 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1174 = this.field1172.length;
            this.method1358();
         }

         if(var3 <= this.field1172.length) {
            if(var3 > 0) {
               if(-1L == this.field1173) {
                  this.field1173 = this.field1182;
               }

               System.arraycopy(var1, var2, this.field1172, (int)(this.field1182 - this.field1173), var3);
               this.field1182 += (long)var3;
               if(this.field1182 - this.field1173 > (long)this.field1174) {
                  this.field1174 = (int)(this.field1182 - this.field1173);
               }
            }
         } else {
            if(this.field1178 != this.field1182) {
               this.field1170.method1369(this.field1182);
               this.field1178 = this.field1182;
            }

            this.field1170.method1375(var1, var2, var3);
            this.field1178 += (long)var3;
            if(this.field1178 > this.field1176) {
               this.field1176 = this.field1178;
            }

            long var10 = -1L;
            long var6 = -1L;
            if(this.field1182 >= this.field1179 && this.field1182 < this.field1179 + (long)this.field1171) {
               var10 = this.field1182;
            } else if(this.field1179 >= this.field1182 && this.field1179 < this.field1182 + (long)var3) {
               var10 = this.field1179;
            }

            if((long)var3 + this.field1182 > this.field1179 && this.field1182 + (long)var3 <= (long)this.field1171 + this.field1179) {
               var6 = this.field1182 + (long)var3;
            } else if(this.field1179 + (long)this.field1171 > this.field1182 && this.field1179 + (long)this.field1171 <= this.field1182 + (long)var3) {
               var6 = (long)this.field1171 + this.field1179;
            }

            if(var10 > -1L && var6 > var10) {
               int var8 = (int)(var6 - var10);
               System.arraycopy(var1, (int)((long)var2 + var10 - this.field1182), this.field1169, (int)(var10 - this.field1179), var8);
            }

            this.field1182 += (long)var3;
         }

      } catch (IOException var9) {
         this.field1178 = -1L;
         throw var9;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-1737191461"
   )
   static void method1361(File var0) {
      class107.field1715 = var0;
      if(!class107.field1715.exists()) {
         throw new RuntimeException("");
      } else {
         class107.field1717 = true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "835777340"
   )
   public static void method1362() {
      PlayerComposition.field2159.reset();
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1845193046"
   )
   static void method1363(int var0) {
      class9.field89 = new class38();
      class9.field89.field787 = Client.menuActionParams0[var0];
      class9.field89.field785 = Client.menuActionParams1[var0];
      class9.field89.field786 = Client.menuTypes[var0];
      class9.field89.field784 = Client.menuIdentifiers[var0];
      class9.field89.field790 = Client.menuOptions[var0];
   }
}
