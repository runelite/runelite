import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lfz;"
   )
   static Buffer field404;
   @ObfuscatedName("fu")
   static int[] field400;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 681767849
   )
   int field396;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1721449461
   )
   int field387;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2085214777
   )
   int field385;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -568593829
   )
   int field388;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 541986553
   )
   int field389;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1888781829
   )
   int field390;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -513694507
   )
   int field391;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1520947225
   )
   int field392;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1210084189
   )
   int field393;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2073975375
   )
   int field394;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1719070115
   )
   int field395;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2022572503
   )
   int field402;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -389679019
   )
   int field397;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -394370629
   )
   int field398;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "1123585680"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field464 > this.field389) {
         var1.field464 = this.field389;
      }

      if(var1.field468 < this.field389) {
         var1.field468 = this.field389;
      }

      if(var1.field469 > this.field390) {
         var1.field469 = this.field390;
      }

      if(var1.field461 < this.field390) {
         var1.field461 = this.field390;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2147483647"
   )
   public boolean vmethod699(int var1, int var2, int var3) {
      return var1 >= this.field396 && var1 < this.field396 + this.field387?var2 >= (this.field385 << 6) + (this.field391 << 3) && var2 <= (this.field385 << 6) + (this.field393 << 3) + 7 && var3 >= (this.field388 << 6) + (this.field392 << 3) && var3 <= (this.field388 << 6) + (this.field394 << 3) + 7:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2005574810"
   )
   public boolean vmethod700(int var1, int var2) {
      return var1 >= (this.field389 << 6) + (this.field395 << 3) && var1 <= (this.field389 << 6) + (this.field397 << 3) + 7 && var2 >= (this.field390 << 6) + (this.field402 << 3) && var2 <= (this.field390 << 6) + (this.field398 << 3) + 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "880778915"
   )
   public int[] vmethod709(int var1, int var2, int var3) {
      if(!this.vmethod699(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field389 * 64 - this.field385 * 64 + var2 + (this.field395 * 8 - this.field391 * 8), var3 + (this.field390 * 64 - this.field388 * 64) + (this.field402 * 8 - this.field392 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "-1413226110"
   )
   public Coordinates vmethod702(int var1, int var2) {
      if(!this.vmethod700(var1, var2)) {
         return null;
      } else {
         int var3 = this.field385 * 64 - this.field389 * 64 + (this.field391 * 8 - this.field395 * 8) + var1;
         int var4 = this.field388 * 64 - this.field390 * 64 + var2 + (this.field392 * 8 - this.field402 * 8);
         return new Coordinates(this.field396, var3, var4);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "15"
   )
   public void vmethod703(Buffer var1) {
      this.field396 = var1.readUnsignedByte();
      this.field387 = var1.readUnsignedByte();
      this.field385 = var1.readUnsignedShort();
      this.field391 = var1.readUnsignedByte();
      this.field393 = var1.readUnsignedByte();
      this.field388 = var1.readUnsignedShort();
      this.field392 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedShort();
      this.field395 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedByte();
      this.field390 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedByte();
      this.field398 = var1.readUnsignedByte();
      this.method197();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1851482411"
   )
   void method197() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1061726490"
   )
   static int method212() {
      return 11;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1128289760"
   )
   static void method215() {
      FileOnDisk var0 = null;

      try {
         var0 = Tile.getPreferencesFile("", WorldMapType1.field452.field3192, true);
         Buffer var1 = class70.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2406(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "189568419"
   )
   static void method210(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "973507242"
   )
   public static boolean method213(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "428682471"
   )
   static void method200() {
      ItemContainer.itemContainers = new HashTable(32);
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "([Lhj;II)V",
      garbageValue = "219076969"
   )
   static final void method214(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !ScriptEvent.method1097(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && ScriptEvent.method1097(var3) && var3 != Sequence.field3621) {
                  continue;
               }

               method214(var0, var3.id);
               if(var3.children != null) {
                  method214(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(WorldMapData.loadWidget(var5)) {
                     method214(class215.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2711 != -1 || var3.field2690 != -1) {
                  boolean var4 = class2.method2(var3);
                  if(var4) {
                     var5 = var3.field2690;
                  } else {
                     var5 = var3.field2711;
                  }

                  if(var5 != -1) {
                     Sequence var6 = NPCComposition.getAnimation(var5);

                     for(var3.field2765 += Client.field1004; var3.field2765 > var6.frameLenghts[var3.field2680]; class45.method647(var3)) {
                        var3.field2765 -= var6.frameLenghts[var3.field2680];
                        ++var3.field2680;
                        if(var3.field2680 >= var6.frameIDs.length) {
                           var3.field2680 -= var6.frameStep;
                           if(var3.field2680 < 0 || var3.field2680 >= var6.frameIDs.length) {
                              var3.field2680 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2746 != 0 && !var3.hasScript) {
                  int var8 = var3.field2746 >> 16;
                  var5 = var3.field2746 << 16 >> 16;
                  var8 *= Client.field1004;
                  var5 *= Client.field1004;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class45.method647(var3);
               }
            }
         }
      }

   }
}
