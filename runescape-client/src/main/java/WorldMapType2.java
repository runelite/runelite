import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("j")
   @Export("titlemuteSprite")
   static ModIcon[] titlemuteSprite;
   @ObfuscatedName("rm")
   @ObfuscatedGetter(
      intValue = 1583246805
   )
   static int field545;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1604656279
   )
   int field544;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -357340807
   )
   int field542;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -710106961
   )
   int field538;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -455276269
   )
   int field539;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -210083313
   )
   int field540;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 563618079
   )
   int field541;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   public boolean vmethod754(int var1, int var2) {
      return var1 >> 6 == this.field542 && var2 >> 6 == this.field538;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field544 && var1 < this.field544 + this.field539?var2 >> 6 == this.field540 && var3 >> 6 == this.field541:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "98017718"
   )
   public void vmethod753(WorldMapData var1) {
      if(var1.field467 > this.field542) {
         var1.field467 = this.field542;
      }

      if(var1.field468 < this.field542) {
         var1.field468 = this.field542;
      }

      if(var1.field472 > this.field538) {
         var1.field472 = this.field538;
      }

      if(var1.field466 < this.field538) {
         var1.field466 = this.field538;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2079571098"
   )
   public Coordinates vmethod731(int var1, int var2) {
      if(!this.vmethod754(var1, var2)) {
         return null;
      } else {
         int var3 = this.field540 * 64 - this.field542 * 64 + var1;
         int var4 = this.field541 * 64 - this.field538 * 64 + var2;
         return new Coordinates(this.field544, var3, var4);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1509988890"
   )
   public int[] vmethod730(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field542 * 64 - this.field540 * 64 + var2, var3 + (this.field538 * 64 - this.field541 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-128"
   )
   void method524() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "618655756"
   )
   public void vmethod732(Buffer var1) {
      this.field544 = var1.readUnsignedByte();
      this.field539 = var1.readUnsignedByte();
      this.field540 = var1.readUnsignedShort();
      this.field541 = var1.readUnsignedShort();
      this.field542 = var1.readUnsignedShort();
      this.field538 = var1.readUnsignedShort();
      this.method524();
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "868030669"
   )
   static final void method525(class119 var0) {
      var0.field1725 = false;
      if(var0.field1726 != null) {
         var0.field1726.field1759 = 0;
      }

      for(class119 var1 = var0.vmethod3864(); var1 != null; var1 = var0.vmethod3865()) {
         method525(var1);
      }

   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      signature = "([LWidget;LWidget;ZI)V",
      garbageValue = "-691198249"
   )
   static void method546(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      ScriptEvent.method1131(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         ScriptEvent.method1131(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         WorldMapType3.method202(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
