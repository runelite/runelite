import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -695882767
   )
   @Export("quantity")
   int quantity;
   @ObfuscatedName("oe")
   @ObfuscatedGetter(
      intValue = 461013193
   )
   static int field893;
   @ObfuscatedName("m")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 847674409
   )
   @Export("id")
   int id;

   @ObfuscatedName("sk")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-12924"
   )
   protected static final void method877() {
      class63.field1108 = null;
      TextureProvider.field1214 = null;
      CombatInfo1.field663 = null;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   static final void method880(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field468; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var1 + var3) {
            Client.field494[var4] = true;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   protected final Model getModel() {
      return ChatLineBuffer.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-678028452"
   )
   static void method882() {
      class202.underlayIds = null;
      class10.overlayIds = null;
      class3.overlayPaths = null;
      class6.overlayRotations = null;
      class159.field2122 = null;
      class10.field83 = null;
      class22.field230 = null;
      class10.field89 = null;
      class7.field56 = null;
      class65.field1127 = null;
      class181.field2701 = null;
      class7.field61 = null;
   }
}
