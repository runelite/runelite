import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public abstract class class9 extends Node {
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   static Font field257;
   @ObfuscatedName("gf")
   @ObfuscatedGetter(
      intValue = -327258247
   )
   @Export("cameraPitch")
   static int cameraPitch;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1657577440"
   )
   public abstract void vmethod57();

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljw;",
      garbageValue = "-979972449"
   )
   public static Parameters[] method47() {
      return new Parameters[]{Parameters.field3725, Parameters.field3720, Parameters.field3718, Parameters.field3724, Parameters.field3728, Parameters.field3732, Parameters.field3727, Parameters.field3717, Parameters.field3719, Parameters.field3731, Parameters.field3726, Parameters.field3721, Parameters.field3729, Parameters.field3730, Parameters.field3723};
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(III)Lfy;",
      garbageValue = "1140227270"
   )
   static class163 method53(int var0, int var1) {
      Client.field1189.field2317 = var0;
      Client.field1189.field2318 = var1;
      Client.field1189.field2319 = 1;
      Client.field1189.field2320 = 1;
      return Client.field1189;
   }
}
