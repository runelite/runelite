import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public class class179 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -660168955
   )
   @Export("myWorldPort")
   static int myWorldPort;

   static {
      new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-265370917"
   )
   public static void method3303() {
      ObjectComposition.objects.reset();
      ObjectComposition.field3524.reset();
      ObjectComposition.cachedModels.reset();
      ObjectComposition.field3552.reset();
   }
}
