import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("h")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("i")
   @Export("name")
   String name;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1507952501
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("u")
   boolean field266;
   @ObfuscatedName("iq")
   static Widget field267;
   @ObfuscatedName("n")
   boolean field271;
   @ObfuscatedName("l")
   public static short[][] field272;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 923511617
   )
   @Export("world")
   int world;

   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "-1650731542"
   )
   static final String[] method193(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && null != var0[var2]) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LWorld;I)V",
      garbageValue = "-1763425217"
   )
   @Export("selectWorld")
   static void selectWorld(World var0) {
      if(var0.method593() != Client.isMembers) {
         Client.isMembers = var0.method593();
         boolean var1 = var0.method593();
         if(class229.isMembersWorld != var1) {
            ItemComposition.field1167.reset();
            ItemComposition.itemModelCache.reset();
            ItemComposition.itemSpriteCache.reset();
            class229.isMembersWorld = var1;
         }
      }

      class48.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      class51.field1126 = Client.field514 == 0?'ꩊ':var0.id + '鱀';
      ItemLayer.field1731 = Client.field514 == 0?443:'썐' + var0.id;
      class75.field1408 = class51.field1126;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;S)V",
      garbageValue = "25576"
   )
   public static void method195(class170 var0) {
      class50.field1096 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)LNPCComposition;",
      garbageValue = "25"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field906.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field919.method3292(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method805(new Buffer(var2));
         }

         var1.method804();
         NPCComposition.field906.put(var1, (long)var0);
         return var1;
      }
   }
}
