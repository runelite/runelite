import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
public final class class82 extends Node {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   static Deque field1330;
   @ObfuscatedName("nx")
   @ObfuscatedGetter(
      intValue = -263364235
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -416510297
   )
   int field1326;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   ObjectComposition field1329;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 921934015
   )
   int field1325;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1213238287
   )
   int field1324;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -2106925397
   )
   int field1331;
   @ObfuscatedName("m")
   int[] field1316;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1323;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 919872157
   )
   int field1319;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1003867189
   )
   int field1317;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1892123681
   )
   int field1322;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 457851029
   )
   int field1327;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1736456595
   )
   int field1321;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldq;"
   )
   class118 field1328;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1896100879
   )
   int field1315;

   static {
      field1330 = new Deque();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method1599() {
      int var1 = this.field1326;
      ObjectComposition var2 = this.field1329.getImpostor();
      if(var2 != null) {
         this.field1326 = var2.ambientSoundId;
         this.field1325 = var2.field3437 * 128;
         this.field1324 = var2.field3472;
         this.field1331 = var2.field3434;
         this.field1316 = var2.field3474;
      } else {
         this.field1326 = -1;
         this.field1325 = 0;
         this.field1324 = 0;
         this.field1331 = 0;
         this.field1316 = null;
      }

      if(var1 != this.field1326 && this.field1323 != null) {
         class56.field679.method1923(this.field1323);
         this.field1323 = null;
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lfo;I)V",
      garbageValue = "-1325312570"
   )
   static final void method1612(PacketBuffer var0) {
      for(int var1 = 0; var1 < class97.field1506; ++var1) {
         int var2 = class97.field1518[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 64) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         class33.method373(var0, var2, var3, var4);
      }

   }
}
