import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
public class class11 {
   @ObfuscatedName("a")
   public static final class11 field273;
   @ObfuscatedName("s")
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("j")
   public static final class11 field270;
   @ObfuscatedName("af")
   static BuildType field269;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 720710299
   )
   @Export("priority")
   public static int priority;
   @ObfuscatedName("ry")
   @Export("renderOverview")
   static RenderOverview renderOverview;
   @ObfuscatedName("km")
   @ObfuscatedGetter(
      intValue = -696510999
   )
   @Export("selectedItemIndex")
   static int selectedItemIndex;

   static {
      field273 = new class11();
      field270 = new class11();
   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2140284004"
   )
   static final void method59() {
      int[] var0 = class96.field1492;

      int var1;
      for(var1 = 0; var1 < class96.field1499; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1230 > 0) {
            --var2.field1230;
            if(var2.field1230 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field944; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1230 > 0) {
            --var3.field1230;
            if(var3.field1230 == 0) {
               var3.overhead = null;
            }
         }
      }

   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "-42"
   )
   static void method58(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1080 < 50 && Client.field1172 != 0) {
         if(var0.field3609 != null && var1 < var0.field3609.length) {
            int var4 = var0.field3609[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1147[Client.field1080] = var5;
               Client.field965[Client.field1080] = var6;
               Client.field1149[Client.field1080] = 0;
               Client.audioEffects[Client.field1080] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1014[Client.field1080] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1080;
            }
         }
      }
   }
}
