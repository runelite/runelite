import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class72 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 6213882447823665233L
   )
   long field1157;
   @ObfuscatedName("c")
   byte[] field1158;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 8569881274903035423L
   )
   long field1159;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -8706966226618319547L
   )
   long field1160 = -1L;
   @ObfuscatedName("t")
   byte[] field1161;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 3971750956421509091L
   )
   long field1162 = -1L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1607317327
   )
   int field1163 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      longValue = 4475516050392417715L
   )
   long field1165;
   @ObfuscatedName("d")
   FileOnDisk field1166;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 5256187214606596999L
   )
   long field1167;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1398352205
   )
   int field1168;
   @ObfuscatedName("ik")
   @ObfuscatedGetter(
      intValue = 186416597
   )
   static int field1171;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-81"
   )
   public void method1394() throws IOException {
      this.method1400();
      this.field1166.method1425();
   }

   @ObfuscatedName("c")
   public void method1395(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1159 = var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "501633300"
   )
   public long method1396() {
      return this.field1157;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1585191463"
   )
   public void method1397(byte[] var1) throws IOException {
      this.method1401(var1, 0, var1.length);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-672075130"
   )
   void method1399() throws IOException {
      this.field1168 = 0;
      if(this.field1167 != this.field1159) {
         this.field1166.method1423(this.field1159);
         this.field1167 = this.field1159;
      }

      int var1;
      for(this.field1160 = this.field1159; this.field1168 < this.field1158.length; this.field1168 += var1) {
         var1 = this.field1166.method1427(this.field1158, this.field1168, this.field1158.length - this.field1168);
         if(var1 == -1) {
            break;
         }

         this.field1167 += (long)var1;
      }

   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1166 = var1;
      this.field1157 = this.field1165 = var1.method1438();
      this.field1158 = new byte[var2];
      this.field1161 = new byte[var3];
      this.field1159 = 0L;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2124952962"
   )
   void method1400() throws IOException {
      if(this.field1162 != -1L) {
         if(this.field1167 != this.field1162) {
            this.field1166.method1423(this.field1162);
            this.field1167 = this.field1162;
         }

         this.field1166.method1424(this.field1161, 0, this.field1163);
         this.field1167 += (long)(this.field1163 * -1464270929) * 1607317327L;
         if(this.field1167 > this.field1165) {
            this.field1165 = this.field1167;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1162 >= this.field1160 && this.field1162 < this.field1160 + (long)this.field1168) {
            var1 = this.field1162;
         } else if(this.field1160 >= this.field1162 && this.field1160 < (long)this.field1163 + this.field1162) {
            var1 = this.field1160;
         }

         if(this.field1162 + (long)this.field1163 > this.field1160 && this.field1162 + (long)this.field1163 <= this.field1160 + (long)this.field1168) {
            var3 = (long)this.field1163 + this.field1162;
         } else if((long)this.field1168 + this.field1160 > this.field1162 && (long)this.field1168 + this.field1160 <= this.field1162 + (long)this.field1163) {
            var3 = this.field1160 + (long)this.field1168;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1161, (int)(var1 - this.field1162), this.field1158, (int)(var1 - this.field1160), var5);
         }

         this.field1162 = -1L;
         this.field1163 = 0;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1527450078"
   )
   public void method1401(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var2 + var3 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1162 != -1L && this.field1159 >= this.field1162 && (long)var3 + this.field1159 <= this.field1162 + (long)this.field1163) {
            System.arraycopy(this.field1161, (int)(this.field1159 - this.field1162), var1, var2, var3);
            this.field1159 += (long)var3;
            return;
         }

         long var4 = this.field1159;
         int var7 = var3;
         int var8;
         if(this.field1159 >= this.field1160 && this.field1159 < (long)this.field1168 + this.field1160) {
            var8 = (int)((long)this.field1168 - (this.field1159 - this.field1160));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1158, (int)(this.field1159 - this.field1160), var1, var2, var8);
            this.field1159 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1158.length) {
            this.field1166.method1423(this.field1159);

            for(this.field1167 = this.field1159; var3 > 0; var3 -= var8) {
               var8 = this.field1166.method1427(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1167 += (long)var8;
               this.field1159 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1399();
            var8 = var3;
            if(var3 > this.field1168) {
               var8 = this.field1168;
            }

            System.arraycopy(this.field1158, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1159 += (long)var8;
         }

         if(this.field1162 != -1L) {
            if(this.field1162 > this.field1159 && var3 > 0) {
               var8 = var2 + (int)(this.field1162 - this.field1159);
               if(var8 > var3 + var2) {
                  var8 = var2 + var3;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1159;
               }
            }

            long var13 = -1L;
            long var10 = -1L;
            if(this.field1162 >= var4 && this.field1162 < var4 + (long)var7) {
               var13 = this.field1162;
            } else if(var4 >= this.field1162 && var4 < this.field1162 + (long)this.field1163) {
               var13 = var4;
            }

            if(this.field1162 + (long)this.field1163 > var4 && (long)this.field1163 + this.field1162 <= var4 + (long)var7) {
               var10 = this.field1162 + (long)this.field1163;
            } else if(var4 + (long)var7 > this.field1162 && var4 + (long)var7 <= this.field1162 + (long)this.field1163) {
               var10 = (long)var7 + var4;
            }

            if(var13 > -1L && var10 > var13) {
               int var12 = (int)(var10 - var13);
               System.arraycopy(this.field1161, (int)(var13 - this.field1162), var1, (int)(var13 - var4) + var2, var12);
               if(var10 > this.field1159) {
                  var3 = (int)((long)var3 - (var10 - this.field1159));
                  this.field1159 = var10;
               }
            }
         }
      } catch (IOException var16) {
         this.field1167 = -1L;
         throw var16;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "28"
   )
   public void method1415(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(this.field1159 + (long)var3 > this.field1157) {
            this.field1157 = this.field1159 + (long)var3;
         }

         if(-1L != this.field1162 && (this.field1159 < this.field1162 || this.field1159 > this.field1162 + (long)this.field1163)) {
            this.method1400();
         }

         if(this.field1162 != -1L && this.field1159 + (long)var3 > this.field1162 + (long)this.field1161.length) {
            int var4 = (int)((long)this.field1161.length - (this.field1159 - this.field1162));
            System.arraycopy(var1, var2, this.field1161, (int)(this.field1159 - this.field1162), var4);
            this.field1159 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1163 = this.field1161.length;
            this.method1400();
         }

         if(var3 <= this.field1161.length) {
            if(var3 > 0) {
               if(this.field1162 == -1L) {
                  this.field1162 = this.field1159;
               }

               System.arraycopy(var1, var2, this.field1161, (int)(this.field1159 - this.field1162), var3);
               this.field1159 += (long)var3;
               if(this.field1159 - this.field1162 > (long)this.field1163) {
                  this.field1163 = (int)(this.field1159 - this.field1162);
               }

            }
         } else {
            if(this.field1159 != this.field1167) {
               this.field1166.method1423(this.field1159);
               this.field1167 = this.field1159;
            }

            this.field1166.method1424(var1, var2, var3);
            this.field1167 += (long)var3;
            if(this.field1167 > this.field1165) {
               this.field1165 = this.field1167;
            }

            long var9 = -1L;
            long var6 = -1L;
            if(this.field1159 >= this.field1160 && this.field1159 < this.field1160 + (long)this.field1168) {
               var9 = this.field1159;
            } else if(this.field1160 >= this.field1159 && this.field1160 < (long)var3 + this.field1159) {
               var9 = this.field1160;
            }

            if(this.field1159 + (long)var3 > this.field1160 && (long)var3 + this.field1159 <= (long)this.field1168 + this.field1160) {
               var6 = (long)var3 + this.field1159;
            } else if((long)this.field1168 + this.field1160 > this.field1159 && this.field1160 + (long)this.field1168 <= this.field1159 + (long)var3) {
               var6 = this.field1160 + (long)this.field1168;
            }

            if(var9 > -1L && var6 > var9) {
               int var8 = (int)(var6 - var9);
               System.arraycopy(var1, (int)(var9 + (long)var2 - this.field1159), this.field1158, (int)(var9 - this.field1160), var8);
            }

            this.field1159 += (long)var3;
         }
      } catch (IOException var12) {
         this.field1167 = -1L;
         throw var12;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1247901665"
   )
   public static synchronized long method1421() {
      long var0 = System.currentTimeMillis();
      if(var0 < class131.field1972) {
         class131.field1973 += class131.field1972 - var0;
      }

      class131.field1972 = var0;
      return class131.field1973 + var0;
   }
}
