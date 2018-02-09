import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("l")
@Implements("WorldComparator")
final class WorldComparator implements Comparator {
   @ObfuscatedName("qe")
   @ObfuscatedSignature(
      signature = "Lbg;"
   )
   @Export("preferences")
   static Preferences preferences;
   @ObfuscatedName("lb")
   @ObfuscatedGetter(
      intValue = -941930431
   )
   static int field268;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = -1542661953
   )
   static int field265;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "1847571219"
   )
   int method59(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.world < var2.world?-1:(var2.world == var1.world?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method59((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1049129755"
   )
   public static int method72(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "918268011"
   )
   static final void method65() {
      PacketBuffer var0 = Client.field937.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.field948[++Client.field947 - 1] = Client.npcIndices[var2];
         }
      }

      if(var1 > Client.npcIndexesCount) {
         throw new RuntimeException("");
      } else {
         Client.npcIndexesCount = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.npcIndices[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = var0.getBits(1);
            if(var5 == 0) {
               Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
               var4.npcCycle = Client.gameCycle;
            } else {
               int var6 = var0.getBits(2);
               if(var6 == 0) {
                  Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                  var4.npcCycle = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1851(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1851(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1851(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field948[++Client.field947 - 1] = var3;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("kp")
   @ObfuscatedSignature(
      signature = "(Lhs;B)I",
      garbageValue = "106"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}
