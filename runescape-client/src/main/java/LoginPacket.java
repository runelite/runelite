import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
@Implements("LoginPacket")
public class LoginPacket implements class179 {
   @ObfuscatedName("oi")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   @Export("clanMemberManager")
   static ClanMemberManager clanMemberManager;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final LoginPacket field2465;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   static final LoginPacket field2466;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final LoginPacket field2470;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final LoginPacket field2468;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Lgk;"
   )
   static final LoginPacket[] field2467;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2120107001
   )
   @Export("id")
   public final int id;

   static {
      field2465 = new LoginPacket(14, 0);
      field2466 = new LoginPacket(15, 4);
      field2470 = new LoginPacket(16, -2);
      field2468 = new LoginPacket(18, -2);
      field2467 = new LoginPacket[32];
      LoginPacket[] var0 = Size.method187();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         field2467[var0[var1].id] = var0[var1];
      }

   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Llv;IIII)V",
      garbageValue = "-1158369735"
   )
   static void method3506(SpritePixels var0, int var1, int var2, int var3) {
      WorldMapRegion.field472.method4018(var0, class167.method3334(var1, var2, var3), var0.pixels.length * 4);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2056638774"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + OwnWorldComparator.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-387137361"
   )
   public static void method3505() {
      Sequence.sequences.reset();
      Sequence.skeletons.reset();
   }
}
