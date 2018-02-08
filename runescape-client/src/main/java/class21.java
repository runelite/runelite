import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class21 {
   @ObfuscatedName("q")
   static int[][][] field331;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1400003601"
   )
   public static final void method161() {
      class131.Viewport_containsMouse = false;
      class131.Viewport_entityCountAtMouse = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)Z",
      garbageValue = "-1879533096"
   )
   static final boolean method162(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = class131.Viewport_mouseY + var6;
      if(var7 < var0 && var7 < var1 && var7 < var2) {
         return false;
      } else {
         var7 = class131.Viewport_mouseY - var6;
         if(var7 > var0 && var7 > var1 && var7 > var2) {
            return false;
         } else {
            var7 = class131.Viewport_mouseX + var6;
            if(var7 < var3 && var7 < var4 && var7 < var5) {
               return false;
            } else {
               var7 = class131.Viewport_mouseX - var6;
               return var7 <= var3 || var7 <= var4 || var7 <= var5;
            }
         }
      }
   }

   @ObfuscatedName("jz")
   @ObfuscatedSignature(
      signature = "(Lhs;I)Z",
      garbageValue = "-1481520401"
   )
   static final boolean method160(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field943 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field1087.method4400(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field1087.method4380(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field1087.method4381(false);
         }

         if(var1 == 325) {
            Client.field1087.method4381(true);
         }

         if(var1 == 326) {
            PacketNode var4 = Script.method2025(ClientPacket.field2414, Client.field937.field1454);
            Client.field1087.method4379(var4.packetBuffer);
            Client.field937.method2044(var4);
            return true;
         } else {
            return false;
         }
      }
   }
}
