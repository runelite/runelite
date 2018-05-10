import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
@Implements("World")
public class World {
   @ObfuscatedName("rd")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1767466175
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 951177231
   )
   static int field956;
   @ObfuscatedName("x")
   static int[] field969;
   @ObfuscatedName("j")
   static int[] field958;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("listFetcher")
   static UrlRequest listFetcher;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1542710865
   )
   @Export("id")
   int id;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1434667055
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -474025673
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("p")
   @Export("address")
   String address;
   @ObfuscatedName("g")
   @Export("activity")
   String activity;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -895673853
   )
   @Export("location")
   int location;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1045042407
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field956 = 0;
      field969 = new int[]{1, 1, 1, 1};
      field958 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   boolean method1603() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-76"
   )
   boolean method1629() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2067933092"
   )
   boolean method1605() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-668792967"
   )
   boolean method1606() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-893888314"
   )
   boolean method1639() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1960836052"
   )
   boolean method1607() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-14232"
   )
   static final void method1647(int var0, int var1) {
      if(Client.hintArrowTargetType == 2) {
         KeyFocusListener.worldToScreen((Client.hintArrowX - class178.baseX << 7) + Client.hintArrowOffsetX, (Client.hintArrowY - CombatInfoListHolder.baseY << 7) + Client.hintArrowOffsetY, Client.hintArrowOffsetZ * 2);
         if(Client.screenX > -1 && Client.gameCycle % 20 < 10) {
            class262.headIconsHint[0].drawAt(var0 + Client.screenX - 12, Client.screenY + var1 - 28);
         }

      }
   }
}
