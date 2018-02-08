import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 132604021
   )
   int field418;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -75356029
   )
   int field416;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -349260903
   )
   int field408;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -2038464019
   )
   int field410;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 187760729
   )
   int field411;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 283585943
   )
   int field412;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 392589395
   )
   int field409;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 868542637
   )
   int field414;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 162431477
   )
   int field415;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1705199285
   )
   int field407;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Las;I)V",
      garbageValue = "-1901809840"
   )
   public void vmethod681(WorldMapData var1) {
      if(var1.field432 > this.field409) {
         var1.field432 = this.field409;
      }

      if(var1.field433 < this.field415) {
         var1.field433 = this.field415;
      }

      if(var1.field426 > this.field414) {
         var1.field426 = this.field414;
      }

      if(var1.field435 < this.field407) {
         var1.field435 = this.field407;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "-76"
   )
   public boolean vmethod682(int var1, int var2, int var3) {
      return var1 >= this.field418 && var1 < this.field418 + this.field416?var2 >> 6 >= this.field408 && var2 >> 6 <= this.field411 && var3 >> 6 >= this.field410 && var3 >> 6 <= this.field412:false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1516873803"
   )
   public boolean vmethod683(int var1, int var2) {
      return var1 >> 6 >= this.field409 && var1 >> 6 <= this.field415 && var2 >> 6 >= this.field414 && var2 >> 6 <= this.field407;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-28346373"
   )
   public int[] vmethod684(int var1, int var2, int var3) {
      if(!this.vmethod682(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field409 * 64 - this.field408 * 64 + var2, var3 + (this.field414 * 64 - this.field410 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Lhv;",
      garbageValue = "-92"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod683(var1, var2)) {
         return null;
      } else {
         int var3 = this.field408 * 64 - this.field409 * 64 + var1;
         int var4 = this.field410 * 64 - this.field414 * 64 + var2;
         return new Coordinates(this.field418, var3, var4);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "1352125466"
   )
   public void vmethod686(Buffer var1) {
      this.field418 = var1.readUnsignedByte();
      this.field416 = var1.readUnsignedByte();
      this.field408 = var1.readUnsignedShort();
      this.field410 = var1.readUnsignedShort();
      this.field411 = var1.readUnsignedShort();
      this.field412 = var1.readUnsignedShort();
      this.field409 = var1.readUnsignedShort();
      this.field414 = var1.readUnsignedShort();
      this.field415 = var1.readUnsignedShort();
      this.field407 = var1.readUnsignedShort();
      this.method252();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2067269249"
   )
   void method252() {
   }

   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      signature = "([Lhs;IB)V",
      garbageValue = "104"
   )
   static final void method269(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method269(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(ServerPacket.loadWidget(var5)) {
                     method269(ScriptState.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2861 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2861;
               class84.method1868(var6);
            }

            if(var1 == 1 && var3.field2800 != null) {
               if(var3.index >= 0) {
                  Widget var7 = class216.getWidget(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var3 != var7.children[var3.index]) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.objs = var3.field2800;
               class84.method1868(var6);
            }
         }
      }

   }
}
