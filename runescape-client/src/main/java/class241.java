import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class241 {
   @ObfuscatedName("c")
   @Export("javaVendor")
   public static String javaVendor;
   @ObfuscatedName("kw")
   @ObfuscatedGetter(
      intValue = -1156941035
   )
   static int field2799;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;B)V",
      garbageValue = "-7"
   )
   public static void method4443(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }
}
