import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
public class class152 extends class283 {
   @ObfuscatedName("ef")
   @ObfuscatedGetter(
      intValue = 1601963607
   )
   static int field2090;
   @ObfuscatedName("b")
   final boolean field2089;

   public class152(boolean var1) {
      this.field2089 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "1308547629"
   )
   int method3125(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2089?var1.field3718 - var2.field3718:var2.field3718 - var1.field3718):this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3125((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;IIIZB)V",
      garbageValue = "-18"
   )
   public static void method3129(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class223.field2646 = 1;
      Huffman.field2471 = var0;
      class223.field2648 = var1;
      TextureProvider.field1658 = var2;
      class223.field2645 = var3;
      class223.field2647 = var4;
      VertexNormal.field1888 = 10000;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-600015434"
   )
   static void method3133() {
      TotalQuantityComparator.field281 = null;
      FileSystem.offsetsY = null;
      BaseVarType.field28 = null;
      GroundObject.field1751 = null;
      class323.field3912 = null;
      class323.spritePixels = null;
   }
}
