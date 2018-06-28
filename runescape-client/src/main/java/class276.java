import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class276 {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Liv;Ljava/lang/String;Ljava/lang/String;B)Llc;",
      garbageValue = "-32"
   )
   public static SpritePixels method5251(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return ChatLineBuffer.getSpriteAsSpritePixels(var0, var3, var4);
   }
}
