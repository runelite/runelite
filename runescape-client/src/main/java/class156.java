import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public abstract class class156 {
   @ObfuscatedName("j")
   static boolean field2106 = false;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1745524473"
   )
   abstract void vmethod3049(byte[] var1);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1676279760"
   )
   abstract byte[] vmethod3063();

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-528513991"
   )
   static void method3064() {
      class10.field107 = 99;
      class10.underlayIds = new byte[4][104][104];
      class10.overlayIds = new byte[4][104][104];
      class10.overlayPaths = new byte[4][104][104];
      class172.overlayRotations = new byte[4][104][104];
      XClanMember.field300 = new int[4][105][105];
      class10.field111 = new byte[4][105][105];
      class10.field112 = new int[105][105];
      class10.field119 = new int[104];
      class195.field2860 = new int[104];
      Frames.field1582 = new int[104];
      class6.field67 = new int[104];
      class10.field106 = new int[104];
   }
}
