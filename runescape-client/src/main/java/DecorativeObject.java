import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 235862001
   )
   int field1587;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -595215287
   )
   @Export("x")
   int x;
   @ObfuscatedName("q")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("w")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1508956827
   )
   @Export("y")
   int y;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 182481635
   )
   int field1592;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -247251583
   )
   int field1593;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2032997785
   )
   int field1594;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2043862103
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1413534175
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2127619427
   )
   int field1597 = 0;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLclass208;I)V",
      garbageValue = "-608387578"
   )
   public static void method1893(class182 var0, class182 var1, boolean var2, class208 var3) {
      ItemComposition.field2952 = var0;
      ItemComposition.field2943 = var1;
      CombatInfoListHolder.isMembersWorld = var2;
      ItemComposition.field2948 = ItemComposition.field2952.method3220(10);
      class155.field2112 = var3;
   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1528550482"
   )
   static final void method1894(Widget var0, int var1, int var2) {
      if(null == Client.field511 && !Client.isMenuOpen) {
         if(null != var0 && class15.method171(var0) != null) {
            Client.field511 = var0;
            Client.field460 = class15.method171(var0);
            Client.field461 = var1;
            Client.field462 = var2;
            class72.field1191 = 0;
            Client.field470 = false;
            if(Client.menuOptionCount > 0) {
               int var3 = Client.menuOptionCount - 1;
               Player.field260 = new class38();
               Player.field260.field797 = Client.menuActionParams0[var3];
               Player.field260.field800 = Client.menuActionParams1[var3];
               Player.field260.field795 = Client.menuTypes[var3];
               Player.field260.field798 = Client.menuIdentifiers[var3];
               Player.field260.field799 = Client.menuOptions[var3];
            }

         }
      }
   }
}
