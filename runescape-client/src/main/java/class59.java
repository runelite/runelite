import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class59 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -444534531
   )
   int field1246 = 0;
   @ObfuscatedName("w")
   public static boolean field1247;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1980938495
   )
   int field1248 = 32;
   @ObfuscatedName("o")
   static class75 field1249;
   @ObfuscatedName("j")
   int[] field1251;
   @ObfuscatedName("r")
   class69 field1252;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1909981637
   )
   int field1253;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 7809967239200219495L
   )
   long field1254 = class193.method3805();
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 395488205
   )
   int field1255;
   @ObfuscatedName("fj")
   @ObfuscatedGetter(
      intValue = -855220377
   )
   @Export("cameraY")
   static int field1256;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      longValue = 8771492356797070771L
   )
   long field1257 = 0L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1169083231
   )
   int field1259 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1449726859
   )
   int field1260;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 269706059
   )
   int field1261 = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1635452869
   )
   public static int field1262;
   @ObfuscatedName("d")
   boolean field1263 = true;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -539740187
   )
   int field1265 = 0;
   @ObfuscatedName("b")
   class69[] field1266 = new class69[8];
   @ObfuscatedName("aj")
   class69[] field1267 = new class69[8];
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1803738347
   )
   public static int field1268;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 5834065878709697301L
   )
   long field1269 = 0L;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "715467008"
   )
   public final synchronized void method1249(class69 var1) {
      this.field1252 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1065451885"
   )
   public final synchronized void method1250() {
      if(null != this.field1251) {
         long var1 = class193.method3805();

         try {
            if(0L != this.field1257) {
               if(var1 < this.field1257) {
                  return;
               }

               this.vmethod1601(this.field1253);
               this.field1257 = 0L;
               this.field1263 = true;
            }

            int var3 = this.vmethod1598();
            if(this.field1261 - var3 > this.field1259) {
               this.field1259 = this.field1261 - var3;
            }

            int var4 = this.field1260 + this.field1255;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(256 + var4 > this.field1253) {
               this.field1253 += 1024;
               if(this.field1253 > 16384) {
                  this.field1253 = 16384;
               }

               this.vmethod1611();
               this.vmethod1601(this.field1253);
               var3 = 0;
               this.field1263 = true;
               if(256 + var4 > this.field1253) {
                  var4 = this.field1253 - 256;
                  this.field1255 = var4 - this.field1260;
               }
            }

            while(var3 < var4) {
               this.method1255(this.field1251, 256);
               this.vmethod1599();
               var3 += 256;
            }

            if(var1 > this.field1269) {
               if(!this.field1263) {
                  if(this.field1259 == 0 && this.field1246 == 0) {
                     this.vmethod1611();
                     this.field1257 = 2000L + var1;
                     return;
                  }

                  this.field1255 = Math.min(this.field1246, this.field1259);
                  this.field1246 = this.field1259;
               } else {
                  this.field1263 = false;
               }

               this.field1259 = 0;
               this.field1269 = var1 + 2000L;
            }

            this.field1261 = var3;
         } catch (Exception var7) {
            this.vmethod1611();
            this.field1257 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1254) {
               var1 = this.field1254;
            }

            while(var1 > this.field1254 + 5000L) {
               this.method1282(256);
               this.field1254 += (long)(256000 / field1268);
            }
         } catch (Exception var6) {
            this.field1254 = var1;
         }

      }
   }

   @ObfuscatedName("m")
   public static String method1251(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2707[(int)(var6 - 37L * var0)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "841731336"
   )
   final void method1252(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1267[var3];
      if(var4 == null) {
         this.field1266[var3] = var1;
      } else {
         var4.field1339 = var1;
      }

      this.field1267[var3] = var1;
      var1.field1337 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-10"
   )
   public final synchronized void method1253() {
      if(null != field1249) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1249.field1422[var2] == this) {
               field1249.field1422[var2] = null;
            }

            if(field1249.field1422[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            field1249.field1423 = true;

            while(field1249.field1429) {
               class141.method2993(50L);
            }

            field1249 = null;
         }
      }

      this.vmethod1611();
      this.field1251 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1255(int[] var1, int var2) {
      int var3 = var2;
      if(field1247) {
         var3 = var2 << 1;
      }

      class123.method2764(var1, 0, var3);
      this.field1265 -= var2;
      if(null != this.field1252 && this.field1265 <= 0) {
         this.field1265 += field1268 >> 4;
         class55.method1136(this.field1252);
         this.method1252(this.field1252, this.field1252.vmethod1547());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
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
                  class69 var11 = this.field1266[var16];

                  label135:
                  while(true) {
                     while(true) {
                        if(null == var11) {
                           break label135;
                        }

                        class68 var12 = var11.field1338;
                        if(null != var12 && var12.field1336 > var8) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1339;
                        } else {
                           var11.field1340 = true;
                           int var13 = var11.vmethod3783();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1336 += var13;
                           }

                           if(var4 >= this.field1248) {
                              break label141;
                           }

                           class69 var14 = var11.vmethod3775();
                           if(var14 != null) {
                              for(int var17 = var11.field1337; null != var14; var14 = var11.vmethod3776()) {
                                 this.method1252(var14, var17 * var14.vmethod1547() >> 8);
                              }
                           }

                           class69 var15 = var11.field1339;
                           var11.field1339 = null;
                           if(null == var10) {
                              this.field1266[var16] = var15;
                           } else {
                              var10.field1339 = var15;
                           }

                           if(null == var15) {
                              this.field1267[var16] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var7 = this.field1266[var6];
            class69[] var18 = this.field1266;
            this.field1267[var6] = null;

            for(var18[var6] = null; var7 != null; var7 = var10) {
               var10 = var7.field1339;
               var7.field1339 = null;
            }
         }
      }

      if(this.field1265 < 0) {
         this.field1265 = 0;
      }

      if(null != this.field1252) {
         this.field1252.vmethod3778(var1, 0, var2);
      }

      this.field1254 = class193.method3805();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "2071460094"
   )
   void vmethod1596(Component var1) throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   void vmethod1604() throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1330954291"
   )
   int vmethod1598() throws Exception {
      return this.field1253;
   }

   @ObfuscatedName("y")
   void vmethod1599() throws Exception {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2058348836"
   )
   public final void method1261() {
      this.field1263 = true;
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Z",
      garbageValue = "-987176361"
   )
   static final boolean method1271(class176 var0) {
      if(null == var0.field2908) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2908.length; ++var1) {
            int var2 = class1.method9(var0, var1);
            int var3 = var0.field2861[var1];
            if(var0.field2908[var1] == 2) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2908[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(var0.field2908[var1] == 4) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var2 != var3) {
               return false;
            }
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2145847335"
   )
   final void method1282(int var1) {
      this.field1265 -= var1;
      if(this.field1265 < 0) {
         this.field1265 = 0;
      }

      if(null != this.field1252) {
         this.field1252.vmethod3779(var1);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-554023544"
   )
   void vmethod1601(int var1) throws Exception {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1204122107"
   )
   void vmethod1611() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2116200186"
   )
   public final synchronized void method1299() {
      this.field1263 = true;

      try {
         this.vmethod1604();
      } catch (Exception var2) {
         this.vmethod1611();
         this.field1257 = class193.method3805() + 2000L;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "41925830"
   )
   @Export("sendGameMessage")
   static void method1304(int var0, String var1, String var2) {
      class23.method580(var0, var1, var2, (String)null);
   }
}
