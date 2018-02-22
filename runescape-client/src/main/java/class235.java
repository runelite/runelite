import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
public class class235 {
   @ObfuscatedName("a")
   static byte[][][] field2764;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IZIB)V",
      garbageValue = "48"
   )
   public static final void method4418(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         Frames.audioHighMemory = var1;
         BoundingBox.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "1412739689"
   )
   @Export("drawStatusBox")
   static final void drawStatusBox(String var0, boolean var1) {
      byte var2 = 4;
      int var3 = var2 + 6;
      int var4 = var2 + 6;
      int var5 = ClanMemberManager.font_p12full.method5510(var0, 250);
      int var6 = ClanMemberManager.font_p12full.method5449(var0, 250) * 13;
      Rasterizer2D.Rasterizer2D_fillRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 0);
      Rasterizer2D.drawRectangle(var3 - var2, var4 - var2, var2 + var5 + var2, var2 + var6 + var2, 16777215);
      ClanMemberManager.font_p12full.method5455(var0, var3, var4, var5, var6, 16777215, -1, 1, 1, 0);
      BuildType.method4528(var3 - var2, var4 - var2, var2 + var5 + var2, var6 + var2 + var2);
      if(var1) {
         class324.rasterProvider.drawFull(0, 0);
      } else {
         class70.method1177(var3, var4, var5, var6);
      }

   }
}
