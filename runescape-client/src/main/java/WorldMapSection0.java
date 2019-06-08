import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
   @ObfuscatedName("sn")
   @ObfuscatedGetter(
      intValue = -1946112139
   )
   @Export("__y_sn")
   static int __y_sn;
   @ObfuscatedName("p")
   @Export("__y_p")
   static int[] __y_p;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2011838881
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1299225715
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 82600709
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -477370575
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -671345527
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 529427495
   )
   @Export("__u")
   int __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -150870205
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1009718107
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1022177315
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1397517463
   )
   @Export("__x")
   int __x;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -799353317
   )
   @Export("__d")
   int __d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1388959491
   )
   @Export("__k")
   int __k;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1657956317
   )
   @Export("surfaceOffsetY")
   int __n;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1345061881
   )
   @Export("__i")
   int __i;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   public void expandBounds(WorldMapArea var1) {
      if(var1.minX0 > this.__o) {
         var1.minX0 = this.__o;
      }

      if(var1.maxX0 < this.__o) {
         var1.maxX0 = this.__o;
      }

      if(var1.minY0 > this.__u) {
         var1.minY0 = this.__u;
      }

      if(var1.maxY0 < this.__u) {
         var1.maxY0 = this.__u;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.__m && var1 < this.__m + this.__f?var2 >= (this.__q << 6) + (this.__g << 3) && var2 <= (this.__q << 6) + (this.__e << 3) + 7 && var3 >= (this.__w << 6) + (this.__l << 3) && var3 <= (this.__w << 6) + (this.__x << 3) + 7:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.__o << 6) + (this.__d << 3) && var1 <= (this.__o << 6) + (this.__n << 3) + 7 && var2 >= (this.__u << 6) + (this.__k << 3) && var2 <= (this.__u << 6) + (this.__i << 3) + 7;
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
         int[] var4 = new int[]{this.__o * 64 - this.__q * 64 + var2 + (this.__d * 8 - this.__g * 8), var3 + (this.__u * 64 - this.__w * 64) + (this.__k * 8 - this.__l * 8)};
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
         int var3 = this.__q * 64 - this.__o * 64 + (this.__g * 8 - this.__d * 8) + var1;
         int var4 = this.__w * 64 - this.__u * 64 + var2 + (this.__l * 8 - this.__k * 8);
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
      this.__g = var1.readUnsignedByte();
      this.__e = var1.readUnsignedByte();
      this.__w = var1.__ag_302();
      this.__l = var1.readUnsignedByte();
      this.__x = var1.readUnsignedByte();
      this.__o = var1.__ag_302();
      this.__d = var1.readUnsignedByte();
      this.__n = var1.readUnsignedByte();
      this.__u = var1.__ag_302();
      this.__k = var1.readUnsignedByte();
      this.__i = var1.readUnsignedByte();
      this.__g_25();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1967186894"
   )
   @Export("__g_25")
   void __g_25() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102591569"
   )
   static void method247() {
      AccessFile var0 = null;

      try {
         var0 = LoginPacket.getPreferencesFile("", class22.studioGame.name, true);
         Buffer var1 = ReflectionCheck.clientPreferences.toBuffer();
         var0.write(var1.array, 0, var1.index);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1886145284"
   )
   static final void method245(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuArguments1[var0];
         int var2 = Client.menuArguments2[var0];
         int var3 = Client.menuOpcodes[var0];
         int var4 = Client.menuArguments0[var0];
         String var5 = Client.menuActions[var0];
         String var6 = Client.menuTargetNames[var0];
         Actor.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
      }
   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lho;IIIIIII)V",
      garbageValue = "-1723792771"
   )
   static final void method246(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(Client.__client_hh) {
         Client.__client_hd = 32;
      } else {
         Client.__client_hd = 0;
      }

      Client.__client_hh = false;
      int var7;
      if(MouseHandler.MouseHandler_currentButton == 1 || !AbstractRasterProvider.__lp_ca && MouseHandler.MouseHandler_currentButton == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class22.method295(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class22.method295(var0);
         } else if(var5 >= var1 - Client.__client_hd && var5 < Client.__client_hd + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class22.method295(var0);
            Client.__client_hh = true;
         }
      }

      if(Client.mouseWheelRotation != 0) {
         var7 = var0.width;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.mouseWheelRotation * 45;
            class22.method295(var0);
         }
      }

   }
}
