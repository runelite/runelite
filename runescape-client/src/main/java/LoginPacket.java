import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ga")
@Implements("LoginPacket")
public class LoginPacket implements class179 {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final LoginPacket field2488;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   static final LoginPacket field2483;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final LoginPacket field2485;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   public static final LoginPacket field2486;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lga;"
   )
   static final LoginPacket[] field2484;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1187276793
   )
   @Export("id")
   public final int id;

   static {
      field2488 = new LoginPacket(14, 0);
      field2483 = new LoginPacket(15, 4);
      field2485 = new LoginPacket(16, -2);
      field2486 = new LoginPacket(18, -2);
      field2484 = new LoginPacket[32];
      LoginPacket[] var0 = BoundingBox2D.method37();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2484[var0[var1].id] = var0[var1];
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
