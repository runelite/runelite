import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
public class class49 extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1309113679
   )
   int field1084 = -1;
   @ObfuscatedName("q")
   static class170 field1085;
   @ObfuscatedName("f")
   public static NodeCache field1086 = new NodeCache(64);
   @ObfuscatedName("k")
   static class170 field1087;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -551298339
   )
   public int field1088;
   @ObfuscatedName("c")
   public static NodeCache field1090 = new NodeCache(64);
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1273949033
   )
   public int field1091 = 255;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -882041847
   )
   public int field1092 = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 906673025
   )
   public int field1093 = 1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1248254725
   )
   public int field1094 = 70;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -54298083
   )
   public int field1096 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2096526475
   )
   int field1097 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 735381557
   )
   public int field1098 = 30;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -810053579
   )
   public int field1099 = 255;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "842466903"
   )
   void method1007(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1008(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-493033263"
   )
   void method1008(Buffer var1, int var2) {
      if(var2 == 1) {
         var1.method2691();
      } else if(var2 == 2) {
         this.field1099 = var1.method2571();
      } else if(var2 == 3) {
         this.field1091 = var1.method2571();
      } else if(var2 == 4) {
         this.field1092 = 0;
      } else if(var2 == 5) {
         this.field1094 = var1.method2691();
      } else if(var2 == 6) {
         var1.method2571();
      } else if(var2 == 7) {
         this.field1097 = var1.method2567();
      } else if(var2 == 8) {
         this.field1084 = var1.method2567();
      } else if(var2 == 11) {
         this.field1092 = var1.method2691();
      } else if(var2 == 14) {
         this.field1098 = var1.method2571();
      } else if(var2 == 15) {
         this.field1096 = var1.method2571();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1753498298"
   )
   public SpritePixels method1010() {
      if(this.field1084 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1090.get((long)this.field1084);
         if(null != var1) {
            return var1;
         } else {
            var1 = Client.method428(field1085, this.field1084, 0);
            if(var1 != null) {
               field1090.put(var1, (long)this.field1084);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1170227531"
   )
   public static void method1014(int var0, int var1) {
      class50 var2 = ClassInfo.method3965(var0);
      int var3 = var2.field1103;
      int var4 = var2.field1101;
      int var5 = var2.field1105;
      int var6 = class179.field2953[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class179.widgetSettings[var3] = class179.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "1372883362"
   )
   static final int method1015(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class94.field1651[var2 * 1024 / var3] >> 1;
      return ((65536 - var4) * var0 >> 16) + (var4 * var1 >> 16);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-121"
   )
   public SpritePixels method1028() {
      if(this.field1097 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field1090.get((long)this.field1097);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Client.method428(field1085, this.field1097, 0);
            if(null != var1) {
               field1090.put(var1, (long)this.field1097);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-73"
   )
   static final void method1029() {
      int var0 = class34.field777;
      int[] var1 = class34.field773;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(null != var3) {
            class62.method1302(var3, 1);
         }
      }

   }
}
