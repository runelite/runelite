package net.runelite.rs.client;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
public class class56 {
   @ObfuscatedName("m")
   static class72 field1183;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1044836845
   )
   int field1184 = 0;
   @ObfuscatedName("k")
   class66 field1185;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -600137325
   )
   int field1186 = 32;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = -2022203506661983405L
   )
   long field1187 = class109.method2381();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1230930621
   )
   int field1188;
   @ObfuscatedName("am")
   class66[] field1189 = new class66[8];
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1826690001
   )
   int field1190;
   @ObfuscatedName("i")
   public static boolean field1191;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 280746305
   )
   int field1192 = 0;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 536607539
   )
   int field1193 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 2824008868917694997L
   )
   long field1194 = 0L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 5586675541763657281L
   )
   long field1195 = 0L;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1236511041
   )
   public static int field1196;
   @ObfuscatedName("w")
   boolean field1197 = true;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1818189639
   )
   int field1198 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 297578221
   )
   int field1199;
   @ObfuscatedName("n")
   int[] field1200;
   @ObfuscatedName("ap")
   static class142 field1201;
   @ObfuscatedName("ak")
   class66[] field1204 = new class66[8];

   @ObfuscatedName("e")
   public final synchronized void method1175() {
      if(this.field1200 != null) {
         long var1 = class109.method2381();

         try {
            if(0L != this.field1194) {
               if(var1 < this.field1194) {
                  return;
               }

               this.vmethod1502(this.field1188);
               this.field1194 = 0L;
               this.field1197 = true;
            }

            int var3 = this.vmethod1521();
            if(this.field1193 - var3 > this.field1192) {
               this.field1192 = this.field1193 - var3;
            }

            int var4 = this.field1199 + this.field1190;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1188) {
               this.field1188 += 1024;
               if(this.field1188 > 16384) {
                  this.field1188 = 16384;
               }

               this.vmethod1511();
               this.vmethod1502(this.field1188);
               var3 = 0;
               this.field1197 = true;
               if(256 + var4 > this.field1188) {
                  var4 = this.field1188 - 256;
                  this.field1190 = var4 - this.field1199;
               }
            }

            while(var3 < var4) {
               this.method1190(this.field1200, 256);
               this.vmethod1503();
               var3 += 256;
            }

            if(var1 > this.field1195) {
               if(!this.field1197) {
                  if(this.field1192 == 0 && this.field1184 == 0) {
                     this.vmethod1511();
                     this.field1194 = 2000L + var1;
                     return;
                  }

                  this.field1190 = Math.min(this.field1184, this.field1192);
                  this.field1184 = this.field1192;
               } else {
                  this.field1197 = false;
               }

               this.field1192 = 0;
               this.field1195 = 2000L + var1;
            }

            this.field1193 = var3;
         } catch (Exception var6) {
            this.vmethod1511();
            this.field1194 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1187) {
               var1 = this.field1187;
            }

            while(var1 > 5000L + this.field1187) {
               this.method1179(256);
               this.field1187 += (long)(256000 / class102.field1780);
            }
         } catch (Exception var5) {
            this.field1187 = var1;
         }

      }
   }

   @ObfuscatedName("ab")
   public final synchronized void method1177() {
      this.field1197 = true;

      try {
         this.vmethod1520();
      } catch (Exception var2) {
         this.vmethod1511();
         this.field1194 = class109.method2381() + 2000L;
      }

   }

   @ObfuscatedName("ak")
   public final synchronized void method1178() {
      if(field1183 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1183.field1359[var2] == this) {
               field1183.field1359[var2] = null;
            }

            if(null != field1183.field1359[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1183.field1357 = true;

            while(field1183.field1358) {
               class105.method2332(50L);
            }

            field1183 = null;
         }
      }

      this.vmethod1511();
      this.field1200 = null;
   }

   @ObfuscatedName("am")
   final void method1179(int var1) {
      this.field1198 -= var1;
      if(this.field1198 < 0) {
         this.field1198 = 0;
      }

      if(null != this.field1185) {
         this.field1185.vmethod3676(var1);
      }

   }

   @ObfuscatedName("ac")
   final void method1180(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1189[var3];
      if(null == var4) {
         this.field1204[var3] = var1;
      } else {
         var4.field1274 = var1;
      }

      this.field1189[var3] = var1;
      var1.field1271 = var2;
   }

   @ObfuscatedName("j")
   void vmethod1501() throws Exception {
   }

   @ObfuscatedName("l")
   void vmethod1502(int var1) throws Exception {
   }

   @ObfuscatedName("a")
   int vmethod1521() throws Exception {
      return this.field1188;
   }

   @ObfuscatedName("i")
   void vmethod1503() throws Exception {
   }

   @ObfuscatedName("f")
   void vmethod1511() {
   }

   @ObfuscatedName("m")
   void vmethod1520() throws Exception {
   }

   @ObfuscatedName("x")
   public final synchronized void method1188(class66 var1) {
      this.field1185 = var1;
   }

   @ObfuscatedName("aw")
   final void method1190(int[] var1, int var2) {
      int var3 = var2;
      if(field1191) {
         var3 = var2 << 1;
      }

      class119.method2676(var1, 0, var3);
      this.field1198 -= var2;
      if(null != this.field1185 && this.field1198 <= 0) {
         this.field1198 += class102.field1780 >> 4;
         class48.method994(this.field1185);
         this.method1180(this.field1185, this.field1185.vmethod1466());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label143:
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

            for(int var9 = var5 >>> var7 & 286331153; 0 != var9; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class66 var11 = this.field1204[var7];

                  label137:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label137;
                        }

                        class65 var12 = var11.field1272;
                        if(var12 != null && var12.field1270 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1274;
                        } else {
                           var11.field1273 = true;
                           int var13 = var11.vmethod3679();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1270 += var13;
                           }

                           if(var4 >= this.field1186) {
                              break label143;
                           }

                           class66 var14 = var11.vmethod3677();
                           if(var14 != null) {
                              for(int var15 = var11.field1271; null != var14; var14 = var11.vmethod3678()) {
                                 this.method1180(var14, var15 * var14.vmethod1466() >> 8);
                              }
                           }

                           class66 var18 = var11.field1274;
                           var11.field1274 = null;
                           if(var10 == null) {
                              this.field1204[var7] = var18;
                           } else {
                              var10.field1274 = var18;
                           }

                           if(null == var18) {
                              this.field1189[var7] = var10;
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
            class66 var16 = this.field1204[var6];
            class66[] var17 = this.field1204;
            this.field1189[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1274;
               var16.field1274 = null;
            }
         }
      }

      if(this.field1198 < 0) {
         this.field1198 = 0;
      }

      if(this.field1185 != null) {
         this.field1185.vmethod3680(var1, 0, var2);
      }

      this.field1187 = class109.method2381();
   }

   @ObfuscatedName("v")
   public final void method1199() {
      this.field1197 = true;
   }
}
