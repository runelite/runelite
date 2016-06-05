import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class56 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -365267411
   )
   int field1183;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -398081897
   )
   public static int field1184;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = -1403294778693876335L
   )
   long field1185 = class124.method2746();
   @ObfuscatedName("q")
   boolean field1186 = true;
   @ObfuscatedName("l")
   class66 field1187;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -173351021
   )
   int field1188 = 0;
   @ObfuscatedName("as")
   class66[] field1189 = new class66[8];
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1523105505
   )
   int field1190;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -850890827
   )
   int field1191;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -6795571779525218583L
   )
   long field1192 = 0L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1932508391
   )
   int field1193 = 32;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1548144289
   )
   public static int field1194;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1051696927
   )
   int field1195 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = 1759924023551628215L
   )
   long field1196 = 0L;
   @ObfuscatedName("d")
   int[] field1197;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 132286667
   )
   int field1199 = 0;
   @ObfuscatedName("ff")
   @ObfuscatedGetter(
      intValue = -1803643213
   )
   static int field1200;
   @ObfuscatedName("ag")
   class66[] field1201 = new class66[8];
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -727045445
   )
   int field1203 = 0;
   @ObfuscatedName("rz")
   protected static String field1204;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "20"
   )
   public static int method1133(int var0) {
      var0 = (var0 >>> 1 & 1431655765) + (var0 & 1431655765);
      var0 = (var0 & 858993459) + (var0 >>> 2 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "437544869"
   )
   public final synchronized void method1134(class66 var1) {
      this.field1187 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "519758281"
   )
   public final void method1136() {
      this.field1186 = true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1071314735"
   )
   public final synchronized void method1137() {
      this.field1186 = true;

      try {
         this.vmethod1469();
      } catch (Exception var2) {
         this.vmethod1471();
         this.field1192 = class124.method2746() + 2000L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1387704398"
   )
   public final synchronized void method1138() {
      if(null != class109.field1912) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(class109.field1912.field1352[var2] == this) {
               class109.field1912.field1352[var2] = null;
            }

            if(class109.field1912.field1352[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class109.field1912.field1355 = true;

            while(class109.field1912.field1354) {
               class45.method926(50L);
            }

            class109.field1912 = null;
         }
      }

      this.vmethod1471();
      this.field1197 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1140(int[] var1, int var2) {
      int var3 = var2;
      if(class21.field575) {
         var3 = var2 << 1;
      }

      class120.method2693(var1, 0, var3);
      this.field1199 -= var2;
      if(this.field1187 != null && this.field1199 <= 0) {
         this.field1199 += field1194 >> 4;
         class23.method571(this.field1187);
         this.method1158(this.field1187, this.field1187.vmethod1421());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label141:
         for(var6 = 7; var5 != 0; --var6) {
            int var8;
            int var16;
            if(var6 < 0) {
               var16 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var16 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var16 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var16);
                  var10 = null;
                  class66 var11 = this.field1189[var16];

                  label135:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label135;
                        }

                        class65 var12 = var11.field1267;
                        if(var12 != null && var12.field1266 > var8) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1269;
                        } else {
                           var11.field1270 = true;
                           int var13 = var11.vmethod3678();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1266 += var13;
                           }

                           if(var4 >= this.field1193) {
                              break label141;
                           }

                           class66 var14 = var11.vmethod3695();
                           if(null != var14) {
                              for(int var15 = var11.field1268; var14 != null; var14 = var11.vmethod3677()) {
                                 this.method1158(var14, var15 * var14.vmethod1421() >> 8);
                              }
                           }

                           class66 var17 = var11.field1269;
                           var11.field1269 = null;
                           if(null == var10) {
                              this.field1189[var16] = var17;
                           } else {
                              var10.field1269 = var17;
                           }

                           if(null == var17) {
                              this.field1201[var16] = var10;
                           }

                           var11 = var17;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var7 = this.field1189[var6];
            class66[] var18 = this.field1189;
            this.field1201[var6] = null;

            for(var18[var6] = null; var7 != null; var7 = var10) {
               var10 = var7.field1269;
               var7.field1269 = null;
            }
         }
      }

      if(this.field1199 < 0) {
         this.field1199 = 0;
      }

      if(null != this.field1187) {
         this.field1187.vmethod3679(var1, 0, var2);
      }

      this.field1185 = class124.method2746();
   }

   @ObfuscatedName("i")
   void vmethod1476(int var1) throws Exception {
   }

   @ObfuscatedName("h")
   void vmethod1470() throws Exception {
   }

   @ObfuscatedName("z")
   void vmethod1471() {
   }

   @ObfuscatedName("r")
   void vmethod1469() throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "256"
   )
   final void method1148(int var1) {
      this.field1199 -= var1;
      if(this.field1199 < 0) {
         this.field1199 = 0;
      }

      if(this.field1187 != null) {
         this.field1187.vmethod3686(var1);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "42814877"
   )
   final void method1158(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1201[var3];
      if(null == var4) {
         this.field1189[var3] = var1;
      } else {
         var4.field1269 = var1;
      }

      this.field1201[var3] = var1;
      var1.field1268 = var2;
   }

   @ObfuscatedName("g")
   int vmethod1468() throws Exception {
      return this.field1183;
   }

   @ObfuscatedName("t")
   void vmethod1466(Component var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2074826229"
   )
   public final synchronized void method1186() {
      if(null != this.field1197) {
         long var1 = class124.method2746();

         try {
            if(0L != this.field1192) {
               if(var1 < this.field1192) {
                  return;
               }

               this.vmethod1476(this.field1183);
               this.field1192 = 0L;
               this.field1186 = true;
            }

            int var3 = this.vmethod1468();
            if(this.field1195 - var3 > this.field1203) {
               this.field1203 = this.field1195 - var3;
            }

            int var4 = this.field1191 + this.field1190;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1183) {
               this.field1183 += 1024;
               if(this.field1183 > 16384) {
                  this.field1183 = 16384;
               }

               this.vmethod1471();
               this.vmethod1476(this.field1183);
               var3 = 0;
               this.field1186 = true;
               if(var4 + 256 > this.field1183) {
                  var4 = this.field1183 - 256;
                  this.field1191 = var4 - this.field1190;
               }
            }

            while(var3 < var4) {
               this.method1140(this.field1197, 256);
               this.vmethod1470();
               var3 += 256;
            }

            if(var1 > this.field1196) {
               if(!this.field1186) {
                  if(this.field1203 == 0 && this.field1188 == 0) {
                     this.vmethod1471();
                     this.field1192 = 2000L + var1;
                     return;
                  }

                  this.field1191 = Math.min(this.field1188, this.field1203);
                  this.field1188 = this.field1203;
               } else {
                  this.field1186 = false;
               }

               this.field1203 = 0;
               this.field1196 = var1 + 2000L;
            }

            this.field1195 = var3;
         } catch (Exception var7) {
            this.vmethod1471();
            this.field1192 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1185) {
               var1 = this.field1185;
            }

            while(var1 > this.field1185 + 5000L) {
               this.method1148(256);
               this.field1185 += (long)(256000 / field1194);
            }
         } catch (Exception var6) {
            this.field1185 = var1;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;I)Ljava/lang/String;",
      garbageValue = "1381170319"
   )
   static String method1187(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof class148) {
         class148 var2 = (class148)var0;
         var1 = var2.field2256 + " | ";
         var0 = var2.field2261;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(null == var7) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-549269032"
   )
   static void method1188(int var0) {
      client.field495 = 0L;
      if(var0 >= 2) {
         client.field496 = true;
      } else {
         client.field496 = false;
      }

      class113.method2405();
      if(client.field462 >= 25) {
         class189.method3707();
      }

      class144.field2235 = true;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "1"
   )
   public static int method1189(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class171.field2744 + class171.field2750;
      return var3;
   }
}
