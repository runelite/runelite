import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
@Implements("LoginPacket")
public class LoginPacket implements class165 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final LoginPacket field2406;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   static final LoginPacket field2401;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final LoginPacket field2402;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   public static final LoginPacket field2400;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lfp;"
   )
   static final LoginPacket[] field2405;
   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1929065247
   )
   @Export("id")
   public final int id;

   static {
      field2406 = new LoginPacket(14, 0);
      field2401 = new LoginPacket(15, 4);
      field2402 = new LoginPacket(16, -2);
      field2400 = new LoginPacket(18, -2);
      field2405 = new LoginPacket[32];
      LoginPacket[] var0 = class45.method665();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2405[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;I)V",
      garbageValue = "1975032326"
   )
   public static void method3196(IndexDataBase var0, IndexDataBase var1) {
      CombatInfo2.field3442 = var0;
      OwnWorldComparator.field864 = var1;
   }
}
