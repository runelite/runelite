import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class220 {
   @ObfuscatedName("aw")
   static Client field2817;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1369744893
   )
   static int field2818;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)LFont;",
      garbageValue = "-1654028162"
   )
   public static Font method3950(IndexDataBase var0, IndexDataBase var1, String var2, String var3) {
      int var4 = var0.method4055(var2);
      int var5 = var0.method4020(var4, var3);
      Font var6;
      if(!class1.method3(var0, var4, var5)) {
         var6 = null;
      } else {
         var6 = class12.method74(var1.getConfigData(var4, var5));
      }

      return var6;
   }
}
