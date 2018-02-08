import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1494362839
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -924497153
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1956085931
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1819518455
   )
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1911940063
   )
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1481520401
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 871293961
   )
   @Export("config")
   int config;

   WallObject() {
      this.hash = 0;
      this.config = 0;
   }

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "1981166062"
   )
   static final void method3112(int var0, int var1, int var2, boolean var3) {
      if(ServerPacket.loadWidget(var0)) {
         class65.method1057(ScriptState.widgets[var0], -1, var1, var2, var3);
      }
   }
}
