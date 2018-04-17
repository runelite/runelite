import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class23 {
   @ObfuscatedName("aj")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("ek")
   @ObfuscatedGetter(
      intValue = 1659864947
   )
   @Export("baseY")
   static int baseY;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;I)V",
      garbageValue = "-951148517"
   )
   static void method186(Component var0) {
      var0.setFocusTraversalKeysEnabled(false);
      var0.addKeyListener(KeyFocusListener.keyboard);
      var0.addFocusListener(KeyFocusListener.keyboard);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;I)V",
      garbageValue = "-520410065"
   )
   public static void method189(IndexDataBase var0) {
      InvType.field3449 = var0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1505438954"
   )
   static void method187(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class81.method1848(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILcr;ZB)I",
      garbageValue = "108"
   )
   static int method188(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         WorldComparator.intStackSize -= 3;
         var3 = class81.intStack[WorldComparator.intStackSize];
         var4 = class81.intStack[WorldComparator.intStackSize + 1];
         int var5 = class81.intStack[WorldComparator.intStackSize + 2];
         if(Client.field1075 != 0 && var4 != 0 && Client.queuedSoundEffectCount < 50) {
            Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var3;
            Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var4;
            Client.unknownSoundValues2[Client.queuedSoundEffectCount] = var5;
            Client.audioEffects[Client.queuedSoundEffectCount] = null;
            Client.soundLocations[Client.queuedSoundEffectCount] = 0;
            ++Client.queuedSoundEffectCount;
         }

         return 1;
      } else if(var0 != 3201) {
         if(var0 == 3202) {
            WorldComparator.intStackSize -= 2;
            var3 = class81.intStack[WorldComparator.intStackSize];
            var4 = class81.intStack[WorldComparator.intStackSize + 1];
            if(Client.field996 != 0 && var3 != -1) {
               PacketNode.method3442(class189.indexTrack2, var3, 0, Client.field996, false);
               Client.field1102 = true;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         var3 = class81.intStack[--WorldComparator.intStackSize];
         if(var3 == -1 && !Client.field1102) {
            class155.method3165();
         } else if(var3 != -1 && var3 != Client.field1026 && Client.field996 != 0 && !Client.field1102) {
            class163.method3213(2, PacketBuffer.indexTrack1, var3, 0, Client.field996, false);
         }

         Client.field1026 = var3;
         return 1;
      }
   }

   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "494954997"
   )
   static void method190(boolean var0) {
      Client.field1016 = var0;
   }
}
