import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class186 extends CacheableNode {
   @ObfuscatedName("aj")
   static class184 field2766;
   @ObfuscatedName("n")
   public static class182 field2768;
   @ObfuscatedName("d")
   public static NodeCache field2769 = new NodeCache(64);
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -587898635
   )
   public int field2771 = 0;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "77"
   )
   public void method3468(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3469(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1757533365"
   )
   void method3469(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2771 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "2"
   )
   static boolean method3472(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class162.method3194(var0, class108.field1740);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class162.method3194(var3.name, class108.field1740))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class162.method3194(var3.previousName, class108.field1740))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IIB)Lclass208;",
      garbageValue = "-80"
   )
   public static class208 method3474(class182 var0, class182 var1, int var2, int var3) {
      return !KitDefinition.method3566(var0, var2, var3)?null:NPCComposition.method3778(var1.method3329(var2, var3));
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1019633907"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            class8.field71 = null;
            WallObject.field1547 = null;
            GameObject.field1617 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field452 = 0;
            Client.field322 = 0;
            Client.field323 = 0;
         }

         if(var0 != 20 && var0 != 40 && WidgetNode.field176 != null) {
            WidgetNode.field176.method2121();
            WidgetNode.field176 = null;
         }

         if(Client.gameState == 25) {
            Client.field367 = 0;
            Client.field342 = 0;
            Client.field343 = 1;
            Client.field344 = 0;
            Client.field345 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class101.method1987(class107.canvas, Client.field317, class156.field2240, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class101.method1987(class107.canvas, Client.field317, class156.field2240, false, 4);
            } else if(class41.field831) {
               class41.field818 = null;
               class41.field819 = null;
               class41.field820 = null;
               class41.field821 = null;
               class41.field822 = null;
               class41.field823 = null;
               class181.field2706 = null;
               class8.field69 = null;
               class6.field56 = null;
               Friend.field150 = null;
               class137.field1911 = null;
               class139.field1924 = null;
               class171.field2358 = null;
               class41.field841 = null;
               class137.field1909 = null;
               class38.field800 = null;
               class18.field200 = null;
               class107.field1730 = null;
               class188.field2780 = null;
               GroundObject.field1290 = null;
               class8.field72 = null;
               class119.field1848 = null;
               class138.field1917 = 1;
               class1.field12 = null;
               class138.field1918 = -1;
               Frames.field1566 = -1;
               class101.field1649 = 0;
               class34.field742 = false;
               class114.field1792 = 2;
               class7.method102(true);
               class41.field831 = false;
            }
         } else {
            class101.method1987(class107.canvas, Client.field317, class156.field2240, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
