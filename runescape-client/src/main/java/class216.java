import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
public class class216 extends Node {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1789877157
   )
   int field2648;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   class218 field2651;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   class213 field2634;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ldp;"
   )
   RawAudioNode field2633;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 995190901
   )
   int field2635;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1429101731
   )
   int field2636;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1103850305
   )
   int field2637;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1407430437
   )
   int field2638;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -829686943
   )
   int field2639;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1703950983
   )
   int field2640;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1708814875
   )
   int field2641;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2096263727
   )
   int field2642;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 676665931
   )
   int field2643;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1422559719
   )
   int field2644;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -8250165
   )
   int field2631;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 675873075
   )
   int field2632;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1247746265
   )
   int field2647;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 576806169
   )
   int field2645;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ldm;"
   )
   class114 field2649;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 408709971
   )
   int field2650;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1998284601
   )
   int field2646;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-39"
   )
   void method4073() {
      this.field2651 = null;
      this.field2633 = null;
      this.field2634 = null;
      this.field2649 = null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgd;I)V",
      garbageValue = "2144113696"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class36.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field809 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - WorldMapType1.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - class85.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      MessageNode.plane = var2.field808 = var4;
      if(class92.field1377[var1] != null) {
         var2.decodeApperance(class92.field1377[var1]);
      }

      class92.playerIndexesCount = 0;
      class92.playerIndices[++class92.playerIndexesCount - 1] = var1;
      class92.field1375[var1] = 0;
      class92.field1373 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class92.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class92.Players_orientations[var7] = 0;
            class92.Players_targetIndices[var7] = -1;
            class92.field1384[++class92.field1373 - 1] = var7;
            class92.field1375[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1028668801"
   )
   static int method4077(int var0) {
      MessageNode var1 = (MessageNode)class94.messages.get((long)var0);
      return var1 == null?-1:(var1.next == class94.field1401.sentinel?-1:((MessageNode)var1.next).id);
   }
}
