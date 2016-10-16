import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class117 {
   @ObfuscatedName("cz")
   static class227 field2001;
   @ObfuscatedName("f")
   static int[] field2002;
   @ObfuscatedName("pi")
   static class224 field2004;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2091780087"
   )
   static final void method2418() {
      class48.field1035.reset();
      class43.field964.reset();
      KitDefinition.field1015.reset();
      class167.method3220();
      NPCComposition.field870.reset();
      NPCComposition.npcModelCache.reset();
      class167.method3224();
      Sequence.method910();
      class45.field988.reset();
      class45.field1003.reset();
      class50.field1063.reset();
      class56.field1203.reset();
      class51.field1076.reset();
      class51.spriteCache.reset();
      class51.field1078.reset();
      class141.method2927();
      PlayerComposition.field2958.reset();
      Widget.field2792.reset();
      Widget.field2793.reset();
      Widget.field2794.reset();
      Widget.field2815.reset();
      ((TextureProvider)class94.field1625).method2157();
      class23.field585.reset();
      class23.field583.method3263();
      Sequence.field983.method3263();
      class124.field2043.method3263();
      Client.field443.method3263();
      class24.field603.method3263();
      class47.field1024.method3263();
      class192.field3101.method3263();
      class152.field2281.method3263();
      class154.field2299.method3263();
      class128.field2074.method3263();
      Buffer.field2033.method3263();
      class188.field3046.method3263();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-211683353"
   )
   static int method2419(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3775((long)var0);
      return var2 == null?-1:(var1 >= 0 && var1 < var2.itemIds.length?var2.itemIds[var1]:-1);
   }
}
