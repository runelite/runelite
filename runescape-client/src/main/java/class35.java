import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class35 {
   @ObfuscatedName("g")
   static final class35 field793 = new class35();
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = -1719659819
   )
   @Export("cameraY")
   static int cameraY;
   @ObfuscatedName("h")
   static final class35 field796 = new class35();
   @ObfuscatedName("e")
   static final class35 field798 = new class35();
   @ObfuscatedName("i")
   static final class35 field799 = new class35();
   @ObfuscatedName("u")
   public static class170 field800;
   @ObfuscatedName("l")
   static byte[][][] field801;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "101174267"
   )
   static byte[] method739(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
