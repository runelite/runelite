import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class150 extends class297 {
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = 683236379
   )
   static int field2100;
   @ObfuscatedName("t")
   final boolean field2099;

   public class150(boolean var1) {
      this.field2099 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;I)I",
      garbageValue = "-1878745985"
   )
   int method3112(ChatPlayer var1, ChatPlayer var2) {
      return Client.world == var1.world && var2.world == Client.world?(this.field2099?var1.method5246().method5420(var2.method5246()):var2.method5246().method5420(var1.method5246())):this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3112((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "-32"
   )
   public static void method3117(Applet var0, String var1) {
      class57.field635 = var0;
      if(var1 != null) {
         class57.field636 = var1;
      }

   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(Lkf;IIIB)V",
      garbageValue = "114"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field1083 != 0) {
         if(var0.field3762 != null && var1 < var0.field3762.length) {
            int var4 = var0.field3762[var1];
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
