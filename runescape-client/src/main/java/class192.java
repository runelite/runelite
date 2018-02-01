import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gq")
public class class192 {
   @ObfuscatedName("p")
   @Export("javaVendor")
   public static String javaVendor;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILhe;I)I",
      garbageValue = "-810837155"
   )
   public static int method3700(int var0, class230 var1) {
      return (var0 << 8) + var1.field2877;
   }
}
