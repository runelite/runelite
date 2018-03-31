import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("Permission")
public enum Permission implements Enumerated {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3336(0, -1, true, false, true),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3328(1, 0, true, true, true),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3330(2, 1, true, true, false),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3337(3, 2, false, false, true),
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3331(4, 3, false, false, true),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3332(5, 10, false, false, true);

   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -363914307
   )
   final int field3333;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -966770069
   )
   public final int field3334;
   @ObfuscatedName("w")
   public final boolean field3335;
   @ObfuscatedName("r")
   public final boolean field3327;

   Permission(int var3, int var4, boolean var5, boolean var6, boolean var7) {
      this.field3333 = var3;
      this.field3334 = var4;
      this.field3335 = var6;
      this.field3327 = var7;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1780726447"
   )
   public int rsOrdinal() {
      return this.field3333;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)[Ljd;",
      garbageValue = "1287517039"
   )
   static VerticalAlignment[] method4534() {
      return new VerticalAlignment[]{VerticalAlignment.field3435, VerticalAlignment.field3434, VerticalAlignment.field3432};
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1793022329"
   )
   static void method4531(int var0, int var1, int var2) {
      if(Client.field1091 != 0 && var1 != 0 && Client.queuedSoundEffectCount < 50) {
         Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var0;
         Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var1;
         Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var2;
         Client.audioEffects[Client.queuedSoundEffectCount] = null;
         Client.soundLocations[Client.queuedSoundEffectCount] = 0;
         ++Client.queuedSoundEffectCount;
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "61"
   )
   static void method4535() {
      PacketNode var0 = FaceNormal.method3078(ClientPacket.field2407, Client.field902.field1475);
      PacketBuffer var1 = var0.packetBuffer;
      int var2 = Client.isResized?2:1;
      var1.putByte(var2);
      var0.packetBuffer.putShort(Sequence.canvasWidth);
      var0.packetBuffer.putShort(class45.canvasHeight);
      Client.field902.method2036(var0);
   }
}
