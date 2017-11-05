import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class215 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[Lhj;"
   )
   @Export("widgets")
   public static Widget[][] widgets;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Lhj;",
      garbageValue = "-95"
   )
   public static Widget method4064(int var0, int var1) {
      Widget var2 = ItemLayer.method2454(var0);
      return var1 == -1?var2:(var2 != null && var2.children != null && var1 < var2.children.length?var2.children[var1]:null);
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "855854550"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      FaceNormal.method2904(var0, var1, var2, var3, var4, var5, false);
   }
}
