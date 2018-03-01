import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   public static class265 field852;
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Lfa;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("d")
   boolean field853;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-365421721"
   )
   int method1183(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field853) {
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
      return this.method1183((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lir;I)Z",
      garbageValue = "-1238325745"
   )
   public static boolean method1193(class245 var0) {
      return class245.field2968 == var0 || class245.field2963 == var0 || class245.field2962 == var0 || class245.field2972 == var0 || class245.field2964 == var0 || class245.field2967 == var0 || class245.field2965 == var0 || class245.field2969 == var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "34"
   )
   public static boolean method1184(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1609284924"
   )
   static final void method1192() {
      PacketBuffer var0 = Client.field899.packetBuffer;
      var0.bitAccess();
      int var1 = var0.getBits(8);
      int var2;
      if(var1 < Client.npcIndexesCount) {
         for(var2 = var1; var2 < Client.npcIndexesCount; ++var2) {
            Client.field972[++Client.field998 - 1] = Client.npcIndices[var2];
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
                     var4.method1870(var7, (byte)1);
                     var8 = var0.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.npcIndices[++Client.npcIndexesCount - 1] = var3;
                     var4.npcCycle = Client.gameCycle;
                     var7 = var0.getBits(3);
                     var4.method1870(var7, (byte)2);
                     var8 = var0.getBits(3);
                     var4.method1870(var8, (byte)2);
                     int var9 = var0.getBits(1);
                     if(var9 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field972[++Client.field998 - 1] = var3;
                  }
               }
            }
         }

      }
   }
}
