import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class class220 {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILim;Ljava/lang/String;Ljava/lang/String;IZB)V",
      garbageValue = "-32"
   )
   public static void method4074(int var0, IndexDataBase var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.getFile(var2);
      int var7 = var1.getChild(var6, var3);
      class40.method556(var0, var1, var6, var7, var4, var5);
   }

   @ObfuscatedName("je")
   @ObfuscatedSignature(
      signature = "(Lhn;II)Ljava/lang/String;",
      garbageValue = "-2032037503"
   )
   static String method4075(Widget var0, int var1) {
      return !class149.method2924(class169.getWidgetConfig(var0), var1) && var0.field2729 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
