import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("r")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 415059661
   )
   static int field222;
   @ObfuscatedName("cv")
   static class227 field225;
   @ObfuscatedName("j")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};
   @ObfuscatedName("x")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "-1358233621"
   )
   @Export("addMenuEntry")
   static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            ++Client.menuOptionCount;
         }

      }
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-3"
   )
   static final void method183(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field314 && var0 != FrameMap.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = Projectile.region.method1974(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = Projectile.region.method2096(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = Projectile.region.method2014(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = Projectile.region.method2111(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = Projectile.region.method1978(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               Projectile.region.method1965(var0, var2, var3);
               var12 = class1.getObjectDefinition(var13);
               if(var12.field940 != 0) {
                  Client.collisionMaps[var0].method2471(var2, var3, var14, var15, var12.field973);
               }
            }

            if(var1 == 1) {
               Projectile.region.method1966(var0, var2, var3);
            }

            if(var1 == 2) {
               Projectile.region.method1967(var0, var2, var3);
               var12 = class1.getObjectDefinition(var13);
               if(var2 + var12.field938 > 103 || var3 + var12.field938 > 103 || var12.field939 + var2 > 103 || var12.field939 + var3 > 103) {
                  return;
               }

               if(var12.field940 != 0) {
                  Client.collisionMaps[var0].method2449(var2, var3, var12.field938, var12.field939, var15, var12.field973);
               }
            }

            if(var1 == 3) {
               Projectile.region.method1968(var0, var2, var3);
               var12 = class1.getObjectDefinition(var13);
               if(var12.field940 == 1) {
                  Client.collisionMaps[var0].method2473(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class5.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            WidgetNode.method43(var0, var11, var2, var3, var4, var5, var6, Projectile.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)[Lclass85;",
      garbageValue = "2"
   )
   public static class85[] method185() {
      return new class85[]{class85.field1467, class85.field1466, class85.field1469, class85.field1474, class85.field1464};
   }
}
