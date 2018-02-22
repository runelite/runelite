import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("ChatPlayer")
public class ChatPlayer extends Nameable {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1841793549
   )
   @Export("world")
   public int world;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1220319169
   )
   public int field3718;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1934693531
   )
   @Export("rank")
   public int rank;

   ChatPlayer() {
      this.world = -1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1183667192"
   )
   void method5332(int var1, int var2) {
      this.world = var1;
      this.field3718 = var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1371551857"
   )
   public int method5336() {
      return this.world;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "1052098241"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class27.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }
}
