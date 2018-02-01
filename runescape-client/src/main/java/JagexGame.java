import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("JagexGame")
public enum JagexGame implements MouseWheel {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3267("runescape", "RuneScape", 0),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3265("stellardawn", "Stellar Dawn", 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3266("game3", "Game 3", 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3268("game4", "Game 4", 3),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3269("game5", "Game 5", 4),
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   field3272("oldscape", "RuneScape 2007", 5);

   @ObfuscatedName("t")
   @Export("name")
   public final String name;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1837608815
   )
   @Export("id")
   final int id;

   JagexGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;B)V",
      garbageValue = "0"
   )
   public static void method4361(File var0) {
      class288.field3760 = var0;
      if(!class288.field3760.exists()) {
         throw new RuntimeException("");
      } else {
         class160.field2130 = true;
      }
   }
}
