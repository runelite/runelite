import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("ServerBuild")
public class ServerBuild {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("LIVE")
   public static final ServerBuild LIVE;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("BUILDLIVE")
   public static final ServerBuild BUILDLIVE;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("RC")
   public static final ServerBuild RC;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("WIP")
   public static final ServerBuild WIP;
   @ObfuscatedName("bx")
   @Export("worldsUrl")
   static String worldsUrl;
   @ObfuscatedName("lo")
   @ObfuscatedGetter(
      intValue = -365366303
   )
   static int field788;
   @ObfuscatedName("o")
   @Export("name")
   public final String name;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -947415971
   )
   @Export("id")
   public final int id;

   ServerBuild(String var1, int var2) {
      this.name = var1;
      this.id = var2;
   }

   static {
      LIVE = new ServerBuild("LIVE", 0);
      BUILDLIVE = new ServerBuild("BUILDLIVE", 3);
      RC = new ServerBuild("RC", 1);
      WIP = new ServerBuild("WIP", 2);
   }
}
