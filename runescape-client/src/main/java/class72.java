import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
public class class72 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = -5551216458635922329L
   )
   long field1178;
   @ObfuscatedName("m")
   byte[] field1179;
   @ObfuscatedName("h")
   byte[] field1180;
   @ObfuscatedName("o")
   FileOnDisk field1181;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = -7395343824369063751L
   )
   long field1182;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 8159035217336338843L
   )
   long field1183 = -1L;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -349536787
   )
   int field1184 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -768561503
   )
   int field1185;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -8487129638493450271L
   )
   long field1186;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = -2155337047440536421L
   )
   long field1188;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 6860470410639288817L
   )
   long field1191 = -1L;
   @ObfuscatedName("ir")
   static Widget field1192;

   @ObfuscatedName("m")
   public void method1353(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1182 = var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "916778793"
   )
   public long method1354() {
      return this.field1178;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1098635110"
   )
   public void method1356(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(-1L != this.field1183 && this.field1182 >= this.field1183 && this.field1182 + (long)var3 <= (long)this.field1184 + this.field1183) {
            System.arraycopy(this.field1180, (int)(this.field1182 - this.field1183), var1, var2, var3);
            this.field1182 += (long)var3;
            return;
         }

         long var4 = this.field1182;
         int var7 = var3;
         int var8;
         if(this.field1182 >= this.field1191 && this.field1182 < this.field1191 + (long)this.field1185) {
            var8 = (int)((long)this.field1185 - (this.field1182 - this.field1191));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1179, (int)(this.field1182 - this.field1191), var1, var2, var8);
            this.field1182 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1179.length) {
            this.field1181.method1388(this.field1182);

            for(this.field1188 = this.field1182; var3 > 0; var3 -= var8) {
               var8 = this.field1181.method1391(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1188 += (long)var8;
               this.field1182 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1368();
            var8 = var3;
            if(var3 > this.field1185) {
               var8 = this.field1185;
            }

            System.arraycopy(this.field1179, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1182 += (long)var8;
         }

         if(this.field1183 != -1L) {
            if(this.field1183 > this.field1182 && var3 > 0) {
               var8 = var2 + (int)(this.field1183 - this.field1182);
               if(var8 > var2 + var3) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1182;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field1183 >= var4 && this.field1183 < (long)var7 + var4) {
               var15 = this.field1183;
            } else if(var4 >= this.field1183 && var4 < this.field1183 + (long)this.field1184) {
               var15 = var4;
            }

            if(this.field1183 + (long)this.field1184 > var4 && (long)this.field1184 + this.field1183 <= var4 + (long)var7) {
               var10 = (long)this.field1184 + this.field1183;
            } else if(var4 + (long)var7 > this.field1183 && var4 + (long)var7 <= (long)this.field1184 + this.field1183) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field1180, (int)(var15 - this.field1183), var1, var2 + (int)(var15 - var4), var12);
               if(var10 > this.field1182) {
                  var3 = (int)((long)var3 - (var10 - this.field1182));
                  this.field1182 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field1188 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "278556837"
   )
   public void method1358(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1182 > this.field1178) {
            this.field1178 = this.field1182 + (long)var3;
         }

         if(-1L != this.field1183 && (this.field1182 < this.field1183 || this.field1182 > this.field1183 + (long)this.field1184)) {
            this.method1359();
         }

         if(this.field1183 != -1L && (long)var3 + this.field1182 > (long)this.field1180.length + this.field1183) {
            int var4 = (int)((long)this.field1180.length - (this.field1182 - this.field1183));
            System.arraycopy(var1, var2, this.field1180, (int)(this.field1182 - this.field1183), var4);
            this.field1182 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1184 = this.field1180.length;
            this.method1359();
         }

         if(var3 <= this.field1180.length) {
            if(var3 > 0) {
               if(this.field1183 == -1L) {
                  this.field1183 = this.field1182;
               }

               System.arraycopy(var1, var2, this.field1180, (int)(this.field1182 - this.field1183), var3);
               this.field1182 += (long)var3;
               if(this.field1182 - this.field1183 > (long)this.field1184) {
                  this.field1184 = (int)(this.field1182 - this.field1183);
               }

            }
         } else {
            if(this.field1182 != this.field1188) {
               this.field1181.method1388(this.field1182);
               this.field1188 = this.field1182;
            }

            this.field1181.method1387(var1, var2, var3);
            this.field1188 += (long)var3;
            if(this.field1188 > this.field1186) {
               this.field1186 = this.field1188;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field1182 >= this.field1191 && this.field1182 < (long)this.field1185 + this.field1191) {
               var11 = this.field1182;
            } else if(this.field1191 >= this.field1182 && this.field1191 < (long)var3 + this.field1182) {
               var11 = this.field1191;
            }

            if((long)var3 + this.field1182 > this.field1191 && this.field1182 + (long)var3 <= (long)this.field1185 + this.field1191) {
               var6 = (long)var3 + this.field1182;
            } else if((long)this.field1185 + this.field1191 > this.field1182 && (long)this.field1185 + this.field1191 <= (long)var3 + this.field1182) {
               var6 = this.field1191 + (long)this.field1185;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field1182), this.field1179, (int)(var11 - this.field1191), var8);
            }

            this.field1182 += (long)var3;
         }
      } catch (IOException var10) {
         this.field1188 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "49"
   )
   void method1359() throws IOException {
      if(this.field1183 != -1L) {
         if(this.field1183 != this.field1188) {
            this.field1181.method1388(this.field1183);
            this.field1188 = this.field1183;
         }

         this.field1181.method1387(this.field1180, 0, this.field1184);
         this.field1188 += -349536787L * (long)(this.field1184 * 557803493);
         if(this.field1188 > this.field1186) {
            this.field1186 = this.field1188;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1183 >= this.field1191 && this.field1183 < (long)this.field1185 + this.field1191) {
            var1 = this.field1183;
         } else if(this.field1191 >= this.field1183 && this.field1191 < this.field1183 + (long)this.field1184) {
            var1 = this.field1191;
         }

         if((long)this.field1184 + this.field1183 > this.field1191 && (long)this.field1184 + this.field1183 <= this.field1191 + (long)this.field1185) {
            var3 = (long)this.field1184 + this.field1183;
         } else if(this.field1191 + (long)this.field1185 > this.field1183 && (long)this.field1185 + this.field1191 <= this.field1183 + (long)this.field1184) {
            var3 = (long)this.field1185 + this.field1191;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1180, (int)(var1 - this.field1183), this.field1179, (int)(var1 - this.field1191), var5);
         }

         this.field1183 = -1L;
         this.field1184 = 0;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1614206560"
   )
   public void method1367() throws IOException {
      this.method1359();
      this.field1181.method1400();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   void method1368() throws IOException {
      this.field1185 = 0;
      if(this.field1188 != this.field1182) {
         this.field1181.method1388(this.field1182);
         this.field1188 = this.field1182;
      }

      int var1;
      for(this.field1191 = this.field1182; this.field1185 < this.field1179.length; this.field1185 += var1) {
         var1 = this.field1181.method1391(this.field1179, this.field1185, this.field1179.length - this.field1185);
         if(var1 == -1) {
            break;
         }

         this.field1188 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1181 = var1;
      long var10003 = var1.method1389();
      this.field1186 = var10003 * -8487129638493450271L;
      this.field1178 = var10003;
      this.field1179 = new byte[var2];
      this.field1180 = new byte[var3];
      this.field1182 = 0L;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-234424088"
   )
   public void method1381(byte[] var1) throws IOException {
      this.method1356(var1, 0, var1.length);
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1171296172"
   )
   static final String method1383(int var0) {
      String var1 = Integer.toString(var0);

      for(int var2 = var1.length() - 3; var2 > 0; var2 -= 3) {
         var1 = var1.substring(0, var2) + "," + var1.substring(var2);
      }

      return var1.length() > 9?" " + class16.method182('ﾀ') + var1.substring(0, var1.length() - 8) + "M" + " " + " (" + var1 + ")" + "</col>":(var1.length() > 6?" " + class16.method182(16777215) + var1.substring(0, var1.length() - 4) + "K" + " " + " (" + var1 + ")" + "</col>":" " + class16.method182(16776960) + var1 + "</col>");
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1953574278"
   )
   static final boolean method1384(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else {
         boolean var1 = var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
         if(var1) {
            return true;
         } else {
            char[] var2 = class204.field3073;

            int var3;
            char var4;
            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            var2 = class204.field3074;

            for(var3 = 0; var3 < var2.length; ++var3) {
               var4 = var2[var3];
               if(var4 == var0) {
                  return true;
               }
            }

            return false;
         }
      }
   }
}
