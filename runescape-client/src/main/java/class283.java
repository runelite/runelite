import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
public abstract class class283 implements Comparator {
   @ObfuscatedName("oc")
   @ObfuscatedSignature(
      signature = "Llc;"
   )
   @Export("minimapSprite")
   static SpritePixels minimapSprite;
   @ObfuscatedName("m")
   Comparator field3632;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;B)V",
      garbageValue = "1"
   )
   final void method5319(Comparator var1) {
      if(this.field3632 == null) {
         this.field3632 = var1;
      } else if(this.field3632 instanceof class283) {
         ((class283)this.field3632).method5319(var1);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljn;Ljn;B)I",
      garbageValue = "-20"
   )
   protected final int method5320(Nameable var1, Nameable var2) {
      return this.field3632 == null?0:this.field3632.compare(var1, var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
