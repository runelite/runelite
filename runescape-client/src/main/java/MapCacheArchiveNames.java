import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("MapCacheArchiveNames")
public class MapCacheArchiveNames
{
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("DETAILS")
   public static final MapCacheArchiveNames DETAILS;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("COMPOSITE_MAP")
   public static final MapCacheArchiveNames COMPOSITE_MAP;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("COMPOSITE_TEXTURE")
   public static final MapCacheArchiveNames COMPOSITE_TEXTURE;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("AREA")
   public static final MapCacheArchiveNames AREA;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   @Export("LABELS")
   public static final MapCacheArchiveNames LABELS;
   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "Lkw;"
   )
   @Export("fontPlain11")
   static Font fontPlain11;
   @ObfuscatedName("y")
   @Export("name")
   public final String name;

   static {
      DETAILS = new MapCacheArchiveNames("details");
      COMPOSITE_MAP = new MapCacheArchiveNames("compositemap");
      COMPOSITE_TEXTURE = new MapCacheArchiveNames("compositetexture");
      AREA = new MapCacheArchiveNames("area");
      LABELS = new MapCacheArchiveNames("labels");
   }

   MapCacheArchiveNames(String var1) {
      this.name = var1;
   }

   @ObfuscatedName("ev")
   @ObfuscatedSignature(
      signature = "(Lki;IIII)V",
      garbageValue = "2040379521"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field911 != 0) {
         if(var0.field3765 != null && var1 < var0.field3765.length) {
            int var4 = var0.field3765[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var5;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.unknownSoundValues2[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "530978548"
   )
   static final void method560(String var0) {
      if(!var0.equals("")) {
         PacketNode var1 = class31.method285(ClientPacket.field2375, Client.field899.field1470);
         var1.packetBuffer.putByte(class29.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field899.method2082(var1);
      }
   }
}
