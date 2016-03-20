import java.awt.Graphics;
import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class141 {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass223;Lclass223;S)V",
      garbageValue = "-17965"
   )
   static void method2993(class223 var0, class223 var1) {
      if(class29.field700 == null) {
         class29.field700 = class74.method1637(class7.field127, "sl_back", "");
      }

      if(null == class38.field880) {
         class38.field880 = class30.method664(class7.field127, "sl_flags", "");
      }

      if(null == class49.field1094) {
         class49.field1094 = class30.method664(class7.field127, "sl_arrows", "");
      }

      if(null == class92.field1587) {
         class92.field1587 = class30.method664(class7.field127, "sl_stars", "");
      }

      class79.method1830(class31.field716, 23, 765, 480, 0);
      class79.method1831(class31.field716, 0, 125, 23, 12425273, 9135624);
      class79.method1831(125 + class31.field716, 0, 640, 23, 5197647, 2697513);
      var0.method4059("Select a world", class31.field716 + 62, 15, 0, -1);
      if(null != class92.field1587) {
         class92.field1587[1].method1883(class31.field716 + 140, 1);
         var1.method4057("Members only world", 152 + class31.field716, 10, 16777215, -1);
         class92.field1587[0].method1883(140 + class31.field716, 12);
         var1.method4057("Free world", 152 + class31.field716, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class49.field1094) {
         int var2 = 280 + class31.field716;
         if(0 == class25.field637[0] && class25.field636[0] == 0) {
            class49.field1094[2].method1883(var2, 4);
         } else {
            class49.field1094[0].method1883(var2, 4);
         }

         if(0 == class25.field637[0] && class25.field636[0] == 1) {
            class49.field1094[3].method1883(var2 + 15, 4);
         } else {
            class49.field1094[1].method1883(15 + var2, 4);
         }

         var0.method4057("World", var2 + 32, 17, 16777215, -1);
         int var3 = 390 + class31.field716;
         if(1 == class25.field637[0] && class25.field636[0] == 0) {
            class49.field1094[2].method1883(var3, 4);
         } else {
            class49.field1094[0].method1883(var3, 4);
         }

         if(class25.field637[0] == 1 && class25.field636[0] == 1) {
            class49.field1094[3].method1883(var3 + 15, 4);
         } else {
            class49.field1094[1].method1883(15 + var3, 4);
         }

         var0.method4057("Players", 32 + var3, 17, 16777215, -1);
         var4 = class31.field716 + 500;
         if(2 == class25.field637[0] && 0 == class25.field636[0]) {
            class49.field1094[2].method1883(var4, 4);
         } else {
            class49.field1094[0].method1883(var4, 4);
         }

         if(class25.field637[0] == 2 && 1 == class25.field636[0]) {
            class49.field1094[3].method1883(15 + var4, 4);
         } else {
            class49.field1094[1].method1883(var4 + 15, 4);
         }

         var0.method4057("Location", var4 + 32, 17, 16777215, -1);
         var5 = class31.field716 + 610;
         if(class25.field637[0] == 3 && 0 == class25.field636[0]) {
            class49.field1094[2].method1883(var5, 4);
         } else {
            class49.field1094[0].method1883(var5, 4);
         }

         if(3 == class25.field637[0] && class25.field636[0] == 1) {
            class49.field1094[3].method1883(15 + var5, 4);
         } else {
            class49.field1094[1].method1883(var5 + 15, 4);
         }

         var0.method4057("Type", var5 + 32, 17, 16777215, -1);
      }

      class79.method1830(708 + class31.field716, 4, 50, 16, 0);
      var1.method4059("Cancel", class31.field716 + 708 + 25, 16, 16777215, -1);
      class31.field747 = -1;
      if(null != class29.field700) {
         byte var21 = 88;
         byte var23 = 19;
         var4 = 765 / (1 + var21);
         var5 = 480 / (var23 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= class25.field634) {
               --var4;
            }

            if((var5 - 1) * var4 >= class25.field634) {
               --var5;
            }

            if(var4 * (var5 - 1) >= class25.field634) {
               --var5;
            }
         } while(var5 != var6 || var4 != var7);

         var6 = (765 - var21 * var4) / (var4 + 1);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var5 * var23) / (1 + var5);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var21 * var4 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var23 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class31.field716;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field634; ++var14) {
            class25 var15 = class25.field633[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field635);
            if(var15.field635 == -1) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field635 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method598()) {
               if(var15.method599()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method604()) {
               var19 = 16711680;
               if(var15.method599()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method601()) {
               if(var15.method599()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method599()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class139.field2140 >= var11 && class139.field2135 >= var10 && class139.field2140 < var11 + var21 && class139.field2135 < var23 + var10 && var16) {
               class31.field747 = var14;
               class29.field700[var18].method1746(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class29.field700[var18].method1743(var11, var10);
            }

            if(class38.field880 != null) {
               class38.field880[(var15.method599()?8:0) + var15.field644].method1883(var11 + 29, var10);
            }

            var0.method4059(Integer.toString(var15.field638), var11 + 15, 5 + var10 + var23 / 2, var19, -1);
            var1.method4059(var17, var11 + 60, var10 + var23 / 2 + 5, 268435455, -1);
            var10 += var7 + var23;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var21 + var6;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method4052(class25.field633[class31.field747].field643) + 6;
            int var24 = 8 + var1.field3193;
            class79.method1830(class139.field2140 - var14 / 2, 20 + class139.field2135 + 5, var14, var24, 16777120);
            class79.method1853(class139.field2140 - var14 / 2, class139.field2135 + 20 + 5, var14, var24, 0);
            var1.method4059(class25.field633[class31.field747].field643, class139.field2140, 4 + var1.field3193 + 5 + 20 + class139.field2135, 0, -1);
         }
      }

      try {
         Graphics var22 = class45.field1042.getGraphics();
         class139.field2149.vmethod1900(var22, 0, 0);
      } catch (Exception var20) {
         class45.field1042.repaint();
      }

   }

   @ObfuscatedName("f")
   public static boolean method2996(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("cc")
   static final String method2997(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?class51.method1090(16711680):(var2 < -6?class51.method1090(16723968):(var2 < -3?class51.method1090(16740352):(var2 < 0?class51.method1090(16756736):(var2 > 9?class51.method1090('\uff00'):(var2 > 6?class51.method1090(4259584):(var2 > 3?class51.method1090(8453888):(var2 > 0?class51.method1090(12648192):class51.method1090(16776960))))))));
   }
}
