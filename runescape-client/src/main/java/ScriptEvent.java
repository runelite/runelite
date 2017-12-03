import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("a")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("w")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2041116237
   )
   int field771;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 334266043
   )
   int field772;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1797326927
   )
   int field773;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   Widget field776;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 137937717
   )
   int field768;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1936247983
   )
   int field775;
   @ObfuscatedName("j")
   @Export("string")
   String string;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1408604377
   )
   int field778;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   class230 field779;

   public ScriptEvent() {
      this.field779 = class230.field2898;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "13"
   )
   public void method1050(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lhi;I)V",
      garbageValue = "-1217881542"
   )
   public void method1051(class230 var1) {
      this.field779 = var1;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-3922817"
   )
   static final void method1055(int var0, int var1, int var2, boolean var3) {
      if(GraphicsObject.loadWidget(var0)) {
         class239.method4227(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }
}
