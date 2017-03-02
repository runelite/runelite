import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1839909795
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -47527831
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -143503245
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 885586555
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1584812749
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("k")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1330016003
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1404469087
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -675253863
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2007017777
   )
   int field1613;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1245272705
   )
   int field1614;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1707721245
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1063559305
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1857610387
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("j")
   static class20 field1621;
   @ObfuscatedName("qh")
   protected static java.awt.Font field1622;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass139;B)Z",
      garbageValue = "-87"
   )
   public static boolean method1980(class182 var0, class182 var1, class182 var2, class139 var3) {
      class138.field1916 = var0;
      class138.field1913 = var1;
      class138.field1914 = var2;
      class39.field800 = var3;
      return true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2133680974"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class22.field233 = null;
            field1622 = null;
            class49.field944 = null;
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field317 = 0;
            Client.field318 = 0;
            Client.field319 = 0;
         }

         if(var0 != 20 && var0 != 40 && class152.field2056 != null) {
            class152.field2056.method2109();
            class152.field2056 = null;
         }

         if(Client.gameState == 25) {
            Client.field344 = 0;
            Client.field340 = 0;
            Client.field395 = 1;
            Client.field532 = 0;
            Client.field343 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class36.method799(class0.canvas, WallObject.field1545, class114.field1790, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class36.method799(class0.canvas, WallObject.field1545, class114.field1790, false, 4);
            } else if(class41.field819) {
               class41.field818 = null;
               class41.field816 = null;
               class6.field53 = null;
               class41.field820 = null;
               class41.field846 = null;
               XGrandExchangeOffer.field43 = null;
               class7.field64 = null;
               class41.field822 = null;
               class41.field837 = null;
               class25.field575 = null;
               class16.field172 = null;
               class116.field1817 = null;
               class179.field2691 = null;
               class38.field795 = null;
               class159.field2122 = null;
               class72.field1173 = null;
               class36.field761 = null;
               class150.field2037 = null;
               Buffer.field2088 = null;
               class13.field130 = null;
               class41.field828 = null;
               class5.field51 = null;
               class33.method765(2);
               class30.method695(true);
               class41.field819 = false;
            }
         } else {
            class36.method799(class0.canvas, WallObject.field1545, class114.field1790, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
