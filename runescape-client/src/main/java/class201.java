import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class201 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lim;",
      garbageValue = "1597622511"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = NetWriter.getWidget(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-291830631"
   )
   public static boolean method3891(int var0) {
      return var0 >= class241.field2956.field2958 && var0 <= class241.field2954.field2958;
   }

   @ObfuscatedName("gt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "64"
   )
   static final void method3888() {
      for(int var0 = 0; var0 < Client.npcIndexesCount; ++var0) {
         int var1 = Client.npcIndices[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class131.method2799(var2, var2.composition.field3661);
         }
      }

   }
}
