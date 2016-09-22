import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aj")
public class class51 extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1059865629
   )
   int field1123 = -1;
   @ObfuscatedName("d")
   static class170 field1124;
   @ObfuscatedName("v")
   static class170 field1125;
   @ObfuscatedName("r")
   static NodeCache field1126 = new NodeCache(64);
   @ObfuscatedName("z")
   @Export("spriteCache")
   static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("t")
   static NodeCache field1128 = new NodeCache(20);
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1066796385
   )
   int field1130 = -1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 130947435
   )
   int field1131 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 540946723
   )
   public int field1132 = 70;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 454552381
   )
   int field1133 = -1;
   @ObfuscatedName("a")
   static class170 field1134;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2074997083
   )
   int field1135 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1715288335
   )
   public int field1137 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2022426057
   )
   public int field1138 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -500343879
   )
   public int field1139 = -1;
   @ObfuscatedName("e")
   String field1140 = "";
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1386061407
   )
   public int field1141 = -1;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 125932215
   )
   public int field1142 = 16777215;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 890774853
   )
   public int field1143 = 0;

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "85"
   )
   static final void method1048(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class93.method2114(var0)) {
         class18.field249 = null;
         class107.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class18.field249 != null) {
            class107.gameDraw(class18.field249, -1412584499, var1, var2, var3, var4, class117.field2048, class24.field628, var7);
            class18.field249 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field374[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field374[var8] = true;
            }
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "1"
   )
   public SpritePixels method1050() {
      if(this.field1123 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1123);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class20.method565(field1124, this.field1123, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1123);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1968890315"
   )
   public String method1051(int var1) {
      String var2 = this.field1140;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class24.method599(var1, false) + var2.substring(2 + var3);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1889919597"
   )
   public SpritePixels method1053() {
      if(this.field1133 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1133);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class20.method565(field1124, this.field1133, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1133);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2042971075"
   )
   public SpritePixels method1055() {
      if(this.field1131 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1131);
         if(null != var1) {
            return var1;
         } else {
            var1 = class20.method565(field1124, this.field1131, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1131);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "-1848390547"
   )
   public class227 method1056() {
      if(this.field1130 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1128.get((long)this.field1130);
         if(null != var1) {
            return var1;
         } else {
            class170 var3 = field1124;
            class170 var4 = field1125;
            int var5 = this.field1130;
            class227 var2;
            if(!class126.method2817(var3, var5, 0)) {
               var2 = null;
            } else {
               byte[] var7 = var4.method3309(var5, 0);
               class227 var6;
               if(var7 == null) {
                  var6 = null;
               } else {
                  class227 var8 = new class227(var7, class79.field1462, class79.field1458, class59.field1268, class79.field1461, class132.field2126, class8.field139);
                  class35.method747();
                  var6 = var8;
               }

               var2 = var6;
            }

            return var2;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1789512742"
   )
   public SpritePixels method1057() {
      if(this.field1135 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1135);
         if(null != var1) {
            return var1;
         } else {
            var1 = class20.method565(field1124, this.field1135, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1135);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("qx")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-27"
   )
   protected static final void method1071() {
      Frames.field1852 = null;
      class32.field731 = null;
      FrameMap.field1845 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1611515396"
   )
   void method1076(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1130 = var1.method2543();
      } else if(var2 == 2) {
         this.field1142 = var1.method2532();
      } else if(var2 == 3) {
         this.field1123 = var1.method2543();
      } else if(var2 == 4) {
         this.field1135 = var1.method2543();
      } else if(var2 == 5) {
         this.field1133 = var1.method2543();
      } else if(var2 == 6) {
         this.field1131 = var1.method2543();
      } else if(var2 == 7) {
         this.field1137 = var1.method2618();
      } else if(var2 == 8) {
         this.field1140 = var1.method2531();
      } else if(var2 == 9) {
         this.field1132 = var1.method2717();
      } else if(var2 == 10) {
         this.field1138 = var1.method2618();
      } else if(var2 == 11) {
         this.field1139 = 0;
      } else if(var2 == 12) {
         this.field1141 = var1.method2528();
      } else if(var2 == 13) {
         this.field1143 = var1.method2618();
      } else if(var2 == 14) {
         this.field1139 = var1.method2717();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "97"
   )
   void method1086(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1076(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lclass171;",
      garbageValue = "-2129259469"
   )
   static class171 method1087(int var0, boolean var1, boolean var2, boolean var3) {
      class137 var4 = null;
      if(null != class152.field2304) {
         var4 = new class137(var0, class152.field2304, class232.field3276[var0], 1000000);
      }

      return new class171(var4, class13.field188, var0, var1, var2, var3);
   }
}
