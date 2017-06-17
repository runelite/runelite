import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -458018593
   )
   int field388;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -671503815
   )
   int field389;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -127617329
   )
   int field390;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -815767425
   )
   int field391;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -284802493
   )
   int field392;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -400684587
   )
   int field393;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1898072897
   )
   int field394;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1569099531
   )
   int field395;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -425813391
   )
   int field396;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 599115961
   )
   int field397;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1765789525
   )
   int field398;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1615313347
   )
   int field399;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1110923903
   )
   int field400;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1338753269
   )
   int field401;
   @ObfuscatedName("cc")
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("g")
   public static class123[] field404;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2095092414"
   )
   public boolean vmethod678(int var1, int var2, int var3) {
      return var1 >= this.field394 && var1 < this.field389 + this.field394?var2 >= (this.field400 << 3) + (this.field390 << 6) && var2 <= (this.field396 << 3) + (this.field390 << 6) + 7 && var3 >= (this.field398 << 6) + (this.field395 << 3) && var3 <= (this.field398 << 6) + (this.field397 << 3) + 7:false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "108"
   )
   public boolean vmethod679(int var1, int var2) {
      return var1 >= (this.field388 << 3) + (this.field391 << 6) && var1 <= (this.field391 << 6) + (this.field392 << 3) + 7 && var2 >= (this.field393 << 6) + (this.field399 << 3) && var2 <= (this.field393 << 6) + (this.field401 << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-1537373407"
   )
   public Coordinates vmethod685(int var1, int var2) {
      if(!this.vmethod679(var1, var2)) {
         return null;
      } else {
         int var3 = var1 + (this.field390 * 64 - this.field391 * 64) + (this.field400 * 8 - this.field388 * 8);
         int var4 = var2 + (this.field398 * 64 - this.field393 * 64) + (this.field395 * 8 - this.field399 * 8);
         return new Coordinates(this.field394, var3, var4);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1315256502"
   )
   public void vmethod684(Buffer var1) {
      this.field394 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedByte();
      this.field390 = var1.readUnsignedShort();
      this.field400 = var1.readUnsignedByte();
      this.field396 = var1.readUnsignedByte();
      this.field398 = var1.readUnsignedShort();
      this.field395 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field391 = var1.readUnsignedShort();
      this.field388 = var1.readUnsignedByte();
      this.field392 = var1.readUnsignedByte();
      this.field393 = var1.readUnsignedShort();
      this.field399 = var1.readUnsignedByte();
      this.field401 = var1.readUnsignedByte();
      this.method211();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3604"
   )
   void method211() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "630255391"
   )
   public int[] vmethod682(int var1, int var2, int var3) {
      if(!this.vmethod678(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field391 * 64 - this.field390 * 64 + var2 + (this.field388 * 8 - this.field400 * 8), var3 + (this.field393 * 64 - this.field398 * 64) + (this.field399 * 8 - this.field395 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-696545254"
   )
   static final void method219(int var0) {
      if(class59.method961(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2776 = 0;
               var3.field2758 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "10"
   )
   static final void method221() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               if(Client.field1053 != -1) {
                  if(var1 == Client.field1053) {
                     Client.field1053 = var1 + 1;
                  } else if(Client.field1053 == var1 + 1) {
                     Client.field1053 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-466828627"
   )
   public void vmethod680(WorldMapData var1) {
      if(var1.field459 > this.field391) {
         var1.field459 = this.field391;
      }

      if(var1.field465 < this.field391) {
         var1.field465 = this.field391;
      }

      if(var1.field466 > this.field393) {
         var1.field466 = this.field393;
      }

      if(var1.field458 < this.field393) {
         var1.field458 = this.field393;
      }

   }
}
