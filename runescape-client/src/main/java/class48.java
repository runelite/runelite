import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -563995631
   )
   int field566;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1855067493
   )
   int field558;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1559955611
   )
   int field559;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2128703873
   )
   int field560;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1183821637
   )
   int field561;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 502181467
   )
   int field557;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -799496983
   )
   int field563;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2035734503
   )
   int field564;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1469729145
   )
   int field565;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -143841309
   )
   int field562;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lai;B)V",
      garbageValue = "59"
   )
   public void vmethod736(WorldMapData var1) {
      if(var1.field419 > this.field561) {
         var1.field419 = this.field561;
      }

      if(var1.field420 < this.field561) {
         var1.field420 = this.field561;
      }

      if(var1.field413 > this.field557) {
         var1.field413 = this.field557;
      }

      if(var1.field422 < this.field557) {
         var1.field422 = this.field557;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2052357031"
   )
   public boolean vmethod737(int var1, int var2, int var3) {
      return var1 >= this.field566 && var1 < this.field566 + this.field558?var2 >= (this.field559 << 6) + (this.field563 << 3) && var2 <= (this.field559 << 6) + (this.field563 << 3) + 7 && var3 >= (this.field560 << 6) + (this.field564 << 3) && var3 <= (this.field560 << 6) + (this.field564 << 3) + 7:false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "1"
   )
   public boolean vmethod745(int var1, int var2) {
      return var1 >= (this.field561 << 6) + (this.field565 << 3) && var1 <= (this.field561 << 6) + (this.field565 << 3) + 7 && var2 >= (this.field557 << 6) + (this.field562 << 3) && var2 <= (this.field557 << 6) + (this.field562 << 3) + 7;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1022148607"
   )
   public int[] vmethod738(int var1, int var2, int var3) {
      if(!this.vmethod737(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field561 * 64 - this.field559 * 64 + var2 + (this.field565 * 8 - this.field563 * 8), var3 + (this.field557 * 64 - this.field560 * 64) + (this.field562 * 8 - this.field564 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Lhp;",
      garbageValue = "-1642348517"
   )
   public Coordinates vmethod739(int var1, int var2) {
      if(!this.vmethod745(var1, var2)) {
         return null;
      } else {
         int var3 = this.field559 * 64 - this.field561 * 64 + (this.field563 * 8 - this.field565 * 8) + var1;
         int var4 = this.field560 * 64 - this.field557 * 64 + var2 + (this.field564 * 8 - this.field562 * 8);
         return new Coordinates(this.field566, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1338328003"
   )
   public void vmethod741(Buffer var1) {
      this.field566 = var1.readUnsignedByte();
      this.field558 = var1.readUnsignedByte();
      this.field559 = var1.readUnsignedShort();
      this.field563 = var1.readUnsignedByte();
      this.field560 = var1.readUnsignedShort();
      this.field564 = var1.readUnsignedByte();
      this.field561 = var1.readUnsignedShort();
      this.field565 = var1.readUnsignedByte();
      this.field557 = var1.readUnsignedShort();
      this.field562 = var1.readUnsignedByte();
      this.method742();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "60464412"
   )
   void method742() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "617273771"
   )
   @Export("addChatMessage")
   @Hook("addChatMessage")
   static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatLineBuffer var4 = (ChatLineBuffer)class94.chatLineMap.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new ChatLineBuffer();
         class94.chatLineMap.put(Integer.valueOf(var0), var4);
      }

      MessageNode var5 = var4.addMessage(var0, var1, var2, var3);
      class94.messages.put(var5, (long)var5.id);
      class94.field1397.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }
}
