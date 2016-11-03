import java.awt.Component;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class59 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -229921701
   )
   int field1233;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -590907257
   )
   int field1234 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 901246469
   )
   public static int field1235;
   @ObfuscatedName("c")
   static class75 field1236;
   @ObfuscatedName("q")
   public static boolean field1238;
   @ObfuscatedName("y")
   class69 field1239;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 587667553
   )
   int field1240;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      longValue = -5621056086145817589L
   )
   long field1241 = class169.method3276();
   @ObfuscatedName("aq")
   class69[] field1242 = new class69[8];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -3411142763727489385L
   )
   long field1243 = 0L;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1530675359
   )
   int field1244;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = 4711387077101200673L
   )
   long field1245 = 0L;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1007471455
   )
   int field1246 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 569632525
   )
   int field1247 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1976670319
   )
   int field1248 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -335013605
   )
   public static int field1249;
   @ObfuscatedName("r")
   boolean field1250 = true;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 359484983
   )
   int field1251 = 32;
   @ObfuscatedName("o")
   class69[] field1252 = new class69[8];
   @ObfuscatedName("m")
   int[] field1253;
   @ObfuscatedName("bm")
   static class171 field1254;
   @ObfuscatedName("qb")
   protected static Image field1256;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   void vmethod1569() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "16"
   )
   public final synchronized void method1216(class69 var1) {
      this.field1239 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "134376921"
   )
   public final synchronized void method1217() {
      if(this.field1253 != null) {
         long var1 = class169.method3276();

         try {
            if(this.field1245 != 0L) {
               if(var1 < this.field1245) {
                  return;
               }

               this.vmethod1566(this.field1233);
               this.field1245 = 0L;
               this.field1250 = true;
            }

            int var3 = this.vmethod1567();
            if(this.field1248 - var3 > this.field1246) {
               this.field1246 = this.field1248 - var3;
            }

            int var4 = this.field1240 + this.field1244;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1233) {
               this.field1233 += 1024;
               if(this.field1233 > 16384) {
                  this.field1233 = 16384;
               }

               this.vmethod1569();
               this.vmethod1566(this.field1233);
               var3 = 0;
               this.field1250 = true;
               if(var4 + 256 > this.field1233) {
                  var4 = this.field1233 - 256;
                  this.field1244 = var4 - this.field1240;
               }
            }

            while(var3 < var4) {
               this.method1222(this.field1253, 256);
               this.vmethod1568();
               var3 += 256;
            }

            if(var1 > this.field1243) {
               if(!this.field1250) {
                  if(this.field1246 == 0 && this.field1234 == 0) {
                     this.vmethod1569();
                     this.field1245 = 2000L + var1;
                     return;
                  }

                  this.field1244 = Math.min(this.field1234, this.field1246);
                  this.field1234 = this.field1246;
               } else {
                  this.field1250 = false;
               }

               this.field1246 = 0;
               this.field1243 = var1 + 2000L;
            }

            this.field1248 = var3;
         } catch (Exception var7) {
            this.vmethod1569();
            this.field1245 = 2000L + var1;
         }

         try {
            if(var1 > 500000L + this.field1241) {
               var1 = this.field1241;
            }

            while(var1 > 5000L + this.field1241) {
               this.method1221(256);
               this.field1241 += (long)(256000 / field1249);
            }
         } catch (Exception var6) {
            this.field1241 = var1;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1580275972"
   )
   final void method1221(int var1) {
      this.field1247 -= var1;
      if(this.field1247 < 0) {
         this.field1247 = 0;
      }

      if(null != this.field1239) {
         this.field1239.vmethod3754(var1);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1222(int[] var1, int var2) {
      int var3 = var2;
      if(field1238) {
         var3 = var2 << 1;
      }

      class123.method2780(var1, 0, var3);
      this.field1247 -= var2;
      if(null != this.field1239 && this.field1247 <= 0) {
         this.field1247 += field1249 >> 4;
         Sequence.method934(this.field1239);
         this.method1223(this.field1239, this.field1239.vmethod1511());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class69 var10;
         label133:
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
                  class69 var11 = this.field1252[var16];

                  label127:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label127;
                        }

                        class68 var12 = var11.field1322;
                        if(null != var12 && var12.field1321 > var8) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1324;
                        } else {
                           var11.field1325 = true;
                           int var13 = var11.vmethod3758();
                           var4 += var13;
                           if(null != var12) {
                              var12.field1321 += var13;
                           }

                           if(var4 >= this.field1251) {
                              break label133;
                           }

                           class69 var14 = var11.vmethod3751();
                           if(null != var14) {
                              for(int var15 = var11.field1323; null != var14; var14 = var11.vmethod3755()) {
                                 this.method1223(var14, var15 * var14.vmethod1511() >> 8);
                              }
                           }

                           class69 var17 = var11.field1324;
                           var11.field1324 = null;
                           if(null == var10) {
                              this.field1252[var16] = var17;
                           } else {
                              var10.field1324 = var17;
                           }

                           if(var17 == null) {
                              this.field1242[var16] = var10;
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
            class69 var7 = this.field1252[var6];
            class69[] var18 = this.field1252;
            this.field1242[var6] = null;

            for(var18[var6] = null; null != var7; var7 = var10) {
               var10 = var7.field1324;
               var7.field1324 = null;
            }
         }
      }

      if(this.field1247 < 0) {
         this.field1247 = 0;
      }

      if(null != this.field1239) {
         this.field1239.vmethod3766(var1, 0, var2);
      }

      this.field1241 = class169.method3276();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass69;II)V",
      garbageValue = "535738328"
   )
   final void method1223(class69 var1, int var2) {
      int var3 = var2 >> 5;
      class69 var4 = this.field1242[var3];
      if(var4 == null) {
         this.field1252[var3] = var1;
      } else {
         var4.field1324 = var1;
      }

      this.field1242[var3] = var1;
      var1.field1323 = var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "14"
   )
   void vmethod1565(Component var1) throws Exception {
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1718856519"
   )
   void vmethod1566(int var1) throws Exception {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "566714973"
   )
   int vmethod1567() throws Exception {
      return this.field1233;
   }

   @ObfuscatedName("e")
   void vmethod1568() throws Exception {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "636351412"
   )
   void vmethod1584() throws Exception {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1851438704"
   )
   public final synchronized void method1251() {
      this.field1250 = true;

      try {
         this.vmethod1584();
      } catch (Exception var2) {
         this.vmethod1569();
         this.field1245 = class169.method3276() + 2000L;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1554915291"
   )
   public final synchronized void method1257() {
      if(null != field1236) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1236.field1407[var2] == this) {
               field1236.field1407[var2] = null;
            }

            if(null != field1236.field1407[var2]) {
               var1 = false;
            }
         }

         if(var1) {
            field1236.field1408 = true;

            while(field1236.field1409) {
               class127.method2846(50L);
            }

            field1236 = null;
         }
      }

      this.vmethod1569();
      this.field1253 = null;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "679028793"
   )
   public final void method1264() {
      this.field1250 = true;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1660457036"
   )
   public static byte[] method1268(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class128) {
         class128 var2 = (class128)var0;
         return var2.vmethod2852();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "553246958"
   )
   static void method1270(int var0, int var1) {
      Client.field324.method2828(82);
      Client.field324.method2603(var1);
      Client.field324.method2615(var0);
   }
}
