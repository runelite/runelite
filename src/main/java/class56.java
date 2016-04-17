import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class56 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -63682469
   )
   int field1183 = 32;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1123997099
   )
   int field1184 = 0;
   @ObfuscatedName("m")
   class66 field1185;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1271204125
   )
   int field1186 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -1095663065058436371L
   )
   long field1187 = class127.method2941();
   @ObfuscatedName("q")
   int[] field1188;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -469357223
   )
   int field1189;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1028766649
   )
   int field1190;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -8473855342870229515L
   )
   long field1191 = 0L;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -141802339
   )
   int field1192 = 0;
   @ObfuscatedName("s")
   boolean field1193 = true;
   @ObfuscatedName("ar")
   class66[] field1194 = new class66[8];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = 2369444703047271987L
   )
   long field1195 = 0L;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1426458157
   )
   int field1196 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -884477697
   )
   int field1197;
   @ObfuscatedName("k")
   static class72 field1198;
   @ObfuscatedName("ah")
   class66[] field1200 = new class66[8];
   @ObfuscatedName("ib")
   static class173 field1201;
   @ObfuscatedName("av")
   static class78[] field1204;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass66;B)V",
      garbageValue = "16"
   )
   public final synchronized void method1276(class66 var1) {
      this.field1185 = var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1711786766"
   )
   public final synchronized void method1277() {
      if(null != this.field1188) {
         long var1 = class127.method2941();

         try {
            if(this.field1191 != 0L) {
               if(var1 < this.field1191) {
                  return;
               }

               this.vmethod1615(this.field1197);
               this.field1191 = 0L;
               this.field1193 = true;
            }

            int var3 = this.vmethod1617();
            if(this.field1186 - var3 > this.field1192) {
               this.field1192 = this.field1186 - var3;
            }

            int var4 = this.field1190 + this.field1189;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1197) {
               this.field1197 += 1024;
               if(this.field1197 > 16384) {
                  this.field1197 = 16384;
               }

               this.vmethod1618();
               this.vmethod1615(this.field1197);
               var3 = 0;
               this.field1193 = true;
               if(256 + var4 > this.field1197) {
                  var4 = this.field1197 - 256;
                  this.field1190 = var4 - this.field1189;
               }
            }

            while(var3 < var4) {
               this.method1306(this.field1188, 256);
               this.vmethod1619();
               var3 += 256;
            }

            if(var1 > this.field1195) {
               if(!this.field1193) {
                  if(this.field1192 == 0 && this.field1184 == 0) {
                     this.vmethod1618();
                     this.field1191 = 2000L + var1;
                     return;
                  }

                  this.field1190 = Math.min(this.field1184, this.field1192);
                  this.field1184 = this.field1192;
               } else {
                  this.field1193 = false;
               }

               this.field1192 = 0;
               this.field1195 = 2000L + var1;
            }

            this.field1186 = var3;
         } catch (Exception var6) {
            this.vmethod1618();
            this.field1191 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1187) {
               var1 = this.field1187;
            }

            while(var1 > 5000L + this.field1187) {
               this.method1280(256);
               this.field1187 += (long)(256000 / class40.field973);
            }
         } catch (Exception var5) {
            this.field1187 = var1;
         }

      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass66;II)V",
      garbageValue = "2110560975"
   )
   final void method1278(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1200[var3];
      if(var4 == null) {
         this.field1194[var3] = var1;
      } else {
         var4.field1272 = var1;
      }

      this.field1200[var3] = var1;
      var1.field1273 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "256"
   )
   final void method1280(int var1) {
      this.field1196 -= var1;
      if(this.field1196 < 0) {
         this.field1196 = 0;
      }

      if(null != this.field1185) {
         this.field1185.vmethod3800(var1);
      }

   }

   @ObfuscatedName("k")
   void vmethod1621() throws Exception {
   }

   @ObfuscatedName("a")
   void vmethod1614(Component var1) throws Exception {
   }

   @ObfuscatedName("w")
   void vmethod1615(int var1) throws Exception {
   }

   @ObfuscatedName("d")
   int vmethod1617() throws Exception {
      return this.field1197;
   }

   @ObfuscatedName("c")
   void vmethod1619() throws Exception {
   }

   @ObfuscatedName("y")
   void vmethod1618() {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-975189953"
   )
   public final synchronized void method1303() {
      if(field1198 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1198.field1360[var2] == this) {
               field1198.field1360[var2] = null;
            }

            if(field1198.field1360[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1198.field1362 = true;

            while(field1198.field1358) {
               class4.method55(50L);
            }

            field1198 = null;
         }
      }

      this.vmethod1618();
      this.field1188 = null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-49"
   )
   public final void method1305() {
      this.field1193 = true;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1306(int[] var1, int var2) {
      int var3 = var2;
      if(class96.field1633) {
         var3 = var2 << 1;
      }

      class120.method2856(var1, 0, var3);
      this.field1196 -= var2;
      if(this.field1185 != null && this.field1196 <= 0) {
         this.field1196 += class40.field973 >> 4;
         class26.method720(this.field1185);
         this.method1278(this.field1185, this.field1185.vmethod1573());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label140:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if(var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; 0 != var9; var9 >>>= 4) {
               if(0 != (var9 & 1)) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1194[var7];

                  label134:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label134;
                        }

                        class65 var12 = var11.field1271;
                        if(null != var12 && var12.field1270 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1272;
                        } else {
                           var11.field1274 = true;
                           int var13 = var11.vmethod3810();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1270 += var13;
                           }

                           if(var4 >= this.field1183) {
                              break label140;
                           }

                           class66 var14 = var11.vmethod3806();
                           if(null != var14) {
                              for(int var15 = var11.field1273; null != var14; var14 = var11.vmethod3797()) {
                                 this.method1278(var14, var15 * var14.vmethod1573() >> 8);
                              }
                           }

                           class66 var18 = var11.field1272;
                           var11.field1272 = null;
                           if(null == var10) {
                              this.field1194[var7] = var18;
                           } else {
                              var10.field1272 = var18;
                           }

                           if(var18 == null) {
                              this.field1200[var7] = var10;
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
            class66 var16 = this.field1194[var6];
            class66[] var17 = this.field1194;
            this.field1200[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1272;
               var16.field1272 = null;
            }
         }
      }

      if(this.field1196 < 0) {
         this.field1196 = 0;
      }

      if(null != this.field1185) {
         this.field1185.vmethod3796(var1, 0, var2);
      }

      this.field1187 = class127.method2941();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1646349417"
   )
   public final synchronized void method1308() {
      this.field1193 = true;

      try {
         this.vmethod1621();
      } catch (Exception var2) {
         this.vmethod1618();
         this.field1191 = class127.method2941() + 2000L;
      }

   }
}
