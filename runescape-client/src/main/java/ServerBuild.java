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
   public static final ServerBuild field784;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static final ServerBuild field785;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static final ServerBuild field786;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   public static final ServerBuild field787;
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
      field784 = new ServerBuild("LIVE", 0);
      field785 = new ServerBuild("BUILDLIVE", 3);
      field786 = new ServerBuild("RC", 1);
      field787 = new ServerBuild("WIP", 2);
   }
}
