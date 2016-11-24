import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
public class class18 extends Node {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2077946585
   )
   int field181;
   @ObfuscatedName("d")
   boolean field182;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -706934325
   )
   int field184;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1805705053
   )
   int field185;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1436106977
   )
   int field186;
   @ObfuscatedName("c")
   Widget field187;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1267925013
   )
   int field188;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2114863663
   )
   int field189;
   @ObfuscatedName("m")
   Widget field192;
   @ObfuscatedName("bp")
   @Export("host")
   static String host;
   @ObfuscatedName("n")
   Object[] field196;
   @ObfuscatedName("z")
   String field199;
   @ObfuscatedName("j")
   static int[] field200;

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1204820258"
   )
   static final void method204(boolean var0) {
      Client.field411 = 0;
      Client.field337 = 0;
      Client.field370.method3232();
      int var1 = Client.field370.method3237(8);
      int var2;
      if(var1 < Client.field326) {
         for(var2 = var1; var2 < Client.field326; ++var2) {
            Client.field412[++Client.field411 - 1] = Client.field559[var2];
         }
      }

      if(var1 > Client.field326) {
         throw new RuntimeException("");
      } else {
         Client.field326 = 0;

         for(var2 = 0; var2 < var1; ++var2) {
            int var3 = Client.field559[var2];
            NPC var4 = Client.cachedNPCs[var3];
            int var5 = Client.field370.method3237(1);
            if(var5 == 0) {
               Client.field559[++Client.field326 - 1] = var3;
               var4.field644 = Client.gameCycle;
            } else {
               int var6 = Client.field370.method3237(2);
               if(var6 == 0) {
                  Client.field559[++Client.field326 - 1] = var3;
                  var4.field644 = Client.gameCycle;
                  Client.field329[++Client.field337 - 1] = var3;
               } else {
                  int var7;
                  int var8;
                  if(var6 == 1) {
                     Client.field559[++Client.field326 - 1] = var3;
                     var4.field644 = Client.gameCycle;
                     var7 = Client.field370.method3237(3);
                     var4.method734(var7, (byte)1);
                     var8 = Client.field370.method3237(1);
                     if(var8 == 1) {
                        Client.field329[++Client.field337 - 1] = var3;
                     }
                  } else if(var6 == 2) {
                     Client.field559[++Client.field326 - 1] = var3;
                     var4.field644 = Client.gameCycle;
                     var7 = Client.field370.method3237(3);
                     var4.method734(var7, (byte)2);
                     var8 = Client.field370.method3237(3);
                     var4.method734(var8, (byte)2);
                     int var9 = Client.field370.method3237(1);
                     if(var9 == 1) {
                        Client.field329[++Client.field337 - 1] = var3;
                     }
                  } else if(var6 == 3) {
                     Client.field412[++Client.field411 - 1] = var3;
                  }
               }
            }
         }

         KitDefinition.method3567(var0);
         XClanMember.method261();

         for(var1 = 0; var1 < Client.field411; ++var1) {
            var2 = Client.field412[var1];
            if(Client.cachedNPCs[var2].field644 != Client.gameCycle) {
               Client.cachedNPCs[var2].composition = null;
               Client.cachedNPCs[var2] = null;
            }
         }

         if(Client.field564 != Client.field370.offset) {
            throw new RuntimeException(Client.field370.offset + "," + Client.field564);
         } else {
            for(var1 = 0; var1 < Client.field326; ++var1) {
               if(Client.cachedNPCs[Client.field559[var1]] == null) {
                  throw new RuntimeException(var1 + "," + Client.field326);
               }
            }

         }
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   static final void method205() {
      for(class25 var0 = (class25)Client.field419.method2466(); var0 != null; var0 = (class25)Client.field419.method2461()) {
         if(var0.field582 == -1) {
            var0.field581 = 0;
            class1.method21(var0);
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "-33"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2945.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2942.method3329(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3691();
         if(var1.field2980 != -1) {
            var1.method3694(getItemDefinition(var1.field2980), getItemDefinition(var1.note));
         }

         if(var1.field2972 != -1) {
            var1.method3695(getItemDefinition(var1.field2972), getItemDefinition(var1.field2957));
         }

         if(var1.field2991 != -1) {
            var1.method3690(getItemDefinition(var1.field2991), getItemDefinition(var1.field2958));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2987 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field2986 = 0;
         }

         ItemComposition.field2945.put(var1, (long)var0);
         return var1;
      }
   }
}
