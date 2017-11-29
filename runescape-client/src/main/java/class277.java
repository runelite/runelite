import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public final class class277 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lel;"
   )
   @Export("taskManager")
   protected static Signlink taskManager;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-7"
   )
   public static boolean method5091() {
      ClassInfo var0 = (ClassInfo)class289.classInfos.last();
      return var0 != null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "-724860798"
   )
   public static String method5083(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
