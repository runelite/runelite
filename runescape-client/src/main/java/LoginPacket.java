import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
@Implements("LoginPacket")
public class LoginPacket implements class169 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   public static final LoginPacket field2432;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   static final LoginPacket field2429;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   public static final LoginPacket field2430;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lfx;"
   )
   public static final LoginPacket field2428;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lfx;"
   )
   static final LoginPacket[] field2433;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1273440689
   )
   @Export("id")
   public final int id;

   static {
      field2432 = new LoginPacket(14, 0);
      field2429 = new LoginPacket(15, 4);
      field2430 = new LoginPacket(16, -2);
      field2428 = new LoginPacket(18, -2);
      field2433 = new LoginPacket[32];
      LoginPacket[] var0 = new LoginPacket[]{field2430, field2428, field2432, field2429};
      LoginPacket[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2433[var1[var2].id] = var1[var2];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-61661518"
   )
   public static boolean method3246(int var0) {
      return var0 >= class232.field2920.field2943 && var0 <= class232.field2941.field2943;
   }
}
