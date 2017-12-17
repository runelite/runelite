import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class54 {
   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-1372896364"
   )
   public static boolean method766(String var0, int var1) {
      return class35.method492(var0, var1, "openjs");
   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      signature = "(Lhz;B)Z",
      garbageValue = "20"
   )
   static final boolean method765(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field881 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1090.method4093(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1090.method4094(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1090.method4092(false);
         }

         if(var1 == 325) {
            Client.field1090.method4092(true);
         }

         if(var1 == 326) {
            PacketNode var4 = FileSystem.method4252(ClientPacket.field2397, Client.field888.field1449);
            Client.field1090.method4096(var4.packetBuffer);
            Client.field888.method1862(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
