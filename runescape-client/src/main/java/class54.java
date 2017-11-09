import java.awt.Component;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
public class class54 {
   @ObfuscatedName("qb")
   static short[] field635;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "79"
   )
   static void method858(Component var0) {
      var0.removeMouseListener(MouseInput.mouse);
      var0.removeMouseMotionListener(MouseInput.mouse);
      var0.removeFocusListener(MouseInput.mouse);
      MouseInput.field717 = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2046829698"
   )
   static final boolean method863() {
      return class133.field1917;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2104099203"
   )
   static void method861() {
      ItemContainer.itemContainers = new HashTable(32);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1520837375"
   )
   @Export("getSmoothNoise2D")
   static final int getSmoothNoise2D(int var0, int var1) {
      int var2 = class1.method0(var0 - 1, var1 - 1) + class1.method0(1 + var0, var1 - 1) + class1.method0(var0 - 1, var1 + 1) + class1.method0(1 + var0, 1 + var1);
      int var3 = class1.method0(var0 - 1, var1) + class1.method0(1 + var0, var1) + class1.method0(var0, var1 - 1) + class1.method0(var0, 1 + var1);
      int var4 = class1.method0(var0, var1);
      return var2 / 16 + var3 / 8 + var4 / 4;
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "58"
   )
   static void method862(int var0) {
      class44.topContextMenuRow = new ContextMenuRow();
      class44.topContextMenuRow.param0 = Client.menuActionParams0[var0];
      class44.topContextMenuRow.param1 = Client.menuActionParams1[var0];
      class44.topContextMenuRow.type = Client.menuTypes[var0];
      class44.topContextMenuRow.identifier = Client.menuIdentifiers[var0];
      class44.topContextMenuRow.option = Client.menuOptions[var0];
   }
}
