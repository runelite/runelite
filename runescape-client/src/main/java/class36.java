import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class36 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final class36 field506;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   static final class36 field508;
   @ObfuscatedName("ot")
   @ObfuscatedSignature(
      signature = "Lcf;"
   )
   static class103 field513;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = -2142619095
   )
   static int field505;
   @ObfuscatedName("ph")
   @ObfuscatedGetter(
      intValue = 318639265
   )
   static int field510;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1804532439
   )
   final int field507;

   static {
      field508 = new class36(0);
      field506 = new class36(1);
   }

   class36(int var1) {
      this.field507 = var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lis;",
      garbageValue = "-48635231"
   )
   public static VarPlayerType method497(int var0) {
      VarPlayerType var1 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarPlayerType.varplayer_ref.getConfigData(16, var0);
         var1 = new VarPlayerType();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         VarPlayerType.varplayers.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1682210626"
   )
   static final void method499(String var0) {
      if(WorldMapData.clanMembers != null) {
         Client.secretPacketBuffer1.putOpcode(78);
         Client.secretPacketBuffer1.putByte(class45.getLength(var0));
         Client.secretPacketBuffer1.putString(var0);
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      signature = "(Lhg;B)Z",
      garbageValue = "4"
   )
   static final boolean method498(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field1040 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1035.method3952(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1035.method3963(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1035.method3956(false);
         }

         if(var1 == 325) {
            Client.field1035.method3956(true);
         }

         if(var1 == 326) {
            Client.secretPacketBuffer1.putOpcode(194);
            Client.field1035.method3955(Client.secretPacketBuffer1);
            return true;
         } else {
            return false;
         }
      }
   }
}
