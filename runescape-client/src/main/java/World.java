import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("World")
public class World {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -2114649381
   )
   @Export("id")
   int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1183276711
   )
   static int field675 = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1519764421
   )
   static int field676 = 0;
   @ObfuscatedName("a")
   static int[] field678 = new int[]{0, 1, 2, 3};
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1219448357
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1118134913
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("o")
   @Export("address")
   String address;
   @ObfuscatedName("q")
   @Export("activity")
   String activity;
   @ObfuscatedName("m")
   static int[] field684 = new int[]{1, 1, 1, 1};
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1726962403
   )
   @Export("index")
   int index;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 803558811
   )
   @Export("location")
   int location;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1211198616"
   )
   boolean method649() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "967826713"
   )
   boolean method650() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "996588442"
   )
   boolean method652() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "719376653"
   )
   boolean method653() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "6"
   )
   boolean method658() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "7979"
   )
   boolean method681() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-878256816"
   )
   static void method693() {
      for(class31 var0 = (class31)class31.field703.method2503(); null != var0; var0 = (class31)class31.field703.method2492()) {
         if(null != var0.field709) {
            Client.field572.method1000(var0.field709);
            var0.field709 = null;
         }

         if(null != var0.field701) {
            Client.field572.method1000(var0.field701);
            var0.field701 = null;
         }
      }

      class31.field703.method2507();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1291033081"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(Client.gameState != var0) {
         if(Client.gameState == 0) {
            Item.method877();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.field321 = 0;
            Client.field322 = 0;
            Client.field323 = 0;
         }

         if(var0 != 20 && var0 != 40 && null != class22.field236) {
            class22.field236.method2139();
            class22.field236 = null;
         }

         if(Client.gameState == 25) {
            Client.field348 = 0;
            Client.field387 = 0;
            Client.field474 = 1;
            Client.field352 = 0;
            Client.field508 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class10.method130(class110.canvas, Friend.field146, class39.field808, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class10.method130(class110.canvas, Friend.field146, class39.field808, false, 4);
            } else if(class41.field858) {
               class41.field821 = null;
               class41.field826 = null;
               ScriptState.field95 = null;
               class41.field824 = null;
               class41.field825 = null;
               class168.field2191 = null;
               class189.field2789 = null;
               FaceNormal.field1568 = null;
               class41.field835 = null;
               class157.field2114 = null;
               Script.field960 = null;
               class39.field806 = null;
               class139.field1955 = null;
               class41.field852 = null;
               class41.field830 = null;
               NPC.field765 = null;
               PlayerComposition.field2178 = null;
               class211.field3132 = null;
               class185.field2768 = null;
               XGrandExchangeOffer.field34 = null;
               class47.field946 = null;
               class30.field688 = null;
               WallObject.method1982(2);
               class172.method3331(true);
               class41.field858 = false;
            }
         } else {
            class10.method130(class110.canvas, Friend.field146, class39.field808, true, 0);
         }

         Client.gameState = var0;
      }
   }
}
