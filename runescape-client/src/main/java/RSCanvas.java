import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   static IndexedSprite field617;
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("b")
   @Export("component")
   Component component;

   RSCanvas(Component var1) {
      this.component = var1;
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILij;IIIZI)V",
      garbageValue = "-2009119517"
   )
   public static void method744(int var0, IndexDataBase var1, int var2, int var3, int var4, boolean var5) {
      class210.field2585 = 1;
      class70.field802 = var1;
      class210.field2586 = var2;
      class31.field414 = var3;
      class230.field2909 = var4;
      class230.field2905 = var5;
      FrameMap.field1952 = var0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   protected static final void method734() {
      GameEngine.timer.vmethod2996();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field639[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field651[var0] = 0L;
      }

      FileSystem.field3259 = 0;
   }
}
