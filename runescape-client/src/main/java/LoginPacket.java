import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("LoginPacket")
public class LoginPacket implements class179 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static final LoginPacket field2479;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static final LoginPacket field2477;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static final LoginPacket field2474;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   public static final LoginPacket field2481;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Lgs;"
   )
   static final LoginPacket[] field2475;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1832978751
   )
   @Export("id")
   public final int id;

   static {
      field2479 = new LoginPacket(14, 0);
      field2477 = new LoginPacket(15, 4);
      field2474 = new LoginPacket(16, -2);
      field2481 = new LoginPacket(18, -2);
      field2475 = new LoginPacket[32];
      LoginPacket[] var0 = ServerPacket.method3478();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2475[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-857762778"
   )
   static final void method3483(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.widgetCount; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1043[var4] = true;
         }
      }

   }
}
