import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public enum class266 implements Enumerated {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3529(2, 0),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3527(0, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   field3526(1, 2);

   @ObfuscatedName("b")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -739868097
   )
   public final int field3528;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1327532101
   )
   @Export("id")
   final int id;

   private class266(int var3, int var4) {
      this.field3528 = var3;
      this.id = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "83"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1908348747"
   )
   static final void method5120() {
      if (VertexNormal.field945) {
         if (PacketWriter.clanChat != null) {
            PacketWriter.clanChat.sort();
         }

         FontName.method5635();
         VertexNormal.field945 = false;
      }

   }
}
