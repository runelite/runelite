import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("LoginPacket")
public class LoginPacket implements class179 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static final LoginPacket field2453;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   static final LoginPacket field2448;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static final LoginPacket field2449;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   public static final LoginPacket field2447;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lgu;"
   )
   static final LoginPacket[] field2450;
   @ObfuscatedName("h")
   @Export("tt")
   static int[] tt;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1406644011
   )
   @Export("id")
   public final int id;

   static {
      field2453 = new LoginPacket(14, 0);
      field2448 = new LoginPacket(15, 4);
      field2449 = new LoginPacket(16, -2);
      field2447 = new LoginPacket(18, -2);
      field2450 = new LoginPacket[32];
      LoginPacket[] var0 = class298.method5285();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2450[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }
}
