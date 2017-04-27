import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class107 {
   @ObfuscatedName("be")
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("n")
   static Hashtable field1715 = new Hashtable(16);
   @ObfuscatedName("ec")
   static SpritePixels[] field1719;
   @ObfuscatedName("d")
   static boolean field1721 = false;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-156876436"
   )
   static boolean method2050(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   class107() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-303486117"
   )
   public static void method2056(Buffer var0, int var1) {
      if(class104.field1679 != null) {
         try {
            class104.field1679.method1395(0L);
            class104.field1679.method1415(var0.payload, var1, 24);
         } catch (Exception var3) {
            ;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1838667607"
   )
   static int method2057(int var0, Script var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class32.field720[--class32.field715];
         var3 = class128.method2364(var4);
      } else {
         var3 = var2?class200.field2894:Script.field942;
      }

      if(var0 == 1100) {
         class32.field715 -= 2;
         var3.scrollX = class32.field720[class32.field715];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class32.field720[class32.field715 + 1];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class124.method2350(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2236 = class32.field720[--class32.field715] == 1;
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2282 = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.textureId = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2196 = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2245 = class32.field720[--class32.field715] == 1;
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class32.field720[--class32.field715];
         class124.method2350(var3);
         return 1;
      } else if(var0 == 1109) {
         class32.field715 -= 6;
         var3.field2256 = class32.field720[class32.field715];
         var3.field2257 = class32.field720[class32.field715 + 1];
         var3.rotationX = class32.field720[class32.field715 + 2];
         var3.rotationZ = class32.field720[class32.field715 + 3];
         var3.rotationY = class32.field720[class32.field715 + 4];
         var3.field2244 = class32.field720[class32.field715 + 5];
         class124.method2350(var3);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class32.field720[--class32.field715];
            if(var5 != var3.field2254) {
               var3.field2254 = var5;
               var3.field2329 = 0;
               var3.field2214 = 0;
               class124.method2350(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2230 = class32.field720[--class32.field715] == 1;
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1112) {
            String var8 = class32.scriptStringStack[--class32.scriptStringStackSize];
            if(!var8.equals(var3.text)) {
               var3.text = var8;
               class124.method2350(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1114) {
            class32.field715 -= 3;
            var3.field2270 = class32.field720[class32.field715];
            var3.field2271 = class32.field720[class32.field715 + 1];
            var3.field2287 = class32.field720[class32.field715 + 2];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2272 = class32.field720[--class32.field715] == 1;
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class32.field720[--class32.field715] == 1;
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class32.field720[--class32.field715] == 1;
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1120) {
            class32.field715 -= 2;
            var3.scrollWidth = class32.field720[class32.field715];
            var3.scrollHeight = class32.field720[class32.field715 + 1];
            class124.method2350(var3);
            if(var4 != -1 && var3.type == 0) {
               class164.method3116(class133.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            class40.method780(var3.id, var3.index);
            Client.field449 = var3;
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2243 = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2279 = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2248 = class32.field720[--class32.field715];
            class124.method2350(var3);
            return 1;
         } else if(var0 == 1125) {
            var5 = class32.field720[--class32.field715];
            class225[] var6 = new class225[]{class225.field3224, class225.field3222, class225.field3223, class225.field3220, class225.field3221};
            class225 var7 = (class225)class32.method708(var6, var5);
            if(var7 != null) {
               var3.field2238 = var7;
               class124.method2350(var3);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }
}
