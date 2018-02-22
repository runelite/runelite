import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
public class class243 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lie;Ljava/lang/String;Ljava/lang/String;I)Llm;",
      garbageValue = "508390399"
   )
   public static SpritePixels method4505(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class19.method165(var0, var3, var4);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1412404876"
   )
   static final void method4504(String var0) {
      StringBuilder var10000 = new StringBuilder();
      Object var10001 = null;
      var10000 = var10000.append("Please remove ").append(var0);
      var10001 = null;
      String var1 = var10000.append(" from your friend list first").toString();
      class149.sendGameMessage(30, "", var1);
   }
}
