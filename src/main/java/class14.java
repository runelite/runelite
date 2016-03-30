import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class14 {
   @ObfuscatedName("hf")
   @ObfuscatedGetter(
      intValue = 1855983109
   )
   static int field219;
   @ObfuscatedName("t")
   int[] field221;
   @ObfuscatedName("p")
   String[] field222;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 938544147
   )
   int field223 = -1;
   @ObfuscatedName("pn")
   static class160 field224;
   @ObfuscatedName("z")
   public static boolean field225;
   @ObfuscatedName("w")
   class22 field226;

   @ObfuscatedName("w")
   public static synchronized long method165() {
      long var0 = System.currentTimeMillis();
      if(var0 < class115.field1991) {
         class109.field1915 += class115.field1991 - var0;
      }

      class115.field1991 = var0;
      return class109.field1915 + var0;
   }

   @ObfuscatedName("e")
   static boolean method166(class122 var0, int var1) {
      int var2 = var0.method2777(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(0 == var2) {
         if(var0.method2777(1) != 0) {
            method166(var0, var1);
         }

         var3 = var0.method2777(6);
         var4 = var0.method2777(6);
         boolean var11 = var0.method2777(1) == 1;
         if(var11) {
            class32.field748[++class32.field758 - 1] = var1;
         }

         if(null != client.field415[var1]) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field415[var1] = new class2();
            var12.field60 = var1;
            if(class32.field749[var1] != null) {
               var12.method22(class32.field749[var1]);
            }

            if(class32.field750[var1] != null) {
               var12.field59 = class32.field750[var1];
            }

            var12.field847 = class32.field761[var1];
            var12.field851 = class32.field755[var1];
            var7 = class32.field764[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field874[0] = class32.field754[var1];
            var12.field62 = (byte)var8;
            var12.method17(var3 + (var9 << 6) - class41.field990, (var10 << 6) + var4 - class2.field37);
            var12.field61 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2777(2);
         var4 = class32.field764[var1];
         class32.field764[var1] = (var4 & 268435455) + (((var4 >> 28) + var3 & 3) << 28);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2777(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field764[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(1 == var5) {
               --var9;
            }

            if(2 == var5) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(4 == var5) {
               ++var8;
            }

            if(5 == var5) {
               --var8;
               ++var9;
            }

            if(6 == var5) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class32.field764[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2777(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field764[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var6 & 255;
            class32.field764[var1] = (var8 << 28) + (var9 << 14) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-40"
   )
   static void method167() {
      class31.field734 = class31.field734.trim();
      if(class31.field734.length() == 0) {
         class21.method590("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class35.method756();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = class52.method1112(var1, class31.field734);
         }

         switch(var0) {
         case 2:
            class21.method590("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field729 = 6;
            break;
         case 3:
            class21.method590("", "Error connecting to server.", "");
            break;
         case 4:
            class21.method590("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class21.method590("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class21.method590("", "Error connecting to server.", "");
            break;
         case 7:
            class21.method590("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("cl")
   static final void method168(int var0, int var1, int var2, boolean var3) {
      if(class39.method817(var0)) {
         class185.method3728(class173.field2830[var0], -1, var1, var2, var3);
      }
   }

   @ObfuscatedName("w")
   public static void method169(class167 var0) {
      class52.field1166 = var0;
      class52.field1165 = class52.field1166.method3330(16);
   }
}
