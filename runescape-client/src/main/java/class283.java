import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public class class283 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lib;Ljava/lang/String;Ljava/lang/String;I)Lks;",
      garbageValue = "1909623791"
   )
   @Export("spriteForName")
   public static SpritePixels method5027(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return SocketSession.takeItemSnapshot(var0, var3, var4);
   }
}
