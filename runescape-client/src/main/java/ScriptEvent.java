import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhh;"
   )
   class219 field855;
   @ObfuscatedName("d")
   Object[] field846;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 517585251
   )
   int field847;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 729061239
   )
   int field848;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   Widget field850;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2069109993
   )
   int field854;
   @ObfuscatedName("t")
   String field852;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 500791687
   )
   int field849;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 527701039
   )
   int field851;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1397479225
   )
   int field844;
   @ObfuscatedName("k")
   boolean field845;

   public ScriptEvent() {
      this.field855 = class219.field2801;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "865613023"
   )
   public void method1145(Object[] var1) {
      this.field846 = var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lhh;I)V",
      garbageValue = "-100642145"
   )
   public void method1143(class219 var1) {
      this.field855 = var1;
   }
}
