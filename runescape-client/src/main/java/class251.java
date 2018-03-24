import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
public class class251 {
   @ObfuscatedName("rz")
   @ObfuscatedSignature(
      signature = "Llo;"
   )
   @Export("renderOverview")
   static RenderOverview renderOverview;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;S)V",
      garbageValue = "-16315"
   )
   public static void method4540(IndexDataBase var0) {
      Overlay.overlay_ref = var0;
   }
}
