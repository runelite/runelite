import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1587098067
   )
   static int field813;
   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "Lbl;"
   )
   @Export("localPlayer")
   static Player localPlayer;
   @ObfuscatedName("b")
   boolean field818;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "-1465648909"
   )
   int method1220(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field818) {
            if(Client.world == var1.world) {
               return -1;
            }

            if(var2.world == Client.world) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1220((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "828575971"
   )
   static final void method1221() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            NPCComposition.method5107(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
