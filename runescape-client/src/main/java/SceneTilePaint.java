import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("ei")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   static class263 field2052;
   @ObfuscatedName("g")
   @Export("flatShade")
   boolean flatShade;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 986295979
   )
   @Export("swColor")
   int swColor;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2034340717
   )
   @Export("rgb")
   int rgb;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1872615693
   )
   @Export("seColor")
   int seColor;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -106571341
   )
   @Export("neColor")
   int neColor;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1122339439
   )
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1072220281
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "915900599"
   )
   public static void method2699() {
      if(class239.field3246 != null) {
         class239.field3246.close();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "-9"
   )
   public static void method2698(Huffman var0) {
      class266.field3648 = var0;
   }
}
