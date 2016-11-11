import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("ck")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 76106359
   )
   static int field1731;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -589550963
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1506709547
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("n")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("u")
   @Export("top")
   Renderable top;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 142183241
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2118354301
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2068871161
   )
   @Export("hash")
   int hash;

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2146353208"
   )
   static void method2243() {
      int var0 = class62.field1267;
      int var1 = class77.field1428;
      if(class116.field2012 < var0) {
         var0 = class116.field2012;
      }

      if(class18.field276 < var1) {
         var1 = class18.field276;
      }

      if(Player.field42 != null) {
         try {
            Client var2 = class168.field2706;
            int var3 = Client.isResized?2:1;
            Object[] var4 = new Object[]{Integer.valueOf(var3)};
            JSObject.getWindow(var2).call("resize", var4);
         } catch (Throwable var5) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   public static String method2244(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; 0L != var3; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); 0L != var0; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class165.field2698[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
