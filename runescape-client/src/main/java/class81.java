import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
public final class class81 extends Node {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   static Deque field1248;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1446308957
   )
   int field1244;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 579690477
   )
   int field1241;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1255363219
   )
   int field1251;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 633772749
   )
   int field1242;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1326825575
   )
   int field1245;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 787009789
   )
   int field1246;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -130676821
   )
   int field1247;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   class116 field1253;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljv;"
   )
   ObjectComposition field1254;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -482239519
   )
   int field1249;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -168622661
   )
   int field1243;
   @ObfuscatedName("n")
   int[] field1240;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2132680707
   )
   int field1252;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ldv;"
   )
   class116 field1250;

   static {
      field1248 = new Deque();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1782122918"
   )
   void method1646() {
      int var1 = this.field1247;
      ObjectComposition var2 = this.field1254.getImpostor();
      if(var2 != null) {
         this.field1247 = var2.ambientSoundId;
         this.field1246 = var2.int4 * 128;
         this.field1249 = var2.int5;
         this.field1243 = var2.int6;
         this.field1240 = var2.field3547;
      } else {
         this.field1247 = -1;
         this.field1246 = 0;
         this.field1249 = 0;
         this.field1243 = 0;
         this.field1240 = null;
      }

      if(var1 != this.field1247 && this.field1253 != null) {
         MouseRecorder.field821.method1954(this.field1253);
         this.field1253 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "4"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = class181.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field857 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - IndexDataBase.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - Occluder.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class233.plane = var2.field853 = var4;
      if(class94.field1407[var1] != null) {
         var2.decodeApperance(class94.field1407[var1]);
      }

      class94.playerIndexesCount = 0;
      class94.playerIndices[++class94.playerIndexesCount - 1] = var1;
      class94.field1412[var1] = 0;
      class94.field1414 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var7 != var1) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class94.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class94.Players_orientations[var7] = 0;
            class94.Players_targetIndices[var7] = -1;
            class94.field1415[++class94.field1414 - 1] = var7;
            class94.field1412[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1149553973"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class96.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class96.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class96.messages.put(var5, (long)var5.id);
      class96.field1435.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
