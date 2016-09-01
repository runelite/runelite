import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public final class class132 {
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1400149671
   )
   public static int field2102;
   @ObfuscatedName("m")
   static byte[][][] field2104;

   @ObfuscatedName("dk")
   @ObfuscatedSignature(
      signature = "(LWidget;I)I",
      garbageValue = "-109626822"
   )
   static int method2880(Widget var0) {
      class204 var1 = (class204)Client.widgetFlags.method3830((long)var0.index + ((long)var0.id << 32));
      return null != var1?var1.field3158:var0.field2882;
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-809892066"
   )
   static boolean method2881(int var0) {
      return var0 == 57 || var0 == 58 || var0 == 1007 || var0 == 25 || var0 == 30;
   }
}
