import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public class class313 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1642435029
   )
   public static int field3765;

   static {
      classInfos = new CombatInfoList();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Liv;Liv;Ljava/lang/String;Ljava/lang/String;I)Lkr;",
      garbageValue = "566118556"
   )
   public static Font method5759(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.getFile(var2);
      int var5 = var0.getChild(var4, var3);
      Font var6;
      if(!class306.method5702(var0, var4, var5)) {
         var6 = null;
      } else {
         var6 = SoundTaskDataProvider.method767(var1.getConfigData(var4, var5));
      }

      return var6;
   }
}
