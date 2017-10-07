import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public class class33 {
   @ObfuscatedName("s")
   @Export("highMemory")
   public static boolean highMemory;
   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   static IndexedSprite[] field488;
   @ObfuscatedName("rw")
   static short[] field491;
   @ObfuscatedName("d")
   String field486;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ln;"
   )
   class24 field485;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2077603849
   )
   int field487;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1229479285
   )
   int field484;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILn;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field486 = var1;
      this.field487 = var2;
      this.field484 = var3;
      this.field485 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-479158049"
   )
   public static void method337() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "57"
   )
   static final void method336(int var0, int var1, int var2, int var3) {
      if(Client.cursorState == 1) {
         class20.field335[Client.field1171 / 100].method5172(Client.field1019 - 8, Client.field1020 - 8);
      }

      if(Client.cursorState == 2) {
         class20.field335[Client.field1171 / 100 + 4].method5172(Client.field1019 - 8, Client.field1020 - 8);
      }

      class41.method593();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "9"
   )
   public static boolean method338(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
