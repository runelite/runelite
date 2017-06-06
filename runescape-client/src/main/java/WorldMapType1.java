import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1559231345
   )
   int field431;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -604285845
   )
   int field432;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 599173193
   )
   int field433;
   @ObfuscatedName("ks")
   static Widget field434;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -656484907
   )
   int field435;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 704724231
   )
   int field436;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 442809713
   )
   int field437;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -612542657
   )
   int field438;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1717107375
   )
   int field439;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -816480419
   )
   int field440;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -966143997
   )
   int field441;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "952872297"
   )
   public boolean vmethod696(int var1, int var2, int var3) {
      return var1 >= this.field431 && var1 < this.field432 + this.field431?var2 >> 6 >= this.field441 && var2 >> 6 <= this.field435 && var3 >> 6 >= this.field433 && var3 >> 6 <= this.field436:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-106764697"
   )
   public boolean vmethod707(int var1, int var2) {
      return var1 >> 6 >= this.field437 && var1 >> 6 <= this.field439 && var2 >> 6 >= this.field438 && var2 >> 6 <= this.field440;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-56"
   )
   public void vmethod700(Buffer var1) {
      this.field431 = var1.readUnsignedByte();
      this.field432 = var1.readUnsignedByte();
      this.field441 = var1.readUnsignedShort();
      this.field433 = var1.readUnsignedShort();
      this.field435 = var1.readUnsignedShort();
      this.field436 = var1.readUnsignedShort();
      this.field437 = var1.readUnsignedShort();
      this.field438 = var1.readUnsignedShort();
      this.field439 = var1.readUnsignedShort();
      this.field440 = var1.readUnsignedShort();
      this.method242();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "730410078"
   )
   public Coordinates vmethod699(int var1, int var2) {
      if(!this.vmethod707(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field441 * 64 - this.field437 * 64);
         int var4 = var2 + (this.field433 * 64 - this.field438 * 64);
         return new Coordinates(this.field431, var3, var4);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-100226432"
   )
   void method242() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;B)V",
      garbageValue = "-1"
   )
   public void vmethod695(WorldMapData var1) {
      if(var1.field458 > this.field437) {
         var1.field458 = this.field437;
      }

      if(var1.field465 < this.field439) {
         var1.field465 = this.field439;
      }

      if(var1.field456 > this.field438) {
         var1.field456 = this.field438;
      }

      if(var1.field461 < this.field440) {
         var1.field461 = this.field440;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-578749739"
   )
   public int[] vmethod698(int var1, int var2, int var3) {
      if(!this.vmethod696(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field437 * 64 - this.field441 * 64), this.field438 * 64 - this.field433 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "256280341"
   )
   static final void method260() {
      Client.secretPacketBuffer1.putOpcode(156);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3518(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3524()) {
         if(var0.field840 == 0 || var0.field840 == 3) {
            ScriptState.method1054(var0, true);
         }
      }

      if(Client.field963 != null) {
         class25.method169(Client.field963);
         Client.field963 = null;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZI)I",
      garbageValue = "1043856637"
   )
   static int method261(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method1545()?(var1.method1545()?0:1):(var1.method1545()?-1:0)):(var2 == 5?(var0.method1547()?(var1.method1547()?0:1):(var1.method1547()?-1:0)):(var2 == 6?(var0.method1548()?(var1.method1548()?0:1):(var1.method1548()?-1:0)):(var2 == 7?(var0.method1567()?(var1.method1567()?0:1):(var1.method1567()?-1:0)):var0.id - var1.id)))));
      }
   }
}
