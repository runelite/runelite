import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 639798369
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2147285637
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1684620931
   )
   @Export("type")
   int type;
   @ObfuscatedName("a")
   @Export("name")
   String name;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   Name field811;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field804;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkx;"
   )
   class303 field807;
   @ObfuscatedName("x")
   @Export("sender")
   String sender;
   @ObfuscatedName("p")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field804 = class303.field3850;
      this.field807 = class303.field3850;
      int var5 = ++class95.field1422 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1172();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "127"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      int var5 = ++class95.field1422 - 1;
      this.id = var5;
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1172();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-23"
   )
   void method1166() {
      this.field804 = class303.field3850;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "678327261"
   )
   final boolean method1174() {
      if(this.field804 == class303.field3850) {
         this.method1168();
      }

      return this.field804 == class303.field3846;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "210198800"
   )
   void method1168() {
      this.field804 = WallObject.friendManager.field1229.isMember(this.field811)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "23456187"
   )
   void method1169() {
      this.field807 = class303.field3850;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "169274032"
   )
   final boolean method1186() {
      if(this.field807 == class303.field3850) {
         this.method1171();
      }

      return this.field807 == class303.field3846;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-259911886"
   )
   void method1171() {
      this.field807 = WallObject.friendManager.field1233.isMember(this.field811)?class303.field3846:class303.field3847;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "50"
   )
   final void method1172() {
      if(this.name != null) {
         this.field811 = new Name(ScriptEvent.method1157(this.name), KeyFocusListener.loginType);
      } else {
         this.field811 = null;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgz;B)V",
      garbageValue = "15"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = WorldMapData.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field837 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class38.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - PlayerComposition.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      Ignore.plane = var2.field836 = var4;
      if(class93.field1405[var1] != null) {
         var2.decodeApperance(class93.field1405[var1]);
      }

      class93.playerIndexesCount = 0;
      class93.playerIndices[++class93.playerIndexesCount - 1] = var1;
      class93.field1394[var1] = 0;
      class93.field1398 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class93.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class93.Players_orientations[var7] = 0;
            class93.Players_targetIndices[var7] = -1;
            class93.field1399[++class93.field1398 - 1] = var7;
            class93.field1394[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "31"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class314.cp1252AsciiExtension[var6 - 128];
               if(var7 == 0) {
                  var7 = '?';
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      signature = "(Lig;Ljy;IIZI)V",
      garbageValue = "-1236962070"
   )
   static final void method1180(Widget var0, ItemComposition var1, int var2, int var3, boolean var4) {
      String[] var5 = var1.inventoryActions;
      byte var6 = -1;
      String var7 = null;
      if(var5 != null && var5[var3] != null) {
         if(var3 == 0) {
            var6 = 33;
         } else if(var3 == 1) {
            var6 = 34;
         } else if(var3 == 2) {
            var6 = 35;
         } else if(var3 == 3) {
            var6 = 36;
         } else {
            var6 = 37;
         }

         var7 = var5[var3];
      } else if(var3 == 4) {
         var6 = 37;
         var7 = "Drop";
      }

      if(var6 != -1 && var7 != null) {
         Size.method193(var7, class37.getColTags(16748608) + var1.name, var6, var1.id, var2, var0.id, var4);
      }

   }
}
