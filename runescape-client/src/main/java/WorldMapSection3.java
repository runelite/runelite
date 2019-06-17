import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
@Implements("WorldMapSection3")
public class WorldMapSection3 implements WorldMapSection {
   @ObfuscatedName("h")
   @Export("osNameLowerCase")
   public static String osNameLowerCase;
   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache8")
   static IndexCache indexCache8;
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = -948290091
   )
   @Export("__p_go")
   static int __p_go;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1389733201
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1622972483
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 702057599
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1068088609
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1257151629
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1351623663
   )
   @Export("__u")
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1016557381
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 884736611
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 395786901
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -627081155
   )
   @Export("__x")
   int __x;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   public void expandBounds(WorldMapArea var1) {
      if(var1.minX0 > this.__g) {
         var1.minX0 = this.__g;
      }

      if(var1.maxX0 < this.__e) {
         var1.maxX0 = this.__e;
      }

      if(var1.minY0 > this.__l) {
         var1.minY0 = this.__l;
      }

      if(var1.maxY0 < this.__x) {
         var1.maxY0 = this.__x;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.__m && var1 < this.__m + this.__f?var2 >> 6 >= this.__q && var2 >> 6 <= this.__o && var3 >> 6 >= this.__w && var3 >> 6 <= this.__u:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 >= this.__g && var1 >> 6 <= this.__e && var2 >> 6 >= this.__l && var2 >> 6 <= this.__x;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1545934424"
   )
   public int[] position(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.__g * 64 - this.__q * 64 + var2, var3 + (this.__l * 64 - this.__w * 64)};
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "-1916486802"
   )
   public TileLocation coord(int var1, int var2) {
      if(!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.__q * 64 - this.__g * 64 + var1;
         int var4 = this.__w * 64 - this.__l * 64 + var2;
         return new TileLocation(this.__m, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   public void read(Buffer var1) {
      this.__m = var1.readUnsignedByte();
      this.__f = var1.readUnsignedByte();
      this.__q = var1.__ag_302();
      this.__w = var1.__ag_302();
      this.__o = var1.__ag_302();
      this.__u = var1.__ag_302();
      this.__g = var1.__ag_302();
      this.__l = var1.__ag_302();
      this.__e = var1.__ag_302();
      this.__x = var1.__ag_302();
      this.__g_38();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-126"
   )
   @Export("__g_38")
   void __g_38() {
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lho;II)V",
      garbageValue = "1115233428"
   )
   static final void method345(Widget var0, int var1) {
      if(var0.__cf == null) {
         throw new RuntimeException();
      } else {
         if(var0.__fh == null) {
            var0.__fh = new int[var0.__cf.length];
         }

         var0.__fh[var1] = Integer.MAX_VALUE;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "23"
   )
   @Export("runWidgetOnLoadListener")
   static void runWidgetOnLoadListener(int var0) {
      if(var0 != -1 && GroundItemPile.loadWidgetGroup(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3.onLoad != null) {
               ScriptEvent var4 = new ScriptEvent();
               var4.widget = var3;
               var4.args0 = var3.onLoad;
               GrandExchangeEvent.runScript0(var4, 5000000);
            }
         }
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "(Lho;IIZB)V",
      garbageValue = "-35"
   )
   @Export("alignWidgetSize")
   static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.widthAlignment == 0) {
         var0.width = var0.rawWidth;
      } else if(var0.widthAlignment == 1) {
         var0.width = var1 - var0.rawWidth;
      } else if(var0.widthAlignment == 2) {
         var0.width = var0.rawWidth * var1 >> 14;
      }

      if(var0.heightAlignment == 0) {
         var0.height = var0.rawHeight;
      } else if(var0.heightAlignment == 1) {
         var0.height = var2 - var0.rawHeight;
      } else if(var0.heightAlignment == 2) {
         var0.height = var2 * var0.rawHeight >> 14;
      }

      if(var0.widthAlignment == 4) {
         var0.width = var0.height * var0.__aw / var0.__al;
      }

      if(var0.heightAlignment == 4) {
         var0.height = var0.width * var0.__al / var0.__aw;
      }

      if(var0.contentType == 1337) {
         Client.viewportWidget = var0;
      }

      if(var3 && var0.__ee != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.args0 = var0.__ee;
         Client.scriptEvents.addFirst(var6);
      }

   }
}
