import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class152 extends class297 {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -979191117
   )
   @Export("revision")
   public static int revision;
   @ObfuscatedName("g")
   final boolean field2116;

   public class152(boolean var1) {
      this.field2116 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-1896684361"
   )
   int method3205(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2116?var1.field3851 - var2.field3851:var2.field3851 - var1.field3851):this.method5341(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3205((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1238556527"
   )
   public static void method3204() {
      Spotanim.spotanims.reset();
      Spotanim.SpotAnimationDefinition_cachedModels.reset();
   }
}
