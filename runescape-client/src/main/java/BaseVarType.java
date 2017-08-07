import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   @Export("INTEGER")
   INTEGER(1, 0, Integer.class, new class2()),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   @Export("LONG")
   LONG(0, 1, Long.class, new class3()),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lw;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -988049291
   )
   final int field23;
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      longValue = 2586484368240924733L
   )
   static long field26;
   @ObfuscatedName("fn")
   static int[] field27;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1076168961
   )
   final int field28;
   @ObfuscatedName("rh")
   @ObfuscatedSignature(
      signature = "Lkv;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Le;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field23 = var3;
      this.field28 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "834678576"
   )
   public int rsOrdinal() {
      return this.field28;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-95"
   )
   public static void method9(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         ItemComposition.items.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;Lit;Lit;I)V",
      garbageValue = "-353005852"
   )
   public static void method8(IndexDataBase var0, IndexDataBase var1, IndexDataBase var2, IndexDataBase var3) {
      Widget.widgetIndex = var0;
      Widget.field2615 = var1;
      class267.field3652 = var2;
      Widget.field2703 = var3;
      Item.widgets = new Widget[Widget.widgetIndex.size()][];
      Timer.validInterfaces = new boolean[Widget.widgetIndex.size()];
   }
}
