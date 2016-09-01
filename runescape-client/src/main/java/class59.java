import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class59 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1917846251
   )
   int field1222 = 32;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -253443061
   )
   int field1223 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1094437391
   )
   static int field1224;
   @ObfuscatedName("l")
   int[] field1225;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 425174777
   )
   int field1226;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1227683009
   )
   int field1227;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -459704319
   )
   public static int field1228;
   @ObfuscatedName("r")
   static boolean field1229;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1474858425
   )
   int field1230;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 788105605
   )
   int field1231 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      longValue = 3090952476566599103L
   )
   long field1232 = 0L;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 502904979
   )
   int field1233 = 0;
   @ObfuscatedName("a")
   boolean field1234 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 844135811
   )
   int field1235 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -1635437822435532485L
   )
   long field1236 = 0L;
   @ObfuscatedName("m")
   class69 field1237;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -2097051847101334057L
   )
   long field1239 = class34.method713();
   @ObfuscatedName("o")
   class69[] field1240 = new class69[8];
   @ObfuscatedName("ah")
   class69[] field1241 = new class69[8];
   @ObfuscatedName("iv")
   static class32 field1242;
   @ObfuscatedName("bt")
   @Export("host")
   static String host;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass69;I)V",
      garbageValue = "1892967862"
   )
   public final synchronized void method1214(class69 var1) {
      this.field1237 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "122"
   )
   public final synchronized void method1215() {
      if(this.field1225 != null) {
         long var1 = class34.method713();

         try {
            if(this.field1232 != 0L) {
               if(var1 < this.field1232) {
                  return;
               }

               this.vmethod1533(this.field1226);
               this.field1232 = 0L;
               this.field1234 = true;
            }

            int var3 = this.vmethod1534();
            if(this.field1235 - var3 > this.field1233) {
               this.field1233 = this.field1235 - var3;
            }

            int var4 = this.field1230 + this.field1227;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1226) {
               this.field1226 += 1024;
               if(this.field1226 > 16384) {
                  this.field1226 = 16384;
               }

               this.vmethod1544();
               this.vmethod1533(this.field1226);
               var3 = 0;
               this.field1234 = true;
               if(256 + var4 > this.field1226) {
                  var4 = this.field1226 - 256;
                  this.field1227 = var4 - this.field1230;
               }
            }

            while(var3 < var4) {
               this.method1220(this.field1225, 256);
               this.vmethod1536();
               var3 += 256;
            }

            if(var1 > this.field1236) {
               if(!this.field1234) {
                  if(this.field1233 == 0 && this.field1223 == 0) {
                     this.vmethod1544();
                     this.field1232 = var1 + 2000L;
                     return;
                  }

                  this.field1227 = Math.min(this.field1223, this.field1233);
                  this.field1223 = this.field1233;
               } else {
                  this.field1234 = false;
               }

               this.field1233 = 0;
               this.field1236 = var1 + 2000L;
            }

            this.field1235 = var3;
         } catch (Exception var7) {
            this.vmethod1544();
            this.field1232 = var1 + 2000L;
         }

         try {
            if(var1 > this.field1239 + 500000L) {
               var1 = this.field1239;
            }

            while(var1 > this.field1239 + 5000L) {
               this.method1219(256);
               this.field1239 += (long)(256000 / field1228);
            }
         } catch (Exception var6) {
            this.field1239 = var1;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-464337916"
   )
   void vmethod1539() throws Exception {
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1737184425"
   )
   public final synchronized void method1218() {
      if(class180.field2963 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(this == class180.field2963.field1392[var2]) {
               class180.field2963.field1392[var2] = null;
            }

            if(class180.field2963.field1392[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class180.field2963.field1393 = true;

            while(class180.field2963.field1394) {
               class125.method2820(50L);
            }

            class180.field2963 = null;
         }
      }

      this.vmethod1544();
      this.field1225 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-15"
   )
   final void method1219(int var1) {
      this.field1231 -= var1;
      if(this.field1231 < 0) {
         this.field1231 = 0;
      }

      if(this.field1237 != null) {
         this.field1237.vmethod3749(var1);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1220(int[] var1, int var2) {
      int var3 = var2;
      if(field1229) {
         var3 = var2 << 1;
      }

      class123.method2786(var1, 0, var3);
      this.field1231 -= var2;
      if(null != this.field1237 && this.field1231 <= 0) {
         this.field1231 += field1228 >> 4;
         class54.method1094(this.field1237);
         this.method1221(this.field1237, this.field1237.vmethod1493());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label137:
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

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  class69 var11 = this.field1240[var7];

                  label131:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label131;
                        }

                        class68 var12 = var11.field1309;
                        if(null != var12 && var12.field1306 > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.field1310;
                        } else {
                           var11.field1308 = true;
                           int var13 = var11.vmethod3747();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1306 += var13;
                           }

                           if(var4 >= this.field1222) {
                              break label137;
                           }

                           class69 var14 = var11.vmethod3753();
                           if(null != var14) {
                              for(int var16 = var11.field1307; null != var14; var14 = var11.vmethod3746()) {
                                 this.method1221(var14, var16 * var14.vmethod1493() >> 8);
                              }
                           }

                           class69 var15 = var11.field1310;
                           var11.field1310 = null;
                           if(null == var10) {
                              this.field1240[var7] = var15;
                           } else {
                              var10.field1310 = var15;
                           }

                           if(var15 == null) {
                              this.field1241[var7] = var10;
                           }

                           var11 = var15;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class69 var17 = this.field1240[var6];
            class69[] var18 = this.field1240;
            this.field1241[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.field1310;
               var17.field1310 = null;
            }
         }
      }

      if(this.field1231 < 0) {
         this.field1231 = 0;
      }

      if(null != this.field1237) {
         this.field1237.vmethod3748(var1, 0, var2);
      }

      this.field1239 = class34.method713();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass69;IB)V",
      garbageValue = "-2"
   )
   final void method1221(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1241[var3];
      if(null == var4) {
         this.field1240[var3] = var1;
      } else {
         var4.field1310 = var1;
      }

      this.field1241[var3] = var1;
      var1.field1307 = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-75"
   )
   void vmethod1532(Component var1) throws Exception {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1062421140"
   )
   void vmethod1533(int var1) throws Exception {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130031761"
   )
   int vmethod1534() throws Exception {
      return this.field1226;
   }

   @ObfuscatedName("g")
   void vmethod1536() throws Exception {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-216231901"
   )
   public final synchronized void method1263() {
      this.field1234 = true;

      try {
         this.vmethod1539();
      } catch (Exception var2) {
         this.vmethod1544();
         this.field1232 = class34.method713() + 2000L;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1255925384"
   )
   void vmethod1544() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-27864"
   )
   public final void method1274() {
      this.field1234 = true;
   }
}
