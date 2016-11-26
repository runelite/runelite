import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class60 {
   @ObfuscatedName("m")
   XHashTable field1071 = new XHashTable(256);
   @ObfuscatedName("mx")
   @ObfuscatedGetter(
      intValue = -987169475
   )
   static int field1072;
   @ObfuscatedName("d")
   class182 field1073;
   @ObfuscatedName("n")
   class182 field1074;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1794324243
   )
   static int field1075;
   @ObfuscatedName("h")
   XHashTable field1076 = new XHashTable(256);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-71"
   )
   public static boolean method1127(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2059.method3332(var0)) {
         return false;
      } else {
         int var1 = Widget.field2059.method3339(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2059.method3329(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method2838(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method2854(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass55;",
      garbageValue = "-1"
   )
   class55 method1128(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1076.method2405(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method975(this.field1074, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method969();
            this.field1076.method2406(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1014.length;
            }

            return var7;
         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1074 = var1;
      this.field1073 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "368978321"
   )
   public class55 method1129(int var1, int[] var2) {
      if(this.field1074.method3360() == 1) {
         return this.method1128(0, var1, var2);
      } else if(this.field1074.method3339(var1) == 1) {
         return this.method1128(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-1161775596"
   )
   public class55 method1130(int var1, int[] var2) {
      if(this.field1073.method3360() == 1) {
         return this.method1139(0, var1, var2);
      } else if(this.field1073.method3339(var1) == 1) {
         return this.method1139(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-118"
   )
   static final int method1136(int var0, int var1) {
      int var2 = var0 + 57 * var1;
      var2 ^= var2 << 13;
      int var3 = var2 * (789221 + 15731 * var2 * var2) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILRegion;[LCollisionData;B)V",
      garbageValue = "90"
   )
   static final void method1138(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method3003();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method3003();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class15.getObjectDefinition(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.field2903;
               int var28 = var21.field2907;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + Renderable.method1918(var16 & 7, var15 & 7, var7, var21.field2903, var21.field2907, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class11.tileSettings[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class163.method3198(var1, var29, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "1853159953"
   )
   class55 method1139(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1076.method2405(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1071.method2405(var5);
         if(var8 == null) {
            var8 = class54.method990(this.field1073, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1071.method2406(var8, var5);
         }

         var7 = var8.method1011(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1076.method2406(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "8924366"
   )
   public static String method1140(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = 42;
      }

      String var1 = new String(var3);
      return var1;
   }
}
