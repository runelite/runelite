import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class181 extends CacheableNode {
   @ObfuscatedName("h")
   byte field2702;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1931519421
   )
   int field2703;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 1401970109
   )
   static int field2704;
   @ObfuscatedName("b")
   public static class181 field2706;
   @ObfuscatedName("q")
   class184 field2707;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "-482208937"
   )
   static int method3299(int var0, class48 var1, boolean var2) {
      int var4 = -1;
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var4 = class32.field747[--class103.field1686];
         var3 = class179.method3296(var4);
      } else {
         var3 = var2?XGrandExchangeOffer.field58:XClanMember.field297;
      }

      if(var0 == 1100) {
         class103.field1686 -= 2;
         var3.scrollX = class32.field747[class103.field1686];
         if(var3.scrollX > var3.scrollWidth - var3.width) {
            var3.scrollX = var3.scrollWidth - var3.width;
         }

         if(var3.scrollX < 0) {
            var3.scrollX = 0;
         }

         var3.scrollY = class32.field747[1 + class103.field1686];
         if(var3.scrollY > var3.scrollHeight - var3.height) {
            var3.scrollY = var3.scrollHeight - var3.height;
         }

         if(var3.scrollY < 0) {
            var3.scrollY = 0;
         }

         class174.method3276(var3);
         return 1;
      } else if(var0 == 1101) {
         var3.textColor = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1102) {
         var3.field2234 = class32.field747[--class103.field1686] == 1;
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1103) {
         var3.opacity = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1104) {
         var3.field2289 = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1105) {
         var3.textureId = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1106) {
         var3.field2242 = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1107) {
         var3.field2243 = class32.field747[--class103.field1686] == 1;
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1108) {
         var3.modelType = 1;
         var3.modelId = class32.field747[--class103.field1686];
         class174.method3276(var3);
         return 1;
      } else if(var0 == 1109) {
         class103.field1686 -= 6;
         var3.field2254 = class32.field747[class103.field1686];
         var3.field2255 = class32.field747[1 + class103.field1686];
         var3.rotationX = class32.field747[2 + class103.field1686];
         var3.rotationZ = class32.field747[class103.field1686 + 3];
         var3.rotationY = class32.field747[4 + class103.field1686];
         var3.field2259 = class32.field747[5 + class103.field1686];
         class174.method3276(var3);
         return 1;
      } else {
         int var5;
         if(var0 == 1110) {
            var5 = class32.field747[--class103.field1686];
            if(var3.field2230 != var5) {
               var3.field2230 = var5;
               var3.field2327 = 0;
               var3.field2328 = 0;
               class174.method3276(var3);
            }

            return 1;
         } else if(var0 == 1111) {
            var3.field2262 = class32.field747[--class103.field1686] == 1;
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1112) {
            String var7 = class32.chatboxSegments[--class32.field749];
            if(!var7.equals(var3.text)) {
               var3.text = var7;
               class174.method3276(var3);
            }

            return 1;
         } else if(var0 == 1113) {
            var3.fontId = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1114) {
            class103.field1686 -= 3;
            var3.field2268 = class32.field747[class103.field1686];
            var3.field2269 = class32.field747[1 + class103.field1686];
            var3.field2267 = class32.field747[class103.field1686 + 2];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1115) {
            var3.field2270 = class32.field747[--class103.field1686] == 1;
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1116) {
            var3.borderThickness = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1117) {
            var3.sprite2 = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1118) {
            var3.flippedVertically = class32.field747[--class103.field1686] == 1;
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1119) {
            var3.flippedHorizontally = class32.field747[--class103.field1686] == 1;
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1120) {
            class103.field1686 -= 2;
            var3.scrollWidth = class32.field747[class103.field1686];
            var3.scrollHeight = class32.field747[1 + class103.field1686];
            class174.method3276(var3);
            if(var4 != -1 && var3.type == 0) {
               class154.method3034(Widget.widgets[var4 >> 16], var3, false);
            }

            return 1;
         } else if(var0 == 1121) {
            Projectile.method872(var3.id, var3.index);
            Client.field469 = var3;
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1122) {
            var3.field2338 = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1123) {
            var3.field2313 = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1124) {
            var3.field2237 = class32.field747[--class103.field1686];
            class174.method3276(var3);
            return 1;
         } else if(var0 == 1125) {
            var5 = class32.field747[--class103.field1686];
            class221 var6 = (class221)class119.method2341(class44.method892(), var5);
            if(var6 != null) {
               var3.field2235 = var6;
               class174.method3276(var3);
            }

            return 1;
         } else {
            return 2;
         }
      }
   }
}
