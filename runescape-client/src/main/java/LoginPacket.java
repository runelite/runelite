import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
@Implements("LoginPacket")
public class LoginPacket implements ClientPacketMarker {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static final LoginPacket field473;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static final LoginPacket field474;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static final LoginPacket field475;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   public static final LoginPacket field476;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   static final LoginPacket field477;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   static final LoginPacket[] field478;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1743806243
   )
   @Export("id")
   public final int id;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   LoginPacket(int var1, int var2) {
      this.id = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZS)Ldk;",
      garbageValue = "15345"
   )
   @Export("getPreferencesFile")
   public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class168.field1115, "preferences" + var0 + ".dat");
      if (var3.exists()) {
         try {
            AccessFile var11 = new AccessFile(var3, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
         }
      }

      String var4 = "";
      if (PacketBuffer.field667 == 33) {
         var4 = "_rc";
      } else if (PacketBuffer.field667 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(WorldMapSection1.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      AccessFile var6;
      if (!var2 && var5.exists()) {
         try {
            var6 = new AccessFile(var5, "rw", 10000L);
            return var6;
         } catch (IOException var9) {
         }
      }

      try {
         var6 = new AccessFile(var3, "rw", 10000L);
         return var6;
      } catch (IOException var8) {
         throw new RuntimeException();
      }
   }

   static {
      field473 = new LoginPacket(14, 0);
      field474 = new LoginPacket(15, 4);
      field475 = new LoginPacket(16, -2);
      field476 = new LoginPacket(18, -2);
      field477 = new LoginPacket(27, 0);
      field478 = new LoginPacket[32];
      LoginPacket[] var0 = WorldMapIcon2.method300();

      for (int var1 = 0; var1 < var0.length; ++var1) {
         field478[var0[var1].id] = var0[var1];
      }

   }
}
