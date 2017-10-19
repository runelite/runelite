import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("v")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1014251003
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1919953237
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1113816907
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1193680813
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -189714385
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1986091021
   )
   @Export("texture")
   int texture;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.flatShade = true;
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.flatShade = var7;
   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-854795150"
   )
   static int method2713() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;Ljava/lang/String;I)[Lky;",
      garbageValue = "657373595"
   )
   public static SpritePixels[] method2714(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.getFile(var1);
      int var4 = var0.getChild(var3, var2);
      return class37.method483(var0, var3, var4);
   }
}
