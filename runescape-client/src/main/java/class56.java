import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
public class class56 {
   @ObfuscatedName("d")
   static Applet field653;
   @ObfuscatedName("x")
   static String field654;
   @ObfuscatedName("b")
   @Export("validInterfaces")
   public static boolean[] validInterfaces;

   static {
      field653 = null;
      field654 = null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;I)V",
      garbageValue = "1074035972"
   )
   public static void method830(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      VarPlayerType.field3357 = VarPlayerType.varplayer_ref.fileCount(16);
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIIIIS)V",
      garbageValue = "-19891"
   )
   static final void method835(int var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 2048 - var3 & 2047;
      int var7 = 2048 - var4 & 2047;
      int var8 = 0;
      int var9 = 0;
      int var10 = var5;
      int var11;
      int var12;
      int var13;
      if(var6 != 0) {
         var11 = Graphics3D.SINE[var6];
         var12 = Graphics3D.COSINE[var6];
         var13 = var9 * var12 - var11 * var5 >> 16;
         var10 = var12 * var5 + var11 * var9 >> 16;
         var9 = var13;
      }

      if(var7 != 0) {
         var11 = Graphics3D.SINE[var7];
         var12 = Graphics3D.COSINE[var7];
         var13 = var12 * var8 + var10 * var11 >> 16;
         var10 = var10 * var12 - var8 * var11 >> 16;
         var8 = var13;
      }

      class214.cameraX = var0 - var8;
      GameEngine.cameraZ = var1 - var9;
      class289.cameraY = var2 - var10;
      class18.cameraPitch = var3;
      SoundTaskDataProvider.cameraYaw = var4;
   }
}
