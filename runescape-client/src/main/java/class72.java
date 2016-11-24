import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class72 {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      longValue = 2434050897157722791L
   )
   long field1168;
   @ObfuscatedName("d")
   byte[] field1169;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -818645636081666467L
   )
   long field1170 = -1L;
   @ObfuscatedName("n")
   FileOnDisk field1171;
   @ObfuscatedName("w")
   byte[] field1172;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -7345221373002599921L
   )
   long field1173 = -1L;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 969693939
   )
   int field1174 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -6394541713832594977L
   )
   long field1178;
   @ObfuscatedName("y")
   static int[] field1179;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1281982785
   )
   int field1180;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = -1658221606658403873L
   )
   long field1181;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -7048413590179834201L
   )
   long field1182;

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1144935365"
   )
   static String method1406(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class48.method888(Widget.method2893(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class36.field772 != null) {
               var4 = class143.method2755(class36.field772.field1659);
               if(null != class36.field772.field1663) {
                  var4 = (String)class36.field772.field1663;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "45"
   )
   public long method1407() {
      return this.field1168;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "156054198"
   )
   public void method1408(byte[] var1) throws IOException {
      this.method1409(var1, 0, var1.length);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1617255518"
   )
   public void method1409(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var3 + var2 - var1.length);
         }

         if(this.field1173 != -1L && this.field1182 >= this.field1173 && (long)var3 + this.field1182 <= (long)this.field1174 + this.field1173) {
            System.arraycopy(this.field1172, (int)(this.field1182 - this.field1173), var1, var2, var3);
            this.field1182 += (long)var3;
            return;
         }

         long var4 = this.field1182;
         int var7 = var3;
         int var8;
         if(this.field1182 >= this.field1170 && this.field1182 < this.field1170 + (long)this.field1180) {
            var8 = (int)((long)this.field1180 - (this.field1182 - this.field1170));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1169, (int)(this.field1182 - this.field1170), var1, var2, var8);
            this.field1182 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1169.length) {
            this.field1171.method1459(this.field1182);

            for(this.field1178 = this.field1182; var3 > 0; var3 -= var8) {
               var8 = this.field1171.method1444(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1178 += (long)var8;
               this.field1182 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1410();
            var8 = var3;
            if(var3 > this.field1180) {
               var8 = this.field1180;
            }

            System.arraycopy(this.field1169, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1182 += (long)var8;
         }

         if(this.field1173 != -1L) {
            if(this.field1173 > this.field1182 && var3 > 0) {
               var8 = (int)(this.field1173 - this.field1182) + var2;
               if(var8 > var3 + var2) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1182;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field1173 >= var4 && this.field1173 < var4 + (long)var7) {
               var15 = this.field1173;
            } else if(var4 >= this.field1173 && var4 < (long)this.field1174 + this.field1173) {
               var15 = var4;
            }

            if((long)this.field1174 + this.field1173 > var4 && this.field1173 + (long)this.field1174 <= (long)var7 + var4) {
               var10 = (long)this.field1174 + this.field1173;
            } else if((long)var7 + var4 > this.field1173 && (long)var7 + var4 <= (long)this.field1174 + this.field1173) {
               var10 = var4 + (long)var7;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field1172, (int)(var15 - this.field1173), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field1182) {
                  var3 = (int)((long)var3 - (var10 - this.field1182));
                  this.field1182 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field1178 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "117"
   )
   void method1410() throws IOException {
      this.field1180 = 0;
      if(this.field1182 != this.field1178) {
         this.field1171.method1459(this.field1182);
         this.field1178 = this.field1182;
      }

      int var1;
      for(this.field1170 = this.field1182; this.field1180 < this.field1169.length; this.field1180 += var1) {
         var1 = this.field1171.method1444(this.field1169, this.field1180, this.field1169.length - this.field1180);
         if(var1 == -1) {
            break;
         }

         this.field1178 += (long)var1;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-805812892"
   )
   public void method1419(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1182 > this.field1168) {
            this.field1168 = (long)var3 + this.field1182;
         }

         if(-1L != this.field1173 && (this.field1182 < this.field1173 || this.field1182 > (long)this.field1174 + this.field1173)) {
            this.method1424();
         }

         if(this.field1173 != -1L && this.field1182 + (long)var3 > this.field1173 + (long)this.field1172.length) {
            int var4 = (int)((long)this.field1172.length - (this.field1182 - this.field1173));
            System.arraycopy(var1, var2, this.field1172, (int)(this.field1182 - this.field1173), var4);
            this.field1182 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1174 = this.field1172.length;
            this.method1424();
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
               this.field1171.method1459(this.field1182);
               this.field1178 = this.field1182;
            }

            this.field1171.method1441(var1, var2, var3);
            this.field1178 += (long)var3;
            if(this.field1178 > this.field1181) {
               this.field1181 = this.field1178;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field1182 >= this.field1170 && this.field1182 < (long)this.field1180 + this.field1170) {
               var11 = this.field1182;
            } else if(this.field1170 >= this.field1182 && this.field1170 < (long)var3 + this.field1182) {
               var11 = this.field1170;
            }

            if(this.field1182 + (long)var3 > this.field1170 && this.field1182 + (long)var3 <= (long)this.field1180 + this.field1170) {
               var6 = (long)var3 + this.field1182;
            } else if((long)this.field1180 + this.field1170 > this.field1182 && (long)this.field1180 + this.field1170 <= (long)var3 + this.field1182) {
               var6 = this.field1170 + (long)this.field1180;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field1182), this.field1169, (int)(var11 - this.field1170), var8);
            }

            this.field1182 += (long)var3;
         }
      } catch (IOException var10) {
         this.field1178 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1304427356"
   )
   void method1424() throws IOException {
      if(this.field1173 != -1L) {
         if(this.field1178 != this.field1173) {
            this.field1171.method1459(this.field1173);
            this.field1178 = this.field1173;
         }

         this.field1171.method1441(this.field1172, 0, this.field1174);
         this.field1178 += (long)(this.field1174 * 1732988475) * 969693939L;
         if(this.field1178 > this.field1181) {
            this.field1181 = this.field1178;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1173 >= this.field1170 && this.field1173 < (long)this.field1180 + this.field1170) {
            var1 = this.field1173;
         } else if(this.field1170 >= this.field1173 && this.field1170 < (long)this.field1174 + this.field1173) {
            var1 = this.field1170;
         }

         if((long)this.field1174 + this.field1173 > this.field1170 && this.field1173 + (long)this.field1174 <= (long)this.field1180 + this.field1170) {
            var3 = this.field1173 + (long)this.field1174;
         } else if(this.field1170 + (long)this.field1180 > this.field1173 && this.field1170 + (long)this.field1180 <= this.field1173 + (long)this.field1174) {
            var3 = this.field1170 + (long)this.field1180;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1172, (int)(var1 - this.field1173), this.field1169, (int)(var1 - this.field1170), var5);
         }

         this.field1173 = -1L;
         this.field1174 = 0;
      }

   }

   @ObfuscatedName("d")
   public void method1425(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1182 = var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2100477477"
   )
   public void method1427() throws IOException {
      this.method1424();
      this.field1171.method1442();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1171 = var1;
      this.field1168 = this.field1181 = var1.method1439();
      this.field1169 = new byte[var2];
      this.field1172 = new byte[var3];
      this.field1182 = 0L;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass152;B)V",
      garbageValue = "-4"
   )
   public static void method1437(class152 var0) {
      class210.field3108 = var0;
   }
}
