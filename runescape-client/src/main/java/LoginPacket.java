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
   @Export("__gl_m")
   public static final LoginPacket __gl_m;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("__gl_f")
   static final LoginPacket __gl_f;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("__gl_q")
   public static final LoginPacket __gl_q;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("__gl_w")
   public static final LoginPacket __gl_w;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("__gl_o")
   static final LoginPacket __gl_o;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lgl;"
   )
   @Export("__gl_g")
   static final LoginPacket[] __gl_g;
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
      File var3 = new File(class168.__fs_o, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            AccessFile var11 = new AccessFile(var3, "rw", 10000L);
            return var11;
         } catch (IOException var10) {
            ;
         }
      }

      String var4 = "";
      if(PacketBuffer.__hx_z == 33) {
         var4 = "_rc";
      } else if(PacketBuffer.__hx_z == 34) {
         var4 = "_wip";
      }

      File var5 = new File(WorldMapSection1.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      AccessFile var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new AccessFile(var5, "rw", 10000L);
            return var6;
         } catch (IOException var9) {
            ;
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
      __gl_m = new LoginPacket(14, 0);
      __gl_f = new LoginPacket(15, 4);
      __gl_q = new LoginPacket(16, -2);
      __gl_w = new LoginPacket(18, -2);
      __gl_o = new LoginPacket(27, 0);
      __gl_g = new LoginPacket[32];
      LoginPacket[] var0 = WorldMapIcon2.method300();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         __gl_g[var0[var1].id] = var0[var1];
      }

   }
}
