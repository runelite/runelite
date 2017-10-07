import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("jr")
public class class276 {
   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Z",
      garbageValue = "-1253522533"
   )
   static final boolean method5021(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field974 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1179.method4078(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1179.method4073(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1179.method4077(false);
         }

         if(var1 == 325) {
            Client.field1179.method4077(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CHARACTER_DESIGN);
            Client.field1179.method4074(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
