import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public class class23 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   static Widget field366;

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-9"
   )
   static final void method196(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class205.field2541[Client.field1040 / 100].method5019(Client.field1038 - 8, Client.field995 - 8);
      }

      if(Client.cursorState == 2) {
         class205.field2541[Client.field1040 / 100 + 4].method5019(Client.field1038 - 8, Client.field995 - 8);
      }

      WidgetNode.method1120();
   }
}
