import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "Lfr;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("g")
   @Export("objs")
   Object[] objs;
   @ObfuscatedName("e")
   @Export("boolean1")
   boolean boolean1;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   @Export("source")
   Widget source;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -672052205
   )
   @Export("mouseX")
   int mouseX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 901295407
   )
   @Export("mouseY")
   int mouseY;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 300414353
   )
   int field779;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Liz;"
   )
   Widget field776;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1845549705
   )
   @Export("pressedKey")
   int pressedKey;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1973273457
   )
   @Export("typedKey")
   int typedKey;
   @ObfuscatedName("h")
   @Export("string")
   String string;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 255897807
   )
   int field784;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   class245 field781;

   public ScriptEvent() {
      this.field781 = class245.field2968;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "621328388"
   )
   public void method1155(Object[] var1) {
      this.objs = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Liv;B)V",
      garbageValue = "17"
   )
   public void method1154(class245 var1) {
      this.field781 = var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;I)V",
      garbageValue = "-106537709"
   )
   public static void method1159(IndexDataBase var0) {
      class278.field3549 = var0;
   }
}
