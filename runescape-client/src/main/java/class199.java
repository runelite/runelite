import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class199 {
   @ObfuscatedName("c")
   @Export("floorMultiplier")
   static int[] floorMultiplier;
   @ObfuscatedName("ae")
   static FontMetrics field2583;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;I)V",
      garbageValue = "-203899723"
   )
   public static void method3797(IndexDataBase var0) {
      InvType.field3443 = var0;
   }
}
