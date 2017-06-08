import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class54 {
   @ObfuscatedName("ca")
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("rx")
   static IndexFile field658;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "47"
   )
   static byte[] method774(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILIndexDataBase;IIIZI)V",
      garbageValue = "-156220169"
   )
   public static void method775(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class203.field2515 = 1;
      class203.field2516 = var1;
      class158.field2275 = var2;
      class275.field3730 = var3;
      FileOnDisk.field1774 = var4;
      class271.field3690 = var5;
      class155.field2261 = var0;
   }
}
