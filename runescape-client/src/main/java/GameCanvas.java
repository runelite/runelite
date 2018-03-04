import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("GameCanvas")
public final class GameCanvas extends Canvas {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1021484827
   )
   public static int field655;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 604024075
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("d")
   @Export("component")
   Component component;

   GameCanvas(Component var1) {
      this.component = var1;
   }

   public final void paint(Graphics var1) {
      this.component.paint(var1);
   }

   public final void update(Graphics var1) {
      this.component.update(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lbi;I)V",
      garbageValue = "971052557"
   )
   public static void method800(ScriptEvent var0) {
      BoundingBox.runScript(var0, 500000);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2129976793"
   )
   static String method796(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "-607935376"
   )
   public static void method798(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method798(var0, var1, var2, var5 - 1);
         method798(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "1690859759"
   )
   static int method797(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class20.field338:class81.field1267;
      if(var0 == 1500) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class81.intStack[++class81.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class81.intStack[++class81.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class81.intStack[++class81.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class81.intStack[++class81.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class81.intStack[++class81.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1644330243"
   )
   public static void method799() {
      PlayerComposition.field2796.reset();
   }
}
