import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
public class class326 {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   @Export("classInfos")
   public static CombatInfoList classInfos;

   static {
      classInfos = new CombatInfoList();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljr;III)Z",
      garbageValue = "1257133858"
   )
   public static boolean method5792(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         WorldMapType2.decodeSprite(var3);
         return true;
      }
   }
}
