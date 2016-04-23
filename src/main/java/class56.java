import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class56 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1423846445
   )
   int field1159 = 32;
   @ObfuscatedName("n")
   int[] field1161;
   @ObfuscatedName("aq")
   class66[] field1162 = new class66[8];
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1330712305
   )
   int field1163 = 0;
   @ObfuscatedName("ab")
   class66[] field1164 = new class66[8];
   @ObfuscatedName("v")
   static int[] field1165;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1535550127
   )
   int field1166;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1969764371
   )
   int field1167;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 756985847
   )
   int field1169;
   @ObfuscatedName("l")
   class66 field1170;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1630361907
   )
   int field1171 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -5121428749129822701L
   )
   long field1172 = 0L;
   @ObfuscatedName("g")
   boolean field1173 = true;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -196059057
   )
   int field1175 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = 6210754665315880803L
   )
   long field1176 = class77.method1674();
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1355287851
   )
   int field1177 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -6520330201966906711L
   )
   long field1179 = 0L;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1645188265
   )
   public static int field1181;

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-974319714"
   )
   public final void method1176() {
      this.field1173 = true;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1119101525"
   )
   public final synchronized void method1178() {
      if(null != class124.field2011) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class124.field2011.field1331[var2]) {
               class124.field2011.field1331[var2] = null;
            }

            if(null != class124.field2011.field1331[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            class124.field2011.field1336 = true;

            while(class124.field2011.field1332) {
               class14.method170(50L);
            }

            class124.field2011 = null;
         }
      }

      this.vmethod1506();
      this.field1161 = null;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "923620896"
   )
   final void method1181(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1164[var3];
      if(null == var4) {
         this.field1162[var3] = var1;
      } else {
         var4.field1248 = var1;
      }

      this.field1164[var3] = var1;
      var1.field1247 = var2;
   }

   @ObfuscatedName("j")
   void vmethod1521(Component var1) throws Exception {
   }

   @ObfuscatedName("h")
   void vmethod1503(int var1) throws Exception {
   }

   @ObfuscatedName("z")
   void vmethod1518() throws Exception {
   }

   @ObfuscatedName("x")
   void vmethod1506() {
   }

   @ObfuscatedName("e")
   void vmethod1507() throws Exception {
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-539695058"
   )
   public final synchronized void method1189(class66 var1) {
      this.field1170 = var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-950640368"
   )
   public final synchronized void method1198() {
      this.field1173 = true;

      try {
         this.vmethod1507();
      } catch (Exception var2) {
         this.vmethod1506();
         this.field1179 = class77.method1674() + 2000L;
      }

   }

   @ObfuscatedName("m")
   int vmethod1520() throws Exception {
      return this.field1169;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "256"
   )
   final void method1202(int var1) {
      this.field1175 -= var1;
      if(this.field1175 < 0) {
         this.field1175 = 0;
      }

      if(null != this.field1170) {
         this.field1170.vmethod3677(var1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "16740352"
   )
   static char method1210(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(221 == var0) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || 255 == var0) {
            return 'y';
         }
      }

      if(338 == var0) {
         return 'O';
      } else if(339 == var0) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "555985589"
   )
   public final synchronized void method1218() {
      if(null != this.field1161) {
         long var1 = class77.method1674();

         try {
            if(this.field1179 != 0L) {
               if(var1 < this.field1179) {
                  return;
               }

               this.vmethod1503(this.field1169);
               this.field1179 = 0L;
               this.field1173 = true;
            }

            int var3 = this.vmethod1520();
            if(this.field1171 - var3 > this.field1177) {
               this.field1177 = this.field1171 - var3;
            }

            int var4 = this.field1166 + this.field1167;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1169) {
               this.field1169 += 1024;
               if(this.field1169 > 16384) {
                  this.field1169 = 16384;
               }

               this.vmethod1506();
               this.vmethod1503(this.field1169);
               var3 = 0;
               this.field1173 = true;
               if(var4 + 256 > this.field1169) {
                  var4 = this.field1169 - 256;
                  this.field1167 = var4 - this.field1166;
               }
            }

            while(var3 < var4) {
               this.method1222(this.field1161, 256);
               this.vmethod1518();
               var3 += 256;
            }

            if(var1 > this.field1172) {
               if(!this.field1173) {
                  if(this.field1177 == 0 && 0 == this.field1163) {
                     this.vmethod1506();
                     this.field1179 = 2000L + var1;
                     return;
                  }

                  this.field1167 = Math.min(this.field1163, this.field1177);
                  this.field1163 = this.field1177;
               } else {
                  this.field1173 = false;
               }

               this.field1177 = 0;
               this.field1172 = 2000L + var1;
            }

            this.field1171 = var3;
         } catch (Exception var6) {
            this.vmethod1506();
            this.field1179 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1176) {
               var1 = this.field1176;
            }

            while(var1 > this.field1176 + 5000L) {
               this.method1202(256);
               this.field1176 += (long)(256000 / field1181);
            }
         } catch (Exception var5) {
            this.field1176 = var1;
         }

      }
   }

   @ObfuscatedName("cd")
   @ObfuscatedSignature(
      signature = "(IIII)Lclass3;",
      garbageValue = "345994173"
   )
   static final class3 method1219(int var0, int var1, int var2) {
      class3 var3 = new class3();
      var3.field65 = var1;
      var3.field64 = var2;
      client.field434.method3743(var3, (long)var0);
      class211.method3905(var1);
      class173 var4 = class141.method2959(var0);
      class2.method28(var4);
      if(null != client.field437) {
         class2.method28(client.field437);
         client.field437 = null;
      }

      class6.method101();
      class116.method2448(class173.field2735[var0 >> 16], var4, false);
      class95.method2181(var1);
      if(client.field433 != -1) {
         int var5 = client.field433;
         if(class107.method2374(var5)) {
            class4.method38(class173.field2735[var5], 1);
         }
      }

      return var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "118"
   )
   static void method1220(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field210.method3742((long)var0);
      if(var4 == null) {
         var4 = new class15();
         class15.field210.method3743(var4, (long)var0);
      }

      if(var4.field211.length <= var1) {
         int[] var5 = new int[var1 + 1];
         int[] var6 = new int[var1 + 1];

         int var7;
         for(var7 = 0; var7 < var4.field211.length; ++var7) {
            var5[var7] = var4.field211[var7];
            var6[var7] = var4.field212[var7];
         }

         for(var7 = var4.field211.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field211 = var5;
         var4.field212 = var6;
      }

      var4.field211[var1] = var2;
      var4.field212[var1] = var3;
   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-683150734"
   )
   static final void method1221(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = client.field346 + client.field521 & 2047;
         int var8 = class91.field1571[var7];
         int var9 = class91.field1572[var7];
         var8 = var8 * 256 / (256 + client.field479);
         var9 = var9 * 256 / (client.field479 + 256);
         int var10 = var9 * var2 + var8 * var3 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class151.field2239.method1693(var14 + 94 + var0 + 4 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         class48.method996(var0, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1222(int[] var1, int var2) {
      int var3 = var2;
      if(class113.field1944) {
         var3 = var2 << 1;
      }

      class120.method2722(var1, 0, var3);
      this.field1175 -= var2;
      if(this.field1170 != null && this.field1175 <= 0) {
         this.field1175 += field1181 >> 4;
         class26.method629(this.field1170);
         this.method1181(this.field1170, this.field1170.vmethod1459());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label140:
         for(var6 = 7; 0 != var5; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1162[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label134;
                        }

                        class65 var12 = var11.field1249;
                        if(null != var12 && var12.field1245 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1248;
                        } else {
                           var11.field1246 = true;
                           int var13 = var11.vmethod3675();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1245 += var13;
                           }

                           if(var4 >= this.field1159) {
                              break label140;
                           }

                           class66 var14 = var11.vmethod3673();
                           if(var14 != null) {
                              for(int var15 = var11.field1247; null != var14; var14 = var11.vmethod3674()) {
                                 this.method1181(var14, var15 * var14.vmethod1459() >> 8);
                              }
                           }

                           class66 var18 = var11.field1248;
                           var11.field1248 = null;
                           if(null == var10) {
                              this.field1162[var7] = var18;
                           } else {
                              var10.field1248 = var18;
                           }

                           if(null == var18) {
                              this.field1164[var7] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class66 var16 = this.field1162[var6];
            class66[] var17 = this.field1162;
            this.field1164[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1248;
               var16.field1248 = null;
            }
         }
      }

      if(this.field1175 < 0) {
         this.field1175 = 0;
      }

      if(this.field1170 != null) {
         this.field1170.vmethod3676(var1, 0, var2);
      }

      this.field1176 = class77.method1674();
   }
}
