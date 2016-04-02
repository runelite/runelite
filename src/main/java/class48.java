import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public class class48 extends class204 {
   @ObfuscatedName("s")
   public char field1052;
   @ObfuscatedName("e")
   public static class167 field1053;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 828772259
   )
   public int field1054;
   @ObfuscatedName("p")
   public String field1055 = "null";
   @ObfuscatedName("r")
   public int[] field1056;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 595115783
   )
   public int field1057 = 0;
   @ObfuscatedName("a")
   public int[] field1058;
   @ObfuscatedName("f")
   public char field1059;
   @ObfuscatedName("k")
   public String[] field1060;
   @ObfuscatedName("x")
   static int[] field1061;
   @ObfuscatedName("gk")
   @ObfuscatedGetter(
      intValue = 2146074393
   )
   @Export("plane")
   static int field1063;
   @ObfuscatedName("w")
   static class193 field1065 = new class193(64);

   @ObfuscatedName("w")
   void method984(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(var2 == 0) {
            return;
         }

         this.method985(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass119;IB)V",
      garbageValue = "115"
   )
   void method985(class119 var1, int var2) {
      if(var2 == 1) {
         this.field1059 = (char)var1.method2523();
      } else if(var2 == 2) {
         this.field1052 = (char)var1.method2523();
      } else if(var2 == 3) {
         this.field1055 = var1.method2531();
      } else if(4 == var2) {
         this.field1054 = var1.method2528();
      } else {
         int var3;
         if(5 == var2) {
            this.field1057 = var1.method2700();
            this.field1058 = new int[this.field1057];
            this.field1060 = new String[this.field1057];

            for(var3 = 0; var3 < this.field1057; ++var3) {
               this.field1058[var3] = var1.method2528();
               this.field1060[var3] = var1.method2531();
            }
         } else if(var2 == 6) {
            this.field1057 = var1.method2700();
            this.field1058 = new int[this.field1057];
            this.field1056 = new int[this.field1057];

            for(var3 = 0; var3 < this.field1057; ++var3) {
               this.field1058[var3] = var1.method2528();
               this.field1056[var3] = var1.method2528();
            }
         }
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIZI)V",
      garbageValue = "1198239142"
   )
   static void method993(class173 var0, int var1, int var2, boolean var3) {
      int var4 = var0.field2770;
      int var5 = var0.field2834;
      if(0 == var0.field2762) {
         var0.field2770 = var0.field2766;
      } else if(1 == var0.field2762) {
         var0.field2770 = var1 - var0.field2766;
      } else if(var0.field2762 == 2) {
         var0.field2770 = var0.field2766 * var1 >> 14;
      }

      if(var0.field2763 == 0) {
         var0.field2834 = var0.field2767;
      } else if(var0.field2763 == 1) {
         var0.field2834 = var2 - var0.field2767;
      } else if(var0.field2763 == 2) {
         var0.field2834 = var2 * var0.field2767 >> 14;
      }

      if(4 == var0.field2762) {
         var0.field2770 = var0.field2772 * var0.field2834 / var0.field2773;
      }

      if(var0.field2763 == 4) {
         var0.field2834 = var0.field2770 * var0.field2773 / var0.field2772;
      }

      if(client.field448 && var0.field2757 == 0) {
         if(var0.field2834 < 5 && var0.field2770 < 5) {
            var0.field2834 = 5;
            var0.field2770 = 5;
         } else {
            if(var0.field2834 <= 0) {
               var0.field2834 = 5;
            }

            if(var0.field2770 <= 0) {
               var0.field2770 = 5;
            }
         }
      }

      if(1337 == var0.field2833) {
         client.field510 = var0;
      }

      if(var3 && null != var0.field2864 && (var0.field2770 != var4 || var0.field2834 != var5)) {
         class0 var6 = new class0();
         var6.field2 = var0;
         var6.field11 = var0.field2864;
         client.field466.method3834(var6);
      }

   }

   @ObfuscatedName("e")
   static class20[] method994() {
      return new class20[]{class20.field563, class20.field569, class20.field562, class20.field564};
   }

   @ObfuscatedName("e")
   static void method995() {
      class5.field81 = 99;
      class84.field1431 = new byte[4][104][104];
      class124.field2024 = new byte[4][104][104];
      class107.field1856 = new byte[4][104][104];
      class5.field82 = new byte[4][104][104];
      class4.field74 = new int[4][105][105];
      class5.field98 = new byte[4][105][105];
      class95.field1602 = new int[105][105];
      class191.field3076 = new int[104];
      class87.field1504 = new int[104];
      class89.field1529 = new int[104];
      class31.field723 = new int[104];
      class5.field84 = new int[104];
   }
}
