import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("u")
   class219 field834;
   @ObfuscatedName("a")
   Object[] field839;
   @ObfuscatedName("n")
   @Export("widget")
   Widget widget;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 973517235
   )
   int field831;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 355724025
   )
   int field828;
   @ObfuscatedName("l")
   Widget field833;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -641212179
   )
   int field835;
   @ObfuscatedName("p")
   String field837;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 486439127
   )
   int field832;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -47912817
   )
   int field838;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1665050601
   )
   int field836;
   @ObfuscatedName("j")
   boolean field829;

   public ScriptEvent() {
      this.field834 = class219.field2792;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "36"
   )
   public void method1092(Object[] var1) {
      this.field839 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass219;B)V",
      garbageValue = "45"
   )
   public void method1098(class219 var1) {
      this.field834 = var1;
   }
}
