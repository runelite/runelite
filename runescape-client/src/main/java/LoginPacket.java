import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("LoginPacket")
public class LoginPacket implements class169 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final LoginPacket field2411;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   static final LoginPacket field2418;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final LoginPacket field2416;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfh;"
   )
   public static final LoginPacket field2413;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Lfh;"
   )
   static final LoginPacket[] field2415;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   @Export("timer")
   protected static Timer timer;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -105058661
   )
   @Export("id")
   public final int id;

   static {
      field2411 = new LoginPacket(14, 0);
      field2418 = new LoginPacket(15, 4);
      field2416 = new LoginPacket(16, -2);
      field2413 = new LoginPacket(18, -2);
      field2415 = new LoginPacket[32];
      LoginPacket[] var0 = new LoginPacket[]{field2416, field2413, field2418, field2411};
      LoginPacket[] var1 = var0;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         field2415[var1[var2].id] = var1[var2];
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
