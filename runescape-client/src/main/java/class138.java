import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class138 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "[Lcg;"
   )
   @Export("worldList")
   static World[] worldList;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1430163046"
   )
   public static void method2927(int var0) {
      class203.field2521 = 1;
      class203.field2522 = null;
      class203.field2520 = -1;
      Frames.field2138 = -1;
      class148.field2203 = 0;
      BufferProvider.field3778 = false;
      class288.field3814 = var0;
   }
}
