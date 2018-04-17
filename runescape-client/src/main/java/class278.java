import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public class class278 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   public static IndexDataBase field3547;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   static NodeCache field3546;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = 1277506421
   )
   static int field3551;
   @ObfuscatedName("t")
   char field3548;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 590235517
   )
   public int field3545;
   @ObfuscatedName("h")
   public String field3549;
   @ObfuscatedName("m")
   boolean field3550;

   static {
      field3546 = new NodeCache(64);
   }

   class278() {
      this.field3550 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1602218120"
   )
   void method4900() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "1568600660"
   )
   void method4901(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4902(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "-1537853184"
   )
   void method4902(Buffer var1, int var2) {
      if(var2 == 1) {
         byte var4 = var1.readByte();
         int var5 = var4 & 255;
         if(var5 == 0) {
            throw new IllegalArgumentException("");
         }

         if(var5 >= 128 && var5 < 160) {
            char var6 = class314.cp1252AsciiExtension[var5 - 128];
            if(var6 == 0) {
               var6 = '?';
            }

            var5 = var6;
         }

         char var3 = (char)var5;
         this.field3548 = var3;
      } else if(var2 == 2) {
         this.field3545 = var1.readInt();
      } else if(var2 == 4) {
         this.field3550 = false;
      } else if(var2 == 5) {
         this.field3549 = var1.readString();
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-37"
   )
   public boolean method4916() {
      return this.field3548 == 's';
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(Lke;IIII)V",
      garbageValue = "402765467"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field951 != 0) {
         if(var0.field3759 != null && var1 < var0.field3759.length) {
            int var4 = var0.field3759[var1];
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
}
