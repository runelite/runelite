import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
public class class56 {
   @ObfuscatedName("s")
   public static Applet field639;
   @ObfuscatedName("g")
   public static String field638;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhu;"
   )
   public static Track1 field637;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = 1723016079
   )
   @Export("menuX")
   static int menuX;

   static {
      field639 = null;
      field638 = "";
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1757435714"
   )
   static int method784(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var2 == null) {
         return 0;
      } else if(var1 == -1) {
         return 0;
      } else {
         int var3 = 0;

         for(int var4 = 0; var4 < var2.stackSizes.length; ++var4) {
            if(var2.itemIds[var4] == var1) {
               var3 += var2.stackSizes[var4];
            }
         }

         return var3;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lbs;I)V",
      garbageValue = "-1232653047"
   )
   static void method773(World var0) {
      if(var0.method1621() != Client.isMembers) {
         Client.isMembers = var0.method1621();
         class239.method4481(var0.method1621());
      }

      RunException.host = var0.address;
      Client.world = var0.id;
      Client.flags = var0.mask;
      WorldMapType2.port1 = Client.socketType == 0?43594:var0.id + 40000;
      FaceNormal.port2 = Client.socketType == 0?443:var0.id + 50000;
      class43.myWorldPort = WorldMapType2.port1;
   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1658222924"
   )
   static final void method781() {
      int var0 = class92.playerIndexesCount;
      int[] var1 = class92.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            ChatLineBuffer.method2040(var3, 1);
         }
      }

   }
}
