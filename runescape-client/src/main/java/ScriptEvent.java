import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
@Implements("ScriptEvent")
public class ScriptEvent extends Node {
   @ObfuscatedName("m")
   Object[] field791;
   @ObfuscatedName("p")
   boolean field786;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("widget")
   Widget widget;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 325545761
   )
   int field787;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1856000799
   )
   int field788;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1107386175
   )
   int field789;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   Widget field790;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1338939927
   )
   int field795;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1691400047
   )
   int field792;
   @ObfuscatedName("n")
   String field793;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -901606729
   )
   int field784;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   class226 field796;

   public ScriptEvent() {
      this.field796 = class226.field2873;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/Object;I)V",
      garbageValue = "-1071472192"
   )
   public void method1159(Object[] var1) {
      this.field791 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lhy;I)V",
      garbageValue = "1583662852"
   )
   public void method1160(class226 var1) {
      this.field796 = var1;
   }
}
