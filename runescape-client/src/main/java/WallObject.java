import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 691467085
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1563992657
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -139104819
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1616796099
   )
   int field1545;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2114337975
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("c")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1116881857
   )
   int field1548;
   @ObfuscatedName("d")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 196548195
   )
   int field1550 = 0;

   @ObfuscatedName("de")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-434547521"
   )
   static final void method1845(Widget var0, int var1, int var2) {
      if(null == Client.field453 && !Client.isMenuOpen && null != var0) {
         Widget var3 = class140.method2605(var0);
         if(null == var3) {
            var3 = var0.parent;
         }

         if(var3 != null) {
            Client.field453 = var0;
            var3 = class140.method2605(var0);
            if(null == var3) {
               var3 = var0.parent;
            }

            Client.field454 = var3;
            Client.field455 = var1;
            Client.field550 = var2;
            class94.field1581 = 0;
            Client.field464 = false;
            if(Client.menuOptionCount > 0) {
               class72.method1363(Client.menuOptionCount - 1);
            }

            return;
         }
      }

   }

   @ObfuscatedName("ex")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "16777215"
   )
   static boolean method1846(Widget var0) {
      if(Client.field414) {
         if(GameObject.method1872(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }
}
