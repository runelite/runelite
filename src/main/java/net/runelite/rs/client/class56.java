package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
public class class56 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -344797021
   )
   public static int field1162;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -511868705
   )
   int field1163 = 0;
   @ObfuscatedName("t")
   int[] field1165;
   @ObfuscatedName("k")
   class66 field1166;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -2595010963583234593L
   )
   long field1168 = class92.method2177();
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1130041309
   )
   int field1169;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1351525161
   )
   int field1170;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1549072775
   )
   int field1171 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -290543348258451117L
   )
   long field1172 = 0L;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2106522015
   )
   int field1173 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1532217591
   )
   int field1174 = 0;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -124224185
   )
   int field1175;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 8313892749671076061L
   )
   long field1176 = 0L;
   @ObfuscatedName("q")
   boolean field1177 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -267039545
   )
   int field1179 = 32;
   @ObfuscatedName("ao")
   class66[] field1180 = new class66[8];
   @ObfuscatedName("as")
   class66[] field1181 = new class66[8];
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2144063691
   )
   public static int field1183;

   @ObfuscatedName("b")
   public final synchronized void method1217(class66 var1) {
      this.field1166 = var1;
   }

   @ObfuscatedName("aa")
   public final synchronized void method1218() {
      if(this.field1165 != null) {
         long var1 = class92.method2177();

         try {
            if(0L != this.field1172) {
               if(var1 < this.field1172) {
                  return;
               }

               this.vmethod1530(this.field1169);
               this.field1172 = 0L;
               this.field1177 = true;
            }

            int var3 = this.vmethod1541();
            if(this.field1173 - var3 > this.field1171) {
               this.field1171 = this.field1173 - var3;
            }

            int var4 = this.field1175 + this.field1170;
            if(256 + var4 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1169) {
               this.field1169 += 1024;
               if(this.field1169 > 16384) {
                  this.field1169 = 16384;
               }

               this.vmethod1540();
               this.vmethod1530(this.field1169);
               var3 = 0;
               this.field1177 = true;
               if(256 + var4 > this.field1169) {
                  var4 = this.field1169 - 256;
                  this.field1175 = var4 - this.field1170;
               }
            }

            while(var3 < var4) {
               this.method1223(this.field1165, 256);
               this.vmethod1532();
               var3 += 256;
            }

            if(var1 > this.field1176) {
               if(!this.field1177) {
                  if(this.field1171 == 0 && this.field1174 == 0) {
                     this.vmethod1540();
                     this.field1172 = var1 + 2000L;
                     return;
                  }

                  this.field1175 = Math.min(this.field1174, this.field1171);
                  this.field1174 = this.field1171;
               } else {
                  this.field1177 = false;
               }

               this.field1171 = 0;
               this.field1176 = 2000L + var1;
            }

            this.field1173 = var3;
         } catch (Exception var6) {
            this.vmethod1540();
            this.field1172 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1168) {
               var1 = this.field1168;
            }

            while(var1 > this.field1168 + 5000L) {
               this.method1222(256);
               this.field1168 += (long)(256000 / field1183);
            }
         } catch (Exception var5) {
            this.field1168 = var1;
         }

      }
   }

   @ObfuscatedName("ao")
   public final void method1219() {
      this.field1177 = true;
   }

   @ObfuscatedName("ae")
   public final synchronized void method1221() {
      if(class28.field659 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class28.field659.field1340[var2]) {
               class28.field659.field1340[var2] = null;
            }

            if(null != class28.field659.field1340[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            class28.field659.field1341 = true;

            while(class28.field659.field1338) {
               class29.method711(50L);
            }

            class28.field659 = null;
         }
      }

      this.vmethod1540();
      this.field1165 = null;
   }

   @ObfuscatedName("ai")
   final void method1222(int var1) {
      this.field1163 -= var1;
      if(this.field1163 < 0) {
         this.field1163 = 0;
      }

      if(this.field1166 != null) {
         this.field1166.vmethod3787(var1);
      }

   }

   @ObfuscatedName("am")
   final void method1223(int[] var1, int var2) {
      int var3 = var2;
      if(class228.field3215) {
         var3 = var2 << 1;
      }

      class119.method2749(var1, 0, var3);
      this.field1163 -= var2;
      if(null != this.field1166 && this.field1163 <= 0) {
         this.field1163 += field1183 >> 4;
         class7.method124(this.field1166);
         this.method1224(this.field1166, this.field1166.vmethod1491());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class66 var10;
         label134:
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
                  class66 var11 = this.field1180[var7];

                  label128:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label128;
                        }

                        class65 var12 = var11.field1253;
                        if(null != var12 && var12.field1250 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1254;
                        } else {
                           var11.field1251 = true;
                           int var13 = var11.vmethod3772();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1250 += var13;
                           }

                           if(var4 >= this.field1179) {
                              break label134;
                           }

                           class66 var14 = var11.vmethod3774();
                           if(var14 != null) {
                              for(int var15 = var11.field1252; var14 != null; var14 = var11.vmethod3770()) {
                                 this.method1224(var14, var15 * var14.vmethod1491() >> 8);
                              }
                           }

                           class66 var18 = var11.field1254;
                           var11.field1254 = null;
                           if(var10 == null) {
                              this.field1180[var7] = var18;
                           } else {
                              var10.field1254 = var18;
                           }

                           if(null == var18) {
                              this.field1181[var7] = var10;
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
            class66 var16 = this.field1180[var6];
            class66[] var17 = this.field1180;
            this.field1181[var6] = null;

            for(var17[var6] = null; null != var16; var16 = var10) {
               var10 = var16.field1254;
               var16.field1254 = null;
            }
         }
      }

      if(this.field1163 < 0) {
         this.field1163 = 0;
      }

      if(null != this.field1166) {
         this.field1166.vmethod3784(var1, 0, var2);
      }

      this.field1168 = class92.method2177();
   }

   @ObfuscatedName("ay")
   final void method1224(class66 var1, int var2) {
      int var3 = var2 >> 5;
      class66 var4 = this.field1181[var3];
      if(var4 == null) {
         this.field1180[var3] = var1;
      } else {
         var4.field1254 = var1;
      }

      this.field1181[var3] = var1;
      var1.field1252 = var2;
   }

   @ObfuscatedName("j")
   void vmethod1529() throws Exception {
   }

   @ObfuscatedName("m")
   void vmethod1530(int var1) throws Exception {
   }

   @ObfuscatedName("f")
   int vmethod1541() throws Exception {
      return this.field1169;
   }

   @ObfuscatedName("l")
   void vmethod1532() throws Exception {
   }

   @ObfuscatedName("a")
   void vmethod1533() throws Exception {
   }

   @ObfuscatedName("u")
   void vmethod1540() {
   }

   @ObfuscatedName("cn")
   static void method1261() {
      for(class3 var0 = (class3)client.field304.method3835(); var0 != null; var0 = (class3)client.field304.method3840()) {
         int var1 = var0.field63;
         if(class167.method3400(var1)) {
            boolean var2 = true;
            class172[] var3 = class172.field2857[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(null != var3[var4]) {
                  var2 = var3[var4].field2733;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.field3104;
               class172 var5 = class48.method1036(var4);
               if(var5 != null) {
                  class42.method942(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("as")
   public final synchronized void method1264() {
      this.field1177 = true;

      try {
         this.vmethod1533();
      } catch (Exception var2) {
         this.vmethod1540();
         this.field1172 = class92.method2177() + 2000L;
      }

   }

   @ObfuscatedName("m")
   public static char method1269(char var0) {
      return (char)(198 == var0?'E':(var0 == 230?'e':(223 == var0?'s':(338 == var0?'E':(var0 == 339?'e':'\u0000')))));
   }
}
