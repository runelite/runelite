import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class48 extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1048681969
   )
   public int field1066;
   @ObfuscatedName("h")
   public static NodeCache field1067 = new NodeCache(64);
   @ObfuscatedName("n")
   public boolean field1068 = true;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 34170453
   )
   public int field1069 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1606290897
   )
   public int field1070 = -1;
   @ObfuscatedName("i")
   static class170 field1071;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 551428565
   )
   public int field1072 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1386826387
   )
   public int field1073;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1218595075
   )
   public int field1074;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1023602249
   )
   public int field1075;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -366730749
   )
   public int field1076;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1755184541
   )
   public int field1077;
   @ObfuscatedName("bw")
   @Export("host")
   static String host;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass56;",
      garbageValue = "216309606"
   )
   public static class56 method982(int var0) {
      class56 var1 = (class56)class56.field1223.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class220.field3215.method3292(16, var0);
         var1 = new class56();
         if(var2 != null) {
            var1.method1170(new Buffer(var2));
         }

         class56.field1223.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   void method983() {
      if(this.field1070 != -1) {
         this.method999(this.field1070);
         this.field1066 = this.field1074;
         this.field1076 = this.field1073;
         this.field1077 = this.field1075;
      }

      this.method999(this.field1072);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1185889976"
   )
   void method984(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2544();
         if(var3 == 0) {
            return;
         }

         this.method986(var1, var3, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1603406889"
   )
   void method986(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field1072 = var1.method2548();
      } else if(var2 == 2) {
         this.field1069 = var1.method2544();
      } else if(var2 == 5) {
         this.field1068 = false;
      } else if(var2 == 7) {
         this.field1070 = var1.method2548();
      } else if(var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1300"
   )
   static void method996() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3815(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3816()) {
         int var1 = var0.id;
         if(class14.method172(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].field2862;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class173.method3412(var4);
               if(var5 != null) {
                  class32.method673(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "404257479"
   )
   void method999(int var1) {
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

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1074 = (int)(256.0D * var12);
      this.field1073 = (int)(var14 * 256.0D);
      this.field1075 = (int)(var16 * 256.0D);
      if(this.field1073 < 0) {
         this.field1073 = 0;
      } else if(this.field1073 > 255) {
         this.field1073 = 255;
      }

      if(this.field1075 < 0) {
         this.field1075 = 0;
      } else if(this.field1075 > 255) {
         this.field1075 = 255;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IIS)Lclass227;",
      garbageValue = "21131"
   )
   public static class227 method1000(class170 var0, class170 var1, int var2, int var3) {
      if(!class22.method559(var0, var2, var3)) {
         return null;
      } else {
         byte[] var5 = var1.method3292(var2, var3);
         class227 var4;
         if(var5 == null) {
            var4 = null;
         } else {
            class227 var6 = new class227(var5, class79.field1439, class79.field1438, class79.field1443, class79.field1440, class129.field2092, class79.field1441);
            ChatLineBuffer.method649();
            var4 = var6;
         }

         return var4;
      }
   }
}
