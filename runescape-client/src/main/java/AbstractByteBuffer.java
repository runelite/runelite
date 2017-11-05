import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("AbstractByteBuffer")
public abstract class AbstractByteBuffer {
   @ObfuscatedName("s")
   static boolean field2410;
   @ObfuscatedName("gw")
   @ObfuscatedGetter(
      intValue = 39076377
   )
   @Export("cameraX")
   static int cameraX;

   static {
      field2410 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-1323537898"
   )
   @Export("get")
   abstract byte[] get();

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-107169366"
   )
   @Export("put")
   abstract void put(byte[] var1);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-1540851623"
   )
   static String method3475(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1797966404"
   )
   public static void method3472() {
      KitDefinition.identKits.reset();
   }
}
