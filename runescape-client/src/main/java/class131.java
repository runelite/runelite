import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public abstract class class131 {
   @ObfuscatedName("rx")
   protected static boolean field2078;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -11240037
   )
   protected static int field2079;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;S)V",
      garbageValue = "-7680"
   )
   public abstract void vmethod3092(Component var1);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-110"
   )
   public abstract void vmethod3091(Component var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1704055059"
   )
   public abstract int vmethod3094();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass224;Lclass224;I)V",
      garbageValue = "-733391753"
   )
   static void method2833(class224 var0, class224 var1) {
      if(class31.field745 == null) {
         class31.field745 = class11.method152(class127.field2058, "sl_back", "");
      }

      if(null == class77.field1403) {
         class77.field1403 = class13.method170(class127.field2058, "sl_flags", "");
      }

      if(null == class158.field2604) {
         class158.field2604 = class13.method170(class127.field2058, "sl_arrows", "");
      }

      if(class31.field746 == null) {
         class31.field746 = class13.method170(class127.field2058, "sl_stars", "");
      }

      class79.method1808(class31.field748, 23, 765, 480, 0);
      class79.method1827(class31.field748, 0, 125, 23, 12425273, 9135624);
      class79.method1827(125 + class31.field748, 0, 640, 23, 5197647, 2697513);
      var0.method4004("Select a world", class31.field748 + 62, 15, 0, -1);
      if(null != class31.field746) {
         class31.field746[1].method1841(class31.field748 + 140, 1);
         var1.method4002("Members only world", 152 + class31.field748, 10, 16777215, -1);
         class31.field746[0].method1841(class31.field748 + 140, 12);
         var1.method4002("Free world", class31.field748 + 152, 21, 16777215, -1);
      }

      int var4;
      int var5;
      if(null != class158.field2604) {
         int var2 = 280 + class31.field748;
         if(class25.field631[0] == 0 && class25.field627[0] == 0) {
            class158.field2604[2].method1841(var2, 4);
         } else {
            class158.field2604[0].method1841(var2, 4);
         }

         if(0 == class25.field631[0] && 1 == class25.field627[0]) {
            class158.field2604[3].method1841(var2 + 15, 4);
         } else {
            class158.field2604[1].method1841(var2 + 15, 4);
         }

         var0.method4002("World", var2 + 32, 17, 16777215, -1);
         int var3 = class31.field748 + 390;
         if(1 == class25.field631[0] && class25.field627[0] == 0) {
            class158.field2604[2].method1841(var3, 4);
         } else {
            class158.field2604[0].method1841(var3, 4);
         }

         if(class25.field631[0] == 1 && class25.field627[0] == 1) {
            class158.field2604[3].method1841(15 + var3, 4);
         } else {
            class158.field2604[1].method1841(15 + var3, 4);
         }

         var0.method4002("Players", 32 + var3, 17, 16777215, -1);
         var4 = class31.field748 + 500;
         if(class25.field631[0] == 2 && class25.field627[0] == 0) {
            class158.field2604[2].method1841(var4, 4);
         } else {
            class158.field2604[0].method1841(var4, 4);
         }

         if(class25.field631[0] == 2 && class25.field627[0] == 1) {
            class158.field2604[3].method1841(var4 + 15, 4);
         } else {
            class158.field2604[1].method1841(var4 + 15, 4);
         }

         var0.method4002("Location", var4 + 32, 17, 16777215, -1);
         var5 = class31.field748 + 610;
         if(3 == class25.field631[0] && class25.field627[0] == 0) {
            class158.field2604[2].method1841(var5, 4);
         } else {
            class158.field2604[0].method1841(var5, 4);
         }

         if(class25.field631[0] == 3 && 1 == class25.field627[0]) {
            class158.field2604[3].method1841(15 + var5, 4);
         } else {
            class158.field2604[1].method1841(var5 + 15, 4);
         }

         var0.method4002("Type", 32 + var5, 17, 16777215, -1);
      }

      class79.method1808(708 + class31.field748, 4, 50, 16, 0);
      var1.method4004("Cancel", class31.field748 + 708 + 25, 16, 16777215, -1);
      class31.field747 = -1;
      if(class31.field745 != null) {
         byte var21 = 88;
         byte var23 = 19;
         var4 = 765 / (1 + var21);
         var5 = 480 / (var23 + 1);

         int var6;
         int var7;
         do {
            var6 = var5;
            var7 = var4;
            if((var4 - 1) * var5 >= class25.field628) {
               --var4;
            }

            if(var4 * (var5 - 1) >= class25.field628) {
               --var5;
            }

            if((var5 - 1) * var4 >= class25.field628) {
               --var5;
            }
         } while(var6 != var5 || var4 != var7);

         var6 = (765 - var4 * var21) / (1 + var4);
         if(var6 > 5) {
            var6 = 5;
         }

         var7 = (480 - var23 * var5) / (var5 + 1);
         if(var7 > 5) {
            var7 = 5;
         }

         int var8 = (765 - var4 * var21 - (var4 - 1) * var6) / 2;
         int var9 = (480 - var5 * var23 - var7 * (var5 - 1)) / 2;
         int var10 = var9 + 23;
         int var11 = var8 + class31.field748;
         int var12 = 0;
         boolean var13 = false;

         int var14;
         for(var14 = 0; var14 < class25.field628; ++var14) {
            class25 var15 = class25.field636[var14];
            boolean var16 = true;
            String var17 = Integer.toString(var15.field634);
            if(-1 == var15.field634) {
               var17 = "OFF";
               var16 = false;
            } else if(var15.field634 > 1980) {
               var17 = "FULL";
               var16 = false;
            }

            int var19 = 0;
            byte var18;
            if(var15.method585()) {
               if(var15.method580()) {
                  var18 = 7;
               } else {
                  var18 = 6;
               }
            } else if(var15.method584()) {
               var19 = 16711680;
               if(var15.method580()) {
                  var18 = 5;
               } else {
                  var18 = 4;
               }
            } else if(var15.method582()) {
               if(var15.method580()) {
                  var18 = 3;
               } else {
                  var18 = 2;
               }
            } else if(var15.method580()) {
               var18 = 1;
            } else {
               var18 = 0;
            }

            if(class140.field2162 >= var11 && class140.field2163 >= var10 && class140.field2162 < var21 + var11 && class140.field2163 < var10 + var23 && var16) {
               class31.field747 = var14;
               class31.field745[var18].method1725(var11, var10, 128, 16777215);
               var13 = true;
            } else {
               class31.field745[var18].method1674(var11, var10);
            }

            if(null != class77.field1403) {
               class77.field1403[(var15.method580()?8:0) + var15.field637].method1841(29 + var11, var10);
            }

            var0.method4004(Integer.toString(var15.field632), var11 + 15, var10 + var23 / 2 + 5, var19, -1);
            var1.method4004(var17, var11 + 60, var23 / 2 + var10 + 5, 268435455, -1);
            var10 += var23 + var7;
            ++var12;
            if(var12 >= var5) {
               var10 = 23 + var9;
               var11 += var6 + var21;
               var12 = 0;
            }
         }

         if(var13) {
            var14 = var1.method3997(class25.field636[class31.field747].field641) + 6;
            int var24 = var1.field3189 + 8;
            class79.method1808(class140.field2162 - var14 / 2, class140.field2163 + 20 + 5, var14, var24, 16777120);
            class79.method1779(class140.field2162 - var14 / 2, class140.field2163 + 20 + 5, var14, var24, 0);
            var1.method4004(class25.field636[class31.field747].field641, class140.field2162, 4 + 20 + class140.field2163 + 5 + var1.field3189, 0, -1);
         }
      }

      try {
         Graphics var22 = class122.field2024.getGraphics();
         class135.field2094.vmethod1857(var22, 0, 0);
      } catch (Exception var20) {
         class122.field2024.repaint();
      }

   }
}
