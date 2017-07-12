import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public class class35 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1304039067
   )
   final int field506;
   @ObfuscatedName("w")
   static final class35 field507;
   @ObfuscatedName("od")
   @Export("clanChatRank")
   static byte clanChatRank;
   @ObfuscatedName("i")
   static final class35 field511;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 187222449
   )
   public static int field514;

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class35(int var1) {
      this.field506 = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[LBuildType;",
      garbageValue = "1933463881"
   )
   public static BuildType[] method507() {
      return new BuildType[]{BuildType.LIVE, BuildType.RC, BuildType.BUILD_LIVE, BuildType.WIP};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "1890011737"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3567.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      field511 = new class35(0);
      field507 = new class35(1);
   }
}
