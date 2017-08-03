import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("q")
   static boolean field2384;

   static {
      field2384 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1901218247"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "3"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lim;Lim;ZLjt;I)V",
      garbageValue = "1827936438"
   )
   public static void method3399(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      ItemComposition.item_ref = var0;
      ItemComposition.field3470 = var1;
      class37.isMembersWorld = var2;
      class118.field1676 = ItemComposition.item_ref.fileCount(10);
      class207.field2551 = var3;
   }
}
