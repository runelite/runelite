import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class51 extends CacheableNode {
   @ObfuscatedName("c")
   public static NodeCache field1112 = new NodeCache(64);
   @ObfuscatedName("f")
   static class170 field1113;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1132212135
   )
   int field1114 = -1;
   @ObfuscatedName("k")
   static class170 field1115;
   @ObfuscatedName("j")
   public static NodeCache field1116 = new NodeCache(20);
   @ObfuscatedName("z")
   String field1117 = "";
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1002308531
   )
   int field1119 = -1;
   @ObfuscatedName("v")
   @Export("spriteCache")
   public static NodeCache spriteCache = new NodeCache(64);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2111761317
   )
   public int field1121 = 70;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -306837209
   )
   int field1123 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1285387819
   )
   int field1124 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1903137361
   )
   int field1125 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -154574917
   )
   public int field1126 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -260601481
   )
   public int field1127 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1069230075
   )
   public int field1128 = 16777215;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1036535321
   )
   public int field1129 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 640059791
   )
   public int field1130 = -1;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2101361683
   )
   public int field1131 = 0;
   @ObfuscatedName("t")
   public int[] field1132;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 402640997
   )
   int field1133 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1320134807
   )
   int field1134 = -1;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-483999777"
   )
   void method1045(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1064(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Lclass51;",
      garbageValue = "-1015247382"
   )
   public final class51 method1047() {
      int var1 = -1;
      if(this.field1133 != -1) {
         var1 = class219.method3992(this.field1133);
      } else if(this.field1134 != -1) {
         var1 = class179.widgetSettings[this.field1134];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field1132.length - 1) {
         var2 = this.field1132[var1];
      } else {
         var2 = this.field1132[this.field1132.length - 1];
      }

      return var2 != -1?class43.method892(var2):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)LSpritePixels;",
      garbageValue = "-48"
   )
   public SpritePixels method1049() {
      if(this.field1114 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1114);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Client.method428(class181.field2961, this.field1114, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1114);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-901217598"
   )
   public SpritePixels method1051() {
      if(this.field1124 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1124);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Client.method428(class181.field2961, this.field1124, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1124);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "1511827894"
   )
   public SpritePixels method1052() {
      if(this.field1125 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1125);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Client.method428(class181.field2961, this.field1125, 0);
            if(null != var1) {
               spriteCache.put(var1, (long)this.field1125);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lclass227;",
      garbageValue = "-117780240"
   )
   public class227 method1056() {
      if(this.field1119 == -1) {
         return null;
      } else {
         class227 var1 = (class227)field1116.get((long)this.field1119);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class218.method3986(class181.field2961, field1113, this.field1119, 0);
            if(null != var1) {
               field1116.put(var1, (long)this.field1119);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "-1641081847"
   )
   public SpritePixels method1057() {
      if(this.field1123 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)spriteCache.get((long)this.field1123);
         if(var1 != null) {
            return var1;
         } else {
            var1 = Client.method428(class181.field2961, this.field1123, 0);
            if(var1 != null) {
               spriteCache.put(var1, (long)this.field1123);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-3"
   )
   void method1064(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1119 = var1.method2567();
      } else if(var2 == 2) {
         this.field1128 = var1.method2575();
      } else if(var2 == 3) {
         this.field1114 = var1.method2567();
      } else if(var2 == 4) {
         this.field1124 = var1.method2567();
      } else if(var2 == 5) {
         this.field1123 = var1.method2567();
      } else if(var2 == 6) {
         this.field1125 = var1.method2567();
      } else if(var2 == 7) {
         this.field1126 = var1.method2574();
      } else if(var2 == 8) {
         this.field1117 = var1.method2580();
      } else if(var2 == 9) {
         this.field1121 = var1.method2691();
      } else if(var2 == 10) {
         this.field1129 = var1.method2574();
      } else if(var2 == 11) {
         this.field1127 = 0;
      } else if(var2 == 12) {
         this.field1130 = var1.method2571();
      } else if(var2 == 13) {
         this.field1131 = var1.method2574();
      } else if(var2 == 14) {
         this.field1127 = var1.method2691();
      } else if(var2 == 17 || var2 == 18) {
         this.field1133 = var1.method2691();
         if(this.field1133 == '\uffff') {
            this.field1133 = -1;
         }

         this.field1134 = var1.method2691();
         if(this.field1134 == '\uffff') {
            this.field1134 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.method2691();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         int var4 = var1.method2571();
         this.field1132 = new int[2 + var4];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field1132[var5] = var1.method2691();
            if(this.field1132[var5] == '\uffff') {
               this.field1132[var5] = -1;
            }
         }

         this.field1132[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2131523909"
   )
   public String method1065(int var1) {
      String var2 = this.field1117;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         String var4 = var2.substring(0, var3);
         String var5 = Integer.toString(var1);
         var2 = var4 + var5 + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "1853356802"
   )
   static void method1075(String var0, String var1, String var2) {
      class33.loginMessage1 = var0;
      class33.loginMessage2 = var1;
      class33.loginMessage3 = var2;
   }
}
