import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("x")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1707235755
   )
   @Export("world")
   int world;
   @ObfuscatedName("y")
   boolean field141;
   @ObfuscatedName("p")
   boolean field142;
   @ObfuscatedName("ds")
   @Export("region")
   static Region region;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1789774717
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("mm")
   @Export("clanMembers")
   static XClanMember[] clanMembers;
   @ObfuscatedName("be")
   static class184 field146;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = 1856475183
   )
   static int field148;
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = -935683149
   )
   protected static int field149;
   @ObfuscatedName("cf")
   static Font field151;

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "-1236710441"
   )
   static boolean method189(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class60.method1229(var0, class149.field2037);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class60.method1229(var3.name, class149.field2037))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class60.method1229(var3.previousName, class149.field2037))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(LWidget;IIZI)V",
      garbageValue = "2138594082"
   )
   static void method190(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2213 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2213 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2213 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.field2214 == 0) {
         var0.height = var0.field2199;
      } else if(var0.field2214 == 1) {
         var0.height = var2 - var0.field2199;
      } else if(var0.field2214 == 2) {
         var0.height = var2 * var0.field2199 >> 14;
      }

      if(var0.field2213 == 4) {
         var0.width = var0.height * var0.field2333 / var0.field2243;
      }

      if(var0.field2214 == 4) {
         var0.height = var0.width * var0.field2243 / var0.field2333;
      }

      if(Client.field470 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field461 = var0;
      }

      if(var3 && null != var0.field2315 && (var0.width != var4 || var0.height != var5)) {
         class18 var6 = new class18();
         var6.field188 = var0;
         var6.field196 = var0.field2315;
         Client.field488.method2511(var6);
      }

   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(LWidget;IB)Ljava/lang/String;",
      garbageValue = "-81"
   )
   static String method191(Widget var0, int var1) {
      int var3 = MessageNode.method220(var0);
      boolean var2 = (var3 >> 1 + var1 & 1) != 0;
      return !var2 && var0.field2306 == null?null:(null != var0.actions && var0.actions.length > var1 && null != var0.actions[var1] && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
