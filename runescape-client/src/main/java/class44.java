import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
final class class44 implements Comparator {
   @ObfuscatedName("eq")
   static SpritePixels[] field898;
   @ObfuscatedName("au")
   static class184 field900;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "63"
   )
   int method781(class2 var1, class2 var2) {
      if(var1.field23 == var2.field23) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field23 == Client.world) {
               return -1;
            }

            if(var2.field23 == Client.world) {
               return 1;
            }
         }

         return var1.field23 < var2.field23?-1:1;
      }
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1791714106"
   )
   public static final boolean method782() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1701 == class105.field1696) {
            return false;
         } else {
            Tile.field1352 = class105.field1698[class105.field1701];
            XClanMember.field275 = class105.field1697[class105.field1701];
            class105.field1701 = class105.field1701 + 1 & 127;
            return true;
         }
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method781((class2)var1, (class2)var2);
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "2065848882"
   )
   static final boolean method789(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field453 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field284.method3065(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field284.method3066(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field284.method3067(false);
         }

         if(var1 == 325) {
            Client.field284.method3067(true);
         }

         if(var1 == 326) {
            Client.field294.method2976(140);
            Client.field284.method3068(Client.field294);
            return true;
         } else {
            return false;
         }
      }
   }
}
