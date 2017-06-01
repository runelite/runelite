import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class230 implements class178 {
   @ObfuscatedName("c")
   static final class230 field3165;
   @ObfuscatedName("y")
   static final class230 field3166;
   @ObfuscatedName("e")
   static final class230 field3167;
   @ObfuscatedName("v")
   static final class230 field3168;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1914439549
   )
   final int field3169;
   @ObfuscatedName("b")
   static final class230 field3170;
   @ObfuscatedName("n")
   public final boolean field3171;
   @ObfuscatedName("i")
   static final class230 field3172;
   @ObfuscatedName("f")
   public final boolean field3173;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -266613051
   )
   public final int field3174;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field3169;
   }

   static {
      field3172 = new class230(0, -1, true, false, true);
      field3165 = new class230(1, 0, true, true, true);
      field3167 = new class230(2, 1, true, true, false);
      field3168 = new class230(3, 2, false, false, true);
      field3170 = new class230(4, 3, false, false, true);
      field3166 = new class230(5, 10, false, false, true);
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class230(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field3169 = var1;
      this.field3174 = var2;
      this.field3173 = var4;
      this.field3171 = var5;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1079927969"
   )
   static void method4093(int var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(0);
      Client.secretPacketBuffer1.method3227(var1);
      Client.secretPacketBuffer1.method3283(var0);
   }
}
