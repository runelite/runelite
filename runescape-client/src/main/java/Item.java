import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -24083525
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 628658673
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Leh;",
      garbageValue = "0"
   )
   protected final Model getModel() {
      return FaceNormal.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1894168426"
   )
   public static void method1794() {
      Spotanim.spotanims.reset();
      Spotanim.field3323.reset();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "-1717259771"
   )
   static int method1795(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class251.field3392:class164.field2314;
      if(var0 == 1600) {
         class81.intStack[++class278.intStackSize - 1] = var3.scrollX;
         return 1;
      } else if(var0 == 1601) {
         class81.intStack[++class278.intStackSize - 1] = var3.scrollY;
         return 1;
      } else if(var0 == 1602) {
         class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var3.text;
         return 1;
      } else if(var0 == 1603) {
         class81.intStack[++class278.intStackSize - 1] = var3.scrollWidth;
         return 1;
      } else if(var0 == 1604) {
         class81.intStack[++class278.intStackSize - 1] = var3.scrollHeight;
         return 1;
      } else if(var0 == 1605) {
         class81.intStack[++class278.intStackSize - 1] = var3.modelZoom;
         return 1;
      } else if(var0 == 1606) {
         class81.intStack[++class278.intStackSize - 1] = var3.rotationX;
         return 1;
      } else if(var0 == 1607) {
         class81.intStack[++class278.intStackSize - 1] = var3.rotationY;
         return 1;
      } else if(var0 == 1608) {
         class81.intStack[++class278.intStackSize - 1] = var3.rotationZ;
         return 1;
      } else if(var0 == 1609) {
         class81.intStack[++class278.intStackSize - 1] = var3.opacity;
         return 1;
      } else if(var0 == 1610) {
         class81.intStack[++class278.intStackSize - 1] = var3.field2674;
         return 1;
      } else if(var0 == 1611) {
         class81.intStack[++class278.intStackSize - 1] = var3.textColor;
         return 1;
      } else if(var0 == 1612) {
         class81.intStack[++class278.intStackSize - 1] = var3.field2668;
         return 1;
      } else if(var0 == 1613) {
         class81.intStack[++class278.intStackSize - 1] = var3.field2672.rsOrdinal();
         return 1;
      } else {
         return 2;
      }
   }
}
