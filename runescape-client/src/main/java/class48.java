import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
public class class48 extends class207 {
   @ObfuscatedName("h")
   public boolean field1077 = true;
   @ObfuscatedName("g")
   public static class196 field1078 = new class196(64);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1935056289
   )
   public int field1079 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -699344059
   )
   public int field1080;
   @ObfuscatedName("bq")
   static class83[] field1081;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1452288537
   )
   public int field1082 = -1;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1627212499
   )
   public int field1083;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1317152211
   )
   public int field1084;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -290744143
   )
   public int field1085;
   @ObfuscatedName("l")
   public static class170 field1086;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -706218341
   )
   public int field1087 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -517340639
   )
   public int field1088;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 965181931
   )
   public int field1090;
   @ObfuscatedName("dl")
   @ObfuscatedGetter(
      intValue = 94916463
   )
   static int field1092;
   @ObfuscatedName("o")
   static String field1097;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1976911261"
   )
   void method1013() {
      if(this.field1082 != -1) {
         this.method1027(this.field1082);
         this.field1090 = this.field1083;
         this.field1080 = this.field1084;
         this.field1088 = this.field1085;
      }

      this.method1027(this.field1079);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "324348032"
   )
   void method1014(class122 var1, int var2) {
      while(true) {
         int var3 = var1.method2633();
         if(var3 == 0) {
            return;
         }

         this.method1015(var1, var3, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass122;III)V",
      garbageValue = "1044780503"
   )
   void method1015(class122 var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1079 = var1.method2637();
      } else if(var2 == 2) {
         this.field1087 = var1.method2633();
      } else if(var2 == 5) {
         this.field1077 = false;
      } else if(var2 == 7) {
         this.field1082 = var1.method2637();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-281153004"
   )
   void method1027(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var10 == var6) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field1083 = (int)(256.0D * var12);
      this.field1084 = (int)(256.0D * var14);
      this.field1085 = (int)(var16 * 256.0D);
      if(this.field1084 < 0) {
         this.field1084 = 0;
      } else if(this.field1084 > 255) {
         this.field1084 = 255;
      }

      if(this.field1085 < 0) {
         this.field1085 = 0;
      } else if(this.field1085 > 255) {
         this.field1085 = 255;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass171;",
      garbageValue = "-339302176"
   )
   static class171 method1033(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(class152.field2296 != null) {
         var4 = new class137(var0, class152.field2296, class8.field152[var0], 1000000);
      }

      return new class171(var4, class159.field2367, var0, var1, var2, var3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "53"
   )
   public static int method1034(int var0, int var1, int var2) {
      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0:7 - var1));
   }
}
