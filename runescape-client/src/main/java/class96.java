import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
public class class96 {
   @ObfuscatedName("i")
   static byte[] field1466;
   @ObfuscatedName("u")
   static byte[] field1467;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[Lfp;"
   )
   static Buffer[] field1475;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1892351531
   )
   static int field1469;
   @ObfuscatedName("s")
   static int[] field1470;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1688696245
   )
   static int field1476;
   @ObfuscatedName("p")
   static int[] field1472;
   @ObfuscatedName("k")
   static int[] field1473;
   @ObfuscatedName("r")
   static int[] field1474;
   @ObfuscatedName("w")
   static int[] field1471;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -298906535
   )
   static int field1480;
   @ObfuscatedName("h")
   static int[] field1465;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   static Buffer field1464;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      longValue = 901218529665921569L
   )
   static long field1479;
   @ObfuscatedName("pm")
   @ObfuscatedGetter(
      intValue = -828221107
   )
   static int field1481;

   static {
      field1466 = new byte[2048];
      field1467 = new byte[2048];
      field1475 = new Buffer[2048];
      field1469 = 0;
      field1470 = new int[2048];
      field1476 = 0;
      field1472 = new int[2048];
      field1473 = new int[2048];
      field1474 = new int[2048];
      field1471 = new int[2048];
      field1480 = 0;
      field1465 = new int[2048];
      field1464 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("fg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2112046475"
   )
   static final void method1732() {
      int[] var0 = field1470;

      int var1;
      for(var1 = 0; var1 < field1469; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1225 > 0) {
            --var2.field1225;
            if(var2.field1225 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.field953; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1225 > 0) {
            --var3.field1225;
            if(var3.field1225 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
