import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class28 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1677657654"
   )
   static void method666(int var0, boolean var1, int var2, boolean var3) {
      if(class27.field662 != null) {
         class44.method911(0, class27.field662.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIZI)Lclass81;",
      garbageValue = "-873170521"
   )
   @Export("createSprite")
   public static final class81 method667(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if(var1 == -1) {
         var4 = 0;
      } else if(var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      class81 var8;
      if(!var5) {
         var8 = (class81)class55.field1177.method3905(var6);
         if(null != var8) {
            return var8;
         }
      }

      class55 var9 = class1.method14(var0);
      if(var1 > 1 && null != var9.field1214) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if(var1 >= var9.field1215[var11] && var9.field1215[var11] != 0) {
               var10 = var9.field1214[var11];
            }
         }

         if(var10 != -1) {
            var9 = class1.method14(var10);
         }
      }

      class108 var19 = var9.method1178(1);
      if(var19 == null) {
         return null;
      } else {
         class81 var20 = null;
         if(var9.field1178 != -1) {
            var20 = method667(var9.field1216, 10, 1, 0, 0, true);
            if(null == var20) {
               return null;
            }
         } else if(var9.field1226 != -1) {
            var20 = method667(var9.field1225, var1, var2, var3, 0, false);
            if(var20 == null) {
               return null;
            }
         } else if(var9.field1213 != -1) {
            var20 = method667(var9.field1227, var1, 0, 0, 0, false);
            if(var20 == null) {
               return null;
            }
         }

         int[] var12 = class82.field1493;
         int var13 = class82.field1490;
         int var14 = class82.field1494;
         int[] var15 = new int[4];
         class82.method1883(var15);
         var8 = new class81(36, 32);
         class82.method1879(var8.field1487, 36, 32);
         class82.method1885();
         class94.method2183();
         class94.method2187(16, 16);
         class94.field1641 = false;
         if(var9.field1213 != -1) {
            var20.method1824(0, 0);
         }

         int var16 = var9.field1191;
         if(var5) {
            var16 = (int)((double)var16 * 1.5D);
         } else if(var2 == 2) {
            var16 = (int)((double)var16 * 1.04D);
         }

         int var17 = class94.field1661[var9.field1188] * var16 >> 16;
         int var18 = var16 * class94.field1662[var9.field1188] >> 16;
         var19.method2402();
         var19.method2414(0, var9.field1193, var9.field1194, var9.field1188, var9.field1179, var19.field1538 / 2 + var17 + var9.field1196, var9.field1196 + var18);
         if(var9.field1226 != -1) {
            var20.method1824(0, 0);
         }

         if(var2 >= 1) {
            var8.method1802(1);
         }

         if(var2 >= 2) {
            var8.method1802(16777215);
         }

         if(var3 != 0) {
            var8.method1803(var3);
         }

         class82.method1879(var8.field1487, 36, 32);
         if(var9.field1178 != -1) {
            var20.method1824(0, 0);
         }

         if(var4 == 1 || var4 == 2 && var9.field1197 == 1) {
            class47.field1072.method4170(class106.method2393(var1), 0, 9, 16776960, 1);
         }

         if(!var5) {
            class55.field1177.method3907(var8, var6);
         }

         class82.method1879(var12, var13, var14);
         class82.method1897(var15);
         class94.method2183();
         class94.field1641 = true;
         return var8;
      }
   }
}
