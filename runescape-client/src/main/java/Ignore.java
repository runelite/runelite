import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("Ignore")
public class Ignore {
   @ObfuscatedName("m")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("p")
   @Export("name")
   String name;

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(Lclass89;III)V",
      garbageValue = "-522817105"
   )
   static final void method1043(class89 var0, int var1, int var2) {
      class116.menuAction(var0.field1386, var0.field1387, var0.field1388, var0.field1389, var0.field1392, var0.field1392, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-135220785"
   )
   static void method1044() {
      class61.field759 = 99;
      class61.underlayIds = new byte[4][104][104];
      class61.overlayIds = new byte[4][104][104];
      class90.overlayPaths = new byte[4][104][104];
      class275.overlayRotations = new byte[4][104][104];
      class61.field750 = new int[4][105][105];
      class267.field3669 = new byte[4][105][105];
      XItemContainer.field774 = new int[105][105];
      Widget.field2648 = new int[104];
      class61.field753 = new int[104];
      WallObject.field2140 = new int[104];
      class40.field552 = new int[104];
      WidgetNode.field810 = new int[104];
   }
}
