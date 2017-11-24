import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bx")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("o")
   static int[] field811;
   @ObfuscatedName("ft")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("headIconsPrayer")
   static SpritePixels[] headIconsPrayer;
   @ObfuscatedName("d")
   Object[] field797;
   @ObfuscatedName("x")
   boolean field798;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -151029351
   )
   int field800;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1447502281
   )
   int field801;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 184963121
   )
   int field806;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhx;"
   )
   Widget field803;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1600863895
   )
   int field802;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 250918847
   )
   int field810;
   @ObfuscatedName("r")
   String field805;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 89196773
   )
   int field807;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   class226 field808;

   public ScriptEvent() {
      this.field808 = class226.field2873;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;B)V",
      garbageValue = "56"
   )
   public void method1122(Object[] var1) {
      this.field797 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lho;B)V",
      garbageValue = "-5"
   )
   public void method1117(class226 var1) {
      this.field808 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static void method1124() {
      for(class81 var0 = (class81)class81.field1248.getFront(); var0 != null; var0 = (class81)class81.field1248.getNext()) {
         if(var0.field1254 != null) {
            var0.method1646();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1803962370"
   )
   public static final boolean method1123() {
      KeyFocusListener var0 = KeyFocusListener.keyboard;
      synchronized(KeyFocusListener.keyboard) {
         if(KeyFocusListener.field600 == KeyFocusListener.field616) {
            return false;
         } else {
            class35.field473 = KeyFocusListener.field611[KeyFocusListener.field600];
            class20.field320 = KeyFocusListener.field610[KeyFocusListener.field600];
            KeyFocusListener.field600 = KeyFocusListener.field600 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-16"
   )
   static final void method1121(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         ItemLayer.menuAction(var1, var2, var3, var4, var5, var6, MouseInput.field709, MouseInput.field710);
      }
   }
}
