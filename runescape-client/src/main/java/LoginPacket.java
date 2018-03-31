import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("LoginPacket")
public class LoginPacket implements class179 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static final LoginPacket field2477;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   static final LoginPacket field2474;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static final LoginPacket field2475;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   public static final LoginPacket field2473;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Lgn;"
   )
   static final LoginPacket[] field2478;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1957826581
   )
   @Export("id")
   public final int id;

   static {
      field2477 = new LoginPacket(14, 0);
      field2474 = new LoginPacket(15, 4);
      field2475 = new LoginPacket(16, -2);
      field2473 = new LoginPacket(18, -2);
      field2478 = new LoginPacket[32];
      LoginPacket[] var0 = class163.method3220();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2478[var0[var1].id] = var0[var1];
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
