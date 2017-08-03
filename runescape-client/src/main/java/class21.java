import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
public class class21 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   public static IndexDataBase field325;
   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   static IndexData field323;
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = -378913143
   )
   static int field326;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = 1118027707
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("ac")
   static int[] field324;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lci;",
      garbageValue = "84066500"
   )
   static Preferences method148() {
      FileOnDisk var0 = null;
      Preferences var1 = new Preferences();

      try {
         var0 = class41.getPreferencesFile("", Client.field1110.field3177, false);
         byte[] var2 = new byte[(int)var0.length()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.read(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new Preferences(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(var0 != null) {
            var0.close();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1636250603"
   )
   static void method146(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1266[var5] != var0) {
            var2[var4] = World.field1266[var5];
            var3[var4] = World.field1265[var5];
            ++var4;
         }
      }

      World.field1266 = var2;
      World.field1265 = var3;
      class13.method76(World.worldList, 0, World.worldList.length - 1, World.field1266, World.field1265);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1281212556"
   )
   static final void method147() {
      Client.secretPacketBuffer2.bitAccess();
      int var0 = Client.secretPacketBuffer2.getBits(8);
      int var1;
      if(var0 < Client.field932) {
         for(var1 = var0; var1 < Client.field932; ++var1) {
            Client.field1007[++Client.field1006 - 1] = Client.npcIndices[var1];
         }
      }

      if(var0 > Client.field932) {
         throw new RuntimeException("");
      } else {
         Client.field932 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = Client.npcIndices[var1];
            NPC var3 = Client.cachedNPCs[var2];
            int var4 = Client.secretPacketBuffer2.getBits(1);
            if(var4 == 0) {
               Client.npcIndices[++Client.field932 - 1] = var2;
               var3.field1238 = Client.gameCycle;
            } else {
               int var5 = Client.secretPacketBuffer2.getBits(2);
               if(var5 == 0) {
                  Client.npcIndices[++Client.field932 - 1] = var2;
                  var3.field1238 = Client.gameCycle;
                  Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     Client.npcIndices[++Client.field932 - 1] = var2;
                     var3.field1238 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1696(var6, (byte)1);
                     var7 = Client.secretPacketBuffer2.getBits(1);
                     if(var7 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     Client.npcIndices[++Client.field932 - 1] = var2;
                     var3.field1238 = Client.gameCycle;
                     var6 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1696(var6, (byte)2);
                     var7 = Client.secretPacketBuffer2.getBits(3);
                     var3.method1696(var7, (byte)2);
                     int var8 = Client.secretPacketBuffer2.getBits(1);
                     if(var8 == 1) {
                        Client.pendingNpcFlagsIndices[++Client.pendingNpcFlagsCount - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     Client.field1007[++Client.field1006 - 1] = var2;
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lhh;I)Z",
      garbageValue = "-1770374422"
   )
   public static boolean method149(class219 var0) {
      return class219.field2770 == var0 || class219.field2774 == var0 || class219.field2775 == var0 || class219.field2769 == var0 || class219.field2768 == var0 || class219.field2771 == var0 || class219.field2778 == var0 || class219.field2773 == var0;
   }
}
