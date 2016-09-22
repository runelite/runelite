import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("v")
   boolean field60 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1045368621
   )
   int field61;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1530175081
   )
   @Export("id")
   int id;
   @ObfuscatedName("iy")
   static class32 field65;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -1458048215
   )
   static int field66;
   @ObfuscatedName("hg")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "417914389"
   )
   static final void method41() {
      if(null != class13.field192) {
         class13.field192.method1235();
      }

      if(null != Projectile.field101) {
         Projectile.field101.method1235();
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "7"
   )
   static final void method42(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class5.tileHeights[var0][var1 + var3][var2 + var4] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var1][var2 + var3] = class5.tileHeights[var0][var1 - 1][var2 + var3];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class5.tileHeights[var0][var3 + var1][var2] = class5.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class5.tileHeights[var0][var1 - 1][var2] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class5.tileHeights[var0][var1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class5.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class5.tileHeights[var0][var1][var2] = class5.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-378161719"
   )
   static final void method43(int var0) {
      if(class93.method2114(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(null != var3) {
               var3.field2862 = 0;
               var3.field2825 = 0;
            }
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public static void method44() {
      class50.field1118.reset();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "576711826"
   )
   static void method45(int var0) {
      Client.field493 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class22.method580();
      if(Client.gameState >= 25) {
         XClanMember.method603();
      }

      GameEngine.field2273 = true;
   }
}
