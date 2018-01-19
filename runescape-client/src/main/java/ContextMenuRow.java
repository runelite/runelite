import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("ContextMenuRow")
public class ContextMenuRow {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1848826809
   )
   @Export("param0")
   int param0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1931478707
   )
   @Export("param1")
   int param1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1082153175
   )
   @Export("type")
   int type;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 758036865
   )
   @Export("identifier")
   int identifier;
   @ObfuscatedName("h")
   @Export("option")
   String option;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lim;",
      garbageValue = "89393955"
   )
   public static VarPlayerType method1742(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = GameEngine.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lhq;I)Z",
      garbageValue = "-1662960890"
   )
   static final boolean method1743(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1084 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1126.method4168(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1126.method4169(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1126.method4170(false);
         }

         if(var1 == 325) {
            Client.field1126.method4170(true);
         }

         if(var1 == 326) {
            PacketNode var4 = class235.method4272(ClientPacket.field2378, Client.field915.field1462);
            Client.field1126.method4171(var4.packetBuffer);
            Client.field915.method1898(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
