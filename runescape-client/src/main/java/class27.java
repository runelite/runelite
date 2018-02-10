import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public enum class27 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   field383(2, (byte)0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   field374(3, (byte)1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   field386(1, (byte)2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   field384(0, (byte)3);

   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      intValue = 1730405651
   )
   static int field381;
   @ObfuscatedName("qr")
   static short[] field382;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lcz;"
   )
   @Export("soundTaskDataProvider")
   public static TaskDataProvider soundTaskDataProvider;
   @ObfuscatedName("br")
   static String field376;
   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1490356729
   )
   final int field377;
   @ObfuscatedName("w")
   final byte field373;

   class27(int var3, byte var4) {
      this.field377 = var3;
      this.field373 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field373;
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "1874662040"
   )
   static void method213(byte[] var0, int var1) {
      if(Client.field1006 == null) {
         Client.field1006 = new byte[24];
      }

      class194.method3903(var0, var1, Client.field1006, 0, 24);
   }
}
