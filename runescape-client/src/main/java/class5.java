import java.io.IOException;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class5 implements class0 {
   @ObfuscatedName("n")
   public static short[][] field26;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   static SpritePixels[] field25;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lcw;",
      garbageValue = "-598295001"
   )
   static Preferences method15() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = GroundObject.getPreferencesFile("", FileSystem.field3262.field3256, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILhk;ZB)V",
      garbageValue = "-24"
   )
   static void method16(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = class64.method1018().method5262(var0);
      int var4 = class275.localPlayer.field835;
      int var5 = (class275.localPlayer.x >> 7) + class13.baseX;
      int var6 = (class275.localPlayer.y >> 7) + ClanMember.baseY;
      Coordinates var7 = new Coordinates(var4, var5, var6);
      class64.method1018().method5252(var3, var7, var1, var2);
   }
}
