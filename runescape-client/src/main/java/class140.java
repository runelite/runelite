import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class140 extends class283 {
   @ObfuscatedName("fz")
   @Export("landMapFileIds")
   static int[] landMapFileIds;
   @ObfuscatedName("w")
   final boolean field1900;

   public class140(boolean var1) {
      this.field1900 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "-449392151"
   )
   int method3169(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field1900?var1.field3649 - var2.field3649:var2.field3649 - var1.field3649):this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3169((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SI)V",
      garbageValue = "430996961"
   )
   public static void method3173(String[] var0, short[] var1) {
      WorldMapType3.method155(var0, var1, 0, var0.length - 1);
   }
}
