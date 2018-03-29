import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class157 extends class297 {
   @ObfuscatedName("w")
   static int[] field2146;
   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;
   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static Widget field2149;
   @ObfuscatedName("c")
   final boolean field2148;

   public class157(boolean var1) {
      this.field2148 = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;I)I",
      garbageValue = "72882670"
   )
   int method3179(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field2148?var1.method5260().method5441(var2.method5260()):var2.method5260().method5441(var1.method5260())):this.method5288(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3179((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Lib;I)Z",
      garbageValue = "2042086833"
   )
   static boolean method3183(Widget var0) {
      return var0.isHidden;
   }
}
