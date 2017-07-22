import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static BufferProvider field417;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field413;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 968476905
   )
   int field415;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1565645903
   )
   int field422;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1682374057
   )
   int field416;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -810052909
   )
   int field420;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1931169429
   )
   int field419;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1353053315
   )
   int field414;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1802502829
   )
   int field421;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1427880323
   )
   int field412;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1302357139
   )
   int field424;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -355112203
   )
   int field418;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-1713"
   )
   public boolean vmethod676(int var1, int var2) {
      return var1 >> 6 >= this.field415 && var1 >> 6 <= this.field420 && var2 >> 6 >= this.field419 && var2 >> 6 <= this.field421;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-762941504"
   )
   public boolean vmethod675(int var1, int var2, int var3) {
      return var1 >= this.field422 && var1 < this.field416 + this.field422?var2 >> 6 >= this.field414 && var2 >> 6 <= this.field412 && var3 >> 6 >= this.field424 && var3 >> 6 <= this.field418:false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lab;S)V",
      garbageValue = "-29128"
   )
   public void vmethod693(WorldMapData var1) {
      if(var1.field443 > this.field415) {
         var1.field443 = this.field415;
      }

      if(var1.field444 < this.field420) {
         var1.field444 = this.field420;
      }

      if(var1.field442 > this.field419) {
         var1.field442 = this.field419;
      }

      if(var1.field435 < this.field421) {
         var1.field435 = this.field421;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "861336956"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod676(var1, var2)) {
         return null;
      } else {
         int var3 = this.field414 * 64 - this.field415 * 64 + var1;
         int var4 = this.field424 * 64 - this.field419 * 64 + var2;
         return new Coordinates(this.field422, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1119600547"
   )
   public int[] vmethod677(int var1, int var2, int var3) {
      if(!this.vmethod675(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field415 * 64 - this.field414 * 64 + var2, var3 + (this.field419 * 64 - this.field424 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-58"
   )
   public void vmethod678(Buffer var1) {
      this.field422 = var1.readUnsignedByte();
      this.field416 = var1.readUnsignedByte();
      this.field414 = var1.readUnsignedShort();
      this.field424 = var1.readUnsignedShort();
      this.field412 = var1.readUnsignedShort();
      this.field418 = var1.readUnsignedShort();
      this.field415 = var1.readUnsignedShort();
      this.field419 = var1.readUnsignedShort();
      this.field420 = var1.readUnsignedShort();
      this.field421 = var1.readUnsignedShort();
      this.method255();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "30"
   )
   void method255() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "1339741445"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var3 = (byte[])((byte[])var0);
         return var1?Renderable.method2800(var3):var3;
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "([Lho;II)V",
      garbageValue = "189901323"
   )
   static final void method267(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method267(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  class208.method3824(var4.id, var1);
               }
            }

            ScriptEvent var5;
            if(var1 == 0 && var3.field2690 != null) {
               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field831 = var3.field2690;
               Ignore.method1054(var5);
            }

            if(var1 == 1 && var3.field2694 != null) {
               if(var3.index >= 0) {
                  Widget var6 = class239.method4167(var3.id);
                  if(var6 == null || var6.children == null || var3.index >= var6.children.length || var3 != var6.children[var3.index]) {
                     continue;
                  }
               }

               var5 = new ScriptEvent();
               var5.widget = var3;
               var5.field831 = var3.field2694;
               Ignore.method1054(var5);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "622439872"
   )
   static final boolean method268(int var0, int var1) {
      ObjectComposition var2 = class169.getObjectDefinition(var0);
      if(var1 == 11) {
         var1 = 10;
      }

      if(var1 >= 5 && var1 <= 8) {
         var1 = 4;
      }

      return var2.method4401(var1);
   }
}
