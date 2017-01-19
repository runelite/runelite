import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class72 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6183027429238329571L
   )
   long field1174;
   @ObfuscatedName("c")
   byte[] field1175;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 2591105923439583809L
   )
   long field1176 = -1L;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -569476753
   )
   int field1178 = 0;
   @ObfuscatedName("s")
   FileOnDisk field1179;
   @ObfuscatedName("ep")
   static SpritePixels field1180;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1983828527766149087L
   )
   long field1181;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -2499090424552105955L
   )
   long field1182;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7185418193345669005L
   )
   long field1183;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      longValue = 1394275572758932387L
   )
   long field1185 = -1L;
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -1911461919
   )
   protected static int field1187;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1332688261
   )
   int field1188;
   @ObfuscatedName("a")
   byte[] field1190;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "40"
   )
   void method1343() throws IOException {
      if(this.field1185 != -1L) {
         if(this.field1174 != this.field1185) {
            this.field1179.method1377(this.field1185);
            this.field1174 = this.field1185;
         }

         this.field1179.method1396(this.field1190, 0, this.field1178);
         this.field1174 += -569476753L * (long)(this.field1178 * -1482357361);
         if(this.field1174 > this.field1182) {
            this.field1182 = this.field1174;
         }

         long var1 = -1L;
         long var3 = -1L;
         if(this.field1185 >= this.field1176 && this.field1185 < this.field1176 + (long)this.field1188) {
            var1 = this.field1185;
         } else if(this.field1176 >= this.field1185 && this.field1176 < this.field1185 + (long)this.field1178) {
            var1 = this.field1176;
         }

         if((long)this.field1178 + this.field1185 > this.field1176 && this.field1185 + (long)this.field1178 <= this.field1176 + (long)this.field1188) {
            var3 = this.field1185 + (long)this.field1178;
         } else if(this.field1176 + (long)this.field1188 > this.field1185 && (long)this.field1188 + this.field1176 <= (long)this.field1178 + this.field1185) {
            var3 = this.field1176 + (long)this.field1188;
         }

         if(var1 > -1L && var3 > var1) {
            int var5 = (int)(var3 - var1);
            System.arraycopy(this.field1190, (int)(var1 - this.field1185), this.field1175, (int)(var1 - this.field1176), var5);
         }

         this.field1185 = -1L;
         this.field1178 = 0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "371627703"
   )
   public long method1346() {
      return this.field1183;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "502345399"
   )
   public void method1347(byte[] var1) throws IOException {
      this.method1357(var1, 0, var1.length);
   }

   @ObfuscatedName("c")
   public void method1348(long var1) throws IOException {
      if(var1 < 0L) {
         throw new IOException("");
      } else {
         this.field1181 = var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1107479916"
   )
   void method1349() throws IOException {
      this.field1188 = 0;
      if(this.field1174 != this.field1181) {
         this.field1179.method1377(this.field1181);
         this.field1174 = this.field1181;
      }

      int var1;
      for(this.field1176 = this.field1181; this.field1188 < this.field1175.length; this.field1188 += var1) {
         var1 = this.field1179.method1380(this.field1175, this.field1188, this.field1175.length - this.field1188);
         if(var1 == -1) {
            break;
         }

         this.field1174 += (long)var1;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "80"
   )
   public void method1350(byte[] var1, int var2, int var3) throws IOException {
      try {
         if((long)var3 + this.field1181 > this.field1183) {
            this.field1183 = (long)var3 + this.field1181;
         }

         if(-1L != this.field1185 && (this.field1181 < this.field1185 || this.field1181 > this.field1185 + (long)this.field1178)) {
            this.method1343();
         }

         if(-1L != this.field1185 && (long)var3 + this.field1181 > (long)this.field1190.length + this.field1185) {
            int var4 = (int)((long)this.field1190.length - (this.field1181 - this.field1185));
            System.arraycopy(var1, var2, this.field1190, (int)(this.field1181 - this.field1185), var4);
            this.field1181 += (long)var4;
            var2 += var4;
            var3 -= var4;
            this.field1178 = this.field1190.length;
            this.method1343();
         }

         if(var3 <= this.field1190.length) {
            if(var3 > 0) {
               if(this.field1185 == -1L) {
                  this.field1185 = this.field1181;
               }

               System.arraycopy(var1, var2, this.field1190, (int)(this.field1181 - this.field1185), var3);
               this.field1181 += (long)var3;
               if(this.field1181 - this.field1185 > (long)this.field1178) {
                  this.field1178 = (int)(this.field1181 - this.field1185);
               }

            }
         } else {
            if(this.field1181 != this.field1174) {
               this.field1179.method1377(this.field1181);
               this.field1174 = this.field1181;
            }

            this.field1179.method1396(var1, var2, var3);
            this.field1174 += (long)var3;
            if(this.field1174 > this.field1182) {
               this.field1182 = this.field1174;
            }

            long var11 = -1L;
            long var6 = -1L;
            if(this.field1181 >= this.field1176 && this.field1181 < (long)this.field1188 + this.field1176) {
               var11 = this.field1181;
            } else if(this.field1176 >= this.field1181 && this.field1176 < (long)var3 + this.field1181) {
               var11 = this.field1176;
            }

            if((long)var3 + this.field1181 > this.field1176 && (long)var3 + this.field1181 <= (long)this.field1188 + this.field1176) {
               var6 = (long)var3 + this.field1181;
            } else if(this.field1176 + (long)this.field1188 > this.field1181 && (long)this.field1188 + this.field1176 <= this.field1181 + (long)var3) {
               var6 = (long)this.field1188 + this.field1176;
            }

            if(var11 > -1L && var6 > var11) {
               int var8 = (int)(var6 - var11);
               System.arraycopy(var1, (int)((long)var2 + var11 - this.field1181), this.field1175, (int)(var11 - this.field1176), var8);
            }

            this.field1181 += (long)var3;
         }
      } catch (IOException var10) {
         this.field1174 = -1L;
         throw var10;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "466121586"
   )
   public void method1357(byte[] var1, int var2, int var3) throws IOException {
      try {
         if(var3 + var2 > var1.length) {
            throw new ArrayIndexOutOfBoundsException(var2 + var3 - var1.length);
         }

         if(this.field1185 != -1L && this.field1181 >= this.field1185 && this.field1181 + (long)var3 <= (long)this.field1178 + this.field1185) {
            System.arraycopy(this.field1190, (int)(this.field1181 - this.field1185), var1, var2, var3);
            this.field1181 += (long)var3;
            return;
         }

         long var4 = this.field1181;
         int var7 = var3;
         int var8;
         if(this.field1181 >= this.field1176 && this.field1181 < (long)this.field1188 + this.field1176) {
            var8 = (int)((long)this.field1188 - (this.field1181 - this.field1176));
            if(var8 > var3) {
               var8 = var3;
            }

            System.arraycopy(this.field1175, (int)(this.field1181 - this.field1176), var1, var2, var8);
            this.field1181 += (long)var8;
            var2 += var8;
            var3 -= var8;
         }

         if(var3 > this.field1175.length) {
            this.field1179.method1377(this.field1181);

            for(this.field1174 = this.field1181; var3 > 0; var3 -= var8) {
               var8 = this.field1179.method1380(var1, var2, var3);
               if(var8 == -1) {
                  break;
               }

               this.field1174 += (long)var8;
               this.field1181 += (long)var8;
               var2 += var8;
            }
         } else if(var3 > 0) {
            this.method1349();
            var8 = var3;
            if(var3 > this.field1188) {
               var8 = this.field1188;
            }

            System.arraycopy(this.field1175, 0, var1, var2, var8);
            var2 += var8;
            var3 -= var8;
            this.field1181 += (long)var8;
         }

         if(-1L != this.field1185) {
            if(this.field1185 > this.field1181 && var3 > 0) {
               var8 = var2 + (int)(this.field1185 - this.field1181);
               if(var8 > var2 + var3) {
                  var8 = var3 + var2;
               }

               while(var2 < var8) {
                  var1[var2++] = 0;
                  --var3;
                  ++this.field1181;
               }
            }

            long var15 = -1L;
            long var10 = -1L;
            if(this.field1185 >= var4 && this.field1185 < (long)var7 + var4) {
               var15 = this.field1185;
            } else if(var4 >= this.field1185 && var4 < (long)this.field1178 + this.field1185) {
               var15 = var4;
            }

            if(this.field1185 + (long)this.field1178 > var4 && this.field1185 + (long)this.field1178 <= var4 + (long)var7) {
               var10 = (long)this.field1178 + this.field1185;
            } else if((long)var7 + var4 > this.field1185 && var4 + (long)var7 <= (long)this.field1178 + this.field1185) {
               var10 = (long)var7 + var4;
            }

            if(var15 > -1L && var10 > var15) {
               int var12 = (int)(var10 - var15);
               System.arraycopy(this.field1190, (int)(var15 - this.field1185), var1, (int)(var15 - var4) + var2, var12);
               if(var10 > this.field1181) {
                  var3 = (int)((long)var3 - (var10 - this.field1181));
                  this.field1181 = var10;
               }
            }
         }
      } catch (IOException var14) {
         this.field1174 = -1L;
         throw var14;
      }

      if(var3 > 0) {
         throw new EOFException();
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "47034150"
   )
   public void method1362() throws IOException {
      this.method1343();
      this.field1179.method1378();
   }

   @ObfuscatedSignature(
      signature = "(LFileOnDisk;II)V",
      garbageValue = "0"
   )
   public class72(FileOnDisk var1, int var2, int var3) throws IOException {
      this.field1179 = var1;
      long var10003 = var1.method1379();
      this.field1182 = var10003 * -2499090424552105955L;
      this.field1183 = var10003;
      this.field1175 = new byte[var2];
      this.field1190 = new byte[var3];
      this.field1181 = 0L;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lclass158;II)Lclass158;",
      garbageValue = "-1315169032"
   )
   public static class158 method1368(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod3916()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "1732248694"
   )
   public static String method1375(CharSequence var0) {
      String var1 = class142.method2609(class22.method186(var0));
      if(null == var1) {
         var1 = "";
      }

      return var1;
   }
}
