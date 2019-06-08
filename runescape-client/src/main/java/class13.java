import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class13 {
   @ObfuscatedName("x")
   @Export("__i_x")
   static int[] __i_x;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhe;"
   )
   @Export("musicTrack")
   public static MusicTrack musicTrack;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1810047523
   )
   @Export("__i_af")
   static int __i_af;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIII)Lln;",
      garbageValue = "862375604"
   )
   static Sprite method164(int var0, int var1, int var2) {
      return (Sprite)WorldMapRegion.__av_o.get(MouseHandler.method1083(var0, var1, var2));
   }

   @ObfuscatedName("fm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "63"
   )
   @Export("playPcmPlayers")
   static final void playPcmPlayers() {
      if(AbstractIndexCache.pcmPlayer1 != null) {
         AbstractIndexCache.pcmPlayer1.run();
      }

      if(WorldMapCacheName.pcmPlayer0 != null) {
         WorldMapCacheName.pcmPlayer0.run();
      }

   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "-527387190"
   )
   static final void method165(class68 var0) {
      long var1 = 0L;
      int var3 = -1;
      int var4 = 0;
      int var5 = 0;
      if(var0.field906 == 0) {
         var1 = class65.scene.__ar_244(var0.field911, var0.field913, var0.field901);
      }

      if(var0.field906 == 1) {
         var1 = class65.scene.__ac_245(var0.field911, var0.field913, var0.field901);
      }

      if(var0.field906 == 2) {
         var1 = class65.scene.__ay_246(var0.field911, var0.field913, var0.field901);
      }

      if(var0.field906 == 3) {
         var1 = class65.scene.getFloorDecorationTag(var0.field911, var0.field913, var0.field901);
      }

      if(var1 != 0L) {
         int var6 = class65.scene.getObjectFlags(var0.field911, var0.field913, var0.field901, var1);
         var3 = HitSplatDefinition.method4972(var1);
         var4 = var6 & 31;
         var5 = var6 >> 6 & 3;
      }

      var0.field903 = var3;
      var0.field905 = var4;
      var0.field904 = var5;
   }
}
